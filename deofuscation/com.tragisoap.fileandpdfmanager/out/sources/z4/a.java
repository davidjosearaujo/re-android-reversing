package z4;

import androidx.activity.h;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import y4.i;
import y4.p;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<i> f6930a;

    /* renamed from: b  reason: collision with root package name */
    public int f6931b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6932c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6933d;

    public a(List<i> list) {
        this.f6930a = list;
    }

    public final i a(SSLSocket sSLSocket) {
        i iVar;
        boolean z6;
        int i7 = this.f6931b;
        int size = this.f6930a.size();
        while (true) {
            if (i7 >= size) {
                iVar = null;
                break;
            }
            iVar = this.f6930a.get(i7);
            if (iVar.a(sSLSocket)) {
                this.f6931b = i7 + 1;
                break;
            }
            i7++;
        }
        if (iVar != null) {
            int i8 = this.f6931b;
            while (true) {
                if (i8 >= this.f6930a.size()) {
                    z6 = false;
                    break;
                } else if (this.f6930a.get(i8).a(sSLSocket)) {
                    z6 = true;
                    break;
                } else {
                    i8++;
                }
            }
            this.f6932c = z6;
            p.a aVar = b.f6935b;
            boolean z7 = this.f6933d;
            aVar.getClass();
            String[] strArr = iVar.f6734c;
            String[] enabledCipherSuites = strArr != null ? (String[]) h.g(strArr, sSLSocket.getEnabledCipherSuites()) : sSLSocket.getEnabledCipherSuites();
            String[] strArr2 = iVar.f6735d;
            String[] enabledProtocols = strArr2 != null ? (String[]) h.g(strArr2, sSLSocket.getEnabledProtocols()) : sSLSocket.getEnabledProtocols();
            if (z7) {
                String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
                byte[] bArr = h.f6955a;
                if (Arrays.asList(supportedCipherSuites).contains("TLS_FALLBACK_SCSV")) {
                    int length = enabledCipherSuites.length + 1;
                    String[] strArr3 = new String[length];
                    System.arraycopy(enabledCipherSuites, 0, strArr3, 0, enabledCipherSuites.length);
                    strArr3[length - 1] = "TLS_FALLBACK_SCSV";
                    enabledCipherSuites = strArr3;
                }
            }
            i.a aVar2 = new i.a(iVar);
            aVar2.a(enabledCipherSuites);
            aVar2.b(enabledProtocols);
            i iVar2 = new i(aVar2);
            String[] strArr4 = iVar2.f6735d;
            if (strArr4 != null) {
                sSLSocket.setEnabledProtocols(strArr4);
            }
            String[] strArr5 = iVar2.f6734c;
            if (strArr5 != null) {
                sSLSocket.setEnabledCipherSuites(strArr5);
            }
            return iVar;
        }
        StringBuilder d7 = h.d("Unable to find acceptable protocols. isFallback=");
        d7.append(this.f6933d);
        d7.append(", modes=");
        d7.append(this.f6930a);
        d7.append(", supported protocols=");
        d7.append(Arrays.toString(sSLSocket.getEnabledProtocols()));
        throw new UnknownServiceException(d7.toString());
    }
}
