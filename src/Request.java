public class Request {

    private String url;
    private String method;
    private String[] headers;
    private String bodyMethod;
    private String[] body;
    private String fileAddress;

    public Request(){

        method = "GET"; // default method
        headers = null;
        body = null;
        bodyMethod = null;
        fileAddress = null;

    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setBody(String[] body) {
        this.body = body;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    public void setBodyMethod(String bodyMethod) {
        this.bodyMethod = bodyMethod;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public String[] getBody() {
        return body;
    }

    public String[] getHeaders() {
        return headers;
    }

    public String getBodyMethod() {
        return bodyMethod;
    }

    public String getFileAddress() {
        return fileAddress;
    }
}