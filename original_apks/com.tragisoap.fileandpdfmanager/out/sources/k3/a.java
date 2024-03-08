package k3;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<byte[]> f4685a = new AtomicReference<>();

    /* renamed from: k3.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0074a extends InputStream {

        /* renamed from: f  reason: collision with root package name */
        public final ByteBuffer f4686f;

        /* renamed from: g  reason: collision with root package name */
        public int f4687g = -1;

        public C0074a(ByteBuffer byteBuffer) {
            this.f4686f = byteBuffer;
        }

        @Override // java.io.InputStream
        public final int available() {
            return this.f4686f.remaining();
        }

        @Override // java.io.InputStream
        public final synchronized void mark(int i7) {
            this.f4687g = this.f4686f.position();
        }

        @Override // java.io.InputStream
        public final boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public final int read() {
            if (!this.f4686f.hasRemaining()) {
                return -1;
            }
            return this.f4686f.get() & 255;
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i7, int i8) {
            if (!this.f4686f.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i8, available());
            this.f4686f.get(bArr, i7, min);
            return min;
        }

        @Override // java.io.InputStream
        public final synchronized void reset() {
            int i7 = this.f4687g;
            if (i7 != -1) {
                this.f4686f.position(i7);
            } else {
                throw new IOException("Cannot reset to unset mark position");
            }
        }

        @Override // java.io.InputStream
        public final long skip(long j7) {
            if (!this.f4686f.hasRemaining()) {
                return -1;
            }
            long min = Math.min(j7, (long) available());
            ByteBuffer byteBuffer = this.f4686f;
            byteBuffer.position((int) (((long) byteBuffer.position()) + min));
            return min;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f4688a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4689b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f4690c;

        public b(byte[] bArr, int i7, int i8) {
            this.f4690c = bArr;
            this.f4688a = i7;
            this.f4689b = i8;
        }
    }

    public static MappedByteBuffer a(File file) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            } else if (length != 0) {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    fileChannel = randomAccessFile.getChannel();
                    try {
                        MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, length).load();
                        try {
                            fileChannel.close();
                        } catch (IOException unused) {
                        }
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused2) {
                        }
                        return load;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException unused4) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel = null;
                }
            } else {
                throw new IOException("File unsuitable for memory mapping");
            }
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
        }
    }

    public static ByteBuffer b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = f4685a.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int read = inputStream.read(andSet);
            if (read >= 0) {
                byteArrayOutputStream.write(andSet, 0, read);
            } else {
                f4685a.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return c(ByteBuffer.allocateDirect(byteArray.length).put(byteArray));
            }
        }
    }

    public static ByteBuffer c(ByteBuffer byteBuffer) {
        return (ByteBuffer) byteBuffer.position(0);
    }

    public static void d(ByteBuffer byteBuffer, File file) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        ByteBuffer byteBuffer2 = (ByteBuffer) byteBuffer.position(0);
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileChannel = randomAccessFile.getChannel();
                fileChannel.write(byteBuffer);
                fileChannel.force(false);
                fileChannel.close();
                randomAccessFile.close();
                try {
                    fileChannel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }
}
