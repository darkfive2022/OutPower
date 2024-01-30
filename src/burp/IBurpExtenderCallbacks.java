package burp;

import java.awt.Component;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* loaded from: xia_yue.-1.2.jdk8.jar:burp/IBurpExtenderCallbacks.class */
public interface IBurpExtenderCallbacks {
    public static final int TOOL_SUITE = 1;
    public static final int TOOL_TARGET = 2;
    public static final int TOOL_PROXY = 4;
    public static final int TOOL_SPIDER = 8;
    public static final int TOOL_SCANNER = 16;
    public static final int TOOL_INTRUDER = 32;
    public static final int TOOL_REPEATER = 64;
    public static final int TOOL_SEQUENCER = 128;
    public static final int TOOL_DECODER = 256;
    public static final int TOOL_COMPARER = 512;
    public static final int TOOL_EXTENDER = 1024;

    void setExtensionName(String str);

    IExtensionHelpers getHelpers();

    OutputStream getStdout();

    OutputStream getStderr();

    void printOutput(String str);

    void printError(String str);

    void registerExtensionStateListener(IExtensionStateListener iExtensionStateListener);

    List<IExtensionStateListener> getExtensionStateListeners();

    void removeExtensionStateListener(IExtensionStateListener iExtensionStateListener);

    void registerHttpListener(IHttpListener iHttpListener);

    List<IHttpListener> getHttpListeners();

    void removeHttpListener(IHttpListener iHttpListener);

    void registerProxyListener(IProxyListener iProxyListener);

    List<IProxyListener> getProxyListeners();

    void removeProxyListener(IProxyListener iProxyListener);

    void registerScannerListener(IScannerListener iScannerListener);

    List<IScannerListener> getScannerListeners();

    void removeScannerListener(IScannerListener iScannerListener);

    void registerScopeChangeListener(IScopeChangeListener iScopeChangeListener);

    List<IScopeChangeListener> getScopeChangeListeners();

    void removeScopeChangeListener(IScopeChangeListener iScopeChangeListener);

    void registerContextMenuFactory(IContextMenuFactory iContextMenuFactory);

    List<IContextMenuFactory> getContextMenuFactories();

    void removeContextMenuFactory(IContextMenuFactory iContextMenuFactory);

    void registerMessageEditorTabFactory(IMessageEditorTabFactory iMessageEditorTabFactory);

    List<IMessageEditorTabFactory> getMessageEditorTabFactories();

    void removeMessageEditorTabFactory(IMessageEditorTabFactory iMessageEditorTabFactory);

    void registerScannerInsertionPointProvider(IScannerInsertionPointProvider iScannerInsertionPointProvider);

    List<IScannerInsertionPointProvider> getScannerInsertionPointProviders();

    void removeScannerInsertionPointProvider(IScannerInsertionPointProvider iScannerInsertionPointProvider);

    void registerScannerCheck(IScannerCheck iScannerCheck);

    List<IScannerCheck> getScannerChecks();

    void removeScannerCheck(IScannerCheck iScannerCheck);

    void registerIntruderPayloadGeneratorFactory(IIntruderPayloadGeneratorFactory iIntruderPayloadGeneratorFactory);

    List<IIntruderPayloadGeneratorFactory> getIntruderPayloadGeneratorFactories();

    void removeIntruderPayloadGeneratorFactory(IIntruderPayloadGeneratorFactory iIntruderPayloadGeneratorFactory);

    void registerIntruderPayloadProcessor(IIntruderPayloadProcessor iIntruderPayloadProcessor);

    List<IIntruderPayloadProcessor> getIntruderPayloadProcessors();

    void removeIntruderPayloadProcessor(IIntruderPayloadProcessor iIntruderPayloadProcessor);

    void registerSessionHandlingAction(ISessionHandlingAction iSessionHandlingAction);

    List<ISessionHandlingAction> getSessionHandlingActions();

    void removeSessionHandlingAction(ISessionHandlingAction iSessionHandlingAction);

    void unloadExtension();

    void addSuiteTab(ITab iTab);

    void removeSuiteTab(ITab iTab);

    void customizeUiComponent(Component component);

    IMessageEditor createMessageEditor(IMessageEditorController iMessageEditorController, boolean z);

    String[] getCommandLineArguments();

    void saveExtensionSetting(String str, String str2);

    String loadExtensionSetting(String str);

    ITextEditor createTextEditor();

    void sendToRepeater(String str, int i, byte[] bArr, String str2);

    void sendToIntruder(String str, int i, boolean z, byte[] bArr);

    void sendToIntruder(String str, int i, boolean z, byte[] bArr, List<int[]> list);

    void sendToComparer(byte[] bArr);

    void sendToSpider(URL url);

    IScanQueueItem doActiveScan(String str, int i, boolean z, byte[] bArr);

    IScanQueueItem doActiveScan(String str, int i, boolean z, byte[] bArr, List<int[]> list);

    void doPassiveScan(String str, int i, boolean z, byte[] bArr, byte[] bArr2);

    IHttpRequestResponse makeHttpRequest(IHttpService iHttpService, byte[] bArr);

    byte[] makeHttpRequest(String str, int i, boolean z, byte[] bArr);

    boolean isInScope(URL url);

    void includeInScope(URL url);

    void excludeFromScope(URL url);

    void issueAlert(String str);

    IHttpRequestResponse[] getProxyHistory();

    IHttpRequestResponse[] getSiteMap(String str);

    IScanIssue[] getScanIssues(String str);

    void generateScanReport(String str, IScanIssue[] iScanIssueArr, File file);

    List<ICookie> getCookieJarContents();

    void updateCookieJar(ICookie iCookie);

    void addToSiteMap(IHttpRequestResponse iHttpRequestResponse);

    @Deprecated
    void restoreState(File file);

    @Deprecated
    void saveState(File file);

    @Deprecated
    Map<String, String> saveConfig();

    @Deprecated
    void loadConfig(Map<String, String> map);

    String saveConfigAsJson(String... strArr);

    void loadConfigFromJson(String str);

    void setProxyInterceptionEnabled(boolean z);

    String[] getBurpVersion();

    String getExtensionFilename();

    boolean isExtensionBapp();

    void exitSuite(boolean z);

    ITempFile saveToTempFile(byte[] bArr);

    IHttpRequestResponsePersisted saveBuffersToTempFiles(IHttpRequestResponse iHttpRequestResponse);

    IHttpRequestResponseWithMarkers applyMarkers(IHttpRequestResponse iHttpRequestResponse, List<int[]> list, List<int[]> list2);

    String getToolName(int i);

    void addScanIssue(IScanIssue iScanIssue);

    IBurpCollaboratorClientContext createBurpCollaboratorClientContext();

    @Deprecated
    String[][] getParameters(byte[] bArr);

    @Deprecated
    String[] getHeaders(byte[] bArr);

    @Deprecated
    void registerMenuItem(String str, IMenuItemHandler iMenuItemHandler);
}
