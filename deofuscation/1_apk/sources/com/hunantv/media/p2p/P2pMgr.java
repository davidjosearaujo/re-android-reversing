package com.hunantv.media.p2p;

import com.hunantv.media.player.MgtvMediaPlayer;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.player.utils.StringUtil;
import com.mgtv.easydatasource.p2p.ImgoP2pManager;
import com.mgtv.easydatasource.p2p.ImgoTaskInfo;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class P2pMgr {
    public static final String PROXY_TAG_P2P_MGTV = "/mghttpagent/";
    public static final String PROXY_TAG_P2P_YUNFAN = "/yfhttpagent/";
    private static final String TAG = "P2pMgr";

    public static void YfAddBackupIps(String str, List<String> list, boolean z) {
        DebugLog.i(TAG, "YfAddBackupIps " + str + "-" + MgtvMediaPlayer.IPList.formatIPList(list) + "-" + z);
    }

    public static String getCdnIpFromP2PTask(IP2pTask iP2pTask) {
        ImgoTaskInfo taskInfo = getTaskInfo(iP2pTask);
        return taskInfo != null ? taskInfo.cdnIp : "n";
    }

    public static String getCdnIpFromSourceInfo(Object obj) {
        return obj instanceof ImgoTaskInfo ? ((ImgoTaskInfo) obj).cdnIp : "n";
    }

    public static ImgoTaskInfo getTaskInfo(IP2pTask iP2pTask) {
        if (iP2pTask != null && P2pTaskFactory.sP2pClassExist) {
            return ImgoP2pManager.getInstance().getTaskInfo(iP2pTask.getImgoTask());
        }
        return null;
    }

    public static boolean isMgP2p() {
        return true;
    }

    public static boolean isMgProxyP2p(String str) {
        return isProxyP2p(str, PROXY_TAG_P2P_MGTV);
    }

    public static boolean isProxyP2p(String str, String str2) {
        return !StringUtil.isEmpty(str) && str.contains(str2);
    }

    public static boolean isTaskExist(IP2pTask iP2pTask) {
        return iP2pTask != null && P2pTaskFactory.sP2pClassExist && ImgoP2pManager.getInstance().isTaskExist(iP2pTask.getImgoTask()) == 0;
    }

    public static int isTaskExistInt(IP2pTask iP2pTask) {
        if (iP2pTask != null && P2pTaskFactory.sP2pClassExist) {
            return ImgoP2pManager.getInstance().isTaskExist(iP2pTask.getImgoTask());
        }
        return -1;
    }

    public static boolean isYfProxyP2p(String str) {
        return isProxyP2p(str, PROXY_TAG_P2P_YUNFAN);
    }

    public static synchronized void setPlaySpeed(float f) {
        synchronized (P2pMgr.class) {
            if (P2pTaskFactory.sP2pClassExist && f > 0.0f) {
                DebugLog.i(TAG, "setPlaySpeed playSpeed:" + f);
                ImgoP2pManager.getInstance().setPlaySpeed((int) (f * 100.0f));
            }
        }
    }

    public static synchronized void setPlayingTimepoint(IP2pTask iP2pTask, int i, boolean z) {
        synchronized (P2pMgr.class) {
            if (P2pTaskFactory.sP2pClassExist && iP2pTask != null) {
                DebugLog.i(TAG, "setPlayingTimepoint timepoint:" + i + ",bSeek:" + z);
                ImgoP2pManager.getInstance().setPlayingTimepoint(iP2pTask.getImgoTask(), i, z);
            }
        }
    }

    public static void startLog() {
        if (P2pTaskFactory.sP2pClassExist) {
            ImgoP2pManager.getInstance().startLog();
        }
    }
}
