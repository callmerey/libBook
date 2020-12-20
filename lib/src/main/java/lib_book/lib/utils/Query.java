package lib_book.lib.utils;

public class Query {
    private String name;
    private Integer typeId;

    public Query(String name, Integer typeId) {
        this.name = name;
        this.typeId = typeId;
    }

    public boolean isEmptyQuery() {
        if (!this.name.equals("") || this.typeId != 0) {
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

        if (this.typeId != 0) {
            str = solveResponseVariable(str, "typeId", this.typeId + "", isFirst);
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

    

}
