package j6;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.m;
import androidx.fragment.app.q;
import androidx.fragment.app.u;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.Objects;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class a extends m {

    /* renamed from: s0 */
    public static final /* synthetic */ int f4599s0 = 0;

    /* renamed from: m0 */
    public ImageView f4600m0;

    /* renamed from: n0 */
    public ImageView f4601n0;

    /* renamed from: o0 */
    public SubsamplingScaleImageView f4602o0;

    /* renamed from: p0 */
    public View f4603p0;

    /* renamed from: q0 */
    public Bitmap f4604q0;

    /* renamed from: r0 */
    public RelativeLayout f4605r0;

    @Override // androidx.fragment.app.m, androidx.fragment.app.n
    public final void B() {
        super.B();
        Dialog dialog = this.f1686h0;
        Objects.requireNonNull(dialog);
        dialog.getWindow().getAttributes().windowAnimations = 2131886372;
    }

    @Override // androidx.fragment.app.n
    public final View u(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f4603p0 = layoutInflater.inflate(2131492915, viewGroup, false);
        u<?> uVar = this.f1716x;
        RelativeLayout relativeLayout = new RelativeLayout(uVar == null ? null : (q) uVar.f1764f);
        this.f4605r0 = relativeLayout;
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Dialog dialog = this.f1686h0;
        Objects.requireNonNull(dialog);
        dialog.requestWindowFeature(1);
        this.f1686h0.setContentView(this.f4605r0);
        this.f1686h0.getWindow().setBackgroundDrawable(new ColorDrawable(-16777216));
        this.f1686h0.getWindow().setLayout(-1, -1);
        this.f4600m0 = (ImageView) this.f4603p0.findViewById(2131296430);
        this.f4602o0 = (SubsamplingScaleImageView) this.f4603p0.findViewById(2131296433);
        this.f4601n0 = (ImageView) this.f4603p0.findViewById(2131296434);
        this.f4600m0.setOnClickListener(new com.google.android.material.datepicker.q(6, this));
        this.f4601n0.setOnClickListener(new i4.a(7, this));
        this.f4602o0.setImage(ImageSource.bitmap(this.f4604q0));
        return this.f4603p0;
    }
}
