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
import lib_book.lib.models.Equipment;
import lib_book.lib.models.Item;
import lib_book.lib.models.Mob;
import lib_book.lib.responses.DropResponse;
import lib_book.lib.responses.ListResponse;
import lib_book.lib.responses.ObjectReponse;
import lib_book.lib.services.DropDataService;
import lib_book.lib.services.EquipmentService;
import lib_book.lib.services.ItemService;
import lib_book.lib.services.MobService;
import lib_book.lib.utils.Query;

@Controller
public class MobController {

    @Autowired
    private MobService mobService;

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private ItemService itemService;

    @Autowired
    DropDataService dropDataService;

    @GetMapping("/mobs")
    public String indexMob(ModelMap m, @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "0") Integer inputPage) {

        List<Mob> l;
        ListResponse<Mob> res = new ListResponse<>();

        if (inputPage > 0) {
            page = inputPage - 1;
        }

        // Set paging string
        String pagingStr = "/mobs";
        Query query = new Query(name, 0);
        res.setQuery(query);
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

        m.addAttribute("res", res);

        return "mobs/list";
    }

    // Detail
    @GetMapping("mobs/{id}")
    public String mobsDetail(@PathVariable(name = "id") Integer id, ModelMap m) {

        Mob mob = new Mob();
        List<DropData> l;
        DropResponse dropDatas = new DropResponse();
        ObjectReponse<Mob> res = new ObjectReponse<>();

        // Find by id
        try {
            mob = mobService.findById(id);
            l = dropDataService.findByDropperId(mob.getId());
            List<Item> consumeList = new ArrayList<>();
            List<Item> etcList = new ArrayList<>();
            List<Item> setupList = new ArrayList<>();
            List<Equipment> equipmentList = new ArrayList<>();
            for (DropData d : l) {
                if (d.getItemId() >= 1000000 && d.getItemId() < 2000000) {
                    try {
                        Equipment e = equipmentService.findById(d.getItemId());
                        equipmentList.add(e);
                    } catch (Exception e) {
                        continue;
                    }
                } else {
                    try {
                        Item i = itemService.findById(d.getItemId());
                        if (d.getItemId() >= 2000000 && d.getItemId() < 3000000) {
                            consumeList.add(i);
                        }
                        if (d.getItemId() >= 3000000 && d.getItemId() < 4000000) {
                            setupList.add(i);
                        }
                        if (d.getItemId() >= 2000000 && d.getItemId() < 3000000) {
                            etcList.add(i);
                        }
                        
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
            dropDatas.setConsumeList(consumeList);
            dropDatas.setEtcList(etcList);
            dropDatas.setSetupList(setupList);
            dropDatas.setEquipmentList(equipmentList);
        } catch (Exception ex) {
            // return fail
            res.setErrorCode("404");
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        // end function try catch

        // Set response
        res.setObject(mob);
        res.setDropDatas(dropDatas);
        System.out.println(dropDatas);

        // Send response
        m.addAttribute("res", res);
        return "mobs/detail";
    }
    // end funcition detail
}
