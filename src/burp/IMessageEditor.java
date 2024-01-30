package burp;

import java.awt.Component;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IMessageEditor.class */
public interface IMessageEditor {
    Component getComponent();

    void setMessage(byte[] bArr, boolean z);

    byte[] getMessage();

    boolean isMessageModified();

    byte[] getSelectedData();

    int[] getSelectionBounds();
}
