package com.cdtu.sys.controller;

import com.cdtu.sys.utils.AppFileUtils;
import com.cdtu.sys.utils.DataGridView;
import com.cdtu.sys.utils.RandomUtils;
import com.cdtu.sys.utils.SysConstant;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */
@RequestMapping("file")
@Controller
public class FileController {

    /**
     * 图片下载  downloadShowFile
     * 参数： 参数 String path , Response
     * 返回值: ResponseEntity   是springmvc提供的用于下载的一个实体
     */
    @RequestMapping("downloadShowFile")
    public ResponseEntity<Object> downloadShowFile(String path, HttpServletResponse response){
        //使用工具类，调用下载方法
        ResponseEntity<Object> responseEntity = AppFileUtils.downloadFile(response, path, "");
        return responseEntity;
    }

    /**
     * 图片上传操作
     * 1.参数是什么  MultipartFile -- toTransfer(xxx);
     * 2.返回值问题 void   DataGridView (图片路径) , 把该对象传递到前台, 前台设置 图片的src路径 (图片回显)
     * 3.当该方法写完还需要配置springmvc中的MutipartFile组件
     */
    @RequestMapping("uploadFile")
    @ResponseBody
    public DataGridView uploadFile(MultipartFile mf){
        try {
            //1.获取父目录
            String parentPath = AppFileUtils.PATH;
            //2.获取一个以当天时间命名的子目录
            String childPath = RandomUtils.getCurrentDateForString();  //20230630
            //3.将父目录和子目录组合成一个file 对象
            File dayFile = new File(parentPath,childPath); //   D://upload/20230630

            //4.判断这个父子目录是否存在,如果不存在,就创建一个这样的多级目录
            if (!dayFile.exists()){
                dayFile.mkdirs();
            }

            //5.获取到用户上传文件的源文件名称
            String oldName = mf.getOriginalFilename();  // 0001.jpg

            //6.对源文件名称做更改   (0001.jpg---->234313123.jpg_temp)
            String newFileName = RandomUtils.createFileNameUseTime(oldName, SysConstant.FILE_UPLOAD_TEMP);

            //7.在将父子目录和源文件名称再组合 得到一个destFile
            File destFile = new File(dayFile,newFileName);  // D://upload/20230630/234313123.jpg_temp

            //8.调用MultipartFile 的transferTo方法完成文件上传操作
            mf.transferTo(destFile);

            //9.创建Map集合,用来保存 新的图片地址(相对图片路径,将来保存到数据库的)
            Map<String,Object> map = new HashMap<>();
            map.put("src",childPath+"/"+newFileName); //  20230630/234313123.jpg_temp

            //10.将map放到 DataGridView对象中,将DataGridView对象返回.
            return new DataGridView(map);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 下载图片
     * @param path
     * @param response
     * @return
     */
    @RequestMapping("downloadFile")
    public ResponseEntity<Object> downloadFile(String path, HttpServletResponse response) {
        String oldName="";
        return AppFileUtils.downloadFile(response, path, oldName);
    }
}
