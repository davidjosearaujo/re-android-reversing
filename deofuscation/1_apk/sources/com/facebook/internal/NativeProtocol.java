package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginTargetApp;
import com.facebook.messenger.MessengerUtils;
import com.huawei.hms.api.FailedBinderCallBack;
import com.huawei.hms.push.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import n.b0;
import n.l2.k;
import n.l2.v.f0;
import n.l2.v.u;
import r.e.a.d;

/* compiled from: NativeProtocol.kt */
@b0(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b9\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b4\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001:\u0010Î\u0001Ï\u0001Ð\u0001Ñ\u0001Ò\u0001Ó\u0001Ô\u0001Õ\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u007f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020v0u0tH\u0002J\u000f\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020v0uH\u0002J\u000f\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020v0uH\u0002J\u0013\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0084\u0001\u001a\u00020vH\u0002J.\u0010\u0085\u0001\u001a\u00020?2\u0010\u0010\u0086\u0001\u001a\u000b\u0012\u0004\u0012\u00020?\u0018\u00010\u0087\u00012\u0007\u0010\u0088\u0001\u001a\u00020?2\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0007J\u0018\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0007J\u0093\u0001\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u00042\u0010\u0010\u0094\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0095\u00012\u0007\u0010\u0096\u0001\u001a\u00020\u00042\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\b\u0010\u0099\u0001\u001a\u00030\u0098\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u00042\u0007\u0010\u009d\u0001\u001a\u00020\u00042\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010\u009f\u0001\u001a\u00030\u0098\u00012\b\u0010 \u0001\u001a\u00030\u0098\u00012\b\u0010¡\u0001\u001a\u00030\u0098\u0001H\u0007J~\u0010¢\u0001\u001a\u0005\u0018\u00010\u0090\u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u00042\u0010\u0010\u0094\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0095\u00012\u0007\u0010\u0096\u0001\u001a\u00020\u00042\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\b\u0010\u0099\u0001\u001a\u00030\u0098\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u00042\u0007\u0010\u009d\u0001\u001a\u00020\u00042\b\u0010 \u0001\u001a\u00030\u0098\u00012\b\u0010¡\u0001\u001a\u00030\u0098\u0001H\u0007J\u009c\u0001\u0010£\u0001\u001a\u0005\u0018\u00010\u0090\u00012\u0007\u0010\u0084\u0001\u001a\u00020v2\u0007\u0010\u0093\u0001\u001a\u00020\u00042\u0010\u0010\u0094\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0095\u00012\u0007\u0010\u0096\u0001\u001a\u00020\u00042\b\u0010\u0099\u0001\u001a\u00030\u0098\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u00042\u0007\u0010\u009d\u0001\u001a\u00020\u00042\b\u0010¤\u0001\u001a\u00030\u0098\u00012\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010\u009f\u0001\u001a\u00030\u0098\u00012\b\u0010¥\u0001\u001a\u00030¦\u00012\b\u0010 \u0001\u001a\u00030\u0098\u00012\b\u0010¡\u0001\u001a\u00030\u0098\u0001H\u0002JD\u0010§\u0001\u001a\u0005\u0018\u00010\u0090\u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010©\u0001\u001a\u0004\u0018\u00010\u00042\n\u0010ª\u0001\u001a\u0005\u0018\u00010«\u00012\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0007J\u0016\u0010\u00ad\u0001\u001a\u0005\u0018\u00010\u0090\u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0007J.\u0010®\u0001\u001a\u0005\u0018\u00010\u0090\u00012\b\u0010¯\u0001\u001a\u00030\u0090\u00012\n\u0010°\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\u0010±\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0007J£\u0001\u0010²\u0001\u001a\t\u0012\u0005\u0012\u00030\u0090\u00010u2\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u00042\u0010\u0010\u0094\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0095\u00012\u0007\u0010\u0096\u0001\u001a\u00020\u00042\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\b\u0010\u0099\u0001\u001a\u00030\u0098\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u00042\u0007\u0010\u009d\u0001\u001a\u00020\u00042\b\u0010¤\u0001\u001a\u00030\u0098\u00012\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010\u009f\u0001\u001a\u00030\u0098\u00012\b\u0010 \u0001\u001a\u00030\u0098\u00012\b\u0010¡\u0001\u001a\u00030\u0098\u0001H\u0007J\u0016\u0010³\u0001\u001a\u0005\u0018\u00010\u0090\u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0007J\u0019\u0010´\u0001\u001a\t\u0012\u0004\u0012\u00020?0\u0087\u00012\u0007\u0010\u0084\u0001\u001a\u00020vH\u0002J\u0016\u0010µ\u0001\u001a\u0005\u0018\u00010\u008c\u00012\b\u0010¶\u0001\u001a\u00030\u0090\u0001H\u0007J\u0018\u0010·\u0001\u001a\u0005\u0018\u00010¸\u00012\n\u0010¶\u0001\u001a\u0005\u0018\u00010\u0090\u0001H\u0007J\u0016\u0010¹\u0001\u001a\u0005\u0018\u00010\u008c\u00012\b\u0010º\u0001\u001a\u00030\u0090\u0001H\u0007J\u0018\u0010»\u0001\u001a\u0005\u0018\u00010\u008e\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0007J\u001d\u0010½\u0001\u001a\u00030«\u00012\u0007\u0010©\u0001\u001a\u00020\u00042\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0007J%\u0010¾\u0001\u001a\u00030«\u00012\u000f\u0010¿\u0001\u001a\n\u0012\u0004\u0012\u00020v\u0018\u00010u2\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0002J\u0012\u0010À\u0001\u001a\u00020?2\u0007\u0010Á\u0001\u001a\u00020?H\u0007J\u0016\u0010Â\u0001\u001a\u0005\u0018\u00010\u008c\u00012\b\u0010¶\u0001\u001a\u00030\u0090\u0001H\u0007J\u0013\u0010Ã\u0001\u001a\u00020?2\b\u0010¶\u0001\u001a\u00030\u0090\u0001H\u0007J\u0016\u0010Ä\u0001\u001a\u0005\u0018\u00010\u008c\u00012\b\u0010º\u0001\u001a\u00030\u0090\u0001H\u0007J\u0014\u0010Å\u0001\u001a\u00030\u0098\u00012\b\u0010º\u0001\u001a\u00030\u0090\u0001H\u0007J\u0013\u0010Æ\u0001\u001a\u00030\u0098\u00012\u0007\u0010Ç\u0001\u001a\u00020?H\u0007J?\u0010È\u0001\u001a\u00030É\u00012\b\u0010¶\u0001\u001a\u00030\u0090\u00012\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010©\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010Ç\u0001\u001a\u00020?2\n\u0010Ê\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0007J\n\u0010Ë\u0001\u001a\u00030É\u0001H\u0007J-\u0010Ì\u0001\u001a\u0005\u0018\u00010\u0090\u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\n\u0010¶\u0001\u001a\u0005\u0018\u00010\u0090\u00012\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010vH\u0007J-\u0010Í\u0001\u001a\u0005\u0018\u00010\u0090\u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\n\u0010¶\u0001\u001a\u0005\u0018\u00010\u0090\u00012\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010vH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>X\u0082\u0004¢\u0006\u0004\n\u0002\u0010@R\u000e\u0010A\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020?X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R \u0010s\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020v0u0tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010w\u001a\b\u0012\u0004\u0012\u00020v0uX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010x\u001a\b\u0012\u0004\u0012\u00020v0uX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010y\u001a\u00020?8FX\u0087\u0004¢\u0006\f\u0012\u0004\bz\u0010\u0002\u001a\u0004\b{\u0010|R\u000e\u0010}\u001a\u00020~X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Ö\u0001"}, d2 = {"Lcom/facebook/internal/NativeProtocol;", "", "()V", "ACTION_APPINVITE_DIALOG", "", "ACTION_CAMERA_EFFECT", "ACTION_FEED_DIALOG", "ACTION_LIKE_DIALOG", "ACTION_MESSAGE_DIALOG", "ACTION_OGACTIONPUBLISH_DIALOG", "ACTION_OGMESSAGEPUBLISH_DIALOG", "ACTION_SHARE_STORY", "AUDIENCE_EVERYONE", "AUDIENCE_FRIENDS", "AUDIENCE_ME", "BRIDGE_ARG_ACTION_ID_STRING", "BRIDGE_ARG_APP_NAME_STRING", "BRIDGE_ARG_ERROR_BUNDLE", "BRIDGE_ARG_ERROR_CODE", "BRIDGE_ARG_ERROR_DESCRIPTION", "BRIDGE_ARG_ERROR_JSON", "BRIDGE_ARG_ERROR_SUBCODE", "BRIDGE_ARG_ERROR_TYPE", "CONTENT_SCHEME", "ERROR_APPLICATION_ERROR", "ERROR_NETWORK_ERROR", "ERROR_PERMISSION_DENIED", "ERROR_PROTOCOL_ERROR", "ERROR_SERVICE_DISABLED", "ERROR_UNKNOWN_ERROR", "ERROR_USER_CANCELED", "EXTRA_ACCESS_TOKEN", "EXTRA_APPLICATION_ID", "EXTRA_APPLICATION_NAME", "EXTRA_DATA_ACCESS_EXPIRATION_TIME", "EXTRA_DIALOG_COMPLETE_KEY", "EXTRA_DIALOG_COMPLETION_GESTURE_KEY", "EXTRA_EXPIRES_SECONDS_SINCE_EPOCH", "EXTRA_GET_INSTALL_DATA_PACKAGE", "EXTRA_GRAPH_API_VERSION", "EXTRA_LOGGER_REF", "EXTRA_PERMISSIONS", "EXTRA_PROTOCOL_ACTION", "EXTRA_PROTOCOL_BRIDGE_ARGS", "EXTRA_PROTOCOL_CALL_ID", "EXTRA_PROTOCOL_METHOD_ARGS", "EXTRA_PROTOCOL_METHOD_RESULTS", "EXTRA_PROTOCOL_VERSION", "EXTRA_PROTOCOL_VERSIONS", "EXTRA_TOAST_DURATION_MS", "EXTRA_USER_ID", "FACEBOOK_PROXY_AUTH_ACTIVITY", "FACEBOOK_PROXY_AUTH_APP_ID_KEY", "FACEBOOK_PROXY_AUTH_E2E_KEY", "FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY", "FACEBOOK_SDK_VERSION_KEY", "FACEBOOK_TOKEN_REFRESH_ACTIVITY", "IMAGE_URL_KEY", "IMAGE_USER_GENERATED_KEY", "INTENT_ACTION_PLATFORM_ACTIVITY", "INTENT_ACTION_PLATFORM_SERVICE", "KNOWN_PROTOCOL_VERSIONS", "", "", "[Ljava/lang/Integer;", "MESSAGE_GET_ACCESS_TOKEN_REPLY", "MESSAGE_GET_ACCESS_TOKEN_REQUEST", "MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY", "MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST", "MESSAGE_GET_INSTALL_DATA_REPLY", "MESSAGE_GET_INSTALL_DATA_REQUEST", "MESSAGE_GET_LIKE_STATUS_REPLY", "MESSAGE_GET_LIKE_STATUS_REQUEST", "MESSAGE_GET_LOGIN_STATUS_REPLY", "MESSAGE_GET_LOGIN_STATUS_REQUEST", "MESSAGE_GET_PROTOCOL_VERSIONS_REPLY", "MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST", "NO_PROTOCOL_AVAILABLE", "OPEN_GRAPH_CREATE_OBJECT_KEY", "PLATFORM_PROVIDER", "PLATFORM_PROVIDER_VERSIONS", "PLATFORM_PROVIDER_VERSION_COLUMN", "PROTOCOL_VERSION_20121101", "PROTOCOL_VERSION_20130502", "PROTOCOL_VERSION_20130618", "PROTOCOL_VERSION_20131107", "PROTOCOL_VERSION_20140204", "PROTOCOL_VERSION_20140324", "PROTOCOL_VERSION_20140701", "PROTOCOL_VERSION_20141001", "PROTOCOL_VERSION_20141028", "PROTOCOL_VERSION_20141107", "PROTOCOL_VERSION_20141218", "PROTOCOL_VERSION_20160327", "PROTOCOL_VERSION_20170213", "PROTOCOL_VERSION_20170411", "PROTOCOL_VERSION_20170417", "PROTOCOL_VERSION_20171115", "RESULT_ARGS_ACCESS_TOKEN", "RESULT_ARGS_DIALOG_COMPLETE_KEY", "RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY", "RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH", "RESULT_ARGS_GRAPH_DOMAIN", "RESULT_ARGS_PERMISSIONS", "RESULT_ARGS_SIGNED_REQUEST", "STATUS_ERROR_CODE", "STATUS_ERROR_DESCRIPTION", "STATUS_ERROR_JSON", "STATUS_ERROR_SUBCODE", "STATUS_ERROR_TYPE", "TAG", "WEB_DIALOG_ACTION", "WEB_DIALOG_IS_FALLBACK", "WEB_DIALOG_PARAMS", "WEB_DIALOG_URL", "actionToAppInfoMap", "", "", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "effectCameraAppInfoList", "facebookAppInfoList", "latestKnownVersion", "getLatestKnownVersion$annotations", "getLatestKnownVersion", "()I", "protocolVersionsAsyncUpdating", "Ljava/util/concurrent/atomic/AtomicBoolean;", "buildActionToAppInfoMap", "buildEffectCameraAppInfoList", "buildFacebookAppList", "buildPlatformProviderVersionURI", "Landroid/net/Uri;", "appInfo", "computeLatestAvailableVersionFromVersionSpec", "allAvailableFacebookAppVersions", "Ljava/util/TreeSet;", "latestSdkVersion", "versionSpec", "", "createBundleForException", "Landroid/os/Bundle;", e.a, "Lcom/facebook/FacebookException;", "createFacebookLiteIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "applicationId", "permissions", "", "e2e", "isRerequest", "", "isForPublish", "defaultAudience", "Lcom/facebook/login/DefaultAudience;", "clientState", "authType", "messengerPageId", "resetMessengerState", "isFamilyLogin", "shouldSkipAccountDedupe", "createInstagramIntent", "createNativeAppIntent", "ignoreAppSwitchToLoggedOut", "targetApp", "Lcom/facebook/login/LoginTargetApp;", "createPlatformActivityIntent", FailedBinderCallBack.CALLER_ID, "action", "versionResult", "Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "extras", "createPlatformServiceIntent", "createProtocolResultIntent", "requestIntent", "results", "error", "createProxyAuthIntents", "createTokenRefreshIntent", "fetchAllAvailableProtocolVersionsForAppInfo", "getBridgeArgumentsFromIntent", "intent", "getCallIdFromIntent", "Ljava/util/UUID;", "getErrorDataFromResultIntent", "resultIntent", "getExceptionFromErrorData", "errorData", "getLatestAvailableProtocolVersionForAction", "getLatestAvailableProtocolVersionForAppInfoList", "appInfoList", "getLatestAvailableProtocolVersionForService", "minimumVersion", "getMethodArgumentsFromIntent", "getProtocolVersionFromIntent", "getSuccessResultsFromIntent", "isErrorResult", "isVersionCompatibleWithBucketedIntent", "version", "setupProtocolRequestIntent", "", "params", "updateAllAvailableProtocolVersionsAsync", "validateActivityIntent", "validateServiceIntent", "EffectTestAppInfo", "FBLiteAppInfo", "InstagramAppInfo", "KatanaAppInfo", "MessengerAppInfo", "NativeAppInfo", "ProtocolVersionQueryResult", "WakizashiAppInfo", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class NativeProtocol {
    @d
    public static final String ACTION_APPINVITE_DIALOG = "com.facebook.platform.action.request.APPINVITES_DIALOG";
    @d
    public static final String ACTION_CAMERA_EFFECT = "com.facebook.platform.action.request.CAMERA_EFFECT";
    @d
    public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";
    @d
    public static final String ACTION_LIKE_DIALOG = "com.facebook.platform.action.request.LIKE_DIALOG";
    @d
    public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";
    @d
    public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    @d
    public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
    @d
    public static final String ACTION_SHARE_STORY = "com.facebook.platform.action.request.SHARE_STORY";
    @d
    public static final String AUDIENCE_EVERYONE = "everyone";
    @d
    public static final String AUDIENCE_FRIENDS = "friends";
    @d
    public static final String AUDIENCE_ME = "only_me";
    @d
    public static final String BRIDGE_ARG_ACTION_ID_STRING = "action_id";
    @d
    public static final String BRIDGE_ARG_APP_NAME_STRING = "app_name";
    @d
    public static final String BRIDGE_ARG_ERROR_BUNDLE = "error";
    @d
    public static final String BRIDGE_ARG_ERROR_CODE = "error_code";
    @d
    public static final String BRIDGE_ARG_ERROR_DESCRIPTION = "error_description";
    @d
    public static final String BRIDGE_ARG_ERROR_JSON = "error_json";
    @d
    public static final String BRIDGE_ARG_ERROR_SUBCODE = "error_subcode";
    @d
    public static final String BRIDGE_ARG_ERROR_TYPE = "error_type";
    private static final String CONTENT_SCHEME = "content://";
    @d
    public static final String ERROR_APPLICATION_ERROR = "ApplicationError";
    @d
    public static final String ERROR_NETWORK_ERROR = "NetworkError";
    @d
    public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";
    @d
    public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
    @d
    public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";
    @d
    public static final String ERROR_UNKNOWN_ERROR = "UnknownError";
    @d
    public static final String ERROR_USER_CANCELED = "UserCanceled";
    @d
    public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";
    @d
    public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";
    @d
    public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";
    @d
    public static final String EXTRA_DATA_ACCESS_EXPIRATION_TIME = "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME";
    @d
    public static final String EXTRA_DIALOG_COMPLETE_KEY = "com.facebook.platform.extra.DID_COMPLETE";
    @d
    public static final String EXTRA_DIALOG_COMPLETION_GESTURE_KEY = "com.facebook.platform.extra.COMPLETION_GESTURE";
    @d
    public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
    @d
    public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";
    @d
    public static final String EXTRA_GRAPH_API_VERSION = "com.facebook.platform.extra.GRAPH_API_VERSION";
    @d
    public static final String EXTRA_LOGGER_REF = "com.facebook.platform.extra.LOGGER_REF";
    @d
    public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";
    @d
    public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";
    @d
    public static final String EXTRA_PROTOCOL_BRIDGE_ARGS = "com.facebook.platform.protocol.BRIDGE_ARGS";
    @d
    public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";
    @d
    public static final String EXTRA_PROTOCOL_METHOD_ARGS = "com.facebook.platform.protocol.METHOD_ARGS";
    @d
    public static final String EXTRA_PROTOCOL_METHOD_RESULTS = "com.facebook.platform.protocol.RESULT_ARGS";
    @d
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";
    @d
    public static final String EXTRA_PROTOCOL_VERSIONS = "com.facebook.platform.extra.PROTOCOL_VERSIONS";
    @d
    public static final String EXTRA_TOAST_DURATION_MS = "com.facebook.platform.extra.EXTRA_TOAST_DURATION_MS";
    @d
    public static final String EXTRA_USER_ID = "com.facebook.platform.extra.USER_ID";
    private static final String FACEBOOK_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";
    @d
    public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";
    @d
    public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";
    @d
    public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";
    @d
    public static final String FACEBOOK_SDK_VERSION_KEY = "facebook_sdk_version";
    private static final String FACEBOOK_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";
    @d
    public static final String IMAGE_URL_KEY = "url";
    @d
    public static final String IMAGE_USER_GENERATED_KEY = "user_generated";
    @d
    public static final NativeProtocol INSTANCE;
    @d
    public static final String INTENT_ACTION_PLATFORM_ACTIVITY = "com.facebook.platform.PLATFORM_ACTIVITY";
    @d
    public static final String INTENT_ACTION_PLATFORM_SERVICE = "com.facebook.platform.PLATFORM_SERVICE";
    private static final Integer[] KNOWN_PROTOCOL_VERSIONS;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY = 65545;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST = 65544;
    public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 65541;
    public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 65540;
    public static final int MESSAGE_GET_LIKE_STATUS_REPLY = 65543;
    public static final int MESSAGE_GET_LIKE_STATUS_REQUEST = 65542;
    public static final int MESSAGE_GET_LOGIN_STATUS_REPLY = 65547;
    public static final int MESSAGE_GET_LOGIN_STATUS_REQUEST = 65546;
    public static final int MESSAGE_GET_PROTOCOL_VERSIONS_REPLY = 65539;
    public static final int MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST = 65538;
    public static final int NO_PROTOCOL_AVAILABLE = -1;
    @d
    public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";
    private static final String PLATFORM_PROVIDER = ".provider.PlatformProvider";
    private static final String PLATFORM_PROVIDER_VERSIONS = ".provider.PlatformProvider/versions";
    private static final String PLATFORM_PROVIDER_VERSION_COLUMN = "version";
    public static final int PROTOCOL_VERSION_20121101 = 20121101;
    public static final int PROTOCOL_VERSION_20130502 = 20130502;
    public static final int PROTOCOL_VERSION_20130618 = 20130618;
    public static final int PROTOCOL_VERSION_20131107 = 20131107;
    public static final int PROTOCOL_VERSION_20140204 = 20140204;
    public static final int PROTOCOL_VERSION_20140324 = 20140324;
    public static final int PROTOCOL_VERSION_20140701 = 20140701;
    public static final int PROTOCOL_VERSION_20141001 = 20141001;
    public static final int PROTOCOL_VERSION_20141028 = 20141028;
    public static final int PROTOCOL_VERSION_20141107 = 20141107;
    public static final int PROTOCOL_VERSION_20141218 = 20141218;
    public static final int PROTOCOL_VERSION_20160327 = 20160327;
    public static final int PROTOCOL_VERSION_20170213 = 20170213;
    public static final int PROTOCOL_VERSION_20170411 = 20170411;
    public static final int PROTOCOL_VERSION_20170417 = 20170417;
    public static final int PROTOCOL_VERSION_20171115 = 20171115;
    @d
    public static final String RESULT_ARGS_ACCESS_TOKEN = "access_token";
    @d
    public static final String RESULT_ARGS_DIALOG_COMPLETE_KEY = "didComplete";
    @d
    public static final String RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY = "completionGesture";
    @d
    public static final String RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH = "expires_seconds_since_epoch";
    @d
    public static final String RESULT_ARGS_GRAPH_DOMAIN = "graph_domain";
    @d
    public static final String RESULT_ARGS_PERMISSIONS = "permissions";
    @d
    public static final String RESULT_ARGS_SIGNED_REQUEST = "signed request";
    @d
    public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";
    @d
    public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";
    @d
    public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";
    @d
    public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";
    @d
    public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";
    private static final String TAG;
    @d
    public static final String WEB_DIALOG_ACTION = "action";
    @d
    public static final String WEB_DIALOG_IS_FALLBACK = "is_fallback";
    @d
    public static final String WEB_DIALOG_PARAMS = "params";
    @d
    public static final String WEB_DIALOG_URL = "url";
    private static final Map<String, List<NativeAppInfo>> actionToAppInfoMap;
    private static final List<NativeAppInfo> effectCameraAppInfoList;
    private static final List<NativeAppInfo> facebookAppInfoList;
    private static final AtomicBoolean protocolVersionsAsyncUpdating;

    /* compiled from: NativeProtocol.kt */
    @b0(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$EffectTestAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class EffectTestAppInfo extends NativeAppInfo {
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public /* bridge */ /* synthetic */ String getLoginActivity() {
            return (String) m8getLoginActivity();
        }

        @r.e.a.e
        /* renamed from: getLoginActivity */
        public Void m8getLoginActivity() {
            return null;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @d
        public String getPackage() {
            return "com.facebook.arstudio.player";
        }
    }

    /* compiled from: NativeProtocol.kt */
    @b0(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$FBLiteAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class FBLiteAppInfo extends NativeAppInfo {
        @d
        public static final Companion Companion = new Companion(null);
        @d
        public static final String FACEBOOK_LITE_ACTIVITY = "com.facebook.lite.platform.LoginGDPDialogActivity";

        /* compiled from: NativeProtocol.kt */
        @b0(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/internal/NativeProtocol$FBLiteAppInfo$Companion;", "", "()V", "FACEBOOK_LITE_ACTIVITY", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(u uVar) {
                this();
            }
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @d
        public String getLoginActivity() {
            return FACEBOOK_LITE_ACTIVITY;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @d
        public String getPackage() {
            return "com.facebook.lite";
        }
    }

    /* compiled from: NativeProtocol.kt */
    @b0(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$InstagramAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "getResponseType", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class InstagramAppInfo extends NativeAppInfo {
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @d
        public String getLoginActivity() {
            return "com.instagram.platform.AppAuthorizeActivity";
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @d
        public String getPackage() {
            return "com.instagram.android";
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @d
        public String getResponseType() {
            return ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SCOPES;
        }
    }

    /* compiled from: NativeProtocol.kt */
    @b0(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/NativeProtocol$KatanaAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class KatanaAppInfo extends NativeAppInfo {
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @d
        public String getLoginActivity() {
            return NativeProtocol.FACEBOOK_PROXY_AUTH_ACTIVITY;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @d
        public String getPackage() {
            return "com.facebook.katana";
        }
    }

    /* compiled from: NativeProtocol.kt */
    @b0(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$MessengerAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class MessengerAppInfo extends NativeAppInfo {
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public /* bridge */ /* synthetic */ String getLoginActivity() {
            return (String) m9getLoginActivity();
        }

        @r.e.a.e
        /* renamed from: getLoginActivity */
        public Void m9getLoginActivity() {
            return null;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @d
        public String getPackage() {
            return MessengerUtils.PACKAGE_NAME;
        }
    }

    /* compiled from: NativeProtocol.kt */
    @b0(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\fH\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "", "()V", "availableVersions", "Ljava/util/TreeSet;", "", "fetchAvailableVersions", "", "force", "", "getAvailableVersions", "getLoginActivity", "", "getPackage", "getResponseType", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static abstract class NativeAppInfo {
        private TreeSet<Integer> availableVersions;

        /* JADX WARN: Code restructure failed: missing block: B:25:0x000d, code lost:
            if (r1.isEmpty() == false) goto L4;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final synchronized void fetchAvailableVersions(boolean r1) {
            /*
                r0 = this;
                monitor-enter(r0)
                if (r1 != 0) goto Lf
                java.util.TreeSet<java.lang.Integer> r1 = r0.availableVersions     // Catch: java.lang.Throwable -> L19
                if (r1 == 0) goto Lf
                if (r1 == 0) goto Lf
                boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L19
                if (r1 == 0) goto L17
            Lf:
                com.facebook.internal.NativeProtocol r1 = com.facebook.internal.NativeProtocol.INSTANCE     // Catch: java.lang.Throwable -> L19
                java.util.TreeSet r1 = com.facebook.internal.NativeProtocol.access$fetchAllAvailableProtocolVersionsForAppInfo(r1, r0)     // Catch: java.lang.Throwable -> L19
                r0.availableVersions = r1     // Catch: java.lang.Throwable -> L19
            L17:
                monitor-exit(r0)
                return
            L19:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.NativeAppInfo.fetchAvailableVersions(boolean):void");
        }

        @r.e.a.e
        public final TreeSet<Integer> getAvailableVersions() {
            TreeSet<Integer> treeSet = this.availableVersions;
            if (treeSet == null || treeSet == null || treeSet.isEmpty()) {
                fetchAvailableVersions(false);
            }
            return this.availableVersions;
        }

        @r.e.a.e
        public abstract String getLoginActivity();

        @d
        public abstract String getPackage();

        @d
        public String getResponseType() {
            return ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST;
        }
    }

    /* compiled from: NativeProtocol.kt */
    @b0(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "", "()V", "<set-?>", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "appInfo", "getAppInfo", "()Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "", "protocolVersion", "getProtocolVersion", "()I", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class ProtocolVersionQueryResult {
        @d
        public static final Companion Companion = new Companion(null);
        @r.e.a.e
        private NativeAppInfo appInfo;
        private int protocolVersion;

        /* compiled from: NativeProtocol.kt */
        @b0(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult$Companion;", "", "()V", "create", "Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "nativeAppInfo", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "protocolVersion", "", "createEmpty", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static final class Companion {
            private Companion() {
            }

            @d
            @k
            public final ProtocolVersionQueryResult create(@r.e.a.e NativeAppInfo nativeAppInfo, int i) {
                ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult(null);
                protocolVersionQueryResult.appInfo = nativeAppInfo;
                protocolVersionQueryResult.protocolVersion = i;
                return protocolVersionQueryResult;
            }

            @d
            @k
            public final ProtocolVersionQueryResult createEmpty() {
                ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult(null);
                protocolVersionQueryResult.protocolVersion = -1;
                return protocolVersionQueryResult;
            }

            public /* synthetic */ Companion(u uVar) {
                this();
            }
        }

        private ProtocolVersionQueryResult() {
        }

        @d
        @k
        public static final ProtocolVersionQueryResult create(@r.e.a.e NativeAppInfo nativeAppInfo, int i) {
            return Companion.create(nativeAppInfo, i);
        }

        @d
        @k
        public static final ProtocolVersionQueryResult createEmpty() {
            return Companion.createEmpty();
        }

        @r.e.a.e
        public final NativeAppInfo getAppInfo() {
            return this.appInfo;
        }

        public final int getProtocolVersion() {
            return this.protocolVersion;
        }

        public /* synthetic */ ProtocolVersionQueryResult(u uVar) {
            this();
        }
    }

    /* compiled from: NativeProtocol.kt */
    @b0(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/NativeProtocol$WakizashiAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class WakizashiAppInfo extends NativeAppInfo {
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @d
        public String getLoginActivity() {
            return NativeProtocol.FACEBOOK_PROXY_AUTH_ACTIVITY;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @d
        public String getPackage() {
            return RemoteServiceWrapper.RECEIVER_SERVICE_PACKAGE_WAKIZASHI;
        }
    }

    static {
        NativeProtocol nativeProtocol = new NativeProtocol();
        INSTANCE = nativeProtocol;
        String name = NativeProtocol.class.getName();
        f0.o(name, "NativeProtocol::class.java.name");
        TAG = name;
        facebookAppInfoList = nativeProtocol.buildFacebookAppList();
        effectCameraAppInfoList = nativeProtocol.buildEffectCameraAppInfoList();
        actionToAppInfoMap = nativeProtocol.buildActionToAppInfoMap();
        protocolVersionsAsyncUpdating = new AtomicBoolean(false);
        KNOWN_PROTOCOL_VERSIONS = new Integer[]{Integer.valueOf((int) PROTOCOL_VERSION_20170417), Integer.valueOf((int) PROTOCOL_VERSION_20160327), Integer.valueOf((int) PROTOCOL_VERSION_20141218), Integer.valueOf((int) PROTOCOL_VERSION_20141107), Integer.valueOf((int) PROTOCOL_VERSION_20141028), Integer.valueOf((int) PROTOCOL_VERSION_20141001), Integer.valueOf((int) PROTOCOL_VERSION_20140701), Integer.valueOf((int) PROTOCOL_VERSION_20140324), Integer.valueOf((int) PROTOCOL_VERSION_20140204), Integer.valueOf((int) PROTOCOL_VERSION_20131107), Integer.valueOf((int) PROTOCOL_VERSION_20130618), Integer.valueOf((int) PROTOCOL_VERSION_20130502), Integer.valueOf((int) PROTOCOL_VERSION_20121101)};
    }

    private NativeProtocol() {
    }

    public static final /* synthetic */ TreeSet access$fetchAllAvailableProtocolVersionsForAppInfo(NativeProtocol nativeProtocol, NativeAppInfo nativeAppInfo) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            return nativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(nativeAppInfo);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final /* synthetic */ List access$getFacebookAppInfoList$p(NativeProtocol nativeProtocol) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            return facebookAppInfoList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final /* synthetic */ AtomicBoolean access$getProtocolVersionsAsyncUpdating$p(NativeProtocol nativeProtocol) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            return protocolVersionsAsyncUpdating;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    private final Map<String, List<NativeAppInfo>> buildActionToAppInfoMap() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MessengerAppInfo());
            List<NativeAppInfo> list = facebookAppInfoList;
            hashMap.put(ACTION_OGACTIONPUBLISH_DIALOG, list);
            hashMap.put(ACTION_FEED_DIALOG, list);
            hashMap.put(ACTION_LIKE_DIALOG, list);
            hashMap.put(ACTION_APPINVITE_DIALOG, list);
            hashMap.put(ACTION_MESSAGE_DIALOG, arrayList);
            hashMap.put(ACTION_OGMESSAGEPUBLISH_DIALOG, arrayList);
            hashMap.put(ACTION_CAMERA_EFFECT, effectCameraAppInfoList);
            hashMap.put(ACTION_SHARE_STORY, list);
            return hashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final List<NativeAppInfo> buildEffectCameraAppInfoList() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList r = CollectionsKt__CollectionsKt.r(new NativeAppInfo[]{new EffectTestAppInfo()});
            r.addAll(buildFacebookAppList());
            return r;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final List<NativeAppInfo> buildFacebookAppList() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return CollectionsKt__CollectionsKt.r(new NativeAppInfo[]{new KatanaAppInfo(), new WakizashiAppInfo()});
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Uri buildPlatformProviderVersionURI(NativeAppInfo nativeAppInfo) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Uri parse = Uri.parse(CONTENT_SCHEME + nativeAppInfo.getPackage() + PLATFORM_PROVIDER_VERSIONS);
            f0.o(parse, "Uri.parse(CONTENT_SCHEME…ATFORM_PROVIDER_VERSIONS)");
            return parse;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @k
    public static final int computeLatestAvailableVersionFromVersionSpec(@r.e.a.e TreeSet<Integer> treeSet, int i, @d int[] iArr) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            f0.p(iArr, "versionSpec");
            if (treeSet == null) {
                return -1;
            }
            int length = iArr.length - 1;
            Iterator<Integer> descendingIterator = treeSet.descendingIterator();
            int i2 = -1;
            while (descendingIterator.hasNext()) {
                Integer next = descendingIterator.next();
                f0.o(next, "fbAppVersion");
                i2 = Math.max(i2, next.intValue());
                while (length >= 0 && iArr[length] > next.intValue()) {
                    length--;
                }
                if (length < 0) {
                    return -1;
                }
                if (iArr[length] == next.intValue()) {
                    if (length % 2 == 0) {
                        return Math.min(i2, i);
                    }
                    return -1;
                }
            }
            return -1;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    @k
    @r.e.a.e
    public static final Bundle createBundleForException(@r.e.a.e FacebookException facebookException) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class) || facebookException == null) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString(BRIDGE_ARG_ERROR_DESCRIPTION, facebookException.toString());
            if (facebookException instanceof FacebookOperationCanceledException) {
                bundle.putString("error_type", ERROR_USER_CANCELED);
            }
            return bundle;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @k
    @r.e.a.e
    public static final Intent createFacebookLiteIntent(@d Context context, @d String str, @d Collection<String> collection, @d String str2, boolean z, boolean z2, @d DefaultAudience defaultAudience, @d String str3, @d String str4, @r.e.a.e String str5, boolean z3, boolean z4, boolean z5) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            f0.p(context, "context");
            f0.p(str, "applicationId");
            f0.p(collection, "permissions");
            f0.p(str2, "e2e");
            f0.p(defaultAudience, "defaultAudience");
            f0.p(str3, "clientState");
            f0.p(str4, "authType");
            FBLiteAppInfo fBLiteAppInfo = new FBLiteAppInfo();
            return validateActivityIntent(context, INSTANCE.createNativeAppIntent(fBLiteAppInfo, str, collection, str2, z2, defaultAudience, str3, str4, false, str5, z3, LoginTargetApp.FACEBOOK, z4, z5), fBLiteAppInfo);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @k
    @r.e.a.e
    public static final Intent createInstagramIntent(@d Context context, @d String str, @d Collection<String> collection, @d String str2, boolean z, boolean z2, @d DefaultAudience defaultAudience, @d String str3, @d String str4, boolean z3, boolean z4) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            f0.p(context, "context");
            f0.p(str, "applicationId");
            f0.p(collection, "permissions");
            f0.p(str2, "e2e");
            f0.p(defaultAudience, "defaultAudience");
            f0.p(str3, "clientState");
            f0.p(str4, "authType");
            InstagramAppInfo instagramAppInfo = new InstagramAppInfo();
            return validateActivityIntent(context, INSTANCE.createNativeAppIntent(instagramAppInfo, str, collection, str2, z2, defaultAudience, str3, str4, false, null, false, LoginTargetApp.INSTAGRAM, z3, z4), instagramAppInfo);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    private final Intent createNativeAppIntent(NativeAppInfo nativeAppInfo, String str, Collection<String> collection, String str2, boolean z, DefaultAudience defaultAudience, String str3, String str4, boolean z2, String str5, boolean z3, LoginTargetApp loginTargetApp, boolean z4, boolean z5) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            String loginActivity = nativeAppInfo.getLoginActivity();
            if (loginActivity != null) {
                Intent putExtra = new Intent().setClassName(nativeAppInfo.getPackage(), loginActivity).putExtra("client_id", str);
                f0.o(putExtra, "Intent()\n            .se…PP_ID_KEY, applicationId)");
                putExtra.putExtra(FACEBOOK_SDK_VERSION_KEY, FacebookSdk.getSdkVersion());
                if (!Utility.isNullOrEmpty(collection)) {
                    putExtra.putExtra("scope", TextUtils.join(",", collection));
                }
                if (!Utility.isNullOrEmpty(str2)) {
                    putExtra.putExtra("e2e", str2);
                }
                putExtra.putExtra("state", str3);
                putExtra.putExtra("response_type", nativeAppInfo.getResponseType());
                putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                if (z) {
                    putExtra.putExtra("default_audience", defaultAudience.getNativeProtocolAudience());
                }
                putExtra.putExtra(ServerProtocol.DIALOG_PARAM_LEGACY_OVERRIDE, FacebookSdk.getGraphApiVersion());
                putExtra.putExtra(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, str4);
                if (z2) {
                    putExtra.putExtra(ServerProtocol.DIALOG_PARAM_FAIL_ON_LOGGED_OUT, true);
                }
                putExtra.putExtra(ServerProtocol.DIALOG_PARAM_MESSENGER_PAGE_ID, str5);
                putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RESET_MESSENGER_STATE, z3);
                if (z4) {
                    putExtra.putExtra(ServerProtocol.DIALOG_PARAM_FX_APP, loginTargetApp.toString());
                }
                if (z5) {
                    putExtra.putExtra(ServerProtocol.DIALOG_PARAM_SKIP_DEDUPE, true);
                }
                return putExtra;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @k
    @r.e.a.e
    public static final Intent createPlatformActivityIntent(@d Context context, @r.e.a.e String str, @r.e.a.e String str2, @r.e.a.e ProtocolVersionQueryResult protocolVersionQueryResult, @r.e.a.e Bundle bundle) {
        NativeAppInfo appInfo;
        Intent validateActivityIntent;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            f0.p(context, "context");
            if (protocolVersionQueryResult == null || (appInfo = protocolVersionQueryResult.getAppInfo()) == null || (validateActivityIntent = validateActivityIntent(context, new Intent().setAction(INTENT_ACTION_PLATFORM_ACTIVITY).setPackage(appInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), appInfo)) == null) {
                return null;
            }
            setupProtocolRequestIntent(validateActivityIntent, str, str2, protocolVersionQueryResult.getProtocolVersion(), bundle);
            return validateActivityIntent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @k
    @r.e.a.e
    public static final Intent createPlatformServiceIntent(@d Context context) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            f0.p(context, "context");
            for (NativeAppInfo nativeAppInfo : facebookAppInfoList) {
                Intent validateServiceIntent = validateServiceIntent(context, new Intent(INTENT_ACTION_PLATFORM_SERVICE).setPackage(nativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), nativeAppInfo);
                if (validateServiceIntent != null) {
                    return validateServiceIntent;
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @k
    @r.e.a.e
    public static final Intent createProtocolResultIntent(@d Intent intent, @r.e.a.e Bundle bundle, @r.e.a.e FacebookException facebookException) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            f0.p(intent, "requestIntent");
            UUID callIdFromIntent = getCallIdFromIntent(intent);
            if (callIdFromIntent != null) {
                Intent intent2 = new Intent();
                intent2.putExtra(EXTRA_PROTOCOL_VERSION, getProtocolVersionFromIntent(intent));
                Bundle bundle2 = new Bundle();
                bundle2.putString("action_id", callIdFromIntent.toString());
                if (facebookException != null) {
                    bundle2.putBundle("error", createBundleForException(facebookException));
                }
                intent2.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
                if (bundle != null) {
                    intent2.putExtra(EXTRA_PROTOCOL_METHOD_RESULTS, bundle);
                }
                return intent2;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @d
    @k
    public static final List<Intent> createProxyAuthIntents(@r.e.a.e Context context, @d String str, @d Collection<String> collection, @d String str2, boolean z, boolean z2, @d DefaultAudience defaultAudience, @d String str3, @d String str4, boolean z3, @r.e.a.e String str5, boolean z4, boolean z5, boolean z6) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            f0.p(str, "applicationId");
            f0.p(collection, "permissions");
            f0.p(str2, "e2e");
            f0.p(defaultAudience, "defaultAudience");
            f0.p(str3, "clientState");
            f0.p(str4, "authType");
            List<NativeAppInfo> list = facebookAppInfoList;
            ArrayList arrayList = new ArrayList();
            for (NativeAppInfo nativeAppInfo : list) {
                ArrayList arrayList2 = arrayList;
                Intent createNativeAppIntent = INSTANCE.createNativeAppIntent(nativeAppInfo, str, collection, str2, z2, defaultAudience, str3, str4, z3, str5, z4, LoginTargetApp.FACEBOOK, z5, z6);
                if (createNativeAppIntent != null) {
                    arrayList2.add(createNativeAppIntent);
                }
                arrayList = arrayList2;
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @k
    @r.e.a.e
    public static final Intent createTokenRefreshIntent(@d Context context) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            f0.p(context, "context");
            for (NativeAppInfo nativeAppInfo : facebookAppInfoList) {
                Intent validateServiceIntent = validateServiceIntent(context, new Intent().setClassName(nativeAppInfo.getPackage(), FACEBOOK_TOKEN_REFRESH_ACTIVITY), nativeAppInfo);
                if (validateServiceIntent != null) {
                    return validateServiceIntent;
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x0091 A[Catch: all -> 0x009d, TRY_ENTER, TryCatch #6 {all -> 0x009d, blocks: (B:54:0x000c, B:84:0x0099, B:85:0x009c, B:79:0x0091), top: B:94:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0073 A[EXC_TOP_SPLITTER, LOOP:0: B:92:0x0073->B:73:0x0079, LOOP_START, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.TreeSet<java.lang.Integer> fetchAllAvailableProtocolVersionsForAppInfo(com.facebook.internal.NativeProtocol.NativeAppInfo r14) {
        /*
            r13 = this;
            java.lang.String r0 = "version"
            java.lang.String r1 = "Failed to query content resolver."
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r13)
            r3 = 0
            if (r2 == 0) goto Lc
            return r3
        Lc:
            java.util.TreeSet r2 = new java.util.TreeSet     // Catch: java.lang.Throwable -> L9d
            r2.<init>()     // Catch: java.lang.Throwable -> L9d
            android.content.Context r4 = com.facebook.FacebookSdk.getApplicationContext()     // Catch: java.lang.Throwable -> L9d
            java.lang.String r5 = "appContext"
            n.l2.v.f0.o(r4, r5)     // Catch: java.lang.Throwable -> L9d
            android.content.ContentResolver r6 = r4.getContentResolver()     // Catch: java.lang.Throwable -> L9d
            java.lang.String[] r8 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L9d
            android.net.Uri r7 = r13.buildPlatformProviderVersionURI(r14)     // Catch: java.lang.Throwable -> L9d
            android.content.Context r4 = com.facebook.FacebookSdk.getApplicationContext()     // Catch: java.lang.Throwable -> L95
            java.lang.String r5 = "FacebookSdk.getApplicationContext()"
            n.l2.v.f0.o(r4, r5)     // Catch: java.lang.Throwable -> L95
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch: java.lang.Throwable -> L95
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L95
            r5.<init>()     // Catch: java.lang.Throwable -> L95
            java.lang.String r14 = r14.getPackage()     // Catch: java.lang.Throwable -> L95
            r5.append(r14)     // Catch: java.lang.Throwable -> L95
            java.lang.String r14 = ".provider.PlatformProvider"
            r5.append(r14)     // Catch: java.lang.Throwable -> L95
            java.lang.String r14 = r5.toString()     // Catch: java.lang.Throwable -> L95
            r5 = 0
            android.content.pm.ProviderInfo r14 = r4.resolveContentProvider(r14, r5)     // Catch: java.lang.RuntimeException -> L4e java.lang.Throwable -> L95
            goto L55
        L4e:
            r14 = move-exception
            java.lang.String r4 = com.facebook.internal.NativeProtocol.TAG     // Catch: java.lang.Throwable -> L95
            android.util.Log.e(r4, r1, r14)     // Catch: java.lang.Throwable -> L95
            r14 = r3
        L55:
            if (r14 == 0) goto L8e
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r14 = r6.query(r7, r8, r9, r10, r11)     // Catch: java.lang.IllegalArgumentException -> L5f java.lang.SecurityException -> L65 java.lang.NullPointerException -> L6b java.lang.Throwable -> L95
            goto L71
        L5f:
            java.lang.String r14 = com.facebook.internal.NativeProtocol.TAG     // Catch: java.lang.Throwable -> L95
            android.util.Log.e(r14, r1)     // Catch: java.lang.Throwable -> L95
            goto L70
        L65:
            java.lang.String r14 = com.facebook.internal.NativeProtocol.TAG     // Catch: java.lang.Throwable -> L95
            android.util.Log.e(r14, r1)     // Catch: java.lang.Throwable -> L95
            goto L70
        L6b:
            java.lang.String r14 = com.facebook.internal.NativeProtocol.TAG     // Catch: java.lang.Throwable -> L95
            android.util.Log.e(r14, r1)     // Catch: java.lang.Throwable -> L95
        L70:
            r14 = r3
        L71:
            if (r14 == 0) goto L8f
        L73:
            boolean r1 = r14.moveToNext()     // Catch: java.lang.Throwable -> L89
            if (r1 == 0) goto L8f
            int r1 = r14.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L89
            int r1 = r14.getInt(r1)     // Catch: java.lang.Throwable -> L89
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L89
            r2.add(r1)     // Catch: java.lang.Throwable -> L89
            goto L73
        L89:
            r0 = move-exception
            r12 = r0
            r0 = r14
            r14 = r12
            goto L97
        L8e:
            r14 = r3
        L8f:
            if (r14 == 0) goto L94
            r14.close()     // Catch: java.lang.Throwable -> L9d
        L94:
            return r2
        L95:
            r14 = move-exception
            r0 = r3
        L97:
            if (r0 == 0) goto L9c
            r0.close()     // Catch: java.lang.Throwable -> L9d
        L9c:
            throw r14     // Catch: java.lang.Throwable -> L9d
        L9d:
            r14 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r14, r13)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(com.facebook.internal.NativeProtocol$NativeAppInfo):java.util.TreeSet");
    }

    @k
    @r.e.a.e
    public static final Bundle getBridgeArgumentsFromIntent(@d Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            f0.p(intent, "intent");
            if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                return intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @k
    @r.e.a.e
    public static final UUID getCallIdFromIntent(@r.e.a.e Intent intent) {
        String stringExtra;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class) || intent == null) {
            return null;
        }
        try {
            if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                Bundle bundleExtra = intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
                stringExtra = bundleExtra != null ? bundleExtra.getString("action_id") : null;
            } else {
                stringExtra = intent.getStringExtra(EXTRA_PROTOCOL_CALL_ID);
            }
            if (stringExtra != null) {
                try {
                    return UUID.fromString(stringExtra);
                } catch (IllegalArgumentException unused) {
                    return null;
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @k
    @r.e.a.e
    public static final Bundle getErrorDataFromResultIntent(@d Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            f0.p(intent, "resultIntent");
            if (isErrorResult(intent)) {
                Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
                if (bridgeArgumentsFromIntent != null) {
                    return bridgeArgumentsFromIntent.getBundle("error");
                }
                return intent.getExtras();
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @k
    @r.e.a.e
    public static final FacebookException getExceptionFromErrorData(@r.e.a.e Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class) || bundle == null) {
            return null;
        }
        try {
            String string = bundle.getString("error_type");
            if (string == null) {
                string = bundle.getString(STATUS_ERROR_TYPE);
            }
            String string2 = bundle.getString(BRIDGE_ARG_ERROR_DESCRIPTION);
            if (string2 == null) {
                string2 = bundle.getString(STATUS_ERROR_DESCRIPTION);
            }
            if (string != null && n.u2.u.K1(string, ERROR_USER_CANCELED, true)) {
                return new FacebookOperationCanceledException(string2);
            }
            return new FacebookException(string2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @d
    @k
    public static final ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAction(@d String str, @d int[] iArr) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            f0.p(str, "action");
            f0.p(iArr, "versionSpec");
            List<NativeAppInfo> list = actionToAppInfoMap.get(str);
            if (list == null) {
                list = CollectionsKt__CollectionsKt.E();
            }
            return INSTANCE.getLatestAvailableProtocolVersionForAppInfoList(list, iArr);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    private final ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAppInfoList(List<? extends NativeAppInfo> list, int[] iArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            updateAllAvailableProtocolVersionsAsync();
            if (list == null) {
                return ProtocolVersionQueryResult.Companion.createEmpty();
            }
            for (NativeAppInfo nativeAppInfo : list) {
                int computeLatestAvailableVersionFromVersionSpec = computeLatestAvailableVersionFromVersionSpec(nativeAppInfo.getAvailableVersions(), getLatestKnownVersion(), iArr);
                if (computeLatestAvailableVersionFromVersionSpec != -1) {
                    return ProtocolVersionQueryResult.Companion.create(nativeAppInfo, computeLatestAvailableVersionFromVersionSpec);
                }
            }
            return ProtocolVersionQueryResult.Companion.createEmpty();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @k
    public static final int getLatestAvailableProtocolVersionForService(int i) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            return INSTANCE.getLatestAvailableProtocolVersionForAppInfoList(facebookAppInfoList, new int[]{i}).getProtocolVersion();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    public static final int getLatestKnownVersion() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            return KNOWN_PROTOCOL_VERSIONS[0].intValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    @k
    @r.e.a.e
    public static final Bundle getMethodArgumentsFromIntent(@d Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            f0.p(intent, "intent");
            if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                return intent.getExtras();
            }
            return intent.getBundleExtra(EXTRA_PROTOCOL_METHOD_ARGS);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @k
    public static final int getProtocolVersionFromIntent(@d Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            f0.p(intent, "intent");
            return intent.getIntExtra(EXTRA_PROTOCOL_VERSION, 0);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    @k
    @r.e.a.e
    public static final Bundle getSuccessResultsFromIntent(@d Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            f0.p(intent, "resultIntent");
            int protocolVersionFromIntent = getProtocolVersionFromIntent(intent);
            Bundle extras = intent.getExtras();
            if (isVersionCompatibleWithBucketedIntent(protocolVersionFromIntent) && extras != null) {
                return extras.getBundle(EXTRA_PROTOCOL_METHOD_RESULTS);
            }
            return extras;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @k
    public static final boolean isErrorResult(@d Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return false;
        }
        try {
            f0.p(intent, "resultIntent");
            Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
            if (bridgeArgumentsFromIntent != null) {
                return bridgeArgumentsFromIntent.containsKey("error");
            }
            return intent.hasExtra(STATUS_ERROR_TYPE);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return false;
        }
    }

    @k
    public static final boolean isVersionCompatibleWithBucketedIntent(int i) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return false;
        }
        try {
            return ArraysKt___ArraysKt.P7(KNOWN_PROTOCOL_VERSIONS, Integer.valueOf(i)) && i >= 20140701;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return false;
        }
    }

    @k
    public static final void setupProtocolRequestIntent(@d Intent intent, @r.e.a.e String str, @r.e.a.e String str2, int i, @r.e.a.e Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return;
        }
        try {
            f0.p(intent, "intent");
            String applicationId = FacebookSdk.getApplicationId();
            String applicationName = FacebookSdk.getApplicationName();
            intent.putExtra(EXTRA_PROTOCOL_VERSION, i).putExtra(EXTRA_PROTOCOL_ACTION, str2).putExtra(EXTRA_APPLICATION_ID, applicationId);
            if (isVersionCompatibleWithBucketedIntent(i)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("action_id", str);
                Utility.putNonEmptyString(bundle2, BRIDGE_ARG_APP_NAME_STRING, applicationName);
                intent.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
                if (bundle == null) {
                    bundle = new Bundle();
                }
                f0.o(intent.putExtra(EXTRA_PROTOCOL_METHOD_ARGS, bundle), "intent.putExtra(EXTRA_PR…OD_ARGS, methodArguments)");
                return;
            }
            intent.putExtra(EXTRA_PROTOCOL_CALL_ID, str);
            if (!Utility.isNullOrEmpty(applicationName)) {
                intent.putExtra(EXTRA_APPLICATION_NAME, applicationName);
            }
            if (bundle != null) {
                intent.putExtras(bundle);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
        }
    }

    @k
    public static final void updateAllAvailableProtocolVersionsAsync() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return;
        }
        try {
            if (protocolVersionsAsyncUpdating.compareAndSet(false, true)) {
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.NativeProtocol$updateAllAvailableProtocolVersionsAsync$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (CrashShieldHandler.isObjectCrashing(this)) {
                            return;
                        }
                        try {
                            for (NativeProtocol.NativeAppInfo nativeAppInfo : NativeProtocol.access$getFacebookAppInfoList$p(NativeProtocol.INSTANCE)) {
                                nativeAppInfo.fetchAvailableVersions(true);
                            }
                            NativeProtocol.access$getProtocolVersionsAsyncUpdating$p(NativeProtocol.INSTANCE).set(false);
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, this);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
        }
    }

    @k
    @r.e.a.e
    public static final Intent validateActivityIntent(@d Context context, @r.e.a.e Intent intent, @r.e.a.e NativeAppInfo nativeAppInfo) {
        ResolveInfo resolveActivity;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            f0.p(context, "context");
            if (intent == null || (resolveActivity = context.getPackageManager().resolveActivity(intent, 0)) == null) {
                return null;
            }
            String str = resolveActivity.activityInfo.packageName;
            f0.o(str, "resolveInfo.activityInfo.packageName");
            if (FacebookSignatureValidator.validateSignature(context, str)) {
                return intent;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @k
    @r.e.a.e
    public static final Intent validateServiceIntent(@d Context context, @r.e.a.e Intent intent, @r.e.a.e NativeAppInfo nativeAppInfo) {
        ResolveInfo resolveService;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            f0.p(context, "context");
            if (intent == null || (resolveService = context.getPackageManager().resolveService(intent, 0)) == null) {
                return null;
            }
            String str = resolveService.serviceInfo.packageName;
            f0.o(str, "resolveInfo.serviceInfo.packageName");
            if (FacebookSignatureValidator.validateSignature(context, str)) {
                return intent;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }
}
