package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import b.a.a.a.c.a;
import b.a.a.a.c.c;
import b.a.a.a.e.t;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {
    private static short[] $ = {9562, 9551, 9540, 9550, 9539, 9540, 9549, 9589, 9539, 9540, 9566, 9551, 9540, 9566, 2301, 2298, 2290, 2295, 2290, 2293, 2300, 2244, 2296, 2295, 2290, 2302, 2293, 2287, 2244, 2290, 2303, 2604, 2605, 2614, 2603, 2596, 2619, 2589, 2607, 2595, 2604, 2595, 2597, 2599, 2608, -32374, -32373, -32368, -32371, -32382, -32355, -32325, -32375, -32379, -32374, -32379, -32381, -32383, -32362, -28510, -28507, -28499, -28504, -28499, -28502, -28509, -28517, -28505, -28504, -28499, -28511, -28502, -28496, -28517, -28499, -28512, 31292, 31275, 31293, 31265, 31266, 31291, 31290, 31271, 31265, 31264, 20980, 20956, 20956, 20948, 20959, 20950, 20978, 20931, 20954, 20978, 20944, 20935, 20954, 20933, 20954, 20935, 20938, 29432, 29402, 29389, 29392, 29391, 29392, 29389, 29376, 29337, 29386, 29389, 29400, 29387, 29389, 29404, 29405, 29337, 29390, 29392, 29389, 29393, 29398, 29388, 29389, 29337, 29404, 29377, 29389, 29387, 29400, 29386, 28637, 28616, 28611, 28617, 28612, 28611, 28618, 28658, 28612, 28611, 28633, 28616, 28611, 28633, 26948, 26963, 26963, 26958, 26963, 27006, 26946, 26958, 26949, 26948, 30601, 30635, 30652, 30625, 30654, 30625, 30652, 30641, 30696, 30651, 30652, 30633, 30650, 30652, 30637, 30636, 30696, 30655, 30625, 30652, 30624, 30631, 30653, 30652, 30696, 30650, 30637, 30651, 30631, 30628, 30653, 30652, 30625, 30631, 30630, 21330, 21365, 21373, 21368, 21361, 21360, 21300, 21344, 21371, 21300, 21368, 21365, 21345, 21370, 21367, 21372, 21300, 21348, 21361, 21370, 21360, 21373, 21370, 21363, 21341, 21370, 21344, 21361, 21370, 21344, 14501, 14514, 14500, 14520, 14523, 14498, 14499, 14526, 14520, 14521};

    /* renamed from: a  reason: collision with root package name */
    private int f225a = 0;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static PendingIntent a(Context context, PendingIntent pendingIntent, int i) {
        return PendingIntent.getActivity(context, 0, b(context, pendingIntent, i, true), 134217728);
    }

    public static Intent b(Context context, PendingIntent pendingIntent, int i, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra($(0, 14, 9514), pendingIntent);
        intent.putExtra($(14, 31, 2203), i);
        intent.putExtra($(31, 45, 2626), z);
        return intent;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra($(45, 59, -32284), true);
            this.f225a = 0;
            setResult(i2, intent);
            if (booleanExtra) {
                t e = t.e(this);
                if (i2 == -1) {
                    e.r();
                } else if (i2 == 0) {
                    e.c(new a(13, null), getIntent().getIntExtra($(59, 76, -28476), -1));
                }
            }
        } else if (i == 2) {
            this.f225a = 0;
            setResult(i2, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f225a = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        String $2;
        super.onCreate(bundle);
        if (bundle != null) {
            this.f225a = bundle.getInt($(76, 86, 31310));
        }
        if (this.f225a != 1) {
            Bundle extras = getIntent().getExtras();
            String $3 = $(86, 103, 20915);
            if (extras == null) {
                $2 = $(103, 134, 29369);
            } else {
                PendingIntent pendingIntent = (PendingIntent) extras.get($(134, 148, 28589));
                Integer num = (Integer) extras.get($(148, 158, 26913));
                if (pendingIntent == null && num == null) {
                    $2 = $(158, 193, 30664);
                } else if (pendingIntent != null) {
                    try {
                        startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                        this.f225a = 1;
                        return;
                    } catch (IntentSender.SendIntentException e) {
                        Log.e($3, $(193, 223, 21268), e);
                    }
                } else {
                    c.j().k(this, num.intValue(), 2, this);
                    this.f225a = 1;
                    return;
                }
            }
            Log.e($3, $2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt($(223, 233, 14551), this.f225a);
        super.onSaveInstanceState(bundle);
    }
}
