package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.alibaba.fastjson.asm.Label;
import com.facebook.GraphRequestBatch;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.text.Regex;
import n.b0;
import n.l2.k;
import n.l2.v.f0;
import n.l2.v.s0;
import n.u2.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r.e.a.d;
import r.e.a.e;

/* compiled from: GraphRequest.kt */
@b0(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0007J\u0016\u0010A\u001a\b\u0012\u0004\u0012\u00020>0B2\u0006\u0010C\u001a\u00020DH\u0007J'\u0010A\u001a\b\u0012\u0004\u0012\u00020>0B2\u0012\u0010C\u001a\n\u0012\u0006\b\u0001\u0012\u00020@0E\"\u00020@H\u0007¢\u0006\u0002\u0010FJ\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020>0B2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020@0GH\u0007J\u0010\u0010H\u001a\u00020I2\u0006\u0010C\u001a\u00020DH\u0007J!\u0010H\u001a\u00020I2\u0012\u0010C\u001a\n\u0012\u0006\b\u0001\u0012\u00020@0E\"\u00020@H\u0007¢\u0006\u0002\u0010JJ\u0016\u0010H\u001a\u00020I2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020@0GH\u0007J\u001e\u0010K\u001a\b\u0012\u0004\u0012\u00020>0B2\u0006\u0010L\u001a\u00020:2\u0006\u0010C\u001a\u00020DH\u0007J$\u0010K\u001a\b\u0012\u0004\u0012\u00020>0B2\u0006\u0010L\u001a\u00020:2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020@0GH\u0007J\"\u0010M\u001a\u00020I2\b\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010L\u001a\u00020:2\u0006\u0010C\u001a\u00020DH\u0007J\u0018\u0010M\u001a\u00020I2\u0006\u0010L\u001a\u00020:2\u0006\u0010C\u001a\u00020DH\u0007J\u0010\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020DH\u0002J\n\u0010R\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010S\u001a\u00020\u00042\b\u0010T\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010U\u001a\u00020V2\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010W\u001a\u00020V2\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010X\u001a\u00020V2\u0006\u0010Y\u001a\u00020\u0004H\u0002J\u0012\u0010Z\u001a\u00020V2\b\u0010[\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010\\\u001a\u00020V2\b\u0010[\u001a\u0004\u0018\u00010\u0001H\u0002J$\u0010]\u001a\u00020@2\b\u0010^\u001a\u0004\u0018\u00010_2\u0006\u0010`\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010cH\u0007J.\u0010]\u001a\u00020@2\b\u0010^\u001a\u0004\u0018\u00010_2\u0006\u0010`\u001a\u00020a2\b\u0010d\u001a\u0004\u0018\u00010\u00042\b\u0010b\u001a\u0004\u0018\u00010cH\u0007J&\u0010e\u001a\u00020@2\b\u0010^\u001a\u0004\u0018\u00010_2\b\u0010f\u001a\u0004\u0018\u00010\u00042\b\u0010b\u001a\u0004\u0018\u00010cH\u0007J&\u0010g\u001a\u00020@2\b\u0010^\u001a\u0004\u0018\u00010_2\b\u0010T\u001a\u0004\u0018\u00010\u00042\b\u0010b\u001a\u0004\u0018\u00010cH\u0007J\u001c\u0010h\u001a\u00020@2\b\u0010^\u001a\u0004\u0018\u00010_2\b\u0010b\u001a\u0004\u0018\u00010iH\u0007J\u001c\u0010j\u001a\u00020@2\b\u0010^\u001a\u0004\u0018\u00010_2\b\u0010b\u001a\u0004\u0018\u00010kH\u0007J@\u0010l\u001a\u00020@2\b\u0010^\u001a\u0004\u0018\u00010_2\b\u0010m\u001a\u0004\u0018\u00010n2\u0006\u0010o\u001a\u00020 2\u0006\u0010p\u001a\u00020 2\b\u0010q\u001a\u0004\u0018\u00010\u00042\b\u0010b\u001a\u0004\u0018\u00010kH\u0007J0\u0010r\u001a\u00020@2\b\u0010^\u001a\u0004\u0018\u00010_2\b\u0010T\u001a\u0004\u0018\u00010\u00042\b\u0010s\u001a\u0004\u0018\u00010t2\b\u0010b\u001a\u0004\u0018\u00010cH\u0007JD\u0010u\u001a\u00020@2\b\u0010^\u001a\u0004\u0018\u00010_2\b\u0010T\u001a\u0004\u0018\u00010\u00042\b\u0010v\u001a\u0004\u0018\u00010w2\b\u0010x\u001a\u0004\u0018\u00010\u00042\b\u0010y\u001a\u0004\u0018\u00010z2\b\u0010b\u001a\u0004\u0018\u00010cH\u0007JB\u0010u\u001a\u00020@2\b\u0010^\u001a\u0004\u0018\u00010_2\b\u0010T\u001a\u0004\u0018\u00010\u00042\u0006\u0010{\u001a\u00020|2\b\u0010x\u001a\u0004\u0018\u00010\u00042\b\u0010y\u001a\u0004\u0018\u00010z2\b\u0010b\u001a\u0004\u0018\u00010cH\u0007JD\u0010u\u001a\u00020@2\b\u0010^\u001a\u0004\u0018\u00010_2\b\u0010T\u001a\u0004\u0018\u00010\u00042\b\u0010}\u001a\u0004\u0018\u00010~2\b\u0010x\u001a\u0004\u0018\u00010\u00042\b\u0010y\u001a\u0004\u0018\u00010z2\b\u0010b\u001a\u0004\u0018\u00010cH\u0007J\u0012\u0010\u007f\u001a\u00020\u00042\b\u0010[\u001a\u0004\u0018\u00010\u0001H\u0002J$\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0006\u0010s\u001a\u00020t2\u0006\u0010Y\u001a\u00020\u00042\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J.\u0010\u0084\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u00042\u0006\u0010[\u001a\u00020\u00012\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0086\u0001\u001a\u00020VH\u0002JB\u0010\u0087\u0001\u001a\u00030\u0081\u00012\u0006\u0010C\u001a\u00020D2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u00012\u0007\u0010\u008a\u0001\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0007\u0010\u008d\u0001\u001a\u00020VH\u0002J'\u0010\u008e\u0001\u001a\u00030\u0081\u00012\u0006\u0010C\u001a\u00020D2\r\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020>0BH\u0001¢\u0006\u0003\b\u0090\u0001J+\u0010\u0091\u0001\u001a\u00030\u0081\u00012\u0015\u0010\u0092\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030\u0094\u00010\u0093\u00012\b\u0010\u0082\u0001\u001a\u00030\u0095\u0001H\u0002J%\u0010\u0096\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0097\u0001\u001a\u00020z2\b\u0010\u0082\u0001\u001a\u00030\u0095\u00012\u0006\u0010?\u001a\u00020@H\u0002J9\u0010\u0098\u0001\u001a\u00030\u0081\u00012\b\u0010\u0082\u0001\u001a\u00030\u0095\u00012\f\u0010C\u001a\b\u0012\u0004\u0012\u00020@0G2\u0015\u0010\u0092\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030\u0094\u00010\u0099\u0001H\u0002J \u0010\u009a\u0001\u001a\u00030\u0081\u00012\u0006\u0010C\u001a\u00020D2\u0006\u0010L\u001a\u00020:H\u0001¢\u0006\u0003\b\u009b\u0001J\u001b\u0010\u009c\u0001\u001a\u00030\u0081\u00012\u0006\u0010L\u001a\u00020:2\u0007\u0010\u008d\u0001\u001a\u00020VH\u0002J\u0014\u0010\u009d\u0001\u001a\u00030\u0081\u00012\b\u0010d\u001a\u0004\u0018\u00010\u0004H\u0007J\u0017\u0010\u009e\u0001\u001a\u00020V2\u0006\u0010?\u001a\u00020@H\u0001¢\u0006\u0003\b\u009f\u0001J\u0011\u0010 \u0001\u001a\u00020:2\u0006\u0010C\u001a\u00020DH\u0007J#\u0010 \u0001\u001a\u00020:2\u0012\u0010C\u001a\n\u0012\u0006\b\u0001\u0012\u00020@0E\"\u00020@H\u0007¢\u0006\u0003\u0010¡\u0001J\u0017\u0010 \u0001\u001a\u00020:2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020@0GH\u0007J\u0018\u0010¢\u0001\u001a\u00030\u0081\u00012\u0006\u0010C\u001a\u00020DH\u0001¢\u0006\u0003\b£\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b*\u0010\u0002R\u000e\u0010+\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u001e\u00102\u001a\u0004\u0018\u00010\u00048BX\u0082\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00101\"\u0004\b4\u00105R\u0016\u00106\u001a\n 8*\u0004\u0018\u00010707X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¤\u0001"}, d2 = {"Lcom/facebook/GraphRequest$Companion;", "", "()V", "ACCEPT_LANGUAGE_HEADER", "", "ACCESS_TOKEN_PARAM", "ATTACHED_FILES_PARAM", "ATTACHMENT_FILENAME_PREFIX", "BATCH_APP_ID_PARAM", "BATCH_BODY_PARAM", "BATCH_ENTRY_DEPENDS_ON_PARAM", "BATCH_ENTRY_NAME_PARAM", "BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM", "BATCH_METHOD_PARAM", "BATCH_PARAM", "BATCH_RELATIVE_URL_PARAM", "CAPTION_PARAM", "CONTENT_ENCODING_HEADER", "CONTENT_TYPE_HEADER", "DEBUG_KEY", "DEBUG_MESSAGES_KEY", "DEBUG_MESSAGE_KEY", "DEBUG_MESSAGE_LINK_KEY", "DEBUG_MESSAGE_TYPE_KEY", "DEBUG_PARAM", "DEBUG_SEVERITY_INFO", "DEBUG_SEVERITY_WARNING", "FIELDS_PARAM", "FORMAT_JSON", "FORMAT_PARAM", "ISO_8601_FORMAT_STRING", "MAXIMUM_BATCH_SIZE", "", "ME", "MIME_BOUNDARY", "MY_FRIENDS", "MY_PHOTOS", "PICTURE_PARAM", "SDK_ANDROID", "SDK_PARAM", ViewHierarchyConstants.SEARCH, "TAG", "getTAG$facebook_core_release$annotations", "USER_AGENT_BASE", "USER_AGENT_HEADER", "VIDEOS_SUFFIX", "defaultBatchApplicationId", "mimeContentType", "getMimeContentType", "()Ljava/lang/String;", "userAgent", "getUserAgent", "setUserAgent", "(Ljava/lang/String;)V", "versionPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "createConnection", "Ljava/net/HttpURLConnection;", "url", "Ljava/net/URL;", "executeAndWait", "Lcom/facebook/GraphResponse;", "request", "Lcom/facebook/GraphRequest;", "executeBatchAndWait", "", "requests", "Lcom/facebook/GraphRequestBatch;", "", "([Lcom/facebook/GraphRequest;)Ljava/util/List;", "", "executeBatchAsync", "Lcom/facebook/GraphRequestAsyncTask;", "([Lcom/facebook/GraphRequest;)Lcom/facebook/GraphRequestAsyncTask;", "executeConnectionAndWait", "connection", "executeConnectionAsync", "callbackHandler", "Landroid/os/Handler;", "getBatchAppId", "batch", "getDefaultBatchApplicationId", "getDefaultPhotoPathIfNull", "graphPath", "hasOnProgressCallbacks", "", "isGzipCompressible", "isMeRequest", "path", "isSupportedAttachmentType", SDKConstants.PARAM_VALUE, "isSupportedParameterType", "newCustomAudienceThirdPartyIdRequest", "accessToken", "Lcom/facebook/AccessToken;", "context", "Landroid/content/Context;", "callback", "Lcom/facebook/GraphRequest$Callback;", "applicationId", "newDeleteObjectRequest", "id", "newGraphPathRequest", "newMeRequest", "Lcom/facebook/GraphRequest$GraphJSONObjectCallback;", "newMyFriendsRequest", "Lcom/facebook/GraphRequest$GraphJSONArrayCallback;", "newPlacesSearchRequest", "location", "Landroid/location/Location;", "radiusInMeters", "resultsLimit", "searchText", "newPostRequest", "graphObject", "Lorg/json/JSONObject;", "newUploadPhotoRequest", "image", "Landroid/graphics/Bitmap;", ShareConstants.FEED_CAPTION_PARAM, "params", "Landroid/os/Bundle;", "photoUri", "Landroid/net/Uri;", "file", "Ljava/io/File;", "parameterToString", "processGraphObject", "", "serializer", "Lcom/facebook/GraphRequest$KeyValueSerializer;", "processGraphObjectProperty", SDKConstants.PARAM_KEY, "passByValue", "processRequest", "logger", "Lcom/facebook/internal/Logger;", "numRequests", "outputStream", "Ljava/io/OutputStream;", "shouldUseGzip", "runCallbacks", "responses", "runCallbacks$facebook_core_release", "serializeAttachments", "attachments", "", "Lcom/facebook/GraphRequest$Attachment;", "Lcom/facebook/GraphRequest$Serializer;", "serializeParameters", "bundle", "serializeRequestsAsJSON", "", "serializeToUrlConnection", "serializeToUrlConnection$facebook_core_release", "setConnectionContentType", "setDefaultBatchApplicationId", "shouldWarnOnMissingFieldsParam", "shouldWarnOnMissingFieldsParam$facebook_core_release", "toHttpConnection", "([Lcom/facebook/GraphRequest;)Ljava/net/HttpURLConnection;", "validateFieldsParamForGetRequests", "validateFieldsParamForGetRequests$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class GraphRequest$Companion {
    private GraphRequest$Companion() {
    }

    private final HttpURLConnection createConnection(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        Objects.requireNonNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setRequestProperty("User-Agent", getUserAgent());
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
        httpURLConnection.setChunkedStreamingMode(0);
        return httpURLConnection;
    }

    private final String getBatchAppId(GraphRequestBatch graphRequestBatch) {
        String batchApplicationId = graphRequestBatch.getBatchApplicationId();
        if (batchApplicationId == null || !(!graphRequestBatch.isEmpty())) {
            Iterator<GraphRequest> it = graphRequestBatch.iterator();
            while (it.hasNext()) {
                AccessToken accessToken = it.next().getAccessToken();
                if (accessToken != null) {
                    return accessToken.getApplicationId();
                }
            }
            String access$getDefaultBatchApplicationId$cp = GraphRequest.access$getDefaultBatchApplicationId$cp();
            if (access$getDefaultBatchApplicationId$cp != null) {
                if (access$getDefaultBatchApplicationId$cp.length() > 0) {
                    return access$getDefaultBatchApplicationId$cp;
                }
            }
            String applicationId = FacebookSdk.getApplicationId();
            f0.o(applicationId, "FacebookSdk.getApplicationId()");
            return applicationId;
        }
        return batchApplicationId;
    }

    private final String getDefaultPhotoPathIfNull(String str) {
        return str != null ? str : ShareInternalUtility.MY_PHOTOS;
    }

    private final String getMimeContentType() {
        s0 s0Var = s0.a;
        String format = String.format("multipart/form-data; boundary=%s", Arrays.copyOf(new Object[]{GraphRequest.access$getMIME_BOUNDARY$cp()}, 1));
        f0.o(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @VisibleForTesting(otherwise = 2)
    public static /* synthetic */ void getTAG$facebook_core_release$annotations() {
    }

    private final String getUserAgent() {
        if (GraphRequest.access$getUserAgent$cp() == null) {
            s0 s0Var = s0.a;
            String format = String.format("%s.%s", Arrays.copyOf(new Object[]{"FBAndroidSDK", FacebookSdkVersion.BUILD}, 2));
            f0.o(format, "java.lang.String.format(format, *args)");
            GraphRequest.access$setUserAgent$cp(format);
            String customUserAgent = InternalSettings.getCustomUserAgent();
            if (!Utility.isNullOrEmpty(customUserAgent)) {
                String format2 = String.format(Locale.ROOT, "%s/%s", Arrays.copyOf(new Object[]{GraphRequest.access$getUserAgent$cp(), customUserAgent}, 2));
                f0.o(format2, "java.lang.String.format(locale, format, *args)");
                GraphRequest.access$setUserAgent$cp(format2);
            }
        }
        return GraphRequest.access$getUserAgent$cp();
    }

    private final boolean hasOnProgressCallbacks(GraphRequestBatch graphRequestBatch) {
        for (GraphRequestBatch.Callback callback : graphRequestBatch.getCallbacks()) {
            if (callback instanceof GraphRequestBatch.OnProgressCallback) {
                return true;
            }
        }
        Iterator<GraphRequest> it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            if (it.next().getCallback() instanceof GraphRequest$OnProgressCallback) {
                return true;
            }
        }
        return false;
    }

    private final boolean isGzipCompressible(GraphRequestBatch graphRequestBatch) {
        Iterator<GraphRequest> it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            GraphRequest next = it.next();
            for (String str : next.getParameters().keySet()) {
                if (isSupportedAttachmentType(next.getParameters().get(str))) {
                    return false;
                }
            }
        }
        return true;
    }

    private final boolean isMeRequest(String str) {
        Matcher matcher = GraphRequest.access$getVersionPattern$cp().matcher(str);
        if (matcher.matches()) {
            str = matcher.group(1);
            f0.o(str, "matcher.group(1)");
        }
        return u.u2(str, "me/", false, 2, (Object) null) || u.u2(str, "/me/", false, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSupportedAttachmentType(Object obj) {
        return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof GraphRequest$ParcelableResourceWithMimeType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSupportedParameterType(Object obj) {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String parameterToString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof Boolean) && !(obj instanceof Number)) {
            if (obj instanceof Date) {
                String format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj);
                f0.o(format, "iso8601DateFormat.format(value)");
                return format;
            }
            throw new IllegalArgumentException("Unsupported parameter type.");
        }
        return obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void processGraphObject(org.json.JSONObject r10, java.lang.String r11, com.facebook.GraphRequest$KeyValueSerializer r12) {
        /*
            r9 = this;
            boolean r0 = r9.isMeRequest(r11)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L23
            r5 = 0
            r6 = 0
            r7 = 6
            r8 = 0
            java.lang.String r4 = ":"
            r3 = r11
            int r0 = kotlin.text.StringsKt__StringsKt.r3(r3, r4, r5, r6, r7, r8)
            java.lang.String r4 = "?"
            int r11 = kotlin.text.StringsKt__StringsKt.r3(r3, r4, r5, r6, r7, r8)
            r3 = 3
            if (r0 <= r3) goto L23
            r3 = -1
            if (r11 == r3) goto L21
            if (r0 >= r11) goto L23
        L21:
            r11 = 1
            goto L24
        L23:
            r11 = 0
        L24:
            java.util.Iterator r0 = r10.keys()
        L28:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L53
            java.lang.Object r3 = r0.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r10.opt(r3)
            if (r11 == 0) goto L44
            java.lang.String r5 = "image"
            boolean r5 = n.u2.u.K1(r3, r5, r1)
            if (r5 == 0) goto L44
            r5 = 1
            goto L45
        L44:
            r5 = 0
        L45:
            java.lang.String r6 = "key"
            n.l2.v.f0.o(r3, r6)
            java.lang.String r6 = "value"
            n.l2.v.f0.o(r4, r6)
            r9.processGraphObjectProperty(r3, r4, r12, r5)
            goto L28
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest$Companion.processGraphObject(org.json.JSONObject, java.lang.String, com.facebook.GraphRequest$KeyValueSerializer):void");
    }

    private final void processGraphObjectProperty(String str, Object obj, GraphRequest$KeyValueSerializer graphRequest$KeyValueSerializer, boolean z) {
        Class<?> cls = obj.getClass();
        if (JSONObject.class.isAssignableFrom(cls)) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
            JSONObject jSONObject = (JSONObject) obj;
            if (z) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    s0 s0Var = s0.a;
                    String format = String.format("%s[%s]", Arrays.copyOf(new Object[]{str, next}, 2));
                    f0.o(format, "java.lang.String.format(format, *args)");
                    Object opt = jSONObject.opt(next);
                    f0.o(opt, "jsonObject.opt(propertyName)");
                    processGraphObjectProperty(format, opt, graphRequest$KeyValueSerializer, z);
                }
            } else if (jSONObject.has("id")) {
                String optString = jSONObject.optString("id");
                f0.o(optString, "jsonObject.optString(\"id\")");
                processGraphObjectProperty(str, optString, graphRequest$KeyValueSerializer, z);
            } else if (jSONObject.has("url")) {
                String optString2 = jSONObject.optString("url");
                f0.o(optString2, "jsonObject.optString(\"url\")");
                processGraphObjectProperty(str, optString2, graphRequest$KeyValueSerializer, z);
            } else if (jSONObject.has(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY)) {
                String jSONObject2 = jSONObject.toString();
                f0.o(jSONObject2, "jsonObject.toString()");
                processGraphObjectProperty(str, jSONObject2, graphRequest$KeyValueSerializer, z);
            }
        } else if (JSONArray.class.isAssignableFrom(cls)) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type org.json.JSONArray");
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                s0 s0Var2 = s0.a;
                String format2 = String.format(Locale.ROOT, "%s[%d]", Arrays.copyOf(new Object[]{str, Integer.valueOf(i)}, 2));
                f0.o(format2, "java.lang.String.format(locale, format, *args)");
                Object opt2 = jSONArray.opt(i);
                f0.o(opt2, "jsonArray.opt(i)");
                processGraphObjectProperty(format2, opt2, graphRequest$KeyValueSerializer, z);
            }
        } else if (!String.class.isAssignableFrom(cls) && !Number.class.isAssignableFrom(cls) && !Boolean.TYPE.isAssignableFrom(cls)) {
            if (Date.class.isAssignableFrom(cls)) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type java.util.Date");
                String format3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj);
                f0.o(format3, "iso8601DateFormat.format(date)");
                graphRequest$KeyValueSerializer.writeString(str, format3);
            }
        } else {
            graphRequest$KeyValueSerializer.writeString(str, obj.toString());
        }
    }

    private final void processRequest(GraphRequestBatch graphRequestBatch, Logger logger, int i, URL url, OutputStream outputStream, boolean z) {
        GraphRequest$Serializer graphRequest$Serializer = new GraphRequest$Serializer(outputStream, logger, z);
        if (i == 1) {
            GraphRequest graphRequest = graphRequestBatch.get(0);
            Map<String, GraphRequest$Attachment> hashMap = new HashMap<>();
            for (String str : graphRequest.getParameters().keySet()) {
                Object obj = graphRequest.getParameters().get(str);
                if (isSupportedAttachmentType(obj)) {
                    f0.o(str, SDKConstants.PARAM_KEY);
                    hashMap.put(str, new GraphRequest$Attachment(graphRequest, obj));
                }
            }
            if (logger != null) {
                logger.append("  Parameters:\n");
            }
            serializeParameters(graphRequest.getParameters(), graphRequest$Serializer, graphRequest);
            if (logger != null) {
                logger.append("  Attachments:\n");
            }
            serializeAttachments(hashMap, graphRequest$Serializer);
            JSONObject graphObject = graphRequest.getGraphObject();
            if (graphObject != null) {
                String path = url.getPath();
                f0.o(path, "url.path");
                processGraphObject(graphObject, path, graphRequest$Serializer);
                return;
            }
            return;
        }
        String batchAppId = getBatchAppId(graphRequestBatch);
        if (!(batchAppId.length() == 0)) {
            graphRequest$Serializer.writeString("batch_app_id", batchAppId);
            Map<String, GraphRequest$Attachment> hashMap2 = new HashMap<>();
            serializeRequestsAsJSON(graphRequest$Serializer, graphRequestBatch, hashMap2);
            if (logger != null) {
                logger.append("  Attachments:\n");
            }
            serializeAttachments(hashMap2, graphRequest$Serializer);
            return;
        }
        throw new FacebookException("App ID was not specified at the request or Settings.");
    }

    private final void serializeAttachments(Map<String, GraphRequest$Attachment> map, GraphRequest$Serializer graphRequest$Serializer) {
        for (Map.Entry<String, GraphRequest$Attachment> entry : map.entrySet()) {
            if (GraphRequest.Companion.isSupportedAttachmentType(entry.getValue().getValue())) {
                graphRequest$Serializer.writeObject(entry.getKey(), entry.getValue().getValue(), entry.getValue().getRequest());
            }
        }
    }

    private final void serializeParameters(Bundle bundle, GraphRequest$Serializer graphRequest$Serializer, GraphRequest graphRequest) {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (isSupportedParameterType(obj)) {
                f0.o(str, SDKConstants.PARAM_KEY);
                graphRequest$Serializer.writeObject(str, obj, graphRequest);
            }
        }
    }

    private final void serializeRequestsAsJSON(GraphRequest$Serializer graphRequest$Serializer, Collection<GraphRequest> collection, Map<String, GraphRequest$Attachment> map) {
        JSONArray jSONArray = new JSONArray();
        for (GraphRequest graphRequest : collection) {
            GraphRequest.access$serializeToBatch(graphRequest, jSONArray, map);
        }
        graphRequest$Serializer.writeRequestsAsJson("batch", jSONArray, collection);
    }

    private final void setConnectionContentType(HttpURLConnection httpURLConnection, boolean z) {
        if (z) {
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            return;
        }
        httpURLConnection.setRequestProperty("Content-Type", getMimeContentType());
    }

    private final void setUserAgent(String str) {
        GraphRequest.access$setUserAgent$cp(str);
    }

    @d
    @k
    public final GraphResponse executeAndWait(@d GraphRequest graphRequest) {
        f0.p(graphRequest, "request");
        List<GraphResponse> executeBatchAndWait = executeBatchAndWait(graphRequest);
        if (executeBatchAndWait.size() == 1) {
            return executeBatchAndWait.get(0);
        }
        throw new FacebookException("invalid state: expected a single response");
    }

    @d
    @k
    public final List<GraphResponse> executeBatchAndWait(@d GraphRequest... graphRequestArr) {
        f0.p(graphRequestArr, "requests");
        return executeBatchAndWait(ArraysKt___ArraysKt.ey(graphRequestArr));
    }

    @d
    @k
    public final GraphRequestAsyncTask executeBatchAsync(@d GraphRequest... graphRequestArr) {
        f0.p(graphRequestArr, "requests");
        return executeBatchAsync(ArraysKt___ArraysKt.ey(graphRequestArr));
    }

    @d
    @k
    public final List<GraphResponse> executeConnectionAndWait(@d HttpURLConnection httpURLConnection, @d Collection<GraphRequest> collection) {
        f0.p(httpURLConnection, "connection");
        f0.p(collection, "requests");
        return executeConnectionAndWait(httpURLConnection, new GraphRequestBatch(collection));
    }

    @d
    @k
    public final GraphRequestAsyncTask executeConnectionAsync(@d HttpURLConnection httpURLConnection, @d GraphRequestBatch graphRequestBatch) {
        f0.p(httpURLConnection, "connection");
        f0.p(graphRequestBatch, "requests");
        return executeConnectionAsync(null, httpURLConnection, graphRequestBatch);
    }

    @k
    @e
    public final String getDefaultBatchApplicationId() {
        return GraphRequest.access$getDefaultBatchApplicationId$cp();
    }

    @d
    @k
    public final GraphRequest newCustomAudienceThirdPartyIdRequest(@e AccessToken accessToken, @d Context context, @e String str, @e GraphRequest$Callback graphRequest$Callback) {
        f0.p(context, "context");
        if (str == null && accessToken != null) {
            str = accessToken.getApplicationId();
        }
        if (str == null) {
            str = Utility.getMetadataApplicationId(context);
        }
        if (str != null) {
            String str2 = str + "/custom_audience_third_party_id";
            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers(context);
            Bundle bundle = new Bundle();
            if (accessToken == null) {
                if (attributionIdentifiers != null) {
                    String attributionId = attributionIdentifiers.getAttributionId() != null ? attributionIdentifiers.getAttributionId() : attributionIdentifiers.getAndroidAdvertiserId();
                    if (attributionIdentifiers.getAttributionId() != null) {
                        bundle.putString("udid", attributionId);
                    }
                } else {
                    throw new FacebookException("There is no access token and attribution identifiers could not be retrieved");
                }
            }
            if (FacebookSdk.getLimitEventAndDataUsage(context) || (attributionIdentifiers != null && attributionIdentifiers.isTrackingLimited())) {
                bundle.putString("limit_event_usage", "1");
            }
            return new GraphRequest(accessToken, str2, bundle, HttpMethod.GET, graphRequest$Callback, (String) null, 32, (n.l2.v.u) null);
        }
        throw new FacebookException("Facebook App ID cannot be determined");
    }

    @d
    @k
    public final GraphRequest newDeleteObjectRequest(@e AccessToken accessToken, @e String str, @e GraphRequest$Callback graphRequest$Callback) {
        return new GraphRequest(accessToken, str, (Bundle) null, HttpMethod.DELETE, graphRequest$Callback, (String) null, 32, (n.l2.v.u) null);
    }

    @d
    @k
    public final GraphRequest newGraphPathRequest(@e AccessToken accessToken, @e String str, @e GraphRequest$Callback graphRequest$Callback) {
        return new GraphRequest(accessToken, str, (Bundle) null, (HttpMethod) null, graphRequest$Callback, (String) null, 32, (n.l2.v.u) null);
    }

    @d
    @k
    public final GraphRequest newMeRequest(@e AccessToken accessToken, @e final GraphRequest$GraphJSONObjectCallback graphRequest$GraphJSONObjectCallback) {
        return new GraphRequest(accessToken, "me", (Bundle) null, (HttpMethod) null, new GraphRequest$Callback() { // from class: com.facebook.GraphRequest$Companion$newMeRequest$wrapper$1
            @Override // com.facebook.GraphRequest$Callback
            public final void onCompleted(@d GraphResponse graphResponse) {
                f0.p(graphResponse, "response");
                GraphRequest$GraphJSONObjectCallback graphRequest$GraphJSONObjectCallback2 = GraphRequest$GraphJSONObjectCallback.this;
                if (graphRequest$GraphJSONObjectCallback2 != null) {
                    graphRequest$GraphJSONObjectCallback2.onCompleted(graphResponse.getJSONObject(), graphResponse);
                }
            }
        }, (String) null, 32, (n.l2.v.u) null);
    }

    @d
    @k
    public final GraphRequest newMyFriendsRequest(@e AccessToken accessToken, @e final GraphRequest$GraphJSONArrayCallback graphRequest$GraphJSONArrayCallback) {
        return new GraphRequest(accessToken, "me/friends", (Bundle) null, (HttpMethod) null, new GraphRequest$Callback() { // from class: com.facebook.GraphRequest$Companion$newMyFriendsRequest$wrapper$1
            @Override // com.facebook.GraphRequest$Callback
            public void onCompleted(@d GraphResponse graphResponse) {
                f0.p(graphResponse, "response");
                if (GraphRequest$GraphJSONArrayCallback.this != null) {
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    GraphRequest$GraphJSONArrayCallback.this.onCompleted(jSONObject != null ? jSONObject.optJSONArray("data") : null, graphResponse);
                }
            }
        }, (String) null, 32, (n.l2.v.u) null);
    }

    @d
    @k
    public final GraphRequest newPlacesSearchRequest(@e AccessToken accessToken, @e Location location, int i, int i2, @e String str, @e final GraphRequest$GraphJSONArrayCallback graphRequest$GraphJSONArrayCallback) {
        if (location == null && Utility.isNullOrEmpty(str)) {
            throw new FacebookException("Either location or searchText must be specified.");
        }
        Bundle bundle = new Bundle(5);
        bundle.putString("type", "place");
        bundle.putInt("limit", i2);
        if (location != null) {
            s0 s0Var = s0.a;
            String format = String.format(Locale.US, "%f,%f", Arrays.copyOf(new Object[]{Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())}, 2));
            f0.o(format, "java.lang.String.format(locale, format, *args)");
            bundle.putString("center", format);
            bundle.putInt("distance", i);
        }
        if (!Utility.isNullOrEmpty(str)) {
            bundle.putString("q", str);
        }
        return new GraphRequest(accessToken, "search", bundle, HttpMethod.GET, new GraphRequest$Callback() { // from class: com.facebook.GraphRequest$Companion$newPlacesSearchRequest$wrapper$1
            @Override // com.facebook.GraphRequest$Callback
            public final void onCompleted(@d GraphResponse graphResponse) {
                f0.p(graphResponse, "response");
                if (GraphRequest$GraphJSONArrayCallback.this != null) {
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    GraphRequest$GraphJSONArrayCallback.this.onCompleted(jSONObject != null ? jSONObject.optJSONArray("data") : null, graphResponse);
                }
            }
        }, (String) null, 32, (n.l2.v.u) null);
    }

    @d
    @k
    public final GraphRequest newPostRequest(@e AccessToken accessToken, @e String str, @e JSONObject jSONObject, @e GraphRequest$Callback graphRequest$Callback) {
        GraphRequest graphRequest = new GraphRequest(accessToken, str, (Bundle) null, HttpMethod.POST, graphRequest$Callback, (String) null, 32, (n.l2.v.u) null);
        graphRequest.setGraphObject(jSONObject);
        return graphRequest;
    }

    @d
    @k
    public final GraphRequest newUploadPhotoRequest(@e AccessToken accessToken, @e String str, @e Bitmap bitmap, @e String str2, @e Bundle bundle, @e GraphRequest$Callback graphRequest$Callback) {
        String defaultPhotoPathIfNull = getDefaultPhotoPathIfNull(str);
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("picture", bitmap);
        if (str2 != null) {
            if (str2.length() > 0) {
                bundle2.putString(ShareConstants.FEED_CAPTION_PARAM, str2);
            }
        }
        return new GraphRequest(accessToken, defaultPhotoPathIfNull, bundle2, HttpMethod.POST, graphRequest$Callback, (String) null, 32, (n.l2.v.u) null);
    }

    @k
    public final void runCallbacks$facebook_core_release(@d final GraphRequestBatch graphRequestBatch, @d List<GraphResponse> list) {
        f0.p(graphRequestBatch, "requests");
        f0.p(list, "responses");
        int size = graphRequestBatch.size();
        final ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            GraphRequest graphRequest = graphRequestBatch.get(i);
            if (graphRequest.getCallback() != null) {
                arrayList.add(new Pair(graphRequest.getCallback(), list.get(i)));
            }
        }
        if (arrayList.size() > 0) {
            Runnable runnable = new Runnable() { // from class: com.facebook.GraphRequest$Companion$runCallbacks$runnable$1
                @Override // java.lang.Runnable
                public final void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Pair pair = (Pair) it.next();
                            Object obj = pair.second;
                            f0.o(obj, "pair.second");
                            ((GraphRequest$Callback) pair.first).onCompleted((GraphResponse) obj);
                        }
                        for (GraphRequestBatch.Callback callback : graphRequestBatch.getCallbacks()) {
                            callback.onBatchCompleted(graphRequestBatch);
                        }
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            };
            Handler callbackHandler = graphRequestBatch.getCallbackHandler();
            if (callbackHandler != null) {
                callbackHandler.post(runnable);
            } else {
                runnable.run();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00f2  */
    @n.l2.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void serializeToUrlConnection$facebook_core_release(@r.e.a.d com.facebook.GraphRequestBatch r14, @r.e.a.d java.net.HttpURLConnection r15) throws java.io.IOException, org.json.JSONException {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest$Companion.serializeToUrlConnection$facebook_core_release(com.facebook.GraphRequestBatch, java.net.HttpURLConnection):void");
    }

    @k
    public final void setDefaultBatchApplicationId(@e String str) {
        GraphRequest.access$setDefaultBatchApplicationId$cp(str);
    }

    @k
    public final boolean shouldWarnOnMissingFieldsParam$facebook_core_release(@d GraphRequest graphRequest) {
        f0.p(graphRequest, "request");
        String version = graphRequest.getVersion();
        if (version != null) {
            if (version.length() == 0) {
                return true;
            }
            if (u.u2(version, "v", false, 2, (Object) null)) {
                Objects.requireNonNull(version, "null cannot be cast to non-null type java.lang.String");
                version = version.substring(1);
                f0.o(version, "(this as java.lang.String).substring(startIndex)");
            }
            Object[] array = new Regex("\\.").split(version, 0).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            String[] strArr = (String[]) array;
            if (strArr.length < 2 || Integer.parseInt(strArr[0]) <= 2) {
                return Integer.parseInt(strArr[0]) >= 2 && Integer.parseInt(strArr[1]) >= 4;
            }
            return true;
        }
        return true;
    }

    @d
    @k
    public final HttpURLConnection toHttpConnection(@d GraphRequest... graphRequestArr) {
        f0.p(graphRequestArr, "requests");
        return toHttpConnection(ArraysKt___ArraysKt.ey(graphRequestArr));
    }

    @k
    public final void validateFieldsParamForGetRequests$facebook_core_release(@d GraphRequestBatch graphRequestBatch) {
        f0.p(graphRequestBatch, "requests");
        Iterator<GraphRequest> it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            GraphRequest next = it.next();
            if (HttpMethod.GET == next.getHttpMethod()) {
                f0.o(next, "request");
                if (shouldWarnOnMissingFieldsParam$facebook_core_release(next) && (!next.getParameters().containsKey("fields") || Utility.isNullOrEmpty(next.getParameters().getString("fields")))) {
                    Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
                    Object[] objArr = new Object[1];
                    String graphPath = next.getGraphPath();
                    if (graphPath == null) {
                        graphPath = "";
                    }
                    objArr[0] = graphPath;
                    companion.log(loggingBehavior, 5, "Request", "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.", objArr);
                }
            }
        }
    }

    public /* synthetic */ GraphRequest$Companion(n.l2.v.u uVar) {
        this();
    }

    @d
    @k
    public final List<GraphResponse> executeBatchAndWait(@d Collection<GraphRequest> collection) {
        f0.p(collection, "requests");
        return executeBatchAndWait(new GraphRequestBatch(collection));
    }

    @d
    @k
    public final GraphRequestAsyncTask executeBatchAsync(@d Collection<GraphRequest> collection) {
        f0.p(collection, "requests");
        return executeBatchAsync(new GraphRequestBatch(collection));
    }

    @d
    @k
    public final List<GraphResponse> executeConnectionAndWait(@d HttpURLConnection httpURLConnection, @d GraphRequestBatch graphRequestBatch) {
        f0.p(httpURLConnection, "connection");
        f0.p(graphRequestBatch, "requests");
        List<GraphResponse> fromHttpConnection$facebook_core_release = GraphResponse.Companion.fromHttpConnection$facebook_core_release(httpURLConnection, graphRequestBatch);
        Utility.disconnectQuietly(httpURLConnection);
        int size = graphRequestBatch.size();
        if (size == fromHttpConnection$facebook_core_release.size()) {
            runCallbacks$facebook_core_release(graphRequestBatch, fromHttpConnection$facebook_core_release);
            AccessTokenManager.Companion.getInstance().extendAccessTokenIfNeeded();
            return fromHttpConnection$facebook_core_release;
        }
        s0 s0Var = s0.a;
        String format = String.format(Locale.US, "Received %d responses while expecting %d", Arrays.copyOf(new Object[]{Integer.valueOf(fromHttpConnection$facebook_core_release.size()), Integer.valueOf(size)}, 2));
        f0.o(format, "java.lang.String.format(locale, format, *args)");
        throw new FacebookException(format);
    }

    @d
    @k
    public final GraphRequestAsyncTask executeConnectionAsync(@e Handler handler, @d HttpURLConnection httpURLConnection, @d GraphRequestBatch graphRequestBatch) {
        f0.p(httpURLConnection, "connection");
        f0.p(graphRequestBatch, "requests");
        GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(httpURLConnection, graphRequestBatch);
        graphRequestBatch.setCallbackHandler(handler);
        graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
        return graphRequestAsyncTask;
    }

    @d
    @k
    public final HttpURLConnection toHttpConnection(@d Collection<GraphRequest> collection) {
        f0.p(collection, "requests");
        Validate.notEmpty(collection, "requests");
        return toHttpConnection(new GraphRequestBatch(collection));
    }

    @d
    @k
    public final List<GraphResponse> executeBatchAndWait(@d GraphRequestBatch graphRequestBatch) {
        Exception exc;
        HttpURLConnection httpURLConnection;
        List<GraphResponse> list;
        f0.p(graphRequestBatch, "requests");
        Validate.notEmptyAndContainsNoNulls(graphRequestBatch, "requests");
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = toHttpConnection(graphRequestBatch);
            exc = null;
        } catch (Exception e) {
            exc = e;
            httpURLConnection = null;
        } catch (Throwable th) {
            th = th;
            Utility.disconnectQuietly(httpURLConnection2);
            throw th;
        }
        try {
            if (httpURLConnection != null) {
                list = executeConnectionAndWait(httpURLConnection, graphRequestBatch);
            } else {
                List<GraphResponse> constructErrorResponses = GraphResponse.Companion.constructErrorResponses(graphRequestBatch.getRequests(), null, new FacebookException(exc));
                runCallbacks$facebook_core_release(graphRequestBatch, constructErrorResponses);
                list = constructErrorResponses;
            }
            Utility.disconnectQuietly(httpURLConnection);
            return list;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection2 = httpURLConnection;
            Utility.disconnectQuietly(httpURLConnection2);
            throw th;
        }
    }

    @d
    @k
    public final GraphRequestAsyncTask executeBatchAsync(@d GraphRequestBatch graphRequestBatch) {
        f0.p(graphRequestBatch, "requests");
        Validate.notEmptyAndContainsNoNulls(graphRequestBatch, "requests");
        GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(graphRequestBatch);
        graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
        return graphRequestAsyncTask;
    }

    @d
    @k
    public final HttpURLConnection toHttpConnection(@d GraphRequestBatch graphRequestBatch) {
        URL url;
        f0.p(graphRequestBatch, "requests");
        validateFieldsParamForGetRequests$facebook_core_release(graphRequestBatch);
        try {
            if (graphRequestBatch.size() == 1) {
                url = new URL(graphRequestBatch.get(0).getUrlForSingleRequest());
            } else {
                url = new URL(ServerProtocol.getGraphUrlBase());
            }
            HttpURLConnection httpURLConnection = null;
            try {
                httpURLConnection = createConnection(url);
                serializeToUrlConnection$facebook_core_release(graphRequestBatch, httpURLConnection);
                return httpURLConnection;
            } catch (IOException e) {
                Utility.disconnectQuietly(httpURLConnection);
                throw new FacebookException("could not construct request body", e);
            } catch (JSONException e2) {
                Utility.disconnectQuietly(httpURLConnection);
                throw new FacebookException("could not construct request body", e2);
            }
        } catch (MalformedURLException e3) {
            throw new FacebookException("could not construct URL for request", e3);
        }
    }

    @d
    @k
    public final GraphRequest newUploadPhotoRequest(@e AccessToken accessToken, @e String str, @e File file, @e String str2, @e Bundle bundle, @e GraphRequest$Callback graphRequest$Callback) throws FileNotFoundException {
        String defaultPhotoPathIfNull = getDefaultPhotoPathIfNull(str);
        ParcelFileDescriptor open = ParcelFileDescriptor.open(file, Label.FORWARD_REFERENCE_TYPE_SHORT);
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("picture", open);
        if (str2 != null) {
            if (str2.length() > 0) {
                bundle2.putString(ShareConstants.FEED_CAPTION_PARAM, str2);
            }
        }
        return new GraphRequest(accessToken, defaultPhotoPathIfNull, bundle2, HttpMethod.POST, graphRequest$Callback, (String) null, 32, (n.l2.v.u) null);
    }

    @d
    @k
    public final GraphRequest newCustomAudienceThirdPartyIdRequest(@e AccessToken accessToken, @d Context context, @e GraphRequest$Callback graphRequest$Callback) {
        f0.p(context, "context");
        return newCustomAudienceThirdPartyIdRequest(accessToken, context, null, graphRequest$Callback);
    }

    @d
    @k
    public final GraphRequest newUploadPhotoRequest(@e AccessToken accessToken, @e String str, @d Uri uri, @e String str2, @e Bundle bundle, @e GraphRequest$Callback graphRequest$Callback) throws FileNotFoundException {
        f0.p(uri, "photoUri");
        String defaultPhotoPathIfNull = getDefaultPhotoPathIfNull(str);
        if (Utility.isFileUri(uri)) {
            return newUploadPhotoRequest(accessToken, defaultPhotoPathIfNull, new File(uri.getPath()), str2, bundle, graphRequest$Callback);
        }
        if (Utility.isContentUri(uri)) {
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            bundle2.putParcelable("picture", uri);
            if (str2 != null) {
                if (str2.length() > 0) {
                    bundle2.putString(ShareConstants.FEED_CAPTION_PARAM, str2);
                }
            }
            return new GraphRequest(accessToken, defaultPhotoPathIfNull, bundle2, HttpMethod.POST, graphRequest$Callback, (String) null, 32, (n.l2.v.u) null);
        }
        throw new FacebookException("The photo Uri must be either a file:// or content:// Uri");
    }
}
