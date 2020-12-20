package lib_book.lib.responses;

import java.util.List;

import lib_book.lib.models.Equipment;
import lib_book.lib.models.Item;
import lib_book.lib.models.Mob;

public class DropResponse {
    private List<Mob> mobList;
    private List<Equipment> equipmentList;
    private List<Item> consumeList;
    private List<Item> etcList;
    private List<Item> setupList;

    public DropResponse() {

    }

    public List<Mob> getMobList() {
        return mobList;
    }

    public void setMobList(List<Mob> mobList) {
        this.mobList = mobList;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public List<Item> getConsumeList() {
        return consumeList;
    }

    public void setConsumeList(List<Item> consumeList) {
        this.consumeList = consumeList;
    }

    public List<Item> getEtcList() {
        return etcList;
    }

    public void setEtcList(List<Item> etcList) {
        this.etcList = etcList;
    }

    public List<Item> getSetupList() {
        return setupList;
    }

    public void setSetupList(List<Item> setupList) {
        this.setupList = setupList;
    }

}
