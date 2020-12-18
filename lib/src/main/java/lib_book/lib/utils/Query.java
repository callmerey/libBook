package lib_book.lib.utils;

public class Query {
    private String name;
    private Integer typeID;

    public Query(String name, Integer typeID) {
        this.name = name;
        this.typeID = typeID;
    }

    public boolean isEmptyQuery() {
        if (!this.name.equals("") || this.typeID != 0) {
            return false;
        }
        return true;
    }

    public String generateResponseQuery(String str) {
        boolean isFirst = true;

        if (!this.name.equals("")) {
            str = solveResponseVariable(str, "name", this.name, isFirst);
            isFirst = false;
        }

        if (this.typeID != 0) {
            str = solveResponseVariable(str, "typeId", this.typeID + "", isFirst);
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
        str = str + "?" + varName + "=" + var;
        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    

}
