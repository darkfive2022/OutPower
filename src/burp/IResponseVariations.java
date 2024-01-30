package burp;

import java.util.List;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IResponseVariations.class */
public interface IResponseVariations {
    List<String> getVariantAttributes();

    List<String> getInvariantAttributes();

    int getAttributeValue(String str, int i);

    void updateWith(byte[]... bArr);
}
