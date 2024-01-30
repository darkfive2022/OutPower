package burp;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.PrintWriter;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/* loaded from: xia_yue.-1.2.jdk16.jar:burp/BurpExtender.class */
public class BurpExtender extends AbstractTableModel implements IBurpExtender, ITab, IHttpListener, IScannerCheck, IMessageEditorController {
    private IBurpExtenderCallbacks callbacks;
    private IExtensionHelpers helpers;
    private JSplitPane splitPane;
    private IMessageEditor requestViewer;
    private IMessageEditor responseViewer;
    private IMessageEditor requestViewer_1;
    private IMessageEditor responseViewer_1;
    private IMessageEditor requestViewer_2;
    private IMessageEditor responseViewer_2;
    private IMessageEditor requestViewer_3;
    private IMessageEditor responseViewer_3;
    private IHttpRequestResponse currentlyDisplayedItem;
    private IHttpRequestResponse currentlyDisplayedItem_1;
    private IHttpRequestResponse currentlyDisplayedItem_2;
    private IHttpRequestResponse currentlyDisplayedItem_3;
    public PrintWriter stdout;
    JTabbedPane tabs;
    int original_data_len;
    String temp_data;
    Table logTable;
    private final List<LogEntry> log = new ArrayList();
    private final List<Request_md5> log4_md5 = new ArrayList();
    int switchs = 0;
    int conut = 0;
    int select_row = 0;
    String white_URL = "";
    int white_switchs = 0;
    String data_1 = "";
    String data_2 = "";
    String universal_cookie = "";

