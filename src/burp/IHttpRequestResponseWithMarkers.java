package burp;

import java.util.List;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IHttpRequestResponseWithMarkers.class */
public interface IHttpRequestResponseWithMarkers extends IHttpRequestResponse {
    List<int[]> getRequestMarkers();

    List<int[]> getResponseMarkers();
}
