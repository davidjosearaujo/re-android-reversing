package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@TargetApi(21)
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class BucketsBitmapPool extends BasePool<Bitmap> implements BitmapPool {
    public BucketsBitmapPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        initialize();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getBucketedSize(int i) {
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getSizeInBytes(int i) {
        return i;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public Bitmap alloc(int i) {
        double d = i;
        Double.isNaN(d);
        return Bitmap.createBitmap(1, (int) Math.ceil(d / 2.0d), Bitmap.Config.RGB_565);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public void free(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap);
        bitmap.recycle();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getBucketedSizeForValue(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap);
        return bitmap.getAllocationByteCount();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.memory.BasePool
    @Nullable
    public Bitmap getValue(Bucket<Bitmap> bucket) {
        Bitmap bitmap = (Bitmap) super.getValue((Bucket<Object>) bucket);
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
        return bitmap;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public boolean isReusable(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap);
        return !bitmap.isRecycled() && bitmap.isMutable();
    }
}
