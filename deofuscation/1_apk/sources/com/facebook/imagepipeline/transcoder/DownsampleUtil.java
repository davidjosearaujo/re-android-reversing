package com.facebook.imagepipeline.transcoder;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import javax.annotation.Nullable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DownsampleUtil {
    public static final int DEFAULT_SAMPLE_SIZE = 1;
    private static final float INTERVAL_ROUNDING = 0.33333334f;

    private DownsampleUtil() {
    }

    @VisibleForTesting
    public static float determineDownsampleRatio(RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions, EncodedImage encodedImage) {
        Preconditions.checkArgument(EncodedImage.isMetaDataAvailable(encodedImage));
        if (resizeOptions == null || resizeOptions.height <= 0 || resizeOptions.width <= 0 || encodedImage.getWidth() == 0 || encodedImage.getHeight() == 0) {
            return 1.0f;
        }
        int rotationAngle = getRotationAngle(rotationOptions, encodedImage);
        boolean z = rotationAngle == 90 || rotationAngle == 270;
        int height = z ? encodedImage.getHeight() : encodedImage.getWidth();
        int width = z ? encodedImage.getWidth() : encodedImage.getHeight();
        float f = resizeOptions.width / height;
        float f2 = resizeOptions.height / width;
        float max = Math.max(f, f2);
        FLog.v("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f", Integer.valueOf(resizeOptions.width), Integer.valueOf(resizeOptions.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max));
        return max;
    }

    public static int determineSampleSize(RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions, EncodedImage encodedImage, int i) {
        int ratioToSampleSize;
        if (EncodedImage.isMetaDataAvailable(encodedImage)) {
            float determineDownsampleRatio = determineDownsampleRatio(rotationOptions, resizeOptions, encodedImage);
            if (encodedImage.getImageFormat() == DefaultImageFormats.JPEG) {
                ratioToSampleSize = ratioToSampleSizeJPEG(determineDownsampleRatio);
            } else {
                ratioToSampleSize = ratioToSampleSize(determineDownsampleRatio);
            }
            int max = Math.max(encodedImage.getHeight(), encodedImage.getWidth());
            float f = resizeOptions != null ? resizeOptions.maxBitmapSize : i;
            while (max / ratioToSampleSize > f) {
                ratioToSampleSize = encodedImage.getImageFormat() == DefaultImageFormats.JPEG ? ratioToSampleSize * 2 : ratioToSampleSize + 1;
            }
            return ratioToSampleSize;
        }
        return 1;
    }

    private static int getRotationAngle(RotationOptions rotationOptions, EncodedImage encodedImage) {
        boolean z = false;
        if (rotationOptions.useImageMetadata()) {
            int rotationAngle = encodedImage.getRotationAngle();
            Preconditions.checkArgument((rotationAngle == 0 || rotationAngle == 90 || rotationAngle == 180 || rotationAngle == 270) ? true : true);
            return rotationAngle;
        }
        return 0;
    }

    @VisibleForTesting
    public static int ratioToSampleSize(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (true) {
            double d = i;
            double pow = Math.pow(d, 2.0d);
            Double.isNaN(d);
            Double.isNaN(d);
            if ((1.0d / d) + ((1.0d / (pow - d)) * 0.3333333432674408d) <= f) {
                return i - 1;
            }
            i++;
        }
    }

    @VisibleForTesting
    public static int ratioToSampleSizeJPEG(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (true) {
            int i2 = i * 2;
            double d = i2;
            Double.isNaN(d);
            double d2 = 1.0d / d;
            if (d2 + (0.3333333432674408d * d2) <= f) {
                return i;
            }
            i = i2;
        }
    }

    @VisibleForTesting
    public static int roundToPowerOfTwo(int i) {
        int i2 = 1;
        while (i2 < i) {
            i2 *= 2;
        }
        return i2;
    }
}