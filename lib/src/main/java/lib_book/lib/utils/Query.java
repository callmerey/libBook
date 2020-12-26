package lib_book.lib.utils;

public class Query {
    private String name;
    private Integer typeId;
    private String order;
    private String type;
    private Integer cash;

    public String generateResponseQuery(String str) {
        boolean isFirst = true;

        if (!this.name.equals("")) {
            str = solveResponseVariable(str, "name", this.name, isFirst);
            isFirst = false;
        }

        if (this.typeId != 0) {
            str = solveResponseVariable(str, "typeId", this.typeId + "", isFirst);
            isFirst = false;
        }

        if (this.cash != 0) {
            str = solveResponseVariable(str, "cash", this.cash + "", isFirst);
            isFirst = false;
        }

        if (this.type != "") {
            str = solveResponseVariable(str, "type", this.type + "", isFirst);
            isFirst = false;
        }

        if (this.order != "") {
            str = solveResponseVariable(str, "order", this.order + "", isFirst);
            isFirst = false;
        }

        return str;
    }

    public String solveResponseVariable(String str, String varName, String var, boolean isFirst) {
        if (isFirst) {
            str += "?";
        } else {
            str += "&";
        }
        str = str + varName + "=" + var;
        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Query(String name, Integer typeId, String order, String type, Integer cash) {
        this.name = name;
        this.typeId = typeId;
        this.order = order;
        this.type = type;
        this.cash = cash;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

}
