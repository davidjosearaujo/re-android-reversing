package q3;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b extends FloatingActionButton.a {

    /* renamed from: a */
    public final /* synthetic */ int f5657a;

    /* renamed from: b */
    public final /* synthetic */ BottomAppBar f5658b;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends FloatingActionButton.a {
        public a() {
            b.this = r1;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
        public final void b() {
            BottomAppBar bottomAppBar = b.this.f5658b;
            int i7 = BottomAppBar.f2818o0;
            bottomAppBar.getClass();
        }
    }

    public b(BottomAppBar bottomAppBar, int i7) {
        this.f5658b = bottomAppBar;
        this.f5657a = i7;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
    public final void a(FloatingActionButton floatingActionButton) {
        floatingActionButton.setTranslationX(this.f5658b.y(this.f5657a));
        floatingActionButton.k(new a(), true);
    }
}
