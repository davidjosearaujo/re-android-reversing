package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CodelessLoggingEventListener {
    private static final String TAG = "com.facebook.appevents.codeless.CodelessLoggingEventListener";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class AutoLoggingOnClickListener implements View.OnClickListener {
        @Nullable
        private View.OnClickListener existingOnClickListener;
        private WeakReference<View> hostView;
        private EventBinding mapping;
        private WeakReference<View> rootView;
        private boolean supportCodelessLogging;

        public boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                View.OnClickListener onClickListener = this.existingOnClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                if (this.rootView.get() == null || this.hostView.get() == null) {
                    return;
                }
                CodelessLoggingEventListener.access$200(this.mapping, this.rootView.get(), this.hostView.get());
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }

        private AutoLoggingOnClickListener(EventBinding eventBinding, View view, View view2) {
            this.supportCodelessLogging = false;
            if (eventBinding == null || view == null || view2 == null) {
                return;
            }
            this.existingOnClickListener = ViewHierarchy.getExistingOnClickListener(view2);
            this.mapping = eventBinding;
            this.hostView = new WeakReference<>(view2);
            this.rootView = new WeakReference<>(view);
            this.supportCodelessLogging = true;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class AutoLoggingOnItemClickListener implements AdapterView.OnItemClickListener {
        @Nullable
        private AdapterView.OnItemClickListener existingOnItemClickListener;
        private WeakReference<AdapterView> hostView;
        private EventBinding mapping;
        private WeakReference<View> rootView;
        private boolean supportCodelessLogging;

        public boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AdapterView.OnItemClickListener onItemClickListener = this.existingOnItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i, j);
            }
            if (this.rootView.get() == null || this.hostView.get() == null) {
                return;
            }
            CodelessLoggingEventListener.access$200(this.mapping, this.rootView.get(), this.hostView.get());
        }

        private AutoLoggingOnItemClickListener(EventBinding eventBinding, View view, AdapterView adapterView) {
            this.supportCodelessLogging = false;
            if (eventBinding == null || view == null || adapterView == null) {
                return;
            }
            this.existingOnItemClickListener = adapterView.getOnItemClickListener();
            this.mapping = eventBinding;
            this.hostView = new WeakReference<>(adapterView);
            this.rootView = new WeakReference<>(view);
            this.supportCodelessLogging = true;
        }
    }

    public static /* synthetic */ void access$200(EventBinding eventBinding, View view, View view2) {
        if (CrashShieldHandler.isObjectCrashing(CodelessLoggingEventListener.class)) {
            return;
        }
        try {
            logEvent(eventBinding, view, view2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessLoggingEventListener.class);
        }
    }

    public static AutoLoggingOnClickListener getOnClickListener(EventBinding eventBinding, View view, View view2) {
        if (CrashShieldHandler.isObjectCrashing(CodelessLoggingEventListener.class)) {
            return null;
        }
        try {
            return new AutoLoggingOnClickListener(eventBinding, view, view2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessLoggingEventListener.class);
            return null;
        }
    }

    public static AutoLoggingOnItemClickListener getOnItemClickListener(EventBinding eventBinding, View view, AdapterView adapterView) {
        if (CrashShieldHandler.isObjectCrashing(CodelessLoggingEventListener.class)) {
            return null;
        }
        try {
            return new AutoLoggingOnItemClickListener(eventBinding, view, adapterView);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessLoggingEventListener.class);
            return null;
        }
    }

    private static void logEvent(EventBinding eventBinding, View view, View view2) {
        if (CrashShieldHandler.isObjectCrashing(CodelessLoggingEventListener.class)) {
            return;
        }
        try {
            final String eventName = eventBinding.getEventName();
            final Bundle parameters = CodelessMatcher.getParameters(eventBinding, view, view2);
            updateParameters(parameters);
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.codeless.CodelessLoggingEventListener.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        AppEventsLogger.newLogger(FacebookSdk.getApplicationContext()).logEvent(eventName, parameters);
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessLoggingEventListener.class);
        }
    }

    public static void updateParameters(Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(CodelessLoggingEventListener.class)) {
            return;
        }
        try {
            String string = bundle.getString("_valueToSum");
            if (string != null) {
                bundle.putDouble("_valueToSum", AppEventUtility.normalizePrice(string));
            }
            bundle.putString(Constants.IS_CODELESS_EVENT_KEY, "1");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessLoggingEventListener.class);
        }
    }
}
