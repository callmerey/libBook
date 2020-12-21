package lib_book.lib.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import lib_book.lib.models.DropData;
import lib_book.lib.models.Equipment;
import lib_book.lib.models.EquipmentCategory;
import lib_book.lib.models.Mob;
import lib_book.lib.responses.DropResponse;
import lib_book.lib.responses.ListResponse;
import lib_book.lib.responses.ObjectReponse;
import lib_book.lib.services.DropDataService;
import lib_book.lib.services.EquipmentCategoryService;
import lib_book.lib.services.EquipmentService;
import lib_book.lib.services.MobService;
import lib_book.lib.utils.Query;

@Controller
public class EquipmentController {

    @Autowired
    private EquipmentCategoryService equipmentCategoryService;

    @Autowired
    EquipmentService equipmentService;

    @Autowired
    MobService mobService;

    @Autowired
    DropDataService dropDataService;

    @GetMapping("/weapons")
    public String indexWeapon(ModelMap m, @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "0") Integer typeId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "0") Integer inputPage) {

        List<Equipment> l;
        ListResponse<Equipment> res = new ListResponse<>();

        if (inputPage > 0) {
            page = inputPage - 1;
        }

        // Set paging string
        String pagingStr = "/weapons";
        Query query = new Query(name, typeId);
        res.setQuery(query);
        pagingStr = query.generateResponseQuery(pagingStr);

        // Set response
        try {
            if (typeId > 0) {
                l = equipmentService.findByTypeAndNameLike(18, 33, name.trim(), typeId);
            } else {
                l = equipmentService.findByNameLike(18, 33, name.trim());
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

        return "equipments/weapon";
    }

    @ModelAttribute(name = "weaponCategories")
    public List<EquipmentCategory> getWeaponCategories() {
        return equipmentCategoryService.findByEquipmentCategorie(17, 33);
    }

    @GetMapping("/clothes")
    public String indexSkin(ModelMap m, @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "0") Integer typeId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "0") Integer inputPage) {

        List<Equipment> l;
        ListResponse<Equipment> res = new ListResponse<>();

        if (inputPage > 0) {
            page = inputPage - 1;
        }

        // Set paging string clothes
        String pagingStr = "/clothes";
        Query query = new Query(name, typeId);
        res.setQuery(query);
        pagingStr = query.generateResponseQuery(pagingStr);

        // Set response

        try {
            if (typeId > 0) {
                l = equipmentService.findByTypeAndNameLike(1, 7, name.trim(), typeId);
            } else {
                l = equipmentService.findByNameLike(1, 7, name.trim());
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

        return "equipments/clothe";
    }

    @ModelAttribute(name = "clothesCategories")
    public List<EquipmentCategory> getSkinCategories() {
        return equipmentCategoryService.findByEquipmentCategorie(1, 7);
    }

    @GetMapping("/accessories")
    public String indexJewelry(ModelMap m, @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "0") Integer typeId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "0") Integer inputPage) {

        List<Equipment> l;
        ListResponse<Equipment> res = new ListResponse<>();

        if (inputPage > 0) {
            page = inputPage - 1;
        }

        // Set paging string clothes
        String pagingStr = "/accessories";
        Query query = new Query(name, typeId);
        res.setQuery(query);
        pagingStr = query.generateResponseQuery(pagingStr);

        // Set response

        try {
            if (typeId > 0) {
                l = equipmentService.findByTypeAndNameLike(8, 14, name.trim(), typeId);
            } else {
                l = equipmentService.findByNameLike(8, 14, name.trim());
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

        return "equipments/accessory";
    }

    @ModelAttribute(name = "jewelryCategories")
    public List<EquipmentCategory> getJewelryCategories() {
        return equipmentCategoryService.findByEquipmentCategorie(8, 14);
    }

    // Detail
    @GetMapping("/equipments/{id}")
    public String detail(@PathVariable(name = "id") Integer id, ModelMap m) {

        Equipment e = new Equipment();
        List<DropData> l;
        DropResponse dropDatas = new DropResponse();
        ObjectReponse<Equipment> res = new ObjectReponse<>();

        // Find by id
        try {
            e = equipmentService.findById(id);
            l = dropDataService.findByItemId(e.getId());
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
            res.setErrorCode("404");
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        // end function try catch

        // Set response
        res.setObject(e);
        res.setDropDatas(dropDatas);

        // Send response
        m.addAttribute("res", res);
        return "equipments/detail";
    }
    // end funcition detail
}
