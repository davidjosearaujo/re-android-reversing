package linc.com.amplituda;

/* loaded from: classes.dex */
public abstract class AmplitudaProgressListener {
    private ProgressOperation operation;

    public void onOperationChanged(ProgressOperation progressOperation) {
        this.operation = progressOperation;
    }

    public abstract void onProgress(ProgressOperation progressOperation, int i7);

    public void onProgressInternal(int i7) {
        onProgress(this.operation, i7);
    }

    public void onStartProgress() {
    }

    public void onStopProgress() {
    }
}
