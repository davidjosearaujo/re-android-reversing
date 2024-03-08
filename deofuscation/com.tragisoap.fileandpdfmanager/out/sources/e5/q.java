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
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class q extends AsyncTask<Void, Void, List<HashMap<String, String>>> {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<FileManagerItemActivity> f3853a;

    public q(FileManagerItemActivity fileManagerItemActivity) {
        this.f3853a = new WeakReference<>(fileManagerItemActivity);
    }

    @Override // android.os.AsyncTask
    public final List<HashMap<String, String>> doInBackground(Void[] voidArr) {
        String str;
        FileManagerItemActivity fileManagerItemActivity = this.f3853a.get();
        if (fileManagerItemActivity == null || fileManagerItemActivity.isFinishing()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Cursor query = fileManagerItemActivity.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"_data", "_size", "date_added"}, "_data LIKE '%.pdf'", null, "date_added DESC");
        if (query == null) {
            return arrayList;
        }
        int columnIndex = query.getColumnIndex("_data");
        int columnIndex2 = query.getColumnIndex("_size");
        int columnIndex3 = query.getColumnIndex("date_added");
        while (query.moveToNext()) {
            String string = query.getString(columnIndex);
            long j7 = query.getLong(columnIndex2);
            String format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.getDefault()).format(Long.valueOf(query.getLong(columnIndex3) * 1000));
            HashMap hashMap = new HashMap();
            hashMap.put("mediaPath", string);
            hashMap.put("mediaName", new File(string).getName());
            if (j7 <= 0) {
                str = "0";
                columnIndex2 = columnIndex2;
                columnIndex3 = columnIndex3;
            } else {
                double d7 = (double) j7;
                int log10 = (int) (Math.log10(d7) / Math.log10(1024.0d));
                columnIndex2 = columnIndex2;
                columnIndex3 = columnIndex3;
                str = String.format(Locale.US, "%.2f %s", Double.valueOf(d7 / Math.pow(1024.0d, (double) log10)), new String[]{"B", "KB", "MB", "GB", "TB"}[log10]);
            }
            hashMap.put("mediaSize", str);
            hashMap.put("mediaDate", format);
            arrayList.add(hashMap);
        }
        query.close();
        return arrayList;
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(List<HashMap<String, String>> list) {
        List<HashMap<String, String>> list2 = list;
        super.onPostExecute(list2);
        FileManagerItemActivity fileManagerItemActivity = this.f3853a.get();
        if (fileManagerItemActivity != null && !fileManagerItemActivity.isFinishing() && list2 != null) {
            TextView textView = FileManagerItemActivity.M;
        }
    }
}
