package burp;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/ISessionHandlingAction.class */
public interface ISessionHandlingAction {
    String getActionName();

    void performAction(IHttpRequestResponse iHttpRequestResponse, IHttpRequestResponse[] iHttpRequestResponseArr);
}
