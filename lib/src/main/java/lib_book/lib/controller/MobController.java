package lib_book.lib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import lib_book.lib.Services.MobService;
import lib_book.lib.models.Mob;

@Controller
public class MobController {
    
    @Autowired
    private MobService mobService;

    @GetMapping("/mobs")
    public String index(ModelMap m, @RequestAttribute(value = "", required = false) String name){
        if (name == null) {
            name = "";
        }
        List<Mob> list = mobService.findByName(name.trim());
        m.addAttribute("list", list);

        return "index/mob/mob_list";
    }

}
