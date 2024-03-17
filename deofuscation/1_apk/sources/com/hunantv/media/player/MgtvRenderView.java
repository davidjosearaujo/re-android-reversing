package com.hunantv.media.player;

import a.a.a.a.c;
import a.a.a.a.l;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.TextureView;
import android.view.View;
import c.a.a.a.h;
import c.a.a.a.o.d;
import c.a.a.a.o.f;
import c.a.a.b.d.g;
import com.alibaba.fastjson.asm.Opcodes;
import com.hunantv.media.player.IMgtvRenderView;
import com.hunantv.media.player.MgtvPlayerListener;
import com.hunantv.media.widget.IVideoView;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgtvRenderView {
    public static final int MGTV_AR_16_9_FIT_PARENT = 4;
    public static final int MGTV_AR_4_3_FIT_PARENT = 5;
    public static final int MGTV_AR_ASPECT_FILL_PARENT = 1;
    public static final int MGTV_AR_ASPECT_FIT_PARENT = 0;
    public static final int MGTV_AR_ASPECT_WRAP_CONTENT = 2;
    public static final int MGTV_AR_MATCH_PARENT = 3;
    public static final int MGTV_RENDER_SURFACE_VIEW = 0;
    public static final int MGTV_RENDER_TEXTURE_VIEW = 1;
    private c mFakeFrameView;
    private h mRenderView;

    public MgtvRenderView(Context context) {
        this.mRenderView = new h(context);
    }

    public MgtvRenderView(Context context, int i, boolean z, MgtvPlayerListener.OnWarningListener onWarningListener, f.a aVar) {
        this.mRenderView = new h(context, i, (d.a || (Build.VERSION.SDK_INT >= 23 && !d.a(g.m()))) ? z : false, onWarningListener, aVar);
    }

    private boolean checkLastFrameValid(TextureView textureView, int i, int i2) {
        if (textureView == null) {
            return false;
        }
        int i3 = i * i2;
        int[] iArr = new int[i3];
        try {
            Bitmap bitmap = textureView.getBitmap(i, i2);
            if (bitmap != null) {
                bitmap.getPixels(iArr, 0, i, 0, 0, i, i2);
                for (int i4 = 0; i4 < i3; i4++) {
                    if (iArr[i4] != iArr[0]) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getAspectRatioName(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "unknown" : "4_3" : "16_9" : "MATCH_PARENT" : "WRAP_CONTENT" : "FILL_PARENT" : "FIT_PARENT";
    }

    public static String getRenderTypeName(int i) {
        return i != 0 ? i != 1 ? "unknown" : "TextureView" : "SurfaceView";
    }

    public void addRenderCallback(IMgtvRenderView.IRenderCallback iRenderCallback) {
        this.mRenderView.k(iRenderCallback);
    }

    public void bind(IVideoView iVideoView) {
        this.mRenderView.l(iVideoView);
    }

    public void bindFakeFrameView(c cVar) {
        this.mFakeFrameView = cVar;
    }

    public void bindResizableFrameView(l lVar) {
        this.mRenderView.i(lVar);
    }

    public IMgtvRenderView.FloatRect getDisplayCoordinate() {
        return this.mRenderView.a();
    }

    public IMgtvRenderView getRenderView() {
        return this.mRenderView.n();
    }

    public int getRenderViewType() {
        return this.mRenderView.s();
    }

    public View getView() {
        return this.mRenderView.v();
    }

    public void release() {
        h hVar = this.mRenderView;
        if (hVar != null) {
            hVar.w();
        }
    }

    public void removeRenderCallback(IMgtvRenderView.IRenderCallback iRenderCallback) {
        this.mRenderView.q(iRenderCallback);
    }

    public void reset() {
        h hVar = this.mRenderView;
        if (hVar != null) {
            hVar.y();
        }
    }

    public void saveLastValidFrame() {
        View view = getView();
        if (this.mFakeFrameView == null || view == null || !(view instanceof TextureView) || !checkLastFrameValid((TextureView) view, Opcodes.IF_ICMPNE, 90)) {
            return;
        }
        this.mFakeFrameView.setImageBitmap(((TextureView) this.mRenderView.v()).getBitmap());
    }

    public void setAntiAliasing(boolean z) {
        h hVar = this.mRenderView;
        if (hVar != null) {
            hVar.m(z);
        }
    }

    public void setAntiShake(boolean z) {
        h hVar = this.mRenderView;
        if (hVar != null) {
            hVar.r(z);
        }
    }

    public void setAspectRatio(int i) {
        this.mRenderView.f(i);
        c cVar = this.mFakeFrameView;
        if (cVar != null) {
            cVar.setAspectRatio(i);
        }
    }

    public void setDisplayFloatRect(IMgtvRenderView.FloatRect floatRect) {
        this.mRenderView.j(floatRect);
    }

    public void setIsInScaleAnim(boolean z) {
        h hVar = this.mRenderView;
        if (hVar != null) {
            hVar.u(z);
        }
    }

    public void setManualRotation(int i, int i2, int i3, int i4, int i5) {
        this.mRenderView.h(i, i2, i3, i4, i5);
    }

    public void setRenderFilter(int i) {
        this.mRenderView.o(i);
    }

    public void setVideoRotation(int i) {
        this.mRenderView.t(i);
        c cVar = this.mFakeFrameView;
        if (cVar != null) {
            cVar.setVideoRotation(i);
        }
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        this.mRenderView.g(i, i2);
    }

    public void setVideoSize(int i, int i2) {
        this.mRenderView.p(i, i2);
        c cVar = this.mFakeFrameView;
        if (cVar != null) {
            cVar.a(i, i2);
        }
    }

    public boolean shouldWaitForResize() {
        return this.mRenderView.z();
    }
}
