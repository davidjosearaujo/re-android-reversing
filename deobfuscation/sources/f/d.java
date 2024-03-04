package f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.f1;
import f.s;
import f1.a;
import f1.g;
import g1.a;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class d extends androidx.fragment.app.q implements e {
    public h C;

    public d() {
        this.f359j.f4376b.c("androidx:appcompat", new b(this));
        n(new c(this));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        u();
        s().c(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(s().d(context));
    }

    @Override // android.app.Activity
    public final void closeOptionsMenu() {
        a t5 = t();
        if (getWindow().hasFeature(0)) {
            if (t5 == null || !t5.a()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // f.e
    public final void d() {
    }

    @Override // f1.e, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a t5 = t();
        if (keyCode == 82 && t5 != null && t5.j(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public final <T extends View> T findViewById(int i7) {
        return (T) s().e(i7);
    }

    @Override // f.e
    public final void g() {
    }

    @Override // android.app.Activity
    public final MenuInflater getMenuInflater() {
        return s().h();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        int i7 = f1.f903a;
        return super.getResources();
    }

    @Override // android.app.Activity
    public final void invalidateOptionsMenu() {
        s().k();
    }

    @Override // f.e
    public final void j() {
    }

    @Override // androidx.fragment.app.q, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        s().m(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
    }

    @Override // androidx.fragment.app.q, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        s().o();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i7, KeyEvent keyEvent) {
        return super.onKeyDown(i7, keyEvent);
    }

    @Override // androidx.fragment.app.q, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i7, MenuItem menuItem) {
        Intent a7;
        Intent makeMainActivity;
        if (super.onMenuItemSelected(i7, menuItem)) {
            return true;
        }
        a t5 = t();
        if (menuItem.getItemId() == 16908332 && t5 != null && (t5.d() & 4) != 0 && (a7 = f1.g.a(this)) != null) {
            if (!g.a.c(this, a7)) {
                g.a.b(this, a7);
                return true;
            }
            ArrayList arrayList = new ArrayList();
            Intent a8 = f1.g.a(this);
            if (a8 == null) {
                a8 = f1.g.a(this);
            }
            if (a8 != null) {
                ComponentName component = a8.getComponent();
                if (component == null) {
                    component = a8.resolveActivity(getPackageManager());
                }
                int size = arrayList.size();
                while (true) {
                    try {
                        String b2 = f1.g.b(this, component);
                        if (b2 == null) {
                            makeMainActivity = null;
                        } else {
                            ComponentName componentName = new ComponentName(component.getPackageName(), b2);
                            makeMainActivity = f1.g.b(this, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
                        }
                        if (makeMainActivity == null) {
                            break;
                        }
                        arrayList.add(size, makeMainActivity);
                        component = makeMainActivity.getComponent();
                    } catch (PackageManager.NameNotFoundException e) {
                        Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                        throw new IllegalArgumentException(e);
                    }
                }
                arrayList.add(a8);
            }
            if (arrayList.isEmpty()) {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            Object obj = g1.a.f4192a;
            a.C0058a.a(this, intentArr, null);
            try {
                int i8 = f1.a.f4073b;
                a.C0055a.a(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onMenuOpened(int i7, Menu menu) {
        return super.onMenuOpened(i7, menu);
    }

    @Override // androidx.fragment.app.q, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final void onPanelClosed(int i7, Menu menu) {
        super.onPanelClosed(i7, menu);
    }

    @Override // android.app.Activity
    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((h) s()).J();
    }

    @Override // androidx.fragment.app.q, android.app.Activity
    public final void onPostResume() {
        super.onPostResume();
        s().p();
    }

    @Override // androidx.fragment.app.q, android.app.Activity
    public final void onStart() {
        super.onStart();
        s().q();
    }

    @Override // androidx.fragment.app.q, android.app.Activity
    public final void onStop() {
        super.onStop();
        s().r();
    }

    @Override // android.app.Activity
    public final void onTitleChanged(CharSequence charSequence, int i7) {
        super.onTitleChanged(charSequence, i7);
        s().z(charSequence);
    }

    @Override // android.app.Activity
    public final void openOptionsMenu() {
        a t5 = t();
        if (getWindow().hasFeature(0)) {
            if (t5 == null || !t5.k()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.fragment.app.q
    public final void r() {
        s().k();
    }

    public final g s() {
        if (this.C == null) {
            s.a aVar = g.f3929f;
            this.C = new h(this, null, this, this);
        }
        return this.C;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void setContentView(int i7) {
        u();
        s().u(i7);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        u();
        s().v(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        u();
        s().w(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i7) {
        super.setTheme(i7);
        s().y(i7);
    }

    public final a t() {
        return s().i();
    }

    public final void u() {
        a0.b.B(getWindow().getDecorView(), this);
        View decorView = getWindow().getDecorView();
        r5.h.f(decorView, "<this>");
        decorView.setTag(2131296918, this);
        a0.b.C(getWindow().getDecorView(), this);
        View decorView2 = getWindow().getDecorView();
        r5.h.f(decorView2, "<this>");
        decorView2.setTag(2131296916, this);
    }
}
