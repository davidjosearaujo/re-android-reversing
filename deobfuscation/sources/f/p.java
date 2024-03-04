package f;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.c0;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class p {

    /* renamed from: b */
    public static final Class<?>[] f4003b = {Context.class, AttributeSet.class};

    /* renamed from: c */
    public static final int[] f4004c = {16843375};

    /* renamed from: d */
    public static final String[] f4005d = {"android.widget.", "android.view.", "android.webkit."};
    public static final o.h<String, Constructor<? extends View>> e = new o.h<>();

    /* renamed from: a */
    public final Object[] f4006a = new Object[2];

    /* loaded from: classes.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: f */
        public final View f4007f;

        /* renamed from: g */
        public final String f4008g;

        /* renamed from: h */
        public Method f4009h;

        /* renamed from: i */
        public Context f4010i;

        public a(View view, String str) {
            this.f4007f = view;
            this.f4008g = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String sb;
            Method method;
            if (this.f4009h == null) {
                Context context = this.f4007f.getContext();
                while (context != null) {
                    try {
                        if (!context.isRestricted() && (method = context.getClass().getMethod(this.f4008g, View.class)) != null) {
                            this.f4009h = method;
                            this.f4010i = context;
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                    context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
                }
                int id = this.f4007f.getId();
                if (id == -1) {
                    sb = "";
                } else {
                    StringBuilder d7 = androidx.activity.h.d(" with id '");
                    d7.append(this.f4007f.getContext().getResources().getResourceEntryName(id));
                    d7.append("'");
                    sb = d7.toString();
                }
                StringBuilder d8 = androidx.activity.h.d("Could not find method ");
                d8.append(this.f4008g);
                d8.append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                d8.append(this.f4007f.getClass());
                d8.append(sb);
                throw new IllegalStateException(d8.toString());
            }
            try {
                this.f4009h.invoke(this.f4010i, view);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e7) {
                throw new IllegalStateException("Could not execute method for android:onClick", e7);
            }
        }
    }

    public androidx.appcompat.widget.d a(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.d(context, attributeSet);
    }

    public AppCompatButton b(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    public androidx.appcompat.widget.f c(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.f(context, attributeSet);
    }

    public androidx.appcompat.widget.t d(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.t(context, attributeSet);
    }

    public c0 e(Context context, AttributeSet attributeSet) {
        return new c0(context, attributeSet);
    }

    public final View f(Context context, String str, String str2) {
        String str3;
        o.h<String, Constructor<? extends View>> hVar = e;
        Constructor<? extends View> orDefault = hVar.getOrDefault(str, null);
        if (orDefault == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            orDefault = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f4003b);
            hVar.put(str, orDefault);
        }
        orDefault.setAccessible(true);
        return orDefault.newInstance(this.f4006a);
    }
}
