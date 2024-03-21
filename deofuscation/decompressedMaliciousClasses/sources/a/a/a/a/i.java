package a.a.a.a;

import a.a.a.d.h;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class i extends f {
    private static short[] $ = {2007, 1996, 2005, 2005, 7154, 7154, 9576, 9579, 8960, 8977, 8977, 4486, 4489, 4483, 4501, 4488, 4494, 4483, 4674, 2652, 8791, 6564, 10497, 10530, 10542, 10540, 10529, 10605, 10507, 10559, 10540, 10538, 10528, 10536, 10531, 10553, 10508, 10542, 10553, 10532, 10555, 10532, 10553, 10548, 10605, 15422, 15437, 15466, 15487, 15466, 15483, 15396, 9073, 9073, 15545, 15511, 15526, 15537, 15541, 15520, 15537, 15536, 15593, 8879, 8848, 8871, 8881, 8887, 8879, 8871, 8870, 8959, 12183, 12250, 12260, 12227, 12248, 12231, 12231, 12242, 12243, 12170, 12951, 13018, 13029, 13010, 13014, 13019, 13019, 13006, 13028, 12995, 13016, 12999, 12999, 13010, 13011, 12938, 6737, 6766, 6754, 6768, 6695, 6735, 6766, 6754, 6773, 6758, 6773, 6756, 6767, 6782, 6717, -25551, -25595, -25578, -25584, -25574, -25582, -25575, -25597, -25546, -25580, -25597, -25570, -25599, -25570, -25597, -25586, -27685, -27655, -27666, -27661, -27668, -27661, -27666, -27677, -27718, -27672, -27649, -27671, -27665, -27658, -27666, -27718, -27650, -27649, -27658, -27661, -27668, -27649, -27672, -27649, -27650, -27718, -27652, -27659, -27672, -27718, -27665, -27660, -27663, -27660, -27659, -27667, -27660, -27718, -27684, -27672, -27653, -27651, -27657, -27649, -27660, -27666, -27724, -32178, -32148, -32133, -32154, -32135, -32154, -32133, -32138, -32209, -32131, -32150, -32132, -32134, -32157, -32133, -32209, -32159, -32160, -32209, -32151, -32131, -32146, -32152, -32158, -32150, -32159, -32133, -32209, -32150, -32137, -32154, -32132, -32133, -32132, -32209, -32151, -32160, -32131, -32209, -32136, -32153, -32160, -32203, -32209, 30398, 30385, 30395, 30381, 30384, 30390, 30395, 30437, 30380, 30378, 30383, 30383, 30384, 30381, 30379, 30437, 30393, 30381, 30398, 30392, 30386, 30394, 30385, 30379, 30380, 24796, 24787, 24793, 24783, 24786, 24788, 24793, 24711, 24782, 24776, 24781, 24781, 24786, 24783, 24777, 24711, 24787, 24792, 24773, 24777, 24802, 24783, 24792, 24780, 24776, 24792, 24782, 24777, 24802, 24788, 24787, 24793, 24792, 24773, 24590, 24577, 24587, 24605, 24576, 24582, 24587, 24661, 24604, 24602, 24607, 24607, 24576, 24605, 24603, 24661, 24605, 24586, 24606, 24602, 24586, 24604, 24603, 24624, 24582, 24577, 24587, 24582, 24588, 24582, 24586, 24604, 25516, 25507, 25513, 25535, 25506, 25508, 25513, 25591, 25534, 25528, 25533, 25533, 25506, 25535, 25529, 25591, 25535, 25512, 25532, 25528, 25512, 25534, 25529, 25490, 25515, 25535, 25516, 25514, 25504, 25512, 25507, 25529, 25490, 25530, 25509, 25506, 27958, 27906, 27921, 27927, 27933, 27925, 27934, 27908, 27953, 27923, 27908, 27929, 27910, 27929, 27908, 27913, 32612, 32579, 32603, 32588, 32577, 32580, 32585, 32525, 32607, 32584, 32604, 32600, 32584, 32606, 32601, 32622, 32578, 32585, 32584, 32525, 32576, 32588, 32605, 32605, 32580, 32579, 32586, 32525, 32580, 32579, 32525, 32606, 32588, 32603, 32584, 32585, 32612, 32579, 32606, 32601, 32588, 32579, 32590, 32584, 32638, 32601, 32588, 32601, 32584, 32515, 17410, 17462, 17445, 17443, 17449, 17441, 17450, 17456, 17413, 17447, 17456, 17453, 17458, 17453, 17456, 17469, 20706, 20672, 20695, 20682, 20693, 20682, 20695, 20698, 20611, 20689, 20678, 20688, 20694, 20687, 20695, 20611, 20679, 20678, 20687, 20682, 20693, 20678, 20689, 20678, 20679, 20611, 20677, 20684, 20689, 20611, 20694, 20685, 20680, 20685, 20684, 20692, 20685, 20611, 20709, 20689, 20674, 20676, 20686, 20678, 20685, 20695, 20621, 24013, 24047, 24056, 24037, 24058, 24037, 24056, 24053, 23980, 24062, 24041, 24063, 24057, 24032, 24056, 23980, 24034, 24035, 23980, 24042, 24062, 24045, 24043, 24033, 24041, 24034, 24056, 23980, 24041, 24052, 24037, 24063, 24056, 24063, 23980, 24042, 24035, 24062, 23980, 24059, 24036, 24035, 23990, 23980, 16309, 16314, 16304, 16294, 16315, 16317, 16304, 16366, 16295, 16289, 16292, 16292, 16315, 16294, 16288, 16366, 16306, 16294, 16309, 16307, 16313, 16305, 16314, 16288, 16295, 16286, 16273, 16283, 16269, 16272, 16278, 16283, 16325, 16268, 16266, 16271, 16271, 16272, 16269, 16267, 16325, 16273, 16282, 16263, 16267, 16288, 16269, 16282, 16270, 16266, 16282, 16268, 16267, 16288, 16278, 16273, 16283, 16282, 16263, 11751, 11752, 11746, 11764, 11753, 11759, 11746, 11708, 11765, 11763, 11766, 11766, 11753, 11764, 11762, 11708, 11764, 11747, 11767, 11763, 11747, 11765, 11762, 11737, 11759, 11752, 11746, 11759, 11749, 11759, 11747, 11765, 13028, 13035, 13025, 13047, 13034, 13036, 13025, 12991, 13046, 13040, 13045, 13045, 13034, 13047, 13041, 12991, 13047, 13024, 13044, 13040, 13024, 13046, 13041, 13018, 13027, 13047, 13028, 13026, 13032, 13024, 13035, 13041, 13018, 13042, 13037, 13034};
    final Handler c = new a();
    final k d = k.b(new b());
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    boolean j;
    int k;
    a.a.a.d.i<String> l;

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    class a extends Handler {
        a() {
            i.this = r1;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                i iVar = i.this;
                if (iVar.g) {
                    iVar.c(false);
                }
            } else if (i != 2) {
                super.handleMessage(message);
            } else {
                i.this.i();
                i.this.d.x();
            }
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    class b extends l<i> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b() {
            super(r1);
            i.this = r1;
        }

        @Override // a.a.a.a.j
        public View a(int i) {
            return i.this.findViewById(i);
        }

        @Override // a.a.a.a.j
        public boolean b() {
            Window window = i.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // a.a.a.a.l
        public void n(h hVar) {
            i.this.f(hVar);
        }

        @Override // a.a.a.a.l
        @SuppressLint({"NewApi"})
        public void o(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            i.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // a.a.a.a.l
        public LayoutInflater p() {
            return i.this.getLayoutInflater().cloneInContext(i.this);
        }

        @Override // a.a.a.a.l
        public int q() {
            Window window = i.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // a.a.a.a.l
        public boolean r() {
            return i.this.getWindow() != null;
        }

        @Override // a.a.a.a.l
        public boolean s(h hVar) {
            return !i.this.isFinishing();
        }

        @Override // a.a.a.a.l
        public void t() {
            i.this.k();
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static final class c {

        /* renamed from: a */
        Object f28a;

        /* renamed from: b */
        o f29b;
        h<String, u> c;

        c() {
        }
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    private void d(String str, PrintWriter printWriter, View view) {
        ViewGroup viewGroup;
        int childCount;
        printWriter.print(str);
        if (view == null) {
            printWriter.println($(0, 4, 1977));
            return;
        }
        printWriter.println(l(view));
        if ((view instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view).getChildCount()) > 0) {
            String str2 = str + $(4, 6, 7122);
            for (int i = 0; i < childCount; i++) {
                d(str2, printWriter, viewGroup.getChildAt(i));
            }
        }
    }

    private static String l(View view) {
        char c2;
        StringBuilder sb = new StringBuilder(128);
        sb.append(view.getClass().getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(view)));
        sb.append(' ');
        int visibility = view.getVisibility();
        char c3 = 'V';
        char c4 = '.';
        if (visibility != 0) {
            if (visibility == 4) {
                c2 = 'I';
            } else if (visibility != 8) {
                sb.append('.');
            } else {
                c2 = 'G';
            }
            sb.append(c2);
        } else {
            sb.append('V');
        }
        char c5 = 'F';
        sb.append(view.isFocusable() ? 'F' : '.');
        sb.append(view.isEnabled() ? 'E' : '.');
        sb.append(view.willNotDraw() ? '.' : 'D');
        sb.append(view.isHorizontalScrollBarEnabled() ? 'H' : '.');
        if (!view.isVerticalScrollBarEnabled()) {
            c3 = '.';
        }
        sb.append(c3);
        sb.append(view.isClickable() ? 'C' : '.');
        sb.append(view.isLongClickable() ? 'L' : '.');
        sb.append(' ');
        if (!view.isFocused()) {
            c5 = '.';
        }
        sb.append(c5);
        sb.append(view.isSelected() ? 'S' : '.');
        if (view.isPressed()) {
            c4 = 'P';
        }
        sb.append(c4);
        sb.append(' ');
        sb.append(view.getLeft());
        sb.append(',');
        sb.append(view.getTop());
        sb.append('-');
        sb.append(view.getRight());
        sb.append(',');
        sb.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            sb.append($(6, 8, 9544));
            sb.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                int i = -16777216 & id;
                try {
                    String resourcePackageName = i != 16777216 ? i != 2130706432 ? resources.getResourcePackageName(id) : $(8, 11, 9057) : $(11, 18, 4583);
                    String resourceTypeName = resources.getResourceTypeName(id);
                    String resourceEntryName = resources.getResourceEntryName(id);
                    sb.append($(18, 19, 4706));
                    sb.append(resourcePackageName);
                    sb.append($(19, 20, 2662));
                    sb.append(resourceTypeName);
                    sb.append($(20, 21, 8824));
                    sb.append(resourceEntryName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        sb.append($(21, 22, 6617));
        return sb.toString();
    }

    @Override // a.a.a.a.d
    public final View b(View view, String str, Context context, AttributeSet attributeSet) {
        return this.d.B(view, str, context, attributeSet);
    }

    void c(boolean z) {
        if (!this.h) {
            this.h = true;
            this.i = z;
            this.c.removeMessages(1);
            h();
        } else if (z) {
            this.d.u();
            this.d.v(true);
        }
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print($(22, 45, 10573));
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println($(45, 52, 15390));
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String $2 = $(52, 54, 9041);
        sb.append($2);
        String sb2 = sb.toString();
        printWriter.print(sb2);
        printWriter.print($(54, 63, 15572));
        printWriter.print(this.e);
        printWriter.print($(63, 72, 8898));
        printWriter.print(this.f);
        printWriter.print($(72, 82, 12215));
        printWriter.print(this.g);
        printWriter.print($(82, 98, 12983));
        printWriter.println(this.h);
        this.d.w(sb2, fileDescriptor, printWriter, strArr);
        this.d.z().b(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println($(98, 113, 6663));
        d(str + $2, printWriter, getWindow().getDecorView());
    }

    public m e() {
        return this.d.z();
    }

    public void f(h hVar) {
    }

    protected boolean g(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    void h() {
        this.d.v(this.i);
        this.d.p();
    }

    protected void i() {
        this.d.q();
    }

    public Object j() {
        return null;
    }

    public void k() {
        if (Build.VERSION.SDK_INT >= 11) {
            a.a(this);
        } else {
            this.j = true;
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        this.d.A();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String e = this.l.e(i4);
            this.l.i(i4);
            String $2 = $(113, 129, -25481);
            if (e == null) {
                Log.w($2, $(129, 176, -27750));
                return;
            }
            h y = this.d.y(e);
            if (y == null) {
                Log.w($2, $(176, 220, -32241) + e);
                return;
            }
            y.J(i & 65535, i2, intent);
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (!this.d.z().d()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.d.d(configuration);
    }

    @Override // a.a.a.a.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        o oVar = null;
        this.d.a(null);
        super.onCreate(bundle);
        c cVar = (c) getLastNonConfigurationInstance();
        if (cVar != null) {
            this.d.E(cVar.c);
        }
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable($(220, 245, 30431));
            k kVar = this.d;
            if (cVar != null) {
                oVar = cVar.f29b;
            }
            kVar.D(parcelable, oVar);
            String $2 = $(245, 279, 24765);
            if (bundle.containsKey($2)) {
                this.k = bundle.getInt($2);
                int[] intArray = bundle.getIntArray($(279, 311, 24687));
                String[] stringArray = bundle.getStringArray($(311, 347, 25549));
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w($(347, 363, 28016), $(363, 413, 32557));
                } else {
                    this.l = new a.a.a.d.i<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.l.h(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.l == null) {
            this.l = new a.a.a.d.i<>();
            this.k = 0;
        }
        this.d.f();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.d.g(menu, getMenuInflater());
        if (Build.VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        c(false);
        this.d.h();
        this.d.t();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.d.i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.d.k(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.d.e(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.d.j(z);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.d.A();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.d.l(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f = false;
        if (this.c.hasMessages(2)) {
            this.c.removeMessages(2);
            i();
        }
        this.d.m();
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.d.n(z);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.c.removeMessages(2);
        i();
        this.d.x();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.j) {
            this.j = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return g(view, menu) | this.d.o(menu);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String e = this.l.e(i3);
            this.l.i(i3);
            String $2 = $(413, 429, 17476);
            if (e == null) {
                Log.w($2, $(429, 476, 20643));
                return;
            }
            h y = this.d.y(e);
            if (y == null) {
                Log.w($2, $(476, 520, 23948) + e);
                return;
            }
            y.f0(i & 65535, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.c.sendEmptyMessage(2);
        this.f = true;
        this.d.x();
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        if (this.g) {
            c(true);
        }
        Object j = j();
        o G = this.d.G();
        h<String, u> F = this.d.F();
        if (G == null && F == null && j == null) {
            return null;
        }
        c cVar = new c();
        cVar.f28a = j;
        cVar.f29b = G;
        cVar.c = F;
        return cVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable H = this.d.H();
        if (H != null) {
            bundle.putParcelable($(520, 545, 16340), H);
        }
        if (this.l.j() > 0) {
            bundle.putInt($(545, 579, 16383), this.k);
            int[] iArr = new int[this.l.j()];
            String[] strArr = new String[this.l.j()];
            for (int i = 0; i < this.l.j(); i++) {
                iArr[i] = this.l.g(i);
                strArr[i] = this.l.k(i);
            }
            bundle.putIntArray($(579, 611, 11654), iArr);
            bundle.putStringArray($(611, 647, 12933), strArr);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.g = false;
        this.h = false;
        this.c.removeMessages(1);
        if (!this.e) {
            this.e = true;
            this.d.c();
        }
        this.d.A();
        this.d.x();
        this.d.u();
        this.d.r();
        this.d.C();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.d.A();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.g = true;
        this.c.sendEmptyMessage(1);
        this.d.s();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (!this.f13b && i != -1) {
            d.a(i);
        }
        super.startActivityForResult(intent, i);
    }
}
