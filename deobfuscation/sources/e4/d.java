package e4;

import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.Objects;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    public final a f3768a;

    /* renamed from: b */
    public final e4.b f3769b;

    /* renamed from: c */
    public final View f3770c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public OnBackInvokedCallback f3771a;

        public OnBackInvokedCallback a(final e4.b bVar) {
            Objects.requireNonNull(bVar);
            return new OnBackInvokedCallback() { // from class: e4.c
                public final void onBackInvoked() {
                    b.this.a();
                }
            };
        }

        public void b(e4.b bVar, View view, boolean z6) {
            OnBackInvokedDispatcher findOnBackInvokedDispatcher;
            if (this.f3771a == null && (findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) != null) {
                OnBackInvokedCallback a7 = a(bVar);
                this.f3771a = a7;
                findOnBackInvokedDispatcher.registerOnBackInvokedCallback(z6 ? 1000000 : 0, a7);
            }
        }

        public void c(View view) {
            OnBackInvokedDispatcher findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
            if (findOnBackInvokedDispatcher == null) {
                return;
            }
            findOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.f3771a);
            this.f3771a = null;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {

        /* loaded from: classes.dex */
        public class a implements OnBackAnimationCallback {

            /* renamed from: a */
            public final /* synthetic */ e4.b f3772a;

            public a(e4.b bVar) {
                b.this = r1;
                this.f3772a = bVar;
            }

            public final void onBackCancelled() {
                if (b.this.f3771a != null) {
                    this.f3772a.d();
                }
            }

            public final void onBackInvoked() {
                this.f3772a.a();
            }

            public final void onBackProgressed(BackEvent backEvent) {
                if (b.this.f3771a != null) {
                    this.f3772a.c(new androidx.activity.b(backEvent));
                }
            }

            public final void onBackStarted(BackEvent backEvent) {
                if (b.this.f3771a != null) {
                    this.f3772a.b(new androidx.activity.b(backEvent));
                }
            }
        }

        @Override // e4.d.a
        public final OnBackInvokedCallback a(e4.b bVar) {
            return new a(bVar);
        }
    }

    public d(BottomSheetBehavior bottomSheetBehavior, FrameLayout frameLayout) {
        int i7 = Build.VERSION.SDK_INT;
        this.f3768a = i7 >= 34 ? new b() : i7 >= 33 ? new a() : null;
        this.f3769b = bottomSheetBehavior;
        this.f3770c = frameLayout;
    }
}
