package com.facebook.internal.logging.dumpsys;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.webkit.WebView;
import android.widget.TextView;
import com.alibaba.android.arouter.utils.Consts;
import com.alipay.sdk.util.g;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.logging.dumpsys.AndroidRootResolver;
import com.facebook.internal.security.CertificateUtil;
import com.hunantv.imgo.widget.BeautifyTextView;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import n.b0;
import n.l2.k;
import n.l2.v.f0;
import n.u2.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r.e.a.d;
import r.e.a.e;

/* compiled from: EndToEndDumpsysHelper.kt */
@b0(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0003\u001b\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0002JB\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0018H\u0002¢\u0006\u0002\u0010\u0019J(\u0010\u001a\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/EndToEndDumpsysHelper;", "", "()V", "lithoViewToStringMethod", "Ljava/lang/reflect/Method;", "rootResolver", "Lcom/facebook/internal/logging/dumpsys/AndroidRootResolver;", "webViewDumpHelper", "Lcom/facebook/internal/logging/dumpsys/WebViewDumpHelper;", "dumpViewHierarchy", "", "prefix", "", "writer", "Ljava/io/PrintWriter;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "leftOffset", "", "topOffset", "withWebView", "", "withProps", "args", "", "(Ljava/lang/String;Ljava/io/PrintWriter;[Ljava/lang/String;)V", "writeLithoViewSubHierarchy", "Api21Utils", "Api24Utils", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
@SuppressLint({"HexColorValueUsage", "CatchGeneralException", "BadMethodUse-java.lang.String.length"})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class EndToEndDumpsysHelper {
    private static final String ALL_ROOTS_ARGUMENT = "all-roots";
    @d
    public static final Companion Companion = new Companion(null);
    private static final String E2E_ARGUMENT = "e2e";
    private static final String LITHO_VIEW_CLASS = "com.facebook.litho.LithoView";
    private static final String LITHO_VIEW_TEST_HELPER_CLASS = "com.facebook.litho.LithoViewTestHelper";
    private static final String LITHO_VIEW_TO_STRING_METHOD = "viewToStringForE2E";
    private static final String RC_TEXT_VIEW_SIMPLE_CLASS_NAME = "RCTextView";
    private static final String TOP_ROOT_ARGUMENT = "top-root";
    private static final String WITH_PROPS_ARGUMENT = "props";
    private static final String WITH_WEBVIEW_ARGUMENT = "webview";
    private static EndToEndDumpsysHelper instance;
    private static Method rcTextViewGetTextMethod;
    private Method lithoViewToStringMethod;
    private final AndroidRootResolver rootResolver = new AndroidRootResolver();
    private final WebViewDumpHelper webViewDumpHelper = new WebViewDumpHelper();

    /* compiled from: EndToEndDumpsysHelper.kt */
    @b0(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/EndToEndDumpsysHelper$Api21Utils;", "", "()V", "keyedTagsField", "Ljava/lang/reflect/Field;", "getTags", "Lorg/json/JSONObject;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "writeExtraProps", "", "writer", "Ljava/io/PrintWriter;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class Api21Utils {
        @d
        public static final Api21Utils INSTANCE = new Api21Utils();
        private static Field keyedTagsField;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mKeyedTags");
                keyedTagsField = declaredField;
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                }
            } catch (NoSuchFieldException unused) {
            }
        }

        private Api21Utils() {
        }

        private final JSONObject getTags(View view) {
            try {
                if (keyedTagsField == null) {
                    Field declaredField = View.class.getDeclaredField("mKeyedTags");
                    keyedTagsField = declaredField;
                    if (declaredField != null) {
                        declaredField.setAccessible(true);
                    }
                }
                Field field = keyedTagsField;
                Object obj = field != null ? field.get(view) : null;
                if (obj != null) {
                    SparseArray sparseArray = (SparseArray) obj;
                    if (sparseArray == null || sparseArray.size() <= 0) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        int size = sparseArray.size();
                        for (int i = 0; i < size; i++) {
                            try {
                                jSONObject.put(ResourcesUtil.getIdStringQuietly(view.getResources(), sparseArray.keyAt(i)), sparseArray.valueAt(i));
                            } catch (JSONException unused) {
                            }
                        }
                    } catch (Exception unused2) {
                    }
                    return jSONObject;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.util.SparseArray<*>");
            } catch (Exception unused3) {
                return null;
            }
        }

        public final void writeExtraProps(@d PrintWriter printWriter, @d View view) {
            Companion companion;
            AccessibilityNodeInfo createNodeInfoFromView;
            f0.p(printWriter, "writer");
            f0.p(view, ViewHierarchyConstants.VIEW_KEY);
            if (Build.VERSION.SDK_INT >= 21 && (createNodeInfoFromView = (companion = EndToEndDumpsysHelper.Companion).createNodeInfoFromView(view)) != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (view instanceof TextView) {
                        ColorStateList textColors = ((TextView) view).getTextColors();
                        f0.o(textColors, "view.textColors");
                        jSONObject.put("textColor", textColors.getDefaultColor());
                        jSONObject.put("textSize", ((TextView) view).getTextSize());
                        jSONObject.put(ViewHierarchyConstants.HINT_KEY, companion.fixString(((TextView) view).getHint(), 100));
                    }
                    JSONObject tags = getTags(view);
                    if (tags != null) {
                        jSONObject.put("keyedTags", tags);
                    }
                    JSONArray jSONArray = new JSONArray();
                    for (AccessibilityNodeInfo.AccessibilityAction accessibilityAction : createNodeInfoFromView.getActionList()) {
                        f0.o(accessibilityAction, "action");
                        CharSequence label = accessibilityAction.getLabel();
                        if (label == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        String str = (String) label;
                        if (str != null) {
                            jSONArray.put(EndToEndDumpsysHelper.Companion.fixString(str, 50));
                        }
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("actions", jSONArray);
                    }
                    Companion companion2 = EndToEndDumpsysHelper.Companion;
                    String fixString = companion2.fixString(createNodeInfoFromView.getContentDescription(), 50);
                    if (fixString != null) {
                        if (fixString.length() > 0) {
                            jSONObject.put("content-description", fixString);
                        }
                    }
                    jSONObject.put("accessibility-focused", createNodeInfoFromView.isAccessibilityFocused()).put("checkable", createNodeInfoFromView.isCheckable()).put("checked", createNodeInfoFromView.isChecked()).put("class-name", companion2.fixString(createNodeInfoFromView.getClassName(), 50)).put("clickable", createNodeInfoFromView.isClickable()).put("content-invalid", createNodeInfoFromView.isContentInvalid()).put("dismissable", createNodeInfoFromView.isDismissable()).put("editable", createNodeInfoFromView.isEditable()).put("enabled", createNodeInfoFromView.isEnabled()).put("focusable", createNodeInfoFromView.isFocusable()).put("focused", createNodeInfoFromView.isFocused()).put("long-clickable", createNodeInfoFromView.isLongClickable()).put("multiline", createNodeInfoFromView.isMultiLine()).put("password", createNodeInfoFromView.isPassword()).put("scrollable", createNodeInfoFromView.isScrollable()).put("selected", createNodeInfoFromView.isSelected()).put("visible-to-user", createNodeInfoFromView.isVisibleToUser());
                    if (Build.VERSION.SDK_INT >= 24) {
                        Api24Utils.INSTANCE.addExtraProps(jSONObject, createNodeInfoFromView);
                    }
                } catch (Exception e) {
                    try {
                        jSONObject.put("DUMP-ERROR", EndToEndDumpsysHelper.Companion.fixString(e.getMessage(), 50));
                    } catch (JSONException unused) {
                    }
                }
                printWriter.append(" props=\"").append((CharSequence) jSONObject.toString()).append("\"");
            }
        }
    }

    /* compiled from: EndToEndDumpsysHelper.kt */
    @b0(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/EndToEndDumpsysHelper$Api24Utils;", "", "()V", "addExtraProps", "", EndToEndDumpsysHelper.WITH_PROPS_ARGUMENT, "Lorg/json/JSONObject;", "nodeInfo", "Landroid/view/accessibility/AccessibilityNodeInfo;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class Api24Utils {
        @d
        public static final Api24Utils INSTANCE = new Api24Utils();

        private Api24Utils() {
        }

        public final void addExtraProps(@d JSONObject jSONObject, @d AccessibilityNodeInfo accessibilityNodeInfo) throws JSONException {
            f0.p(jSONObject, EndToEndDumpsysHelper.WITH_PROPS_ARGUMENT);
            f0.p(accessibilityNodeInfo, "nodeInfo");
            if (Build.VERSION.SDK_INT < 24) {
                return;
            }
            jSONObject.put("context-clickable", accessibilityNodeInfo.isContextClickable()).put("drawing-order", accessibilityNodeInfo.getDrawingOrder()).put("important-for-accessibility", accessibilityNodeInfo.isImportantForAccessibility());
        }
    }

    /* compiled from: EndToEndDumpsysHelper.kt */
    @b0(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0003J%\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J-\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0002\u0010&J\u0018\u0010'\u001a\u00020(2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J(\u0010)\u001a\u00020(2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u0019H\u0002J\u0018\u0010,\u001a\u00020(2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010-\u001a\u00020(2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010.\u001a\u00020(2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0014H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/EndToEndDumpsysHelper$Companion;", "", "()V", "ALL_ROOTS_ARGUMENT", "", "E2E_ARGUMENT", "LITHO_VIEW_CLASS", "LITHO_VIEW_TEST_HELPER_CLASS", "LITHO_VIEW_TO_STRING_METHOD", "RC_TEXT_VIEW_SIMPLE_CLASS_NAME", "TOP_ROOT_ARGUMENT", "WITH_PROPS_ARGUMENT", "WITH_WEBVIEW_ARGUMENT", "instance", "Lcom/facebook/internal/logging/dumpsys/EndToEndDumpsysHelper;", "rcTextViewGetTextMethod", "Ljava/lang/reflect/Method;", "createNodeInfoFromView", "Landroid/view/accessibility/AccessibilityNodeInfo;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "fixString", "str", "", "maxLength", "", "getTextFromRcTextView", "hasArgument", "", "args", "", "argument", "([Ljava/lang/String;Ljava/lang/String;)Z", "isExtendsLithoView", "maybeDump", "prefix", "writer", "Ljava/io/PrintWriter;", "(Ljava/lang/String;Ljava/io/PrintWriter;[Ljava/lang/String;)Z", "maybeWriteViewTestIdFromTag", "", "writeViewBounds", "leftOffset", "topOffset", "writeViewFlags", "writeViewTestId", "writeViewText", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final AccessibilityNodeInfo createNodeInfoFromView(View view) {
            if (view == null) {
                return null;
            }
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
            try {
                view.onInitializeAccessibilityNodeInfo(obtain);
                return obtain;
            } catch (NullPointerException unused) {
                if (obtain != null) {
                    obtain.recycle();
                }
                return null;
            }
        }

        public final String fixString(CharSequence charSequence, int i) {
            if (charSequence != null) {
                if (charSequence.length() == 0) {
                    return "";
                }
                String k2 = u.k2(u.k2(u.k2(charSequence.toString(), " \n", " ", false, 4, (Object) null), "\n", " ", false, 4, (Object) null), "\"", "", false, 4, (Object) null);
                if (charSequence.length() > i) {
                    StringBuilder sb = new StringBuilder();
                    Objects.requireNonNull(k2, "null cannot be cast to non-null type java.lang.String");
                    String substring = k2.substring(0, i);
                    f0.o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sb.append(substring);
                    sb.append("...");
                    return sb.toString();
                }
                return k2;
            }
            return "";
        }

        @SuppressLint({"PrivateApi", "ReflectionMethodUse"})
        private final String getTextFromRcTextView(View view) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
            if (EndToEndDumpsysHelper.rcTextViewGetTextMethod == null) {
                EndToEndDumpsysHelper.rcTextViewGetTextMethod = view.getClass().getDeclaredMethod("getText", new Class[0]);
            }
            Method method = EndToEndDumpsysHelper.rcTextViewGetTextMethod;
            Object invoke = method != null ? method.invoke(view, new Object[0]) : null;
            if (invoke != null) {
                return invoke.toString();
            }
            return null;
        }

        public final boolean hasArgument(String[] strArr, String str) {
            if (strArr == null) {
                return false;
            }
            for (String str2 : strArr) {
                if (u.K1(str, str2, true)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isExtendsLithoView(View view) {
            for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                if (f0.g(cls.getName(), EndToEndDumpsysHelper.LITHO_VIEW_CLASS)) {
                    return true;
                }
            }
            return false;
        }

        private final void maybeWriteViewTestIdFromTag(PrintWriter printWriter, View view) {
            Object tag = view.getTag();
            if (!(tag instanceof String)) {
                tag = null;
            }
            String str = (String) tag;
            if (str != null) {
                if (str.length() == 0) {
                    return;
                }
                printWriter.print(" app:tag/");
                printWriter.print(fixString(str, 60));
            }
        }

        public final void writeViewBounds(PrintWriter printWriter, View view, int i, int i2) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            printWriter.print(" ");
            printWriter.print(iArr[0] - i);
            printWriter.print(",");
            printWriter.print(iArr[1] - i2);
            printWriter.print("-");
            printWriter.print((iArr[0] + view.getWidth()) - i);
            printWriter.print(",");
            printWriter.print((iArr[1] + view.getHeight()) - i2);
        }

        public final void writeViewFlags(PrintWriter printWriter, View view) {
            printWriter.print(" ");
            int visibility = view.getVisibility();
            String str = Consts.DOT;
            if (visibility == 0) {
                printWriter.print("V");
            } else if (visibility == 4) {
                printWriter.print("I");
            } else if (visibility != 8) {
                printWriter.print(Consts.DOT);
            } else {
                printWriter.print("G");
            }
            printWriter.print(view.isFocusable() ? "F" : Consts.DOT);
            printWriter.print(view.isEnabled() ? "E" : Consts.DOT);
            printWriter.print(Consts.DOT);
            printWriter.print(view.isHorizontalScrollBarEnabled() ? "H" : Consts.DOT);
            printWriter.print(view.isVerticalScrollBarEnabled() ? "V" : Consts.DOT);
            printWriter.print(view.isClickable() ? "C" : Consts.DOT);
            printWriter.print(view.isLongClickable() ? "L" : Consts.DOT);
            printWriter.print(" ");
            printWriter.print(view.isFocused() ? "F" : Consts.DOT);
            printWriter.print(view.isSelected() ? "S" : Consts.DOT);
            printWriter.print(view.isHovered() ? "H" : Consts.DOT);
            printWriter.print(view.isActivated() ? "A" : Consts.DOT);
            if (view.isDirty()) {
                str = "D";
            }
            printWriter.print(str);
        }

        public final void writeViewTestId(PrintWriter printWriter, View view) {
            String str;
            try {
                int id = view.getId();
                if (id == -1) {
                    maybeWriteViewTestIdFromTag(printWriter, view);
                    return;
                }
                printWriter.append(" #");
                printWriter.append((CharSequence) Integer.toHexString(id));
                Resources resources = view.getResources();
                if (id > 0 && resources != null) {
                    int i = (-16777216) & id;
                    if (i == 16777216) {
                        str = "android";
                    } else if (i != 2130706432) {
                        str = resources.getResourcePackageName(id);
                        f0.o(str, "resources.getResourcePackageName(id)");
                    } else {
                        str = "app";
                    }
                    printWriter.print(" ");
                    printWriter.print(str);
                    printWriter.print(CertificateUtil.DELIMITER);
                    printWriter.print(resources.getResourceTypeName(id));
                    printWriter.print("/");
                    printWriter.print(resources.getResourceEntryName(id));
                    return;
                }
                maybeWriteViewTestIdFromTag(printWriter, view);
            } catch (Exception unused) {
                maybeWriteViewTestIdFromTag(printWriter, view);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:79:0x003d, code lost:
            if ((r0.length() == 0) != false) goto L31;
         */
        @android.annotation.SuppressLint({"ReflectionMethodUse"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void writeViewText(java.io.PrintWriter r8, android.view.View r9) {
            /*
                r7 = this;
                r0 = 0
                boolean r1 = r9 instanceof android.widget.TextView     // Catch: java.lang.Exception -> La0
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L13
                android.widget.TextView r9 = (android.widget.TextView) r9     // Catch: java.lang.Exception -> La0
                java.lang.CharSequence r9 = r9.getText()     // Catch: java.lang.Exception -> La0
                java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> La0
                goto L80
            L13:
                java.lang.Class r1 = r9.getClass()     // Catch: java.lang.Exception -> La0
                java.lang.String r1 = r1.getSimpleName()     // Catch: java.lang.Exception -> La0
                java.lang.String r4 = "RCTextView"
                boolean r1 = n.l2.v.f0.g(r1, r4)     // Catch: java.lang.Exception -> La0
                if (r1 == 0) goto L28
                java.lang.String r9 = r7.getTextFromRcTextView(r9)     // Catch: java.lang.Exception -> La0
                goto L80
            L28:
                java.lang.CharSequence r1 = r9.getContentDescription()     // Catch: java.lang.Exception -> La0
                if (r1 == 0) goto L32
                java.lang.String r0 = r1.toString()     // Catch: java.lang.Exception -> La0
            L32:
                if (r0 == 0) goto L3f
                int r1 = r0.length()     // Catch: java.lang.Exception -> La0
                if (r1 != 0) goto L3c
                r1 = 1
                goto L3d
            L3c:
                r1 = 0
            L3d:
                if (r1 == 0) goto L7f
            L3f:
                java.lang.Object r9 = r9.getTag()     // Catch: java.lang.Exception -> La0
                if (r9 == 0) goto L7f
                java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> La0
                int r0 = r9.length()     // Catch: java.lang.Exception -> La0
                int r0 = r0 - r3
                r1 = 0
                r4 = 0
            L50:
                if (r1 > r0) goto L75
                if (r4 != 0) goto L56
                r5 = r1
                goto L57
            L56:
                r5 = r0
            L57:
                char r5 = r9.charAt(r5)     // Catch: java.lang.Exception -> La0
                r6 = 32
                int r5 = n.l2.v.f0.t(r5, r6)     // Catch: java.lang.Exception -> La0
                if (r5 > 0) goto L65
                r5 = 1
                goto L66
            L65:
                r5 = 0
            L66:
                if (r4 != 0) goto L6f
                if (r5 != 0) goto L6c
                r4 = 1
                goto L50
            L6c:
                int r1 = r1 + 1
                goto L50
            L6f:
                if (r5 != 0) goto L72
                goto L75
            L72:
                int r0 = r0 + (-1)
                goto L50
            L75:
                int r0 = r0 + r3
                java.lang.CharSequence r9 = r9.subSequence(r1, r0)     // Catch: java.lang.Exception -> La0
                java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> La0
                goto L80
            L7f:
                r9 = r0
            L80:
                if (r9 == 0) goto La0
                int r0 = r9.length()     // Catch: java.lang.Exception -> La0
                if (r0 != 0) goto L89
                r2 = 1
            L89:
                if (r2 == 0) goto L8c
                goto La0
            L8c:
                java.lang.String r0 = " text=\""
                r8.print(r0)     // Catch: java.lang.Exception -> La0
                r0 = 600(0x258, float:8.41E-43)
                java.lang.String r9 = r7.fixString(r9, r0)     // Catch: java.lang.Exception -> La0
                r8.print(r9)     // Catch: java.lang.Exception -> La0
                java.lang.String r9 = "\""
                r8.print(r9)     // Catch: java.lang.Exception -> La0
            La0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.logging.dumpsys.EndToEndDumpsysHelper.Companion.writeViewText(java.io.PrintWriter, android.view.View):void");
        }

        @k
        public final boolean maybeDump(@d String str, @d PrintWriter printWriter, @e String[] strArr) {
            f0.p(str, "prefix");
            f0.p(printWriter, "writer");
            if (strArr != null) {
                if ((!(strArr.length == 0)) && f0.g("e2e", strArr[0])) {
                    if (EndToEndDumpsysHelper.instance == null) {
                        EndToEndDumpsysHelper.instance = new EndToEndDumpsysHelper();
                    }
                    EndToEndDumpsysHelper endToEndDumpsysHelper = EndToEndDumpsysHelper.instance;
                    if (endToEndDumpsysHelper != null) {
                        endToEndDumpsysHelper.dumpViewHierarchy(str, printWriter, strArr);
                    }
                    return true;
                }
            }
            return false;
        }

        public /* synthetic */ Companion(n.l2.v.u uVar) {
            this();
        }
    }

    public final void dumpViewHierarchy(String str, PrintWriter printWriter, String[] strArr) {
        View view;
        printWriter.print(str);
        printWriter.println("Top Level Window View Hierarchy:");
        Companion companion = Companion;
        boolean hasArgument = companion.hasArgument(strArr, ALL_ROOTS_ARGUMENT);
        boolean hasArgument2 = companion.hasArgument(strArr, TOP_ROOT_ARGUMENT);
        boolean hasArgument3 = companion.hasArgument(strArr, WITH_WEBVIEW_ARGUMENT);
        boolean hasArgument4 = companion.hasArgument(strArr, WITH_PROPS_ARGUMENT);
        try {
            List<AndroidRootResolver.Root> listActiveRoots = this.rootResolver.listActiveRoots();
            if (listActiveRoots != null && !listActiveRoots.isEmpty()) {
                Collections.reverse(listActiveRoots);
                WindowManager.LayoutParams layoutParams = null;
                for (AndroidRootResolver.Root root : listActiveRoots) {
                    if (root != null && (view = root.getView()) != null && view.getVisibility() == 0) {
                        if (!hasArgument && layoutParams != null && Math.abs(root.getParam().type - layoutParams.type) != 1) {
                            break;
                        }
                        dumpViewHierarchy(str + BeautifyTextView.c, printWriter, root.getView(), 0, 0, hasArgument3, hasArgument4);
                        WindowManager.LayoutParams param = root.getParam();
                        if (hasArgument2) {
                            break;
                        }
                        layoutParams = param;
                    }
                }
                this.webViewDumpHelper.dump(printWriter);
            }
        } catch (Exception e) {
            printWriter.println("Failure in view hierarchy dump: " + e.getMessage());
        }
    }

    @k
    public static final boolean maybeDump(@d String str, @d PrintWriter printWriter, @e String[] strArr) {
        return Companion.maybeDump(str, printWriter, strArr);
    }

    private final void writeLithoViewSubHierarchy(PrintWriter printWriter, View view, String str, boolean z) {
        try {
            if (this.lithoViewToStringMethod == null) {
                Class<?> cls = Class.forName(LITHO_VIEW_TEST_HELPER_CLASS);
                f0.o(cls, "Class.forName(LITHO_VIEW_TEST_HELPER_CLASS)");
                this.lithoViewToStringMethod = cls.getDeclaredMethod(LITHO_VIEW_TO_STRING_METHOD, View.class, Integer.TYPE, Boolean.TYPE);
            }
            Method method = this.lithoViewToStringMethod;
            Object invoke = method != null ? method.invoke(null, view, Integer.valueOf((str.length() / 2) + 1), Boolean.valueOf(z)) : null;
            if (invoke != null) {
                f0.o(printWriter.append((CharSequence) ((String) invoke)), "writer.append(lithoViewDump)");
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception e) {
            printWriter.append((CharSequence) str).append("Failed litho view sub hierarch dump: ").append((CharSequence) Companion.fixString(e.getMessage(), 100)).println();
        }
    }

    private final void dumpViewHierarchy(String str, PrintWriter printWriter, View view, int i, int i2, boolean z, boolean z2) {
        ViewGroup viewGroup;
        int childCount;
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.print(view.getClass().getName());
        printWriter.print("{");
        printWriter.print(Integer.toHexString(view.hashCode()));
        Companion companion = Companion;
        companion.writeViewFlags(printWriter, view);
        companion.writeViewBounds(printWriter, view, i, i2);
        companion.writeViewTestId(printWriter, view);
        companion.writeViewText(printWriter, view);
        if (z2 && Build.VERSION.SDK_INT >= 21) {
            Api21Utils.INSTANCE.writeExtraProps(printWriter, view);
        }
        printWriter.println(g.d);
        if (companion.isExtendsLithoView(view)) {
            writeLithoViewSubHierarchy(printWriter, view, str, z2);
        }
        if (z && (view instanceof WebView)) {
            this.webViewDumpHelper.handle((WebView) view);
        }
        if ((view instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view).getChildCount()) > 0) {
            String str2 = str + BeautifyTextView.c;
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            for (int i3 = 0; i3 < childCount; i3++) {
                dumpViewHierarchy(str2, printWriter, viewGroup.getChildAt(i3), iArr[0], iArr[1], z, z2);
            }
        }
    }
}
