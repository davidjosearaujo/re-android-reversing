package com.hunantv.media.alpha;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import com.hunantv.media.player.MgtvMediaPlayer;
import com.hunantv.media.player.pragma.DebugLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AlphaRenderer implements Renderer, SurfaceTexture.OnFrameAvailableListener {
    private static final int FLOAT_SIZE_BYTES = 4;
    private static int GL_TEXTURE_EXTERNAL_OES = 36197;
    private static String TAG = "AlphaRenderer";
    private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
    private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 16;
    private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 2;
    private int aPositionHandle;
    private int aTextureHandle;
    private int mCurrentVideoHeight;
    private int mCurrentVideoWidth;
    private int mCurrentViewHeight;
    private int mCurrentViewWidth;
    private OnSurfaceErrorListener onSurfaceErrorListener;
    private OnSurfacePrepareListener onSurfacePrepareListener;
    private int program;
    private SurfaceTexture surface;
    private int textureID;
    private FloatBuffer triangleVertices;
    private final float[] triangleVerticesData;
    private final String vertexShader = "attribute vec2 a_position;\nattribute vec2 a_texCoord;\nvarying vec2 v_texcoord;\nvoid main(void) {\n  gl_Position = vec4(a_position, 0.0, 0.998);\n  v_texcoord = a_texCoord;\n}\n";
    private final String alphaShader = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 v_texcoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = vec4(texture2D(sTexture, v_texcoord).rgb, texture2D(sTexture, v_texcoord + vec2(-0.5, 0)).r);\n}\n";
    private boolean updateSurface = false;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnSurfaceErrorListener {
        void surfaceError(int i, String str);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnSurfacePrepareListener {
        void surfacePrepared(Surface surface);
    }

    public AlphaRenderer() {
        float[] fArr = {-1.0f, 1.0f, 0.5f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.5f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
        this.triangleVerticesData = fArr;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.triangleVertices = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
    }

    private int checkGlError(int i, String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            String str2 = TAG;
            DebugLog.e(str2, "error checkGlError errCode:" + i + ",msg:" + str);
            OnSurfaceErrorListener onSurfaceErrorListener = this.onSurfaceErrorListener;
            if (onSurfaceErrorListener != null) {
                onSurfaceErrorListener.surfaceError(i, str);
            }
        }
        return glGetError;
    }

    private int checkGlWarning(int i, String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            String str2 = TAG;
            DebugLog.e(str2, "warning checkGlWarning errCode:" + i + ",msg:" + str);
        }
        return glGetError;
    }

    private int createProgram(String str, String str2) {
        int loadShader;
        int loadShader2 = loadShader(35633, str);
        if (loadShader2 == 0 || (loadShader = loadShader(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, loadShader2);
            if (checkGlError(-119, "glAttachShader") != 0) {
                return 0;
            }
            GLES20.glAttachShader(glCreateProgram, loadShader);
            if (checkGlError(-120, "glAttachShader") != 0) {
                return 0;
            }
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                String str3 = TAG;
                DebugLog.i(str3, "Could not link program: " + GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
        }
        return glCreateProgram;
    }

    private int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                String str2 = TAG;
                DebugLog.i(str2, "Could not compile shader " + i + ":\n" + GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                return 0;
            }
            return glCreateShader;
        }
        return glCreateShader;
    }

    private void prepareSurface() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        this.textureID = i;
        GLES20.glBindTexture(GL_TEXTURE_EXTERNAL_OES, i);
        if (checkGlError(-118, "glBindTexture textureID") != 0) {
            return;
        }
        GLES20.glTexParameterf(GL_TEXTURE_EXTERNAL_OES, 10241, 9728.0f);
        GLES20.glTexParameterf(GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.textureID);
        this.surface = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.onSurfacePrepareListener.surfacePrepared(new Surface(this.surface));
        synchronized (this) {
            this.updateSurface = false;
        }
    }

    @Override // com.hunantv.media.alpha.Renderer
    public void onDrawFrame(GL10 gl10) {
        synchronized (this) {
            if (this.updateSurface) {
                this.surface.updateTexImage();
                this.updateSurface = false;
            }
        }
        GLES20.glClear(16640);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glUseProgram(this.program);
        checkGlWarning(MgtvMediaPlayer.MEDIA_ERROR_TIMED_OUT, "glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GL_TEXTURE_EXTERNAL_OES, this.textureID);
        this.triangleVertices.position(0);
        GLES20.glVertexAttribPointer(this.aPositionHandle, 2, 5126, false, 16, (Buffer) this.triangleVertices);
        checkGlWarning(-111, "glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.aPositionHandle);
        checkGlWarning(-112, "glEnableVertexAttribArray aPositionHandle");
        this.triangleVertices.position(2);
        GLES20.glVertexAttribPointer(this.aTextureHandle, 2, 5126, false, 16, (Buffer) this.triangleVertices);
        checkGlWarning(-113, "glVertexAttribPointer aTextureHandle");
        GLES20.glEnableVertexAttribArray(this.aTextureHandle);
        checkGlWarning(-114, "glEnableVertexAttribArray aTextureHandle");
        GLES20.glDrawArrays(5, 0, 4);
        checkGlWarning(-115, "glDrawArrays");
        GLES20.glFinish();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.updateSurface = true;
    }

    @Override // com.hunantv.media.alpha.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        String str = TAG;
        DebugLog.i(str, "onSufaceChanged w " + i + " h " + i2);
        GLES20.glViewport(0, 0, i, i2);
    }

    @Override // com.hunantv.media.alpha.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int createProgram = createProgram("attribute vec2 a_position;\nattribute vec2 a_texCoord;\nvarying vec2 v_texcoord;\nvoid main(void) {\n  gl_Position = vec4(a_position, 0.0, 0.998);\n  v_texcoord = a_texCoord;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 v_texcoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = vec4(texture2D(sTexture, v_texcoord).rgb, texture2D(sTexture, v_texcoord + vec2(-0.5, 0)).r);\n}\n");
        this.program = createProgram;
        if (createProgram == 0) {
            return;
        }
        this.aPositionHandle = GLES20.glGetAttribLocation(createProgram, "a_position");
        if (checkGlError(-116, "glGetAttribLocation aPosition") != 0) {
            return;
        }
        if (this.aPositionHandle == -1) {
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        this.aTextureHandle = GLES20.glGetAttribLocation(this.program, "a_texCoord");
        if (checkGlError(-117, "glGetAttribLocation aTextureCoord") != 0) {
            return;
        }
        if (this.aTextureHandle == -1) {
            throw new RuntimeException("Could not get attrib location for aTextureCoord");
        }
        prepareSurface();
    }

    @Override // com.hunantv.media.alpha.Renderer
    public void onSurfaceDestroyed(GL10 gl10) {
    }

    public void setOnSurfaceErrorListener(OnSurfaceErrorListener onSurfaceErrorListener) {
        this.onSurfaceErrorListener = onSurfaceErrorListener;
    }

    public void setOnSurfacePrepareListener(OnSurfacePrepareListener onSurfacePrepareListener) {
        this.onSurfacePrepareListener = onSurfacePrepareListener;
    }

    public void updateRadio(int i, int i2, int i3, int i4) {
        if (this.mCurrentVideoWidth == i && this.mCurrentVideoHeight == i2 && this.mCurrentViewWidth == i3 && this.mCurrentViewHeight == i4) {
            return;
        }
        this.mCurrentVideoWidth = i;
        this.mCurrentVideoHeight = i2;
        this.mCurrentViewWidth = i3;
        this.mCurrentViewHeight = i4;
        if (this.triangleVertices == null) {
            this.triangleVertices = ByteBuffer.allocateDirect(this.triangleVerticesData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.triangleVertices.put(this.triangleVerticesData).position(0);
        float f = i;
        float f2 = i2;
        float f3 = i3;
        float f4 = f3 * 1.0f;
        float f5 = i4;
        if ((f * 1.0f) / f2 > f4 / f5) {
            float f6 = (f - ((f4 * f2) / f5)) / f;
            FloatBuffer floatBuffer = this.triangleVertices;
            float f7 = f6 / 2.0f;
            floatBuffer.put(2, floatBuffer.get(2) + f7);
            floatBuffer.put(6, floatBuffer.get(6) - f7);
            floatBuffer.put(10, floatBuffer.get(10) + f7);
            floatBuffer.put(14, floatBuffer.get(14) - f7);
            return;
        }
        float f8 = (f2 - (((f5 * 1.0f) * f) / f3)) / f2;
        FloatBuffer floatBuffer2 = this.triangleVertices;
        float f9 = f8 / 2.0f;
        floatBuffer2.put(3, floatBuffer2.get(3) + f9);
        floatBuffer2.put(7, floatBuffer2.get(7) + f9);
        floatBuffer2.put(11, floatBuffer2.get(11) - f9);
        floatBuffer2.put(15, floatBuffer2.get(15) - f9);
    }
}
