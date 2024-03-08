package androidx.appcompat.app;

import a0.e;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import f.n;
import java.lang.ref.WeakReference;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class AlertController {

    /* renamed from: a */
    public final Context f463a;

    /* renamed from: b */
    public final n f464b;

    /* renamed from: c */
    public final Window f465c;

    /* renamed from: d */
    public CharSequence f466d;
    public RecycleListView e;

    /* renamed from: f */
    public Button f467f;

    /* renamed from: g */
    public Button f468g;

    /* renamed from: h */
    public Button f469h;

    /* renamed from: i */
    public NestedScrollView f470i;

    /* renamed from: k */
    public Drawable f472k;

    /* renamed from: l */
    public ImageView f473l;
    public TextView m;

    /* renamed from: n */
    public TextView f474n;

    /* renamed from: o */
    public View f475o;

    /* renamed from: p */
    public ListAdapter f476p;

    /* renamed from: r */
    public int f478r;
    public int s;

    /* renamed from: t */
    public int f479t;

    /* renamed from: u */
    public int f480u;

    /* renamed from: v */
    public boolean f481v;

    /* renamed from: w */
    public c f482w;

    /* renamed from: j */
    public int f471j = 0;

    /* renamed from: q */
    public int f477q = -1;

    /* renamed from: x */
    public final a f483x = new a();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class RecycleListView extends ListView {

        /* renamed from: f */
        public final int f484f;

        /* renamed from: g */
        public final int f485g;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.P);
            this.f485g = obtainStyledAttributes.getDimensionPixelOffset(0, -1);
            this.f484f = obtainStyledAttributes.getDimensionPixelOffset(1, -1);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements View.OnClickListener {
        public a() {
            AlertController.this = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AlertController alertController = AlertController.this;
            Button button = alertController.f467f;
            Button button2 = alertController.f468g;
            Button button3 = alertController.f469h;
            alertController.f482w.obtainMessage(1, alertController.f464b).sendToTarget();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {

        /* renamed from: a */
        public final Context f487a;

        /* renamed from: b */
        public final LayoutInflater f488b;

        /* renamed from: c */
        public Drawable f489c;

        /* renamed from: d */
        public CharSequence f490d;
        public View e;

        /* renamed from: f */
        public DialogInterface.OnKeyListener f491f;

        /* renamed from: g */
        public ListAdapter f492g;

        /* renamed from: h */
        public DialogInterface.OnClickListener f493h;

        /* renamed from: i */
        public boolean f494i;

        /* renamed from: j */
        public int f495j = -1;

        public b(ContextThemeWrapper contextThemeWrapper) {
            this.f487a = contextThemeWrapper;
            this.f488b = (LayoutInflater) contextThemeWrapper.getSystemService("layout_inflater");
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class c extends Handler {

        /* renamed from: a */
        public WeakReference<DialogInterface> f496a;

        public c(DialogInterface dialogInterface) {
            this.f496a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i7 = message.what;
            if (i7 == -3 || i7 == -2 || i7 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f496a.get(), message.what);
            } else if (i7 == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class d extends ArrayAdapter<CharSequence> {
        public d(Context context, int i7) {
            super(context, i7, 16908308, (Object[]) null);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final long getItemId(int i7) {
            return (long) i7;
        }

        @Override // android.widget.Adapter, android.widget.BaseAdapter
        public final boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, n nVar, Window window) {
        this.f463a = context;
        this.f464b = nVar;
        this.f465c = window;
        this.f482w = new c(nVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, e.A, 2130903083, 0);
        this.f478r = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.getResourceId(2, 0);
        this.s = obtainStyledAttributes.getResourceId(4, 0);
        obtainStyledAttributes.getResourceId(5, 0);
        this.f479t = obtainStyledAttributes.getResourceId(7, 0);
        this.f480u = obtainStyledAttributes.getResourceId(3, 0);
        this.f481v = obtainStyledAttributes.getBoolean(6, true);
        obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        nVar.f().t(1);
    }

    public static void a(View view, View view2, View view3) {
        int i7 = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i7 = 4;
            }
            view3.setVisibility(i7);
        }
    }

    public static ViewGroup b(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }
}
