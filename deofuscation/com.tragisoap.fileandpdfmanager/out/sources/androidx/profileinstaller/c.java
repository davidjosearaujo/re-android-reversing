package androidx.profileinstaller;

import android.content.pm.PackageInfo;
import android.util.Log;
import com.davemorrissey.labs.subscaleview.R;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import linc.com.amplituda.ErrorCode;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c {

    /* renamed from: a */
    public static final a f1914a = new a();

    /* renamed from: b */
    public static final b f1915b = new b();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements AbstractC0019c {
        @Override // androidx.profileinstaller.c.AbstractC0019c
        public final void a() {
        }

        @Override // androidx.profileinstaller.c.AbstractC0019c
        public final void b(int i7, Object obj) {
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b implements AbstractC0019c {
        @Override // androidx.profileinstaller.c.AbstractC0019c
        public final void a() {
            Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
        }

        @Override // androidx.profileinstaller.c.AbstractC0019c
        public final void b(int i7, Object obj) {
            String str;
            switch (i7) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case 9:
                default:
                    str = "";
                    break;
                case ErrorCode.FRAME_ALLOC_CODE /* 10 */:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case ErrorCode.PACKET_ALLOC_CODE /* 11 */:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
            }
            if (i7 == 6 || i7 == 7 || i7 == 8) {
                Log.e("ProfileInstaller", str, (Throwable) obj);
            } else {
                Log.d("ProfileInstaller", str);
            }
        }
    }

    /* renamed from: androidx.profileinstaller.c$c */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface AbstractC0019c {
        void a();

        void b(int i7, Object obj);
    }

    public static void a(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            dataOutputStream.writeLong(packageInfo.lastUpdateTime);
            dataOutputStream.close();
        } catch (IOException unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x01d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01d1 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r1v2, types: [byte[], f2.b[]] */
    /* JADX WARN: Type inference failed for: r2v10, types: [byte[], f2.b[]] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Unknown variable types count: 3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(android.content.Context r15, k.a r16, androidx.profileinstaller.c.AbstractC0019c r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 738
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.c.b(android.content.Context, k.a, androidx.profileinstaller.c$c, boolean):void");
    }
}