    @Override // burp.IBurpExtender
    public void registerExtenderCallbacks(final IBurpExtenderCallbacks callbacks) {
        this.stdout = new PrintWriter(callbacks.getStdout(), true);
        this.stdout.println("======================");
        this.stdout.println("========OutPower======");
        this.stdout.println("=========version:1.0==");
        this.stdout.println("======================");

        this.callbacks = callbacks;
        this.helpers = callbacks.getHelpers();
        callbacks.setExtensionName("OutPower V1.0");
        SwingUtilities.invokeLater(new Runnable() { // from class: burp.BurpExtender.1
            @Override // java.lang.Runnable
            public void run() {
                BurpExtender.this.splitPane = new JSplitPane(1);
                JSplitPane splitPanes = new JSplitPane(0);
                JSplitPane splitPanes_2 = new JSplitPane(0);
                BurpExtender.this.logTable = new Table(BurpExtender.this);
                BurpExtender.this.logTable.getColumnModel().getColumn(0).setPreferredWidth(10);
                BurpExtender.this.logTable.getColumnModel().getColumn(1).setPreferredWidth(50);
                BurpExtender.this.logTable.getColumnModel().getColumn(2).setPreferredWidth(300);
                JScrollPane jScrollPane = new JScrollPane(BurpExtender.this.logTable);
                JPanel jPanel = new JPanel();
                jPanel.setLayout(new GridLayout(1, 1));
                jPanel.add(jScrollPane);
                JPanel jPanel2 = new JPanel();
                jPanel2.setLayout(new GridLayout(10, 1));
                JLabel jls = new JLabel("插件名:OutPower");
                JLabel jls_1 = new JLabel("版本：OutPower V1.0");
                JLabel jls_2 = new JLabel("Team：TheTRunker");
                JLabel jls_3 = new JLabel("感谢名单：算命瞎子，darkfive");
                final JCheckBox chkbox1 = new JCheckBox("启动插件");
                final JCheckBox chkbox2 = new JCheckBox("启动万能cookie");
                JLabel jls_5 = new JLabel("如果需要多个域名加白请用,(英文输入法)隔开");
                final JTextField textField = new JTextField("填写白名单域名");
                JButton btn1 = new JButton("清空列表");
                final JButton btn3 = new JButton("启动白名单");
                //修改日期：2024/1/21


                JPanel jps_2 = new JPanel();
                JLabel jps_2_jls_1 = new JLabel("越权：填写低权限认证信息,将会替换或新增");
                final JTextArea jta = new JTextArea("Cookie: JSESSIONID=test;UUID=1; userid=admin\nAuthorization: Bearer test", 5, 30);
                JScrollPane jsp = new JScrollPane(jta);
                JLabel jps_2_jls_2 = new JLabel("未授权：将移除下列头部认证信息,区分大小写");
                final JTextArea jta_1 = new JTextArea("Cookie\nAuthorization\nToken", 5, 30);
                JScrollPane jsp_1 = new JScrollPane(jta_1);
                //JLabel jps_2_jls_3 = new JLabel("越权：填写低权限认证信息,将会替换或新增");
                //final JTextArea jta_2 = new JTextArea("Cookie: JSESSIONID=test;UUID=1; userid=admin\nAuthorization: Bearer test", 5, 30);
                //JScrollPane jsp_2 = new JScrollPane(jta_2);
                //JLabel jps_2_jls_4 = new JLabel("fuzz参数模糊测试：对参数+1进行越权判断");
                //final JTextArea jta_3 = new JTextArea("userid\nid\nmerberid", 5, 30);
                //JScrollPane jsp_3 = new JScrollPane(jta_2);
                jps_2.add(jps_2_jls_1);
                jps_2.add(jsp);
                jps_2.add(jps_2_jls_2);
                jps_2.add(jsp_1);
                //jps_2.add(jps_2_jls_3);
                //jps_2.add(jsp_2);
                jps_2.setLayout(new GridLayout(5, 1, 0, 0));
                chkbox1.addItemListener(new ItemListener() { // from class: burp.BurpExtender.1.1
                    public void itemStateChanged(ItemEvent e) {
                        if (chkbox1.isSelected()) {
                            BurpExtender.this.switchs = 1;
                            BurpExtender.this.data_1 = jta.getText();
                            BurpExtender.this.data_2 = jta_1.getText();
                            jta.setForeground(Color.BLACK);
                            jta.setBackground(Color.CYAN);
                            jta.setEditable(false);
                            jta_1.setForeground(Color.BLACK);
                            jta_1.setBackground(Color.CYAN);
                            jta_1.setEditable(false);
                            //jta_2.setForeground(Color.BLACK);
                            //jta_2.setBackground(Color.CYAN);
                            //jta_2.setEditable(false);
                            return;
                        }
                        BurpExtender.this.switchs = 0;
                        jta.setForeground(Color.BLACK);
                        jta.setBackground(Color.YELLOW);
                        jta.setEditable(true);
                        jta_1.setForeground(Color.BLACK);
                        jta_1.setBackground(Color.YELLOW);
                        jta_1.setEditable(true);
                        //jta_2.setForeground(Color.BLACK);
                        //jta_2.setBackground(Color.YELLOW);
                        //jta_2.setEditable(true);
                    }
                });
                chkbox2.addItemListener(new ItemListener() { // from class: burp.BurpExtender.1.2
                    public void itemStateChanged(ItemEvent e) {
                        if (chkbox2.isSelected()) {
                            BurpExtender.this.universal_cookie = "";
                        } else {
                            BurpExtender.this.universal_cookie = "";
                        }
                    }
                });
                btn1.addActionListener(new ActionListener() { // from class: burp.BurpExtender.1.3
                    public void actionPerformed(ActionEvent e) {
                        BurpExtender.this.log.clear();
                        BurpExtender.this.conut = 0;
                        BurpExtender.this.log4_md5.clear();
                        BurpExtender.this.fireTableRowsInserted(BurpExtender.this.log.size(), BurpExtender.this.log.size());
                    }
                });

                btn3.addActionListener(new ActionListener() { // from class: burp.BurpExtender.1.4
                    public void actionPerformed(ActionEvent e) {
                        if (btn3.getText().equals("启动白名单")) {
                            btn3.setText("关闭白名单");
                            BurpExtender.this.white_URL = textField.getText();
                            BurpExtender.this.white_switchs = 1;
                            textField.setEditable(false);
                            textField.setForeground(Color.GRAY);
                            return;
                        }
                        btn3.setText("启动白名单");
                        BurpExtender.this.white_switchs = 0;
                        textField.setEditable(true);
                        textField.setForeground(Color.BLACK);
                    }
                });
                jPanel2.add(jls);
                jPanel2.add(jls_1);
                jPanel2.add(jls_2);
                jPanel2.add(jls_3);
                jPanel2.add(chkbox1);
                jPanel2.add(chkbox2);
                jPanel2.add(jls_5);
                jPanel2.add(textField);
                jPanel2.add(btn3);
                jPanel2.add(btn1);

                BurpExtender.this.tabs = new JTabbedPane();
                BurpExtender.this.requestViewer = callbacks.createMessageEditor(BurpExtender.this, false);
                BurpExtender.this.responseViewer = callbacks.createMessageEditor(BurpExtender.this, false);
                BurpExtender.this.requestViewer_1 = callbacks.createMessageEditor(BurpExtender.this, false);
                BurpExtender.this.responseViewer_1 = callbacks.createMessageEditor(BurpExtender.this, false);
                BurpExtender.this.requestViewer_2 = callbacks.createMessageEditor(BurpExtender.this, false);
                BurpExtender.this.responseViewer_2 = callbacks.createMessageEditor(BurpExtender.this, false);
                BurpExtender.this.requestViewer_3 = callbacks.createMessageEditor(BurpExtender.this, false);
                BurpExtender.this.responseViewer_3 = callbacks.createMessageEditor(BurpExtender.this, false);

                JSplitPane y_jp = new JSplitPane(1);
                y_jp.setDividerLocation(500);
                y_jp.setLeftComponent(BurpExtender.this.requestViewer.getComponent());
                y_jp.setRightComponent(BurpExtender.this.responseViewer.getComponent());
                JSplitPane d_jp = new JSplitPane(1);
                d_jp.setDividerLocation(500);
                d_jp.setLeftComponent(BurpExtender.this.requestViewer_1.getComponent());
                d_jp.setRightComponent(BurpExtender.this.responseViewer_1.getComponent());
                JSplitPane w_jp = new JSplitPane(1);
                w_jp.setDividerLocation(500);
                w_jp.setLeftComponent(BurpExtender.this.requestViewer_2.getComponent());
                w_jp.setRightComponent(BurpExtender.this.responseViewer_2.getComponent());
                JSplitPane z_jp = new JSplitPane(1);
                z_jp.setDividerLocation(500);
                z_jp.setLeftComponent(BurpExtender.this.requestViewer_3.getComponent());
                z_jp.setRightComponent(BurpExtender.this.responseViewer_3.getComponent());
                BurpExtender.this.tabs.addTab("原始数据包", y_jp);
                BurpExtender.this.tabs.addTab("低权限数据包", d_jp);
                BurpExtender.this.tabs.addTab("未授权数据包", w_jp);
                BurpExtender.this.tabs.addTab("is_vul数据包",z_jp);
                splitPanes_2.setLeftComponent(jPanel2);
                splitPanes_2.setRightComponent(jps_2);
                splitPanes.setLeftComponent(jPanel);
                splitPanes.setRightComponent(BurpExtender.this.tabs);
                BurpExtender.this.splitPane.setLeftComponent(splitPanes);
                BurpExtender.this.splitPane.setRightComponent(splitPanes_2);
                BurpExtender.this.splitPane.setDividerLocation(1000);
                callbacks.customizeUiComponent(BurpExtender.this.splitPane);
                callbacks.customizeUiComponent(BurpExtender.this.logTable);
                callbacks.customizeUiComponent(jScrollPane);
                callbacks.customizeUiComponent(jPanel2);
                callbacks.customizeUiComponent(jPanel);
                callbacks.customizeUiComponent(BurpExtender.this.tabs);
                callbacks.addSuiteTab(BurpExtender.this);
                callbacks.registerHttpListener(BurpExtender.this);
                callbacks.registerScannerCheck(BurpExtender.this);
            }
        });
    }

