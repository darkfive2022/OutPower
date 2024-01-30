package burp;

import java.awt.Component;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/ITextEditor.class */
public interface ITextEditor {
    Component getComponent();

    void setEditable(boolean z);

    void setText(byte[] bArr);

    byte[] getText();

    boolean isTextModified();

    byte[] getSelectedText();

    int[] getSelectionBounds();

    void setSearchExpression(String str);
}
