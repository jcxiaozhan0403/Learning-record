package com.cdtu.bus.controller;

import com.cdtu.bus.domain.Car;
import com.cdtu.bus.service.ICarService;
import com.cdtu.sys.utils.AppFileUtils;
import com.cdtu.sys.utils.DataGridView;
import com.cdtu.sys.utils.ResultObj;
import com.cdtu.sys.utils.SysConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cdtu.bus.domain.CarVo;

import java.util.Date;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */
@Controller
@RequestMapping("car")
public class CarController {

    @Autowired
    private ICarService carService;

    /**
     * 页面跳转到 business/car/carManager
     */
    @RequestMapping("toCarManager")
    public String toCarManager(){
        return "business/car/carManager";
    }

    /**
     * 车辆的分页查询
     * param 参数:  CarVo
     * return: DataGridView  数据表格展示,layui中用
     */
    @RequestMapping("loadAllCar")
    @ResponseBody
    public DataGridView loadAllCar(CarVo carVo){
        return carService.loadAllCar(carVo);
    }

    /**
     * 添加车辆
     */
    @RequestMapping("addCar")
    @ResponseBody
    public ResultObj addCar(CarVo carVo){
        try {
            //1.设置时间
            carVo.setCreatetime(new Date());
            //2判断是否为默认图片，如果不是默认图片去掉后缀 _temp
            if(!carVo.getCarimg().equals(SysConstant.DEFAULT_CAR_IMG)){
                //去掉后缀
                String fileName = AppFileUtils.updateFileName(carVo.getCarimg(), SysConstant.FILE_UPLOAD_TEMP);  // 20230629/202312313.jpg
                //新名称重新设置给carVo
                carVo.setCarimg(fileName);
            }

            //3.调用service 添加
            carService.addCar(carVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 删除车辆
     */
    @RequestMapping("deleteCar")
    public ResultObj deleteCar(String carnumber){
        try {
            carService.deleteCar(carnumber);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 修改车辆
     * @param carVo
     * @return
     */
    @RequestMapping("updateCar")
    public ResultObj updateCar(CarVo carVo){
        try{
            String carimg = carVo.getCarimg();
            if (carimg.endsWith(SysConstant.FILE_UPLOAD_TEMP)) {
                String filePath =AppFileUtils.updateFileName(carVo.getCarimg(), SysConstant.FILE_UPLOAD_TEMP);
                carVo.setCarimg(filePath);
                //把原来的删除
                Car car = this.carService.queryCarByCarNumber(carVo.getCarnumber());
                AppFileUtils.removeFileByPath(car.getCarimg());

            }
            this.carService.updateCar(carVo);
            return ResultObj.UPDADTE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 批量删除车辆
     * @param carVo
     * @return
     */
    @RequestMapping("deleteBatchCar")
    public ResultObj deleteBatchCar(CarVo carVo){
        try{
            this.carService.deleteBatchCar(carVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