    @Override // burp.ITab
    public String getTabCaption() {
        return "OutPower";
    }

    @Override // burp.ITab
    public Component getUiComponent() {
        return this.splitPane;
    }

    @Override // burp.IBurpExtender, burp.IHttpListener
    public void processHttpMessage(final int toolFlag, boolean messageIsRequest, final IHttpRequestResponse messageInfo) {
        if (this.switchs == 1 && toolFlag == 4 && !messageIsRequest) {
            synchronized (this.log) {
                Thread thread = new Thread(new Runnable() { // from class: burp.BurpExtender.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            BurpExtender.this.checkVul(messageInfo, toolFlag);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            BurpExtender.this.stdout.println(ex);
                        }
                    }
                });
                thread.start();
            }
        }
    }

    @Override // burp.IScannerCheck
    public List<IScanIssue> doPassiveScan(IHttpRequestResponse baseRequestResponse) {
        return null;
    }

    private void checkVul(IHttpRequestResponse baseRequestResponse, int toolFlag) {
        String low_len_data;
        int original_len1;
        String original_len_data;
        String is_vuln="√";
        this.temp_data = String.valueOf(this.helpers.analyzeRequest(baseRequestResponse).getUrl());
        this.original_data_len = baseRequestResponse.getResponse().length;
        int original_len = this.original_data_len - this.helpers.analyzeResponse(baseRequestResponse.getResponse()).getBodyOffset();
        String[] temp_data_strarray = this.temp_data.split("\\?");
        String temp_data = temp_data_strarray[0];
        String[] white_URL_list = this.white_URL.split(",");
        if (this.white_switchs == 1) {
            int white_swith = 0;
            for (String str : white_URL_list) {
                if (temp_data.contains(str)) {
                    this.stdout.println("白名单URL！" + temp_data);
                    white_swith = 1;
                }
            }
            if (white_swith == 0) {  //逻辑有问题
                this.stdout.println("不是白名单URL！" + temp_data);
                return;
            }
        }
        if (toolFlag == 4 || toolFlag == 64) {
            String[] static_file = {"jpg", "png", "gif", "css", "js", "pdf", "mp3", "mp4", "avi", "map", "svg", "ico", "svg", "woff", "woff2", "ttf"};
            String[] static_file_1 = temp_data.split("\\.");
            String static_file_2 = static_file_1[static_file_1.length - 1];
            for (String i : static_file) {
                if (static_file_2.equals(i)) {
                    this.stdout.println("当前url为静态文件：" + temp_data + "\n");
                    return;
                }
            }
        }
        List<IParameter> paraLists = this.helpers.analyzeRequest(baseRequestResponse).getParameters();
        for (IParameter para : paraLists) {
            temp_data = temp_data + "+" + para.getName();
        }
        String temp_data2 = temp_data + "+" + this.helpers.analyzeRequest(baseRequestResponse).getMethod();
        this.stdout.println("\nMD5(\"" + temp_data2 + "\")");
        String temp_data3 = MD5(temp_data2);
        this.stdout.println(temp_data3);
        for (Request_md5 i2 : this.log4_md5) {
            if (i2.md5_data.equals(temp_data3)) {
                return;
            }
        }
        this.log4_md5.add(new Request_md5(temp_data3));

        /*2024/1/24开发
           新增应用场景，如/webui/user/add/123456，即123456为数据查询参数，可通过该参数fuzz实现越权判断
           检测思路：
           通过响应内容大小判断
           误报优化：
           通过3次fuzz请求响应判断，若3次响应内容一致，说明极大可能不存在越权风险
         *
         */
        IRequestInfo analyIRequestInfo1 = this.helpers.analyzeRequest(baseRequestResponse);
        URL url = analyIRequestInfo1.getUrl();
        String path = url.getPath();
        String lastPart = path.substring(path.lastIndexOf("/") + 1);
        int path_len = lastPart.length();
        boolean isInt = lastPart.matches("\\d+");
        boolean isPath = lastPart.matches("\\?");
        String formattedNumber;
        String result;

        if(isInt){
            int res = Integer.parseInt(lastPart)+1;
            result = String.format("%0"+path_len+"d", res);
        }else {
            result = lastPart;
        }

        //String result2 = String.format("%0"+path_len+"s",result);

        IResponseInfo iResponseInfo = this.helpers.analyzeResponse(baseRequestResponse.getResponse());
        int length = baseRequestResponse.getResponse().length;
        original_len1 = length - iResponseInfo.getBodyOffset();
        int index1 = (length - original_len1) % 2;
        String originalRequest = new String(baseRequestResponse.getRequest());
        // 修改请求路径,
        String modifiedRequest = originalRequest.replace(lastPart, result);
        byte[] b1 = modifiedRequest.getBytes();
        IHttpService iHttpService1 = baseRequestResponse.getHttpService();
        IHttpRequestResponse requestResponse_z = this.callbacks.makeHttpRequest(iHttpService1,b1);
        IResponseInfo iResponseInfo1 = this.helpers.analyzeResponse(requestResponse_z.getResponse());

        //多次fuzz判断越权
        /*  未实现代码如下：
        int[] arr1 = new int[3];  //fuzz三次
        for (int i = 0 ; i < arr1.length ; i++ ){
            String result1 = String.valueOf((Integer.parseInt(lastPart)+i+1));
            String modifiedRequest1 = originalRequest.replace(lastPart, result1);
            byte[] b2 = modifiedRequest1.getBytes();
            IHttpService iHttpService2 = baseRequestResponse.getHttpService();
            IHttpRequestResponse requestResponse_t = this.callbacks.makeHttpRequest(iHttpService2,b2);
            IResponseInfo iResponseInfo2 = this.helpers.analyzeResponse(requestResponse_t.getResponse());
            int new_resp1 = requestResponse_t.getResponse().length;
            int low_len3 = new_resp1 - iResponseInfo2.getBodyOffset();
            arr1[i] = low_len3;
        }

        if (iResponseInfo1.getStatusCode() != 200 && !checkArrayValues(arr1) && result.equals(lastPart)){
            is_vuln = "❌";
        }

         */
        int[] arr1 = new int[3];  //fuzz三次
        for (int i = 0 ; i < arr1.length ; i++ ){
            String result1 = String.valueOf((Integer.parseInt(lastPart)+i+1));
            String modifiedRequest1 = originalRequest.replace(lastPart, result1);
            byte[] b2 = modifiedRequest1.getBytes();
            IHttpService iHttpService2 = baseRequestResponse.getHttpService();
            IHttpRequestResponse requestResponse_t = this.callbacks.makeHttpRequest(iHttpService2,b2);
            IResponseInfo iResponseInfo2 = this.helpers.analyzeResponse(requestResponse_t.getResponse());
            int new_resp1 = requestResponse_t.getResponse().length;
            int low_len3 = new_resp1 - iResponseInfo2.getBodyOffset();
            arr1[i] = low_len3;
        }

        if (iResponseInfo1.getStatusCode() != 200 && checkArrayValues(arr1) && result.equals(lastPart)){
            is_vuln = "❌";
        }
//        if (iResponseInfo1.getStatusCode() == 200){
//            int new_resp = requestResponse_z.getResponse().length;
//            int low_len2 = new_resp - iResponseInfo1.getBodyOffset();
//            int index2 = new_resp - low_len2;
//            if ( index2 < index1 ){
//                is_vuln = "❌";
//            }else if(result == lastPart){
//                is_vuln = "❌";
//            }
//        }else {
//            is_vuln = "❌";
//        }

        IRequestInfo analyIRequestInfo = this.helpers.analyzeRequest(baseRequestResponse);
        IHttpService iHttpService = baseRequestResponse.getHttpService();
        String request = this.helpers.bytesToString(baseRequestResponse.getRequest());
        int bodyOffset = analyIRequestInfo.getBodyOffset();
        byte[] body = request.substring(bodyOffset).getBytes();
        List<String> headers_y = analyIRequestInfo.getHeaders();
        String[] data_1_list = this.data_1.split("\n");
        for (int i3 = 0; i3 < headers_y.size(); i3++) {
            String head_key = headers_y.get(i3).split(":")[0];
            for (String str2 : data_1_list) {
                if (head_key.equals(str2.split(":")[0])) {
                    headers_y.remove(i3);
                }
            }
        }
        for (String str3 : data_1_list) {
            headers_y.add(headers_y.size() / 2, str3);
        }
        byte[] newRequest_y = this.helpers.buildHttpMessage(headers_y, body);
        IHttpRequestResponse requestResponse_y = this.callbacks.makeHttpRequest(iHttpService, newRequest_y);
        int low_len = requestResponse_y.getResponse().length - this.helpers.analyzeResponse(requestResponse_y.getResponse()).getBodyOffset();
        if (original_len == 0) {
            low_len_data = Integer.toString(low_len);
        } else if (original_len == low_len) {
            low_len_data = Integer.toString(low_len) + "  ✔";
        } else {
            low_len_data = Integer.toString(low_len) + "  ==> " + Integer.toString(original_len - low_len);
        }
        List<String> headers_w = analyIRequestInfo.getHeaders();
        String[] data_2_list = this.data_2.split("\n");
        for (int i4 = 0; i4 < headers_w.size(); i4++) {
            String head_key2 = headers_w.get(i4).split(":")[0];
            for (String str4 : data_2_list) {
                if (head_key2.equals(str4)) {
                    headers_w.remove(i4);
                }
            }
        }
        if (this.universal_cookie.length() != 0) {
            String[] universal_cookies = this.universal_cookie.split("\n");
            headers_w.add(headers_w.size() / 2, universal_cookies[0]);
            headers_w.add(headers_w.size() / 2, universal_cookies[1]);
        }
        byte[] newRequest_w = this.helpers.buildHttpMessage(headers_w, body);
        IHttpRequestResponse requestResponse_w = this.callbacks.makeHttpRequest(iHttpService, newRequest_w);
        int Unauthorized_len = requestResponse_w.getResponse().length - this.helpers.analyzeResponse(requestResponse_w.getResponse()).getBodyOffset();
        if (original_len == 0) {
            original_len_data = Integer.toString(Unauthorized_len);
        } else if (original_len == Unauthorized_len) {
            original_len_data = Integer.toString(Unauthorized_len) + "  ✔";
        } else {
            original_len_data = Integer.toString(Unauthorized_len) + "  ==> " + Integer.toString(original_len - Unauthorized_len);
        }
        this.conut++;
        int id = this.conut;
        this.log.add(new LogEntry(id, this.helpers.analyzeRequest(baseRequestResponse).getMethod(), this.callbacks.saveBuffersToTempFiles(baseRequestResponse), this.callbacks.saveBuffersToTempFiles(requestResponse_y), this.callbacks.saveBuffersToTempFiles(requestResponse_w),this.callbacks.saveBuffersToTempFiles(requestResponse_z), String.valueOf(this.helpers.analyzeRequest(baseRequestResponse).getUrl()), original_len, low_len_data, original_len_data,is_vuln));
        fireTableDataChanged();
        this.logTable.setRowSelectionInterval(this.select_row, this.select_row);
    }

    @Override // burp.IScannerCheck
    public List<IScanIssue> doActiveScan(IHttpRequestResponse baseRequestResponse, IScannerInsertionPoint insertionPoint) {
        return null;
    }

    @Override // burp.IScannerCheck
    public int consolidateDuplicateIssues(IScanIssue existingIssue, IScanIssue newIssue) {
        if (existingIssue.getIssueName().equals(newIssue.getIssueName())) {
            return -1;
        }
        return 0;
    }

    public static boolean checkArrayValues(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int firstValue = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != firstValue) {
                return false;
            }
        }

        return true;
    }


    public int getRowCount() {
        return this.log.size();
    }

    public int getColumnCount() {
        return 7;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "#";
            case 1:
                return "类型";
            case 2:
                return "URL";
            case 3:
                return "原始包长度";
            case 4:
                return "低权限包长度";
            case 5:
                return "未授权包长度";
            case 6:
                return "is_vul";
            default:
                return "";
        }
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        LogEntry logEntry = this.log.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Integer.valueOf(logEntry.id);
            case 1:
                return logEntry.Method;
            case 2:
                return logEntry.url;
            case 3:
                return Integer.valueOf(logEntry.original_len);
            case 4:
                return logEntry.low_len;
            case 5:
                return logEntry.Unauthorized_len;
            case 6:
                return logEntry.is_vul;
            default:
                return "";
        }
    }

    @Override // burp.IHttpListener, burp.IMessageEditorController
    public byte[] getRequest() {
        return this.currentlyDisplayedItem.getRequest();
    }

    @Override // burp.IBurpExtender, burp.IMessageEditorController
    public byte[] getResponse() {
        return this.currentlyDisplayedItem.getResponse();
    }

    @Override // burp.IBurpExtender, burp.IMessageEditorController
    public IHttpService getHttpService() {
        return this.currentlyDisplayedItem.getHttpService();
    }

    @Override
    public void processHttpMessage(boolean messageIsRequest, IInterceptedProxyMessage message) {

    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xia_yue.-1.2.jdk16.jar:burp/BurpExtender$Table.class */
    public class Table extends JTable {
        public Table(TableModel tableModel) {
            super(tableModel);
        }

        public void changeSelection(int row, int col, boolean toggle, boolean extend) {
            LogEntry logEntry = BurpExtender.this.log.get(row);
            BurpExtender.this.select_row = row;
            if (col == 4) {
                BurpExtender.this.tabs.setSelectedIndex(1);
            } else if (col == 5) {
                BurpExtender.this.tabs.setSelectedIndex(2);
            } else if (col == 3) {
                BurpExtender.this.tabs.setSelectedIndex(0);
            }else if (col == 6){
                BurpExtender.this.tabs.setSelectedIndex(3);
            }
            BurpExtender.this.requestViewer.setMessage(logEntry.requestResponse.getRequest(), true);
            BurpExtender.this.responseViewer.setMessage(logEntry.requestResponse.getResponse(), false);
            BurpExtender.this.currentlyDisplayedItem = logEntry.requestResponse;
            BurpExtender.this.requestViewer_1.setMessage(logEntry.requestResponse_1.getRequest(), true);
            BurpExtender.this.responseViewer_1.setMessage(logEntry.requestResponse_1.getResponse(), false);
            BurpExtender.this.currentlyDisplayedItem_1 = logEntry.requestResponse_1;
            BurpExtender.this.requestViewer_2.setMessage(logEntry.requestResponse_2.getRequest(), true);
            BurpExtender.this.responseViewer_2.setMessage(logEntry.requestResponse_2.getResponse(), false);
            BurpExtender.this.currentlyDisplayedItem_2 = logEntry.requestResponse_2;
            BurpExtender.this.requestViewer_3.setMessage(logEntry.requestResponse_3.getRequest(), true);
            BurpExtender.this.responseViewer_3.setMessage(logEntry.requestResponse_3.getResponse(), false);
            BurpExtender.this.currentlyDisplayedItem_3 = logEntry.requestResponse_3;
            super.changeSelection(row, col, toggle, extend);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xia_yue.-1.2.jdk16.jar:burp/BurpExtender$Request_md5.class */
    public static class Request_md5 {
        final String md5_data;

        Request_md5(String md5_data) {
            this.md5_data = md5_data;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xia_yue.-1.2.jdk16.jar:burp/BurpExtender$LogEntry.class */
    public static class LogEntry {
        final int id;
        final String Method;
        final IHttpRequestResponsePersisted requestResponse;
        final IHttpRequestResponsePersisted requestResponse_1;
        final IHttpRequestResponsePersisted requestResponse_2;
        final IHttpRequestResponsePersisted requestResponse_3;
        final String url;
        final int original_len;
        final String low_len;
        final String Unauthorized_len;

        final String is_vul;

        LogEntry(int id, String Method, IHttpRequestResponsePersisted requestResponse, IHttpRequestResponsePersisted requestResponse_1, IHttpRequestResponsePersisted requestResponse_2, IHttpRequestResponsePersisted requestResponse_3 ,String url, int original_len, String low_len, String Unauthorized_len,String vul) {
            this.id = id;
            this.Method = Method;
            this.requestResponse = requestResponse;
            this.requestResponse_1 = requestResponse_1;
            this.requestResponse_2 = requestResponse_2;
            this.requestResponse_3 = requestResponse_3;
            this.url = url;
            this.original_len = original_len;
            this.low_len = low_len;
            this.Unauthorized_len = Unauthorized_len;
            this.is_vul = vul;
        }
    }

    public static String MD5(String key) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = key.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                int i = k;
                int k2 = k + 1;
                str[i] = hexDigits[(byte0 >>> 4) & 15];
                k = k2 + 1;
                str[k2] = hexDigits[byte0 & 15];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
}