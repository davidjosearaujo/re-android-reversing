package b5;

import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import y4.r;
import y4.s;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a */
    public static final a f2428a = new a();

    /* renamed from: b */
    public static final String f2429b;

    /* renamed from: c */
    public static final String f2430c;

    /* loaded from: classes.dex */
    public static class a implements Comparator<String> {
        @Override // java.util.Comparator
        public final int compare(String str, String str2) {
            String str3 = str;
            String str4 = str2;
            if (str3 == str4) {
                return 0;
            }
            if (str3 == null) {
                return -1;
            }
            if (str4 == null) {
                return 1;
            }
            return String.CASE_INSENSITIVE_ORDER.compare(str3, str4);
        }
    }

    static {
        z4.f.f6940a.getClass();
        f2429b = "OkHttp-Sent-Millis";
        f2430c = "OkHttp-Received-Millis";
    }

    public static long a(y4.l lVar) {
        String a7 = lVar.a("Content-Length");
        if (a7 != null) {
            try {
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }
        return Long.parseLong(a7);
    }

    public static boolean b(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static r c(y4.b bVar, s sVar, Proxy proxy) {
        int i7 = 0;
        if (sVar.f6801c == 407) {
            ((b5.a) bVar).getClass();
            List<y4.f> b2 = sVar.b();
            r rVar = sVar.f6799a;
            y4.m mVar = rVar.f6790a;
            int size = b2.size();
            while (i7 < size) {
                y4.f fVar = b2.get(i7);
                if ("Basic".equalsIgnoreCase(fVar.f6708a)) {
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                    try {
                        PasswordAuthentication requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(inetSocketAddress.getHostName(), proxy.type() != Proxy.Type.DIRECT ? ((InetSocketAddress) proxy.address()).getAddress() : InetAddress.getByName(mVar.f6750d), inetSocketAddress.getPort(), mVar.f6747a, fVar.f6709b, fVar.f6708a, new URL(mVar.f6753h), Authenticator.RequestorType.PROXY);
                        if (requestPasswordAuthentication != null) {
                            String e = a0.e.e(requestPasswordAuthentication.getUserName(), new String(requestPasswordAuthentication.getPassword()));
                            r.a aVar = new r.a(rVar);
                            aVar.f6797c.e("Proxy-Authorization", e);
                            return aVar.a();
                        }
                    } catch (MalformedURLException e7) {
                        throw new RuntimeException(e7);
                    }
                }
                i7++;
            }
        } else {
            ((b5.a) bVar).getClass();
            List<y4.f> b7 = sVar.b();
            r rVar2 = sVar.f6799a;
            y4.m mVar2 = rVar2.f6790a;
            int size2 = b7.size();
            while (i7 < size2) {
                y4.f fVar2 = b7.get(i7);
                if ("Basic".equalsIgnoreCase(fVar2.f6708a)) {
                    try {
                        PasswordAuthentication requestPasswordAuthentication2 = Authenticator.requestPasswordAuthentication(mVar2.f6750d, (proxy == null || proxy.type() == Proxy.Type.DIRECT) ? InetAddress.getByName(mVar2.f6750d) : ((InetSocketAddress) proxy.address()).getAddress(), mVar2.e, mVar2.f6747a, fVar2.f6709b, fVar2.f6708a, new URL(mVar2.f6753h), Authenticator.RequestorType.SERVER);
                        if (requestPasswordAuthentication2 != null) {
                            String e8 = a0.e.e(requestPasswordAuthentication2.getUserName(), new String(requestPasswordAuthentication2.getPassword()));
                            r.a aVar2 = new r.a(rVar2);
                            aVar2.f6797c.e("Authorization", e8);
                            return aVar2.a();
                        }
                    } catch (MalformedURLException e9) {
                        throw new RuntimeException(e9);
                    }
                }
                i7++;
            }
        }
        return null;
    }

    public static Map d(y4.l lVar) {
        TreeMap treeMap = new TreeMap(f2428a);
        int length = lVar.f6744a.length / 2;
        for (int i7 = 0; i7 < length; i7++) {
            String b2 = lVar.b(i7);
            String d7 = lVar.d(i7);
            ArrayList arrayList = new ArrayList();
            List list = (List) treeMap.get(b2);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(d7);
            treeMap.put(b2, Collections.unmodifiableList(arrayList));
        }
        return Collections.unmodifiableMap(treeMap);
    }
}
