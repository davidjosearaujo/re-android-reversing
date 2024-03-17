package com.facebook.internal.logging.dumpsys;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import com.alibaba.android.arouter.utils.Consts;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import n.b0;
import n.l2.v.f0;
import n.l2.v.s0;
import n.l2.v.u;
import r.e.a.d;
import r.e.a.e;

/* compiled from: AndroidRootResolver.kt */
@b0(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0004\u0011\u0012\u0013\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\b\u0010\r\u001a\u00020\nH\u0002J\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/AndroidRootResolver;", "", "()V", "initialized", "", "paramsField", "Ljava/lang/reflect/Field;", "viewsField", "windowManagerObj", "attachActiveRootListener", "", "listener", "Lcom/facebook/internal/logging/dumpsys/AndroidRootResolver$Listener;", "initialize", "listActiveRoots", "", "Lcom/facebook/internal/logging/dumpsys/AndroidRootResolver$Root;", "Companion", "ListenableArrayList", "Listener", Consts.SUFFIX_ROOT, "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class AndroidRootResolver {
    @d
    public static final Companion Companion = new Companion(null);
    private static final String GET_DEFAULT_IMPL = "getDefault";
    private static final String GET_GLOBAL_INSTANCE = "getInstance";
    private static final String TAG;
    private static final String VIEWS_FIELD = "mViews";
    private static final String WINDOW_MANAGER_GLOBAL_CLAZZ = "android.view.WindowManagerGlobal";
    private static final String WINDOW_MANAGER_IMPL_CLAZZ = "android.view.WindowManagerImpl";
    private static final String WINDOW_PARAMS_FIELD = "mParams";
    private boolean initialized;
    private Field paramsField;
    private Field viewsField;
    private Object windowManagerObj;

    /* compiled from: AndroidRootResolver.kt */
    @b0(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/AndroidRootResolver$Companion;", "", "()V", "GET_DEFAULT_IMPL", "", "GET_GLOBAL_INSTANCE", "TAG", "VIEWS_FIELD", "WINDOW_MANAGER_GLOBAL_CLAZZ", "WINDOW_MANAGER_IMPL_CLAZZ", "WINDOW_PARAMS_FIELD", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    /* compiled from: AndroidRootResolver.kt */
    @b0(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/AndroidRootResolver$ListenableArrayList;", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "()V", "listener", "Lcom/facebook/internal/logging/dumpsys/AndroidRootResolver$Listener;", "add", "", SDKConstants.PARAM_VALUE, "remove", "removeAt", "index", "", "setListener", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class ListenableArrayList extends ArrayList<View> {
        private Listener listener;

        public /* bridge */ boolean contains(View view) {
            return super.contains((Object) view);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ int indexOf(View view) {
            return super.indexOf((Object) view);
        }

        public /* bridge */ int lastIndexOf(View view) {
            return super.lastIndexOf((Object) view);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ View remove(int i) {
            return remove(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        @e
        /* renamed from: removeAt */
        public View remove(int i) {
            View view = (View) super.remove(i);
            Listener listener = this.listener;
            if (listener != null) {
                if (listener != null) {
                    listener.onRootRemoved(view);
                }
                Listener listener2 = this.listener;
                if (listener2 != null) {
                    listener2.onRootsChanged(this);
                }
            }
            return view;
        }

        public final void setListener(@e Listener listener) {
            this.listener = listener;
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(@e View view) {
            Listener listener;
            boolean add = super.add((ListenableArrayList) view);
            if (add && (listener = this.listener) != null) {
                if (listener != null) {
                    listener.onRootAdded(view);
                }
                Listener listener2 = this.listener;
                if (listener2 != null) {
                    listener2.onRootsChanged(this);
                }
            }
            return add;
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj != null ? obj instanceof View : true) {
                return contains((View) obj);
            }
            return false;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj != null ? obj instanceof View : true) {
                return indexOf((View) obj);
            }
            return -1;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj != null ? obj instanceof View : true) {
                return lastIndexOf((View) obj);
            }
            return -1;
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object obj) {
            if (obj != null ? obj instanceof View : true) {
                return remove((View) obj);
            }
            return false;
        }

        public boolean remove(@e View view) {
            Listener listener;
            boolean remove = super.remove((Object) view);
            if (remove && (listener = this.listener) != null && (view instanceof View)) {
                if (listener != null) {
                    listener.onRootRemoved(view);
                }
                Listener listener2 = this.listener;
                if (listener2 != null) {
                    listener2.onRootsChanged(this);
                }
            }
            return remove;
        }
    }

    /* compiled from: AndroidRootResolver.kt */
    @b0(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0007\u001a\u00020\u00032\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/AndroidRootResolver$Listener;", "", "onRootAdded", "", "root", "Landroid/view/View;", "onRootRemoved", "onRootsChanged", "roots", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface Listener {
        void onRootAdded(@e View view);

        void onRootRemoved(@e View view);

        void onRootsChanged(@e List<? extends View> list);
    }

    /* compiled from: AndroidRootResolver.kt */
    @b0(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/AndroidRootResolver$Root;", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", RemoteMessageConst.MessageBody.PARAM, "Landroid/view/WindowManager$LayoutParams;", "(Landroid/view/View;Landroid/view/WindowManager$LayoutParams;)V", "getParam", "()Landroid/view/WindowManager$LayoutParams;", "getView", "()Landroid/view/View;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class Root {
        @d
        private final WindowManager.LayoutParams param;
        @d
        private final View view;

        public Root(@d View view, @d WindowManager.LayoutParams layoutParams) {
            f0.p(view, ViewHierarchyConstants.VIEW_KEY);
            f0.p(layoutParams, RemoteMessageConst.MessageBody.PARAM);
            this.view = view;
            this.param = layoutParams;
        }

        @d
        public final WindowManager.LayoutParams getParam() {
            return this.param;
        }

        @d
        public final View getView() {
            return this.view;
        }
    }

    static {
        String simpleName = AndroidRootResolver.class.getSimpleName();
        f0.o(simpleName, "AndroidRootResolver::class.java.simpleName");
        TAG = simpleName;
    }

    private final void initialize() {
        this.initialized = true;
        int i = Build.VERSION.SDK_INT;
        String str = i > 16 ? WINDOW_MANAGER_GLOBAL_CLAZZ : WINDOW_MANAGER_IMPL_CLAZZ;
        String str2 = i > 16 ? GET_GLOBAL_INSTANCE : GET_DEFAULT_IMPL;
        try {
            Class<?> cls = Class.forName(str);
            f0.o(cls, "Class.forName(accessClass)");
            Method method = cls.getMethod(str2, new Class[0]);
            f0.o(method, "clazz.getMethod(instanceMethod)");
            this.windowManagerObj = method.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField(VIEWS_FIELD);
            this.viewsField = declaredField;
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Field declaredField2 = cls.getDeclaredField(WINDOW_PARAMS_FIELD);
            this.paramsField = declaredField2;
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
        } catch (ClassNotFoundException e) {
            String str3 = TAG;
            s0 s0Var = s0.a;
            String format = String.format("could not find class: %s", Arrays.copyOf(new Object[]{str}, 1));
            f0.o(format, "java.lang.String.format(format, *args)");
            Log.d(str3, format, e);
        } catch (IllegalAccessException e2) {
            String str4 = TAG;
            s0 s0Var2 = s0.a;
            String format2 = String.format("reflective setup failed using obj: %s method: %s field: %s", Arrays.copyOf(new Object[]{str, str2, VIEWS_FIELD}, 3));
            f0.o(format2, "java.lang.String.format(format, *args)");
            Log.d(str4, format2, e2);
        } catch (NoSuchFieldException e3) {
            String str5 = TAG;
            s0 s0Var3 = s0.a;
            String format3 = String.format("could not find field: %s or %s on %s", Arrays.copyOf(new Object[]{WINDOW_PARAMS_FIELD, VIEWS_FIELD, str}, 3));
            f0.o(format3, "java.lang.String.format(format, *args)");
            Log.d(str5, format3, e3);
        } catch (NoSuchMethodException e4) {
            String str6 = TAG;
            s0 s0Var4 = s0.a;
            String format4 = String.format("could not find method: %s on %s", Arrays.copyOf(new Object[]{str2, str}, 2));
            f0.o(format4, "java.lang.String.format(format, *args)");
            Log.d(str6, format4, e4);
        } catch (RuntimeException e5) {
            String str7 = TAG;
            s0 s0Var5 = s0.a;
            String format5 = String.format("reflective setup failed using obj: %s method: %s field: %s", Arrays.copyOf(new Object[]{str, str2, VIEWS_FIELD}, 3));
            f0.o(format5, "java.lang.String.format(format, *args)");
            Log.d(str7, format5, e5);
        } catch (InvocationTargetException e6) {
            String str8 = TAG;
            s0 s0Var6 = s0.a;
            String format6 = String.format("could not invoke: %s on %s", Arrays.copyOf(new Object[]{str2, str}, 2));
            f0.o(format6, "java.lang.String.format(format, *args)");
            Log.d(str8, format6, e6.getCause());
        }
    }

    public final void attachActiveRootListener(@e Listener listener) {
        if (Build.VERSION.SDK_INT < 19 || listener == null) {
            return;
        }
        if (!this.initialized) {
            initialize();
        }
        try {
            Field declaredField = Field.class.getDeclaredField("accessFlags");
            f0.o(declaredField, "Field::class.java.getDeclaredField(\"accessFlags\")");
            declaredField.setAccessible(true);
            Field field = this.viewsField;
            declaredField.setInt(field, field != null ? field.getModifiers() : 0);
            Field field2 = this.viewsField;
            Object obj = field2 != null ? field2.get(this.windowManagerObj) : null;
            if (obj != null) {
                ListenableArrayList listenableArrayList = new ListenableArrayList();
                listenableArrayList.setListener(listener);
                listenableArrayList.addAll((ArrayList) obj);
                Field field3 = this.viewsField;
                if (field3 != null) {
                    field3.set(this.windowManagerObj, listenableArrayList);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<android.view.View> /* = java.util.ArrayList<android.view.View> */");
        } catch (Throwable th) {
            Log.d(TAG, "Couldn't attach root listener.", th);
        }
    }

    @e
    public final List<Root> listActiveRoots() {
        List list;
        if (!this.initialized) {
            initialize();
        }
        Object obj = this.windowManagerObj;
        List list2 = null;
        if (obj == null) {
            Log.d(TAG, "No reflective access to windowmanager object.");
            return null;
        }
        Field field = this.viewsField;
        if (field == null) {
            Log.d(TAG, "No reflective access to mViews");
            return null;
        } else if (this.paramsField == null) {
            Log.d(TAG, "No reflective access to mPArams");
            return null;
        } else {
            try {
                if (Build.VERSION.SDK_INT < 19) {
                    View[] viewArr = (View[]) (field != null ? field.get(obj) : null);
                    list = viewArr != null ? ArraysKt___ArraysKt.ey(viewArr) : null;
                    Field field2 = this.paramsField;
                    WindowManager.LayoutParams[] layoutParamsArr = (WindowManager.LayoutParams[]) (field2 != null ? field2.get(this.windowManagerObj) : null);
                    if (layoutParamsArr != null) {
                        list2 = ArraysKt___ArraysKt.ey(layoutParamsArr);
                    }
                } else {
                    list = (List) (field != null ? field.get(obj) : null);
                    Field field3 = this.paramsField;
                    list2 = (List) (field3 != null ? field3.get(this.windowManagerObj) : null);
                }
                ArrayList arrayList = new ArrayList();
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.E();
                }
                if (list2 == null) {
                    list2 = CollectionsKt__CollectionsKt.E();
                }
                for (Pair pair : CollectionsKt___CollectionsKt.V5(list, list2)) {
                    arrayList.add(new Root((View) pair.component1(), (WindowManager.LayoutParams) pair.component2()));
                }
                return arrayList;
            } catch (IllegalAccessException e) {
                String str = TAG;
                s0 s0Var = s0.a;
                String format = String.format("Reflective access to %s or %s on %s failed.", Arrays.copyOf(new Object[]{this.viewsField, this.paramsField, this.windowManagerObj}, 3));
                f0.o(format, "java.lang.String.format(format, *args)");
                Log.d(str, format, e);
                return null;
            } catch (RuntimeException e2) {
                String str2 = TAG;
                s0 s0Var2 = s0.a;
                String format2 = String.format("Reflective access to %s or %s on %s failed.", Arrays.copyOf(new Object[]{this.viewsField, this.paramsField, this.windowManagerObj}, 3));
                f0.o(format2, "java.lang.String.format(format, *args)");
                Log.d(str2, format2, e2);
                return null;
            }
        }
    }
}
