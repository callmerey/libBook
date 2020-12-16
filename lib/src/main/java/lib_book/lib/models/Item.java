package lib_book.lib.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item implements Serializable{

    @Id
    private int id;

    @Column
    private String name;
    
    @Column(name = "description")
    private String desc;
    //
    @Column(name = "category_id")
    private int typeId;

    public Item() {
    }

    public Item(int id, String name, String desc, int typeId) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.typeId = typeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Item [desc=" + desc + ", id=" + id + ", name=" + name + ", typeId=" + typeId + "]";
    }

    
}
