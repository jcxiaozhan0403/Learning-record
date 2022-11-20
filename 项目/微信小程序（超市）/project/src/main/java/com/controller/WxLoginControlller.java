package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dto.UserInfoDTO;
import com.entity.User;
import com.mapper.UserMapper;
import com.service.UserService;
import com.utils.AesCbcUtil;
import com.utils.Result;
import com.utils.WxHttpUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: [微信小程序登录获取用户信息接口, 解密数据获取用户信息包括UnionID(需要微信开放平台认证开发者账户绑定的小程序)]
 * @Author: pjqdyd
 * @Version: [v1.0.0]
*/

@RestController
@RequestMapping("/wx")
public class WxLoginControlller {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    public static final String APPID = "wx7b7cfe6d555a79fe"; //申请小程序的AppId
    public static final String APP_SECRET = "c3f3e90ffa57febc74de21f5383bc5b5"; //生成的AppSecret

    //请求微信后端的地址
    public static final String AUTH_URL = "https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={js_code}&grant_type={grant_type}";

    /**
     * 登录接口
     * @param code 前端wx.login获取的code
     * @param iv 前端wx.getUserInfo获取的加密偏移值
     * @param encryptedData 前端wx.getUserInfo加密的用户数据
     * @return
     */
    @PostMapping("/login")
    public Result wxLogin(@RequestParam("code") String code,
                          @RequestParam("iv") String iv,
                          @RequestParam("encryptedData") String encryptedData) throws Exception{

        if (StringUtils.isBlank(code) || StringUtils.isBlank(iv) || StringUtils.isBlank(encryptedData)){
            return Result.FAIL("失败-参数不能为空");
        }

        //装载请求参数的Map集合,通过code,appid,app_secret获取用户的OpenId和session_key
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("appid", APPID);
        paramsMap.put("secret", APP_SECRET);
        paramsMap.put("js_code", code);
        paramsMap.put("grant_type", "authorization_code");

        //获取用户的OpenId和session_key
        Map<String, String> resultMap = new WxHttpUtil().getWxOpenIdAndSkey(AUTH_URL, paramsMap);
        System.out.println(resultMap);

        String openId = resultMap.get("openid");
        String session_key = resultMap.get("session_key");

        //查询是否为新用户
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("openId");
        wrapper.eq("openId",openId);
        User user = userMapper.selectOne(wrapper);


        if (user == null){
            //用户为空，执行注册
            JSONObject jsonUserInfo = AesCbcUtil.decrypt(encryptedData, session_key, iv);
            System.out.println(jsonUserInfo);
            UserInfoDTO userInfoDTO = new UserInfoDTO();
            userInfoDTO.from(jsonUserInfo);

            if (jsonUserInfo != null){
                String nickName = jsonUserInfo.getString("nickName");

                //注册，存入数据库
                User newUser = new User();
                newUser.setNickName(nickName);
                newUser.setOpenId(openId);
                userMapper.insert(newUser);
                return Result.SUCCESS(userInfoDTO);
            }
            return Result.FAIL("未找到用户信息");
        }else {
            //用户不为空,执行登录
            //解密用户数据
            JSONObject jsonUserInfo = AesCbcUtil.decrypt(encryptedData, session_key, iv);
            UserInfoDTO userInfoDTO = new UserInfoDTO();
            userInfoDTO.from(jsonUserInfo);

            if (jsonUserInfo != null){
                System.out.println(jsonUserInfo.toString());
                return Result.SUCCESS(userInfoDTO);
            }
        }

//        //表示用户认证登录信息正确
//        if(!StringUtils.isBlank(openId) || !StringUtils.isBlank(session_key)){
//            //解密用户数据
//            JSONObject jsonUserInfo = AesCbcUtil.decrypt(encryptedData, session_key, iv);
//
//            if (jsonUserInfo != null){
//                System.out.println(jsonUserInfo.toString());
//                System.out.println(jsonUserInfo.getString("openId"));
//                name = jsonUserInfo.getString("nickName");
//                return "Success";
//            }
//        }
        return Result.FAIL("Error");
    }

//    @GetMapping("/getNumber")
//    public String getNumber(@RequestParam("code") String code) {
//        try{
//            Object phoneNumberData = getPhoneNumber(code);
//            //手机号
//            String phoneNum = phoneNumberData.toString().substring(16,27);
//
////            //第一次登录，存入数据库
////            User user = new User();
////            user.setName(this.name);
////            user.setPhone(phoneNum);
////            userController.addUser(user);
//
//            return "Success";
//        }catch (Exception e){
//            e.printStackTrace();
//            return "False";
//        }
//    }
//
//    public static Object getPhoneNumber(String code) {
//
//        String result = null;
//        try {
//            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={0}&secret={1}";
//            String replaceUrl = url.replace("{0}", APPID).replace("{1}", APP_SECRET);
//            String res = HttpUtil.get(replaceUrl);
//            JSONObject json_token = JSON.parseObject(res);
//            String access_token = json_token.getString("access_token");
//
//            String urlTwo = "https://api.weixin.qq.com/wxa/business/getuserphonenumber?access_token={0}";
//            String replaceUrlTwo = urlTwo.replace("{0}",access_token);
//            HashMap<String, Object> requestParam = new HashMap<>();
//            // 手机号调用凭证
//            requestParam.put("code", code);
//            String jsonStr = JSON.toJSONString(requestParam);
//            HttpResponse response = HttpRequest.post(replaceUrlTwo)
//                    .header(Header.CONTENT_ENCODING, "UTF-8")
//                    // 发送json数据需要设置contentType
//                    .header(Header.CONTENT_TYPE, "application/x-www-form-urlencoded")
//                    .body(jsonStr)
//                    .execute();
//            if (response.getStatus() == HttpStatus.HTTP_OK) {
//                result = response.body();
//            }
//        } catch (HttpException e) {
//            e.printStackTrace();
//        }
//        return JSONObject.parseObject(result).get("phone_info");
//    }

}
