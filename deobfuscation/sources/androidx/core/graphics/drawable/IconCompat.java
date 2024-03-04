package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Parcelable;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.davemorrissey.labs.subscaleview.R;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k */
    public static final PorterDuff.Mode f1471k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    public Object f1473b;

    /* renamed from: j */
    public String f1480j;

    /* renamed from: a */
    public int f1472a = -1;

    /* renamed from: c */
    public byte[] f1474c = null;

    /* renamed from: d */
    public Parcelable f1475d = null;
    public int e = 0;

    /* renamed from: f */
    public int f1476f = 0;

    /* renamed from: g */
    public ColorStateList f1477g = null;

    /* renamed from: h */
    public PorterDuff.Mode f1478h = f1471k;

    /* renamed from: i */
    public String f1479i = null;

    /* loaded from: classes.dex */
    public static class a {
        public static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        public static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        public static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        public static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    public final String toString() {
        String str;
        int height;
        int i7;
        if (this.f1472a == -1) {
            return String.valueOf(this.f1473b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f1472a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.f1472a) {
            case 1:
            case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                sb.append(" size=");
                sb.append(((Bitmap) this.f1473b).getWidth());
                sb.append("x");
                height = ((Bitmap) this.f1473b).getHeight();
                sb.append(height);
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f1480j);
                sb.append(" id=");
                Object[] objArr = new Object[1];
                int i8 = this.f1472a;
                if (i8 == -1) {
                    i7 = a.a(this.f1473b);
                } else if (i8 != 2) {
                    throw new IllegalStateException("called getResId() on " + this);
                } else {
                    i7 = this.e;
                }
                objArr[0] = Integer.valueOf(i7);
                sb.append(String.format("0x%08x", objArr));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.e);
                if (this.f1476f != 0) {
                    sb.append(" off=");
                    height = this.f1476f;
                    sb.append(height);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f1473b);
                break;
        }
        if (this.f1477g != null) {
            sb.append(" tint=");
            sb.append(this.f1477g);
        }
        if (this.f1478h != f1471k) {
            sb.append(" mode=");
            sb.append(this.f1478h);
        }
        sb.append(")");
        return sb.toString();
    }
}
