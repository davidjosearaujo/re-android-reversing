package a2;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.Os;
import java.io.FileDescriptor;
import java.io.Serializable;

/* renamed from: a2.b */
/* loaded from: classes.dex */
public final class IOWrapper {

    /* renamed from: a2.b$a */
    /* loaded from: classes.dex */
    public static class FileDescriptorWrapper {
        /* renamed from: a */
        public static void close(FileDescriptor fileDescriptor) {
            Os.close(fileDescriptor);
        }

        /* renamed from: b */
        public static FileDescriptor duplicate(FileDescriptor fileDescriptor) {
            return Os.dup(fileDescriptor);
        }

        /* renamed from: c */
        public static long seek(FileDescriptor fileDescriptor, long j5, int i7) {
            return Os.lseek(fileDescriptor, j5, i7);
        }
    }

    /* renamed from: a2.b$b */
    /* loaded from: classes.dex */
    public static class DataSourceSetter {
        /* renamed from: a */
        public static void setDataSource(MediaMetadataRetriever mediaMetadataRetriever, MediaDataSource mediaDataSource) {
            mediaMetadataRetriever.setDataSource(mediaDataSource);
        }
    }

    /* renamed from: a */
    public static String ByteArrayToString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int iter = 0; iter < bArr.length; iter++) {
            sb.append(String.format("%02x", Byte.valueOf(bArr[iter])));
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static long[] toLongArrSerialization(Serializable serializable) {
        if (!(serializable instanceof int[])) {
            if (serializable instanceof long[]) {
                return (long[]) serializable;
            }
            return null;
        }
        int[] iArr = (int[]) serializable;
        long[] jArr = new long[iArr.length];
        for (int iter = 0; iter < iArr.length; iter++) {
            jArr[iter] = iArr[iter];
        }
        return jArr;
    }
}
