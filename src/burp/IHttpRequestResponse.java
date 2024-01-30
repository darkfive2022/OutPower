package burp;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IHttpRequestResponse.class */
public interface IHttpRequestResponse {
    byte[] getRequest();

    void setRequest(byte[] bArr);

    byte[] getResponse();

    void setResponse(byte[] bArr);

    String getComment();

    void setComment(String str);

    String getHighlight();

    void setHighlight(String str);

    IHttpService getHttpService();

    void setHttpService(IHttpService iHttpService);
}
