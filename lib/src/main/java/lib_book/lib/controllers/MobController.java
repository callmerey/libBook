package lib_book.lib.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lib_book.lib.models.Mob;
import lib_book.lib.responses.ListResponse;
import lib_book.lib.services.MobService;
import lib_book.lib.utils.Query;

@Controller
public class MobController {

    @Autowired
    private MobService mobService;

    @GetMapping("/mobs")
    public String index(ModelMap m, @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "0") Integer page) {
        
        List<Mob> l;
        ListResponse<Mob> res = new ListResponse<>();

        // Set paging string
        String pagingStr = "/mobs";
        Query query = new Query(name, 0);
        pagingStr = query.generateResponseQuery(pagingStr);

        // Set response
        
        try {
            l = mobService.findByNameLike(name.trim());
            res.generateResponse(l, 0, page, pagingStr);
        } catch (Exception ex) {
            if (!res.getIsEmpty()) {
                // Return error on fail
                res.setErrorCode("404");
                res.setMessage(ex.getMessage());
                m.addAttribute("res", res);
                return "module/error";
            }
        }

        return "index/mob/mob_list";
    }

}
