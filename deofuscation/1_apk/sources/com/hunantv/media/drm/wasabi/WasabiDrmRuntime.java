package com.hunantv.media.drm.wasabi;

import com.hunantv.media.drm.MgtvDrmErrorCodeException;
import com.hunantv.media.player.pragma.DebugLog;
import com.intertrust.wasabi.ErrorCodeException;
import com.intertrust.wasabi.Runtime;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class WasabiDrmRuntime {
    private static final String TAG = "WasabiDrmRuntime";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Property {
        public static final int KEY_SPACE = 6;
        public static final int MS3_ACCEPT_HOSTNAME_MISMATCH = 2;
        public static final int MS3_ACCEPT_SELF_SIGNED_CERTS = 1;
        public static final int NEMO_DEVICE_ID = 7;
        public static final int PERSONALITY_NODE_ID = 8;
        public static final int PROXY_DASH_CONTENT_LENGTH = 4;
        public static final int ROOTED_OK = 5;
        public static final int STORAGE_DIRECTORY = 3;
        public static final int TLS_SESSION_ID_LIFETIME = 12;
        public static final int TLS_SESSION_TICKET_LIFETIME = 9;
        public static final int TLS_VERSION_MINOR_HIGH = 10;
        public static final int TLS_VERSION_MINOR_LOW = 11;
    }

    public static void checkLicense(String str) throws MgtvDrmErrorCodeException {
        try {
            Runtime.checkLicense(str);
        } catch (ErrorCodeException e) {
            throw new MgtvDrmErrorCodeException(e);
        }
    }

    public static Object getKeySpace() throws MgtvDrmErrorCodeException {
        try {
            return Runtime.getProperty(Runtime.Property.KEY_SPACE);
        } catch (ErrorCodeException e) {
            throw new MgtvDrmErrorCodeException(e);
        }
    }

    public static void initialize(String str) throws MgtvDrmErrorCodeException, NullPointerException {
        try {
            Runtime.initialize(str);
        } catch (ErrorCodeException e) {
            throw new MgtvDrmErrorCodeException(e);
        }
    }

    public static boolean isPersonalized() {
        return Runtime.isPersonalized();
    }

    private static Runtime.Property mapPropertyKey(int i) {
        switch (i) {
            case 1:
                return Runtime.Property.MS3_ACCEPT_SELF_SIGNED_CERTS;
            case 2:
                return Runtime.Property.MS3_ACCEPT_HOSTNAME_MISMATCH;
            case 3:
                return Runtime.Property.STORAGE_DIRECTORY;
            case 4:
                return Runtime.Property.PROXY_DASH_CONTENT_LENGTH;
            case 5:
                return Runtime.Property.ROOTED_OK;
            case 6:
                return Runtime.Property.KEY_SPACE;
            case 7:
                return Runtime.Property.NEMO_DEVICE_ID;
            case 8:
                return Runtime.Property.PERSONALITY_NODE_ID;
            case 9:
                return Runtime.Property.TLS_SESSION_TICKET_LIFETIME;
            case 10:
                return Runtime.Property.TLS_VERSION_MINOR_HIGH;
            case 11:
                return Runtime.Property.TLS_VERSION_MINOR_LOW;
            case 12:
                return Runtime.Property.TLS_SESSION_ID_LIFETIME;
            default:
                return null;
        }
    }

    public static void personalize() throws MgtvDrmErrorCodeException {
        try {
            Runtime.personalize();
        } catch (ErrorCodeException e) {
            throw new MgtvDrmErrorCodeException(e);
        }
    }

    public static void processServiceToken(String str) throws MgtvDrmErrorCodeException {
        try {
            Runtime.processServiceToken(str);
        } catch (ErrorCodeException e) {
            throw new MgtvDrmErrorCodeException(e);
        }
    }

    public static void setProperty(int i, Object obj) throws MgtvDrmErrorCodeException {
        try {
            DebugLog.i(TAG, "setProperty key=" + i + ", value=" + obj);
            Runtime.Property mapPropertyKey = mapPropertyKey(i);
            if (mapPropertyKey != null) {
                Runtime.setProperty(mapPropertyKey, obj);
            }
        } catch (ErrorCodeException e) {
            throw new MgtvDrmErrorCodeException(e);
        }
    }

    public static void shutdown() throws MgtvDrmErrorCodeException {
        try {
            Runtime.shutdown();
        } catch (ErrorCodeException e) {
            throw new MgtvDrmErrorCodeException(e);
        }
    }
}
