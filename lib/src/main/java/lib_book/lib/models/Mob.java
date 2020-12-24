package lib_book.lib.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mobs")
public class Mob implements Serializable{
    @Id
    private int id;

    @Column
    private int level;
    
    @Column
    private int exp;

    @Column
    private int maxHp; 
    
    @Column
    private int maxMp;
    
    @Column
    private int pad;

    @Column
    private int pdd;
    
    @Column
    private int mad; 

    @Column
    private int mdd;
    
    @Column
    private int acc;
    
    @Column
    private int eva;
    
    @Column
    private int speed;
    
    @Column
    private int hpRecover;

    @Column
    private int mpRecover;

    @Column
    private String name;

    @Column
    private String avatar;

    @Column
    private String avatarType;

    public Mob() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public int getPad() {
        return pad;
    }

    public void setPad(int pad) {
        this.pad = pad;
    }

    public int getPdd() {
        return pdd;
    }

    public void setPdd(int pdd) {
        this.pdd = pdd;
    }

    public int getMad() {
        return mad;
    }

    public void setMad(int mad) {
        this.mad = mad;
    }

    public int getMdd() {
        return mdd;
    }

    public void setMdd(int mdd) {
        this.mdd = mdd;
    }

    public int getAcc() {
        return acc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
    }

    public int getEva() {
        return eva;
    }

    public void setEva(int eva) {
        this.eva = eva;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHpRecover() {
        return hpRecover;
    }

    public void setHpRecover(int hpRecover) {
        this.hpRecover = hpRecover;
    }

    public int getMpRecover() {
        return mpRecover;
    }

    public void setMpRecover(int mpRecover) {
        this.mpRecover = mpRecover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

	public String getAvatarType() {
		return avatarType;
	}

	public void setAvatarType(String avatarType) {
		this.avatarType = avatarType;
	}

}
