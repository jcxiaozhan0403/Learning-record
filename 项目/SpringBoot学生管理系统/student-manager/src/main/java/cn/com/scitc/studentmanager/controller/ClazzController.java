package cn.com.scitc.studentmanager.controller;

import cn.com.scitc.studentmanager.common.ResultCode;
import cn.com.scitc.studentmanager.common.ResultData;
import cn.com.scitc.studentmanager.pojo.Clazz;
import cn.com.scitc.studentmanager.service.impl.ClazzServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author John.Cena
 * @date 2021/10/15 11:35
 * @Description: 班级控制器
 */
@CrossOrigin
@RestController
@RequestMapping(value = "clazz")
public class ClazzController {
    @Autowired
    Clazz clazz;

    @Autowired
    ClazzServiceImpl clazzServiceImpl;

    /**
     *
     * @return
     * 班级列表
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultData listClazz(){
        List<Clazz> list = clazzServiceImpl.listClazz();
        return ResultData.ok().data("data",list);
    }

    /**
     *
     * @param clazz
     * @return
     * 添加班级
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultData addClazz(@RequestBody Clazz clazz){
        clazzServiceImpl.addClazz(clazz);
        return ResultData.ok(ResultCode.SUCCESS,"添加成功");
    }

    /**
     *
     * @param clazz
     * @return
     * 更新班级
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultData updateClazz(@RequestBody Clazz clazz){
        clazzServiceImpl.updateClazz(clazz);
        return ResultData.ok(ResultCode.SUCCESS,"更新成功");
    }

    /**
     *
     * @param id
     * @return
     * 删除班级
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public ResultData deleteClazz(@PathVariable Integer id){
        clazzServiceImpl.deleteClazz(id);
        return ResultData.ok(ResultCode.SUCCESS,"删除成功");
    }

    /**
     *
     * @return
     * 年级列表
     */
    @RequestMapping(value = "grades", method = RequestMethod.GET)
    public ResultData getAllGrade(){
        List<String> list = clazzServiceImpl.getAllGrade();
        return ResultData.ok().data("data",list);
    }

    /**
     *
     * @param grade
     * @return
     * 通过年级获取班级
     */
    @RequestMapping(value = "clazzs", method = RequestMethod.GET)
    public ResultData getAllCalzz(@RequestParam("grade") String grade){
        List<String> list = clazzServiceImpl.getAllCalzz(grade);
        return ResultData.ok().data("data",list);
    }

}
