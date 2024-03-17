package com.hunantv.media.player.loader;

import a.a.a.a.p.c;
import android.content.Context;
import com.hunantv.media.player.helper.BuildHelper;
import com.hunantv.media.player.pragma.DebugLog;
import java.io.File;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ImgoLibLoader {
    private static final String LIB_NAME_CACHE = "ImgoCache";
    private static final String LIB_NAME_CPP_SHARED = "c++_shared";
    private static final String LIB_NAME_DS = "Imgods";
    private static final String LIB_NAME_EXS = "Imgoexs";
    private static final String LIB_NAME_FFMEPG = "ImgoFfmpeg";
    private static final String LIB_NAME_FFMEPG4 = "ImgoFfmpeg4";
    private static final String LIB_NAME_HELP = "ImgoHelp";
    private static final String LIB_NAME_IMGOHAND = "ImgoHand";
    private static final String LIB_NAME_IMGOHAND_JNI = "ImgoHand_jni";
    private static final String LIB_NAME_IMGOVSR = "ImgoVsr";
    private static final String LIB_NAME_MGTV_DRM = "mgtvdrm";
    private static final String LIB_NAME_NPU_HIAI = "hiai";
    private static final String LIB_NAME_NPU_HIAI_HCL_MODEL_RUNTIME = "hiai_hcl_model_runtime";
    private static final String LIB_NAME_NPU_HIAI_IR = "hiai_ir";
    private static final String LIB_NAME_NPU_HIAI_IR_BUILD = "hiai_ir_build";
    private static final String LIB_NAME_OPENSSL_CRYPT_1_0 = "crypto";
    private static final String LIB_NAME_OPENSSL_CRYPT_1_1 = "crypto.1.1";
    private static final String LIB_NAME_OPENSSL_SSL_1_0 = "ssl";
    private static final String LIB_NAME_OPENSSL_SSL_1_1 = "ssl.1.1";
    private static final String LIB_NAME_PLAYER_DRM_PRE = "ImgoMediaPlayer_drm_";
    private static final String LIB_NAME_PLAYER_NODRM_PRE = "ImgoMediaPlayer_nodrm_";
    private static final String LIB_NAME_PLAYER_NODS_PRE = "ImgoMediaPlayer_nods_";
    private static final String LIB_NAME_PLAYER_PRE = "ImgoMediaPlayer_";
    private static final String LIB_NAME_WANOS_DECODER = "wanosdecoder";
    private static final String LIB_NAME_WANOS_VIRTUAL = "wanosvirtual";
    private static final String LIB_NAME_WANOS_VIRTUALV2 = "wanosvirtualV2";
    private static final String LIB_NAME_WASABI_DRM = "WasabiJni";
    private static final String TAG = "ImgoLibLoader";
    private static volatile String sInjectLibDirectory = null;
    private static IInjectorCallback sInjectorCallback = null;
    private static ImgoLibLoader sInstance = null;
    private static int useOpensslVersion = 2;
    private String mDsLibLoadErrorMsg;
    private volatile boolean mIsAllPlayerLibLoaded = false;
    private volatile boolean mIsHelpLibLoaded = false;
    private volatile boolean mIsDsLibLoaded = false;
    private volatile boolean mIsCacheLibLoaded = false;
    private volatile boolean mIsWanosDecoderLibLoaded = false;
    private volatile boolean mIsWanosVirtualLibLoaded = false;
    private volatile boolean mIsFFmpegLibLoaded = false;
    private volatile boolean mIsExsLibLoaded = false;
    private volatile boolean mIsWasabiDrmLibLoaded = false;
    private volatile boolean mIsMgtvDrmLibLoaded = false;
    private volatile boolean mIsOpenSSLLibLoaded = false;
    private volatile boolean mIsCPPSharedLibLoaded = false;
    private volatile boolean mIsImgoVsrNPULibLoaded = false;
    private volatile boolean mIsImgoVsrLibLoaded = false;
    private volatile boolean mIsImgoHandLibLoaded = false;
    private volatile boolean mIsImgoHandJniLibLoaded = false;
    private volatile boolean mIsPlayerLibLoaded = false;
    private volatile boolean mDsLibLoadError = false;
    private boolean mDsLibLoadErrorMsgReport = false;
    private String mDrmLibLoadErrorMsg = "n";
    private String mWanosLibLoadErrorMsg = "n";
    private String mCPPSharedLibLoadErrorMsg = "n";
    private String mImgoVsrNPULibLoadErrorMsg = "n";
    private String mImgoVsrLibLoadErrorMsg = "n";
    private Object mSync = new Object();
    private boolean mIsBackUpLoaderSuccess = false;
    private String mBackUpLoaderSoMsg = "";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface IInjectorCallback {
        String onInjectLibDirectory();

        void onLoadedLibMeta(String str);
    }

    private ImgoLibLoader() {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006c A[Catch: UnsatisfiedLinkError -> 0x0090, TRY_LEAVE, TryCatch #0 {UnsatisfiedLinkError -> 0x0090, blocks: (B:17:0x0065, B:19:0x006c), top: B:24:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void exLoadLibrary(android.content.Context r4, java.lang.String r5) throws java.lang.UnsatisfiedLinkError, java.lang.SecurityException, java.lang.NullPointerException, a.a.a.a.p.c {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "exLoadLibrary: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ImgoLibLoader"
            com.hunantv.media.player.pragma.DebugLog.i(r1, r0)
            java.lang.String r0 = ""
            r4.getApplicationInfo()     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L32 java.lang.UnsatisfiedLinkError -> L3e
            java.lang.String r2 = com.hunantv.media.player.utils.SystemUtil.getPrimaryCpuAbi(r4)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L32 java.lang.UnsatisfiedLinkError -> L3e
            boolean r2 = preInjectLoad(r2, r5)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L32 java.lang.UnsatisfiedLinkError -> L3e
            if (r2 == 0) goto L57
            return
        L26:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = "preInjectLoad Throwable "
            goto L49
        L32:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = "preInjectLoad Exception "
            goto L49
        L3e:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = "preInjectLoad UnsatisfiedLinkError "
        L49:
            r3.append(r0)
            java.lang.String r0 = c.a.a.a.m.b.c(r2)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
        L57:
            boolean r2 = com.hunantv.media.player.utils.StringUtil.isEmpty(r0)
            if (r2 != 0) goto L60
            com.hunantv.media.player.pragma.DebugLog.e(r1, r0)
        L60:
            java.lang.String r0 = "no preInjectLoad,use System.loadLibrary"
            com.hunantv.media.player.pragma.DebugLog.i(r1, r0)
            int r4 = c.a.a.a.m.b.a(r4, r5)     // Catch: java.lang.UnsatisfiedLinkError -> L90
            r0 = 2
            if (r4 != r0) goto L8f
            com.hunantv.media.player.loader.ImgoLibLoader r4 = getInstance()     // Catch: java.lang.UnsatisfiedLinkError -> L90
            r0 = 1
            r4.mIsBackUpLoaderSuccess = r0     // Catch: java.lang.UnsatisfiedLinkError -> L90
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.UnsatisfiedLinkError -> L90
            r4.<init>()     // Catch: java.lang.UnsatisfiedLinkError -> L90
            com.hunantv.media.player.loader.ImgoLibLoader r0 = getInstance()     // Catch: java.lang.UnsatisfiedLinkError -> L90
            java.lang.String r1 = r0.mBackUpLoaderSoMsg     // Catch: java.lang.UnsatisfiedLinkError -> L90
            r4.append(r1)     // Catch: java.lang.UnsatisfiedLinkError -> L90
            r4.append(r5)     // Catch: java.lang.UnsatisfiedLinkError -> L90
            java.lang.String r1 = "_"
            r4.append(r1)     // Catch: java.lang.UnsatisfiedLinkError -> L90
            java.lang.String r4 = r4.toString()     // Catch: java.lang.UnsatisfiedLinkError -> L90
            r0.mBackUpLoaderSoMsg = r4     // Catch: java.lang.UnsatisfiedLinkError -> L90
        L8f:
            return
        L90:
            r4 = move-exception
            a.a.a.a.p.c r0 = new a.a.a.a.p.c
            java.lang.String r4 = r4.getMessage()
            int r5 = mapID(r5)
            r0.<init>(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.player.loader.ImgoLibLoader.exLoadLibrary(android.content.Context, java.lang.String):void");
    }

    public static synchronized ImgoLibLoader getInstance() {
        ImgoLibLoader imgoLibLoader;
        synchronized (ImgoLibLoader.class) {
            if (sInstance == null) {
                sInstance = new ImgoLibLoader();
            }
            imgoLibLoader = sInstance;
        }
        return imgoLibLoader;
    }

    private static boolean isLegalFilePath(String str) throws SecurityException {
        if (str == null || "".equals(str.trim())) {
            return false;
        }
        File file = new File(str);
        return file.exists() && !file.isDirectory();
    }

    private static int mapID(String str) {
        if (str != null && !str.trim().equals("")) {
            if (str.startsWith(LIB_NAME_FFMEPG)) {
                return 100;
            }
            if (str.startsWith(LIB_NAME_HELP)) {
                return 101;
            }
            if (str.startsWith(LIB_NAME_DS)) {
                return 102;
            }
            if (str.startsWith(LIB_NAME_PLAYER_NODS_PRE)) {
                return 103;
            }
            if (str.startsWith(LIB_NAME_PLAYER_PRE)) {
                return 104;
            }
            if (str.startsWith("ImgoCache")) {
                return 105;
            }
            if (str.startsWith(LIB_NAME_PLAYER_NODRM_PRE)) {
                return 106;
            }
            if (str.startsWith(LIB_NAME_WANOS_DECODER)) {
                return 107;
            }
            if (str.startsWith(LIB_NAME_WANOS_VIRTUAL)) {
                return 108;
            }
            if (str.startsWith(LIB_NAME_WASABI_DRM)) {
                return 109;
            }
            if (str.startsWith(LIB_NAME_WANOS_VIRTUALV2)) {
                return 110;
            }
        }
        return 0;
    }

    private static boolean preInjectLoad(String str, String str2) throws SecurityException, UnsatisfiedLinkError, NullPointerException {
        if (sInjectLibDirectory != null && !sInjectLibDirectory.trim().isEmpty()) {
            File file = new File(sInjectLibDirectory);
            if (file.exists() && file.isDirectory()) {
                String str3 = file.getAbsolutePath() + "/" + str + "/" + System.mapLibraryName(str2);
                if (isLegalFilePath(str3)) {
                    System.load(str3);
                    DebugLog.i(TAG, "preInjectLoad load success:" + str3);
                    return true;
                }
                DebugLog.i(TAG, "preInjectLoad load failed:" + str3);
            }
        }
        return false;
    }

    public static void setsInjectorCallback(IInjectorCallback iInjectorCallback) {
        sInjectorCallback = iInjectorCallback;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean tryLoadAllLibraries(android.content.Context r3) throws java.lang.UnsatisfiedLinkError, java.lang.SecurityException, java.lang.NullPointerException, a.a.a.a.p.c {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.player.loader.ImgoLibLoader.tryLoadAllLibraries(android.content.Context):boolean");
    }

    private void tryLoadCPPSharedLib(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, c {
        if (this.mIsCPPSharedLibLoaded) {
            return;
        }
        exLoadLibrary(context, LIB_NAME_CPP_SHARED);
        this.mIsCPPSharedLibLoaded = true;
    }

    private void tryLoadCacheLib(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, c {
        if (this.mIsCacheLibLoaded) {
            return;
        }
        exLoadLibrary(context, "ImgoCache");
        this.mIsCacheLibLoaded = true;
    }

    private void tryLoadDsLib(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, c {
        if (this.mIsDsLibLoaded) {
            return;
        }
        exLoadLibrary(context, LIB_NAME_DS);
        this.mIsDsLibLoaded = true;
    }

    private void tryLoadExsLib(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, c {
        if (this.mIsExsLibLoaded) {
            return;
        }
        exLoadLibrary(context, LIB_NAME_EXS);
        this.mIsExsLibLoaded = true;
    }

    private void tryLoadFFmpeg20Lib(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, c {
        if (this.mIsFFmpegLibLoaded) {
            return;
        }
        exLoadLibrary(context, LIB_NAME_FFMEPG4);
        this.mIsFFmpegLibLoaded = true;
    }

    private void tryLoadFFmpegLib(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, c {
        tryLoadFFmpeg20Lib(context);
    }

    private void tryLoadHelpLib(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, c {
        if (this.mIsHelpLibLoaded) {
            return;
        }
        exLoadLibrary(context, LIB_NAME_HELP);
        this.mIsHelpLibLoaded = true;
    }

    private void tryLoadImgoHandJniLib(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, c {
        if (this.mIsImgoHandJniLibLoaded) {
            return;
        }
        exLoadLibrary(context, LIB_NAME_IMGOHAND_JNI);
        this.mIsImgoHandJniLibLoaded = true;
    }

    private void tryLoadImgoHandLib(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, c {
        if (this.mIsImgoHandLibLoaded) {
            return;
        }
        exLoadLibrary(context, LIB_NAME_IMGOHAND);
        this.mIsImgoHandLibLoaded = true;
    }

    private void tryLoadImgoVsrLib(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, c {
        if (this.mIsImgoVsrLibLoaded) {
            return;
        }
        if (BuildHelper.supportX86()) {
            DebugLog.e(TAG, "is X86, don't tryLoadImgoVsrLib!");
            return;
        }
        exLoadLibrary(context, LIB_NAME_IMGOVSR);
        this.mIsImgoVsrLibLoaded = true;
    }

    private void tryLoadImgoVsrNPULib(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, c {
        if (this.mIsImgoVsrNPULibLoaded) {
            return;
        }
        if (BuildHelper.supportX86()) {
            DebugLog.e(TAG, "is X86, don't tryLoadImgoVsrNPULib!");
            return;
        }
        exLoadLibrary(context, LIB_NAME_NPU_HIAI_IR);
        exLoadLibrary(context, LIB_NAME_NPU_HIAI_IR_BUILD);
        exLoadLibrary(context, LIB_NAME_NPU_HIAI_HCL_MODEL_RUNTIME);
        exLoadLibrary(context, LIB_NAME_NPU_HIAI);
        this.mIsImgoVsrNPULibLoaded = true;
    }

    private boolean tryLoadMgtvDrmLib(Context context) {
        if (useOpensslVersion == 2 && this.mIsOpenSSLLibLoaded && !this.mIsMgtvDrmLibLoaded) {
            exLoadLibrary(context, LIB_NAME_MGTV_DRM);
            this.mIsMgtvDrmLibLoaded = true;
        }
        return this.mIsMgtvDrmLibLoaded;
    }

    private void tryLoadMgtvDrmLibNoThrow(Context context) {
        try {
            tryLoadMgtvDrmLib(context);
        } catch (Error e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void tryLoadOpenSSLLib(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, c {
        String str;
        if (this.mIsOpenSSLLibLoaded) {
            return;
        }
        if (useOpensslVersion == 1) {
            exLoadLibrary(context, LIB_NAME_OPENSSL_CRYPT_1_0);
            str = LIB_NAME_OPENSSL_SSL_1_0;
        } else {
            exLoadLibrary(context, LIB_NAME_OPENSSL_CRYPT_1_1);
            str = LIB_NAME_OPENSSL_SSL_1_1;
        }
        exLoadLibrary(context, str);
        this.mIsOpenSSLLibLoaded = true;
    }

    private void tryLoadPlayer20Lib(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, c {
        if (this.mIsPlayerLibLoaded) {
            return;
        }
        exLoadLibrary(context, "ImgoMediaPlayer_5.5.5");
        this.mIsPlayerLibLoaded = true;
    }

    private void tryLoadPlayerLib(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, c {
        tryLoadPlayer20Lib(context);
    }

    private void tryLoadWanosDecoderLib(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, c {
        if (this.mIsWanosDecoderLibLoaded) {
            return;
        }
        exLoadLibrary(context, LIB_NAME_WANOS_DECODER);
        this.mIsWanosDecoderLibLoaded = true;
    }

    private void tryLoadWanosVirtualLib(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, c {
        if (this.mIsWanosVirtualLibLoaded) {
            return;
        }
        exLoadLibrary(context, LIB_NAME_WANOS_VIRTUAL);
        exLoadLibrary(context, LIB_NAME_WANOS_VIRTUALV2);
        this.mIsWanosVirtualLibLoaded = true;
    }

    private void tryLoadWasabiDrmLib(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, c {
        if (this.mIsWasabiDrmLibLoaded) {
            return;
        }
        exLoadLibrary(context, LIB_NAME_WASABI_DRM);
        this.mIsWasabiDrmLibLoaded = true;
    }

    public String getBackUpLoaderSoMsg() {
        return this.mBackUpLoaderSoMsg;
    }

    public String getDrmLibLoadErrorMsg() {
        return this.mDrmLibLoadErrorMsg;
    }

    public String getDsLibLoadErrorMsg() {
        return this.mDsLibLoadErrorMsg;
    }

    public boolean isAllPlayerLibLoaded() {
        return this.mIsAllPlayerLibLoaded;
    }

    public boolean isBackUpLoaderSuccess() {
        return this.mIsBackUpLoaderSuccess;
    }

    public boolean isCacheLibLoaded() {
        return this.mIsCacheLibLoaded;
    }

    public boolean isDsLibLoadError() {
        return this.mDsLibLoadError;
    }

    public boolean isDsLibLoadErrorMsgReport() {
        return this.mDsLibLoadErrorMsgReport;
    }

    public boolean isDsLibLoaded() {
        return this.mIsDsLibLoaded;
    }

    public boolean isFFmpegLibLoaded() {
        return this.mIsFFmpegLibLoaded;
    }

    public boolean isHelpLibLoaded() {
        return this.mIsHelpLibLoaded;
    }

    public boolean isMgtvDrmLibLoaded() {
        return this.mIsMgtvDrmLibLoaded;
    }

    public boolean isMgtvHandLibLoaded() {
        return this.mIsImgoHandJniLibLoaded;
    }

    public boolean isPlayerLibLoaded() {
        return this.mIsPlayerLibLoaded;
    }

    public boolean isWasabiDrmLibLoaded() {
        return this.mIsWasabiDrmLibLoaded;
    }

    public void setBackUpLoaderSuccess(boolean z) {
        this.mIsBackUpLoaderSuccess = z;
    }

    public void setDsLibLoadErrorMsgReport(boolean z) {
        this.mDsLibLoadErrorMsgReport = z;
    }

    public boolean syncTryLoadAllLibraries(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException {
        boolean tryLoadAllLibraries;
        synchronized (this.mSync) {
            tryLoadAllLibraries = tryLoadAllLibraries(context);
        }
        return tryLoadAllLibraries;
    }

    public boolean syncTryLoadDrmLib(Context context) {
        synchronized (this.mSync) {
            try {
                try {
                    tryLoadWasabiDrmLib(context);
                    return true;
                } catch (Error e) {
                    e.printStackTrace();
                    return false;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
    }

    public void syncTryLoadExsLib(Context context) {
        synchronized (this.mSync) {
            try {
                try {
                    tryLoadExsLib(context);
                } catch (Error e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean syncTryLoadFFmpegLib(Context context) {
        synchronized (this.mSync) {
            try {
                try {
                    tryLoadFFmpegLib(context);
                    return true;
                } catch (Error e) {
                    e.printStackTrace();
                    return false;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
    }

    public void syncTryLoadHandLib(Context context) {
        synchronized (this.mSync) {
            try {
                try {
                    tryLoadImgoHandLib(context);
                    tryLoadImgoHandJniLib(context);
                } catch (Error e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void syncTryLoadHelpLib(Context context) {
        synchronized (this.mSync) {
            try {
                try {
                    tryLoadHelpLib(context);
                } catch (Error e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean syncTryLoadMgtvDRMLib(Context context) {
        synchronized (this.mSync) {
            try {
                try {
                    tryLoadOpenSSLLib(context);
                    tryLoadMgtvDrmLib(context);
                    return this.mIsMgtvDrmLibLoaded;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return false;
                }
            } catch (Error e2) {
                e2.printStackTrace();
                return false;
            }
        }
    }

    public boolean syncTryLoadPlayerLib(Context context) {
        synchronized (this.mSync) {
            try {
                try {
                    tryLoadPlayerLib(context);
                    return true;
                } catch (Error e) {
                    e.printStackTrace();
                    return false;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
    }
}
