package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class u0 extends u1.c implements View.OnClickListener {
    public static final /* synthetic */ int C = 0;
    public int A;
    public int B;

    /* renamed from: p */
    public final SearchView f1043p;

    /* renamed from: q */
    public final SearchableInfo f1044q;

    /* renamed from: r */
    public final Context f1045r;
    public final WeakHashMap<String, Drawable.ConstantState> s;

    /* renamed from: t */
    public final int f1046t;

    /* renamed from: u */
    public int f1047u;

    /* renamed from: v */
    public ColorStateList f1048v;

    /* renamed from: w */
    public int f1049w;

    /* renamed from: x */
    public int f1050x;

    /* renamed from: y */
    public int f1051y;

    /* renamed from: z */
    public int f1052z;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        public final TextView f1053a;

        /* renamed from: b */
        public final TextView f1054b;

        /* renamed from: c */
        public final ImageView f1055c;

        /* renamed from: d */
        public final ImageView f1056d;
        public final ImageView e;

        public a(View view) {
            this.f1053a = (TextView) view.findViewById(16908308);
            this.f1054b = (TextView) view.findViewById(16908309);
            this.f1055c = (ImageView) view.findViewById(16908295);
            this.f1056d = (ImageView) view.findViewById(16908296);
            this.e = (ImageView) view.findViewById(2131296460);
        }
    }

    public u0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout());
        this.f1047u = 1;
        this.f1049w = -1;
        this.f1050x = -1;
        this.f1051y = -1;
        this.f1052z = -1;
        this.A = -1;
        this.B = -1;
        this.f1043p = searchView;
        this.f1044q = searchableInfo;
        this.f1046t = searchView.getSuggestionCommitIconResId();
        this.f1045r = context;
        this.s = weakHashMap;
    }

    public static String i(Cursor cursor, int i7) {
        if (i7 == -1) {
            return null;
        }
        try {
            return cursor.getString(i7);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x014b  */
    @Override // u1.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(android.view.View r19, android.database.Cursor r20) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.u0.b(android.view.View, android.database.Cursor):void");
    }

    @Override // u1.a
    public final void c(Cursor cursor) {
        try {
            super.c(cursor);
            if (cursor != null) {
                this.f1049w = cursor.getColumnIndex("suggest_text_1");
                this.f1050x = cursor.getColumnIndex("suggest_text_2");
                this.f1051y = cursor.getColumnIndex("suggest_text_2_url");
                this.f1052z = cursor.getColumnIndex("suggest_icon_1");
                this.A = cursor.getColumnIndex("suggest_icon_2");
                this.B = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // u1.a
    public final String d(Cursor cursor) {
        String i7;
        String i8;
        if (cursor == null) {
            return null;
        }
        String i9 = i(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (i9 != null) {
            return i9;
        }
        if (!this.f1044q.shouldRewriteQueryFromData() || (i8 = i(cursor, cursor.getColumnIndex("suggest_intent_data"))) == null) {
            if (!this.f1044q.shouldRewriteQueryFromText() || (i7 = i(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
                return null;
            }
            return i7;
        }
        return i8;
    }

    @Override // u1.a
    public final View e(ViewGroup viewGroup) {
        View inflate = this.f6091o.inflate(this.m, viewGroup, false);
        inflate.setTag(new a(inflate));
        ((ImageView) inflate.findViewById(2131296460)).setImageResource(this.f1046t);
        return inflate;
    }

    public final Drawable f(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f1045r.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    parseInt = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size != 2) {
                throw new FileNotFoundException("More than two path segments: " + uri);
            } else {
                parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (parseInt != 0) {
                return resourcesForApplication.getDrawable(parseInt);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:239:0x0133  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.drawable.Drawable g(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.u0.g(java.lang.String):android.graphics.drawable.Drawable");
    }

    @Override // u1.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i7, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i7, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View inflate = this.f6091o.inflate(this.f6090n, viewGroup, false);
            if (inflate != null) {
                ((a) inflate.getTag()).f1053a.setText(e.toString());
            }
            return inflate;
        }
    }

    @Override // u1.a, android.widget.Adapter
    public final View getView(int i7, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i7, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View e7 = this.e(viewGroup);
            ((a) e7.getTag()).f1053a.setText(e.toString());
            return e7;
        }
    }

    public final Cursor h(SearchableInfo searchableInfo, String str) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        fragment.appendQueryParameter("limit", String.valueOf(50));
        return this.f1045r.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Cursor cursor = this.f6082h;
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        Cursor cursor = this.f6082h;
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1043p.o((CharSequence) tag);
        }
    }
}
