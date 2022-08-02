package com.cheng.controller;

import com.cheng.pojo.Pro;
import com.cheng.service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("pro")
public class ProContorller {
    @Autowired
    ProService proService;

    @RequestMapping("provider")
    public String getprovider(Model model){
        List<Pro> proList = proService.getPro();
        model.addAttribute("providerList",proList);
        return "jsp/providerlist";
    }
}
