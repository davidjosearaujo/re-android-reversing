package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.WeakHashMap;
import p1.y;

/* loaded from: classes.dex */
public class SearchView extends l0 implements i.b {

    /* renamed from: o0 */
    public static final /* synthetic */ int f729o0 = 0;
    public final ImageView A;
    public final ImageView B;
    public final View C;
    public p D;
    public Rect E;
    public Rect F;
    public int[] G;
    public int[] H;
    public final ImageView I;
    public final Drawable J;
    public final int K;
    public final int L;
    public final Intent M;
    public final Intent N;
    public final CharSequence O;
    public View.OnFocusChangeListener P;
    public View.OnClickListener Q;
    public boolean R;
    public boolean S;
    public u1.a T;
    public boolean U;
    public CharSequence V;
    public boolean W;

    /* renamed from: a0 */
    public boolean f730a0;

    /* renamed from: b0 */
    public int f731b0;

    /* renamed from: c0 */
    public boolean f732c0;

    /* renamed from: d0 */
    public String f733d0;

    /* renamed from: e0 */
    public CharSequence f734e0;

    /* renamed from: f0 */
    public boolean f735f0;

    /* renamed from: g0 */
    public int f736g0;

    /* renamed from: h0 */
    public SearchableInfo f737h0;

    /* renamed from: i0 */
    public Bundle f738i0;

    /* renamed from: j0 */
    public final b f739j0;

    /* renamed from: k0 */
    public c f740k0;

    /* renamed from: l0 */
    public final WeakHashMap f741l0;

    /* renamed from: m0 */
    public g f742m0;

    /* renamed from: n0 */
    public a f743n0;

    /* renamed from: u */
    public final SearchAutoComplete f744u;

    /* renamed from: v */
    public final View f745v;

    /* renamed from: w */
    public final View f746w;

    /* renamed from: x */
    public final View f747x;

    /* renamed from: y */
    public final ImageView f748y;

    /* renamed from: z */
    public final ImageView f749z;

    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends androidx.appcompat.widget.d {

        /* renamed from: j */
        public int f750j;

        /* renamed from: k */
        public SearchView f751k;

        /* renamed from: l */
        public boolean f752l;
        public final a m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            public final void run() {
                SearchAutoComplete searchAutoComplete = SearchAutoComplete.this;
                if (searchAutoComplete.f752l) {
                    ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
                    searchAutoComplete.f752l = false;
                }
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet, 0);
            this.m = new a();
            this.f750j = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i7 = configuration.screenWidthDp;
            int i8 = configuration.screenHeightDp;
            if (i7 < 960 || i8 < 720 || configuration.orientation != 2) {
                if (i7 < 600) {
                    return (i7 < 640 || i8 < 480) ? 160 : 192;
                }
                return 192;
            }
            return 256;
        }

