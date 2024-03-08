package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import com.davemorrissey.labs.subscaleview.R;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.nio.charset.Charset;
import m2.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        Parcelable parcelable;
        IconCompat iconCompat = new IconCompat();
        int i7 = iconCompat.f1472a;
        if (aVar.h(1)) {
            i7 = aVar.i();
        }
        iconCompat.f1472a = i7;
        byte[] bArr = iconCompat.f1474c;
        if (aVar.h(2)) {
            bArr = aVar.f();
        }
        iconCompat.f1474c = bArr;
        Parcelable parcelable2 = iconCompat.f1475d;
        if (aVar.h(3)) {
            parcelable2 = aVar.j();
        }
        iconCompat.f1475d = parcelable2;
        int i8 = iconCompat.e;
        if (aVar.h(4)) {
            i8 = aVar.i();
        }
        iconCompat.e = i8;
        int i9 = iconCompat.f1476f;
        if (aVar.h(5)) {
            i9 = aVar.i();
        }
        iconCompat.f1476f = i9;
        Parcelable parcelable3 = iconCompat.f1477g;
        if (aVar.h(6)) {
            parcelable3 = aVar.j();
        }
        iconCompat.f1477g = (ColorStateList) parcelable3;
        String str = iconCompat.f1479i;
        if (aVar.h(7)) {
            str = aVar.k();
        }
        iconCompat.f1479i = str;
        String str2 = iconCompat.f1480j;
        if (aVar.h(8)) {
            str2 = aVar.k();
        }
        iconCompat.f1480j = str2;
        iconCompat.f1478h = PorterDuff.Mode.valueOf(iconCompat.f1479i);
        switch (iconCompat.f1472a) {
            case SubsamplingScaleImageView.ORIENTATION_USE_EXIF /* -1 */:
                parcelable = iconCompat.f1475d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f1473b = parcelable;
                break;
            case 1:
            case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                parcelable = iconCompat.f1475d;
                if (parcelable == null) {
                    byte[] bArr2 = iconCompat.f1474c;
                    iconCompat.f1473b = bArr2;
                    iconCompat.f1472a = 3;
                    iconCompat.e = 0;
                    iconCompat.f1476f = bArr2.length;
                    break;
                }
                iconCompat.f1473b = parcelable;
                break;
            case 2:
            case 4:
            case 6:
                String str3 = new String(iconCompat.f1474c, Charset.forName("UTF-16"));
                iconCompat.f1473b = str3;
                if (iconCompat.f1472a == 2 && iconCompat.f1480j == null) {
                    iconCompat.f1480j = str3.split(":", -1)[0];
                    break;
                }
                break;
            case 3:
                iconCompat.f1473b = iconCompat.f1474c;
                break;
        }
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.getClass();
        iconCompat.f1479i = iconCompat.f1478h.name();
        switch (iconCompat.f1472a) {
            case SubsamplingScaleImageView.ORIENTATION_USE_EXIF /* -1 */:
            case 1:
            case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                iconCompat.f1475d = (Parcelable) iconCompat.f1473b;
                break;
            case 2:
                iconCompat.f1474c = ((String) iconCompat.f1473b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f1474c = (byte[]) iconCompat.f1473b;
                break;
            case 4:
            case 6:
                iconCompat.f1474c = iconCompat.f1473b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i7 = iconCompat.f1472a;
        if (-1 != i7) {
            aVar.m(1);
            aVar.q(i7);
        }
        byte[] bArr = iconCompat.f1474c;
        if (bArr != null) {
            aVar.m(2);
            aVar.o(bArr);
        }
        Parcelable parcelable = iconCompat.f1475d;
        if (parcelable != null) {
            aVar.m(3);
            aVar.r(parcelable);
        }
        int i8 = iconCompat.e;
        if (i8 != 0) {
            aVar.m(4);
            aVar.q(i8);
        }
        int i9 = iconCompat.f1476f;
        if (i9 != 0) {
            aVar.m(5);
            aVar.q(i9);
        }
        ColorStateList colorStateList = iconCompat.f1477g;
        if (colorStateList != null) {
            aVar.m(6);
            aVar.r(colorStateList);
        }
        String str = iconCompat.f1479i;
        if (str != null) {
            aVar.m(7);
            aVar.s(str);
        }
        String str2 = iconCompat.f1480j;
        if (str2 != null) {
            aVar.m(8);
            aVar.s(str2);
        }
    }
}
