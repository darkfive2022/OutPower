package burp;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IIntruderAttack.class */
public interface IIntruderAttack {
    IHttpService getHttpService();

    byte[] getRequestTemplate();
}
