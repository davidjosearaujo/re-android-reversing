package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.transition.Transition;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;

/* loaded from: classes.dex */
public final class p0 extends n0 implements o0 {
    public o0 F;

    /* loaded from: classes.dex */
    public static class a {
        public static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        public static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static void a(PopupWindow popupWindow, boolean z6) {
            popupWindow.setTouchModal(z6);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends i0 {

        /* renamed from: r */
        public final int f1014r;
        public final int s;

        /* renamed from: t */
        public o0 f1015t;

        /* renamed from: u */
        public androidx.appcompat.view.menu.h f1016u;

        /* loaded from: classes.dex */
        public static class a {
            public static int a(Configuration configuration) {
                return configuration.getLayoutDirection();
            }
        }

        public c(Context context, boolean z6) {
            super(context, z6);
            if (1 == a.a(context.getResources().getConfiguration())) {
                this.f1014r = 21;
                this.s = 22;
                return;
            }
            this.f1014r = 22;
            this.s = 21;
        }

        @Override // androidx.appcompat.widget.i0, android.view.View
        public final boolean onHoverEvent(MotionEvent motionEvent) {
            int i7;
            int pointToPosition;
            int i8;
            if (this.f1015t != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i7 = headerViewListAdapter.getHeadersCount();
                    adapter = headerViewListAdapter.getWrappedAdapter();
                } else {
                    i7 = 0;
                }
                androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) adapter;
                androidx.appcompat.view.menu.h hVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i8 = pointToPosition - i7) >= 0 && i8 < eVar.getCount()) {
                    hVar = eVar.getItem(i8);
                }
                androidx.appcompat.view.menu.h hVar2 = this.f1016u;
                if (hVar2 != hVar) {
                    androidx.appcompat.view.menu.f fVar = eVar.f572f;
                    if (hVar2 != null) {
                        this.f1015t.a(fVar, hVar2);
                    }
                    this.f1016u = hVar;
                    if (hVar != null) {
                        this.f1015t.e(fVar, hVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public final boolean onKeyDown(int i7, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i7 == this.f1014r) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i7 != this.s) {
                return super.onKeyDown(i7, keyEvent);
            } else {
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                }
                ((androidx.appcompat.view.menu.e) adapter).f572f.c(false);
                return true;
            }
        }

        public void setHoverListener(o0 o0Var) {
            this.f1015t = o0Var;
        }

        @Override // androidx.appcompat.widget.i0, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    public p0(Context context, int i7, int i8) {
        super(context, null, i7, i8);
    }

    @Override // androidx.appcompat.widget.o0
    public final void a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
        o0 o0Var = this.F;
        if (o0Var != null) {
            o0Var.a(fVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.o0
    public final void e(androidx.appcompat.view.menu.f fVar, androidx.appcompat.view.menu.h hVar) {
        o0 o0Var = this.F;
        if (o0Var != null) {
            o0Var.e(fVar, hVar);
        }
    }

    @Override // androidx.appcompat.widget.n0
    public final i0 q(Context context, boolean z6) {
        c cVar = new c(context, z6);
        cVar.setHoverListener(this);
        return cVar;
    }
}
