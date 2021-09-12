package cn.com.scitc.studentmanager.controller;

import cn.com.scitc.studentmanager.common.ResultCode;
import cn.com.scitc.studentmanager.common.ResultData;
import cn.com.scitc.studentmanager.pojo.Clazz;
import cn.com.scitc.studentmanager.service.impl.ClazzServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "clazz")
public class ClazzController {
    @Autowired
    Clazz clazz;

    @Autowired
    ClazzServiceImpl clazzServiceImpl;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultData listClazz(){
        List<Clazz> list = clazzServiceImpl.listClazz();
        return ResultData.ok().data("data",list);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultData addClazz(@RequestBody Clazz clazz){
        clazzServiceImpl.addClazz(clazz);
        return ResultData.ok(ResultCode.SUCCESS,"添加成功");
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultData updateClazz(@RequestBody Clazz clazz){
        clazzServiceImpl.updateClazz(clazz);
        return ResultData.ok(ResultCode.SUCCESS,"更新成功");
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public ResultData deleteClazz(@PathVariable Integer id){
        clazzServiceImpl.deleteClazz(id);
        return ResultData.ok(ResultCode.SUCCESS,"删除成功");
    }

    @RequestMapping(value = "grades", method = RequestMethod.GET)
    public ResultData getAllGrade(){
        List<String> list = clazzServiceImpl.getAllGrade();
        return ResultData.ok().data("data",list);
    }

    @RequestMapping(value = "clazzs", method = RequestMethod.GET)
    public ResultData getAllCalzz(@RequestParam("grade") String grade){
        List<String> list = clazzServiceImpl.getAllCalzz(grade);
        return ResultData.ok().data("data",list);
    }

}
