package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import cn.com.custommma.mobile.tracking.viewability.webjs.DeviceMessage;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.alipay.sdk.packet.e;
import com.alipay.sdk.util.g;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest$Callback;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.common.time.Clock;
import com.facebook.common.util.UriUtil;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.internal.ShareConstants;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.opendevice.c;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import j.l.c.e0.a.a.b;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import n.b0;
import n.l2.k;
import n.l2.v.f0;
import n.l2.v.s0;
import n.u2.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import r.e.a.d;

/* compiled from: Utility.kt */
@b0(d1 = {"\u0000Î\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001:\bí\u0001î\u0001ï\u0001ð\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010)\u001a\u00020 \"\u0004\b\u0000\u0010*2\b\u0010+\u001a\u0004\u0018\u0001H*2\b\u0010,\u001a\u0004\u0018\u0001H*H\u0007¢\u0006\u0002\u0010-J7\u0010.\u001a\u0012\u0012\u0004\u0012\u0002H*0/j\b\u0012\u0004\u0012\u0002H*`0\"\u0004\b\u0000\u0010*2\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u0002H*02\"\u0002H*H\u0007¢\u0006\u0002\u00103J-\u00104\u001a\b\u0012\u0004\u0012\u0002H*05\"\u0004\b\u0000\u0010*2\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u0002H*02\"\u0002H*H\u0007¢\u0006\u0002\u00107J\u0012\u00108\u001a\u0004\u0018\u00010\u001a2\u0006\u00109\u001a\u00020\u0004H\u0007J&\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u00042\b\u0010=\u001a\u0004\u0018\u00010\u00042\b\u0010>\u001a\u0004\u0018\u00010?H\u0007J\b\u0010@\u001a\u00020AH\u0007J\u0018\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0004H\u0002J\u0010\u0010F\u001a\u00020A2\u0006\u0010C\u001a\u00020DH\u0007J\u0012\u0010G\u001a\u00020A2\b\u0010H\u001a\u0004\u0018\u00010IH\u0007J\u001e\u0010J\u001a\u0004\u0018\u00010\u00042\b\u0010K\u001a\u0004\u0018\u00010\u00042\b\u0010L\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010M\u001a\u00020\u00132\u0006\u0010N\u001a\u00020OH\u0002J\u0016\u0010P\u001a\b\u0012\u0004\u0012\u00020\u0004052\u0006\u0010Q\u001a\u00020RH\u0007J\u001c\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010T2\u0006\u0010U\u001a\u00020\u001aH\u0007J\u001c\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040T2\u0006\u0010U\u001a\u00020\u001aH\u0007J\u001a\u0010W\u001a\u00020\u00062\b\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010Z\u001a\u00020[H\u0007J\u0012\u0010\\\u001a\u00020A2\b\u0010]\u001a\u0004\u0018\u00010^H\u0007J\u0012\u0010_\u001a\u00020A2\b\u0010`\u001a\u0004\u0018\u00010aH\u0007J\b\u0010b\u001a\u00020 H\u0002J4\u0010c\u001a\n\u0012\u0004\u0012\u0002H*\u0018\u000105\"\u0004\b\u0000\u0010*2\u000e\u0010d\u001a\n\u0012\u0004\u0012\u0002H*\u0018\u0001052\f\u0010e\u001a\b\u0012\u0004\u0012\u0002H*0fH\u0007J\u0010\u0010g\u001a\u00020\u00042\u0006\u0010h\u001a\u00020\u0006H\u0007J\u0012\u0010i\u001a\u00020\u00042\b\u0010C\u001a\u0004\u0018\u00010DH\u0007J\u0010\u0010j\u001a\u00020\u00042\u0006\u0010C\u001a\u00020DH\u0007J\n\u0010k\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010l\u001a\u0004\u0018\u00010m2\b\u0010n\u001a\u0004\u0018\u00010?2\b\u0010o\u001a\u0004\u0018\u00010\u00042\u0006\u0010p\u001a\u00020mH\u0007J\u0010\u0010q\u001a\u00020\u00132\u0006\u0010r\u001a\u00020;H\u0007J\n\u0010s\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010t\u001a\u0004\u0018\u00010\u00042\b\u0010u\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010v\u001a\u00020w2\u0006\u00109\u001a\u00020\u0004H\u0002J\u0018\u0010x\u001a\u00020A2\u0006\u00109\u001a\u00020\u00042\u0006\u0010y\u001a\u00020zH\u0007J\u0012\u0010{\u001a\u00020\u00042\b\u0010C\u001a\u0004\u0018\u00010DH\u0007JF\u0010|\u001a\u0004\u0018\u00010}2\n\u0010~\u001a\u0006\u0012\u0002\b\u00030\u007f2\u0007\u0010\u0080\u0001\u001a\u00020\u00042\u001f\u0010\u0081\u0001\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u007f02\"\b\u0012\u0002\b\u0003\u0018\u00010\u007fH\u0007¢\u0006\u0003\u0010\u0082\u0001JC\u0010|\u001a\u0004\u0018\u00010}2\u0007\u0010\u0083\u0001\u001a\u00020\u00042\u0007\u0010\u0080\u0001\u001a\u00020\u00042\u001f\u0010\u0081\u0001\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u007f02\"\b\u0012\u0002\b\u0003\u0018\u00010\u007fH\u0007¢\u0006\u0003\u0010\u0084\u0001J\u0014\u0010\u0085\u0001\u001a\u00020\u00042\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0004H\u0002J(\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010U\u001a\u00020\u001a2\b\u0010o\u001a\u0004\u0018\u00010\u00042\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J\u0016\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010;H\u0007J\u0013\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0007\u0010\u008d\u0001\u001a\u00020\u001aH\u0007J\u001d\u0010\u008e\u0001\u001a\u00020 2\b\u0010+\u001a\u0004\u0018\u00010\u001a2\b\u0010,\u001a\u0004\u0018\u00010\u001aH\u0007J\u001c\u0010\u008f\u0001\u001a\u00020\u00042\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u0007\u0010N\u001a\u00030\u0092\u0001H\u0002J;\u0010\u0093\u0001\u001a\u0014\u0012\u0004\u0012\u0002H*0\u0094\u0001j\t\u0012\u0004\u0012\u0002H*`\u0095\u0001\"\u0004\b\u0000\u0010*2\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u0002H*02\"\u0002H*H\u0007¢\u0006\u0003\u0010\u0096\u0001J\u001d\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u0098\u0001\u001a\u00020\u00042\u0007\u0010N\u001a\u00030\u0092\u0001H\u0002J\u001c\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u0098\u0001\u001a\u00020\u00042\u0006\u0010o\u001a\u00020\u0004H\u0002J$\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00012\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00012\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0007J>\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00012\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00012\u0007\u0010\u009f\u0001\u001a\u00020}2\u0017\u0010 \u0001\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000102\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010¡\u0001J\u0011\u0010¢\u0001\u001a\u00020 2\u0006\u0010C\u001a\u00020DH\u0007J\u0011\u0010£\u0001\u001a\u00020 2\u0006\u0010C\u001a\u00020DH\u0007J\u0014\u0010¤\u0001\u001a\u00020 2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010;H\u0007J\u0015\u0010¥\u0001\u001a\u00020 2\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001H\u0007J\u0014\u0010¨\u0001\u001a\u00020 2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010;H\u0007J\u0013\u0010©\u0001\u001a\u00020 2\b\u0010K\u001a\u0004\u0018\u00010\u0004H\u0007J!\u0010©\u0001\u001a\u00020 \"\u0004\b\u0000\u0010*2\u0010\u0010ª\u0001\u001a\u000b\u0012\u0004\u0012\u0002H*\u0018\u00010«\u0001H\u0007J3\u0010¬\u0001\u001a\u00020 \"\u0004\b\u0000\u0010*2\u0010\u0010\u00ad\u0001\u001a\u000b\u0012\u0004\u0012\u0002H*\u0018\u00010«\u00012\u0010\u0010®\u0001\u001a\u000b\u0012\u0004\u0012\u0002H*\u0018\u00010«\u0001H\u0007J\u0014\u0010¯\u0001\u001a\u00020 2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010;H\u0007J\u0018\u0010°\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040±\u00012\u0006\u0010Q\u001a\u00020RH\u0007J\u0017\u0010²\u0001\u001a\b\u0012\u0004\u0012\u00020\u0004052\u0006\u0010Q\u001a\u00020RH\u0007J\u001e\u0010³\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040T2\u0007\u0010´\u0001\u001a\u00020\u0004H\u0007J'\u0010µ\u0001\u001a\u00020A2\t\u0010¶\u0001\u001a\u0004\u0018\u00010\u00042\u0011\u0010·\u0001\u001a\f\u0018\u00010¸\u0001j\u0005\u0018\u0001`¹\u0001H\u0007J\u001f\u0010µ\u0001\u001a\u00020A2\t\u0010¶\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010º\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J+\u0010µ\u0001\u001a\u00020A2\t\u0010¶\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010º\u0001\u001a\u0004\u0018\u00010\u00042\n\u0010»\u0001\u001a\u0005\u0018\u00010¼\u0001H\u0007JF\u0010½\u0001\u001a\u000b\u0012\u0005\u0012\u0003H¾\u0001\u0018\u000105\"\u0004\b\u0000\u0010*\"\u0005\b\u0001\u0010¾\u00012\u000e\u0010d\u001a\n\u0012\u0004\u0012\u0002H*\u0018\u0001052\u0015\u0010¿\u0001\u001a\u0010\u0012\u0004\u0012\u0002H*\u0012\u0005\u0012\u0003H¾\u00010À\u0001H\u0007J\"\u0010Á\u0001\u001a\u00020\u00042\u0017\u0010½\u0001\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040TH\u0007J\u0013\u0010Â\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010o\u001a\u00020\u0004H\u0007J\u0011\u0010Ã\u0001\u001a\u00020 2\u0006\u0010C\u001a\u00020DH\u0007J\u0014\u0010Ä\u0001\u001a\u00020?2\t\u0010Å\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J.\u0010Æ\u0001\u001a\u00020A2\u0006\u0010,\u001a\u00020?2\b\u0010o\u001a\u0004\u0018\u00010\u00042\u0011\u0010Ç\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u000105H\u0007J&\u0010È\u0001\u001a\u00020 2\u0006\u0010n\u001a\u00020?2\b\u0010o\u001a\u0004\u0018\u00010\u00042\t\u0010É\u0001\u001a\u0004\u0018\u00010\u0001H\u0007J&\u0010Ê\u0001\u001a\u00020A2\u0006\u0010,\u001a\u00020?2\b\u0010o\u001a\u0004\u0018\u00010\u00042\t\u0010É\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010Ë\u0001\u001a\u00020A2\u0006\u0010,\u001a\u00020?2\b\u0010o\u001a\u0004\u0018\u00010\u00042\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010;H\u0007J\u0013\u0010Ì\u0001\u001a\u00020\u00042\b\u0010X\u001a\u0004\u0018\u00010YH\u0007J%\u0010Í\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010T2\b\u0010Î\u0001\u001a\u00030Ï\u0001H\u0007J\t\u0010Ð\u0001\u001a\u00020AH\u0002J\t\u0010Ñ\u0001\u001a\u00020\u0006H\u0002J\u0012\u0010Ò\u0001\u001a\u00020A2\u0007\u0010Ó\u0001\u001a\u00020DH\u0002J\u0012\u0010Ô\u0001\u001a\u00020A2\u0007\u0010Ó\u0001\u001a\u00020DH\u0002J\t\u0010Õ\u0001\u001a\u00020AH\u0002J\t\u0010Ö\u0001\u001a\u00020AH\u0002J\u0015\u0010×\u0001\u001a\u00020A2\n\u0010Ø\u0001\u001a\u0005\u0018\u00010Ù\u0001H\u0007J\u001f\u0010Ú\u0001\u001a\u00020\u00042\t\u0010Û\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010Ü\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J2\u0010Ý\u0001\u001a\u00020A2\u0007\u0010Þ\u0001\u001a\u00020\u001a2\n\u0010ß\u0001\u001a\u0005\u0018\u00010à\u00012\t\u0010á\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010â\u0001\u001a\u00020 H\u0007J\u001b\u0010ã\u0001\u001a\u00020A2\u0007\u0010Þ\u0001\u001a\u00020\u001a2\u0007\u0010Ó\u0001\u001a\u00020DH\u0007J\u0014\u0010ä\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010N\u001a\u00030\u0092\u0001H\u0007J\u0013\u0010ä\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010o\u001a\u00020\u0004H\u0007J\u0016\u0010å\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010N\u001a\u0005\u0018\u00010\u0092\u0001H\u0007J\u0015\u0010å\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010o\u001a\u0004\u0018\u00010\u0004H\u0007J\u001d\u0010æ\u0001\u001a\u00020 2\b\u0010+\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010\u0004H\u0007J!\u0010ç\u0001\u001a\u0004\u0018\u00010R2\t\u0010Û\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010è\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J!\u0010é\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010Û\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010è\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J0\u0010ê\u0001\u001a\t\u0012\u0004\u0012\u0002H*0«\u0001\"\u0004\b\u0000\u0010*2\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u0002H*02\"\u0002H*H\u0007¢\u0006\u0003\u0010ë\u0001J.\u0010ì\u0001\u001a\u00020A2\b\u0010Î\u0001\u001a\u00030Ï\u00012\u0019\u0010½\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010TH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a8G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0002\u001a\u0004\b\u001f\u0010\"R\u0011\u0010#\u001a\u00020 8G¢\u0006\u0006\u001a\u0004\b#\u0010\"R\u000e\u0010$\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010%\u001a\u0004\u0018\u00010\u00168G¢\u0006\u0006\u001a\u0004\b&\u0010\u0018R\u000e\u0010'\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ñ\u0001"}, d2 = {"Lcom/facebook/internal/Utility;", "", "()V", "ARC_DEVICE_PATTERN", "", "DEFAULT_STREAM_BUFFER_SIZE", "", "EXTRA_APP_EVENTS_INFO_FORMAT_VERSION", "FACEBOOK_PROFILE_FIELDS", "HASH_ALGORITHM_MD5", "HASH_ALGORITHM_SHA1", "HASH_ALGORITHM_SHA256", "INSTAGRAM_PROFILE_FIELDS", "LOG_TAG", "NO_CARRIER", "REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS", "URL_SCHEME", "UTF8", "availableExternalStorageGB", "", "carrierName", "currentLocale", "Ljava/util/Locale;", "getCurrentLocale", "()Ljava/util/Locale;", "dataProcessingOptions", "Lorg/json/JSONObject;", "getDataProcessingOptions", "()Lorg/json/JSONObject;", "deviceTimeZoneName", "deviceTimezoneAbbreviation", "isAutoAppLinkSetup", "", "isAutoAppLinkSetup$annotations", "()Z", "isDataProcessingRestricted", "numCPUCores", "resourceLocale", "getResourceLocale", "timestampOfLastCheck", "totalExternalStorageGB", "areObjectsEqual", "T", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "arrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", DeviceMessage.JSON_TS, "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "asListNoNulls", "", "array", "([Ljava/lang/Object;)Ljava/util/List;", "awaitGetGraphMeRequestWithCache", "accessToken", "buildUri", "Landroid/net/Uri;", "authority", "path", "parameters", "Landroid/os/Bundle;", "clearCaches", "", "clearCookiesForDomain", "context", "Landroid/content/Context;", "domain", "clearFacebookCookies", "closeQuietly", "closeable", "Ljava/io/Closeable;", "coerceValueIfNullOrEmpty", "s", "valueIfNullOrEmpty", "convertBytesToGB", "bytes", "", "convertJSONArrayToList", "jsonArray", "Lorg/json/JSONArray;", "convertJSONObjectToHashMap", "", "jsonObject", "convertJSONObjectToStringMap", "copyAndCloseInputStream", "inputStream", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "deleteDirectory", "directoryOrFile", "Ljava/io/File;", "disconnectQuietly", "connection", "Ljava/net/URLConnection;", "externalStorageExists", "filter", "target", "predicate", "Lcom/facebook/internal/Utility$Predicate;", "generateRandomString", "length", "getActivityName", "getAppName", "getAppVersion", "getBundleLongAsDate", "Ljava/util/Date;", "bundle", SDKConstants.PARAM_KEY, "dateBase", "getContentSize", "contentUri", "getCurrentTokenDomainWithDefault", "getGraphDomainFromTokenDomain", "tokenGraphDomain", "getGraphMeRequestWithCache", "Lcom/facebook/GraphRequest;", "getGraphMeRequestWithCacheAsync", "callback", "Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "getMetadataApplicationId", "getMethodQuietly", "Ljava/lang/reflect/Method;", "clazz", "Ljava/lang/Class;", "methodName", "parameterTypes", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "className", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getProfileFieldsForGraphDomain", SDKConstants.PARAM_GRAPH_DOMAIN, "getStringPropertyAsJSON", "nonJSONPropertyKey", "getUriString", ShareConstants.MEDIA_URI, "handlePermissionResponse", "Lcom/facebook/internal/Utility$PermissionsLists;", "result", "hasSameId", "hashBytes", "hash", "Ljava/security/MessageDigest;", "", "hashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "([Ljava/lang/Object;)Ljava/util/HashSet;", "hashWithAlgorithm", "algorithm", "intersectRanges", "", "range1", "range2", "invokeMethodQuietly", "receiver", e.s, "args", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "isAutofillAvailable", "isChromeOS", "isContentUri", "isCurrentAccessToken", JThirdPlatFormInterface.KEY_TOKEN, "Lcom/facebook/AccessToken;", "isFileUri", "isNullOrEmpty", c.a, "", "isSubset", "subset", "superset", "isWebUri", "jsonArrayToSet", "", "jsonArrayToStringList", "jsonStrToMap", "str", "logd", "tag", com.huawei.hms.push.e.a, "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "t", "", "map", "K", "mapper", "Lcom/facebook/internal/Utility$Mapper;", "mapToJsonStr", "md5hash", "mustFixWindowParamsForAutofill", "parseUrlQueryString", "queryString", "putCommaSeparatedStringList", "list", "putJSONValueInBundle", SDKConstants.PARAM_VALUE, "putNonEmptyString", "putUri", "readStreamToString", "readStringMapFromParcel", "parcel", "Landroid/os/Parcel;", "refreshAvailableExternalStorage", "refreshBestGuessNumberOfCPUCores", "refreshCarrierName", "appContext", "refreshPeriodicExtendedDeviceInfo", "refreshTimezone", "refreshTotalExternalStorage", "runOnNonUiThread", "runnable", "Ljava/lang/Runnable;", "safeGetStringFromResponse", "response", "propertyName", "setAppEventAttributionParameters", "params", "attributionIdentifiers", "Lcom/facebook/internal/AttributionIdentifiers;", "anonymousAppDeviceGUID", "limitEventUsage", "setAppEventExtendedDeviceInfoParameters", "sha1hash", "sha256hash", "stringsEqualOrEmpty", "tryGetJSONArrayFromResponse", "propertyKey", "tryGetJSONObjectFromResponse", "unmodifiableCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "writeStringMapToParcel", "GraphMeRequestWithCacheCallback", "Mapper", "PermissionsLists", "Predicate", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class Utility {
    private static final String ARC_DEVICE_PATTERN = ".+_cheets|cheets_.+";
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
    private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a2";
    private static final String FACEBOOK_PROFILE_FIELDS = "id,name,first_name,middle_name,last_name";
    private static final String HASH_ALGORITHM_MD5 = "MD5";
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
    private static final String HASH_ALGORITHM_SHA256 = "SHA-256";
    private static final String INSTAGRAM_PROFILE_FIELDS = "id,name,profile_picture";
    @d
    public static final String LOG_TAG = "FacebookSDK";
    private static final int REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS = 1800000;
    private static final String URL_SCHEME = "https";
    private static final String UTF8 = "UTF-8";
    private static int numCPUCores;
    @d
    public static final Utility INSTANCE = new Utility();
    private static long timestampOfLastCheck = -1;
    private static long totalExternalStorageGB = -1;
    private static long availableExternalStorageGB = -1;
    private static String deviceTimezoneAbbreviation = "";
    private static String deviceTimeZoneName = "";
    private static final String NO_CARRIER = "NoCarrier";
    private static String carrierName = NO_CARRIER;

    /* compiled from: Utility.kt */
    @b0(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "", "onFailure", "", "error", "Lcom/facebook/FacebookException;", "onSuccess", "userInfo", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface GraphMeRequestWithCacheCallback {
        void onFailure(@r.e.a.e FacebookException facebookException);

        void onSuccess(@r.e.a.e JSONObject jSONObject);
    }

    /* compiled from: Utility.kt */
    @b0(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bæ\u0080\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/Utility$Mapper;", "T", "K", "", "apply", "item", "(Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface Mapper<T, K> {
        K apply(T t);
    }

    /* compiled from: Utility.kt */
    @b0(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0007R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/Utility$PermissionsLists;", "", "grantedPermissions", "", "", SDKConstants.PARAM_DECLINED_PERMISSIONS, SDKConstants.PARAM_EXPIRED_PERMISSIONS, "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDeclinedPermissions", "()Ljava/util/List;", "setDeclinedPermissions", "(Ljava/util/List;)V", "getExpiredPermissions", "setExpiredPermissions", "getGrantedPermissions", "setGrantedPermissions", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class PermissionsLists {
        @d
        private List<String> declinedPermissions;
        @d
        private List<String> expiredPermissions;
        @d
        private List<String> grantedPermissions;

        public PermissionsLists(@d List<String> list, @d List<String> list2, @d List<String> list3) {
            f0.p(list, "grantedPermissions");
            f0.p(list2, SDKConstants.PARAM_DECLINED_PERMISSIONS);
            f0.p(list3, SDKConstants.PARAM_EXPIRED_PERMISSIONS);
            this.grantedPermissions = list;
            this.declinedPermissions = list2;
            this.expiredPermissions = list3;
        }

        @d
        public final List<String> getDeclinedPermissions() {
            return this.declinedPermissions;
        }

        @d
        public final List<String> getExpiredPermissions() {
            return this.expiredPermissions;
        }

        @d
        public final List<String> getGrantedPermissions() {
            return this.grantedPermissions;
        }

        public final void setDeclinedPermissions(@d List<String> list) {
            f0.p(list, "<set-?>");
            this.declinedPermissions = list;
        }

        public final void setExpiredPermissions(@d List<String> list) {
            f0.p(list, "<set-?>");
            this.expiredPermissions = list;
        }

        public final void setGrantedPermissions(@d List<String> list) {
            f0.p(list, "<set-?>");
            this.grantedPermissions = list;
        }
    }

    /* compiled from: Utility.kt */
    @b0(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/Utility$Predicate;", "T", "", "apply", "", "item", "(Ljava/lang/Object;)Z", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface Predicate<T> {
        boolean apply(T t);
    }

    private Utility() {
    }

    @k
    public static final <T> boolean areObjectsEqual(@r.e.a.e T t, @r.e.a.e T t2) {
        if (t == null) {
            return t2 == null;
        }
        return f0.g(t, t2);
    }

    @d
    @k
    public static final <T> ArrayList<T> arrayList(@d T... tArr) {
        f0.p(tArr, DeviceMessage.JSON_TS);
        ArrayList<T> arrayList = new ArrayList<>(tArr.length);
        for (T t : tArr) {
            arrayList.add(t);
        }
        return arrayList;
    }

    @d
    @k
    public static final <T> List<T> asListNoNulls(@d T... tArr) {
        f0.p(tArr, "array");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @k
    @r.e.a.e
    public static final JSONObject awaitGetGraphMeRequestWithCache(@d String str) {
        f0.p(str, "accessToken");
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(str);
        if (profileInformation != null) {
            return profileInformation;
        }
        GraphResponse executeAndWait = INSTANCE.getGraphMeRequestWithCache(str).executeAndWait();
        if (executeAndWait.getError() != null) {
            return null;
        }
        return executeAndWait.getJsonObject();
    }

    @d
    @k
    public static final Uri buildUri(@r.e.a.e String str, @r.e.a.e String str2, @r.e.a.e Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str3, (String) obj);
                }
            }
        }
        Uri build = builder.build();
        f0.o(build, "builder.build()");
        return build;
    }

    @k
    public static final void clearCaches() {
        ImageDownloader.clearCache();
    }

    private final void clearCookiesForDomain(Context context, String str) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        String cookie = cookieManager.getCookie(str);
        if (cookie != null) {
            Object[] array = StringsKt__StringsKt.T4(cookie, new String[]{g.b}, false, 0, 6, (Object) null).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            for (String str2 : (String[]) array) {
                Object[] array2 = StringsKt__StringsKt.T4(str2, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null).toArray(new String[0]);
                Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                String[] strArr = (String[]) array2;
                if (strArr.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    String str3 = strArr[0];
                    int length = str3.length() - 1;
                    int i = 0;
                    boolean z = false;
                    while (i <= length) {
                        boolean z2 = f0.t(str3.charAt(!z ? i : length), 32) <= 0;
                        if (z) {
                            if (!z2) {
                                break;
                            }
                            length--;
                        } else if (z2) {
                            i++;
                        } else {
                            z = true;
                        }
                    }
                    sb.append(str3.subSequence(i, length + 1).toString());
                    sb.append("=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
                    cookieManager.setCookie(str, sb.toString());
                }
            }
            cookieManager.removeExpiredCookie();
        }
    }

    @k
    public static final void clearFacebookCookies(@d Context context) {
        f0.p(context, "context");
        Utility utility = INSTANCE;
        utility.clearCookiesForDomain(context, FacebookSdk.FACEBOOK_COM);
        utility.clearCookiesForDomain(context, ".facebook.com");
        utility.clearCookiesForDomain(context, "https://facebook.com");
        utility.clearCookiesForDomain(context, "https://.facebook.com");
    }

    @k
    public static final void closeQuietly(@r.e.a.e Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @k
    @r.e.a.e
    public static final String coerceValueIfNullOrEmpty(@r.e.a.e String str, @r.e.a.e String str2) {
        return isNullOrEmpty(str) ? str2 : str;
    }

    private final long convertBytesToGB(double d) {
        return Math.round(d / 1.073741824E9d);
    }

    @d
    @k
    public static final List<String> convertJSONArrayToList(@d JSONArray jSONArray) {
        f0.p(jSONArray, "jsonArray");
        try {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String string = jSONArray.getString(i);
                f0.o(string, "jsonArray.getString(i)");
                arrayList.add(string);
            }
            return arrayList;
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    @d
    @k
    public static final Map<String, Object> convertJSONObjectToHashMap(@d JSONObject jSONObject) {
        f0.p(jSONObject, "jsonObject");
        HashMap hashMap = new HashMap();
        JSONArray names = jSONObject.names();
        int length = names.length();
        for (int i = 0; i < length; i++) {
            try {
                String string = names.getString(i);
                f0.o(string, "keys.getString(i)");
                Object obj = jSONObject.get(string);
                if (obj instanceof JSONObject) {
                    obj = convertJSONObjectToHashMap((JSONObject) obj);
                }
                f0.o(obj, SDKConstants.PARAM_VALUE);
                hashMap.put(string, obj);
            } catch (JSONException unused) {
            }
        }
        return hashMap;
    }

    @d
    @k
    public static final Map<String, String> convertJSONObjectToStringMap(@d JSONObject jSONObject) {
        f0.p(jSONObject, "jsonObject");
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next);
            if (optString != null) {
                f0.o(next, SDKConstants.PARAM_KEY);
                hashMap.put(next, optString);
            }
        }
        return hashMap;
    }

    @k
    public static final int copyAndCloseInputStream(@r.e.a.e InputStream inputStream, @d OutputStream outputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        f0.p(outputStream, "outputStream");
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[8192];
            int i = 0;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                i += read;
            }
            bufferedInputStream.close();
            if (inputStream != null) {
                inputStream.close();
            }
            return i;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    @k
    public static final void deleteDirectory(@r.e.a.e File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                deleteDirectory(file2);
            }
        }
        file.delete();
    }

    @k
    public static final void disconnectQuietly(@r.e.a.e URLConnection uRLConnection) {
        if (uRLConnection == null || !(uRLConnection instanceof HttpURLConnection)) {
            return;
        }
        ((HttpURLConnection) uRLConnection).disconnect();
    }

    private final boolean externalStorageExists() {
        b.c();
        return f0.g("mounted", Environment.getExternalStorageState());
    }

    @k
    @r.e.a.e
    public static final <T> List<T> filter(@r.e.a.e List<? extends T> list, @d Predicate<T> predicate) {
        f0.p(predicate, "predicate");
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (predicate.apply(t)) {
                arrayList.add(t);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    @d
    @k
    public static final String generateRandomString(int i) {
        String bigInteger = new BigInteger(i * 5, new Random()).toString(32);
        f0.o(bigInteger, "BigInteger(length * 5, r).toString(32)");
        return bigInteger;
    }

    @d
    @k
    public static final String getActivityName(@r.e.a.e Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        String simpleName = context.getClass().getSimpleName();
        f0.o(simpleName, "context.javaClass.simpleName");
        return simpleName;
    }

    @d
    @k
    public static final String getAppName(@d Context context) {
        String string;
        f0.p(context, "context");
        try {
            String applicationName = FacebookSdk.getApplicationName();
            if (applicationName != null) {
                return applicationName;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            if (i == 0) {
                string = applicationInfo.nonLocalizedLabel.toString();
            } else {
                string = context.getString(i);
                f0.o(string, "context.getString(stringId)");
            }
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    @k
    @r.e.a.e
    public static final String getAppVersion() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        if (applicationContext != null) {
            try {
                PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
                if (packageInfo != null) {
                    return packageInfo.versionName;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    @k
    @r.e.a.e
    public static final Date getBundleLongAsDate(@r.e.a.e Bundle bundle, @r.e.a.e String str, @d Date date) {
        long parseLong;
        f0.p(date, "dateBase");
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            parseLong = ((Number) obj).longValue();
        } else {
            if (obj instanceof String) {
                try {
                    parseLong = Long.parseLong((String) obj);
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        if (parseLong == 0) {
            return new Date((long) Clock.MAX_TIME);
        }
        return new Date(date.getTime() + (parseLong * 1000));
    }

    @k
    public static final long getContentSize(@d Uri uri) {
        f0.p(uri, "contentUri");
        Cursor cursor = null;
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            f0.o(applicationContext, "FacebookSdk.getApplicationContext()");
            cursor = applicationContext.getContentResolver().query(uri, null, null, null, null);
            if (cursor == null) {
                return 0L;
            }
            int columnIndex = cursor.getColumnIndex("_size");
            cursor.moveToFirst();
            long j = cursor.getLong(columnIndex);
            cursor.close();
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @d
    @k
    public static final Locale getCurrentLocale() {
        Locale resourceLocale = getResourceLocale();
        if (resourceLocale != null) {
            return resourceLocale;
        }
        Locale locale = Locale.getDefault();
        f0.o(locale, "Locale.getDefault()");
        return locale;
    }

    private final String getCurrentTokenDomainWithDefault() {
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        return (currentAccessToken == null || currentAccessToken.getGraphDomain() == null) ? AccessToken.DEFAULT_GRAPH_DOMAIN : currentAccessToken.getGraphDomain();
    }

    @k
    @r.e.a.e
    public static final JSONObject getDataProcessingOptions() {
        if (CrashShieldHandler.isObjectCrashing(Utility.class)) {
            return null;
        }
        try {
            String string = FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.DATA_PROCESSING_OPTIONS_PREFERENCES, 0).getString(FacebookSdk.DATA_PROCESSION_OPTIONS, null);
            if (string != null) {
                try {
                    return new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Utility.class);
            return null;
        }
    }

    @k
    @r.e.a.e
    public static final String getGraphDomainFromTokenDomain(@r.e.a.e String str) {
        String facebookDomain = FacebookSdk.getFacebookDomain();
        if (str == null) {
            return facebookDomain;
        }
        int hashCode = str.hashCode();
        if (hashCode != -1253231569) {
            if (hashCode == 28903346 && str.equals(FacebookSdk.INSTAGRAM)) {
                f0.o(facebookDomain, "facebookDomain");
                return u.k2(facebookDomain, FacebookSdk.FACEBOOK_COM, FacebookSdk.INSTAGRAM_COM, false, 4, (Object) null);
            }
            return facebookDomain;
        } else if (str.equals(FacebookSdk.GAMING)) {
            f0.o(facebookDomain, "facebookDomain");
            return u.k2(facebookDomain, FacebookSdk.FACEBOOK_COM, FacebookSdk.FB_GG, false, 4, (Object) null);
        } else {
            return facebookDomain;
        }
    }

    private final GraphRequest getGraphMeRequestWithCache(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", getProfileFieldsForGraphDomain(getCurrentTokenDomainWithDefault()));
        bundle.putString("access_token", str);
        return new GraphRequest((AccessToken) null, "me", bundle, HttpMethod.GET, (GraphRequest$Callback) null, (String) null, 32, (n.l2.v.u) null);
    }

    @k
    public static final void getGraphMeRequestWithCacheAsync(@d final String str, @d final GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback) {
        f0.p(str, "accessToken");
        f0.p(graphMeRequestWithCacheCallback, "callback");
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(str);
        if (profileInformation != null) {
            graphMeRequestWithCacheCallback.onSuccess(profileInformation);
            return;
        }
        GraphRequest$Callback graphRequest$Callback = new GraphRequest$Callback() { // from class: com.facebook.internal.Utility$getGraphMeRequestWithCacheAsync$graphCallback$1
            @Override // com.facebook.GraphRequest$Callback
            public final void onCompleted(@d GraphResponse graphResponse) {
                f0.p(graphResponse, "response");
                if (graphResponse.getError() != null) {
                    graphMeRequestWithCacheCallback.onFailure(graphResponse.getError().getException());
                    return;
                }
                String str2 = str;
                JSONObject jsonObject = graphResponse.getJsonObject();
                if (jsonObject != null) {
                    ProfileInformationCache.putProfileInformation(str2, jsonObject);
                    graphMeRequestWithCacheCallback.onSuccess(graphResponse.getJsonObject());
                    return;
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
        };
        GraphRequest graphMeRequestWithCache = INSTANCE.getGraphMeRequestWithCache(str);
        graphMeRequestWithCache.setCallback(graphRequest$Callback);
        graphMeRequestWithCache.executeAsync();
    }

    @d
    @k
    public static final String getMetadataApplicationId(@r.e.a.e Context context) {
        Validate.notNull(context, "context");
        String applicationId = FacebookSdk.getApplicationId();
        f0.o(applicationId, "FacebookSdk.getApplicationId()");
        return applicationId;
    }

    @k
    @r.e.a.e
    public static final Method getMethodQuietly(@d Class<?> cls, @d String str, @d Class<?>... clsArr) {
        f0.p(cls, "clazz");
        f0.p(str, "methodName");
        f0.p(clsArr, "parameterTypes");
        try {
            return cls.getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final String getProfileFieldsForGraphDomain(String str) {
        return f0.g(str, FacebookSdk.INSTAGRAM) ? INSTAGRAM_PROFILE_FIELDS : FACEBOOK_PROFILE_FIELDS;
    }

    @k
    @r.e.a.e
    public static final Locale getResourceLocale() {
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            f0.o(applicationContext, "FacebookSdk.getApplicationContext()");
            Resources resources = applicationContext.getResources();
            f0.o(resources, "FacebookSdk.getApplicationContext().resources");
            return resources.getConfiguration().locale;
        } catch (Exception unused) {
            return null;
        }
    }

    @k
    @r.e.a.e
    public static final Object getStringPropertyAsJSON(@d JSONObject jSONObject, @r.e.a.e String str, @r.e.a.e String str2) throws JSONException {
        f0.p(jSONObject, "jsonObject");
        Object opt = jSONObject.opt(str);
        if (opt != null && (opt instanceof String)) {
            opt = new JSONTokener((String) opt).nextValue();
        }
        if (opt == null || (opt instanceof JSONObject) || (opt instanceof JSONArray)) {
            return opt;
        }
        if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, opt);
            return jSONObject2;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
    }

    @k
    @r.e.a.e
    public static final String getUriString(@r.e.a.e Uri uri) {
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    @d
    @k
    public static final PermissionsLists handlePermissionResponse(@d JSONObject jSONObject) throws JSONException {
        String optString;
        f0.p(jSONObject, "result");
        JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        ArrayList arrayList2 = new ArrayList(jSONArray.length());
        ArrayList arrayList3 = new ArrayList(jSONArray.length());
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            String optString2 = optJSONObject.optString("permission");
            if (optString2 != null && !f0.g(optString2, "installed") && (optString = optJSONObject.optString("status")) != null) {
                if (f0.g(optString, "granted")) {
                    arrayList.add(optString2);
                } else if (f0.g(optString, "declined")) {
                    arrayList2.add(optString2);
                } else if (f0.g(optString, "expired")) {
                    arrayList3.add(optString2);
                }
            }
        }
        return new PermissionsLists(arrayList, arrayList2, arrayList3);
    }

    @k
    public static final boolean hasSameId(@r.e.a.e JSONObject jSONObject, @r.e.a.e JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null || !jSONObject.has("id") || !jSONObject2.has("id")) {
            return false;
        }
        if (f0.g(jSONObject, jSONObject2)) {
            return true;
        }
        String optString = jSONObject.optString("id");
        String optString2 = jSONObject2.optString("id");
        if (optString == null || optString2 == null) {
            return false;
        }
        return f0.g(optString, optString2);
    }

    private final String hashBytes(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toHexString((b >> 4) & 15));
            sb.append(Integer.toHexString((b >> 0) & 15));
        }
        String sb2 = sb.toString();
        f0.o(sb2, "builder.toString()");
        return sb2;
    }

    @d
    @k
    public static final <T> HashSet<T> hashSet(@d T... tArr) {
        f0.p(tArr, DeviceMessage.JSON_TS);
        HashSet<T> hashSet = new HashSet<>(tArr.length);
        for (T t : tArr) {
            hashSet.add(t);
        }
        return hashSet;
    }

    private final String hashWithAlgorithm(String str, String str2) {
        Charset charset = n.u2.d.a;
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = str2.getBytes(charset);
        f0.o(bytes, "(this as java.lang.String).getBytes(charset)");
        return hashWithAlgorithm(str, bytes);
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x005c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x000e A[SYNTHETIC] */
    @n.l2.k
    @r.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int[] intersectRanges(@r.e.a.e int[] r10, @r.e.a.e int[] r11) {
        /*
            if (r10 != 0) goto L3
            return r11
        L3:
            if (r11 != 0) goto L6
            return r10
        L6:
            int r0 = r10.length
            int r1 = r11.length
            int r0 = r0 + r1
            int[] r0 = new int[r0]
            r1 = 0
            r2 = 0
            r3 = 0
        Le:
            int r4 = r10.length
            if (r1 >= r4) goto L68
            int r4 = r11.length
            if (r2 >= r4) goto L68
            r4 = r10[r1]
            r5 = r11[r2]
            int r6 = r10.length
            int r6 = r6 + (-1)
            r7 = 2147483647(0x7fffffff, float:NaN)
            if (r1 >= r6) goto L25
            int r6 = r1 + 1
            r6 = r10[r6]
            goto L28
        L25:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L28:
            int r8 = r11.length
            int r8 = r8 + (-1)
            if (r2 >= r8) goto L32
            int r8 = r2 + 1
            r8 = r11[r8]
            goto L35
        L32:
            r8 = 2147483647(0x7fffffff, float:NaN)
        L35:
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r4 >= r5) goto L48
            if (r6 <= r5) goto L45
            if (r6 <= r8) goto L41
            int r2 = r2 + 2
            r4 = r5
            goto L51
        L41:
            int r1 = r1 + 2
            r4 = r5
            goto L5a
        L45:
            int r1 = r1 + 2
            goto L55
        L48:
            if (r8 <= r4) goto L53
            if (r8 <= r6) goto L4f
            int r1 = r1 + 2
            goto L5a
        L4f:
            int r2 = r2 + 2
        L51:
            r6 = r8
            goto L5a
        L53:
            int r2 = r2 + 2
        L55:
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 2147483647(0x7fffffff, float:NaN)
        L5a:
            if (r4 == r9) goto Le
            int r5 = r3 + 1
            r0[r3] = r4
            if (r6 == r7) goto L67
            int r3 = r5 + 1
            r0[r5] = r6
            goto Le
        L67:
            r3 = r5
        L68:
            int[] r10 = java.util.Arrays.copyOf(r0, r3)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Utility.intersectRanges(int[], int[]):int[]");
    }

    @k
    @r.e.a.e
    public static final Object invokeMethodQuietly(@r.e.a.e Object obj, @d Method method, @d Object... objArr) {
        f0.p(method, e.s);
        f0.p(objArr, "args");
        try {
            return method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static final boolean isAutoAppLinkSetup() {
        try {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            s0 s0Var = s0.a;
            String format = String.format("fb%s://applinks", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
            f0.o(format, "java.lang.String.format(format, *args)");
            intent.setData(Uri.parse(format));
            Context applicationContext = FacebookSdk.getApplicationContext();
            f0.o(applicationContext, "ctx");
            PackageManager packageManager = applicationContext.getPackageManager();
            String packageName = applicationContext.getPackageName();
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)) {
                if (f0.g(packageName, resolveInfo.activityInfo.packageName)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @k
    public static /* synthetic */ void isAutoAppLinkSetup$annotations() {
    }

    @k
    public static final boolean isAutofillAvailable(@d Context context) {
        AutofillManager autofillManager;
        f0.p(context, "context");
        return Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class)) != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled();
    }

    @k
    public static final boolean isChromeOS(@d Context context) {
        f0.p(context, "context");
        if (Build.VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        String str = Build.DEVICE;
        if (str != null) {
            f0.o(str, "Build.DEVICE");
            if (new Regex(ARC_DEVICE_PATTERN).matches(str)) {
                return true;
            }
        }
        return false;
    }

    @k
    public static final boolean isContentUri(@r.e.a.e Uri uri) {
        return uri != null && u.K1("content", uri.getScheme(), true);
    }

    @k
    public static final boolean isCurrentAccessToken(@r.e.a.e AccessToken accessToken) {
        return accessToken != null && f0.g(accessToken, AccessToken.Companion.getCurrentAccessToken());
    }

    @k
    public static final boolean isDataProcessingRestricted() {
        if (CrashShieldHandler.isObjectCrashing(Utility.class)) {
            return false;
        }
        try {
            JSONObject dataProcessingOptions = getDataProcessingOptions();
            if (dataProcessingOptions != null) {
                try {
                    JSONArray jSONArray = dataProcessingOptions.getJSONArray(FacebookSdk.DATA_PROCESSION_OPTIONS);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        String string = jSONArray.getString(i);
                        f0.o(string, "options.getString(i)");
                        if (string != null) {
                            String lowerCase = string.toLowerCase();
                            f0.o(lowerCase, "(this as java.lang.String).toLowerCase()");
                            if (f0.g(lowerCase, "ldu")) {
                                return true;
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Utility.class);
            return false;
        }
    }

    @k
    public static final boolean isFileUri(@r.e.a.e Uri uri) {
        return uri != null && u.K1("file", uri.getScheme(), true);
    }

    @k
    public static final <T> boolean isNullOrEmpty(@r.e.a.e Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    @k
    public static final <T> boolean isSubset(@r.e.a.e Collection<? extends T> collection, @r.e.a.e Collection<? extends T> collection2) {
        if (collection2 == null || collection2.isEmpty()) {
            return collection == null || collection.isEmpty();
        }
        HashSet hashSet = new HashSet(collection2);
        if (collection != null) {
            for (T t : collection) {
                if (!hashSet.contains(t)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @k
    public static final boolean isWebUri(@r.e.a.e Uri uri) {
        return uri != null && (u.K1(UriUtil.HTTP_SCHEME, uri.getScheme(), true) || u.K1("https", uri.getScheme(), true) || u.K1("fbstaging", uri.getScheme(), true));
    }

    @d
    @k
    public static final Set<String> jsonArrayToSet(@d JSONArray jSONArray) throws JSONException {
        f0.p(jSONArray, "jsonArray");
        HashSet hashSet = new HashSet();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String string = jSONArray.getString(i);
            f0.o(string, "jsonArray.getString(i)");
            hashSet.add(string);
        }
        return hashSet;
    }

    @d
    @k
    public static final List<String> jsonArrayToStringList(@d JSONArray jSONArray) throws JSONException {
        f0.p(jSONArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    @d
    @k
    public static final Map<String, String> jsonStrToMap(@d String str) {
        f0.p(str, "str");
        if (str.length() == 0) {
            return new HashMap();
        }
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                f0.o(next, SDKConstants.PARAM_KEY);
                String string = jSONObject.getString(next);
                f0.o(string, "jsonObject.getString(key)");
                hashMap.put(next, string);
            }
            return hashMap;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    @k
    public static final void logd(@r.e.a.e String str, @r.e.a.e Exception exc) {
        if (!FacebookSdk.isDebugEnabled() || str == null || exc == null) {
            return;
        }
        Log.d(str, exc.getClass().getSimpleName() + ": " + exc.getMessage());
    }

    @k
    @r.e.a.e
    public static final <T, K> List<K> map(@r.e.a.e List<? extends T> list, @d Mapper<T, K> mapper) {
        f0.p(mapper, "mapper");
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            K apply = mapper.apply(t);
            if (apply != null) {
                arrayList.add(apply);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    @d
    @k
    public static final String mapToJsonStr(@d Map<String, String> map) {
        f0.p(map, "map");
        String str = "";
        if (!map.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                str = jSONObject.toString();
            } catch (JSONException unused) {
            }
            f0.o(str, "try {\n        val jsonOb…ion) {\n        \"\"\n      }");
        }
        return str;
    }

    @k
    @r.e.a.e
    public static final String md5hash(@d String str) {
        f0.p(str, SDKConstants.PARAM_KEY);
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_MD5, str);
    }

    @k
    public static final boolean mustFixWindowParamsForAutofill(@d Context context) {
        f0.p(context, "context");
        return isAutofillAvailable(context);
    }

    @d
    @k
    public static final Bundle parseUrlQueryString(@r.e.a.e String str) {
        Bundle bundle = new Bundle();
        if (!isNullOrEmpty(str)) {
            if (str != null) {
                Object[] array = StringsKt__StringsKt.T4(str, new String[]{"&"}, false, 0, 6, (Object) null).toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                for (String str2 : (String[]) array) {
                    Object[] array2 = StringsKt__StringsKt.T4(str2, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null).toArray(new String[0]);
                    Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                    String[] strArr = (String[]) array2;
                    try {
                        if (strArr.length == 2) {
                            bundle.putString(URLDecoder.decode(strArr[0], "UTF-8"), URLDecoder.decode(strArr[1], "UTF-8"));
                        } else if (strArr.length == 1) {
                            bundle.putString(URLDecoder.decode(strArr[0], "UTF-8"), "");
                        }
                    } catch (UnsupportedEncodingException e) {
                        logd(LOG_TAG, e);
                    }
                }
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        return bundle;
    }

    @k
    public static final void putCommaSeparatedStringList(@d Bundle bundle, @r.e.a.e String str, @r.e.a.e List<String> list) {
        f0.p(bundle, "b");
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (String str2 : list) {
                sb.append(str2);
                sb.append(",");
            }
            bundle.putString(str, sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "");
        }
    }

    @k
    public static final boolean putJSONValueInBundle(@d Bundle bundle, @r.e.a.e String str, @r.e.a.e Object obj) {
        f0.p(bundle, "bundle");
        if (obj == null) {
            bundle.remove(str);
            return true;
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return true;
        } else if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
            return true;
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Number) obj).doubleValue());
            return true;
        } else if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
            return true;
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Number) obj).intValue());
            return true;
        } else if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
            return true;
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Number) obj).longValue());
            return true;
        } else if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
            return true;
        } else if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return true;
        } else if (obj instanceof JSONArray) {
            bundle.putString(str, obj.toString());
            return true;
        } else if (obj instanceof JSONObject) {
            bundle.putString(str, obj.toString());
            return true;
        } else {
            return false;
        }
    }

    @k
    public static final void putNonEmptyString(@d Bundle bundle, @r.e.a.e String str, @r.e.a.e String str2) {
        f0.p(bundle, "b");
        if (isNullOrEmpty(str2)) {
            return;
        }
        bundle.putString(str, str2);
    }

    @k
    public static final void putUri(@d Bundle bundle, @r.e.a.e String str, @r.e.a.e Uri uri) {
        f0.p(bundle, "b");
        if (uri != null) {
            putNonEmptyString(bundle, str, uri.toString());
        }
    }

    @d
    @k
    public static final String readStreamToString(@r.e.a.e InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        InputStreamReader inputStreamReader;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
            }
        } catch (Throwable th3) {
            bufferedInputStream = null;
            th = th3;
            inputStreamReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[2048];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read != -1) {
                    sb.append(cArr, 0, read);
                } else {
                    String sb2 = sb.toString();
                    f0.o(sb2, "stringBuilder.toString()");
                    closeQuietly(bufferedInputStream);
                    closeQuietly(inputStreamReader);
                    return sb2;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            closeQuietly(bufferedInputStream);
            closeQuietly(inputStreamReader);
            throw th;
        }
    }

    @k
    @r.e.a.e
    public static final Map<String, String> readStringMapFromParcel(@d Parcel parcel) {
        f0.p(parcel, "parcel");
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < readInt; i++) {
            hashMap.put(parcel.readString(), parcel.readString());
        }
        return hashMap;
    }

    private final void refreshAvailableExternalStorage() {
        try {
            if (externalStorageExists()) {
                b.a();
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                f0.o(externalStorageDirectory, "path");
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                availableExternalStorageGB = statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            availableExternalStorageGB = convertBytesToGB(availableExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    private final int refreshBestGuessNumberOfCPUCores() {
        int i = numCPUCores;
        if (i > 0) {
            return i;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FilenameFilter() { // from class: com.facebook.internal.Utility$refreshBestGuessNumberOfCPUCores$cpuFiles$1
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str) {
                    return Pattern.matches("cpu[0-9]+", str);
                }
            });
            if (listFiles != null) {
                numCPUCores = listFiles.length;
            }
        } catch (Exception unused) {
        }
        if (numCPUCores <= 0) {
            numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return numCPUCores;
    }

    private final void refreshCarrierName(Context context) {
        if (f0.g(carrierName, NO_CARRIER)) {
            try {
                Object systemService = context.getSystemService("phone");
                if (systemService != null) {
                    String networkOperatorName = ((TelephonyManager) systemService).getNetworkOperatorName();
                    f0.o(networkOperatorName, "telephonyManager.networkOperatorName");
                    carrierName = networkOperatorName;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
            } catch (Exception unused) {
            }
        }
    }

    private final void refreshPeriodicExtendedDeviceInfo(Context context) {
        if (timestampOfLastCheck == -1 || System.currentTimeMillis() - timestampOfLastCheck >= ((long) REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS)) {
            timestampOfLastCheck = System.currentTimeMillis();
            refreshTimezone();
            refreshCarrierName(context);
            refreshTotalExternalStorage();
            refreshAvailableExternalStorage();
        }
    }

    private final void refreshTimezone() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            String displayName = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            f0.o(displayName, "tz.getDisplayName(tz.inD…(Date()), TimeZone.SHORT)");
            deviceTimezoneAbbreviation = displayName;
            f0.o(timeZone, "tz");
            String id = timeZone.getID();
            f0.o(id, "tz.id");
            deviceTimeZoneName = id;
        } catch (AssertionError | Exception unused) {
        }
    }

    private final void refreshTotalExternalStorage() {
        try {
            if (externalStorageExists()) {
                b.a();
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                f0.o(externalStorageDirectory, "path");
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                totalExternalStorageGB = statFs.getBlockCount() * statFs.getBlockSize();
            }
            totalExternalStorageGB = convertBytesToGB(totalExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    @k
    public static final void runOnNonUiThread(@r.e.a.e Runnable runnable) {
        try {
            FacebookSdk.getExecutor().execute(runnable);
        } catch (Exception unused) {
        }
    }

    @d
    @k
    public static final String safeGetStringFromResponse(@r.e.a.e JSONObject jSONObject, @r.e.a.e String str) {
        if (jSONObject != null) {
            String optString = jSONObject.optString(str, "");
            f0.o(optString, "response.optString(propertyName, \"\")");
            return optString;
        }
        return "";
    }

    @k
    public static final void setAppEventAttributionParameters(@d JSONObject jSONObject, @r.e.a.e AttributionIdentifiers attributionIdentifiers, @r.e.a.e String str, boolean z) throws JSONException {
        f0.p(jSONObject, "params");
        jSONObject.put("anon_id", str);
        jSONObject.put("application_tracking_enabled", !z);
        jSONObject.put("advertiser_id_collection_enabled", FacebookSdk.getAdvertiserIDCollectionEnabled());
        if (attributionIdentifiers != null) {
            if (attributionIdentifiers.getAttributionId() != null) {
                jSONObject.put("attribution", attributionIdentifiers.getAttributionId());
            }
            if (attributionIdentifiers.getAndroidAdvertiserId() != null) {
                jSONObject.put("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
                jSONObject.put("advertiser_tracking_enabled", !attributionIdentifiers.isTrackingLimited());
            }
            if (!attributionIdentifiers.isTrackingLimited()) {
                String allHashedUserData = UserDataStore.getAllHashedUserData();
                if (!(allHashedUserData.length() == 0)) {
                    jSONObject.put("ud", allHashedUserData);
                }
            }
            if (attributionIdentifiers.getAndroidInstallerPackage() != null) {
                jSONObject.put("installer_package", attributionIdentifiers.getAndroidInstallerPackage());
            }
        }
    }

    @k
    public static final void setAppEventExtendedDeviceInfoParameters(@d JSONObject jSONObject, @d Context context) throws JSONException {
        String str;
        Locale locale;
        int i;
        Display display;
        PackageInfo packageInfo;
        f0.p(jSONObject, "params");
        f0.p(context, "appContext");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(EXTRA_APP_EVENTS_INFO_FORMAT_VERSION);
        INSTANCE.refreshPeriodicExtendedDeviceInfo(context);
        String packageName = context.getPackageName();
        int i2 = 0;
        int i3 = -1;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            str = "";
        }
        if (packageInfo != null) {
            i3 = packageInfo.versionCode;
            str = packageInfo.versionName;
            jSONArray.put(packageName);
            jSONArray.put(i3);
            jSONArray.put(str);
            jSONArray.put(Build.VERSION.RELEASE);
            jSONArray.put(Build.MODEL);
            try {
                Resources resources = context.getResources();
                f0.o(resources, "appContext.resources");
                locale = resources.getConfiguration().locale;
            } catch (Exception unused2) {
                locale = Locale.getDefault();
            }
            StringBuilder sb = new StringBuilder();
            f0.o(locale, "locale");
            sb.append(locale.getLanguage());
            sb.append("_");
            sb.append(locale.getCountry());
            jSONArray.put(sb.toString());
            jSONArray.put(deviceTimezoneAbbreviation);
            jSONArray.put(carrierName);
            double d = 0.0d;
            try {
                display = null;
                if (Build.VERSION.SDK_INT >= 17) {
                    Object systemService = context.getSystemService("display");
                    if (!(systemService instanceof DisplayManager)) {
                        systemService = null;
                    }
                    DisplayManager displayManager = (DisplayManager) systemService;
                    if (displayManager != null) {
                        display = displayManager.getDisplay(0);
                    }
                } else {
                    Object systemService2 = context.getSystemService("window");
                    if (!(systemService2 instanceof WindowManager)) {
                        systemService2 = null;
                    }
                    WindowManager windowManager = (WindowManager) systemService2;
                    if (windowManager != null) {
                        display = windowManager.getDefaultDisplay();
                    }
                }
            } catch (Exception unused3) {
            }
            if (display != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                display.getMetrics(displayMetrics);
                int i4 = displayMetrics.widthPixels;
                try {
                    int i5 = displayMetrics.heightPixels;
                    try {
                        d = displayMetrics.density;
                    } catch (Exception unused4) {
                    }
                    i = i5;
                    i2 = i4;
                } catch (Exception unused5) {
                    i2 = i4;
                }
                jSONArray.put(i2);
                jSONArray.put(i);
                jSONArray.put(new DecimalFormat("#.##").format(d));
                jSONArray.put(INSTANCE.refreshBestGuessNumberOfCPUCores());
                jSONArray.put(totalExternalStorageGB);
                jSONArray.put(availableExternalStorageGB);
                jSONArray.put(deviceTimeZoneName);
                jSONObject.put(Constants.EXTINFO, jSONArray.toString());
            }
            i = 0;
            jSONArray.put(i2);
            jSONArray.put(i);
            jSONArray.put(new DecimalFormat("#.##").format(d));
            jSONArray.put(INSTANCE.refreshBestGuessNumberOfCPUCores());
            jSONArray.put(totalExternalStorageGB);
            jSONArray.put(availableExternalStorageGB);
            jSONArray.put(deviceTimeZoneName);
            jSONObject.put(Constants.EXTINFO, jSONArray.toString());
        }
    }

    @k
    @r.e.a.e
    public static final String sha1hash(@d String str) {
        f0.p(str, SDKConstants.PARAM_KEY);
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_SHA1, str);
    }

    @k
    @r.e.a.e
    public static final String sha256hash(@r.e.a.e String str) {
        if (str == null) {
            return null;
        }
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_SHA256, str);
    }

    @k
    public static final boolean stringsEqualOrEmpty(@r.e.a.e String str, @r.e.a.e String str2) {
        boolean z = str == null || str.length() == 0;
        boolean z2 = str2 == null || str2.length() == 0;
        if (z && z2) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return f0.g(str, str2);
    }

    @k
    @r.e.a.e
    public static final JSONArray tryGetJSONArrayFromResponse(@r.e.a.e JSONObject jSONObject, @r.e.a.e String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONArray(str);
        }
        return null;
    }

    @k
    @r.e.a.e
    public static final JSONObject tryGetJSONObjectFromResponse(@r.e.a.e JSONObject jSONObject, @r.e.a.e String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    @d
    @k
    public static final <T> Collection<T> unmodifiableCollection(@d T... tArr) {
        f0.p(tArr, DeviceMessage.JSON_TS);
        Collection<T> unmodifiableCollection = Collections.unmodifiableCollection(Arrays.asList(Arrays.copyOf(tArr, tArr.length)));
        f0.o(unmodifiableCollection, "Collections.unmodifiable…ction(Arrays.asList(*ts))");
        return unmodifiableCollection;
    }

    @k
    public static final void writeStringMapToParcel(@d Parcel parcel, @r.e.a.e Map<String, String> map) {
        f0.p(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }

    @k
    @r.e.a.e
    public static final Method getMethodQuietly(@d String str, @d String str2, @d Class<?>... clsArr) {
        f0.p(str, "className");
        f0.p(str2, "methodName");
        f0.p(clsArr, "parameterTypes");
        try {
            Class<?> cls = Class.forName(str);
            f0.o(cls, "Class.forName(className)");
            return getMethodQuietly(cls, str2, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private final String hashWithAlgorithm(String str, byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            f0.o(messageDigest, "hash");
            return hashBytes(messageDigest, bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    @k
    public static final boolean isNullOrEmpty(@r.e.a.e String str) {
        if (str != null) {
            if (!(str.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    @k
    @r.e.a.e
    public static final String sha1hash(@d byte[] bArr) {
        f0.p(bArr, "bytes");
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_SHA1, bArr);
    }

    @k
    @r.e.a.e
    public static final String sha256hash(@r.e.a.e byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_SHA256, bArr);
    }

    @k
    public static final void logd(@r.e.a.e String str, @r.e.a.e String str2) {
        if (!FacebookSdk.isDebugEnabled() || str == null || str2 == null) {
            return;
        }
        Log.d(str, str2);
    }

    @k
    public static final void logd(@r.e.a.e String str, @r.e.a.e String str2, @r.e.a.e Throwable th) {
        if (!FacebookSdk.isDebugEnabled() || isNullOrEmpty(str)) {
            return;
        }
        Log.d(str, str2, th);
    }
}
