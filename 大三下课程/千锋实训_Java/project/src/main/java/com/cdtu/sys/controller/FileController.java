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

@Controller
@RequestMapping("file")
public class FileController {

    /**
     * 查看缩略图
     */
    @RequestMapping("downloadShowFile")
    public ResponseEntity<Object> downloadShowFile(String path , HttpServletResponse response){
        return AppFileUtils.downloadFile(response,path,"");
    }

    /**
     * 上传图片
     */
    @RequestMapping("uploadFile")
    @ResponseBody
    public DataGridView uploadFile(MultipartFile mf) throws IOException {
        //文件上传的父目录
        String parentPath = AppFileUtils.PATH;
        //得到当前的文件夹作为存放图片的目录
        String dirName = RandomUtils.getCurrentDateForString();
        //构建文件夹对象
        File dirFile = new File(parentPath,dirName);
        if(!dirFile.exists()){
            dirFile.mkdirs(); //如果我们想要的日期目录不存在, 就创建一个
        }
        //得到源文件名称
        String oldName = mf.getOriginalFilename();
        //根据源文件名称获取到一个新文件名称
        String newName = RandomUtils.createFileNameUseTime(oldName, SysConstant.FILE_UPLOAD_TEMP);
        File dest = new File(dirFile,newName);
        //上传操作
        mf.transferTo(dest);

        //构建一个DataGridView对象返回
        Map<String,Object> map = new HashMap<>();
        map.put("src",dirName+"/"+newName);
        return new DataGridView(map);
    }
}
