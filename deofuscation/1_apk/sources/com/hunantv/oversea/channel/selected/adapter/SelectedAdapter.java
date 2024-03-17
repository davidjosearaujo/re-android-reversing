package com.hunantv.oversea.channel.selected.adapter;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.c.c.f.u0.b;
import java.util.HashMap;
import java.util.List;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SelectedAdapter extends j.v.u.j.a {
    private static final /* synthetic */ c.b e = null;
    private static final /* synthetic */ c.b f = null;
    private static final /* synthetic */ c.b g = null;
    private List<a> b;
    private final FragmentManager c;
    private final HashMap<Integer, Fragment> d;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a {
        public Class a;
        public Bundle b;
        public boolean c;
        public boolean d;
        public String e;

        public a(Class cls, Bundle bundle) {
            this.a = cls;
            this.b = bundle;
        }
    }

    static {
        c();
    }

    public SelectedAdapter(FragmentManager fragmentManager, List<a> list) {
        super(fragmentManager);
        this.d = new HashMap<>();
        this.c = fragmentManager;
        this.b = list;
    }

    private static /* synthetic */ void c() {
        e eVar = new e("SelectedAdapter.java", SelectedAdapter.class);
        e = eVar.H("method-execution", eVar.E("1", "instantiateItem", "com.hunantv.oversea.channel.selected.adapter.SelectedAdapter", "android.view.ViewGroup:int", "container:position", "", "java.lang.Object"), 95);
        f = eVar.H("method-execution", eVar.E("1", "destroyItem", "com.hunantv.oversea.channel.selected.adapter.SelectedAdapter", "android.view.ViewGroup:int:java.lang.Object", "container:position:object", "", "void"), 103);
        g = eVar.H("method-execution", eVar.E("1", "getCurrentFragment", "com.hunantv.oversea.channel.selected.adapter.SelectedAdapter", "int", "postion", "", "androidx.fragment.app.Fragment"), 123);
    }

    public static final /* synthetic */ void d(SelectedAdapter selectedAdapter, ViewGroup viewGroup, int i, Object obj, c cVar) {
        super/*androidx.fragment.app.FragmentStatePagerAdapter*/.destroyItem(viewGroup, i, obj);
        selectedAdapter.d.remove(Integer.valueOf(i));
    }

    public static final /* synthetic */ Fragment e(SelectedAdapter selectedAdapter, int i, c cVar) {
        Fragment fragment = selectedAdapter.d.get(Integer.valueOf(i));
        if (fragment == null) {
            for (Fragment fragment2 : selectedAdapter.c.getFragments()) {
                Bundle arguments = fragment2.getArguments();
                if (arguments != null && arguments.getInt("bundle_channel_position", 0) == i) {
                    return fragment2;
                }
            }
            return fragment;
        }
        return fragment;
    }

    public static final /* synthetic */ Object g(SelectedAdapter selectedAdapter, ViewGroup viewGroup, int i, c cVar) {
        Object instantiateItem = super/*androidx.fragment.app.FixedFragmentStatePagerAdapter*/.instantiateItem(viewGroup, i);
        selectedAdapter.d.put(Integer.valueOf(i), (Fragment) instantiateItem);
        return instantiateItem;
    }

    @WithTryCatchRuntime
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new b(new Object[]{this, viewGroup, r.a.c.b.e.k(i), obj, e.y(f, this, this, new Object[]{viewGroup, r.a.c.b.e.k(i), obj})}).e(69648));
    }

    public a f(int i) {
        List<a> list;
        if (i >= getCount() || (list = this.b) == null) {
            return null;
        }
        return list.get(i);
    }

    public int getCount() {
        List<a> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @WithTryCatchRuntime
    public Fragment getCurrentFragment(int i) {
        return (Fragment) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.f.u0.c(new Object[]{this, r.a.c.b.e.k(i), e.w(g, this, this, r.a.c.b.e.k(i))}).e(69648));
    }

    public Fragment getItem(int i) {
        a aVar;
        List<a> list = this.b;
        if (list != null && i >= 0 && i < list.size() && (aVar = this.b.get(i)) != null) {
            try {
                Fragment fragment = (Fragment) aVar.a.newInstance();
                if (fragment != null) {
                    Bundle bundle = aVar.b;
                    if (bundle != null) {
                        bundle.putInt("bundle_channel_position", i);
                        fragment.setArguments(aVar.b);
                    }
                    return fragment;
                }
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    @WithTryCatchRuntime
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.f.u0.a(new Object[]{this, viewGroup, r.a.c.b.e.k(i), e.x(e, this, this, viewGroup, r.a.c.b.e.k(i))}).e(69648));
    }

    public Parcelable saveState() {
        return super/*androidx.fragment.app.FragmentStatePagerAdapter*/.saveState();
    }
}
