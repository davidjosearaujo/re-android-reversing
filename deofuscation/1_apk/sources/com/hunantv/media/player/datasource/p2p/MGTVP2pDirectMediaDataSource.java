package com.hunantv.media.player.datasource.p2p;

import c.a.a.a.f;
import com.google.gson.Gson;
import com.hunantv.media.player.libnative.IMGTVMediaDataSource;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.player.utils.StringUtil;
import com.hunantv.media.player.utils.UrlUtil;
import com.hunantv.media.utils.HttpParser;
import com.mgtv.easydatasource.p2p.IP2pMgr;
import com.mgtv.easydatasource.p2p.ImgoP2pManager;
import com.mgtv.easydatasource.p2p.ImgoP2pTask;
import java.io.IOException;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MGTVP2pDirectMediaDataSource implements IMGTVMediaDataSource {
    private static final int CODE_ABORT = -1;
    private static final int CODE_BLOCKED = 1;
    private static final int CODE_NORMAL = 0;
    public static final int ERROR_TYPE_CUS_CODE = 9;
    public static final int ERR_BASE_CODE_610 = 610;
    public static final int ERR_BASE_CODE_701 = 701;
    public static final int ERR_BASE_CODE_705 = 705;
    public static final int ERR_BASE_CODE_910 = 910;
    public static final int ERR_BASE_CODE_911 = 911;
    public static final int ERR_BASE_CODE_913 = 913;
    public static final int ERR_P2P_DIRECT_WHAT = 400700;
    public static final int ERR_P2P_MGTVDS_NEGATIVE_BASECODE = 710000;
    public static final int ERR_P2P_MGTVDS_POSITIVE_BASECODE = 700000;
    public static final int ERR_P2P_STAGE_BASE_CODE = 10000000;
    public static final int ERR_P2P_STAGE_GETSIZE_FLAGCODE = 1;
    public static final int ERR_P2P_STAGE_READAT_FLAGCODE = 2;
    public static final int ERR_P2P_TYPE_BASE_CODE = 1000000;
    public static final int ERR_P2P_TYPE_BASE_FLAGCODE = 0;
    public static final int INVALID_CODE = -1;
    public static final int MAX_P2P_NOT_START_TIMEOUT_US = 10000000;
    public static final int WAIT_MS = 10;
    private Config mConfig;
    private String mDataSourceUrl;
    private IMGTVMediaDataSource.IInfoListener mInfoListener;
    private volatile CdnM3u8Entity mLastM3u8Entity;
    private f mMediaPlayer;
    private ImgoP2pTask mP2pTask;
    private int mVideoSourceType;
    private volatile boolean mRequestAbort = false;
    private volatile HttpErrorEntity mLastHttpError = null;
    private Object mLockObj = new Object();
    private String mTagStr = "";
    private IP2pMgr.OnNotifyMsgListener mOnNotifyMsgListener = new IP2pMgr.OnNotifyMsgListener() { // from class: com.hunantv.media.player.datasource.p2p.MGTVP2pDirectMediaDataSource.1
        private void doCallbackHttpBegin(int i, String str) {
            HttpBeginEntity httpBeginEntity = (HttpBeginEntity) new Gson().fromJson(str, HttpBeginEntity.class);
            if (httpBeginEntity == null || !validHash(httpBeginEntity.hash)) {
                return;
            }
            String logTag = MGTVP2pDirectMediaDataSource.this.getLogTag();
            DebugLog.i(logTag, "Begin hash:" + httpBeginEntity.hash);
            String logTag2 = MGTVP2pDirectMediaDataSource.this.getLogTag();
            DebugLog.i(logTag2, "Begin url:" + httpBeginEntity.url);
        }

        private void doCallbackHttpEnd(int i, String str) {
            MGTVP2pDirectMediaDataSource.this.mLastHttpError = null;
            String logTag = MGTVP2pDirectMediaDataSource.this.getLogTag();
            MGTVP2pDirectMediaDataSource.P2PDebugD(logTag, "doCallbackHttpEnd " + i + "-" + str);
            HttpEndEntity httpEndEntity = (HttpEndEntity) new Gson().fromJson(str, HttpEndEntity.class);
            if (httpEndEntity == null || !validHash(httpEndEntity.hash)) {
                return;
            }
            String logTag2 = MGTVP2pDirectMediaDataSource.this.getLogTag();
            DebugLog.i(logTag2, "End hash:" + httpEndEntity.hash);
            String logTag3 = MGTVP2pDirectMediaDataSource.this.getLogTag();
            DebugLog.i(logTag3, "End url:" + httpEndEntity.url);
            String logTag4 = MGTVP2pDirectMediaDataSource.this.getLogTag();
            DebugLog.i(logTag4, "End ip:" + httpEndEntity.ip);
        }

        private void doCallbackHttpError(int i, String str) {
            String logTag = MGTVP2pDirectMediaDataSource.this.getLogTag();
            MGTVP2pDirectMediaDataSource.P2PDebugD(logTag, "doCallbackHttpError " + i + "-" + str);
            HttpErrorEntity httpErrorEntity = (HttpErrorEntity) new Gson().fromJson(str, HttpErrorEntity.class);
            if (httpErrorEntity == null || !validHash(httpErrorEntity.hash)) {
                return;
            }
            MGTVP2pDirectMediaDataSource.this.mLastHttpError = httpErrorEntity;
        }

        private void doCdnM3u8Callback(int i, String str) {
            CdnM3u8Entity cdnM3u8Entity;
            DebugLog.i(MGTVP2pDirectMediaDataSource.this.getLogTag(), "httpBodySize:" + i);
            MGTVP2pDirectMediaDataSource.P2PDebugD(MGTVP2pDirectMediaDataSource.this.getLogTag(), str);
            try {
                cdnM3u8Entity = (CdnM3u8Entity) new Gson().fromJson(str, CdnM3u8Entity.class);
            } catch (Exception unused) {
                DebugLog.e(MGTVP2pDirectMediaDataSource.this.getLogTag(), "doCdnM3u8Callback error，wrong json data,'buf' = " + str);
                cdnM3u8Entity = null;
            }
            if (cdnM3u8Entity == null || !validHash(cdnM3u8Entity.hash)) {
                return;
            }
            cdnM3u8Entity.isHtml = StringUtil.isHtml(cdnM3u8Entity.data);
            cdnM3u8Entity.fileName = UrlUtil.getFileName(cdnM3u8Entity.url);
            long parseContentLength = HttpParser.parseContentLength(cdnM3u8Entity.data);
            if (parseContentLength >= 0 && parseContentLength != i) {
                cdnM3u8Entity.contentLength = parseContentLength;
                cdnM3u8Entity.httpBodySize = i;
            }
            MGTVP2pDirectMediaDataSource.this.mLastM3u8Entity = cdnM3u8Entity;
        }

        private boolean validHash(String str) {
            return !StringUtil.isEmpty(str) && str.equalsIgnoreCase(MGTVP2pDirectMediaDataSource.this.mP2pTask.getStrHash());
        }

        public void onNotify(int i, int i2, String str) {
        }
    };

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class APIResult {
        public long costMs;
        public long ret;

        private APIResult() {
            this.ret = 0L;
            this.costMs = 0L;
        }

        public void clean() {
            this.ret = 0L;
            this.costMs = 0L;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Config {
        private static final int MIN_TIMEOUT_US = 100000;
        private int connectTimeOutUs = 15000000;
        private int reciveDataTimeOutUs = 15000000;

        public int getConnectTimeOutUs() {
            return this.connectTimeOutUs;
        }

        public int getReciveDataTimeOutUs() {
            return this.reciveDataTimeOutUs;
        }

        public Config setConnectTimeOutUs(int i) {
            if (i > MIN_TIMEOUT_US) {
                this.connectTimeOutUs = i;
            }
            return this;
        }

        public Config setReciveDataTimeOutUs(int i) {
            if (i > MIN_TIMEOUT_US) {
                this.reciveDataTimeOutUs = i;
            }
            return this;
        }
    }

    static {
        new Gson();
    }

    public MGTVP2pDirectMediaDataSource(f fVar, String str, int i, ImgoP2pTask imgoP2pTask, Config config) {
        this.mMediaPlayer = fVar;
        this.mDataSourceUrl = str;
        this.mVideoSourceType = i;
        this.mP2pTask = imgoP2pTask;
        this.mConfig = config;
        if (config == null) {
            this.mConfig = new Config();
        }
        String logTag = getLogTag();
        DebugLog.i(logTag, "setConfig connectTime:" + this.mConfig.getConnectTimeOutUs() + ",receiveTime:" + this.mConfig.getReciveDataTimeOutUs());
        if (this.mP2pTask != null) {
            ImgoP2pManager.getInstance().addNotifyListener(this.mOnNotifyMsgListener);
        }
    }

    public static void P2PDebugD(String str, String str2) {
    }

    private int blockReadThread() {
        boolean z = false;
        while (!isRequestAbort() && !isP2pTaskStart()) {
            try {
                this.mLockObj.wait(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            z = true;
        }
        if (isRequestAbort()) {
            return -1;
        }
        return z ? 1 : 0;
    }

    private void callbackOnSourceInfoUpdate() {
        if (isRequestAbort() || this.mInfoListener == null) {
            return;
        }
        this.mInfoListener.onSourceInfoUpdate(ImgoP2pManager.getInstance().getTaskInfo(this.mP2pTask));
    }

    private static boolean checkClass() {
        return true;
    }

    private long checkHtmlM3u8(long j, int i, String str) {
        if (this.mLastM3u8Entity == null || !this.mLastM3u8Entity.isHtml || StringUtil.isEmpty(this.mLastM3u8Entity.fileName) || !this.mLastM3u8Entity.fileName.equals(UrlUtil.getFileName(str))) {
            return j;
        }
        DebugLog.i(getLogTag(), "getSize out error_code:701");
        return convertPlayerErrorCode(i, 9, 701);
    }

    private long checkM3u8SizeError(int i, String str) {
        if (this.mLastM3u8Entity == null || !this.mLastM3u8Entity.isSizeError || StringUtil.isEmpty(this.mLastM3u8Entity.fileName) || !this.mLastM3u8Entity.fileName.equals(UrlUtil.getFileName(str))) {
            return 0L;
        }
        DebugLog.i(getLogTag(), "checkM3u8SizeError error_code:705");
        return convertPlayerErrorCode(i, 9, ERR_BASE_CODE_705);
    }

    public static int convertErrorTypeStaticCode(int i) {
        return 8;
    }

    public static int convertP2pErrorCode(int i) {
        return Math.abs(i) % 10000;
    }

    private static int convertPlayerErrorCode(int i, int i2, int i3) {
        int i4 = (i * 10000000) + (i2 * ERR_P2P_TYPE_BASE_CODE);
        return -(i3 >= 0 ? i4 + 700000 + i3 : i4 + ERR_P2P_MGTVDS_NEGATIVE_BASECODE + Math.abs(i3));
    }

    private static int convertPlayerErrorCodeGetSize(int i) {
        return convertPlayerErrorCodeGetSize(0, i);
    }

    private static int convertPlayerErrorCodeGetSize(int i, int i2) {
        return convertPlayerErrorCode(1, i, i2);
    }

    private static int convertPlayerErrorCodeReadAt(int i) {
        return convertPlayerErrorCodeReadAt(0, i);
    }

    private static int convertPlayerErrorCodeReadAt(int i, int i2) {
        return convertPlayerErrorCode(2, i, i2);
    }

    public static int convertTaskStatusCode(int i) {
        if (i != -1) {
            if (i != 0) {
                return i != 1 ? 4 : 3;
            }
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLogTag() {
        StringBuilder sb = new StringBuilder();
        sb.append("P2pDirect-");
        ImgoP2pTask imgoP2pTask = this.mP2pTask;
        sb.append(imgoP2pTask != null ? imgoP2pTask.getStrHash() : 0);
        sb.append("-");
        sb.append(hashCode());
        sb.append("-");
        sb.append(this.mTagStr);
        return sb.toString();
    }

    private static int getP2pDirectTypeCode(int i) {
        return (i / ERR_P2P_TYPE_BASE_CODE) % 10;
    }

    public static int getShortErrorCode(int i, int i2) {
        if (i == 400700) {
            return convertP2pErrorCode(i2);
        }
        return -1;
    }

    private long getSizeImpl(String str) {
        long[] jArr = new long[1];
        int[] iArr = new int[1];
        long readData = ImgoP2pManager.getInstance().readData(this.mP2pTask, str, (byte[]) null, 0L, 0L, jArr, iArr);
        if (0 == readData) {
            P2PDebugD(getLogTag(), "getSizeImpl out OK. size:" + jArr[0]);
            return jArr[0];
        } else if (-555 == readData) {
            return -2018102640L;
        } else {
            if (-1 == readData) {
                if (iArr[0] >= 400) {
                    int i = iArr[0];
                }
                long convertPlayerErrorCodeGetSize = convertPlayerErrorCodeGetSize(iArr[0]);
                P2PDebugD(getLogTag(), "getSizeImpl out E_NET_FALSE. ret:" + convertPlayerErrorCodeGetSize);
                return convertPlayerErrorCodeGetSize;
            }
            return convertPlayerErrorCodeGetSize((int) readData);
        }
    }

    private APIResult getSizeImplProxy(String str) {
        APIResult aPIResult = new APIResult();
        long currentTimeMillis = System.currentTimeMillis();
        aPIResult.ret = getSizeImpl(str);
        aPIResult.costMs = System.currentTimeMillis() - currentTimeMillis;
        return aPIResult;
    }

    private boolean isDataSourcePaused() {
        return (isP2pTaskStart() || (this.mMediaPlayer.z3() && this.mMediaPlayer.e0())) ? false : true;
    }

    public static boolean isNoTaskByHashError(int i, int i2) {
        if (isP2pDirectError(i, i2)) {
            return i2 == 10710012 || i2 == 20710012 || i2 == 20710006 || i2 == 10710006;
        }
        return false;
    }

    public static boolean isP2pDirect913X(int i, int i2) {
        int convertP2pErrorCode;
        return i == 400700 && isP2pDirectCusCode(i, i2) && (convertP2pErrorCode = convertP2pErrorCode(i2)) >= 9130 && convertP2pErrorCode <= 9139;
    }

    public static boolean isP2pDirectCusCode(int i, int i2) {
        return i == 400700 && getP2pDirectTypeCode(i2) == 9;
    }

    public static boolean isP2pDirectDnsError(int i, int i2) {
        if (i == 400700) {
            getP2pDirectTypeCode(i2);
            return false;
        }
        return false;
    }

    public static boolean isP2pDirectError(int i, int i2) {
        return i == 400700;
    }

    public static boolean isP2pDirectHttp403(int i, int i2) {
        return i == 400700 && convertP2pErrorCode(i2) == 403;
    }

    public static boolean isP2pDirectHttp410(int i, int i2) {
        return i == 400700 && convertP2pErrorCode(i2) == 410;
    }

    public static boolean isP2pDirectHttp4XX(int i, int i2) {
        int convertP2pErrorCode;
        return i == 400700 && (convertP2pErrorCode = convertP2pErrorCode(i2)) >= 400 && convertP2pErrorCode <= 499;
    }

    public static boolean isP2pDirectHttp5XX(int i, int i2) {
        int convertP2pErrorCode;
        return i == 400700 && (convertP2pErrorCode = convertP2pErrorCode(i2)) >= 500 && convertP2pErrorCode <= 599;
    }

    public static boolean isP2pDirectTimeoutError(int i, int i2) {
        int convertP2pErrorCode;
        if (i == 400700) {
            return i2 == 107910 || i2 == 107911 || (convertP2pErrorCode = convertP2pErrorCode(i2)) == 910 || convertP2pErrorCode == 911 || isP2pDirect913X(i, i2);
        }
        return false;
    }

    private long readAtImpl(String str, byte[] bArr, long j, long j2) {
        int[] iArr = new int[1];
        long readData = ImgoP2pManager.getInstance().readData(this.mP2pTask, str, bArr, j, j2, new long[1], iArr);
        if (readData > 0) {
            String logTag = getLogTag();
            P2PDebugD(logTag, "readAtImpl out OK. size:" + readData);
            return readData;
        } else if (-555 == readData) {
            return -2018102640L;
        } else {
            if (-1 == readData) {
                long convertPlayerErrorCodeReadAt = 1 == iArr[0] ? -2018102641L : convertPlayerErrorCodeReadAt(iArr[0]);
                String logTag2 = getLogTag();
                P2PDebugD(logTag2, "readAtImpl out E_NET_FALSE. ret:" + convertPlayerErrorCodeReadAt);
                return convertPlayerErrorCodeReadAt;
            }
            return convertPlayerErrorCodeReadAt((int) readData);
        }
    }

    private APIResult readAtImplProxy(String str, byte[] bArr, long j, long j2) {
        APIResult aPIResult = new APIResult();
        long currentTimeMillis = System.currentTimeMillis();
        aPIResult.ret = readAtImpl(str, bArr, j, j2);
        aPIResult.costMs = System.currentTimeMillis() - currentTimeMillis;
        return aPIResult;
    }

    @Override // com.hunantv.media.player.libnative.IMGTVMediaDataSource
    public void close(String str) throws IOException {
    }

    public void finalize() throws Throwable {
        super.finalize();
        release();
    }

    @Override // com.hunantv.media.player.libnative.IMGTVMediaDataSource
    public String getDataSourceUrl() {
        return this.mDataSourceUrl;
    }

    public CdnM3u8Entity getLastM3u8Entity() {
        return this.mLastM3u8Entity;
    }

    @Override // com.hunantv.media.player.libnative.IMGTVMediaDataSource
    public long getSize(String str) throws IOException {
        int blockReadThread;
        P2PDebugD(getLogTag(), "getSize in url:" + str);
        synchronized (this.mLockObj) {
            APIResult aPIResult = new APIResult();
            long currentTimeMillis = System.currentTimeMillis();
            callbackOnSourceInfoUpdate();
            while (!isRequestAbort()) {
                long checkHtmlM3u8 = checkHtmlM3u8(aPIResult.ret, 1, str);
                aPIResult.ret = checkHtmlM3u8;
                if (checkHtmlM3u8 < 0 || (blockReadThread = blockReadThread()) < 0 || (aPIResult = getSizeImplProxy(str)) == null || aPIResult.ret != -2018102640) {
                    break;
                }
                if (blockReadThread == 1 || isDataSourcePaused()) {
                    P2PDebugD(getLogTag(), "getSize isDataSourcePaused");
                    currentTimeMillis = System.currentTimeMillis();
                }
                currentTimeMillis += aPIResult.costMs;
                long currentTimeMillis2 = (System.currentTimeMillis() - currentTimeMillis) * 1000;
                if (isP2pTaskStart()) {
                    if (currentTimeMillis2 > this.mConfig.getReciveDataTimeOutUs()) {
                        if (this.mLastHttpError != null && !StringUtil.isEmpty(this.mLastHttpError.url)) {
                            String fileName = UrlUtil.getFileName(this.mLastHttpError.url);
                            String fileName2 = UrlUtil.getFileName(str);
                            P2PDebugD(getLogTag(), "getSize lastErrorName:" + fileName + ",targetName:" + fileName2);
                            if (!StringUtil.isEmpty(fileName) && !StringUtil.isEmpty(fileName2)) {
                                fileName.equals(fileName2);
                            }
                        }
                        long checkM3u8SizeError = checkM3u8SizeError(1, str);
                        if (checkM3u8SizeError < 0) {
                            callbackOnSourceInfoUpdate();
                            return checkM3u8SizeError;
                        }
                        DebugLog.i(getLogTag(), "getSize out error_code:-2018102642");
                        callbackOnSourceInfoUpdate();
                        return -2018102642L;
                    }
                } else if (currentTimeMillis2 > 10000000) {
                    ImgoP2pTask imgoP2pTask = this.mP2pTask;
                    int convertTaskStatusCode = (imgoP2pTask != null ? convertTaskStatusCode(imgoP2pTask.getStatus()) : 9) + 9130;
                    DebugLog.i(getLogTag(), "getSize out" + convertTaskStatusCode);
                    long convertPlayerErrorCodeGetSize = convertPlayerErrorCodeGetSize(9, convertTaskStatusCode);
                    callbackOnSourceInfoUpdate();
                    return convertPlayerErrorCodeGetSize;
                }
                try {
                    this.mLockObj.wait(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                aPIResult.clean();
            }
            if (isRequestAbort()) {
                DebugLog.i(getLogTag(), "getSize out-2018111410");
                callbackOnSourceInfoUpdate();
                return -2018111410L;
            }
            P2PDebugD(getLogTag(), "getSize out ret:" + aPIResult.ret);
            long j = aPIResult.ret;
            callbackOnSourceInfoUpdate();
            return j;
        }
    }

    @Override // com.hunantv.media.player.libnative.IMGTVMediaDataSource
    public int getVideoSourceType() {
        return this.mVideoSourceType;
    }

    public boolean isP2pTaskStart() {
        ImgoP2pTask imgoP2pTask = this.mP2pTask;
        return imgoP2pTask != null && imgoP2pTask.getStatus() == 0;
    }

    public boolean isRequestAbort() {
        return this.mRequestAbort;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x013e, code lost:
        r11 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0145, code lost:
        if (isRequestAbort() == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0147, code lost:
        com.hunantv.media.player.pragma.DebugLog.i(getLogTag(), "readAt out-2018111410");
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0154, code lost:
        return -2018111410;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0155, code lost:
        r0 = getLogTag();
        P2PDebugD(r0, "readAt out ret:" + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x016e, code lost:
        return r11;
     */
    @Override // com.hunantv.media.player.libnative.IMGTVMediaDataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readAt(java.lang.String r20, byte[] r21, long r22, long r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.player.datasource.p2p.MGTVP2pDirectMediaDataSource.readAt(java.lang.String, byte[], long, long):long");
    }

    @Override // com.hunantv.media.player.libnative.IMGTVMediaDataSource
    public void release() {
        DebugLog.i(getLogTag(), "release in");
        this.mRequestAbort = true;
        synchronized (this.mLockObj) {
            this.mLockObj.notifyAll();
        }
        this.mLastHttpError = null;
        this.mLastM3u8Entity = null;
        ImgoP2pManager.getInstance().removeNotifyListener(this.mOnNotifyMsgListener);
        DebugLog.i(getLogTag(), "release out");
    }

    @Override // com.hunantv.media.player.libnative.IMGTVMediaDataSource
    public void setInfoListener(IMGTVMediaDataSource.IInfoListener iInfoListener) {
        this.mInfoListener = iInfoListener;
    }

    @Override // com.hunantv.media.player.libnative.IMGTVMediaDataSource
    public void setLogTag(String str) {
        this.mTagStr = str;
    }

    public void setP2pTask(ImgoP2pTask imgoP2pTask) {
        this.mP2pTask = imgoP2pTask;
        if (imgoP2pTask != null) {
            ImgoP2pManager.getInstance().removeNotifyListener(this.mOnNotifyMsgListener);
            ImgoP2pManager.getInstance().addNotifyListener(this.mOnNotifyMsgListener);
        }
    }
}
