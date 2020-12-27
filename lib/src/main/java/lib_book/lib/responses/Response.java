package lib_book.lib.responses;

import lib_book.lib.utils.Query;

public class Response {
    private String title, message, errorCode;
    private Query query;
    private String accessingPage;

    public Response() {
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public String getAccessingPage() {
        return accessingPage;
    }

    public void setAccessingPage(String accessingPage) {
        this.accessingPage = accessingPage;
    }

}
