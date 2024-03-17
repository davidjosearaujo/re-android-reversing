package com.facebook.imageutils;

import com.alibaba.fastjson.asm.Opcodes;
import com.facebook.common.internal.Preconditions;
import com.hunantv.media.drm.IDrmSession;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class JfifUtil {
    public static final int APP1_EXIF_MAGIC = 1165519206;
    public static final int MARKER_APP1 = 225;
    public static final int MARKER_EOI = 217;
    public static final int MARKER_ESCAPE_BYTE = 0;
    public static final int MARKER_FIRST_BYTE = 255;
    public static final int MARKER_RST0 = 208;
    public static final int MARKER_RST7 = 215;
    public static final int MARKER_SOFn = 192;
    public static final int MARKER_SOI = 216;
    public static final int MARKER_SOS = 218;
    public static final int MARKER_TEM = 1;

    private JfifUtil() {
    }

    public static int getAutoRotateAngleFromOrientation(int i) {
        return TiffUtil.getAutoRotateAngleFromOrientation(i);
    }

    public static int getOrientation(byte[] bArr) {
        return getOrientation(new ByteArrayInputStream(bArr));
    }

    private static boolean isSOFn(int i) {
        switch (i) {
            case 192:
            case Opcodes.INSTANCEOF /* 193 */:
            case 194:
            case 195:
            case 197:
            case Opcodes.IFNULL /* 198 */:
            case Opcodes.IFNONNULL /* 199 */:
            case 201:
            case IDrmSession.ERROR_SESSION_PROVISION_PROVIDE_LICENSE_EXCEPTION /* 202 */:
            case IDrmSession.ERROR_SESSION_PROVISION_NO_SELECT_DRM /* 203 */:
            case IDrmSession.ERROR_SESSION_KEY_REQUEST_NULL /* 205 */:
            case IDrmSession.ERROR_SESSION_SELECT_DRM_NOT_SUPPORT /* 206 */:
            case IDrmSession.ERROR_SESSION_DRM_LICENSE_URL_EMPTY /* 207 */:
                return true;
            case 196:
            case 200:
            case IDrmSession.ERROR_SESSION_DRM_NULL /* 204 */:
            default:
                return false;
        }
    }

    private static int moveToAPP1EXIF(InputStream inputStream) throws IOException {
        int readPackedInt;
        if (moveToMarker(inputStream, MARKER_APP1) && (readPackedInt = StreamProcessor.readPackedInt(inputStream, 2, false) - 2) > 6) {
            int readPackedInt2 = StreamProcessor.readPackedInt(inputStream, 4, false);
            int readPackedInt3 = StreamProcessor.readPackedInt(inputStream, 2, false);
            int i = (readPackedInt - 4) - 2;
            if (readPackedInt2 == 1165519206 && readPackedInt3 == 0) {
                return i;
            }
        }
        return 0;
    }

    public static boolean moveToMarker(InputStream inputStream, int i) throws IOException {
        Preconditions.checkNotNull(inputStream);
        while (StreamProcessor.readPackedInt(inputStream, 1, false) == 255) {
            int i2 = MARKER_FIRST_BYTE;
            while (i2 == 255) {
                i2 = StreamProcessor.readPackedInt(inputStream, 1, false);
            }
            if ((i != 192 || !isSOFn(i2)) && i2 != i) {
                if (i2 != 216 && i2 != 1) {
                    if (i2 == 217 || i2 == 218) {
                        break;
                    }
                    inputStream.skip(StreamProcessor.readPackedInt(inputStream, 2, false) - 2);
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public static int getOrientation(InputStream inputStream) {
        try {
            int moveToAPP1EXIF = moveToAPP1EXIF(inputStream);
            if (moveToAPP1EXIF == 0) {
                return 0;
            }
            return TiffUtil.readOrientationFromTIFF(inputStream, moveToAPP1EXIF);
        } catch (IOException unused) {
            return 0;
        }
    }
}
