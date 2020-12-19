package lib_book.lib.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    @RequestMapping("/index")
    public String index(){
        return "index/index";
    }

    @RequestMapping("/list")
    public String list(){
        return "index/list";
    }

    @RequestMapping("/weapon")
    public String weapon(){
        return "index/weapon";
    }

    @RequestMapping("/detail")
    public String detail(){
        return "layouts/detail";
    }

    @RequestMapping("/monster")
    public String monster(){
        return "index/monster";
    }

    @RequestMapping("/npc")
    public String npc(){
        return "index/npc";
    }

    @RequestMapping("/map")
    public String map(){
        return "index/map";
    }

    @RequestMapping("/use")
    public String use(){
        return "index/use";
    }

    @RequestMapping("/skill")
    public String skill(){
        return "index/skill";
    }

    @RequestMapping("/quest")
    public String quest(){
        return "index/quest";
    }

    @RequestMapping("/exp")
    public String exp(){
        return "index/exptable";
    }

    @RequestMapping("/selweapon")
    public String selweapon(){
        return "index/equipments/select_weapon";
    }
}
