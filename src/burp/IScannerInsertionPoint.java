package burp;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IScannerInsertionPoint.class */
public interface IScannerInsertionPoint {
    public static final byte INS_PARAM_URL = 0;
    public static final byte INS_PARAM_BODY = 1;
    public static final byte INS_PARAM_COOKIE = 2;
    public static final byte INS_PARAM_XML = 3;
    public static final byte INS_PARAM_XML_ATTR = 4;
    public static final byte INS_PARAM_MULTIPART_ATTR = 5;
    public static final byte INS_PARAM_JSON = 6;
    public static final byte INS_PARAM_AMF = 7;
    public static final byte INS_HEADER = 32;
    public static final byte INS_URL_PATH_FOLDER = 33;
    @Deprecated
    public static final byte INS_URL_PATH_REST = 33;
    public static final byte INS_PARAM_NAME_URL = 34;
    public static final byte INS_PARAM_NAME_BODY = 35;
    public static final byte INS_ENTIRE_BODY = 36;
    public static final byte INS_URL_PATH_FILENAME = 37;
    public static final byte INS_USER_PROVIDED = 64;
    public static final byte INS_EXTENSION_PROVIDED = 65;
    public static final byte INS_UNKNOWN = Byte.MAX_VALUE;

    String getInsertionPointName();

    String getBaseValue();

    byte[] buildRequest(byte[] bArr);

    int[] getPayloadOffsets(byte[] bArr);

    byte getInsertionPointType();
}
