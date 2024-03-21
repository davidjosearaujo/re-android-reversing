package a.a.a.a;

import android.annotation.TargetApi;
import android.app.RemoteInput;
@TargetApi(20)
/* loaded from: /home/remnux/decompressedMalicious.dex */
class k0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static RemoteInput[] a(l0[] l0VarArr) {
        if (l0VarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[l0VarArr.length];
        for (int i = 0; i < l0VarArr.length; i++) {
            l0 l0Var = l0VarArr[i];
            remoteInputArr[i] = new RemoteInput.Builder(l0Var.e()).setLabel(l0Var.d()).setChoices(l0Var.b()).setAllowFreeFormInput(l0Var.a()).addExtras(l0Var.c()).build();
        }
        return remoteInputArr;
    }
}
