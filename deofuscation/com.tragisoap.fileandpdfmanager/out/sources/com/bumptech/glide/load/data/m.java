package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import java.io.InputStream;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class m extends l<InputStream> {

    /* renamed from: i  reason: collision with root package name */
    public static final UriMatcher f2688i;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f2688i = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public m(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.l
    public final void c(InputStream inputStream) {
        inputStream.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    @Override // com.bumptech.glide.load.data.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(android.content.ContentResolver r3, android.net.Uri r4) {
        /*
            r2 = this;
            android.content.UriMatcher r2 = com.bumptech.glide.load.data.m.f2688i
            int r2 = r2.match(r4)
            r0 = 1
            if (r2 == r0) goto L_0x0019
            r1 = 3
            if (r2 == r1) goto L_0x0014
            r1 = 5
            if (r2 == r1) goto L_0x0019
            java.io.InputStream r2 = r3.openInputStream(r4)
            goto L_0x0023
        L_0x0014:
            java.io.InputStream r2 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(r3, r4, r0)
            goto L_0x0023
        L_0x0019:
            android.net.Uri r2 = android.provider.ContactsContract.Contacts.lookupContact(r3, r4)
            if (r2 == 0) goto L_0x003d
            java.io.InputStream r2 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(r3, r2, r0)
        L_0x0023:
            if (r2 == 0) goto L_0x0026
            return r2
        L_0x0026:
            java.io.FileNotFoundException r2 = new java.io.FileNotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "InputStream is null for "
            r3.append(r0)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x003d:
            java.io.FileNotFoundException r2 = new java.io.FileNotFoundException
            java.lang.String r3 = "Contact cannot be found"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.m.d(android.content.ContentResolver, android.net.Uri):java.lang.Object");
    }
}