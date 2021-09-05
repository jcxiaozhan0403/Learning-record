package controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello/{a}/{b}")
    public String hello(@PathVariable int a, @PathVariable int b) {
        int res = a + b;
        return String.valueOf(res);
    }
}
