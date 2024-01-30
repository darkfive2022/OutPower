package burp;

import java.util.List;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IBurpCollaboratorClientContext.class */
public interface IBurpCollaboratorClientContext {
    String generatePayload(boolean z);

    List<IBurpCollaboratorInteraction> fetchAllCollaboratorInteractions();

    List<IBurpCollaboratorInteraction> fetchCollaboratorInteractionsFor(String str);

    List<IBurpCollaboratorInteraction> fetchAllInfiltratorInteractions();

    List<IBurpCollaboratorInteraction> fetchInfiltratorInteractionsFor(String str);

    String getCollaboratorServerLocation();
}
