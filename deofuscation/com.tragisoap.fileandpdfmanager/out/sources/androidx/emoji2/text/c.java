package androidx.emoji2.text;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c {
    /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.emoji2.text.l a(android.content.Context r8) {
        /*
            android.content.pm.PackageManager r0 = r8.getPackageManager()
            java.lang.String r1 = "Package manager required to locate emoji font provider"
            a0.e.i(r0, r1)
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "androidx.content.action.LOAD_EMOJI_FONT"
            r1.<init>(r2)
            r2 = 0
            java.util.List r1 = r0.queryIntentContentProviders(r1, r2)
            java.util.Iterator r1 = r1.iterator()
        L_0x0019:
            boolean r3 = r1.hasNext()
            r4 = 0
            if (r3 == 0) goto L_0x0039
            java.lang.Object r3 = r1.next()
            android.content.pm.ResolveInfo r3 = (android.content.pm.ResolveInfo) r3
            android.content.pm.ProviderInfo r3 = r3.providerInfo
            r5 = 1
            if (r3 == 0) goto L_0x0035
            android.content.pm.ApplicationInfo r6 = r3.applicationInfo
            if (r6 == 0) goto L_0x0035
            int r6 = r6.flags
            r6 = r6 & r5
            if (r6 != r5) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r5 = r2
        L_0x0036:
            if (r5 == 0) goto L_0x0019
            goto L_0x003a
        L_0x0039:
            r3 = r4
        L_0x003a:
            if (r3 != 0) goto L_0x003d
            goto L_0x006f
        L_0x003d:
            java.lang.String r1 = r3.authority     // Catch: NameNotFoundException -> 0x0069
            java.lang.String r3 = r3.packageName     // Catch: NameNotFoundException -> 0x0069
            r5 = 64
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r3, r5)     // Catch: NameNotFoundException -> 0x0069
            android.content.pm.Signature[] r0 = r0.signatures     // Catch: NameNotFoundException -> 0x0069
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: NameNotFoundException -> 0x0069
            r5.<init>()     // Catch: NameNotFoundException -> 0x0069
            int r6 = r0.length     // Catch: NameNotFoundException -> 0x0069
        L_0x004f:
            if (r2 >= r6) goto L_0x005d
            r7 = r0[r2]     // Catch: NameNotFoundException -> 0x0069
            byte[] r7 = r7.toByteArray()     // Catch: NameNotFoundException -> 0x0069
            r5.add(r7)     // Catch: NameNotFoundException -> 0x0069
            int r2 = r2 + 1
            goto L_0x004f
        L_0x005d:
            java.util.List r0 = java.util.Collections.singletonList(r5)     // Catch: NameNotFoundException -> 0x0069
            m1.f r2 = new m1.f     // Catch: NameNotFoundException -> 0x0069
            java.lang.String r5 = "emojicompat-emoji-font"
            r2.<init>(r1, r3, r5, r0)     // Catch: NameNotFoundException -> 0x0069
            goto L_0x0070
        L_0x0069:
            r0 = move-exception
            java.lang.String r1 = "emoji2.text.DefaultEmojiConfig"
            android.util.Log.wtf(r1, r0)
        L_0x006f:
            r2 = r4
        L_0x0070:
            if (r2 != 0) goto L_0x0073
            goto L_0x0078
        L_0x0073:
            androidx.emoji2.text.l r4 = new androidx.emoji2.text.l
            r4.<init>(r8, r2)
        L_0x0078:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.c.a(android.content.Context):androidx.emoji2.text.l");
    }
}
