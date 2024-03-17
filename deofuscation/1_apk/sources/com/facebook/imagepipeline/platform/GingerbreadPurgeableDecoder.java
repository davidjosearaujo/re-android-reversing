package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.MemoryFile;
import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class GingerbreadPurgeableDecoder extends DalvikPurgeableDecoder {
    private static Method sGetFileDescriptorMethod;
    @Nullable
    private final WebpBitmapFactory mWebpBitmapFactory = WebpSupportStatus.loadWebpBitmapFactoryIfExists();

    private static MemoryFile copyToMemoryFile(CloseableReference<PooledByteBuffer> closeableReference, int i, @Nullable byte[] bArr) throws IOException {
        OutputStream outputStream;
        LimitedInputStream limitedInputStream;
        PooledByteBufferInputStream pooledByteBufferInputStream = null;
        OutputStream outputStream2 = null;
        MemoryFile memoryFile = new MemoryFile(null, (bArr == null ? 0 : bArr.length) + i);
        memoryFile.allowPurging(false);
        try {
            PooledByteBufferInputStream pooledByteBufferInputStream2 = new PooledByteBufferInputStream(closeableReference.get());
            try {
                limitedInputStream = new LimitedInputStream(pooledByteBufferInputStream2, i);
            } catch (Throwable th) {
                th = th;
                outputStream = null;
                limitedInputStream = null;
            }
            try {
                outputStream2 = memoryFile.getOutputStream();
                ByteStreams.copy(limitedInputStream, outputStream2);
                if (bArr != null) {
                    memoryFile.writeBytes(bArr, 0, i, bArr.length);
                }
                CloseableReference.closeSafely(closeableReference);
                Closeables.closeQuietly(pooledByteBufferInputStream2);
                Closeables.closeQuietly(limitedInputStream);
                Closeables.close(outputStream2, true);
                return memoryFile;
            } catch (Throwable th2) {
                th = th2;
                outputStream = outputStream2;
                pooledByteBufferInputStream = pooledByteBufferInputStream2;
                CloseableReference.closeSafely(closeableReference);
                Closeables.closeQuietly(pooledByteBufferInputStream);
                Closeables.closeQuietly(limitedInputStream);
                Closeables.close(outputStream, true);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
            limitedInputStream = null;
        }
    }

    private Bitmap decodeFileDescriptorAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, int i, byte[] bArr, BitmapFactory.Options options) {
        MemoryFile memoryFile = null;
        try {
            try {
                MemoryFile copyToMemoryFile = copyToMemoryFile(closeableReference, i, bArr);
                try {
                    FileDescriptor memoryFileDescriptor = getMemoryFileDescriptor(copyToMemoryFile);
                    WebpBitmapFactory webpBitmapFactory = this.mWebpBitmapFactory;
                    if (webpBitmapFactory != null) {
                        Bitmap bitmap = (Bitmap) Preconditions.checkNotNull(webpBitmapFactory.decodeFileDescriptor(memoryFileDescriptor, null, options), "BitmapFactory returned null");
                        if (copyToMemoryFile != null) {
                            copyToMemoryFile.close();
                        }
                        return bitmap;
                    }
                    throw new IllegalStateException("WebpBitmapFactory is null");
                } catch (IOException e) {
                    e = e;
                    memoryFile = copyToMemoryFile;
                    throw Throwables.propagate(e);
                } catch (Throwable th) {
                    th = th;
                    memoryFile = copyToMemoryFile;
                    if (memoryFile != null) {
                        memoryFile.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    private synchronized Method getFileDescriptorMethod() {
        if (sGetFileDescriptorMethod == null) {
            try {
                sGetFileDescriptorMethod = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
            } catch (Exception e) {
                throw Throwables.propagate(e);
            }
        }
        return sGetFileDescriptorMethod;
    }

    private FileDescriptor getMemoryFileDescriptor(MemoryFile memoryFile) {
        try {
            return (FileDescriptor) getFileDescriptorMethod().invoke(memoryFile, new Object[0]);
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory.Options options) {
        return decodeFileDescriptorAsPurgeable(closeableReference, closeableReference.get().size(), null, options);
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, int i, BitmapFactory.Options options) {
        return decodeFileDescriptorAsPurgeable(closeableReference, i, DalvikPurgeableDecoder.endsWithEOI(closeableReference, i) ? null : DalvikPurgeableDecoder.EOI, options);
    }
}
