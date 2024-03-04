package linc.com.amplituda;

import java.util.Iterator;
import java.util.LinkedHashSet;
import linc.com.amplituda.callback.AmplitudaErrorListener;
import linc.com.amplituda.callback.AmplitudaSuccessListener;
import linc.com.amplituda.exceptions.AmplitudaException;

/* loaded from: classes.dex */
public final class AmplitudaProcessingOutput<T> {
    private final AmplitudaResult<T> amplitudaResult;
    private LinkedHashSet<AmplitudaException> processingErrors;

    public AmplitudaProcessingOutput(String str, InputAudio<T> inputAudio) {
        this.processingErrors = new LinkedHashSet<>();
        this.amplitudaResult = new AmplitudaResult<>(str, inputAudio);
    }

    public AmplitudaProcessingOutput(AmplitudaResultJNI amplitudaResultJNI, InputAudio<T> inputAudio) {
        this(amplitudaResultJNI.getAmplitudes(), inputAudio);
        this.processingErrors.addAll(amplitudaResultJNI.getErrors());
    }

    public AmplitudaProcessingOutput(AmplitudaException amplitudaException, InputAudio<T> inputAudio) {
        this("", inputAudio);
        this.processingErrors.add(amplitudaException);
    }

    private void handleAmplitudaProcessingErrors(AmplitudaErrorListener amplitudaErrorListener) {
        if (this.processingErrors.isEmpty()) {
            this.processingErrors = null;
            return;
        }
        Iterator<AmplitudaException> it = this.processingErrors.iterator();
        while (it.hasNext()) {
            throwException(it.next(), amplitudaErrorListener);
        }
        this.processingErrors.clear();
        this.processingErrors = null;
    }

    private void throwException(AmplitudaException amplitudaException, AmplitudaErrorListener amplitudaErrorListener) {
        if (amplitudaErrorListener == null) {
            this.processingErrors.add(amplitudaException);
        } else {
            amplitudaErrorListener.onError(amplitudaException);
        }
    }

    public AmplitudaResult<T> get() {
        return this.amplitudaResult;
    }

    public AmplitudaResult<T> get(AmplitudaErrorListener amplitudaErrorListener) {
        handleAmplitudaProcessingErrors(amplitudaErrorListener);
        return this.amplitudaResult;
    }

    public void get(AmplitudaSuccessListener<T> amplitudaSuccessListener) {
        get(amplitudaSuccessListener, null);
    }

    public void get(AmplitudaSuccessListener<T> amplitudaSuccessListener, AmplitudaErrorListener amplitudaErrorListener) {
        handleAmplitudaProcessingErrors(amplitudaErrorListener);
        amplitudaSuccessListener.onSuccess(this.amplitudaResult);
    }
}
