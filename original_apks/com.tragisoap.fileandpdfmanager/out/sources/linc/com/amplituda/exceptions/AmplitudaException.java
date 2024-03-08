package linc.com.amplituda.exceptions;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class AmplitudaException extends Exception {
    public final int code;

    public AmplitudaException() {
        this("Something went wrong!", 1);
    }

    public AmplitudaException(String str, int i7) {
        super(String.format("%s\nRead Amplituda doc here: https://github.com/lincollincol/Amplituda", str));
        this.code = i7;
    }

    public int getCode() {
        return this.code;
    }
}
