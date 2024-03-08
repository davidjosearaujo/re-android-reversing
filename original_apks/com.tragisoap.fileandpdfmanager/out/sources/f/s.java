package f;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class s {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a implements Executor {

        /* renamed from: f  reason: collision with root package name */
        public final Object f4015f = new Object();

        /* renamed from: g  reason: collision with root package name */
        public final ArrayDeque f4016g = new ArrayDeque();

        /* renamed from: h  reason: collision with root package name */
        public final Executor f4017h;

        /* renamed from: i  reason: collision with root package name */
        public Runnable f4018i;

        public a(b bVar) {
            this.f4017h = bVar;
        }

        public final void a() {
            synchronized (this.f4015f) {
                Runnable runnable = (Runnable) this.f4016g.poll();
                this.f4018i = runnable;
                if (runnable != null) {
                    this.f4017h.execute(runnable);
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            synchronized (this.f4015f) {
                this.f4016g.add(new r(this, 0, runnable));
                if (this.f4018i == null) {
                    a();
                }
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    /*  JADX ERROR: NullPointerException in pass: BlockProcessor
        java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
        	at java.base/java.util.BitSet.or(BitSet.java:943)
        	at jadx.core.utils.BlockUtils.lambda$getPathCross$3(BlockUtils.java:704)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:704)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.searchBottomBlock(BlockExceptionHandler.java:412)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.wrapBlocksWithTryCatch(BlockExceptionHandler.java:329)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.connectExcHandlers(BlockExceptionHandler.java:84)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.process(BlockExceptionHandler.java:59)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.independentBlockTreeMod(BlockProcessor.java:452)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:51)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static void a(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "locales"
            java.lang.String r1 = "AppLocalesStorageHelper"
            java.lang.String r2 = ""
            boolean r2 = r7.equals(r2)
            java.lang.String r3 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            if (r2 == 0) goto L_0x0012
            r6.deleteFile(r3)
            return
        L_0x0012:
            r2 = 0
            java.io.FileOutputStream r6 = r6.openFileOutput(r3, r2)     // Catch: FileNotFoundException -> 0x0074
            org.xmlpull.v1.XmlSerializer r2 = android.util.Xml.newSerializer()
            r3 = 0
            r2.setOutput(r6, r3)     // Catch: Exception -> 0x0055, all -> 0x0053
            java.lang.String r4 = "UTF-8"
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch: Exception -> 0x0055, all -> 0x0053
            r2.startDocument(r4, r5)     // Catch: Exception -> 0x0055, all -> 0x0053
            r2.startTag(r3, r0)     // Catch: Exception -> 0x0055, all -> 0x0053
            java.lang.String r4 = "application_locales"
            r2.attribute(r3, r4, r7)     // Catch: Exception -> 0x0055, all -> 0x0053
            r2.endTag(r3, r0)     // Catch: Exception -> 0x0055, all -> 0x0053
            r2.endDocument()     // Catch: Exception -> 0x0055, all -> 0x0053
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: Exception -> 0x0055, all -> 0x0053
            r0.<init>()     // Catch: Exception -> 0x0055, all -> 0x0053
            java.lang.String r2 = "Storing App Locales : app-locales: "
            r0.append(r2)     // Catch: Exception -> 0x0055, all -> 0x0053
            r0.append(r7)     // Catch: Exception -> 0x0055, all -> 0x0053
            java.lang.String r2 = " persisted successfully."
            r0.append(r2)     // Catch: Exception -> 0x0055, all -> 0x0053
            java.lang.String r0 = r0.toString()     // Catch: Exception -> 0x0055, all -> 0x0053
            android.util.Log.d(r1, r0)     // Catch: Exception -> 0x0055, all -> 0x0053
            if (r6 == 0) goto L_0x006d
        L_0x004f:
            r6.close()     // Catch: IOException -> 0x006d
            goto L_0x006d
        L_0x0053:
            r7 = move-exception
            goto L_0x006e
        L_0x0055:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: all -> 0x0053
            r2.<init>()     // Catch: all -> 0x0053
            java.lang.String r3 = "Storing App Locales : Failed to persist app-locales: "
            r2.append(r3)     // Catch: all -> 0x0053
            r2.append(r7)     // Catch: all -> 0x0053
            java.lang.String r7 = r2.toString()     // Catch: all -> 0x0053
            android.util.Log.w(r1, r7, r0)     // Catch: all -> 0x0053
            if (r6 == 0) goto L_0x006d
            goto L_0x004f
        L_0x006d:
            return
        L_0x006e:
            if (r6 == 0) goto L_0x0073
            r6.close()     // Catch: IOException -> 0x0073
        L_0x0073:
            throw r7
        L_0x0074:
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r2] = r3
            java.lang.String r7 = "Storing App Locales : FileNotFoundException: Cannot open file %s for writing "
            java.lang.String r6 = java.lang.String.format(r7, r6)
            android.util.Log.w(r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.s.a(android.content.Context, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        r2 = r4.getAttributeValue(null, "application_locales");
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r3 != null) goto L_0x0042;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r3 == null) goto L_0x0050;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
        if (r2.isEmpty() == false) goto L_0x0056;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
        android.util.Log.d("AppLocalesStorageHelper", "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: " + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:
        r9.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(android.content.Context r9) {
        /*
            java.lang.String r0 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.lang.String r1 = "AppLocalesStorageHelper"
            java.lang.String r2 = ""
            java.io.FileInputStream r3 = r9.openFileInput(r0)     // Catch: FileNotFoundException -> 0x0075
            org.xmlpull.v1.XmlPullParser r4 = android.util.Xml.newPullParser()     // Catch: XmlPullParserException | IOException -> 0x0048, all -> 0x0046
            java.lang.String r5 = "UTF-8"
            r4.setInput(r3, r5)     // Catch: XmlPullParserException | IOException -> 0x0048, all -> 0x0046
            int r5 = r4.getDepth()     // Catch: XmlPullParserException | IOException -> 0x0048, all -> 0x0046
        L_0x0017:
            int r6 = r4.next()     // Catch: XmlPullParserException | IOException -> 0x0048, all -> 0x0046
            r7 = 1
            if (r6 == r7) goto L_0x0040
            r7 = 3
            if (r6 != r7) goto L_0x0027
            int r8 = r4.getDepth()     // Catch: XmlPullParserException | IOException -> 0x0048, all -> 0x0046
            if (r8 <= r5) goto L_0x0040
        L_0x0027:
            if (r6 == r7) goto L_0x0017
            r7 = 4
            if (r6 != r7) goto L_0x002d
            goto L_0x0017
        L_0x002d:
            java.lang.String r6 = r4.getName()     // Catch: XmlPullParserException | IOException -> 0x0048, all -> 0x0046
            java.lang.String r7 = "locales"
            boolean r6 = r6.equals(r7)     // Catch: XmlPullParserException | IOException -> 0x0048, all -> 0x0046
            if (r6 == 0) goto L_0x0017
            r5 = 0
            java.lang.String r6 = "application_locales"
            java.lang.String r2 = r4.getAttributeValue(r5, r6)     // Catch: XmlPullParserException | IOException -> 0x0048, all -> 0x0046
        L_0x0040:
            if (r3 == 0) goto L_0x0050
        L_0x0042:
            r3.close()     // Catch: IOException -> 0x0050
            goto L_0x0050
        L_0x0046:
            r9 = move-exception
            goto L_0x006f
        L_0x0048:
            java.lang.String r4 = "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r1, r4)     // Catch: all -> 0x0046
            if (r3 == 0) goto L_0x0050
            goto L_0x0042
        L_0x0050:
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x006b
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: "
            r9.append(r0)
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r1, r9)
            goto L_0x006e
        L_0x006b:
            r9.deleteFile(r0)
        L_0x006e:
            return r2
        L_0x006f:
            if (r3 == 0) goto L_0x0074
            r3.close()     // Catch: IOException -> 0x0074
        L_0x0074:
            throw r9
        L_0x0075:
            java.lang.String r9 = "Reading app Locales : Locales record file not found: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r1, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: f.s.b(android.content.Context):java.lang.String");
    }
}
