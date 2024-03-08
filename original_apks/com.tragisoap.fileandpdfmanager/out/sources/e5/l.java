package e5;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.d;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.davemorrissey.labs.subscaleview.R;
import com.tragisoap.fileandpdfmanager.PartFileManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l extends AsyncTask<Void, Void, List<HashMap<String, String>>> {

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ int f3826g = 0;

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<PartFileManager> f3827a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3828b;

    /* renamed from: c  reason: collision with root package name */
    public long f3829c = 0;

    /* renamed from: d  reason: collision with root package name */
    public ConstraintLayout f3830d;
    public ProgressBar e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f3831f;

    public l(PartFileManager partFileManager, String str, ProgressBar progressBar, TextView textView, ConstraintLayout constraintLayout) {
        this.f3827a = new WeakReference<>(partFileManager);
        this.f3828b = str;
        this.e = progressBar;
        this.f3831f = textView;
        this.f3830d = constraintLayout;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.AsyncTask
    public final List<HashMap<String, String>> doInBackground(Void[] voidArr) {
        char c7;
        char c8;
        String str;
        char c9;
        String[] strArr;
        String str2;
        String str3;
        String str4;
        String str5;
        l lVar = this;
        PartFileManager partFileManager = lVar.f3827a.get();
        if (partFileManager == null || partFileManager.isFinishing()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ContentResolver contentResolver = partFileManager.getContentResolver();
        String str6 = lVar.f3828b;
        str6.getClass();
        switch (str6.hashCode()) {
            case -2101383528:
                if (str6.equals("Images")) {
                    c7 = 0;
                    break;
                }
                c7 = 65535;
                break;
            case -1732810888:
                if (str6.equals("Videos")) {
                    c7 = 1;
                    break;
                }
                c7 = 65535;
                break;
            case -1347456360:
                if (str6.equals("Documents")) {
                    c7 = 2;
                    break;
                }
                c7 = 65535;
                break;
            case -978294581:
                if (str6.equals("Downloads")) {
                    c7 = 3;
                    break;
                }
                c7 = 65535;
                break;
            case -534622334:
                if (str6.equals("Compress")) {
                    c7 = 4;
                    break;
                }
                c7 = 65535;
                break;
            case 66044:
                if (str6.equals("Apk")) {
                    c7 = 5;
                    break;
                }
                c7 = 65535;
                break;
            case 79058:
                if (str6.equals("PDF")) {
                    c7 = 6;
                    break;
                }
                c7 = 65535;
                break;
            case 1972030333:
                if (str6.equals("Audios")) {
                    c7 = 7;
                    break;
                }
                c7 = 65535;
                break;
            default:
                c7 = 65535;
                break;
        }
        Uri contentUri = c7 != 0 ? c7 != 1 ? c7 != 7 ? MediaStore.Files.getContentUri("external") : MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : MediaStore.Video.Media.EXTERNAL_CONTENT_URI : MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] strArr2 = {"_data", "_size", "date_added"};
        String str7 = lVar.f3828b;
        str7.getClass();
        switch (str7.hashCode()) {
            case -2101383528:
                if (str7.equals("Images")) {
                    c8 = 0;
                    break;
                }
                c8 = 65535;
                break;
            case -1732810888:
                if (str7.equals("Videos")) {
                    c8 = 1;
                    break;
                }
                c8 = 65535;
                break;
            case -1347456360:
                if (str7.equals("Documents")) {
                    c8 = 2;
                    break;
                }
                c8 = 65535;
                break;
            case -978294581:
                if (str7.equals("Downloads")) {
                    c8 = 3;
                    break;
                }
                c8 = 65535;
                break;
            case -534622334:
                if (str7.equals("Compress")) {
                    c8 = 4;
                    break;
                }
                c8 = 65535;
                break;
            case 66044:
                if (str7.equals("Apk")) {
                    c8 = 5;
                    break;
                }
                c8 = 65535;
                break;
            case 79058:
                if (str7.equals("PDF")) {
                    c8 = 6;
                    break;
                }
                c8 = 65535;
                break;
            case 1972030333:
                if (str7.equals("Audios")) {
                    c8 = 7;
                    break;
                }
                c8 = 65535;
                break;
            default:
                c8 = 65535;
                break;
        }
        switch (c8) {
            case 0:
            case 1:
                str = "mime_type=? or mime_type=? or mime_type=?";
                break;
            case 2:
                str = "mime_type=? or mime_type=? or mime_type=? or mime_type=? or mime_type=? or mime_type=? or mime_type=?";
                break;
            case 3:
                str = "_data LIKE '" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + "/%' AND (_display_name GLOB '*.???' OR _display_name GLOB '*.??' OR _display_name GLOB '*.????')";
                break;
            case 4:
            case 7:
                str = "mime_type=? or mime_type=? or mime_type=? or mime_type=?";
                break;
            case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                str = "_data LIKE '%.apk'";
                break;
            case 6:
                str = "_data LIKE '%.pdf'";
                break;
            default:
                str = "";
                break;
        }
        String str8 = lVar.f3828b;
        str8.getClass();
        switch (str8.hashCode()) {
            case -2101383528:
                if (str8.equals("Images")) {
                    c9 = 0;
                    break;
                }
                c9 = 65535;
                break;
            case -1732810888:
                if (str8.equals("Videos")) {
                    c9 = 1;
                    break;
                }
                c9 = 65535;
                break;
            case -1347456360:
                if (str8.equals("Documents")) {
                    c9 = 2;
                    break;
                }
                c9 = 65535;
                break;
            case -534622334:
                if (str8.equals("Compress")) {
                    c9 = 3;
                    break;
                }
                c9 = 65535;
                break;
            case 1972030333:
                if (str8.equals("Audios")) {
                    c9 = 4;
                    break;
                }
                c9 = 65535;
                break;
            default:
                c9 = 65535;
                break;
        }
        switch (c9) {
            case 0:
                str5 = "image/jpeg";
                str4 = "image/png";
                str3 = "image/jpg";
                strArr = new String[]{str5, str4, str3};
                break;
            case 1:
                strArr = new String[]{"video/mp4", "video/avi"};
                break;
            case 2:
                strArr = new String[]{"application/msword", "application/vnd.ms-powerpoint", "application/rtf", "application/vnd.ms-excel", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.openxmlformats-officedocument.presentationml.presentation"};
                break;
            case 3:
                strArr = new String[]{"application/zip", "application/rar", "application/x-rar-compressed", "application/x-tar"};
                break;
            case 4:
                str5 = "audio/mpeg";
                str4 = "audio/mp3";
                str3 = "audio/ogg";
                strArr = new String[]{str5, str4, str3};
                break;
            default:
                strArr = null;
                break;
        }
        Cursor query = contentResolver.query(contentUri, strArr2, str, strArr, "date_added DESC");
        if (query != null) {
            int columnIndex = query.getColumnIndex("_data");
            int columnIndex2 = query.getColumnIndex("_size");
            int columnIndex3 = query.getColumnIndex("date_added");
            while (query.moveToNext()) {
                String string = query.getString(columnIndex);
                long j7 = query.getLong(columnIndex2);
                String format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.getDefault()).format(Long.valueOf(query.getLong(columnIndex3) * 1000));
                lVar.f3829c += j7;
                HashMap hashMap = new HashMap();
                hashMap.put("mediaPath", string);
                hashMap.put("mediaName", new File(string).getName());
                if (j7 <= 0) {
                    str2 = "0";
                    columnIndex2 = columnIndex2;
                    columnIndex3 = columnIndex3;
                } else {
                    double d7 = (double) j7;
                    int log10 = (int) (Math.log10(d7) / Math.log10(1024.0d));
                    columnIndex2 = columnIndex2;
                    columnIndex3 = columnIndex3;
                    str2 = String.format(Locale.US, "%.2f %s", Double.valueOf(d7 / Math.pow(1024.0d, (double) log10)), new String[]{"B", "KB", "MB", "GB", "TB"}[log10]);
                }
                hashMap.put("mediaSize", str2);
                hashMap.put("mediaDate", format);
                arrayList.add(hashMap);
                lVar = this;
            }
            query.close();
        }
        return arrayList;
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(List<HashMap<String, String>> list) {
        List<HashMap<String, String>> list2 = list;
        super.onPostExecute(list2);
        PartFileManager partFileManager = this.f3827a.get();
        if (partFileManager != null && !partFileManager.isFinishing() && list2 != null) {
            String str = this.f3828b;
            str.getClass();
            char c7 = 65535;
            switch (str.hashCode()) {
                case -2101383528:
                    if (str.equals("Images")) {
                        c7 = 0;
                        break;
                    }
                    break;
                case -1732810888:
                    if (str.equals("Videos")) {
                        c7 = 1;
                        break;
                    }
                    break;
                case -1347456360:
                    if (str.equals("Documents")) {
                        c7 = 2;
                        break;
                    }
                    break;
                case -978294581:
                    if (str.equals("Downloads")) {
                        c7 = 3;
                        break;
                    }
                    break;
                case -534622334:
                    if (str.equals("Compress")) {
                        c7 = 4;
                        break;
                    }
                    break;
                case 66044:
                    if (str.equals("Apk")) {
                        c7 = 5;
                        break;
                    }
                    break;
                case 79058:
                    if (str.equals("PDF")) {
                        c7 = 6;
                        break;
                    }
                    break;
                case 1972030333:
                    if (str.equals("Audios")) {
                        c7 = 7;
                        break;
                    }
                    break;
            }
            switch (c7) {
                case 0:
                    PartFileManager.P = list2;
                    break;
                case 1:
                    PartFileManager.Q = list2;
                    break;
                case 2:
                    PartFileManager.S = list2;
                    break;
                case 3:
                    PartFileManager.W = list2;
                    break;
                case 4:
                    PartFileManager.U = list2;
                    break;
                case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                    PartFileManager.T = list2;
                    break;
                case 6:
                    PartFileManager.V = list2;
                    break;
                case 7:
                    PartFileManager.R = list2;
                    break;
            }
            partFileManager.runOnUiThread(new d(14, this));
        }
    }
}
