package burp;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IHttpListener.class */
public interface IHttpListener {
    void processHttpMessage(int i, boolean z, IHttpRequestResponse iHttpRequestResponse);

    byte[] getRequest();
}
