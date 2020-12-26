package lib_book.lib.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lib_book.lib.models.Equipment;
import lib_book.lib.models.Item;
import lib_book.lib.models.Mob;
import lib_book.lib.services.EquipmentService;
import lib_book.lib.services.ItemService;
import lib_book.lib.services.MobService;

@Controller
@RequestMapping("/getimage")
public class ImageController {

    // private String imageDir = "C:/Users/THANH SON/Desktop/project_lib/Maple images v146";
    private String imageDir = "C:/Users/Simon/Desktop/Maple images v146";

    private String defaultImg = imageDir + "/default.png";

    @Autowired
    private ItemService itemService;

    @Autowired
    private MobService mobService;

    @Autowired
    private EquipmentService equipmentService;

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ByteArrayResource> downloadItemImage(@PathVariable Integer id) {
        String dir = imageDir + "/Item";
        try {
            Item i = itemService.findById(id);
            String p = defaultImg;
            String idStr = i.getAvatar() + "";
            while (idStr.length() < 8) {
                idStr = "0" + idStr;
            }
            String imgPath = dir + "/" + idStr + ".png";
            File img = new File(imgPath);
            if (img.exists()) {
                p = imgPath;
            }
            Path file = Paths.get(p);
            byte[] buffer = Files.readAllBytes(file);
            ByteArrayResource bar = new ByteArrayResource(buffer);
            return ResponseEntity.ok().contentLength(buffer.length).contentType(MediaType.parseMediaType("image/png"))
                    .body(bar);
        } catch (Exception e) {
            // return lỗi
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/mob/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ByteArrayResource> downloadMobImage(@PathVariable Integer id) {
        String dir = imageDir + "/Mob";
        try {
            Mob m = mobService.findById(id);
            String p = defaultImg;
            String avtStr = m.getAvatar() + "";
            while (avtStr.length() < 7) {
                avtStr = "0" + avtStr;
            }
            String imgPath = dir + "/" + avtStr + "." + m.getAvatarType() +".png";
            System.out.println(imgPath);
            File img = new File(imgPath);
            if (img.exists()) {
                p = imgPath;
            }
            Path file = Paths.get(p);
            byte[] buffer = Files.readAllBytes(file);
            ByteArrayResource bar = new ByteArrayResource(buffer);
            return ResponseEntity.ok().contentLength(buffer.length).contentType(MediaType.parseMediaType("image/png"))
                    .body(bar);
        } catch (Exception e) {
            // return lỗi
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/equipment/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ByteArrayResource> downloadEquipmentImage(@PathVariable Integer id) {
        String dir = imageDir + "/Equipment";
        try {
            Equipment e = equipmentService.findById(id);
            String p = defaultImg;
            String idStr = e.getAvatar() + "";
            while (idStr.length() < 8) {
                idStr = "0" + idStr;
            }
            String imgPath = dir + "/" + idStr + ".png";
            File img = new File(imgPath);
            if (img.exists()) {
                p = imgPath;
            }
            Path file = Paths.get(p);
            byte[] buffer = Files.readAllBytes(file);
            ByteArrayResource bar = new ByteArrayResource(buffer);
            return ResponseEntity.ok().contentLength(buffer.length).contentType(MediaType.parseMediaType("image/png"))
                    .body(bar);
        } catch (Exception e) {
            // return lỗi
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().build();
    }
    
}