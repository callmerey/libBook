package lib_book.lib.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lib_book.lib.models.Equipment;
import lib_book.lib.models.Item;
import lib_book.lib.models.Mob;
import lib_book.lib.responses.GlobalRecord;
import lib_book.lib.responses.ListResponse;
import lib_book.lib.services.EquipmentService;
import lib_book.lib.services.ItemService;
import lib_book.lib.services.MobService;
import lib_book.lib.utils.Query;

@Controller
public class AppController {

    @Autowired
    EquipmentService equipmentService;

    @Autowired
    MobService mobService;

    @Autowired
    ItemService itemService;
    
    @GetMapping("")
    public String blank() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index/index";
    }

    @GetMapping("/all")
    public String globalSearch(ModelMap mm, @RequestParam(required = false, defaultValue = "") String name, @RequestParam(required = false, defaultValue = "0") Integer page) {

        ListResponse<GlobalRecord> res = new ListResponse<>();

        List<GlobalRecord> l = new ArrayList<>();

        List<Equipment> eList = equipmentService.findByNameLike(1, 49, name);

        List<Item> iList = itemService.findByNameLike(name);

        List<Mob> mList = mobService.findByNameLike(name);

        for (Equipment e : eList) {
            GlobalRecord g = new GlobalRecord();
            g.setId(e.getId());
            g.setName(e.getName());
            g.setType(e.getEquipmentCategory().getName());
            g.setCategory("equipment");
            l.add(g);
        }

        for (Item i : iList) {
            GlobalRecord g = new GlobalRecord();
            g.setId(i.getId());
            g.setName(i.getName());
            g.setType(i.getItemCategory().getName());
            g.setCategory("item");
            l.add(g);
        }

        for (Mob m : mList) {
            GlobalRecord g = new GlobalRecord();
            g.setId(m.getId());
            g.setName(m.getName());
            g.setType("Mob");
            g.setCategory("mob");
            l.add(g);
        }

        String pagingStr = "/accessories";
        Query query = new Query(name, 0);
        res.setQuery(query);
        pagingStr = query.generateResponseQuery(pagingStr);

        try {
            res.generateResponse(l, 0, page, pagingStr);
        } catch (Exception ex) {
            if (!res.getIsEmpty()) {
                // Return error on fail
                res.setErrorCode("404");
                res.setMessage(ex.getMessage());
                mm.addAttribute("res", res);
                return "module/error";
            }
            ex.printStackTrace();
        }
        
        mm.addAttribute("res", res);
        
        return "global";
    }
}
