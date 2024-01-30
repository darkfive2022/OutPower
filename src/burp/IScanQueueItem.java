package burp;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IScanQueueItem.class */
public interface IScanQueueItem {
    String getStatus();

    byte getPercentageComplete();

    int getNumRequests();

    int getNumErrors();

    int getNumInsertionPoints();

    void cancel();

    IScanIssue[] getIssues();
}
