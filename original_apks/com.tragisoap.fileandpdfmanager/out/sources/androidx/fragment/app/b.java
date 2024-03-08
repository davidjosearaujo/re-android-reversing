package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.f0;
import java.util.ArrayList;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: f  reason: collision with root package name */
    public final int[] f1580f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList<String> f1581g;

    /* renamed from: h  reason: collision with root package name */
    public final int[] f1582h;

    /* renamed from: i  reason: collision with root package name */
    public final int[] f1583i;

    /* renamed from: j  reason: collision with root package name */
    public final int f1584j;

    /* renamed from: k  reason: collision with root package name */
    public final String f1585k;

    /* renamed from: l  reason: collision with root package name */
    public final int f1586l;
    public final int m;

    /* renamed from: n  reason: collision with root package name */
    public final CharSequence f1587n;

    /* renamed from: o  reason: collision with root package name */
    public final int f1588o;

    /* renamed from: p  reason: collision with root package name */
    public final CharSequence f1589p;

    /* renamed from: q  reason: collision with root package name */
    public final ArrayList<String> f1590q;

    /* renamed from: r  reason: collision with root package name */
    public final ArrayList<String> f1591r;
    public final boolean s;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements Parcelable.Creator<b> {
        @Override // android.os.Parcelable.Creator
        public final b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final b[] newArray(int i7) {
            return new b[i7];
        }
    }

    public b(Parcel parcel) {
        this.f1580f = parcel.createIntArray();
        this.f1581g = parcel.createStringArrayList();
        this.f1582h = parcel.createIntArray();
        this.f1583i = parcel.createIntArray();
        this.f1584j = parcel.readInt();
        this.f1585k = parcel.readString();
        this.f1586l = parcel.readInt();
        this.m = parcel.readInt();
        this.f1587n = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1588o = parcel.readInt();
        this.f1589p = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1590q = parcel.createStringArrayList();
        this.f1591r = parcel.createStringArrayList();
        this.s = parcel.readInt() != 0;
    }

    public b(a aVar) {
        int size = aVar.f1624a.size();
        this.f1580f = new int[size * 5];
        if (aVar.f1629g) {
            this.f1581g = new ArrayList<>(size);
            this.f1582h = new int[size];
            this.f1583i = new int[size];
            int i7 = 0;
            for (int i8 = 0; i8 < size; i8++) {
                f0.a aVar2 = aVar.f1624a.get(i8);
                int i9 = i7 + 1;
                this.f1580f[i7] = aVar2.f1637a;
                ArrayList<String> arrayList = this.f1581g;
                n nVar = aVar2.f1638b;
                arrayList.add(nVar != null ? nVar.f1704j : null);
                int[] iArr = this.f1580f;
                int i10 = i9 + 1;
                iArr[i9] = aVar2.f1639c;
                int i11 = i10 + 1;
                iArr[i10] = aVar2.f1640d;
                int i12 = i11 + 1;
                iArr[i11] = aVar2.e;
                i7 = i12 + 1;
                iArr[i12] = aVar2.f1641f;
                this.f1582h[i8] = aVar2.f1642g.ordinal();
                this.f1583i[i8] = aVar2.f1643h.ordinal();
            }
            this.f1584j = aVar.f1628f;
            this.f1585k = aVar.f1630h;
            this.f1586l = aVar.f1573r;
            this.m = aVar.f1631i;
            this.f1587n = aVar.f1632j;
            this.f1588o = aVar.f1633k;
            this.f1589p = aVar.f1634l;
            this.f1590q = aVar.m;
            this.f1591r = aVar.f1635n;
            this.s = aVar.f1636o;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        parcel.writeIntArray(this.f1580f);
        parcel.writeStringList(this.f1581g);
        parcel.writeIntArray(this.f1582h);
        parcel.writeIntArray(this.f1583i);
        parcel.writeInt(this.f1584j);
        parcel.writeString(this.f1585k);
        parcel.writeInt(this.f1586l);
        parcel.writeInt(this.m);
        TextUtils.writeToParcel(this.f1587n, parcel, 0);
        parcel.writeInt(this.f1588o);
        TextUtils.writeToParcel(this.f1589p, parcel, 0);
        parcel.writeStringList(this.f1590q);
        parcel.writeStringList(this.f1591r);
        parcel.writeInt(this.s ? 1 : 0);
    }
}
