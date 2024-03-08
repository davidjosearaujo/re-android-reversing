package linc.com.amplituda.exceptions.processing;

import java.util.Locale;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class SecondOutOfBoundsException extends AmplitudaProcessingException {
    public SecondOutOfBoundsException() {
        this(0, 0);
    }

    public SecondOutOfBoundsException(int i7, int i8) {
        super(String.format(Locale.getDefault(), "Cannot extract amplitudes for second %d when input audio duration = %d", Integer.valueOf(i7), Integer.valueOf(i8)), 39);
    }
}
