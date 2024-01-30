package burp;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IMessageEditorController.class */
public interface IMessageEditorController {
    IHttpService getHttpService();

    byte[] getRequest();

    byte[] getResponse();
}
