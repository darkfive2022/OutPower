package burp;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IIntruderPayloadGenerator.class */
public interface IIntruderPayloadGenerator {
    boolean hasMorePayloads();

    byte[] getNextPayload(byte[] bArr);

    void reset();
}
