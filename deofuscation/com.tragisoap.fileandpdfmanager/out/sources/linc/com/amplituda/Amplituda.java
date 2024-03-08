package linc.com.amplituda;

import android.content.Context;
import android.webkit.URLUtil;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Locale;
import linc.com.amplituda.InputAudio;
import linc.com.amplituda.exceptions.AmplitudaException;
import linc.com.amplituda.exceptions.io.FileNotFoundException;
import linc.com.amplituda.exceptions.io.InvalidAudioByteArrayException;
import linc.com.amplituda.exceptions.io.InvalidAudioInputStreamException;
import linc.com.amplituda.exceptions.io.InvalidAudioUrlException;
import linc.com.amplituda.exceptions.io.InvalidRawResourceException;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class Amplituda {
    private final FileManager fileManager;

    static {
        System.loadLibrary("amplituda-native-lib");
    }

    public Amplituda(Context context) {
        this.fileManager = new FileManager(context);
    }

    private AmplitudaResultJNI amplitudesFromCache(File file) {
        try {
            String readFile = this.fileManager.readFile(file);
            if (readFile != null && !readFile.isEmpty()) {
                int indexOf = readFile.indexOf("=");
                int indexOf2 = readFile.indexOf(System.lineSeparator());
                String substring = readFile.substring(0, indexOf2).substring(indexOf + 1, indexOf2);
                String substring2 = readFile.substring(indexOf2 + 1);
                AmplitudaResultJNI amplitudaResultJNI = new AmplitudaResultJNI();
                amplitudaResultJNI.setDuration(Double.parseDouble(substring));
                amplitudaResultJNI.setAmplitudes(substring2);
                return amplitudaResultJNI;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private synchronized <T> AmplitudaProcessingOutput<T> errorOutput(AmplitudaException amplitudaException, InputAudio<T> inputAudio, AmplitudaProgressListener amplitudaProgressListener) {
        stopProgress(amplitudaProgressListener);
        return new AmplitudaProcessingOutput<>(amplitudaException, inputAudio);
    }

    private synchronized <T> AmplitudaResultJNI processFileJNI(File file, InputAudio<T> inputAudio, Compress compress, Cache cache, AmplitudaProgressListener amplitudaProgressListener) {
        AmplitudaResultJNI amplitudaResultJNI;
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            updateProgressOperation(amplitudaProgressListener, ProgressOperation.PROCESSING);
            File cacheFile = this.fileManager.getCacheFile(String.valueOf(file.hashCode()), cache.getKey());
            amplitudaResultJNI = null;
            if (cache.getState() == 2) {
                amplitudaResultJNI = amplitudesFromCache(cacheFile);
            }
            if (amplitudaResultJNI == null) {
                AmplitudaLogger.log("Process audio " + file.getPath());
                amplitudaResultJNI = amplitudesFromAudioJNI(file.getPath(), compress.getType(), compress.getPreferredSamplesPerSecond(), cacheFile.getPath(), cache.isEnabled(), amplitudaProgressListener);
            } else {
                AmplitudaLogger.log(String.format(Locale.US, "Found cache data \"%s\" for audio \"%s\"", cacheFile.getName(), file.getName()));
            }
            inputAudio.setDuration(amplitudaResultJNI.getDurationMillis());
            AmplitudaLogger.logOperationTime(AmplitudaLogger.OPERATION_PROCESSING, currentTimeMillis);
            stopProgress(amplitudaProgressListener);
        } else {
            throw new FileNotFoundException();
        }
        return amplitudaResultJNI;
    }

    private synchronized void startProgress(AmplitudaProgressListener amplitudaProgressListener) {
        if (amplitudaProgressListener != null) {
            amplitudaProgressListener.onStartProgress();
        }
    }

    private synchronized void stopProgress(AmplitudaProgressListener amplitudaProgressListener) {
        if (amplitudaProgressListener != null) {
            amplitudaProgressListener.onStopProgress();
        }
    }

    private synchronized void updateProgressOperation(AmplitudaProgressListener amplitudaProgressListener, ProgressOperation progressOperation) {
        if (amplitudaProgressListener != null) {
            amplitudaProgressListener.onOperationChanged(progressOperation);
        }
    }

    public native AmplitudaResultJNI amplitudesFromAudioJNI(String str, int i7, int i8, String str2, boolean z6, AmplitudaProgressListener amplitudaProgressListener);

    public Amplituda clearCache() {
        this.fileManager.clearAllCacheFiles();
        return this;
    }

    public Amplituda clearCache(int i7) {
        clearCache(String.valueOf(i7), true);
        return this;
    }

    public Amplituda clearCache(File file) {
        clearCache(String.valueOf(file.hashCode()), true);
        return this;
    }

    public Amplituda clearCache(InputStream inputStream) {
        clearCache(this.fileManager.getInputStreamHashString(inputStream), true);
        return this;
    }

    public Amplituda clearCache(String str, boolean z6) {
        FileManager fileManager = this.fileManager;
        if (!z6) {
            str = String.valueOf(str.hashCode());
        }
        fileManager.clearCache(str);
        return this;
    }

    public Amplituda clearCache(byte[] bArr) {
        clearCache(String.valueOf(Arrays.hashCode(bArr)), true);
        return this;
    }

    public AmplitudaProcessingOutput<Integer> processAudio(int i7) {
        return processAudio(i7, Compress.getDefault(), Cache.getDefault(), (AmplitudaProgressListener) null);
    }

    public AmplitudaProcessingOutput<Integer> processAudio(int i7, AmplitudaProgressListener amplitudaProgressListener) {
        return processAudio(i7, Compress.getDefault(), Cache.getDefault(), amplitudaProgressListener);
    }

    public AmplitudaProcessingOutput<Integer> processAudio(int i7, Cache cache) {
        return processAudio(i7, Compress.getDefault(), cache, (AmplitudaProgressListener) null);
    }

    public AmplitudaProcessingOutput<Integer> processAudio(int i7, Cache cache, AmplitudaProgressListener amplitudaProgressListener) {
        return processAudio(i7, Compress.getDefault(), cache, amplitudaProgressListener);
    }

    public AmplitudaProcessingOutput<Integer> processAudio(int i7, Compress compress) {
        return processAudio(i7, compress, Cache.getDefault(), (AmplitudaProgressListener) null);
    }

    public AmplitudaProcessingOutput<Integer> processAudio(int i7, Compress compress, AmplitudaProgressListener amplitudaProgressListener) {
        return processAudio(i7, compress, Cache.getDefault(), amplitudaProgressListener);
    }

    public AmplitudaProcessingOutput<Integer> processAudio(int i7, Compress compress, Cache cache) {
        return processAudio(i7, compress, cache, (AmplitudaProgressListener) null);
    }

    public AmplitudaProcessingOutput<Integer> processAudio(int i7, Compress compress, Cache cache, AmplitudaProgressListener amplitudaProgressListener) {
        startProgress(amplitudaProgressListener);
        InputAudio inputAudio = new InputAudio(Integer.valueOf(i7), InputAudio.Type.RESOURCE);
        long currentTimeMillis = System.currentTimeMillis();
        updateProgressOperation(amplitudaProgressListener, ProgressOperation.DECODING);
        File rawFile = this.fileManager.getRawFile(i7, amplitudaProgressListener);
        if (rawFile == null) {
            return errorOutput(new InvalidRawResourceException(), inputAudio, amplitudaProgressListener);
        }
        AmplitudaLogger.logOperationTime(AmplitudaLogger.OPERATION_PREPARING, currentTimeMillis);
        try {
            AmplitudaResultJNI processFileJNI = processFileJNI(rawFile, inputAudio, compress, cache, amplitudaProgressListener);
            this.fileManager.deleteFile(rawFile);
            return new AmplitudaProcessingOutput<>(processFileJNI, inputAudio);
        } catch (AmplitudaException e) {
            return errorOutput(e, inputAudio, amplitudaProgressListener);
        }
    }

    public AmplitudaProcessingOutput<File> processAudio(File file) {
        return processAudio(file, Compress.getDefault(), Cache.getDefault(), (AmplitudaProgressListener) null);
    }

    public AmplitudaProcessingOutput<File> processAudio(File file, AmplitudaProgressListener amplitudaProgressListener) {
        return processAudio(file, Compress.getDefault(), Cache.getDefault(), amplitudaProgressListener);
    }

    public AmplitudaProcessingOutput<File> processAudio(File file, Cache cache) {
        return processAudio(file, Compress.getDefault(), cache, (AmplitudaProgressListener) null);
    }

    public AmplitudaProcessingOutput<File> processAudio(File file, Cache cache, AmplitudaProgressListener amplitudaProgressListener) {
        return processAudio(file, Compress.getDefault(), cache, amplitudaProgressListener);
    }

    public AmplitudaProcessingOutput<File> processAudio(File file, Compress compress) {
        return processAudio(file, compress, Cache.getDefault(), (AmplitudaProgressListener) null);
    }

    public AmplitudaProcessingOutput<File> processAudio(File file, Compress compress, AmplitudaProgressListener amplitudaProgressListener) {
        return processAudio(file, compress, Cache.getDefault(), amplitudaProgressListener);
    }

    public AmplitudaProcessingOutput<File> processAudio(File file, Compress compress, Cache cache) {
        return processAudio(file, compress, cache, (AmplitudaProgressListener) null);
    }

    public AmplitudaProcessingOutput<File> processAudio(File file, Compress compress, Cache cache, AmplitudaProgressListener amplitudaProgressListener) {
        startProgress(amplitudaProgressListener);
        InputAudio inputAudio = new InputAudio(file, InputAudio.Type.FILE);
        try {
            return new AmplitudaProcessingOutput<>(processFileJNI(file, inputAudio, compress, cache, amplitudaProgressListener), inputAudio);
        } catch (AmplitudaException e) {
            return errorOutput(e, inputAudio, amplitudaProgressListener);
        }
    }

    public AmplitudaProcessingOutput<InputStream> processAudio(InputStream inputStream) {
        return processAudio(inputStream, Compress.getDefault(), Cache.getDefault(), (AmplitudaProgressListener) null);
    }

    public AmplitudaProcessingOutput<InputStream> processAudio(InputStream inputStream, AmplitudaProgressListener amplitudaProgressListener) {
        return processAudio(inputStream, Compress.getDefault(), Cache.getDefault(), amplitudaProgressListener);
    }

    public AmplitudaProcessingOutput<InputStream> processAudio(InputStream inputStream, Cache cache) {
        return processAudio(inputStream, Compress.getDefault(), cache, (AmplitudaProgressListener) null);
    }

    public AmplitudaProcessingOutput<InputStream> processAudio(InputStream inputStream, Cache cache, AmplitudaProgressListener amplitudaProgressListener) {
        return processAudio(inputStream, Compress.getDefault(), cache, amplitudaProgressListener);
    }

    public AmplitudaProcessingOutput<InputStream> processAudio(InputStream inputStream, Compress compress) {
        return processAudio(inputStream, compress, Cache.getDefault(), (AmplitudaProgressListener) null);
    }

    public AmplitudaProcessingOutput<InputStream> processAudio(InputStream inputStream, Compress compress, AmplitudaProgressListener amplitudaProgressListener) {
        return processAudio(inputStream, compress, Cache.getDefault(), amplitudaProgressListener);
    }

    public AmplitudaProcessingOutput<InputStream> processAudio(InputStream inputStream, Compress compress, Cache cache) {
        return processAudio(inputStream, compress, cache, (AmplitudaProgressListener) null);
    }

    public AmplitudaProcessingOutput<InputStream> processAudio(InputStream inputStream, Compress compress, Cache cache, AmplitudaProgressListener amplitudaProgressListener) {
        startProgress(amplitudaProgressListener);
        InputAudio inputAudio = new InputAudio(inputStream, InputAudio.Type.INPUT_STREAM);
        try {
            updateProgressOperation(amplitudaProgressListener, ProgressOperation.DECODING);
            File inputStreamFile = this.fileManager.getInputStreamFile(inputStream, amplitudaProgressListener);
            if (inputStreamFile == null) {
                return errorOutput(new InvalidAudioInputStreamException(), inputAudio, amplitudaProgressListener);
            }
            AmplitudaProcessingOutput<InputStream> amplitudaProcessingOutput = new AmplitudaProcessingOutput<>(processFileJNI(inputStreamFile, inputAudio, compress, cache, amplitudaProgressListener), inputAudio);
            this.fileManager.deleteFile(inputStreamFile);
            return amplitudaProcessingOutput;
        } catch (AmplitudaException e) {
            return errorOutput(e, inputAudio, amplitudaProgressListener);
        }
    }

    public AmplitudaProcessingOutput<String> processAudio(String str) {
        return processAudio(str, Compress.getDefault(), Cache.getDefault(), (AmplitudaProgressListener) null);
    }

    public AmplitudaProcessingOutput<String> processAudio(String str, AmplitudaProgressListener amplitudaProgressListener) {
        return processAudio(str, Compress.getDefault(), Cache.getDefault(), amplitudaProgressListener);
    }

    public AmplitudaProcessingOutput<String> processAudio(String str, Cache cache) {
        return processAudio(str, Compress.getDefault(), cache, (AmplitudaProgressListener) null);
    }

    public AmplitudaProcessingOutput<String> processAudio(String str, Cache cache, AmplitudaProgressListener amplitudaProgressListener) {
        return processAudio(str, Compress.getDefault(), cache, amplitudaProgressListener);
    }

    public AmplitudaProcessingOutput<String> processAudio(String str, Compress compress) {
        return processAudio(str, compress, Cache.getDefault(), (AmplitudaProgressListener) null);
    }

    public AmplitudaProcessingOutput<String> processAudio(String str, Compress compress, AmplitudaProgressListener amplitudaProgressListener) {
        return processAudio(str, compress, Cache.getDefault(), amplitudaProgressListener);
    }

    public AmplitudaProcessingOutput<String> processAudio(String str, Compress compress, Cache cache) {
        return processAudio(str, compress, cache, (AmplitudaProgressListener) null);
    }

    public AmplitudaProcessingOutput<String> processAudio(String str, Compress compress, Cache cache, AmplitudaProgressListener amplitudaProgressListener) {
        startProgress(amplitudaProgressListener);
        InputAudio inputAudio = new InputAudio(str);
        try {
            if (!URLUtil.isValidUrl(str)) {
                inputAudio.setType(InputAudio.Type.PATH);
                return new AmplitudaProcessingOutput<>(processFileJNI(new File(str), inputAudio, compress, cache, amplitudaProgressListener), inputAudio);
            }
            inputAudio.setType(InputAudio.Type.URL);
            long currentTimeMillis = System.currentTimeMillis();
            updateProgressOperation(amplitudaProgressListener, ProgressOperation.DOWNLOADING);
            File urlFile = this.fileManager.getUrlFile(str, amplitudaProgressListener);
            if (urlFile == null) {
                return errorOutput(new InvalidAudioUrlException(), inputAudio, amplitudaProgressListener);
            }
            AmplitudaLogger.logOperationTime(AmplitudaLogger.OPERATION_PREPARING, currentTimeMillis);
            AmplitudaResultJNI processFileJNI = processFileJNI(urlFile, inputAudio, compress, cache, amplitudaProgressListener);
            this.fileManager.deleteFile(urlFile);
            return new AmplitudaProcessingOutput<>(processFileJNI, inputAudio);
        } catch (AmplitudaException e) {
            return errorOutput(e, inputAudio, amplitudaProgressListener);
        }
    }

    public AmplitudaProcessingOutput<byte[]> processAudio(byte[] bArr) {
        return processAudio(bArr, Compress.getDefault(), Cache.getDefault(), (AmplitudaProgressListener) null);
    }

    public AmplitudaProcessingOutput<byte[]> processAudio(byte[] bArr, AmplitudaProgressListener amplitudaProgressListener) {
        return processAudio(bArr, Compress.getDefault(), Cache.getDefault(), amplitudaProgressListener);
    }

    public AmplitudaProcessingOutput<byte[]> processAudio(byte[] bArr, Cache cache) {
        return processAudio(bArr, Compress.getDefault(), cache, (AmplitudaProgressListener) null);
    }

    public AmplitudaProcessingOutput<byte[]> processAudio(byte[] bArr, Cache cache, AmplitudaProgressListener amplitudaProgressListener) {
        return processAudio(bArr, Compress.getDefault(), cache, amplitudaProgressListener);
    }

    public AmplitudaProcessingOutput<byte[]> processAudio(byte[] bArr, Compress compress) {
        return processAudio(bArr, compress, Cache.getDefault(), (AmplitudaProgressListener) null);
    }

    public AmplitudaProcessingOutput<byte[]> processAudio(byte[] bArr, Compress compress, AmplitudaProgressListener amplitudaProgressListener) {
        return processAudio(bArr, compress, Cache.getDefault(), amplitudaProgressListener);
    }

    public AmplitudaProcessingOutput<byte[]> processAudio(byte[] bArr, Compress compress, Cache cache) {
        return processAudio(bArr, compress, cache, (AmplitudaProgressListener) null);
    }

    public AmplitudaProcessingOutput<byte[]> processAudio(byte[] bArr, Compress compress, Cache cache, AmplitudaProgressListener amplitudaProgressListener) {
        startProgress(amplitudaProgressListener);
        InputAudio inputAudio = new InputAudio(bArr, InputAudio.Type.BYTE_ARRAY);
        try {
            updateProgressOperation(amplitudaProgressListener, ProgressOperation.DECODING);
            File byteArrayFile = this.fileManager.getByteArrayFile(bArr, amplitudaProgressListener);
            if (byteArrayFile == null) {
                return errorOutput(new InvalidAudioByteArrayException(), inputAudio, amplitudaProgressListener);
            }
            AmplitudaProcessingOutput<byte[]> amplitudaProcessingOutput = new AmplitudaProcessingOutput<>(processFileJNI(byteArrayFile, inputAudio, compress, cache, amplitudaProgressListener), inputAudio);
            this.fileManager.deleteFile(byteArrayFile);
            return amplitudaProcessingOutput;
        } catch (AmplitudaException e) {
            return errorOutput(e, inputAudio, amplitudaProgressListener);
        }
    }

    public Amplituda setLogConfig(int i7, boolean z6) {
        AmplitudaLogger.enable(z6);
        AmplitudaLogger.priority(i7);
        return this;
    }
}
