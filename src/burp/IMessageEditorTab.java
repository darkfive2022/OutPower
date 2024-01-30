package burp;

import java.awt.Component;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IMessageEditorTab.class */
public interface IMessageEditorTab {
    String getTabCaption();

    Component getUiComponent();

    boolean isEnabled(byte[] bArr, boolean z);

    void setMessage(byte[] bArr, boolean z);

    byte[] getMessage();

    boolean isModified();

    byte[] getSelectedData();
}
