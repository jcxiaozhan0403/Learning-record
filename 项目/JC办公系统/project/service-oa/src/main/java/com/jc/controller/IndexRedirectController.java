package com.jc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author John.Cena
 * @Description: 登录页重定向
 */
@Controller
public class IndexRedirectController {

    @GetMapping(value = {"/", "/index"})
    public RedirectView redirectToIndex() {
        return new RedirectView("/index.html");
    }
}
