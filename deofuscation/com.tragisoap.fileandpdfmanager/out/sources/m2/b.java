package m2;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.activity.h;
import java.lang.reflect.Method;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b extends a {

    /* renamed from: d  reason: collision with root package name */
    public final SparseIntArray f5083d;
    public final Parcel e;

    /* renamed from: f  reason: collision with root package name */
    public final int f5084f;

    /* renamed from: g  reason: collision with root package name */
    public final int f5085g;

    /* renamed from: h  reason: collision with root package name */
    public final String f5086h;

    /* renamed from: i  reason: collision with root package name */
    public int f5087i;

    /* renamed from: j  reason: collision with root package name */
    public int f5088j;

    /* renamed from: k  reason: collision with root package name */
    public int f5089k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new o.b(), new o.b(), new o.b());
    }

    public b(Parcel parcel, int i7, int i8, String str, o.b<String, Method> bVar, o.b<String, Method> bVar2, o.b<String, Class> bVar3) {
        super(bVar, bVar2, bVar3);
        this.f5083d = new SparseIntArray();
        this.f5087i = -1;
        this.f5089k = -1;
        this.e = parcel;
        this.f5084f = i7;
        this.f5085g = i8;
        this.f5088j = i7;
        this.f5086h = str;
    }

    @Override // m2.a
    public final b a() {
        Parcel parcel = this.e;
        int dataPosition = parcel.dataPosition();
        int i7 = this.f5088j;
        if (i7 == this.f5084f) {
            i7 = this.f5085g;
        }
        return new b(parcel, dataPosition, i7, h.c(new StringBuilder(), this.f5086h, "  "), this.f5080a, this.f5081b, this.f5082c);
    }

    @Override // m2.a
    public final boolean e() {
        return this.e.readInt() != 0;
    }

    @Override // m2.a
    public final byte[] f() {
        int readInt = this.e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.e.readByteArray(bArr);
        return bArr;
    }

    @Override // m2.a
    public final CharSequence g() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.e);
    }

    @Override // m2.a
    public final boolean h(int i7) {
        while (this.f5088j < this.f5085g) {
            int i8 = this.f5089k;
            if (i8 == i7) {
                return true;
            }
            if (String.valueOf(i8).compareTo(String.valueOf(i7)) > 0) {
                return false;
            }
            this.e.setDataPosition(this.f5088j);
            int readInt = this.e.readInt();
            this.f5089k = this.e.readInt();
            this.f5088j += readInt;
        }
        return this.f5089k == i7;
    }

    @Override // m2.a
    public final int i() {
        return this.e.readInt();
    }

    @Override // m2.a
    public final <T extends Parcelable> T j() {
        return (T) this.e.readParcelable(b.class.getClassLoader());
    }

    @Override // m2.a
    public final String k() {
        return this.e.readString();
    }

    @Override // m2.a
    public final void m(int i7) {
        u();
        this.f5087i = i7;
        this.f5083d.put(i7, this.e.dataPosition());
        q(0);
        q(i7);
    }

    @Override // m2.a
    public final void n(boolean z6) {
        this.e.writeInt(z6 ? 1 : 0);
    }

    @Override // m2.a
    public final void o(byte[] bArr) {
        if (bArr != null) {
            this.e.writeInt(bArr.length);
            this.e.writeByteArray(bArr);
            return;
        }
        this.e.writeInt(-1);
    }

    @Override // m2.a
    public final void p(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.e, 0);
    }

    @Override // m2.a
    public final void q(int i7) {
        this.e.writeInt(i7);
    }

    @Override // m2.a
    public final void r(Parcelable parcelable) {
        this.e.writeParcelable(parcelable, 0);
    }

    @Override // m2.a
    public final void s(String str) {
        this.e.writeString(str);
    }

    public final void u() {
        int i7 = this.f5087i;
        if (i7 >= 0) {
            int i8 = this.f5083d.get(i7);
            int dataPosition = this.e.dataPosition();
            this.e.setDataPosition(i8);
            this.e.writeInt(dataPosition - i8);
            this.e.setDataPosition(dataPosition);
        }
    }
}
