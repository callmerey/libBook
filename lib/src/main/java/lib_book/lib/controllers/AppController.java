package lib_book.lib.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("")
    public String blank() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index/index";
    }

}
