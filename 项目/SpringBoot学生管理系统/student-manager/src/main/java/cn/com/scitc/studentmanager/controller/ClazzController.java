package cn.com.scitc.studentmanager.controller;

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

//    @RequestMapping(value = "add", method = RequestMethod.POST)
//    ServerResponse addClazz(@RequestBody Clazz clazz){
//        return clazzService.addClazz(clazz);
//    }
//
//
//    @RequestMapping(value = "update", method = RequestMethod.POST)
//    ServerResponse updateClazz(@RequestBody Clazz clazz){
//        return clazzService.updateClazz(clazz);
//    }
//
//    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
//    ServerResponse deleteClazz(@PathVariable("id")Long id){
//        return clazzService.deleteClazz(id);
//    }

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

//    @RequestMapping(value = "clazzs", method = RequestMethod.GET)
//    ServerResponse getAllCalzz(@RequestParam("grade") String grade){return clazzService.getAllClazz(grade);}

}
