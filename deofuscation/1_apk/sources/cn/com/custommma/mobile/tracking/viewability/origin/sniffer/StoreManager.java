package cn.com.custommma.mobile.tracking.viewability.origin.sniffer;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class StoreManager {
    private static final String SHAREDPREFERENCES_NAME = "viewability.explorer.pref";
    private Context mContext;

    public StoreManager(Context context) {
        Objects.requireNonNull(context, "StoreManager context can`t be null!");
        this.mContext = context;
    }

    public List<ViewAbilityExplorer> getAll() throws Exception {
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SHAREDPREFERENCES_NAME, 0);
        ArrayList arrayList = new ArrayList();
        for (String str : sharedPreferences.getAll().keySet()) {
            ViewAbilityExplorer viewAbilityExplorer = (ViewAbilityExplorer) getObject(sharedPreferences.getString(str, null), ViewAbilityExplorer.class);
            if (viewAbilityExplorer != null) {
                arrayList.add(viewAbilityExplorer);
            }
        }
        return arrayList;
    }

    public <T> T getObject(String str, Class<T> cls) {
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(str, 0));
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                } catch (StreamCorruptedException e) {
                    e = e;
                    objectInputStream = null;
                } catch (IOException e2) {
                    e = e2;
                    objectInputStream = null;
                } catch (ClassNotFoundException e3) {
                    e = e3;
                    objectInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    try {
                        byteArrayInputStream.close();
                        if (0 != 0) {
                            objectInputStream2.close();
                        }
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
                try {
                    T t = (T) objectInputStream.readObject();
                    try {
                        byteArrayInputStream.close();
                        objectInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    return t;
                } catch (StreamCorruptedException e6) {
                    e = e6;
                    e.printStackTrace();
                    byteArrayInputStream.close();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    return null;
                } catch (IOException e7) {
                    e = e7;
                    e.printStackTrace();
                    byteArrayInputStream.close();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    return null;
                } catch (ClassNotFoundException e8) {
                    e = e8;
                    e.printStackTrace();
                    byteArrayInputStream.close();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    return null;
                }
            } catch (IOException e9) {
                e9.printStackTrace();
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public synchronized void removeObject(String str) {
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(SHAREDPREFERENCES_NAME, 0).edit();
        edit.remove(str);
        edit.commit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void setObject(String str, Object obj) {
        ObjectOutputStream objectOutputStream;
        byte[] byteArray;
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SHAREDPREFERENCES_NAME, 0);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = 0;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(obj);
                    byteArray = byteArrayOutputStream.toByteArray();
                    String str2 = new String(Base64.encode(byteArray, 0));
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(str, str2);
                    edit.commit();
                } catch (IOException e) {
                    e = e;
                    objectOutputStream2 = objectOutputStream;
                    e.printStackTrace();
                    try {
                        byteArrayOutputStream.close();
                        objectOutputStream2 = objectOutputStream2;
                        if (objectOutputStream2 != null) {
                            objectOutputStream2.close();
                            objectOutputStream2 = objectOutputStream2;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream2 = objectOutputStream;
                    try {
                        byteArrayOutputStream.close();
                        if (objectOutputStream2 != null) {
                            objectOutputStream2.close();
                        }
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
            }
            try {
                byteArrayOutputStream.close();
                objectOutputStream.close();
                objectOutputStream2 = byteArray;
            } catch (IOException e5) {
                e = e5;
                e.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
