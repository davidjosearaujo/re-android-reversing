package com.hunantv.media.p2p;

import com.hunantv.media.utils.ClassUtil;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class P2pTaskFactory {
    public static final String P2P_MGR_CLASS_NAME = "com.mgtv.easydatasource.p2p.ImgoP2pManager";
    public static final String P2P_TASK_CLASS_NAME = "com.mgtv.easydatasource.p2p.ImgoP2pTask";
    public static final String P2P_TASK_INFO_CLASS_NAME = "com.mgtv.easydatasource.p2p.ImgoTaskInfo";
    public static final String TAG = "P2P";
    public static boolean sP2pClassChecked;
    public static boolean sP2pClassExist;

    static {
        checkP2pClass();
    }

    public static synchronized boolean checkP2pClass() {
        boolean z;
        synchronized (P2pTaskFactory.class) {
            if (!sP2pClassChecked) {
                sP2pClassExist = ClassUtil.isClassExist(P2P_TASK_CLASS_NAME) && ClassUtil.isClassExist(P2P_MGR_CLASS_NAME) && ClassUtil.isClassExist(P2P_TASK_INFO_CLASS_NAME);
                sP2pClassChecked = true;
            }
            z = sP2pClassExist;
        }
        return z;
    }

    public static IP2pTask create(Object obj) {
        checkP2pClass();
        if (obj == null || obj.getClass() == null || !P2P_TASK_CLASS_NAME.equals(obj.getClass().getName()) || !sP2pClassExist) {
            return null;
        }
        return P2pTask.build(obj);
    }
}
