package burp;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IIntruderPayloadGeneratorFactory.class */
public interface IIntruderPayloadGeneratorFactory {
    String getGeneratorName();

    IIntruderPayloadGenerator createNewInstance(IIntruderAttack iIntruderAttack);
}
