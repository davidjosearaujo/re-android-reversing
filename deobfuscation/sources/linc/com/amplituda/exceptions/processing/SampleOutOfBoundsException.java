package linc.com.amplituda.exceptions.processing;

/* loaded from: classes.dex */
public final class SampleOutOfBoundsException extends AmplitudaProcessingException {
    public SampleOutOfBoundsException() {
        super("Sample out of bound. Check `Compress` parameter: preferredSamplesPerSecond.", 40);
    }
}
