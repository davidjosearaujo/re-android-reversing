package com.hunantv.media.drm.utils;

import android.media.MediaDrm;
import android.os.Build;
import android.util.Log;
import com.google.gson.Gson;
import com.hunantv.media.drm.MgtvDrmConstans;
import com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass;
import com.hunantv.media.player.pragma.DebugLog;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgtvDrmUtils {
    private static final String TAG = "CencDrmUtils";
    public static final Map<UUID, String> sCommercialDrmSolutionValueMap = new HashMap<UUID, String>() { // from class: com.hunantv.media.drm.utils.MgtvDrmUtils.1
        {
            put(MgtvDrmConstans.MARLIN_UUID, "5");
            put(MgtvDrmConstans.WIDEVINE_UUID, "2");
            put(MgtvDrmConstans.CHINADRM_UUID, "4");
        }
    };
    public static final Map<UUID, String> sNonCommercialDrmSolutionValueMap = new HashMap<UUID, String>() { // from class: com.hunantv.media.drm.utils.MgtvDrmUtils.2
        {
            put(MgtvDrmConstans.CHINADRM_UUID, "6");
        }
    };
    public static Map<UUID, Boolean> sDrmSupportMapCache = new HashMap();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class PSSH {
        public byte[] data;
        public List key_ids = new LinkedList();
        public byte[] rawData;
        public byte[] system_id;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class WisePlayPsshJson {
        public String contentID;
        public String enschema;
        public String exts;
        public List<String> kids;
        public String playIndex;
        public String version;

        private WisePlayPsshJson() {
        }
    }

    private static String arrToHex(byte[] bArr) {
        String str = "0x";
        for (int i = 0; i < bArr.length; i++) {
            str = str + String.format("%02x", Byte.valueOf(bArr[i]));
        }
        return str;
    }

    private static UUID bytesToUUID(byte[] bArr) {
        long j = 0;
        long j2 = 0;
        for (int i = 0; i < 8; i++) {
            int i2 = (7 - i) * 8;
            j |= (bArr[i] & 255) << i2;
            j2 |= (bArr[i + 8] & 255) << i2;
        }
        return new UUID(j, j2);
    }

    public static byte[] createPsshRawData(PSSH pssh) {
        byte[] bArr;
        byte[] bArr2;
        if (pssh == null || (bArr = pssh.system_id) == null || (bArr2 = pssh.data) == null) {
            return null;
        }
        int length = bArr.length + 12 + 4 + bArr2.length;
        byte[] bArr3 = new byte[length];
        ByteBuffer wrap = ByteBuffer.wrap(bArr3);
        wrap.putInt(length);
        byte[] bytes = "pssh".getBytes();
        wrap.put(bytes, 0, bytes.length);
        wrap.putInt(0);
        byte[] bArr4 = pssh.system_id;
        wrap.put(bArr4, 0, bArr4.length);
        wrap.putInt(pssh.data.length);
        byte[] bArr5 = pssh.data;
        wrap.put(bArr5, 0, bArr5.length);
        return bArr3;
    }

    public static String drmt2DrmTypeStr(String str) {
        str.hashCode();
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c = 2;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c = 3;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c = 4;
                    break;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    c = 5;
                    break;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    c = 6;
                    break;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "清流";
            case 1:
                return "marlin DRM";
            case 2:
                return "wiseplay DRM";
            case 3:
                return "marlin cbcs DRM";
            case 4:
                return "widevine DRM";
            case 5:
                return "Fairplay DRM";
            case 6:
                return "PlayReady DRM";
            case 7:
                return "LightPlay DRM";
            default:
                return "n";
        }
    }

    public static boolean isCryptoSchemeSupported(UUID uuid) {
        try {
            if (sDrmSupportMapCache.containsKey(uuid)) {
                return sDrmSupportMapCache.get(uuid).booleanValue();
            }
            if (Build.VERSION.SDK_INT < 18 || uuid == null) {
                return false;
            }
            boolean isCryptoSchemeSupported = MediaDrm.isCryptoSchemeSupported(uuid);
            sDrmSupportMapCache.put(uuid, Boolean.valueOf(isCryptoSchemeSupported));
            return isCryptoSchemeSupported;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean isWidevineSupport() {
        return Build.VERSION.SDK_INT >= 28 && isCryptoSchemeSupported(MgtvDrmConstans.WIDEVINE_UUID);
    }

    public static Map<UUID, PSSH> parsePSSH(byte[] bArr) {
        ByteBuffer wrap;
        if (bArr == null || bArr.length < 16) {
            DebugLog.e(TAG, "parsePSSH invalid pssh");
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            wrap = ByteBuffer.wrap(bArr);
            int i = wrap.getInt();
            DebugLog.i(TAG, "pssh_size_bytes: " + i);
        } catch (Exception unused) {
            return null;
        }
        while (wrap.remaining() > 0) {
            PSSH pssh = new PSSH();
            if (wrap.remaining() < 16) {
                Log.w(TAG, "parsePSSH: len is too short to parse UUID: (" + wrap.remaining() + " < 16)");
                return null;
            }
            int i2 = wrap.getInt();
            int i3 = wrap.getInt();
            int i4 = wrap.getInt();
            int i5 = wrap.getInt();
            byte[] bArr2 = new byte[i2];
            pssh.system_id = bArr2;
            wrap.get(bArr2);
            for (int i6 = 0; i6 < i3; i6++) {
                byte[] bArr3 = new byte[i4];
                wrap.get(bArr3);
                pssh.key_ids.add(bArr3);
            }
            byte[] bArr4 = new byte[i5];
            pssh.data = bArr4;
            wrap.get(bArr4);
            pssh.rawData = createPsshRawData(pssh);
            if (i2 == 16) {
                UUID bytesToUUID = bytesToUUID(pssh.system_id);
                if (MgtvDrmConstans.CHINADRM_UUID.equals(bytesToUUID)) {
                    DebugLog.i(TAG, "this is wiseplay uuid parse it");
                    pssh.key_ids.clear();
                    pssh.key_ids = ((WisePlayPsshJson) new Gson().fromJson(new String(pssh.data), WisePlayPsshJson.class)).kids;
                } else if (MgtvDrmConstans.WIDEVINE_UUID.equals(bytesToUUID)) {
                    DebugLog.i(TAG, "this is widevine uuid parse it");
                    pssh.key_ids.clear();
                    WidevinePsshDataOuterClass.WidevinePsshData parseFrom = WidevinePsshDataOuterClass.WidevinePsshData.parseFrom(pssh.data);
                    if (parseFrom != null && parseFrom.getKeyIdCount() > 0) {
                        for (int i7 = 0; i7 < parseFrom.getKeyIdCount(); i7++) {
                            if (parseFrom.getKeyId(i7) != null) {
                                pssh.key_ids.add(parseFrom.getKeyId(i7).toByteArray());
                            }
                        }
                    }
                } else if (MgtvDrmConstans.MARLIN_UUID.equals(bytesToUUID)) {
                    try {
                        DebugLog.i(TAG, "this is marlin uuid parse it");
                        pssh.key_ids.clear();
                        ByteBuffer wrap2 = ByteBuffer.wrap(pssh.data);
                        wrap2.position(28);
                        byte[] bArr5 = new byte[i4];
                        wrap2.get(bArr5);
                        pssh.key_ids.add(bArr5);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                hashMap.put(bytesToUUID, pssh);
            }
            return null;
        }
        return hashMap;
    }
}
