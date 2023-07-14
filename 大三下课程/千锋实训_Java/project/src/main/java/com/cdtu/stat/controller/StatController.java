package com.cdtu.stat.controller;

import com.cdtu.bus.domain.Customer;
import com.cdtu.bus.domain.Rent;
import com.cdtu.bus.service.ICustomerService;
import com.cdtu.bus.service.IRentService;
import com.cdtu.sys.utils.ExportRentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RequestMapping("stat")
@Controller
public class StatController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IRentService rentService;

    /**
     * 导出出租单
     */
    @RequestMapping("exportRent")
    public ResponseEntity<Object> exportRent(String rentid){
        System.out.println("进入");
        //跟出租单id查询出租单
        Rent rent = rentService.queryRentByRentId(rentid);
        //根据客户的身份证号码查询客户信息
        Customer customer = customerService.queryCustomerByIdentity(rent.getIdentity());
        String fileName = customer.getCustname() + "-的出租单.xls";
        String sheetName = customer.getCustname()+"出租单";
        //通过工具类进行导出操作
        ByteArrayOutputStream bos = ExportRentUtils.exportRent(rent,customer,sheetName);

        try {
            //处理文件名称乱码
            fileName = URLEncoder.encode(fileName,"UTF-8");
            //由于要进行下载,所有要设置头信息
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //设置下载文件的名称
            headers.setContentDispositionFormData("attachment",fileName);
            //将数据组装返回
            return new ResponseEntity<Object>(bos.toByteArray(),headers, HttpStatus.CREATED);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
