package e5;

import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.widget.TextView;
import com.tragisoap.fileandpdfmanager.FileManagerItemActivity;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class q extends AsyncTask<Void, Void, List<HashMap<String, String>>> {

    /* renamed from: a */
    public final WeakReference<FileManagerItemActivity> f3853a;

    public q(FileManagerItemActivity fileManagerItemActivity) {
        this.f3853a = new WeakReference<>(fileManagerItemActivity);
    }

    @Override // android.os.AsyncTask
    public final List<HashMap<String, String>> doInBackground(Void[] voidArr) {
        int i7;
        int i8;
        String format;
        FileManagerItemActivity fileManagerItemActivity = this.f3853a.get();
        if (fileManagerItemActivity == null || fileManagerItemActivity.isFinishing()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Cursor query = fileManagerItemActivity.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"_data", "_size", "date_added"}, "_data LIKE '%.pdf'", null, "date_added DESC");
        if (query != null) {
            int columnIndex = query.getColumnIndex("_data");
            int columnIndex2 = query.getColumnIndex("_size");
            int columnIndex3 = query.getColumnIndex("date_added");
            while (query.moveToNext()) {
                String string = query.getString(columnIndex);
                long j5 = query.getLong(columnIndex2);
                String format2 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.getDefault()).format(Long.valueOf(query.getLong(columnIndex3) * 1000));
                HashMap hashMap = new HashMap();
                hashMap.put("mediaPath", string);
                hashMap.put("mediaName", new File(string).getName());
                if (j5 <= 0) {
                    format = "0";
                    i7 = columnIndex2;
                    i8 = columnIndex3;
                } else {
                    double d7 = j5;
                    int log10 = (int) (Math.log10(d7) / Math.log10(1024.0d));
                    i7 = columnIndex2;
                    i8 = columnIndex3;
                    format = String.format(Locale.US, "%.2f %s", Double.valueOf(d7 / Math.pow(1024.0d, log10)), new String[]{"B", "KB", "MB", "GB", "TB"}[log10]);
                }
                hashMap.put("mediaSize", format);
                hashMap.put("mediaDate", format2);
                arrayList.add(hashMap);
                columnIndex2 = i7;
                columnIndex3 = i8;
            }
            query.close();
            return arrayList;
        }
        return arrayList;
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(List<HashMap<String, String>> list) {
        List<HashMap<String, String>> list2 = list;
        super.onPostExecute(list2);
        FileManagerItemActivity fileManagerItemActivity = this.f3853a.get();
        if (fileManagerItemActivity == null || fileManagerItemActivity.isFinishing() || list2 == null) {
            return;
        }
        TextView textView = FileManagerItemActivity.M;
    }
}
