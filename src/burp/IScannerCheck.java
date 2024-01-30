package burp;

import java.util.List;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IScannerCheck.class */
public interface IScannerCheck {
    List<IScanIssue> doPassiveScan(IHttpRequestResponse iHttpRequestResponse);

    List<IScanIssue> doActiveScan(IHttpRequestResponse iHttpRequestResponse, IScannerInsertionPoint iScannerInsertionPoint);

    int consolidateDuplicateIssues(IScanIssue iScanIssue, IScanIssue iScanIssue2);
}
