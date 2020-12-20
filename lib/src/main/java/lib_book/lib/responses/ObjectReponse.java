package lib_book.lib.responses;

import java.util.List;

public class ObjectReponse<E> extends Response {
    
    private E object;
    private boolean isEdit;
    private DropResponse dropDatas;

    public E getObject() {
        return object;
    }

    public void setObject(E object) {
        this.object = object;
    }

    public boolean isEdit() {
        return isEdit;
    }

    public void setEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public ObjectReponse() {
    }

    public DropResponse getDropDatas() {
        return dropDatas;
    }

    public void setDropDatas(DropResponse dropDatas) {
        this.dropDatas = dropDatas;
    }



}