        public final boolean enoughToFilter() {
            return this.f750j <= 0 || super.enoughToFilter();
        }

        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f752l) {
                removeCallbacks(this.m);
                post(this.m);
            }
            return onCreateInputConnection;
        }

        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        public final void onFocusChanged(boolean z6, int i7, Rect rect) {
            super.onFocusChanged(z6, i7, rect);
            SearchView searchView = this.f751k;
            searchView.v(searchView.S);
            searchView.post(searchView.f739j0);
            if (searchView.f744u.hasFocus()) {
                k.a(searchView.f744u);
            }
        }

        public final boolean onKeyPreIme(int i7, KeyEvent keyEvent) {
            if (i7 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f751k.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i7, keyEvent);
        }

        public final void onWindowFocusChanged(boolean z6) {
            super.onWindowFocusChanged(z6);
            if (z6 && this.f751k.hasFocus() && getVisibility() == 0) {
                this.f752l = true;
                Context context = getContext();
                int i7 = SearchView.f729o0;
                if (context.getResources().getConfiguration().orientation == 2) {
                    k.b(this, 1);
                    if (enoughToFilter()) {
                        showDropDown();
                    }
                }
            }
        }

        public final void performCompletion() {
        }

        public final void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z6) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z6) {
                this.f752l = false;
                removeCallbacks(this.m);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (!inputMethodManager.isActive(this)) {
                this.f752l = true;
            } else {
                this.f752l = false;
                removeCallbacks(this.m);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f751k = searchView;
        }

        public void setThreshold(int i7) {
            super.setThreshold(i7);
            this.f750j = i7;
        }
    }

    /* loaded from: classes.dex */
    public class a implements TextWatcher {
        public a() {
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }

        public final void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            SearchView searchView = SearchView.this;
            Editable text = searchView.f744u.getText();
            searchView.f734e0 = text;
            boolean z6 = !TextUtils.isEmpty(text);
            searchView.u(z6);
            boolean z7 = !z6;
            int i10 = 8;
            if (searchView.f732c0 && !searchView.S && z7) {
                searchView.f749z.setVisibility(8);
                i10 = 0;
            }
            searchView.B.setVisibility(i10);
            searchView.q();
            searchView.t();
            searchView.getClass();
            searchView.f733d0 = charSequence.toString();
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        public final void run() {
            SearchView.this.r();
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        public final void run() {
            u1.a aVar = SearchView.this.T;
            if (aVar instanceof u0) {
                aVar.c(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        public final void onFocusChange(View view, boolean z6) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.P;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z6);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements View.OnLayoutChangeListener {
        public e() {
        }

        public final void onLayoutChange(View view, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
            SearchView searchView = SearchView.this;
            if (searchView.C.getWidth() > 1) {
                Resources resources = searchView.getContext().getResources();
                int paddingLeft = searchView.f746w.getPaddingLeft();
                Rect rect = new Rect();
                boolean a7 = g1.a(searchView);
                int dimensionPixelSize = searchView.R ? resources.getDimensionPixelSize(2131099690) + resources.getDimensionPixelSize(2131099689) : 0;
                searchView.f744u.getDropDownBackground().getPadding(rect);
                searchView.f744u.setDropDownHorizontalOffset(a7 ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
                searchView.f744u.setDropDownWidth((((searchView.C.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        public final void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f748y) {
                searchView.v(false);
                searchView.f744u.requestFocus();
                searchView.f744u.setImeVisibility(true);
                View.OnClickListener onClickListener = searchView.Q;
                if (onClickListener != null) {
                    onClickListener.onClick(searchView);
                }
            } else if (view == searchView.A) {
                searchView.l();
            } else if (view == searchView.f749z) {
                searchView.p();
            } else if (view != searchView.B) {
                SearchAutoComplete searchAutoComplete = searchView.f744u;
                if (view == searchAutoComplete) {
                    k.a(searchAutoComplete);
                }
            } else {
                SearchableInfo searchableInfo = searchView.f737h0;
                if (searchableInfo == null) {
                    return;
                }
                try {
                    if (!searchableInfo.getVoiceSearchLaunchWebSearch()) {
                        if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                            searchView.getContext().startActivity(searchView.k(searchView.N, searchableInfo));
                            return;
                        }
                        return;
                    }
                    Intent intent = new Intent(searchView.M);
                    ComponentName searchActivity = searchableInfo.getSearchActivity();
                    intent.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
                    searchView.getContext().startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                    Log.w("SearchView", "Could not find voice search activity");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements View.OnKeyListener {
        public g() {
        }

        public final boolean onKey(View view, int i7, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f737h0 == null) {
                return false;
            }
            if (!searchView.f744u.isPopupShowing() || SearchView.this.f744u.getListSelection() == -1) {
                if (!(TextUtils.getTrimmedLength(SearchView.this.f744u.getText()) == 0) && keyEvent.hasNoModifiers() && keyEvent.getAction() == 1 && i7 == 66) {
                    view.cancelLongPress();
                    SearchView searchView2 = SearchView.this;
                    searchView2.getContext().startActivity(searchView2.j("android.intent.action.SEARCH", null, null, searchView2.f744u.getText().toString()));
                    return true;
                }
                return false;
            }
            SearchView searchView3 = SearchView.this;
            if (searchView3.f737h0 != null && searchView3.T != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
                if (i7 == 66 || i7 == 84 || i7 == 61) {
                    return searchView3.m(searchView3.f744u.getListSelection());
                }
                if (i7 != 21 && i7 != 22) {
                    if (i7 == 19) {
                        searchView3.f744u.getListSelection();
                        return false;
                    }
                    return false;
                }
                searchView3.f744u.setSelection(i7 == 21 ? 0 : searchView3.f744u.length());
                searchView3.f744u.setListSelection(0);
                searchView3.f744u.clearListSelection();
                SearchAutoComplete searchAutoComplete = searchView3.f744u;
                searchAutoComplete.getClass();
                k.b(searchAutoComplete, 1);
                if (searchAutoComplete.enoughToFilter()) {
                    searchAutoComplete.showDropDown();
                }
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class h implements TextView.OnEditorActionListener {
        public h() {
        }

        public final boolean onEditorAction(TextView textView, int i7, KeyEvent keyEvent) {
            SearchView.this.p();
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        public final void onItemClick(AdapterView adapterView, View view, int i7, long j5) {
            SearchView.this.m(i7);
        }
    }

    /* loaded from: classes.dex */
    public class j implements AdapterView.OnItemSelectedListener {
        public j() {
        }

        public final void onItemSelected(AdapterView adapterView, View view, int i7, long j5) {
            SearchView.this.n(i7);
        }

        public final void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* loaded from: classes.dex */
    public static class k {
        public static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        public static void b(SearchAutoComplete searchAutoComplete, int i7) {
            searchAutoComplete.setInputMethodMode(i7);
        }
    }

    /* loaded from: classes.dex */
    public interface l {
        boolean a();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean a();

        boolean b();
    }

    /* loaded from: classes.dex */
    public interface n {
        boolean a();

        boolean b();
    }

    /* loaded from: classes.dex */
    public static class o extends Kotlin_2.a {
        public static final Parcelable.Creator CREATOR = new a();

        /* renamed from: h */
        public boolean f764h;

        /* loaded from: classes.dex */
        public class a implements Parcelable.ClassLoaderCreator {
            public final Object createFromParcel(Parcel parcel) {
                return new o(parcel, null);
            }

            public final Object[] newArray(int i7) {
                return new o[i7];
            }

            public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new o(parcel, classLoader);
            }
        }

        public o(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f764h = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public o(Parcelable parcelable) {
            super(parcelable);
        }

        public final String toString() {
            StringBuilder d7 = androidx.activity.h.d("SearchView.SavedState{");
            d7.append(Integer.toHexString(System.identityHashCode(this)));
            d7.append(" isIconified=");
            d7.append(this.f764h);
            d7.append("}");
            return d7.toString();
        }

        public final void writeToParcel(Parcel parcel, int i7) {
            parcel.writeParcelable(this.f6374f, i7);
            parcel.writeValue(Boolean.valueOf(this.f764h));
        }
    }

    /* loaded from: classes.dex */
    public static class p extends TouchDelegate {

        /* renamed from: a */
        public final View f765a;

        /* renamed from: b */
        public final Rect f766b;

        /* renamed from: c */
        public final Rect f767c;

        /* renamed from: d */
        public final Rect f768d;
        public final int e;

        /* renamed from: f */
        public boolean f769f;

        public p(Rect rect, Rect rect2, SearchAutoComplete searchAutoComplete) {
            super(rect, searchAutoComplete);
            int scaledTouchSlop = ViewConfiguration.get(searchAutoComplete.getContext()).getScaledTouchSlop();
            this.e = scaledTouchSlop;
            Rect rect3 = new Rect();
            this.f766b = rect3;
            Rect rect4 = new Rect();
            this.f768d = rect4;
            Rect rect5 = new Rect();
            this.f767c = rect5;
            rect3.set(rect);
            rect4.set(rect);
            int i7 = -scaledTouchSlop;
            rect4.inset(i7, i7);
            rect5.set(rect2);
            this.f765a = searchAutoComplete;
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z6;
            float f7;
            int i7;
            boolean z7;
            int x3 = (int) motionEvent.getX();
            int y6 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z8 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z7 = this.f769f;
                    if (z7 && !this.f768d.contains(x3, y6)) {
                        z8 = z7;
                        z6 = false;
                    }
                } else {
                    if (action == 3) {
                        z7 = this.f769f;
                        this.f769f = false;
                    }
                    z6 = true;
                    z8 = false;
                }
                z8 = z7;
                z6 = true;
            } else {
                if (this.f766b.contains(x3, y6)) {
                    this.f769f = true;
                    z6 = true;
                }
                z6 = true;
                z8 = false;
            }
            if (z8) {
                if (!z6 || this.f767c.contains(x3, y6)) {
                    Rect rect = this.f767c;
                    f7 = x3 - rect.left;
                    i7 = y6 - rect.top;
                } else {
                    f7 = this.f765a.getWidth() / 2;
                    i7 = this.f765a.getHeight() / 2;
                }
                motionEvent.setLocation(f7, i7);
                return this.f765a.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130904032);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.E = new Rect();
        this.F = new Rect();
        this.G = new int[2];
        this.H = new int[2];
        this.f739j0 = new b();
        this.f740k0 = new c();
        this.f741l0 = new WeakHashMap();
        f fVar = new f();
        this.f742m0 = new g();
        h hVar = new h();
        i iVar = new i();
        j jVar = new j();
        this.f743n0 = new a();
        int[] iArr = a0.e.Q;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i7, 0);
        a1 a1Var = new a1(context, obtainStyledAttributes);
        WeakHashMap<View, p1.k0> weakHashMap = p1.y.f5540a;
        y.m.d(this, context, iArr, attributeSet, obtainStyledAttributes, i7, 0);
        LayoutInflater.from(context).inflate(a1Var.i(19, 2131492889), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(2131296774);
        this.f744u = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f745v = findViewById(2131296770);
        View findViewById = findViewById(2131296773);
        this.f746w = findViewById;
        View findViewById2 = findViewById(2131296818);
        this.f747x = findViewById2;
        ImageView imageView = (ImageView) findViewById(2131296768);
        this.f748y = imageView;
        ImageView imageView2 = (ImageView) findViewById(2131296771);
        this.f749z = imageView2;
        ImageView imageView3 = (ImageView) findViewById(2131296769);
        this.A = imageView3;
        ImageView imageView4 = (ImageView) findViewById(2131296775);
        this.B = imageView4;
        ImageView imageView5 = (ImageView) findViewById(2131296772);
        this.I = imageView5;
        y.d.q(findViewById, a1Var.e(20));
        y.d.q(findViewById2, a1Var.e(25));
        imageView.setImageDrawable(a1Var.e(23));
        imageView2.setImageDrawable(a1Var.e(15));
        imageView3.setImageDrawable(a1Var.e(12));
        imageView4.setImageDrawable(a1Var.e(28));
        imageView5.setImageDrawable(a1Var.e(23));
        this.J = a1Var.e(22);
        d1.a(imageView, getResources().getString(2131820565));
        this.K = a1Var.i(26, 2131492888);
        this.L = a1Var.i(13, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f743n0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.f742m0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(a1Var.a(18, true));
        int d7 = a1Var.d(2, -1);
        if (d7 != -1) {
            setMaxWidth(d7);
        }
        this.O = a1Var.k(14);
        this.V = a1Var.k(21);
        int h7 = a1Var.h(6, -1);
        if (h7 != -1) {
            setImeOptions(h7);
        }
        int h8 = a1Var.h(5, -1);
        if (h8 != -1) {
            setInputType(h8);
        }
        setFocusable(a1Var.a(1, true));
        a1Var.n();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.M = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.N = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.C = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new e());
        }
        v(this.R);
        s();
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(2131099702);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(2131099703);
    }

    private void setQuery(CharSequence charSequence) {
        this.f744u.setText(charSequence);
        this.f744u.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public final void clearFocus() {
        this.f730a0 = true;
        super.clearFocus();
        this.f744u.clearFocus();
        this.f744u.setImeVisibility(false);
        this.f730a0 = false;
    }

    public int getImeOptions() {
        return this.f744u.getImeOptions();
    }

    public int getInputType() {
        return this.f744u.getInputType();
    }

    public int getMaxWidth() {
        return this.f731b0;
    }

    public CharSequence getQuery() {
        return this.f744u.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.V;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f737h0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.O : getContext().getText(this.f737h0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.L;
    }

    public int getSuggestionRowLayout() {
        return this.K;
    }

    public u1.a getSuggestionsAdapter() {
        return this.T;
    }

    public final Intent j(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f734e0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f738i0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.f737h0.getSearchActivity());
        return intent;
    }

    public final Intent k(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f738i0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void l() {
        if (!TextUtils.isEmpty(this.f744u.getText())) {
            this.f744u.setText("");
            this.f744u.requestFocus();
            this.f744u.setImeVisibility(true);
        } else if (this.R) {
            clearFocus();
            v(true);
        }
    }

    public final boolean m(int i7) {
        int i8;
        String i9;
        Cursor cursor = this.T.f6082h;
        if (cursor != null && cursor.moveToPosition(i7)) {
            Intent intent = null;
            try {
                int i10 = u0.C;
                String i11 = u0.i(cursor, cursor.getColumnIndex("suggest_intent_action"));
                if (i11 == null) {
                    i11 = this.f737h0.getSuggestIntentAction();
                }
                if (i11 == null) {
                    i11 = "android.intent.action.SEARCH";
                }
                String i12 = u0.i(cursor, cursor.getColumnIndex("suggest_intent_data"));
                if (i12 == null) {
                    i12 = this.f737h0.getSuggestIntentData();
                }
                if (i12 != null && (i9 = u0.i(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                    i12 = i12 + "/" + Uri.encode(i9);
                }
                intent = j(i11, i12 == null ? null : Uri.parse(i12), u0.i(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), u0.i(cursor, cursor.getColumnIndex("suggest_intent_query")));
            } catch (RuntimeException e7) {
                try {
                    i8 = cursor.getPosition();
                } catch (RuntimeException unused) {
                    i8 = -1;
                }
                Log.w("SearchView", "Search suggestions cursor at row " + i8 + " returned exception.", e7);
            }
            if (intent != null) {
                try {
                    getContext().startActivity(intent);
                } catch (RuntimeException e8) {
                    Log.e("SearchView", "Failed launch activity: " + intent, e8);
                }
            }
        }
        this.f744u.setImeVisibility(false);
        this.f744u.dismissDropDown();
        return true;
    }

    public final void n(int i7) {
        String d7;
        Editable text = this.f744u.getText();
        Cursor cursor = this.T.f6082h;
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToPosition(i7) || (d7 = this.T.d(cursor)) == null) {
            setQuery(text);
        } else {
            setQuery(d7);
        }
    }

    public final void o(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public final void onActionViewCollapsed() {
        this.f744u.setText("");
        SearchAutoComplete searchAutoComplete = this.f744u;
        searchAutoComplete.setSelection(searchAutoComplete.length());
        this.f734e0 = "";
        clearFocus();
        v(true);
        this.f744u.setImeOptions(this.f736g0);
        this.f735f0 = false;
    }

    public final void onActionViewExpanded() {
        if (this.f735f0) {
            return;
        }
        this.f735f0 = true;
        int imeOptions = this.f744u.getImeOptions();
        this.f736g0 = imeOptions;
        this.f744u.setImeOptions(imeOptions | 33554432);
        this.f744u.setText("");
        setIconified(false);
    }

    public final void onDetachedFromWindow() {
        removeCallbacks(this.f739j0);
        post(this.f740k0);
        super.onDetachedFromWindow();
    }

    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        super.onLayout(z6, i7, i8, i9, i10);
        if (z6) {
            SearchAutoComplete searchAutoComplete = this.f744u;
            Rect rect = this.E;
            searchAutoComplete.getLocationInWindow(this.G);
            getLocationInWindow(this.H);
            int[] iArr = this.G;
            int i11 = iArr[1];
            int[] iArr2 = this.H;
            int i12 = i11 - iArr2[1];
            int i13 = iArr[0] - iArr2[0];
            rect.set(i13, i12, searchAutoComplete.getWidth() + i13, searchAutoComplete.getHeight() + i12);
            Rect rect2 = this.F;
            Rect rect3 = this.E;
            rect2.set(rect3.left, 0, rect3.right, i10 - i8);
            p pVar = this.D;
            if (pVar == null) {
                p pVar2 = new p(this.F, this.E, this.f744u);
                this.D = pVar2;
                setTouchDelegate(pVar2);
                return;
            }
            Rect rect4 = this.F;
            Rect rect5 = this.E;
            pVar.f766b.set(rect4);
            pVar.f768d.set(rect4);
            Rect rect6 = pVar.f768d;
            int i14 = -pVar.e;
            rect6.inset(i14, i14);
            pVar.f767c.set(rect5);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        if (r0 <= 0) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            boolean r0 = r3.S
            if (r0 == 0) goto L8
            super.onMeasure(r4, r5)
            return
        L8:
            int r0 = android.view.View.MeasureSpec.getMode(r4)
            int r4 = android.view.View.MeasureSpec.getSize(r4)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L2a
            if (r0 == 0) goto L20
            if (r0 == r2) goto L1b
            goto L37
        L1b:
            int r0 = r3.f731b0
            if (r0 <= 0) goto L37
            goto L2e
        L20:
            int r4 = r3.f731b0
            if (r4 <= 0) goto L25
            goto L37
        L25:
            int r4 = r3.getPreferredWidth()
            goto L37
        L2a:
            int r0 = r3.f731b0
            if (r0 <= 0) goto L2f
        L2e:
            goto L33
        L2f:
            int r0 = r3.getPreferredWidth()
        L33:
            int r4 = java.lang.Math.min(r0, r4)
        L37:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            if (r0 == r1) goto L49
            if (r0 == 0) goto L44
            goto L51
        L44:
            int r5 = r3.getPreferredHeight()
            goto L51
        L49:
            int r0 = r3.getPreferredHeight()
            int r5 = java.lang.Math.min(r0, r5)
        L51:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r2)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r2)
            super.onMeasure(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.onMeasure(int, int):void");
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof o)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        o oVar = (o) parcelable;
        super.onRestoreInstanceState(oVar.f6374f);
        v(oVar.f764h);
        requestLayout();
    }

    public final Parcelable onSaveInstanceState() {
        o oVar = new o(super.onSaveInstanceState());
        oVar.f764h = this.S;
        return oVar;
    }

    public final void onWindowFocusChanged(boolean z6) {
        super.onWindowFocusChanged(z6);
        post(this.f739j0);
    }

    public final void p() {
        Editable text = this.f744u.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f737h0 != null) {
            getContext().startActivity(j("android.intent.action.SEARCH", null, null, text.toString()));
        }
        this.f744u.setImeVisibility(false);
        this.f744u.dismissDropDown();
    }

    public final void q() {
        boolean z6 = true;
        boolean z7 = !TextUtils.isEmpty(this.f744u.getText());
        if (!z7 && (!this.R || this.f735f0)) {
            z6 = false;
        }
        this.A.setVisibility(z6 ? 0 : 8);
        Drawable drawable = this.A.getDrawable();
        if (drawable != null) {
            drawable.setState(z7 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public final void r() {
        int[] iArr = this.f744u.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f746w.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f747x.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final boolean requestFocus(int i7, Rect rect) {
        if (!this.f730a0 && isFocusable()) {
            if (this.S) {
                return super.requestFocus(i7, rect);
            }
            boolean requestFocus = this.f744u.requestFocus(i7, rect);
            if (requestFocus) {
                v(false);
            }
            return requestFocus;
        }
        return false;
    }

    public final void s() {
        SpannableStringBuilder queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f744u;
        if (queryHint == null) {
            queryHint = "";
        }
        if (this.R && this.J != null) {
            int textSize = (int) (searchAutoComplete.getTextSize() * 1.25d);
            this.J.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.J), 1, 2, 33);
            spannableStringBuilder.append(queryHint);
            queryHint = spannableStringBuilder;
        }
        searchAutoComplete.setHint(queryHint);
    }

    public void setAppSearchData(Bundle bundle) {
        this.f738i0 = bundle;
    }

    public void setIconified(boolean z6) {
        if (z6) {
            l();
            return;
        }
        v(false);
        this.f744u.requestFocus();
        this.f744u.setImeVisibility(true);
        View.OnClickListener onClickListener = this.Q;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z6) {
        if (this.R == z6) {
            return;
        }
        this.R = z6;
        v(z6);
        s();
    }

    public void setImeOptions(int i7) {
        this.f744u.setImeOptions(i7);
    }

    public void setInputType(int i7) {
        this.f744u.setInputType(i7);
    }

    public void setMaxWidth(int i7) {
        this.f731b0 = i7;
        requestLayout();
    }

    public void setOnCloseListener(l lVar) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.P = onFocusChangeListener;
    }

    public void setOnQueryTextListener(m mVar) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.Q = onClickListener;
    }

    public void setOnSuggestionListener(n nVar) {
    }

    public void setQueryHint(CharSequence charSequence) {
        this.V = charSequence;
        s();
    }

    public void setQueryRefinementEnabled(boolean z6) {
        this.W = z6;
        u1.a aVar = this.T;
        if (aVar instanceof u0) {
            ((u0) aVar).f1047u = z6 ? 2 : 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009c, code lost:
        if (getContext().getPackageManager().resolveActivity(r2, 65536) != null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setSearchableInfo(android.app.SearchableInfo r7) {
        /*
            r6 = this;
            r6.f737h0 = r7
            r0 = 1
            r1 = 65536(0x10000, float:9.18355E-41)
            r2 = 0
            if (r7 == 0) goto L6e
            androidx.appcompat.widget.SearchView$SearchAutoComplete r3 = r6.f744u
            int r7 = r7.getSuggestThreshold()
            r3.setThreshold(r7)
            androidx.appcompat.widget.SearchView$SearchAutoComplete r7 = r6.f744u
            android.app.SearchableInfo r3 = r6.f737h0
            int r3 = r3.getImeOptions()
            r7.setImeOptions(r3)
            android.app.SearchableInfo r7 = r6.f737h0
            int r7 = r7.getInputType()
            r3 = r7 & 15
            if (r3 != r0) goto L36
            r3 = -65537(0xfffffffffffeffff, float:NaN)
            r7 = r7 & r3
            android.app.SearchableInfo r3 = r6.f737h0
            java.lang.String r3 = r3.getSuggestAuthority()
            if (r3 == 0) goto L36
            r7 = r7 | r1
            r3 = 524288(0x80000, float:7.34684E-40)
            r7 = r7 | r3
        L36:
            androidx.appcompat.widget.SearchView$SearchAutoComplete r3 = r6.f744u
            r3.setInputType(r7)
            u1.a r7 = r6.T
            if (r7 == 0) goto L42
            r7.c(r2)
        L42:
            android.app.SearchableInfo r7 = r6.f737h0
            java.lang.String r7 = r7.getSuggestAuthority()
            if (r7 == 0) goto L6b
            androidx.appcompat.widget.u0 r7 = new androidx.appcompat.widget.u0
            android.content.Context r3 = r6.getContext()
            android.app.SearchableInfo r4 = r6.f737h0
            java.util.WeakHashMap r5 = r6.f741l0
            r7.<init>(r3, r6, r4, r5)
            r6.T = r7
            androidx.appcompat.widget.SearchView$SearchAutoComplete r3 = r6.f744u
            r3.setAdapter(r7)
            u1.a r7 = r6.T
            androidx.appcompat.widget.u0 r7 = (androidx.appcompat.widget.u0) r7
            boolean r3 = r6.W
            if (r3 == 0) goto L68
            r3 = 2
            goto L69
        L68:
            r3 = r0
        L69:
            r7.f1047u = r3
        L6b:
            r6.s()
        L6e:
            android.app.SearchableInfo r7 = r6.f737h0
            r3 = 0
            if (r7 == 0) goto L9f
            boolean r7 = r7.getVoiceSearchEnabled()
            if (r7 == 0) goto L9f
            android.app.SearchableInfo r7 = r6.f737h0
            boolean r7 = r7.getVoiceSearchLaunchWebSearch()
            if (r7 == 0) goto L84
            android.content.Intent r2 = r6.M
            goto L8e
        L84:
            android.app.SearchableInfo r7 = r6.f737h0
            boolean r7 = r7.getVoiceSearchLaunchRecognizer()
            if (r7 == 0) goto L8e
            android.content.Intent r2 = r6.N
        L8e:
            if (r2 == 0) goto L9f
            android.content.Context r7 = r6.getContext()
            android.content.pm.PackageManager r7 = r7.getPackageManager()
            android.content.pm.ResolveInfo r7 = r7.resolveActivity(r2, r1)
            if (r7 == 0) goto L9f
            goto La0
        L9f:
            r0 = r3
        La0:
            r6.f732c0 = r0
            if (r0 == 0) goto Lab
            androidx.appcompat.widget.SearchView$SearchAutoComplete r7 = r6.f744u
            java.lang.String r0 = "nm"
            r7.setPrivateImeOptions(r0)
        Lab:
            boolean r7 = r6.S
            r6.v(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.setSearchableInfo(android.app.SearchableInfo):void");
    }

    public void setSubmitButtonEnabled(boolean z6) {
        this.U = z6;
        v(this.S);
    }

    public void setSuggestionsAdapter(u1.a aVar) {
        this.T = aVar;
        this.f744u.setAdapter(aVar);
    }

    public final void t() {
        int i7 = 0;
        if (!((this.U || this.f732c0) && !this.S) || (this.f749z.getVisibility() != 0 && this.B.getVisibility() != 0)) {
            i7 = 8;
        }
        this.f747x.setVisibility(i7);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001e, code lost:
        if (r2.f732c0 == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void u(boolean r3) {
        /*
            r2 = this;
            boolean r0 = r2.U
            r1 = 0
            if (r0 == 0) goto L21
            if (r0 != 0) goto Lb
            boolean r0 = r2.f732c0
            if (r0 == 0) goto L11
        Lb:
            boolean r0 = r2.S
            if (r0 != 0) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = r1
        L12:
            if (r0 == 0) goto L21
            boolean r0 = r2.hasFocus()
            if (r0 == 0) goto L21
            if (r3 != 0) goto L23
            boolean r3 = r2.f732c0
            if (r3 != 0) goto L21
            goto L23
        L21:
            r1 = 8
        L23:
            android.widget.ImageView r2 = r2.f749z
            r2.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.u(boolean):void");
    }

    public final void v(boolean z6) {
        this.S = z6;
        int i7 = 8;
        int i8 = z6 ? 0 : 8;
        boolean z7 = !TextUtils.isEmpty(this.f744u.getText());
        this.f748y.setVisibility(i8);
        u(z7);
        this.f745v.setVisibility(z6 ? 8 : 0);
        this.I.setVisibility((this.I.getDrawable() == null || this.R) ? 8 : 0);
        q();
        boolean z8 = !z7;
        if (this.f732c0 && !this.S && z8) {
            this.f749z.setVisibility(8);
            i7 = 0;
        }
        this.B.setVisibility(i7);
        t();
    }
}
