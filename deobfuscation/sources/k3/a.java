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

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public static final AtomicReference<byte[]> f4685a = new AtomicReference<>();

    /* renamed from: k3.a$a */
    /* loaded from: classes.dex */
    public static class C0074a extends InputStream {

        /* renamed from: f */
        public final ByteBuffer f4686f;

        /* renamed from: g */
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
            if (this.f4686f.hasRemaining()) {
                return this.f4686f.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i7, int i8) {
            if (this.f4686f.hasRemaining()) {
                int min = Math.min(i8, available());
                this.f4686f.get(bArr, i7, min);
                return min;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public final synchronized void reset() {
            int i7 = this.f4687g;
            if (i7 == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f4686f.position(i7);
        }

        @Override // java.io.InputStream
        public final long skip(long j5) {
            if (this.f4686f.hasRemaining()) {
                long min = Math.min(j5, available());
                ByteBuffer byteBuffer = this.f4686f;
                byteBuffer.position((int) (byteBuffer.position() + min));
                return min;
            }
            return -1L;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a */
        public final int f4688a;

        /* renamed from: b */
        public final int f4689b;

        /* renamed from: c */
        public final byte[] f4690c;

        public b(byte[] bArr, int i7, int i8) {
            this.f4690c = bArr;
            this.f4688a = i7;
            this.f4689b = i8;
        }
    }

    public static MappedByteBuffer a(File file) {
        RandomAccessFile randomAccessFile;
        Throwable th;
        FileChannel fileChannel;
        FileChannel fileChannel2 = null;
        try {
            long length = file.length();
            if (length <= 2147483647L) {
                if (length != 0) {
                    randomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        fileChannel = randomAccessFile.getChannel();
                    } catch (Throwable th2) {
                        th = th2;
                        fileChannel = null;
                    }
                    try {
                        MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                        try {
                            fileChannel.close();
                        } catch (IOException unused) {
                        }
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused2) {
                        }
                        return load;
                    } catch (Throwable th3) {
                        th = th3;
                        Throwable th4 = th;
                        fileChannel2 = fileChannel;
                        th = th4;
                        if (fileChannel2 != null) {
                            try {
                                fileChannel2.close();
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
                }
                throw new IOException("File unsuitable for memory mapping");
            }
            throw new IOException("File too large to map into memory");
        } catch (Throwable th5) {
            th = th5;
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
            if (read < 0) {
                f4685a.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return c(ByteBuffer.allocateDirect(byteArray.length).put(byteArray));
            }
            byteArrayOutputStream.write(andSet, 0, read);
        }
    }

    public static ByteBuffer c(ByteBuffer byteBuffer) {
        return (ByteBuffer) byteBuffer.position(0);
    }

    public static void d(ByteBuffer byteBuffer, File file) {
        RandomAccessFile randomAccessFile;
        ByteBuffer byteBuffer2 = (ByteBuffer) byteBuffer.position(0);
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
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
    }
}
