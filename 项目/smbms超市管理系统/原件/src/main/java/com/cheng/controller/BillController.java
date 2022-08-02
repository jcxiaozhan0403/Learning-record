package com.cheng.controller;

import com.cheng.pojo.Bill;
import com.cheng.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("bill")
public class BillController {

    @Autowired
    BillService billService;

    @RequestMapping("bill")
    public String bill(Model model){
        List<Bill> bills = billService.getBillList();
        model.addAttribute("billList",bills);
        return "jsp/billlist";
    }
}
