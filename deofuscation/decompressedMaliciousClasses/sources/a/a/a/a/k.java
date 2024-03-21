package a.a.a.a;

import a.a.a.d.h;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private final l<?> f32a;

    private k(l<?> lVar) {
        this.f32a = lVar;
    }

    public static final k b(l<?> lVar) {
        return new k(lVar);
    }

    public void A() {
        this.f32a.d.A0();
    }

    public View B(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f32a.d.onCreateView(view, str, context, attributeSet);
    }

    public void C() {
        this.f32a.u();
    }

    public void D(Parcelable parcelable, o oVar) {
        this.f32a.d.J0(parcelable, oVar);
    }

    public void E(h<String, u> hVar) {
        this.f32a.v(hVar);
    }

    public h<String, u> F() {
        return this.f32a.w();
    }

    public o G() {
        return this.f32a.d.K0();
    }

    public Parcelable H() {
        return this.f32a.d.M0();
    }

    public void a(h hVar) {
        l<?> lVar = this.f32a;
        lVar.d.k(lVar, lVar, hVar);
    }

    public void c() {
        this.f32a.d.r();
    }

    public void d(Configuration configuration) {
        this.f32a.d.s(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f32a.d.t(menuItem);
    }

    public void f() {
        this.f32a.d.u();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f32a.d.v(menu, menuInflater);
    }

    public void h() {
        this.f32a.d.w();
    }

    public void i() {
        this.f32a.d.y();
    }

    public void j(boolean z) {
        this.f32a.d.z(z);
    }

    public boolean k(MenuItem menuItem) {
        return this.f32a.d.N(menuItem);
    }

    public void l(Menu menu) {
        this.f32a.d.O(menu);
    }

    public void m() {
        this.f32a.d.P();
    }

    public void n(boolean z) {
        this.f32a.d.Q(z);
    }

    public boolean o(Menu menu) {
        return this.f32a.d.R(menu);
    }

    public void p() {
        this.f32a.d.S();
    }

    public void q() {
        this.f32a.d.T();
    }

    public void r() {
        this.f32a.d.U();
    }

    public void s() {
        this.f32a.d.V();
    }

    public void t() {
        this.f32a.c();
    }

    public void u() {
        this.f32a.d();
    }

    public void v(boolean z) {
        this.f32a.e(z);
    }

    public void w(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f32a.f(str, fileDescriptor, printWriter, strArr);
    }

    public boolean x() {
        return this.f32a.d.a0();
    }

    public h y(String str) {
        return this.f32a.d.g0(str);
    }

    public m z() {
        return this.f32a.i();
    }
}
