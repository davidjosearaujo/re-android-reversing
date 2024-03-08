package i;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class h implements Window.Callback {

    /* renamed from: f  reason: collision with root package name */
    public final Window.Callback f4457f;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {
        public static boolean a(Window.Callback callback, SearchEvent searchEvent) {
            return callback.onSearchRequested(searchEvent);
        }

        public static ActionMode b(Window.Callback callback, ActionMode.Callback callback2, int i7) {
            return callback.onWindowStartingActionMode(callback2, i7);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {
        public static void a(Window.Callback callback, List<KeyboardShortcutGroup> list, Menu menu, int i7) {
            callback.onProvideKeyboardShortcuts(list, menu, i7);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c {
        public static void a(Window.Callback callback, boolean z6) {
            callback.onPointerCaptureChanged(z6);
        }
    }

    public h(Window.Callback callback) {
        if (callback != null) {
            this.f4457f = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f4457f.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f4457f.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f4457f.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f4457f.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f4457f.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f4457f.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f4457f.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f4457f.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f4457f.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i7, Menu menu) {
        return this.f4457f.onCreatePanelMenu(i7, menu);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i7) {
        return this.f4457f.onCreatePanelView(i7);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f4457f.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i7, MenuItem menuItem) {
        return this.f4457f.onMenuItemSelected(i7, menuItem);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i7, Menu menu) {
        return this.f4457f.onMenuOpened(i7, menu);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i7, Menu menu) {
        this.f4457f.onPanelClosed(i7, menu);
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z6) {
        c.a(this.f4457f, z6);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i7, View view, Menu menu) {
        return this.f4457f.onPreparePanel(i7, view, menu);
    }

    @Override // android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i7) {
        b.a(this.f4457f, list, menu, i7);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f4457f.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return a.a(this.f4457f, searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f4457f.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z6) {
        this.f4457f.onWindowFocusChanged(z6);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i7) {
        return a.b(this.f4457f, callback, i7);
    }
}
