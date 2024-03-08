package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.core.widget.NestedScrollView;
import f.n;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b extends n {

    /* renamed from: k */
    public final AlertController f499k = new AlertController(getContext(), this, getWindow());

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {

        /* renamed from: a */
        public final AlertController.b f500a;

        /* renamed from: b */
        public final int f501b;

        public a(Context context) {
            int i7 = b.i(context, 0);
            this.f500a = new AlertController.b(new ContextThemeWrapper(context, b.i(context, i7)));
            this.f501b = i7;
        }

        public final b a() {
            b bVar = new b(this.f500a.f487a, this.f501b);
            AlertController.b bVar2 = this.f500a;
            AlertController alertController = bVar.f499k;
            View view = bVar2.e;
            if (view != null) {
                alertController.f475o = view;
            } else {
                CharSequence charSequence = bVar2.f490d;
                if (charSequence != null) {
                    alertController.f466d = charSequence;
                    TextView textView = alertController.m;
                    if (textView != null) {
                        textView.setText(charSequence);
                    }
                }
                Drawable drawable = bVar2.f489c;
                if (drawable != null) {
                    alertController.f472k = drawable;
                    alertController.f471j = 0;
                    ImageView imageView = alertController.f473l;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        alertController.f473l.setImageDrawable(drawable);
                    }
                }
            }
            if (bVar2.f492g != null) {
                AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) bVar2.f488b.inflate(alertController.s, (ViewGroup) null);
                int i7 = bVar2.f494i ? alertController.f479t : alertController.f480u;
                ListAdapter listAdapter = bVar2.f492g;
                if (listAdapter == null) {
                    listAdapter = new AlertController.d(bVar2.f487a, i7);
                }
                alertController.f476p = listAdapter;
                alertController.f477q = bVar2.f495j;
                if (bVar2.f493h != null) {
                    recycleListView.setOnItemClickListener(new a(bVar2, alertController));
                }
                if (bVar2.f494i) {
                    recycleListView.setChoiceMode(1);
                }
                alertController.e = recycleListView;
            }
            this.f500a.getClass();
            bVar.setCancelable(true);
            this.f500a.getClass();
            bVar.setCanceledOnTouchOutside(true);
            this.f500a.getClass();
            bVar.setOnCancelListener(null);
            this.f500a.getClass();
            bVar.setOnDismissListener(null);
            DialogInterface.OnKeyListener onKeyListener = this.f500a.f491f;
            if (onKeyListener != null) {
                bVar.setOnKeyListener(onKeyListener);
            }
            return bVar;
        }
    }

    public b(Context context, int i7) {
        super(context, i(context, i7));
    }

    public static int i(Context context, int i7) {
        if (((i7 >>> 24) & 255) >= 1) {
            return i7;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130903084, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // f.n, androidx.activity.l, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        boolean z6;
        ListAdapter listAdapter;
        View findViewById;
        Button button;
        super.onCreate(bundle);
        AlertController alertController = this.f499k;
        alertController.f464b.setContentView(alertController.f478r);
        View findViewById2 = alertController.f465c.findViewById(2131296702);
        View findViewById3 = findViewById2.findViewById(2131296881);
        View findViewById4 = findViewById2.findViewById(2131296405);
        View findViewById5 = findViewById2.findViewById(2131296365);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(2131296414);
        alertController.f465c.setFlags(131072, 131072);
        viewGroup.setVisibility(8);
        View findViewById6 = viewGroup.findViewById(2131296881);
        View findViewById7 = viewGroup.findViewById(2131296405);
        View findViewById8 = viewGroup.findViewById(2131296365);
        ViewGroup b2 = AlertController.b(findViewById6, findViewById3);
        ViewGroup b7 = AlertController.b(findViewById7, findViewById4);
        ViewGroup b8 = AlertController.b(findViewById8, findViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) alertController.f465c.findViewById(2131296764);
        alertController.f470i = nestedScrollView;
        int i7 = 0;
        nestedScrollView.setFocusable(false);
        alertController.f470i.setNestedScrollingEnabled(false);
        TextView textView = (TextView) b7.findViewById(16908299);
        alertController.f474n = textView;
        if (textView != null) {
            textView.setVisibility(8);
            alertController.f470i.removeView(alertController.f474n);
            if (alertController.e != null) {
                ViewGroup viewGroup2 = (ViewGroup) alertController.f470i.getParent();
                int indexOfChild = viewGroup2.indexOfChild(alertController.f470i);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(alertController.e, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
            } else {
                b7.setVisibility(8);
            }
        }
        Button button2 = (Button) b8.findViewById(16908313);
        alertController.f467f = button2;
        button2.setOnClickListener(alertController.f483x);
        View view = null;
        if (TextUtils.isEmpty(null)) {
            alertController.f467f.setVisibility(8);
            z6 = false;
        } else {
            alertController.f467f.setText((CharSequence) null);
            alertController.f467f.setVisibility(0);
            z6 = true;
        }
        Button button3 = (Button) b8.findViewById(16908314);
        alertController.f468g = button3;
        button3.setOnClickListener(alertController.f483x);
        if (TextUtils.isEmpty(null)) {
            alertController.f468g.setVisibility(8);
        } else {
            alertController.f468g.setText((CharSequence) null);
            alertController.f468g.setVisibility(0);
            z6 |= true;
        }
        Button button4 = (Button) b8.findViewById(16908315);
        alertController.f469h = button4;
        button4.setOnClickListener(alertController.f483x);
        if (TextUtils.isEmpty(null)) {
            alertController.f469h.setVisibility(8);
        } else {
            alertController.f469h.setText((CharSequence) null);
            alertController.f469h.setVisibility(0);
            z6 |= true;
        }
        Context context = alertController.f463a;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130903082, typedValue, true);
        if (typedValue.data != 0) {
            if (z6) {
                button = alertController.f467f;
            } else if (z6) {
                button = alertController.f468g;
            } else if (z6) {
                button = alertController.f469h;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams.gravity = 1;
            layoutParams.weight = 0.5f;
            button.setLayoutParams(layoutParams);
        }
        if (!(z6)) {
            b8.setVisibility(8);
        }
        if (alertController.f475o != null) {
            b2.addView(alertController.f475o, 0, new ViewGroup.LayoutParams(-1, -2));
            alertController.f465c.findViewById(2131296875).setVisibility(8);
        } else {
            alertController.f473l = (ImageView) alertController.f465c.findViewById(16908294);
            if (!(!TextUtils.isEmpty(alertController.f466d)) || !alertController.f481v) {
                alertController.f465c.findViewById(2131296875).setVisibility(8);
                alertController.f473l.setVisibility(8);
                b2.setVisibility(8);
            } else {
                TextView textView2 = (TextView) alertController.f465c.findViewById(2131296330);
                alertController.m = textView2;
                textView2.setText(alertController.f466d);
                int i8 = alertController.f471j;
                if (i8 != 0) {
                    alertController.f473l.setImageResource(i8);
                } else {
                    Drawable drawable = alertController.f472k;
                    if (drawable != null) {
                        alertController.f473l.setImageDrawable(drawable);
                    } else {
                        alertController.m.setPadding(alertController.f473l.getPaddingLeft(), alertController.f473l.getPaddingTop(), alertController.f473l.getPaddingRight(), alertController.f473l.getPaddingBottom());
                        alertController.f473l.setVisibility(8);
                    }
                }
            }
        }
        boolean z7 = viewGroup.getVisibility() != 8;
        int i9 = (b2 == null || b2.getVisibility() == 8) ? 0 : 1;
        boolean z8 = b8.getVisibility() != 8;
        if (!z8 && (findViewById = b7.findViewById(2131296841)) != null) {
            findViewById.setVisibility(0);
        }
        if (i9 != 0) {
            NestedScrollView nestedScrollView2 = alertController.f470i;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            if (alertController.e != null) {
                view = b2.findViewById(2131296874);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            View findViewById9 = b7.findViewById(2131296842);
            if (findViewById9 != null) {
                findViewById9.setVisibility(0);
            }
        }
        AlertController.RecycleListView recycleListView = alertController.e;
        if (recycleListView instanceof AlertController.RecycleListView) {
            if (!z8 || i9 == 0) {
                recycleListView.setPadding(recycleListView.getPaddingLeft(), i9 != 0 ? recycleListView.getPaddingTop() : recycleListView.f484f, recycleListView.getPaddingRight(), z8 ? recycleListView.getPaddingBottom() : recycleListView.f485g);
            } else {
                recycleListView.getClass();
            }
        }
        if (!z7) {
            View view2 = alertController.e;
            if (view2 == null) {
                view2 = alertController.f470i;
            }
            if (view2 != null) {
                if (z8) {
                    i7 = 2;
                }
                int i10 = i9 | i7;
                View findViewById10 = alertController.f465c.findViewById(2131296763);
                View findViewById11 = alertController.f465c.findViewById(2131296762);
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                y.j.d(view2, i10, 3);
                if (findViewById10 != null) {
                    b7.removeView(findViewById10);
                }
                if (findViewById11 != null) {
                    b7.removeView(findViewById11);
                }
            }
        }
        AlertController.RecycleListView recycleListView2 = alertController.e;
        if (recycleListView2 != null && (listAdapter = alertController.f476p) != null) {
            recycleListView2.setAdapter(listAdapter);
            int i11 = alertController.f477q;
            if (i11 > -1) {
                recycleListView2.setItemChecked(i11, true);
                recycleListView2.setSelection(i11);
            }
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i7, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f499k.f470i;
        if (nestedScrollView != null && nestedScrollView.e(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i7, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i7, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f499k.f470i;
        if (nestedScrollView != null && nestedScrollView.e(keyEvent)) {
            return true;
        }
        return super.onKeyUp(i7, keyEvent);
    }

    @Override // f.n, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        AlertController alertController = this.f499k;
        alertController.f466d = charSequence;
        TextView textView = alertController.m;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
