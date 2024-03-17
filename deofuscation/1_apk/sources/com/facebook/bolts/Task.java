package com.facebook.bolts;

import com.facebook.appevents.UserDataStore;
import com.facebook.bolts.BoltsExecutors;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Ref;
import n.b0;
import n.l2.d;
import n.l2.k;
import n.l2.v.f0;
import n.l2.v.s0;
import n.l2.v.u;
import n.u1;
import r.e.a.e;

/* compiled from: Task.kt */
@b0(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 @*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003@ABB\u0007\b\u0010¢\u0006\u0002\u0010\u0003B\u0011\b\u0012\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0005B\u000f\b\u0012\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010%\u001a\b\u0012\u0004\u0012\u0002H&0\u0000\"\u0004\b\u0001\u0010&J4\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070)2\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00000\u0010J>\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070)2\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00000\u00102\b\u0010+\u001a\u0004\u0018\u00010,JJ\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070)2\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00000\u00102\b\b\u0002\u0010-\u001a\u00020.2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,J&\u0010/\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H00\u0010J0\u0010/\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H00\u00102\b\u0010+\u001a\u0004\u0018\u00010,J.\u0010/\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H00\u00102\u0006\u0010-\u001a\u00020.J8\u0010/\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H00\u00102\u0006\u0010-\u001a\u00020.2\b\u0010+\u001a\u0004\u0018\u00010,J,\u00101\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H00\u00000\u0010J6\u00101\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H00\u00000\u00102\b\u0010+\u001a\u0004\u0018\u00010,J4\u00101\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H00\u00000\u00102\u0006\u0010-\u001a\u00020.J>\u00101\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H00\u00000\u00102\u0006\u0010-\u001a\u00020.2\b\u0010+\u001a\u0004\u0018\u00010,J\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00110\u0000J&\u00103\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H00\u0010J0\u00103\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H00\u00102\b\u0010+\u001a\u0004\u0018\u00010,J.\u00103\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H00\u00102\u0006\u0010-\u001a\u00020.J8\u00103\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H00\u00102\u0006\u0010-\u001a\u00020.2\b\u0010+\u001a\u0004\u0018\u00010,J,\u00104\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H00\u00000\u0010J6\u00104\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H00\u00000\u00102\b\u0010+\u001a\u0004\u0018\u00010,J4\u00104\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H00\u00000\u00102\u0006\u0010-\u001a\u00020.J>\u00104\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H00\u00000\u00102\u0006\u0010-\u001a\u00020.2\b\u0010+\u001a\u0004\u0018\u00010,J\b\u00105\u001a\u000206H\u0002J\u0006\u00107\u001a\u00020\u0007J\u0016\u00108\u001a\u00020\u00072\u000e\u0010\u0012\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014J\u0015\u00109\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010:J\u0006\u0010;\u001a\u000206J\u0016\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u001c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/facebook/bolts/Task;", "TResult", "", "()V", "result", "(Ljava/lang/Object;)V", AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, "", "(Z)V", "cancelledField", "completeField", "condition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "continuations", "", "Lcom/facebook/bolts/Continuation;", "Ljava/lang/Void;", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getError", "()Ljava/lang/Exception;", "errorField", "errorHasBeenObserved", "isCancelled", "()Z", "isCompleted", "isFaulted", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getResult", "()Ljava/lang/Object;", "resultField", "Ljava/lang/Object;", "unobservedErrorNotifier", "Lcom/facebook/bolts/UnobservedErrorNotifier;", "cast", "TOut", "continueWhile", "predicate", "Ljava/util/concurrent/Callable;", "continuation", UserDataStore.CITY, "Lcom/facebook/bolts/CancellationToken;", "executor", "Ljava/util/concurrent/Executor;", "continueWith", "TContinuationResult", "continueWithTask", "makeVoid", "onSuccess", "onSuccessTask", "runContinuations", "", "trySetCancelled", "trySetError", "trySetResult", "(Ljava/lang/Object;)Z", "waitForCompletion", "duration", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "Companion", "TaskCompletionSource", "UnobservedExceptionHandler", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class Task<TResult> {
    @d
    @r.e.a.d
    public static final ExecutorService BACKGROUND_EXECUTOR;
    @r.e.a.d
    public static final Companion Companion = new Companion(null);
    private static final Executor IMMEDIATE_EXECUTOR;
    private static final Task<?> TASK_CANCELLED;
    private static final Task<Boolean> TASK_FALSE;
    private static final Task<?> TASK_NULL;
    private static final Task<Boolean> TASK_TRUE;
    @d
    @r.e.a.d
    public static final Executor UI_THREAD_EXECUTOR;
    private static volatile UnobservedExceptionHandler unobservedExceptionHandler;
    private boolean cancelledField;
    private boolean completeField;
    private final Condition condition;
    private List<Continuation<TResult, Void>> continuations;
    private Exception errorField;
    private boolean errorHasBeenObserved;
    private final ReentrantLock lock;
    private TResult resultField;
    private UnobservedErrorNotifier unobservedErrorNotifier;

    /* compiled from: Task.kt */
    @b0(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00110\b\"\u0004\b\u0001\u0010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u0013H\u0007J.\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00110\b\"\u0004\b\u0001\u0010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J,\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00110\b\"\u0004\b\u0001\u0010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u00132\u0006\u0010\u0016\u001a\u00020\u0006H\u0007J6\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00110\b\"\u0004\b\u0001\u0010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u00132\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00110\b\"\u0004\b\u0001\u0010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u0013H\u0007J.\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00110\b\"\u0004\b\u0001\u0010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00110\b\"\u0004\b\u0001\u0010\u0011H\u0007J\\\u0010\u0019\u001a\u00020\u001a\"\u0004\b\u0001\u0010\u001b\"\u0004\b\u0002\u0010\u00112\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001d2\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\b0\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00110\b2\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002JV\u0010!\u001a\u00020\u001a\"\u0004\b\u0001\u0010\u001b\"\u0004\b\u0002\u0010\u00112\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u001b0\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00110\b2\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0018\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\b2\u0006\u0010\"\u001a\u00020$H\u0007J\"\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\b2\u0006\u0010\"\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0015H\u0007J/\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\b2\u0006\u0010\"\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0002\b'J$\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u00110\b\"\u0004\b\u0001\u0010\u00112\u000e\u0010)\u001a\n\u0018\u00010*j\u0004\u0018\u0001`+H\u0007J#\u0010,\u001a\b\u0012\u0004\u0012\u0002H\u00110\b\"\u0004\b\u0001\u0010\u00112\b\u0010-\u001a\u0004\u0018\u0001H\u0011H\u0007¢\u0006\u0002\u0010.J\n\u0010/\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u00100\u001a\u00020\u001a2\b\u00101\u001a\u0004\u0018\u00010\u000fH\u0007J \u00102\u001a\b\u0012\u0004\u0012\u00020#0\b2\u0010\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b04H\u0007J0\u00105\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0011060\b\"\u0004\b\u0001\u0010\u00112\u0012\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\b04H\u0007J$\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\b2\u0010\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b04H\u0007J.\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\b0\b\"\u0004\b\u0001\u0010\u00112\u0012\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\b04H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/facebook/bolts/Task$Companion;", "", "()V", "BACKGROUND_EXECUTOR", "Ljava/util/concurrent/ExecutorService;", "IMMEDIATE_EXECUTOR", "Ljava/util/concurrent/Executor;", "TASK_CANCELLED", "Lcom/facebook/bolts/Task;", "TASK_FALSE", "", "TASK_NULL", "TASK_TRUE", "UI_THREAD_EXECUTOR", "unobservedExceptionHandler", "Lcom/facebook/bolts/Task$UnobservedExceptionHandler;", "call", "TResult", "callable", "Ljava/util/concurrent/Callable;", UserDataStore.CITY, "Lcom/facebook/bolts/CancellationToken;", "executor", "callInBackground", AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, "completeAfterTask", "", "TContinuationResult", "tcs", "Lcom/facebook/bolts/TaskCompletionSource;", "continuation", "Lcom/facebook/bolts/Continuation;", "task", "completeImmediately", "delay", "Ljava/lang/Void;", "", "cancellationToken", "Ljava/util/concurrent/ScheduledExecutorService;", "delay$facebook_core_release", "forError", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "forResult", SDKConstants.PARAM_VALUE, "(Ljava/lang/Object;)Lcom/facebook/bolts/Task;", "getUnobservedExceptionHandler", "setUnobservedExceptionHandler", "eh", "whenAll", "tasks", "", "whenAllResult", "", "whenAny", "whenAnyResult", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final <TContinuationResult, TResult> void completeAfterTask(final TaskCompletionSource<TContinuationResult> taskCompletionSource, final Continuation<TResult, Task<TContinuationResult>> continuation, final Task<TResult> task, Executor executor, final CancellationToken cancellationToken) {
            try {
                executor.execute(new Runnable() { // from class: com.facebook.bolts.Task$Companion$completeAfterTask$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (CrashShieldHandler.isObjectCrashing(this)) {
                            return;
                        }
                        try {
                            CancellationToken cancellationToken2 = cancellationToken;
                            if (cancellationToken2 != null && cancellationToken2.isCancellationRequested()) {
                                taskCompletionSource.setCancelled();
                                return;
                            }
                            try {
                                Task task2 = (Task) continuation.then(task);
                                if (task2 == null || task2.continueWith(new Continuation() { // from class: com.facebook.bolts.Task$Companion$completeAfterTask$1.1
                                    {
                                        Task$Companion$completeAfterTask$1.this = this;
                                    }

                                    @Override // com.facebook.bolts.Continuation
                                    @e
                                    public final Void then(@r.e.a.d Task<TContinuationResult> task3) {
                                        f0.p(task3, "task");
                                        CancellationToken cancellationToken3 = cancellationToken;
                                        if (cancellationToken3 != null && cancellationToken3.isCancellationRequested()) {
                                            taskCompletionSource.setCancelled();
                                            return null;
                                        }
                                        if (task3.isCancelled()) {
                                            taskCompletionSource.setCancelled();
                                        } else if (task3.isFaulted()) {
                                            taskCompletionSource.setError(task3.getError());
                                        } else {
                                            taskCompletionSource.setResult(task3.getResult());
                                        }
                                        return null;
                                    }
                                }) == null) {
                                    taskCompletionSource.setResult((Object) null);
                                    u1 u1Var = u1.a;
                                }
                            } catch (CancellationException unused) {
                                taskCompletionSource.setCancelled();
                            } catch (Exception e) {
                                taskCompletionSource.setError(e);
                            }
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, this);
                        }
                    }
                });
            } catch (Exception e) {
                taskCompletionSource.setError(new ExecutorException(e));
            }
        }

        public final <TContinuationResult, TResult> void completeImmediately(final TaskCompletionSource<TContinuationResult> taskCompletionSource, final Continuation<TResult, TContinuationResult> continuation, final Task<TResult> task, Executor executor, final CancellationToken cancellationToken) {
            try {
                executor.execute(new Runnable() { // from class: com.facebook.bolts.Task$Companion$completeImmediately$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (CrashShieldHandler.isObjectCrashing(this)) {
                            return;
                        }
                        try {
                            CancellationToken cancellationToken2 = cancellationToken;
                            if (cancellationToken2 != null && cancellationToken2.isCancellationRequested()) {
                                taskCompletionSource.setCancelled();
                                return;
                            }
                            try {
                                try {
                                    taskCompletionSource.setResult(continuation.then(task));
                                } catch (Exception e) {
                                    taskCompletionSource.setError(e);
                                }
                            } catch (CancellationException unused) {
                                taskCompletionSource.setCancelled();
                            }
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, this);
                        }
                    }
                });
            } catch (Exception e) {
                taskCompletionSource.setError(new ExecutorException(e));
            }
        }

        @r.e.a.d
        @k
        public final <TResult> Task<TResult> call(@r.e.a.d Callable<TResult> callable, @r.e.a.d Executor executor) {
            f0.p(callable, "callable");
            f0.p(executor, "executor");
            return call(callable, executor, null);
        }

        @r.e.a.d
        @k
        public final <TResult> Task<TResult> callInBackground(@r.e.a.d Callable<TResult> callable) {
            f0.p(callable, "callable");
            return call(callable, Task.BACKGROUND_EXECUTOR, null);
        }

        @r.e.a.d
        @k
        public final <TResult> Task<TResult> cancelled() {
            Task<TResult> task = Task.TASK_CANCELLED;
            Objects.requireNonNull(task, "null cannot be cast to non-null type com.facebook.bolts.Task<TResult>");
            return task;
        }

        @r.e.a.d
        @k
        public final Task<Void> delay(long j) {
            return delay$facebook_core_release(j, BoltsExecutors.Companion.scheduled$facebook_core_release(), null);
        }

        @r.e.a.d
        @k
        public final Task<Void> delay$facebook_core_release(long j, @r.e.a.d ScheduledExecutorService scheduledExecutorService, @e CancellationToken cancellationToken) {
            f0.p(scheduledExecutorService, "executor");
            if (cancellationToken == null || !cancellationToken.isCancellationRequested()) {
                if (j <= 0) {
                    return forResult(null);
                }
                final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new Runnable() { // from class: com.facebook.bolts.Task$Companion$delay$scheduled$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (CrashShieldHandler.isObjectCrashing(this)) {
                            return;
                        }
                        try {
                            taskCompletionSource.trySetResult((Object) null);
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, this);
                        }
                    }
                }, j, TimeUnit.MILLISECONDS);
                if (cancellationToken != null) {
                    cancellationToken.register(new Runnable() { // from class: com.facebook.bolts.Task$Companion$delay$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (CrashShieldHandler.isObjectCrashing(this)) {
                                return;
                            }
                            try {
                                schedule.cancel(true);
                                taskCompletionSource.trySetCancelled();
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(th, this);
                            }
                        }
                    });
                }
                return taskCompletionSource.getTask();
            }
            return cancelled();
        }

        @r.e.a.d
        @k
        public final <TResult> Task<TResult> forError(@e Exception exc) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setError(exc);
            return taskCompletionSource.getTask();
        }

        @r.e.a.d
        @k
        public final <TResult> Task<TResult> forResult(@e TResult tresult) {
            if (tresult == null) {
                Task<TResult> task = Task.TASK_NULL;
                Objects.requireNonNull(task, "null cannot be cast to non-null type com.facebook.bolts.Task<TResult>");
                return task;
            } else if (tresult instanceof Boolean) {
                Task<TResult> task2 = ((Boolean) tresult).booleanValue() ? Task.TASK_TRUE : Task.TASK_FALSE;
                Objects.requireNonNull(task2, "null cannot be cast to non-null type com.facebook.bolts.Task<TResult>");
                return task2;
            } else {
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.setResult(tresult);
                return taskCompletionSource.getTask();
            }
        }

        @k
        @e
        public final UnobservedExceptionHandler getUnobservedExceptionHandler() {
            return Task.unobservedExceptionHandler;
        }

        @k
        public final void setUnobservedExceptionHandler(@e UnobservedExceptionHandler unobservedExceptionHandler) {
            Task.unobservedExceptionHandler = unobservedExceptionHandler;
        }

        @r.e.a.d
        @k
        public final Task<Void> whenAll(@r.e.a.d Collection<? extends Task<?>> collection) {
            f0.p(collection, "tasks");
            if (collection.isEmpty()) {
                return forResult(null);
            }
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            final ArrayList arrayList = new ArrayList();
            final ReentrantLock reentrantLock = new ReentrantLock();
            final AtomicInteger atomicInteger = new AtomicInteger(collection.size());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            for (Task<?> task : collection) {
                Objects.requireNonNull(task, "null cannot be cast to non-null type com.facebook.bolts.Task<kotlin.Any>");
                task.continueWith(new Continuation() { // from class: com.facebook.bolts.Task$Companion$whenAll$1
                    @Override // com.facebook.bolts.Continuation
                    public /* bridge */ /* synthetic */ Object then(Task task2) {
                        return then((Task<Object>) task2);
                    }

                    @Override // com.facebook.bolts.Continuation
                    @e
                    public final Void then(@r.e.a.d Task<Object> task2) {
                        f0.p(task2, "it");
                        if (task2.isFaulted()) {
                            ReentrantLock reentrantLock2 = reentrantLock;
                            reentrantLock2.lock();
                            try {
                                arrayList.add(task2.getError());
                            } finally {
                                reentrantLock2.unlock();
                            }
                        }
                        if (task2.isCancelled()) {
                            atomicBoolean.set(true);
                        }
                        if (atomicInteger.decrementAndGet() == 0) {
                            if (arrayList.size() != 0) {
                                if (arrayList.size() == 1) {
                                    taskCompletionSource.setError((Exception) arrayList.get(0));
                                } else {
                                    s0 s0Var = s0.a;
                                    String format = String.format("There were %d exceptions.", Arrays.copyOf(new Object[]{Integer.valueOf(arrayList.size())}, 1));
                                    f0.o(format, "java.lang.String.format(format, *args)");
                                    taskCompletionSource.setError(new AggregateException(format, arrayList));
                                }
                            } else if (atomicBoolean.get()) {
                                taskCompletionSource.setCancelled();
                            } else {
                                taskCompletionSource.setResult((Object) null);
                            }
                        }
                        return null;
                    }
                });
            }
            return taskCompletionSource.getTask();
        }

        @r.e.a.d
        @k
        public final <TResult> Task<List<TResult>> whenAllResult(@r.e.a.d final Collection<Task<TResult>> collection) {
            f0.p(collection, "tasks");
            return (Task<List<TResult>>) whenAll(collection).onSuccess((Continuation<Void, List<? extends TResult>>) new Continuation<Void, List<? extends TResult>>() { // from class: com.facebook.bolts.Task$Companion$whenAllResult$1
                @Override // com.facebook.bolts.Continuation
                @r.e.a.d
                public List<TResult> then(@r.e.a.d Task<Void> task) {
                    f0.p(task, "task");
                    if (collection.isEmpty()) {
                        return CollectionsKt__CollectionsKt.E();
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Task task2 : collection) {
                        arrayList.add(task2.getResult());
                    }
                    return arrayList;
                }
            });
        }

        @r.e.a.d
        @k
        public final Task<Task<?>> whenAny(@r.e.a.d Collection<? extends Task<?>> collection) {
            f0.p(collection, "tasks");
            if (collection.isEmpty()) {
                return forResult(null);
            }
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            for (Task<?> task : collection) {
                Objects.requireNonNull(task, "null cannot be cast to non-null type com.facebook.bolts.Task<kotlin.Any>");
                task.continueWith(new Continuation() { // from class: com.facebook.bolts.Task$Companion$whenAny$1
                    @Override // com.facebook.bolts.Continuation
                    public /* bridge */ /* synthetic */ Object then(Task task2) {
                        return then((Task<Object>) task2);
                    }

                    @Override // com.facebook.bolts.Continuation
                    @e
                    public final Void then(@r.e.a.d Task<Object> task2) {
                        f0.p(task2, "it");
                        if (atomicBoolean.compareAndSet(false, true)) {
                            taskCompletionSource.setResult(task2);
                            return null;
                        }
                        task2.getError();
                        return null;
                    }
                });
            }
            return taskCompletionSource.getTask();
        }

        @r.e.a.d
        @k
        public final <TResult> Task<Task<TResult>> whenAnyResult(@r.e.a.d Collection<Task<TResult>> collection) {
            f0.p(collection, "tasks");
            if (collection.isEmpty()) {
                return forResult(null);
            }
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            for (Task<TResult> task : collection) {
                task.continueWith(new Continuation() { // from class: com.facebook.bolts.Task$Companion$whenAnyResult$1
                    @Override // com.facebook.bolts.Continuation
                    @e
                    public final Void then(@r.e.a.d Task<TResult> task2) {
                        f0.p(task2, "it");
                        if (atomicBoolean.compareAndSet(false, true)) {
                            taskCompletionSource.setResult(task2);
                            return null;
                        }
                        task2.getError();
                        return null;
                    }
                });
            }
            return taskCompletionSource.getTask();
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }

        @r.e.a.d
        @k
        public final <TResult> Task<TResult> call(@r.e.a.d final Callable<TResult> callable, @r.e.a.d Executor executor, @e final CancellationToken cancellationToken) {
            f0.p(callable, "callable");
            f0.p(executor, "executor");
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            try {
                executor.execute(new Runnable() { // from class: com.facebook.bolts.Task$Companion$call$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (CrashShieldHandler.isObjectCrashing(this)) {
                            return;
                        }
                        try {
                            CancellationToken cancellationToken2 = cancellationToken;
                            if (cancellationToken2 != null && cancellationToken2.isCancellationRequested()) {
                                taskCompletionSource.setCancelled();
                                return;
                            }
                            try {
                                try {
                                    taskCompletionSource.setResult(callable.call());
                                } catch (Exception e) {
                                    taskCompletionSource.setError(e);
                                }
                            } catch (CancellationException unused) {
                                taskCompletionSource.setCancelled();
                            }
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, this);
                        }
                    }
                });
            } catch (Exception e) {
                taskCompletionSource.setError(new ExecutorException(e));
            }
            return taskCompletionSource.getTask();
        }

        @r.e.a.d
        @k
        public final <TResult> Task<TResult> callInBackground(@r.e.a.d Callable<TResult> callable, @e CancellationToken cancellationToken) {
            f0.p(callable, "callable");
            return call(callable, Task.BACKGROUND_EXECUTOR, cancellationToken);
        }

        @r.e.a.d
        @k
        public final Task<Void> delay(long j, @e CancellationToken cancellationToken) {
            return delay$facebook_core_release(j, BoltsExecutors.Companion.scheduled$facebook_core_release(), cancellationToken);
        }

        @r.e.a.d
        @k
        public final <TResult> Task<TResult> call(@r.e.a.d Callable<TResult> callable) {
            f0.p(callable, "callable");
            return call(callable, Task.IMMEDIATE_EXECUTOR, null);
        }

        @r.e.a.d
        @k
        public final <TResult> Task<TResult> call(@r.e.a.d Callable<TResult> callable, @e CancellationToken cancellationToken) {
            f0.p(callable, "callable");
            return call(callable, Task.IMMEDIATE_EXECUTOR, cancellationToken);
        }
    }

    /* compiled from: Task.kt */
    @b0(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/facebook/bolts/Task$UnobservedExceptionHandler;", "", "unobservedException", "", "t", "Lcom/facebook/bolts/Task;", com.huawei.hms.push.e.a, "Lcom/facebook/bolts/UnobservedTaskException;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface UnobservedExceptionHandler {
        void unobservedException(@r.e.a.d Task<?> task, @r.e.a.d UnobservedTaskException unobservedTaskException);
    }

    static {
        BoltsExecutors.Companion companion = BoltsExecutors.Companion;
        BACKGROUND_EXECUTOR = companion.background();
        IMMEDIATE_EXECUTOR = companion.immediate$facebook_core_release();
        Executor uiThread = AndroidExecutors.uiThread();
        f0.o(uiThread, "AndroidExecutors.uiThread()");
        UI_THREAD_EXECUTOR = uiThread;
        TASK_NULL = new Task<>((Object) null);
        TASK_TRUE = new Task<>(Boolean.TRUE);
        TASK_FALSE = new Task<>(Boolean.FALSE);
        TASK_CANCELLED = new Task<>(true);
    }

    public Task() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        this.continuations = new ArrayList();
    }

    @r.e.a.d
    @k
    public static final <TResult> Task<TResult> call(@r.e.a.d Callable<TResult> callable) {
        return Companion.call(callable);
    }

    @r.e.a.d
    @k
    public static final <TResult> Task<TResult> call(@r.e.a.d Callable<TResult> callable, @e CancellationToken cancellationToken) {
        return Companion.call(callable, cancellationToken);
    }

    @r.e.a.d
    @k
    public static final <TResult> Task<TResult> call(@r.e.a.d Callable<TResult> callable, @r.e.a.d Executor executor) {
        return Companion.call(callable, executor);
    }

    @r.e.a.d
    @k
    public static final <TResult> Task<TResult> call(@r.e.a.d Callable<TResult> callable, @r.e.a.d Executor executor, @e CancellationToken cancellationToken) {
        return Companion.call(callable, executor, cancellationToken);
    }

    @r.e.a.d
    @k
    public static final <TResult> Task<TResult> callInBackground(@r.e.a.d Callable<TResult> callable) {
        return Companion.callInBackground(callable);
    }

    @r.e.a.d
    @k
    public static final <TResult> Task<TResult> callInBackground(@r.e.a.d Callable<TResult> callable, @e CancellationToken cancellationToken) {
        return Companion.callInBackground(callable, cancellationToken);
    }

    @r.e.a.d
    @k
    public static final <TResult> Task<TResult> cancelled() {
        return Companion.cancelled();
    }

    public static /* synthetic */ Task continueWhile$default(Task task, Callable callable, Continuation continuation, Executor executor, CancellationToken cancellationToken, int i, Object obj) {
        if ((i & 4) != 0) {
            executor = IMMEDIATE_EXECUTOR;
        }
        if ((i & 8) != 0) {
            cancellationToken = null;
        }
        return task.continueWhile(callable, continuation, executor, cancellationToken);
    }

    @r.e.a.d
    @k
    public static final Task<Void> delay(long j) {
        return Companion.delay(j);
    }

    @r.e.a.d
    @k
    public static final Task<Void> delay(long j, @e CancellationToken cancellationToken) {
        return Companion.delay(j, cancellationToken);
    }

    @r.e.a.d
    @k
    public static final <TResult> Task<TResult> forError(@e Exception exc) {
        return Companion.forError(exc);
    }

    @r.e.a.d
    @k
    public static final <TResult> Task<TResult> forResult(@e TResult tresult) {
        return Companion.forResult(tresult);
    }

    @k
    @e
    public static final UnobservedExceptionHandler getUnobservedExceptionHandler() {
        return Companion.getUnobservedExceptionHandler();
    }

    private final void runContinuations() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            List<Continuation<TResult, Void>> list = this.continuations;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        ((Continuation) it.next()).then(this);
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Throwable th) {
                        throw new RuntimeException(th);
                    }
                }
            }
            this.continuations = null;
            u1 u1Var = u1.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @k
    public static final void setUnobservedExceptionHandler(@e UnobservedExceptionHandler unobservedExceptionHandler2) {
        Companion.setUnobservedExceptionHandler(unobservedExceptionHandler2);
    }

    @r.e.a.d
    @k
    public static final Task<Void> whenAll(@r.e.a.d Collection<? extends Task<?>> collection) {
        return Companion.whenAll(collection);
    }

    @r.e.a.d
    @k
    public static final <TResult> Task<List<TResult>> whenAllResult(@r.e.a.d Collection<Task<TResult>> collection) {
        return Companion.whenAllResult(collection);
    }

    @r.e.a.d
    @k
    public static final Task<Task<?>> whenAny(@r.e.a.d Collection<? extends Task<?>> collection) {
        return Companion.whenAny(collection);
    }

    @r.e.a.d
    @k
    public static final <TResult> Task<Task<TResult>> whenAnyResult(@r.e.a.d Collection<Task<TResult>> collection) {
        return Companion.whenAnyResult(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @r.e.a.d
    public final <TOut> Task<TOut> cast() {
        return this;
    }

    @r.e.a.d
    public final Task<Void> continueWhile(@r.e.a.d Callable<Boolean> callable, @r.e.a.d Continuation<Void, Task<Void>> continuation) {
        f0.p(callable, "predicate");
        f0.p(continuation, "continuation");
        return continueWhile(callable, continuation, IMMEDIATE_EXECUTOR, null);
    }

    @r.e.a.d
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@r.e.a.d Continuation<TResult, TContinuationResult> continuation, @r.e.a.d Executor executor) {
        f0.p(continuation, "continuation");
        f0.p(executor, "executor");
        return continueWith(continuation, executor, null);
    }

    @r.e.a.d
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@r.e.a.d Continuation<TResult, Task<TContinuationResult>> continuation, @r.e.a.d Executor executor) {
        f0.p(continuation, "continuation");
        f0.p(executor, "executor");
        return continueWithTask(continuation, executor, null);
    }

    @e
    public final Exception getError() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.errorField != null) {
                this.errorHasBeenObserved = true;
                UnobservedErrorNotifier unobservedErrorNotifier = this.unobservedErrorNotifier;
                if (unobservedErrorNotifier != null) {
                    unobservedErrorNotifier.setObserved();
                    this.unobservedErrorNotifier = null;
                }
            }
            return this.errorField;
        } finally {
            reentrantLock.unlock();
        }
    }

    @e
    public final TResult getResult() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.resultField;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean isCancelled() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.cancelledField;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean isCompleted() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.completeField;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean isFaulted() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.errorField != null;
        } finally {
            reentrantLock.unlock();
        }
    }

    @r.e.a.d
    public final Task<Void> makeVoid() {
        return continueWithTask(new Continuation() { // from class: com.facebook.bolts.Task$makeVoid$1
            @Override // com.facebook.bolts.Continuation
            @e
            public final Task<Void> then(@r.e.a.d Task<TResult> task) {
                f0.p(task, "task");
                if (task.isCancelled()) {
                    return Task.Companion.cancelled();
                }
                if (task.isFaulted()) {
                    return Task.Companion.forError(task.getError());
                }
                return Task.Companion.forResult(null);
            }
        });
    }

    @r.e.a.d
    public final <TContinuationResult> Task<TContinuationResult> onSuccess(@r.e.a.d Continuation<TResult, TContinuationResult> continuation, @r.e.a.d Executor executor) {
        f0.p(continuation, "continuation");
        f0.p(executor, "executor");
        return onSuccess(continuation, executor, null);
    }

    @r.e.a.d
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(@r.e.a.d Continuation<TResult, Task<TContinuationResult>> continuation, @r.e.a.d Executor executor) {
        f0.p(continuation, "continuation");
        f0.p(executor, "executor");
        return onSuccessTask(continuation, executor, null);
    }

    public final boolean trySetCancelled() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.completeField) {
                return false;
            }
            this.completeField = true;
            this.cancelledField = true;
            this.condition.signalAll();
            runContinuations();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean trySetError(@e Exception exc) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.completeField) {
                return false;
            }
            this.completeField = true;
            this.errorField = exc;
            this.errorHasBeenObserved = false;
            this.condition.signalAll();
            runContinuations();
            if (!this.errorHasBeenObserved && unobservedExceptionHandler != null) {
                this.unobservedErrorNotifier = new UnobservedErrorNotifier(this);
            }
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean trySetResult(@e TResult tresult) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.completeField) {
                return false;
            }
            this.completeField = true;
            this.resultField = tresult;
            this.condition.signalAll();
            runContinuations();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void waitForCompletion() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!isCompleted()) {
                this.condition.await();
            }
            u1 u1Var = u1.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @r.e.a.d
    public final Task<Void> continueWhile(@r.e.a.d Callable<Boolean> callable, @r.e.a.d Continuation<Void, Task<Void>> continuation, @e CancellationToken cancellationToken) {
        f0.p(callable, "predicate");
        f0.p(continuation, "continuation");
        return continueWhile(callable, continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    @r.e.a.d
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@r.e.a.d final Continuation<TResult, TContinuationResult> continuation, @r.e.a.d final Executor executor, @e final CancellationToken cancellationToken) {
        List<Continuation<TResult, Void>> list;
        f0.p(continuation, "continuation");
        f0.p(executor, "executor");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean isCompleted = isCompleted();
            booleanRef.element = isCompleted;
            if (!isCompleted && (list = this.continuations) != null) {
                list.add(new Continuation() { // from class: com.facebook.bolts.Task$continueWith$$inlined$withLock$lambda$1
                    {
                        Task.this = this;
                    }

                    @Override // com.facebook.bolts.Continuation
                    @e
                    public final Void then(@r.e.a.d Task<TResult> task) {
                        f0.p(task, "task");
                        Task.Companion.completeImmediately(taskCompletionSource, continuation, task, executor, cancellationToken);
                        return null;
                    }
                });
            }
            u1 u1Var = u1.a;
            reentrantLock.unlock();
            if (booleanRef.element) {
                Companion.completeImmediately(taskCompletionSource, continuation, this, executor, cancellationToken);
            }
            return taskCompletionSource.getTask();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @r.e.a.d
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@r.e.a.d final Continuation<TResult, Task<TContinuationResult>> continuation, @r.e.a.d final Executor executor, @e final CancellationToken cancellationToken) {
        List<Continuation<TResult, Void>> list;
        f0.p(continuation, "continuation");
        f0.p(executor, "executor");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean isCompleted = isCompleted();
            booleanRef.element = isCompleted;
            if (!isCompleted && (list = this.continuations) != null) {
                list.add(new Continuation() { // from class: com.facebook.bolts.Task$continueWithTask$$inlined$withLock$lambda$1
                    {
                        Task.this = this;
                    }

                    @Override // com.facebook.bolts.Continuation
                    @e
                    public final Void then(@r.e.a.d Task<TResult> task) {
                        f0.p(task, "task");
                        Task.Companion.completeAfterTask(taskCompletionSource, continuation, task, executor, cancellationToken);
                        return null;
                    }
                });
            }
            u1 u1Var = u1.a;
            reentrantLock.unlock();
            if (booleanRef.element) {
                Companion.completeAfterTask(taskCompletionSource, continuation, this, executor, cancellationToken);
            }
            return taskCompletionSource.getTask();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @r.e.a.d
    public final <TContinuationResult> Task<TContinuationResult> onSuccess(@r.e.a.d final Continuation<TResult, TContinuationResult> continuation, @r.e.a.d Executor executor, @e final CancellationToken cancellationToken) {
        f0.p(continuation, "continuation");
        f0.p(executor, "executor");
        return continueWithTask(new Continuation() { // from class: com.facebook.bolts.Task$onSuccess$1
            @Override // com.facebook.bolts.Continuation
            @e
            public final Task<TContinuationResult> then(@r.e.a.d Task<TResult> task) {
                f0.p(task, "task");
                CancellationToken cancellationToken2 = cancellationToken;
                if (cancellationToken2 != null && cancellationToken2.isCancellationRequested()) {
                    return Task.Companion.cancelled();
                }
                if (task.isFaulted()) {
                    return Task.Companion.forError(task.getError());
                }
                if (task.isCancelled()) {
                    return Task.Companion.cancelled();
                }
                return task.continueWith(continuation);
            }
        }, executor);
    }

    @r.e.a.d
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(@r.e.a.d final Continuation<TResult, Task<TContinuationResult>> continuation, @r.e.a.d Executor executor, @e final CancellationToken cancellationToken) {
        f0.p(continuation, "continuation");
        f0.p(executor, "executor");
        return continueWithTask(new Continuation() { // from class: com.facebook.bolts.Task$onSuccessTask$1
            @Override // com.facebook.bolts.Continuation
            @e
            public final Task<TContinuationResult> then(@r.e.a.d Task<TResult> task) {
                f0.p(task, "task");
                CancellationToken cancellationToken2 = cancellationToken;
                if (cancellationToken2 != null && cancellationToken2.isCancellationRequested()) {
                    return Task.Companion.cancelled();
                }
                if (task.isFaulted()) {
                    return Task.Companion.forError(task.getError());
                }
                if (task.isCancelled()) {
                    return Task.Companion.cancelled();
                }
                return task.continueWithTask(continuation);
            }
        }, executor);
    }

    @r.e.a.d
    public final Task<Void> continueWhile(@r.e.a.d final Callable<Boolean> callable, @r.e.a.d final Continuation<Void, Task<Void>> continuation, @r.e.a.d final Executor executor, @e final CancellationToken cancellationToken) {
        f0.p(callable, "predicate");
        f0.p(continuation, "continuation");
        f0.p(executor, "executor");
        return makeVoid().continueWithTask(new Continuation<Void, Task<Void>>() { // from class: com.facebook.bolts.Task$continueWhile$predicateContinuation$1
            @Override // com.facebook.bolts.Continuation
            @r.e.a.d
            public Task<Void> then(@r.e.a.d Task<Void> task) throws Exception {
                f0.p(task, "task");
                CancellationToken cancellationToken2 = cancellationToken;
                if (cancellationToken2 != null && cancellationToken2.isCancellationRequested()) {
                    return Task.Companion.cancelled();
                }
                Object call = callable.call();
                f0.o(call, "predicate.call()");
                if (((Boolean) call).booleanValue()) {
                    return Task.Companion.forResult(null).onSuccessTask(continuation, executor).onSuccessTask(this, executor);
                }
                return Task.Companion.forResult(null);
            }
        }, executor);
    }

    @r.e.a.d
    public final <TContinuationResult> Task<TContinuationResult> onSuccess(@r.e.a.d Continuation<TResult, TContinuationResult> continuation) {
        f0.p(continuation, "continuation");
        return onSuccess(continuation, IMMEDIATE_EXECUTOR, null);
    }

    @r.e.a.d
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(@r.e.a.d Continuation<TResult, Task<TContinuationResult>> continuation) {
        f0.p(continuation, "continuation");
        return onSuccessTask(continuation, IMMEDIATE_EXECUTOR);
    }

    private Task(TResult tresult) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        this.continuations = new ArrayList();
        trySetResult(tresult);
    }

    @r.e.a.d
    public final <TContinuationResult> Task<TContinuationResult> onSuccess(@r.e.a.d Continuation<TResult, TContinuationResult> continuation, @e CancellationToken cancellationToken) {
        f0.p(continuation, "continuation");
        return onSuccess(continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    @r.e.a.d
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(@r.e.a.d Continuation<TResult, Task<TContinuationResult>> continuation, @e CancellationToken cancellationToken) {
        f0.p(continuation, "continuation");
        return onSuccessTask(continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    public final boolean waitForCompletion(long j, @r.e.a.d TimeUnit timeUnit) throws InterruptedException {
        f0.p(timeUnit, "timeUnit");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!isCompleted()) {
                this.condition.await(j, timeUnit);
            }
            return isCompleted();
        } finally {
            reentrantLock.unlock();
        }
    }

    private Task(boolean z) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        this.continuations = new ArrayList();
        if (z) {
            trySetCancelled();
        } else {
            trySetResult(null);
        }
    }

    @r.e.a.d
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@r.e.a.d Continuation<TResult, TContinuationResult> continuation) {
        f0.p(continuation, "continuation");
        return continueWith(continuation, IMMEDIATE_EXECUTOR, null);
    }

    @r.e.a.d
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@r.e.a.d Continuation<TResult, Task<TContinuationResult>> continuation) {
        f0.p(continuation, "continuation");
        return continueWithTask(continuation, IMMEDIATE_EXECUTOR, null);
    }

    @r.e.a.d
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@r.e.a.d Continuation<TResult, TContinuationResult> continuation, @e CancellationToken cancellationToken) {
        f0.p(continuation, "continuation");
        return continueWith(continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    @r.e.a.d
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@r.e.a.d Continuation<TResult, Task<TContinuationResult>> continuation, @e CancellationToken cancellationToken) {
        f0.p(continuation, "continuation");
        return continueWithTask(continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }
}
