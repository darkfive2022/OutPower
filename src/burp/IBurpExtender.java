package burp;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IBurpExtender.class */
public interface IBurpExtender {
    void registerExtenderCallbacks(IBurpExtenderCallbacks iBurpExtenderCallbacks);

    void processHttpMessage(int i, boolean z, IHttpRequestResponse iHttpRequestResponse);

    byte[] getResponse();

    IHttpService getHttpService();

    void processHttpMessage(boolean messageIsRequest, IInterceptedProxyMessage message);
}
