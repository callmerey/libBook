package lib_book.lib.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import lib_book.lib.models.DropData;
import lib_book.lib.models.Item;
import lib_book.lib.models.Mob;
import lib_book.lib.responses.DropResponse;
import lib_book.lib.responses.ListResponse;
import lib_book.lib.responses.ObjectReponse;
import lib_book.lib.services.DropDataService;
import lib_book.lib.services.ItemService;
import lib_book.lib.services.MobService;
import lib_book.lib.utils.Query;

@Controller
public class ItemController {

    @Autowired
    MobService mobService;

    @Autowired
    private ItemService itemService;

    @Autowired
    DropDataService dropDataService;

    @GetMapping("/items")
    public String indexItem(ModelMap m, @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "0") Integer typeId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "0") Integer inputPage) {

        List<Item> l;
        ListResponse<Item> res = new ListResponse<>();

        if (inputPage > 0) {
            page = inputPage - 1;
        }

        // Set paging string
        String pagingStr = "/items";
        Query query = new Query(name, typeId, "", "", 0);
        res.setQuery(query);
        pagingStr = query.generateResponseQuery(pagingStr);

        // Set response

        try {
            if (typeId > 0) {
                l = itemService.findByTypeAndNameLike(typeId, name.trim());
            } else {
                l = itemService.findByNameLike(name.trim());
            }

            res.generateResponse(l, 0, page, pagingStr);
        } catch (Exception ex) {
            if (!res.getIsEmpty()) {
                // Return error on fail
                res.setErrorCode("404");
                res.setMessage(ex.getMessage());
                m.addAttribute("res", res);
                return "module/error";
            }
            ex.printStackTrace();
        }

        m.addAttribute("res", res);

        return "items/list";
    }

    // Detail
    @GetMapping("items/{id}")
    public String itemsDetail(@PathVariable(name = "id") Integer id, ModelMap m) {

        Item i = new Item();
        List<DropData> l;
        DropResponse dropDatas = new DropResponse();
        ObjectReponse<Item> res = new ObjectReponse<>();

        // Find by id
        try {
            i = itemService.findById(id);
            l = dropDataService.findByItemId(i.getId());
            List<Mob> mobList = new ArrayList<>();
            for (DropData d : l) {
                try {
                    Mob mob = mobService.findById(d.getDropperId());
                    mobList.add(mob);
                } catch (Exception exx) {
                    continue;
                }
            }
            dropDatas.setMobList(mobList);
        } catch (Exception ex) {
            // return fail
            ex.printStackTrace();
            res.setErrorCode("404");
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        // end function try catch

        // Set response
        res.setObject(i);
        res.setDropDatas(dropDatas);

        // Send response
        m.addAttribute("res", res);
        return "items/detail";
    }
    // end funcition detail
}
