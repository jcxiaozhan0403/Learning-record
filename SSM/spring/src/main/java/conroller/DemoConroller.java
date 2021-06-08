package conroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoConroller {

    @RequestMapping("/demo")
    public String demo(Model model) {
        model.addAttribute("name","李爽");
        model.addAttribute("sex","男");
        model.addAttribute("age",19);
        return "demo";
    }
}
