package d4;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import d4.s;
import p1.p;
import p1.p0;
import r3.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class q implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s.a f3635a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s.b f3636b;

    public q(b bVar, s.b bVar2) {
        this.f3635a = bVar;
        this.f3636b = bVar2;
    }

    @Override // p1.p
    public final p0 a(View view, p0 p0Var) {
        int i7;
        int i8;
        int i9;
        s.a aVar = this.f3635a;
        s.b bVar = this.f3636b;
        int i10 = bVar.f3637a;
        int i11 = bVar.f3638b;
        int i12 = bVar.f3639c;
        b bVar2 = (b) aVar;
        bVar2.getClass();
        i1.b a7 = p0Var.a(7);
        i1.b a8 = p0Var.a(32);
        bVar2.f5899b.B = a7.f4463b;
        boolean a9 = s.a(view);
        int paddingBottom = view.getPaddingBottom();
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        BottomSheetBehavior bottomSheetBehavior = bVar2.f5899b;
        if (bottomSheetBehavior.f2864t) {
            bottomSheetBehavior.A = p0Var.b();
            paddingBottom = bVar2.f5899b.A + i12;
        }
        BottomSheetBehavior bottomSheetBehavior2 = bVar2.f5899b;
        if (bottomSheetBehavior2.f2865u) {
            paddingLeft = (a9 ? i11 : i10) + a7.f4462a;
        }
        if (bottomSheetBehavior2.f2866v) {
            if (!a9) {
                i10 = i11;
            }
            paddingRight = i10 + a7.f4464c;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        BottomSheetBehavior bottomSheetBehavior3 = bVar2.f5899b;
        boolean z6 = false;
        z6 = true;
        if (bottomSheetBehavior3.f2868x && marginLayoutParams.leftMargin != (i9 = a7.f4462a)) {
            marginLayoutParams.leftMargin = i9;
            z6 = true;
        }
        if (bottomSheetBehavior3.f2869y && marginLayoutParams.rightMargin != (i8 = a7.f4464c)) {
            marginLayoutParams.rightMargin = i8;
            z6 = true;
        }
        if (bottomSheetBehavior3.f2870z && marginLayoutParams.topMargin != (i7 = a7.f4463b)) {
            marginLayoutParams.topMargin = i7;
        }
        if (z6) {
            view.setLayoutParams(marginLayoutParams);
        }
        view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
        boolean z7 = bVar2.f5898a;
        if (z7) {
            bVar2.f5899b.f2863r = a8.f4465d;
        }
        BottomSheetBehavior bottomSheetBehavior4 = bVar2.f5899b;
        if (bottomSheetBehavior4.f2864t || z7) {
            bottomSheetBehavior4.R();
        }
        return p0Var;
    }
}
