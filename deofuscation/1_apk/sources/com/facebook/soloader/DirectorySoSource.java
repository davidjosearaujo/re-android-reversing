package com.facebook.soloader;

import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DirectorySoSource extends SoSource {
    public static final int ON_LD_LIBRARY_PATH = 2;
    public static final int RESOLVE_DEPENDENCIES = 1;
    public final List<String> denyList;
    public final int flags;
    public final File soDirectory;

    public DirectorySoSource(File file, int i) {
        this(file, i, new String[0]);
    }

    private void loadDependencies(String str, ElfByteChannel elfByteChannel, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        String[] dependencies = getDependencies(str, elfByteChannel);
        Log.d(SoLoader.TAG, "Loading " + str + "'s dependencies: " + Arrays.toString(dependencies));
        for (String str2 : dependencies) {
            if (!str2.startsWith("/")) {
                SoLoader.loadLibraryBySoName(str2, i | 1, threadPolicy);
            }
        }
    }

    @Override // com.facebook.soloader.SoSource
    public void addToLdLibraryPath(Collection<String> collection) {
        collection.add(this.soDirectory.getAbsolutePath());
    }

    public ElfByteChannel getChannel(File file) throws IOException {
        return new ElfFileChannel(file);
    }

    public String[] getDependencies(String str, ElfByteChannel elfByteChannel) throws IOException {
        boolean z = SoLoader.SYSTRACE_LIBRARY_LOADING;
        if (z) {
            Api18TraceUtils.beginTraceSection("SoLoader.getElfDependencies[", str, "]");
        }
        try {
            String[] dependencies = NativeDeps.getDependencies(str, elfByteChannel);
            if (z) {
                Api18TraceUtils.endSection();
            }
            return dependencies;
        } catch (Throwable th) {
            if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                Api18TraceUtils.endSection();
            }
            throw th;
        }
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public String[] getLibraryDependencies(String str) throws IOException {
        File soFileByName = getSoFileByName(str);
        if (soFileByName == null) {
            return null;
        }
        ElfByteChannel channel = getChannel(soFileByName);
        try {
            String[] dependencies = getDependencies(str, channel);
            if (channel != null) {
                channel.close();
            }
            return dependencies;
        } catch (Throwable th) {
            if (channel != null) {
                try {
                    channel.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public String getLibraryPath(String str) throws IOException {
        File soFileByName = getSoFileByName(str);
        if (soFileByName == null) {
            return null;
        }
        return soFileByName.getCanonicalPath();
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public File getSoFileByName(String str) throws IOException {
        File file = new File(this.soDirectory, str);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
    }

    public int loadLibraryFrom(String str, int i, File file, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        if (SoLoader.sSoFileLoader != null) {
            if (this.denyList.contains(str)) {
                Log.d(SoLoader.TAG, str + " is on the denyList, skip loading from " + file.getCanonicalPath());
                return 0;
            }
            File soFileByName = getSoFileByName(str);
            if (soFileByName == null) {
                Log.v(SoLoader.TAG, str + " not found on " + file.getCanonicalPath());
                return 0;
            }
            Log.d(SoLoader.TAG, str + " found on " + file.getCanonicalPath());
            if ((i & 1) != 0 && (this.flags & 2) != 0) {
                Log.d(SoLoader.TAG, str + " loaded implicitly");
                return 2;
            }
            ElfByteChannel elfByteChannel = null;
            boolean z = (this.flags & 1) != 0;
            boolean equals = soFileByName.getName().equals(str);
            if (z || !equals) {
                try {
                    elfByteChannel = getChannel(soFileByName);
                } catch (Throwable th) {
                    if (elfByteChannel != null) {
                        elfByteChannel.close();
                    }
                    throw th;
                }
            }
            if (z) {
                loadDependencies(str, elfByteChannel, i, threadPolicy);
            } else {
                Log.d(SoLoader.TAG, "Not resolving dependencies for " + str);
            }
            try {
                if (equals) {
                    SoLoader.sSoFileLoader.load(soFileByName.getAbsolutePath(), i);
                } else {
                    SoLoader.sSoFileLoader.loadBytes(soFileByName.getAbsolutePath(), elfByteChannel, i);
                }
                if (elfByteChannel != null) {
                    elfByteChannel.close();
                }
                return 1;
            } catch (UnsatisfiedLinkError e) {
                if (e.getMessage().contains("bad ELF magic")) {
                    Log.d(SoLoader.TAG, "Corrupted lib file detected");
                    if (elfByteChannel != null) {
                        elfByteChannel.close();
                    }
                    return 3;
                }
                throw e;
            }
        }
        throw new IllegalStateException("SoLoader.init() not yet called");
    }

    @Override // com.facebook.soloader.SoSource
    public String toString() {
        String name;
        try {
            name = String.valueOf(this.soDirectory.getCanonicalPath());
        } catch (IOException unused) {
            name = this.soDirectory.getName();
        }
        return getClass().getName() + "[root = " + name + " flags = " + this.flags + ']';
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public File unpackLibrary(String str) throws IOException {
        return getSoFileByName(str);
    }

    public DirectorySoSource(File file, int i, String[] strArr) {
        this.soDirectory = file;
        this.flags = i;
        this.denyList = Arrays.asList(strArr);
    }
}
