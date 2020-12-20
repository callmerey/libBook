package lib_book.lib.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import lib_book.lib.models.Equipment;
import lib_book.lib.models.EquipmentCategory;
import lib_book.lib.models.Mob;
import lib_book.lib.responses.ListResponse;
import lib_book.lib.responses.ObjectReponse;
import lib_book.lib.services.EquipmentCategoryService;
import lib_book.lib.services.EquipmentService;
import lib_book.lib.services.MobService;
import lib_book.lib.utils.Query;

@Controller
public class AppController {

    @Autowired
    private MobService mobService;

    @Autowired
    private EquipmentCategoryService equipmentCategoryService;

    @Autowired
    EquipmentService equipmentService;

    @GetMapping("")
    public String blank() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index/index";
    }

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

        return "index/mob/mob_list";
    }

    @GetMapping("/equipments")
    public String indexEquiment(ModelMap m, @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "0") Integer typeId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "0") Integer inputPage) {

        List<Equipment> l;
        ListResponse<Equipment> res = new ListResponse<>();

        if (inputPage > 0) {
            page = inputPage - 1;
        }

        // Set paging string
        String pagingStr = "/equipments";
        Query query = new Query(name, typeId);
        res.setQuery(query);
        pagingStr = query.generateResponseQuery(pagingStr);

        // Set response

        try {
            if (typeId > 0) {
                l = equipmentService.findByTypeAndNameLike(typeId, name.trim());
            } else {
                l = equipmentService.findByNameLike(name.trim());
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

        return "index/equipments/weapon";
    }

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
                l = equipmentService.findByTypeAndNameLike(typeId, name.trim());
            } else {
                l = equipmentService.findByWeapon(18, 33);
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

        return "index/equipments/select_weapon";
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
                l = equipmentService.findByTypeAndNameLike(typeId, name.trim());
            } else {
                l = equipmentService.findByWeapon(1, 7);
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

        return "index/equipments/select_clothes";
    }

    @ModelAttribute(name = "clothesCategories")
    public List<EquipmentCategory> getSkinCategories() {
        return equipmentCategoryService.findByEquipmentCategorie(1, 7);
    }

    @GetMapping("/jewelry")
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
        String pagingStr = "/jewelry";
        Query query = new Query(name, typeId);
        res.setQuery(query);
        pagingStr = query.generateResponseQuery(pagingStr);

        // Set response

        try {
            if (typeId > 0) {
                l = equipmentService.findByTypeAndNameLike(typeId, name.trim());
            } else {
                l = equipmentService.findByWeapon(8, 14);
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

        return "index/equipments/select_jewelry";
    }

    @ModelAttribute(name = "jewelryCategories")
    public List<EquipmentCategory> getJewelryCategories() {
        return equipmentCategoryService.findByEquipmentCategorie(8, 14);
    }

    // Detail
    @GetMapping("/{id}")
    public String detail(@PathVariable(name = "id") Integer id, ModelMap m) {

        Equipment e = new Equipment();
        ObjectReponse<Equipment> res = new ObjectReponse<>();

        // Find by id
        try {
            e = equipmentService.findById(id);
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

        // Send response
        m.addAttribute("res", res);
        return "layouts/equiment_detail";
    }
    // end funcition detail

    // Detail
    @GetMapping("mobs/{id}")
    public String mobsDetail(@PathVariable(name = "id") Integer id, ModelMap m) {

        Mob mob = new Mob();
        ObjectReponse<Mob> res = new ObjectReponse<>();

        // Find by id
        try {
            mob = mobService.findById(id);
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

        // Send response
        m.addAttribute("res", res);
        return "layouts/mob_detail";
    }
    // end funcition detail
}
