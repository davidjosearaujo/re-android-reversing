package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.transcoder.DownsampleUtil;
import com.facebook.imagepipeline.transcoder.ImageTranscodeResult;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

@DoNotStrip
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class NativeJpegTranscoder implements ImageTranscoder {
    public static final String TAG = "NativeJpegTranscoder";
    private int mMaxBitmapSize;
    private boolean mResizingEnabled;
    private boolean mUseDownsamplingRatio;

    static {
        NativeJpegTranscoderSoLoader.ensure();
    }

    public NativeJpegTranscoder(boolean z, int i, boolean z2) {
        this.mResizingEnabled = z;
        this.mMaxBitmapSize = i;
        this.mUseDownsamplingRatio = z2;
    }

    @DoNotStrip
    private static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    @DoNotStrip
    private static native void nativeTranscodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    @VisibleForTesting
    public static void transcodeJpeg(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException {
        NativeJpegTranscoderSoLoader.ensure();
        boolean z = false;
        Preconditions.checkArgument(i2 >= 1);
        Preconditions.checkArgument(i2 <= 16);
        Preconditions.checkArgument(i3 >= 0);
        Preconditions.checkArgument(i3 <= 100);
        Preconditions.checkArgument(JpegTranscoderUtils.isRotationAngleAllowed(i));
        Preconditions.checkArgument((i2 == 8 && i == 0) ? true : true, "no transformation requested");
        nativeTranscodeJpeg((InputStream) Preconditions.checkNotNull(inputStream), (OutputStream) Preconditions.checkNotNull(outputStream), i, i2, i3);
    }

    @VisibleForTesting
    public static void transcodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException {
        NativeJpegTranscoderSoLoader.ensure();
        boolean z = false;
        Preconditions.checkArgument(i2 >= 1);
        Preconditions.checkArgument(i2 <= 16);
        Preconditions.checkArgument(i3 >= 0);
        Preconditions.checkArgument(i3 <= 100);
        Preconditions.checkArgument(JpegTranscoderUtils.isExifOrientationAllowed(i));
        Preconditions.checkArgument((i2 == 8 && i == 1) ? true : true, "no transformation requested");
        nativeTranscodeJpegWithExifOrientation((InputStream) Preconditions.checkNotNull(inputStream), (OutputStream) Preconditions.checkNotNull(outputStream), i, i2, i3);
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canResize(EncodedImage encodedImage, @Nullable RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions) {
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.autoRotate();
        }
        return JpegTranscoderUtils.getSoftwareNumerator(rotationOptions, resizeOptions, encodedImage, this.mResizingEnabled) < 8;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canTranscode(ImageFormat imageFormat) {
        return imageFormat == DefaultImageFormats.JPEG;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public String getIdentifier() {
        return TAG;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public ImageTranscodeResult transcode(EncodedImage encodedImage, OutputStream outputStream, @Nullable RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions, @Nullable ImageFormat imageFormat, @Nullable Integer num) throws IOException {
        if (num == null) {
            num = 85;
        }
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.autoRotate();
        }
        int determineSampleSize = DownsampleUtil.determineSampleSize(rotationOptions, resizeOptions, encodedImage, this.mMaxBitmapSize);
        try {
            int softwareNumerator = JpegTranscoderUtils.getSoftwareNumerator(rotationOptions, resizeOptions, encodedImage, this.mResizingEnabled);
            int calculateDownsampleNumerator = JpegTranscoderUtils.calculateDownsampleNumerator(determineSampleSize);
            if (this.mUseDownsamplingRatio) {
                softwareNumerator = calculateDownsampleNumerator;
            }
            InputStream inputStream = encodedImage.getInputStream();
            if (JpegTranscoderUtils.INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation()))) {
                transcodeJpegWithExifOrientation(inputStream, outputStream, JpegTranscoderUtils.getForceRotatedInvertedExifOrientation(rotationOptions, encodedImage), softwareNumerator, num.intValue());
            } else {
                transcodeJpeg(inputStream, outputStream, JpegTranscoderUtils.getRotationAngle(rotationOptions, encodedImage), softwareNumerator, num.intValue());
            }
            Closeables.closeQuietly(inputStream);
            return new ImageTranscodeResult(determineSampleSize != 1 ? 0 : 1);
        } catch (Throwable th) {
            Closeables.closeQuietly((InputStream) null);
            throw th;
        }
    }
}
