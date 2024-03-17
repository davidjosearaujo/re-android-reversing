package com.hunantv.oversea.me.ui.profile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.hunantv.imgo.util.ThreadManager;
import com.hunantv.mpdt.data.EventClickData;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoImpl;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.model.TakePhotoOptions;
import com.jph.takephoto.uitl.ImageRotateUtil;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.e0;
import j.l.a.b0.r;
import j.l.c.e0.a.a.b;
import j.l.c.k.l.e.a0;
import j.l.c.k.l.e.l;
import j.l.c.k.l.e.m;
import j.l.c.k.l.e.v;
import j.l.c.k.l.e.w;
import j.l.c.k.l.e.x;
import j.l.c.k.l.e.y;
import j.l.c.k.l.e.z;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Locale;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MePhotoTaker implements TakePhoto.TakeResultListener {
    private static final int e = 500;
    private static final int f = 204800;
    private static String g;
    private static final /* synthetic */ c.b h = null;
    private static final /* synthetic */ c.b i = null;
    private static final /* synthetic */ c.b j = null;
    private static final /* synthetic */ c.b k = null;
    private static final /* synthetic */ c.b l = null;
    private static final /* synthetic */ c.b m = null;
    @Nullable
    private TakePhoto a;
    private AppCompatActivity b;
    private int c;
    private a d;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface a {
        void P();

        void U(String str);

        void x(String str);
    }

    static {
        a();
        g = null;
    }

    public MePhotoTaker(AppCompatActivity appCompatActivity) {
        this.b = appCompatActivity;
        StringBuilder sb = new StringBuilder();
        b.a();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        sb.append("/Android/data/");
        sb.append(appCompatActivity.getPackageName());
        sb.append("/cache");
        g = sb.toString();
    }

    private static /* synthetic */ void a() {
        e eVar = new e("MePhotoTaker.java", MePhotoTaker.class);
        h = eVar.H("method-execution", eVar.E("0", "shouldCallTakePhoto", "com.hunantv.oversea.me.ui.profile.MePhotoTaker", "int:int", "requestCode:resultCode", "", "boolean"), 97);
        i = eVar.H("method-execution", eVar.E("1", "onAvatarCamera", "com.hunantv.oversea.me.ui.profile.MePhotoTaker", "", "", "", "void"), 122);
        j = eVar.H("method-execution", eVar.E("1", "onAvatarGallery", "com.hunantv.oversea.me.ui.profile.MePhotoTaker", "", "", "", "void"), 132);
        k = eVar.H("method-execution", eVar.E("2", "getDestImageFile", "com.hunantv.oversea.me.ui.profile.MePhotoTaker", "", "", "", "java.io.File"), (int) EventClickData.u.N0);
        l = eVar.H("method-execution", eVar.E("2", "getTakePhoto", "com.hunantv.oversea.me.ui.profile.MePhotoTaker", "", "", "", "com.jph.takephoto.app.TakePhoto"), (int) Opcodes.DCMPL);
        m = eVar.H("method-execution", eVar.E("2", "rotateBitmap", "com.hunantv.oversea.me.ui.profile.MePhotoTaker", "java.lang.String:int", "path:degree", "", "void"), 228);
    }

    @NonNull
    private CropOptions b() {
        CropOptions.Builder builder = new CropOptions.Builder();
        builder.setAspectX(500).setAspectY(500);
        builder.setOutputX(500).setOutputY(500);
        builder.setWithOwnCrop(true);
        return builder.create();
    }

    public static final /* synthetic */ File c(MePhotoTaker mePhotoTaker, c cVar) {
        return new File(g, String.format(Locale.US, "mgtv-userHead-%d.jpg", Long.valueOf(System.currentTimeMillis())));
    }

    public static final /* synthetic */ TakePhoto d(MePhotoTaker mePhotoTaker, c cVar) {
        if (mePhotoTaker.a == null) {
            CompressConfig ofDefaultConfig = CompressConfig.ofDefaultConfig();
            ofDefaultConfig.setMaxSize(30720);
            ofDefaultConfig.setMaxPixel(150);
            mePhotoTaker.a = new TakePhotoImpl(mePhotoTaker.b, mePhotoTaker);
            TakePhotoOptions create = new TakePhotoOptions.Builder().create();
            create.setCorrectImage(true);
            mePhotoTaker.a.setTakePhotoOptions(create);
            mePhotoTaker.a.onEnableCompress(ofDefaultConfig, true);
        }
        return mePhotoTaker.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f(String str) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.U(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h(String str) {
        try {
            String a2 = r.a(str);
            int i2 = this.c;
            if (i2 != 0) {
                rotateBitmap(a2, i2);
                this.c = 0;
            }
            this.b.runOnUiThread(new m(this, a2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @WithTryCatchRuntime
    private File getDestImageFile() {
        return (File) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new z(new Object[]{this, e.v(k, this, this)}).e(69648));
    }

    @NonNull
    @WithTryCatchRuntime
    private TakePhoto getTakePhoto() {
        return (TakePhoto) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new a0(new Object[]{this, e.v(l, this, this)}).e(69648));
    }

    public static final /* synthetic */ void j(MePhotoTaker mePhotoTaker, c cVar) {
        File destImageFile = mePhotoTaker.getDestImageFile();
        if (!destImageFile.getParentFile().exists()) {
            destImageFile.getParentFile().mkdirs();
        }
        mePhotoTaker.getTakePhoto().onPickFromCaptureWithCrop(Uri.fromFile(destImageFile), mePhotoTaker.b());
    }

    public static final /* synthetic */ void k(MePhotoTaker mePhotoTaker, c cVar) {
        File destImageFile = mePhotoTaker.getDestImageFile();
        if (!destImageFile.getParentFile().exists()) {
            destImageFile.getParentFile().mkdirs();
        }
        mePhotoTaker.getTakePhoto().onPickFromGalleryWithCrop(Uri.fromFile(destImageFile), mePhotoTaker.b());
    }

    public static final /* synthetic */ void o(MePhotoTaker mePhotoTaker, String str, int i2, c cVar) {
        Bitmap rotateBitmapByDegree;
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (decodeFile == null || (rotateBitmapByDegree = ImageRotateUtil.rotateBitmapByDegree(decodeFile, i2)) == null) {
            return;
        }
        try {
            rotateBitmapByDegree.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(new File(str)));
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public static final /* synthetic */ boolean q(MePhotoTaker mePhotoTaker, int i2, int i3, c cVar) {
        return (i3 == -1 && i2 == 1007 && ContextCompat.checkSelfPermission(mePhotoTaker.b, e0.b()) != 0) ? false : true;
    }

    @WithTryCatchRuntime
    private void rotateBitmap(String str, int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new v(new Object[]{this, str, r.a.c.b.e.k(i2), e.x(m, this, this, str, r.a.c.b.e.k(i2))}).e(69648));
    }

    public void i(int i2, int i3, Intent intent) {
        if (shouldCallTakePhoto(i2, i3)) {
            try {
                getTakePhoto().onActivityResult(i2, i3, intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void l(Bundle bundle) {
        getTakePhoto().onCreate(bundle);
    }

    public void m(Bundle bundle) {
        getTakePhoto().onSaveInstanceState(bundle);
    }

    public void n() {
        if (this.a != null) {
            CompressConfig ofDefaultConfig = CompressConfig.ofDefaultConfig();
            ofDefaultConfig.setMaxSize((int) f);
            ofDefaultConfig.setMaxPixel(500);
            this.a = new TakePhotoImpl(this.b, this);
            TakePhotoOptions create = new TakePhotoOptions.Builder().create();
            create.setCorrectImage(true);
            this.a.setTakePhotoOptions(create);
            this.a.onEnableCompress(ofDefaultConfig, true);
        }
    }

    @WithTryCatchRuntime
    public void onAvatarCamera() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new x(new Object[]{this, e.v(i, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void onAvatarGallery() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new y(new Object[]{this, e.v(j, this, this)}).e(69648));
    }

    public void p(a aVar) {
        this.d = aVar;
    }

    @WithTryCatchRuntime
    public boolean shouldCallTakePhoto(int i2, int i3) {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new w(new Object[]{this, r.a.c.b.e.k(i2), r.a.c.b.e.k(i3), e.x(h, this, this, r.a.c.b.e.k(i2), r.a.c.b.e.k(i3))}).e(69648)));
    }

    public void takeCancel() {
        a aVar = this.d;
        if (aVar != null) {
            aVar.P();
        }
    }

    public void takeDegree(int i2) {
        this.c = i2;
    }

    public void takeFail(TResult tResult, String str) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.x(str);
        }
    }

    public void takeSuccess(TResult tResult) {
        String compressPath = tResult.getImage().getCompressPath();
        if (r.b(compressPath)) {
            ThreadManager.getCommonExecutorService().execute(new l(this, compressPath));
            return;
        }
        a aVar = this.d;
        if (aVar != null) {
            aVar.U(tResult.getImage().getCompressPath());
        }
    }
}
