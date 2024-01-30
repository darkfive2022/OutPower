package burp;

import java.net.URL;
import java.util.List;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IExtensionHelpers.class */
public interface IExtensionHelpers {
    IRequestInfo analyzeRequest(IHttpRequestResponse iHttpRequestResponse);

    IRequestInfo analyzeRequest(IHttpService iHttpService, byte[] bArr);

    IRequestInfo analyzeRequest(byte[] bArr);

    IResponseInfo analyzeResponse(byte[] bArr);

    IParameter getRequestParameter(byte[] bArr, String str);

    String urlDecode(String str);

    String urlEncode(String str);

    byte[] urlDecode(byte[] bArr);

    byte[] urlEncode(byte[] bArr);

    byte[] base64Decode(String str);

    byte[] base64Decode(byte[] bArr);

    String base64Encode(String str);

    String base64Encode(byte[] bArr);

    byte[] stringToBytes(String str);

    String bytesToString(byte[] bArr);

    int indexOf(byte[] bArr, byte[] bArr2, boolean z, int i, int i2);

    byte[] buildHttpMessage(List<String> list, byte[] bArr);

    byte[] buildHttpRequest(URL url);

    byte[] addParameter(byte[] bArr, IParameter iParameter);

    byte[] removeParameter(byte[] bArr, IParameter iParameter);

    byte[] updateParameter(byte[] bArr, IParameter iParameter);

    byte[] toggleRequestMethod(byte[] bArr);

    IHttpService buildHttpService(String str, int i, String str2);

    IHttpService buildHttpService(String str, int i, boolean z);

    IParameter buildParameter(String str, String str2, byte b);

    IScannerInsertionPoint makeScannerInsertionPoint(String str, byte[] bArr, int i, int i2);

    IResponseVariations analyzeResponseVariations(byte[]... bArr);

    IResponseKeywords analyzeResponseKeywords(List<String> list, byte[]... bArr);
}
