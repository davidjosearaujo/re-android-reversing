package com.facebook.soloader;

import android.util.Log;
import com.hunantv.media.player.helper.BuildHelper;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedByInterruptException;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class MinElf {
    public static final int DT_NEEDED = 1;
    public static final int DT_NULL = 0;
    public static final int DT_STRTAB = 5;
    public static final int ELF_MAGIC = 1179403647;
    public static final int PN_XNUM = 65535;
    public static final int PT_DYNAMIC = 2;
    public static final int PT_LOAD = 1;
    private static final String TAG = "MinElf";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class ElfError extends RuntimeException {
        public ElfError(String str) {
            super(str);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum ISA {
        NOT_SO("not_so"),
        X86(BuildHelper.ABI_X86),
        ARM(BuildHelper.ABI_ARMv7a),
        X86_64("x86_64"),
        AARCH64(BuildHelper.ABI_ARM64_V8A),
        OTHERS("others");
        
        private final String value;

        ISA(String str) {
            this.value = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    public static String[] extract_DT_NEEDED(File file) throws IOException {
        ElfFileChannel elfFileChannel = new ElfFileChannel(file);
        try {
            String[] extract_DT_NEEDED = extract_DT_NEEDED(elfFileChannel);
            elfFileChannel.close();
            return extract_DT_NEEDED;
        } catch (Throwable th) {
            try {
                elfFileChannel.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static String[] extract_DT_NEEDED_no_retries(ElfByteChannel elfByteChannel) throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (getu32(elfByteChannel, allocate, 0L) == 1179403647) {
            boolean z = getu8(elfByteChannel, allocate, 4L) == 1;
            if (getu8(elfByteChannel, allocate, 5L) == 2) {
                allocate.order(ByteOrder.BIG_ENDIAN);
            }
            long j12 = z ? getu32(elfByteChannel, allocate, 28L) : get64(elfByteChannel, allocate, 32L);
            long j13 = z ? getu16(elfByteChannel, allocate, 44L) : getu16(elfByteChannel, allocate, 56L);
            int i = getu16(elfByteChannel, allocate, z ? 42L : 54L);
            if (j13 == 65535) {
                long j14 = z ? getu32(elfByteChannel, allocate, 32L) : get64(elfByteChannel, allocate, 40L);
                if (z) {
                    j11 = getu32(elfByteChannel, allocate, j14 + 28);
                } else {
                    j11 = getu32(elfByteChannel, allocate, j14 + 44);
                }
                j13 = j11;
            }
            long j15 = j12;
            long j16 = 0;
            while (true) {
                if (j16 >= j13) {
                    j2 = 0;
                    break;
                }
                if (z) {
                    j10 = getu32(elfByteChannel, allocate, j15 + 0);
                } else {
                    j10 = getu32(elfByteChannel, allocate, j15 + 0);
                }
                if (j10 != 2) {
                    j15 += i;
                    j16++;
                } else if (z) {
                    j2 = getu32(elfByteChannel, allocate, j15 + 4);
                } else {
                    j2 = get64(elfByteChannel, allocate, j15 + 8);
                }
            }
            long j17 = 0;
            if (j2 == 0) {
                throw new ElfError("ELF file does not contain dynamic linking information");
            }
            long j18 = j2;
            long j19 = 0;
            int i2 = 0;
            while (true) {
                boolean z2 = z;
                long j20 = z ? getu32(elfByteChannel, allocate, j18 + j17) : get64(elfByteChannel, allocate, j18 + j17);
                if (j20 == 1) {
                    j3 = j2;
                    if (i2 == Integer.MAX_VALUE) {
                        throw new ElfError("malformed DT_NEEDED section");
                    }
                    i2++;
                } else {
                    j3 = j2;
                    if (j20 == 5) {
                        j19 = z2 ? getu32(elfByteChannel, allocate, j18 + 4) : get64(elfByteChannel, allocate, j18 + 8);
                    }
                }
                long j21 = 16;
                j18 += z2 ? 8L : 16L;
                j17 = 0;
                if (j20 != 0) {
                    z = z2;
                    j2 = j3;
                } else if (j19 == 0) {
                    throw new ElfError("Dynamic section string-table not found");
                } else {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= j13) {
                            j4 = 0;
                            break;
                        }
                        if (z2) {
                            j5 = getu32(elfByteChannel, allocate, j12 + j17);
                        } else {
                            j5 = getu32(elfByteChannel, allocate, j12 + j17);
                        }
                        if (j5 == 1) {
                            if (z2) {
                                j7 = getu32(elfByteChannel, allocate, j12 + 8);
                            } else {
                                j7 = get64(elfByteChannel, allocate, j12 + j21);
                            }
                            if (z2) {
                                j6 = j13;
                                j8 = getu32(elfByteChannel, allocate, j12 + 20);
                            } else {
                                j6 = j13;
                                j8 = get64(elfByteChannel, allocate, j12 + 40);
                            }
                            if (j7 <= j19 && j19 < j8 + j7) {
                                if (z2) {
                                    j9 = getu32(elfByteChannel, allocate, j12 + 4);
                                } else {
                                    j9 = get64(elfByteChannel, allocate, j12 + 8);
                                }
                                j4 = j9 + (j19 - j7);
                            }
                        } else {
                            j6 = j13;
                        }
                        j12 += i;
                        i3++;
                        j13 = j6;
                        j21 = 16;
                        j17 = 0;
                    }
                    long j22 = 0;
                    if (j4 != 0) {
                        String[] strArr = new String[i2];
                        int i4 = 0;
                        while (true) {
                            long j23 = j3 + j22;
                            long j24 = z2 ? getu32(elfByteChannel, allocate, j23) : get64(elfByteChannel, allocate, j23);
                            if (j24 == 1) {
                                strArr[i4] = getSz(elfByteChannel, allocate, (z2 ? getu32(elfByteChannel, allocate, j3 + 4) : get64(elfByteChannel, allocate, j3 + 8)) + j4);
                                if (i4 == Integer.MAX_VALUE) {
                                    throw new ElfError("malformed DT_NEEDED section");
                                }
                                i4++;
                            }
                            j3 += z2 ? 8L : 16L;
                            if (j24 == 0) {
                                if (i4 == i2) {
                                    return strArr;
                                }
                                throw new ElfError("malformed DT_NEEDED section");
                            }
                            j22 = 0;
                        }
                    } else {
                        throw new ElfError("did not find file offset of DT_STRTAB table");
                    }
                }
            }
        } else {
            throw new ElfError("file is not ELF: 0x" + Long.toHexString(j));
        }
    }

    private static String[] extract_DT_NEEDED_with_retries(ElfFileChannel elfFileChannel) throws IOException {
        int i = 0;
        while (true) {
            try {
                return extract_DT_NEEDED_no_retries(elfFileChannel);
            } catch (ClosedByInterruptException e) {
                i++;
                if (i > 4) {
                    throw e;
                }
                Thread.interrupted();
                Log.e(TAG, "retrying extract_DT_NEEDED due to ClosedByInterruptException", e);
                elfFileChannel.openChannel();
            }
        }
    }

    private static long get64(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(elfByteChannel, byteBuffer, 8, j);
        return byteBuffer.getLong();
    }

    private static String getSz(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short u8Var = getu8(elfByteChannel, byteBuffer, j);
            if (u8Var != 0) {
                sb.append((char) u8Var);
                j = j2;
            } else {
                return sb.toString();
            }
        }
    }

    private static int getu16(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(elfByteChannel, byteBuffer, 2, j);
        return byteBuffer.getShort() & 65535;
    }

    private static long getu32(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(elfByteChannel, byteBuffer, 4, j);
        return byteBuffer.getInt() & 4294967295L;
    }

    private static short getu8(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(elfByteChannel, byteBuffer, 1, j);
        return (short) (byteBuffer.get() & 255);
    }

    private static void read(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, int i, long j) throws IOException {
        int read;
        byteBuffer.position(0);
        byteBuffer.limit(i);
        while (byteBuffer.remaining() > 0 && (read = elfByteChannel.read(byteBuffer, j)) != -1) {
            j += read;
        }
        if (byteBuffer.remaining() <= 0) {
            byteBuffer.position(0);
            return;
        }
        throw new ElfError("ELF file truncated");
    }

    public static String[] extract_DT_NEEDED(ElfByteChannel elfByteChannel) throws IOException {
        if (elfByteChannel instanceof ElfFileChannel) {
            return extract_DT_NEEDED_with_retries((ElfFileChannel) elfByteChannel);
        }
        return extract_DT_NEEDED_no_retries(elfByteChannel);
    }
}
