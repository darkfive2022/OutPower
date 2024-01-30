package burp;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IIntruderPayloadProcessor.class */
public interface IIntruderPayloadProcessor {
    String getProcessorName();

    byte[] processPayload(byte[] bArr, byte[] bArr2, byte[] bArr3);
}
