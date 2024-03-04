package f1;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import java.util.HashMap;

@Deprecated
/* loaded from: classes.dex */
public abstract class f extends Service {

    /* renamed from: h */
    public static final Object f4076h = new Object();

    /* renamed from: i */
    public static final HashMap<ComponentName, d> f4077i = new HashMap<>();

    /* renamed from: f */
    public b f4078f;

    /* renamed from: g */
    public a f4079g;

    /* loaded from: classes.dex */
    public final class a extends AsyncTask<Void, Void, Void> {
        public a() {
            f.this = r1;
        }

        /* JADX WARN: Removed duplicated region for block: B:117:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:135:0x004f A[SYNTHETIC] */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Void doInBackground(java.lang.Void[] r5) {
            /*
                r4 = this;
                java.lang.Void[] r5 = (java.lang.Void[]) r5
            L2:
                f1.f r5 = f1.f.this
                f1.f$b r5 = r5.f4078f
                r5.getClass()
                java.lang.Object r0 = r5.f4082b
                monitor-enter(r0)
                android.app.job.JobParameters r1 = r5.f4083c     // Catch: java.lang.Throwable -> L50
                r2 = 0
                if (r1 != 0) goto L13
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L50
                goto L2d
            L13:
                android.app.job.JobWorkItem r1 = r1.dequeueWork()     // Catch: java.lang.Throwable -> L50
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L50
                if (r1 == 0) goto L2d
                android.content.Intent r0 = r1.getIntent()
                f1.f r3 = r5.f4081a
                java.lang.ClassLoader r3 = r3.getClassLoader()
                r0.setExtrasClassLoader(r3)
                f1.f$b$a r0 = new f1.f$b$a
                r0.<init>(r1)
                goto L2e
            L2d:
                r0 = r2
            L2e:
                if (r0 == 0) goto L4f
                f1.f r5 = f1.f.this
                android.app.job.JobWorkItem r1 = r0.f4084a
                r1.getIntent()
                r5.a()
                f1.f$b r5 = f1.f.b.this
                java.lang.Object r5 = r5.f4082b
                monitor-enter(r5)
                f1.f$b r1 = f1.f.b.this     // Catch: java.lang.Throwable -> L4c
                android.app.job.JobParameters r1 = r1.f4083c     // Catch: java.lang.Throwable -> L4c
                if (r1 == 0) goto L4a
                android.app.job.JobWorkItem r0 = r0.f4084a     // Catch: java.lang.Throwable -> L4c
                r1.completeWork(r0)     // Catch: java.lang.Throwable -> L4c
            L4a:
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L4c
                goto L2
            L4c:
                r4 = move-exception
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L4c
                throw r4
            L4f:
                return r2
            L50:
                r4 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L50
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: f1.f.a.doInBackground(java.lang.Object[]):java.lang.Object");
        }

        @Override // android.os.AsyncTask
        public final void onCancelled(Void r12) {
            f.this.getClass();
        }

        @Override // android.os.AsyncTask
        public final void onPostExecute(Void r12) {
            f.this.getClass();
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends JobServiceEngine {

        /* renamed from: a */
        public final f f4081a;

        /* renamed from: b */
        public final Object f4082b;

        /* renamed from: c */
        public JobParameters f4083c;

        /* loaded from: classes.dex */
        public final class a {

            /* renamed from: a */
            public final JobWorkItem f4084a;

            public a(JobWorkItem jobWorkItem) {
                b.this = r1;
                this.f4084a = jobWorkItem;
            }
        }

        public b(f fVar) {
            super(fVar);
            this.f4082b = new Object();
            this.f4081a = fVar;
        }

        @Override // android.app.job.JobServiceEngine
        public final boolean onStartJob(JobParameters jobParameters) {
            this.f4083c = jobParameters;
            f fVar = this.f4081a;
            if (fVar.f4079g == null) {
                a aVar = new a();
                fVar.f4079g = aVar;
                aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return true;
            }
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public final boolean onStopJob(JobParameters jobParameters) {
            a aVar = this.f4081a.f4079g;
            if (aVar != null) {
                aVar.cancel(false);
            }
            synchronized (this.f4082b) {
                this.f4083c = null;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends d {

        /* renamed from: c */
        public final JobInfo f4086c;

        /* renamed from: d */
        public final JobScheduler f4087d;

        public c(Context context, ComponentName componentName) {
            super(componentName);
            b();
            this.f4086c = new JobInfo.Builder(67, componentName).setOverrideDeadline(0L).build();
            this.f4087d = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // f1.f.d
        public final void a(Intent intent) {
            this.f4087d.enqueue(this.f4086c, new JobWorkItem(intent));
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d {

        /* renamed from: a */
        public boolean f4088a;

        /* renamed from: b */
        public int f4089b;

        public d(ComponentName componentName) {
        }

        public abstract void a(Intent intent);

        public final void b() {
            if (!this.f4088a) {
                this.f4088a = true;
                this.f4089b = 67;
            } else if (this.f4089b == 67) {
            } else {
                throw new IllegalArgumentException("Given job ID 67 is different than previous " + this.f4089b);
            }
        }
    }

    public abstract void a();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        b bVar = this.f4078f;
        if (bVar != null) {
            return bVar.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.f4078f = new b(this);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i7, int i8) {
        return 2;
    }
}
