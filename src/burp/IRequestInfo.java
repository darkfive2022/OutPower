package burp;

import java.net.URL;
import java.util.List;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IRequestInfo.class */
public interface IRequestInfo {
    public static final byte CONTENT_TYPE_NONE = 0;
    public static final byte CONTENT_TYPE_URL_ENCODED = 1;
    public static final byte CONTENT_TYPE_MULTIPART = 2;
    public static final byte CONTENT_TYPE_XML = 3;
    public static final byte CONTENT_TYPE_JSON = 4;
    public static final byte CONTENT_TYPE_AMF = 5;
    public static final byte CONTENT_TYPE_UNKNOWN = -1;

    String getMethod();

    URL getUrl();

    List<String> getHeaders();

    List<IParameter> getParameters();

    int getBodyOffset();

    byte getContentType();
}
