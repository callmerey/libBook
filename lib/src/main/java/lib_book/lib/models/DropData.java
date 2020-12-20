package lib_book.lib.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "drop_data")
public class DropData implements Serializable{

    @Id
    private int id;

    @Column(name="dropperid")
    private Integer dropperId;
    
    @Column(name="itemid")
    private Integer itemId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getDropperId() {
        return dropperId;
    }

    public void setDropperId(Integer dropperId) {
        this.dropperId = dropperId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public DropData() {
    }

    
}
