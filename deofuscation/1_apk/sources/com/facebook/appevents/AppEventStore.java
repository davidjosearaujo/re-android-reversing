package com.facebook.appevents;

import android.content.Context;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import n.b0;
import n.l2.k;
import n.l2.v.f0;
import n.l2.v.u;
import r.e.a.d;
import r.e.a.e;

/* compiled from: AppEventStore.kt */
@b0(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\u0017\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0002\b\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/AppEventStore;", "", "()V", "PERSISTED_EVENTS_FILENAME", "", "TAG", "persistEvents", "", "accessTokenAppIdPair", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "appEvents", "Lcom/facebook/appevents/SessionEventsState;", "eventsToPersist", "Lcom/facebook/appevents/AppEventCollection;", "readAndClearStore", "Lcom/facebook/appevents/PersistedEvents;", "saveEventsToDisk", "saveEventsToDisk$facebook_core_release", "MovedClassObjectInputStream", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class AppEventStore {
    @d
    public static final AppEventStore INSTANCE = new AppEventStore();
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    private static final String TAG;

    /* compiled from: AppEventStore.kt */
    @b0(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/AppEventStore$MovedClassObjectInputStream;", "Ljava/io/ObjectInputStream;", "inputStream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "readClassDescriptor", "Ljava/io/ObjectStreamClass;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class MovedClassObjectInputStream extends ObjectInputStream {
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2";
        @d
        public static final Companion Companion = new Companion(null);

        /* compiled from: AppEventStore.kt */
        @b0(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/appevents/AppEventStore$MovedClassObjectInputStream$Companion;", "", "()V", "ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME", "", "APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(u uVar) {
                this();
            }
        }

        public MovedClassObjectInputStream(@e InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        @d
        public ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            f0.o(readClassDescriptor, "resultClassDescriptor");
            if (f0.g(readClassDescriptor.getName(), ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                readClassDescriptor = ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            } else if (f0.g(readClassDescriptor.getName(), APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                readClassDescriptor = ObjectStreamClass.lookup(AppEvent.SerializationProxyV2.class);
            }
            f0.o(readClassDescriptor, "resultClassDescriptor");
            return readClassDescriptor;
        }
    }

    static {
        String name = AppEventStore.class.getName();
        f0.o(name, "AppEventStore::class.java.name");
        TAG = name;
    }

    private AppEventStore() {
    }

    @k
    public static final synchronized void persistEvents(@d AccessTokenAppIdPair accessTokenAppIdPair, @d SessionEventsState sessionEventsState) {
        synchronized (AppEventStore.class) {
            if (CrashShieldHandler.isObjectCrashing(AppEventStore.class)) {
                return;
            }
            f0.p(accessTokenAppIdPair, "accessTokenAppIdPair");
            f0.p(sessionEventsState, "appEvents");
            AppEventUtility.assertIsNotMainThread();
            PersistedEvents readAndClearStore = readAndClearStore();
            readAndClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
            saveEventsToDisk$facebook_core_release(readAndClearStore);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00a0 A[Catch: all -> 0x00a7, TRY_LEAVE, TryCatch #10 {, blocks: (B:80:0x0003, B:85:0x000c, B:90:0x0030, B:91:0x0033, B:126:0x00a0, B:94:0x003e, B:105:0x005c, B:106:0x005f, B:109:0x006a, B:110:0x006e, B:112:0x0073, B:113:0x0076, B:117:0x0088, B:116:0x0081, B:119:0x008a, B:120:0x008d, B:123:0x0098), top: B:148:0x0003 }] */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.content.Context] */
    @r.e.a.d
    @n.l2.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final synchronized com.facebook.appevents.PersistedEvents readAndClearStore() {
        /*
            java.lang.Class<com.facebook.appevents.AppEventStore> r0 = com.facebook.appevents.AppEventStore.class
            monitor-enter(r0)
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)     // Catch: java.lang.Throwable -> Lad
            r2 = 0
            if (r1 == 0) goto Lc
            monitor-exit(r0)
            return r2
        Lc:
            com.facebook.appevents.internal.AppEventUtility.assertIsNotMainThread()     // Catch: java.lang.Throwable -> La7
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch: java.lang.Throwable -> La7
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r3 = r1.openFileInput(r3)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53 java.io.FileNotFoundException -> L89
            java.lang.String r4 = "context.openFileInput(PERSISTED_EVENTS_FILENAME)"
            n.l2.v.f0.o(r3, r4)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53 java.io.FileNotFoundException -> L89
            com.facebook.appevents.AppEventStore$MovedClassObjectInputStream r4 = new com.facebook.appevents.AppEventStore$MovedClassObjectInputStream     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53 java.io.FileNotFoundException -> L89
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53 java.io.FileNotFoundException -> L89
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53 java.io.FileNotFoundException -> L89
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53 java.io.FileNotFoundException -> L89
            java.lang.Object r3 = r4.readObject()     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L72 java.io.FileNotFoundException -> L8a
            if (r3 == 0) goto L46
            com.facebook.appevents.PersistedEvents r3 = (com.facebook.appevents.PersistedEvents) r3     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L72 java.io.FileNotFoundException -> L8a
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch: java.lang.Throwable -> La7
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r4)     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> La7
            r1.delete()     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> La7
            goto L9e
        L3d:
            r1 = move-exception
            java.lang.String r4 = com.facebook.appevents.AppEventStore.TAG     // Catch: java.lang.Throwable -> La7
            java.lang.String r5 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r4, r5, r1)     // Catch: java.lang.Throwable -> La7
            goto L9e
        L46:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L72 java.io.FileNotFoundException -> L8a
            java.lang.String r5 = "null cannot be cast to non-null type com.facebook.appevents.PersistedEvents"
            r3.<init>(r5)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L72 java.io.FileNotFoundException -> L8a
            throw r3     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L72 java.io.FileNotFoundException -> L8a
        L4e:
            r3 = move-exception
            goto L55
        L50:
            r3 = move-exception
            r4 = r2
            goto L73
        L53:
            r3 = move-exception
            r4 = r2
        L55:
            java.lang.String r5 = com.facebook.appevents.AppEventStore.TAG     // Catch: java.lang.Throwable -> L72
            java.lang.String r6 = "Got unexpected exception while reading events: "
            android.util.Log.w(r5, r6, r3)     // Catch: java.lang.Throwable -> L72
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch: java.lang.Throwable -> La7
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La7
            r1.delete()     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> La7
            goto L9d
        L69:
            r1 = move-exception
            java.lang.String r3 = com.facebook.appevents.AppEventStore.TAG     // Catch: java.lang.Throwable -> La7
            java.lang.String r4 = "Got unexpected exception when removing events file: "
        L6e:
            android.util.Log.w(r3, r4, r1)     // Catch: java.lang.Throwable -> La7
            goto L9d
        L72:
            r3 = move-exception
        L73:
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch: java.lang.Throwable -> La7
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r4)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> La7
            r1.delete()     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> La7
            goto L88
        L80:
            r1 = move-exception
            java.lang.String r4 = com.facebook.appevents.AppEventStore.TAG     // Catch: java.lang.Throwable -> La7
            java.lang.String r5 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r4, r5, r1)     // Catch: java.lang.Throwable -> La7
        L88:
            throw r3     // Catch: java.lang.Throwable -> La7
        L89:
            r4 = r2
        L8a:
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch: java.lang.Throwable -> La7
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch: java.lang.Exception -> L97 java.lang.Throwable -> La7
            r1.delete()     // Catch: java.lang.Exception -> L97 java.lang.Throwable -> La7
            goto L9d
        L97:
            r1 = move-exception
            java.lang.String r3 = com.facebook.appevents.AppEventStore.TAG     // Catch: java.lang.Throwable -> La7
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            goto L6e
        L9d:
            r3 = r2
        L9e:
            if (r3 != 0) goto La5
            com.facebook.appevents.PersistedEvents r3 = new com.facebook.appevents.PersistedEvents     // Catch: java.lang.Throwable -> La7
            r3.<init>()     // Catch: java.lang.Throwable -> La7
        La5:
            monitor-exit(r0)
            return r3
        La7:
            r1 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r0)     // Catch: java.lang.Throwable -> Lad
            monitor-exit(r0)
            return r2
        Lad:
            r1 = move-exception
            monitor-exit(r0)
            goto Lb1
        Lb0:
            throw r1
        Lb1:
            goto Lb0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventStore.readAndClearStore():com.facebook.appevents.PersistedEvents");
    }

    @k
    public static final void saveEventsToDisk$facebook_core_release(@e PersistedEvents persistedEvents) {
        ObjectOutputStream objectOutputStream;
        if (CrashShieldHandler.isObjectCrashing(AppEventStore.class)) {
            return;
        }
        ObjectOutputStream objectOutputStream2 = null;
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            try {
                objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(applicationContext.openFileOutput(PERSISTED_EVENTS_FILENAME, 0)));
            } catch (Throwable th) {
                th = th;
            }
            try {
                objectOutputStream.writeObject(persistedEvents);
                Utility.closeQuietly(objectOutputStream);
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream2 = objectOutputStream;
                Log.w(TAG, "Got unexpected exception while persisting events: ", th);
                try {
                    applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                } catch (Exception unused) {
                }
                Utility.closeQuietly(objectOutputStream2);
            }
        } catch (Throwable th3) {
            CrashShieldHandler.handleThrowable(th3, AppEventStore.class);
        }
    }

    @k
    public static final synchronized void persistEvents(@d AppEventCollection appEventCollection) {
        synchronized (AppEventStore.class) {
            if (CrashShieldHandler.isObjectCrashing(AppEventStore.class)) {
                return;
            }
            f0.p(appEventCollection, "eventsToPersist");
            AppEventUtility.assertIsNotMainThread();
            PersistedEvents readAndClearStore = readAndClearStore();
            for (AccessTokenAppIdPair accessTokenAppIdPair : appEventCollection.keySet()) {
                SessionEventsState sessionEventsState = appEventCollection.get(accessTokenAppIdPair);
                if (sessionEventsState != null) {
                    readAndClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            }
            saveEventsToDisk$facebook_core_release(readAndClearStore);
        }
    }
}
