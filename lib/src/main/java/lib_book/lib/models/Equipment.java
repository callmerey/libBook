package lib_book.lib.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equipments")
public class Equipment implements Serializable {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=true)
    private EquipmentCategory equipmentCategory;

    @Column
    private Integer attSpd;
    
    @Column
    private Integer incAcc;

    @Column
    private Integer incEva;

    @Column
    private Integer incJump;

    @Column
    private Integer incSpeed;

    @Column
    private Integer incStr;

    @Column
    private Integer incDex;

    @Column
    private Integer incInt;

    @Column
    private Integer incLuk;

    @Column
    private Integer incHp;

    @Column
    private Integer incMp;

    @Column
    private Integer tuc;

    @Column
    private Integer incPad;

    @Column
    private Integer incPdd;

    @Column
    private Integer incMad;

    @Column
    private Integer incMdd;

    @Column
    private Integer reqLevel;

    @Column
    private Integer reqStr;

    @Column
    private Integer reqDex;

    @Column
    private Integer reqInt;

    @Column
    private Integer reqLuk;

    @Column
    private String name;

    @Column
    private String avatar;

    @Column
    private Integer cash;

    @Column(columnDefinition = "bit default 0")
    private boolean isW;

    @Column(columnDefinition = "bit default 0")
    private boolean isM;

    @Column(columnDefinition = "bit default 0")
    private boolean isB;

    @Column(columnDefinition = "bit default 0")
    private boolean isT;

    @Column(columnDefinition = "bit default 0")
    private boolean isP;

    @Column(columnDefinition = "bit default 0")
    private boolean isBgn;
    
    public Equipment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIncAcc() {
        return incAcc;
    }

    public void setIncAcc(Integer incAcc) {
        this.incAcc = incAcc;
    }

    public Integer getIncEva() {
        return incEva;
    }

    public void setIncEva(Integer incEva) {
        this.incEva = incEva;
    }

    public Integer getIncJump() {
        return incJump;
    }

    public void setIncJump(Integer incJump) {
        this.incJump = incJump;
    }

    public Integer getIncSpeed() {
        return incSpeed;
    }

    public void setIncSpeed(Integer incSpeed) {
        this.incSpeed = incSpeed;
    }

    public Integer getIncStr() {
        return incStr;
    }

    public void setIncStr(Integer incStr) {
        this.incStr = incStr;
    }

    public Integer getIncDex() {
        return incDex;
    }

    public void setIncDex(Integer incDex) {
        this.incDex = incDex;
    }

    public Integer getIncInt() {
        return incInt;
    }

    public void setIncInt(Integer incInt) {
        this.incInt = incInt;
    }

    public Integer getIncLuk() {
        return incLuk;
    }

    public void setIncLuk(Integer incLuk) {
        this.incLuk = incLuk;
    }

    public Integer getIncHp() {
        return incHp;
    }

    public void setIncHp(Integer incHp) {
        this.incHp = incHp;
    }

    public Integer getIncMp() {
        return incMp;
    }

    public void setIncMp(Integer incMp) {
        this.incMp = incMp;
    }

    public Integer getTuc() {
        return tuc;
    }

    public void setTuc(Integer tuc) {
        this.tuc = tuc;
    }

    public Integer getIncPad() {
        return incPad;
    }

    public void setIncPad(Integer incPad) {
        this.incPad = incPad;
    }

    public Integer getIncPdd() {
        return incPdd;
    }

    public void setIncPdd(Integer incPdd) {
        this.incPdd = incPdd;
    }

    public Integer getIncMad() {
        return incMad;
    }

    public void setIncMad(Integer incMad) {
        this.incMad = incMad;
    }

    public Integer getIncMdd() {
        return incMdd;
    }

    public void setIncMdd(Integer incMdd) {
        this.incMdd = incMdd;
    }

    public Integer getReqLevel() {
        return reqLevel;
    }

    public void setReqLevel(Integer reqLevel) {
        this.reqLevel = reqLevel;
    }

    public Integer getReqStr() {
        return reqStr;
    }

    public void setReqStr(Integer reqStr) {
        this.reqStr = reqStr;
    }

    public Integer getReqDex() {
        return reqDex;
    }

    public void setReqDex(Integer reqDex) {
        this.reqDex = reqDex;
    }

    public Integer getReqInt() {
        return reqInt;
    }

    public void setReqInt(Integer reqInt) {
        this.reqInt = reqInt;
    }

    public Integer getReqLuk() {
        return reqLuk;
    }

    public void setReqLuk(Integer reqLuk) {
        this.reqLuk = reqLuk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Integer getAttSpd() {
		return attSpd;
	}

	public void setAttSpd(Integer attSpd) {
		this.attSpd = attSpd;
	}

    public EquipmentCategory getEquipmentCategory() {
        return equipmentCategory;
    }

    public void setEquipmentCategory(EquipmentCategory equipmentCategory) {
        this.equipmentCategory = equipmentCategory;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public boolean getIsW() {
        return isW;
    }

    public void setIsW(boolean isW) {
        this.isW = isW;
    }

    public boolean getIsM() {
        return isM;
    }

    public void setIsM(boolean isM) {
        this.isM = isM;
    }

    public boolean getIsB() {
        return isB;
    }

    public void setIsB(boolean isB) {
        this.isB = isB;
    }

    public boolean getIsT() {
        return isT;
    }

    public void setIsT(boolean isT) {
        this.isT = isT;
    }

    public boolean getIsP() {
        return isP;
    }

    public void setIsP(boolean isP) {
        this.isP = isP;
    }

    public boolean getIsBgn() {
        return isBgn;
    }

    public void setIsBgn(boolean isBgn) {
        this.isBgn = isBgn;
    }

}
