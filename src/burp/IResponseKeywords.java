package burp;

import java.util.List;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IResponseKeywords.class */
public interface IResponseKeywords {
    List<String> getVariantKeywords();

    List<String> getInvariantKeywords();

    int getKeywordCount(String str, int i);

    void updateWith(byte[]... bArr);
}
