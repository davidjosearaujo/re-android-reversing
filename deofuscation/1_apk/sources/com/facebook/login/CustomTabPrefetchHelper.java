package com.facebook.login;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CustomTabPrefetchHelper extends CustomTabsServiceConnection {
    private static CustomTabsClient client;
    private static CustomTabsSession session;

    public static CustomTabsSession getPreparedSessionOnce() {
        CustomTabsSession customTabsSession = session;
        session = null;
        return customTabsSession;
    }

    public static void mayLaunchUrl(Uri uri) {
        if (session == null) {
            prepareSession();
        }
        CustomTabsSession customTabsSession = session;
        if (customTabsSession != null) {
            customTabsSession.mayLaunchUrl(uri, (Bundle) null, (List) null);
        }
    }

    private static void prepareSession() {
        CustomTabsClient customTabsClient;
        if (session != null || (customTabsClient = client) == null) {
            return;
        }
        session = customTabsClient.newSession((CustomTabsCallback) null);
    }

    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        client = customTabsClient;
        customTabsClient.warmup(0L);
        prepareSession();
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
