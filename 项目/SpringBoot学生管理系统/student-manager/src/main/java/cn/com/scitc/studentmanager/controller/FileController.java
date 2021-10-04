package cn.com.scitc.studentmanager.controller;

import cn.com.scitc.studentmanager.common.ResultCode;
import cn.com.scitc.studentmanager.common.ResultData;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ Author     ：John.Cena
 * @ Date       ：Created in 16:05 2020/3/21
 * @ Description：文件上传
 * @ Modified By：
 * @Version: 1.0
 */

@RestController
@RequestMapping(name = "avatar")
public class FileController {
    @RequestMapping(name = "upload", method = RequestMethod.POST)
    public ResultData uploadAvatar(@RequestParam("file")MultipartFile file){
        try{
            if(file.isEmpty()){
                return ResultData.ok(ResultCode.ERROR,"文件参数为空");
            }else{
                String fileName = file.getOriginalFilename();
                System.out.println(fileName);
                return ResultData.ok(ResultCode.SUCCESS,"上传成功");
            }
        }catch (Exception e){
            return ResultData.ok(ResultCode.ERROR,"上传失败");
        }
    }
}
