package burp;

import java.net.URL;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IScanIssue.class */
public interface IScanIssue {
    URL getUrl();

    String getIssueName();

    int getIssueType();

    String getSeverity();

    String getConfidence();

    String getIssueBackground();

    String getRemediationBackground();

    String getIssueDetail();

    String getRemediationDetail();

    IHttpRequestResponse[] getHttpMessages();

    IHttpService getHttpService();
}
