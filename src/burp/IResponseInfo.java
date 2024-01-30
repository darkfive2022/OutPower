package burp;

import java.util.List;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IResponseInfo.class */
public interface IResponseInfo {
    List<String> getHeaders();

    int getBodyOffset();

    short getStatusCode();

    List<ICookie> getCookies();

    String getStatedMimeType();

    String getInferredMimeType();
}
