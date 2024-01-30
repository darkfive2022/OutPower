package burp;

import java.util.Date;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/ICookie.class */
public interface ICookie {
    String getDomain();

    String getPath();

    Date getExpiration();

    String getName();

    String getValue();
}
