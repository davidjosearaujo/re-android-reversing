package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.c;
import f2.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.Executor;
import linc.com.amplituda.ErrorCode;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    public final AssetManager f1906a;

    /* renamed from: b */
    public final Executor f1907b;

    /* renamed from: c */
    public final c.InterfaceC0019c f1908c;

    /* renamed from: d */
    public final byte[] f1909d;
    public final File e;

    /* renamed from: f */
    public final String f1910f;

    /* renamed from: g */
    public boolean f1911g = false;

    /* renamed from: h */
    public f2.b[] f1912h;

    /* renamed from: i */
    public byte[] f1913i;

    public b(AssetManager assetManager, k.a aVar, c.InterfaceC0019c interfaceC0019c, String str, File file) {
        byte[] bArr;
        this.f1906a = assetManager;
        this.f1907b = aVar;
        this.f1908c = interfaceC0019c;
        this.f1910f = str;
        this.e = file;
        int i7 = Build.VERSION.SDK_INT;
        if (i7 <= 33) {
            switch (i7) {
                case ErrorCode.CODEC_NOT_FOUND_PROC_CODE /* 30 */:
                    bArr = f.f4110b;
                    break;
                case ErrorCode.STREAM_NOT_FOUND_PROC_CODE /* 31 */:
                case ErrorCode.STREAM_INFO_NOT_FOUND_PROC_CODE /* 32 */:
                case ErrorCode.CODEC_PARAMETERS_COPY_PROC_CODE /* 33 */:
                    bArr = f.f4109a;
                    break;
            }
            this.f1909d = bArr;
        }
        bArr = null;
        this.f1909d = bArr;
    }

    public final FileInputStream a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f1908c.a();
            }
            return null;
        }
    }
}
