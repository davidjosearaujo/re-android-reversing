package z4;

import f.t;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import p.n0;
import y4.q;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a */
    public static final f f6940a;

    /* loaded from: classes.dex */
    public static class a extends f {

        /* renamed from: b */
        public final Class<?> f6941b;

        /* renamed from: c */
        public final e<Socket> f6942c;

        /* renamed from: d */
        public final e<Socket> f6943d;
        public final e<Socket> e;

        /* renamed from: f */
        public final e<Socket> f6944f;

        public a(Class cls, e eVar, e eVar2, e eVar3, e eVar4) {
            this.f6941b = cls;
            this.f6942c = eVar;
            this.f6943d = eVar2;
            this.e = eVar3;
            this.f6944f = eVar4;
        }

        @Override // z4.f
        public final void b(SSLSocket sSLSocket, String str, List<q> list) {
            if (str != null) {
                this.f6942c.c(sSLSocket, Boolean.TRUE);
                this.f6943d.c(sSLSocket, str);
            }
            e<Socket> eVar = this.f6944f;
            if (eVar != null) {
                if (eVar.a(sSLSocket.getClass()) != null) {
                    Object[] objArr = new Object[1];
                    i6.d dVar = new i6.d();
                    int size = list.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        q qVar = list.get(i7);
                        if (qVar != q.f6784g) {
                            dVar.z(qVar.f6789f.length());
                            String str2 = qVar.f6789f;
                            dVar.G(0, str2.length(), str2);
                        }
                    }
                    objArr[0] = dVar.u();
                    e<Socket> eVar2 = this.f6944f;
                    eVar2.getClass();
                    try {
                        eVar2.b(sSLSocket, objArr);
                    } catch (InvocationTargetException e) {
                        Throwable targetException = e.getTargetException();
                        if (targetException instanceof RuntimeException) {
                            throw ((RuntimeException) targetException);
                        }
                        AssertionError assertionError = new AssertionError("Unexpected exception");
                        assertionError.initCause(targetException);
                        throw assertionError;
                    }
                }
            }
        }

        @Override // z4.f
        public final void c(Socket socket, InetSocketAddress inetSocketAddress, int i7) {
            try {
                socket.connect(inetSocketAddress, i7);
            } catch (AssertionError e) {
                if (!h.h(e)) {
                    throw e;
                }
                throw new IOException(e);
            } catch (SecurityException e7) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e7);
                throw iOException;
            }
        }

        @Override // z4.f
        public final String d(SSLSocket sSLSocket) {
            e<Socket> eVar = this.e;
            if (eVar == null) {
                return null;
            }
            if (eVar.a(sSLSocket.getClass()) != null) {
                e<Socket> eVar2 = this.e;
                Object[] objArr = new Object[0];
                eVar2.getClass();
                try {
                    byte[] bArr = (byte[]) eVar2.b(sSLSocket, objArr);
                    if (bArr != null) {
                        return new String(bArr, h.f6957c);
                    }
                    return null;
                } catch (InvocationTargetException e) {
                    Throwable targetException = e.getTargetException();
                    if (targetException instanceof RuntimeException) {
                        throw ((RuntimeException) targetException);
                    }
                    AssertionError assertionError = new AssertionError("Unexpected exception");
                    assertionError.initCause(targetException);
                    throw assertionError;
                }
            }
            return null;
        }

        @Override // z4.f
        public final X509TrustManager f(SSLSocketFactory sSLSocketFactory) {
            Object e = f.e(sSLSocketFactory, this.f6941b, "sslParameters");
            if (e == null) {
                try {
                    e = f.e(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
                } catch (ClassNotFoundException unused) {
                    return null;
                }
            }
            X509TrustManager x509TrustManager = (X509TrustManager) f.e(e, X509TrustManager.class, "x509TrustManager");
            return x509TrustManager != null ? x509TrustManager : (X509TrustManager) f.e(e, X509TrustManager.class, "trustManager");
        }

        @Override // z4.f
        public final d5.c g(X509TrustManager x509TrustManager) {
            n0 n0Var;
            try {
                Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
                declaredMethod.setAccessible(true);
                n0Var = new n0(x509TrustManager, declaredMethod);
            } catch (NoSuchMethodException unused) {
                n0Var = null;
            }
            return n0Var != null ? n0Var : new t(x509TrustManager.getAcceptedIssuers());
        }
    }

    /* loaded from: classes.dex */
    public static class b extends f {

        /* renamed from: b */
        public final Class<?> f6945b;

        public b(Class<?> cls) {
            this.f6945b = cls;
        }

        @Override // z4.f
        public final X509TrustManager f(SSLSocketFactory sSLSocketFactory) {
            Object e = f.e(sSLSocketFactory, this.f6945b, "context");
            if (e == null) {
                return null;
            }
            return (X509TrustManager) f.e(e, X509TrustManager.class, "trustManager");
        }
    }

    /* loaded from: classes.dex */
    public static class c extends b {

        /* renamed from: c */
        public final Method f6946c;

        /* renamed from: d */
        public final Method f6947d;
        public final Method e;

        /* renamed from: f */
        public final Class<?> f6948f;

        /* renamed from: g */
        public final Class<?> f6949g;

        public c(Class<?> cls, Method method, Method method2, Method method3, Class<?> cls2, Class<?> cls3) {
            super(cls);
            this.f6946c = method;
            this.f6947d = method2;
            this.e = method3;
            this.f6948f = cls2;
            this.f6949g = cls3;
        }

        @Override // z4.f
        public final void a(SSLSocket sSLSocket) {
            try {
                this.e.invoke(null, sSLSocket);
            } catch (IllegalAccessException | InvocationTargetException unused) {
                throw new AssertionError();
            }
        }

        @Override // z4.f
        public final void b(SSLSocket sSLSocket, String str, List<q> list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                q qVar = list.get(i7);
                if (qVar != q.f6784g) {
                    arrayList.add(qVar.f6789f);
                }
            }
            try {
                this.f6946c.invoke(null, sSLSocket, Proxy.newProxyInstance(f.class.getClassLoader(), new Class[]{this.f6948f, this.f6949g}, new d(arrayList)));
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new AssertionError(e);
            }
        }

        @Override // z4.f
        public final String d(SSLSocket sSLSocket) {
            try {
                d dVar = (d) Proxy.getInvocationHandler(this.f6947d.invoke(null, sSLSocket));
                boolean z6 = dVar.f6951b;
                if (!z6 && dVar.f6952c == null) {
                    z4.b.f6934a.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                } else if (z6) {
                    return null;
                } else {
                    return dVar.f6952c;
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
                throw new AssertionError();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements InvocationHandler {

        /* renamed from: a */
        public final List<String> f6950a;

        /* renamed from: b */
        public boolean f6951b;

        /* renamed from: c */
        public String f6952c;

        public d(ArrayList arrayList) {
            this.f6950a = arrayList;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            Object obj2;
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = h.f6956b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f6951b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f6950a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                    Object obj3 = objArr[0];
                    if (obj3 instanceof List) {
                        List list = (List) obj3;
                        int size = list.size();
                        int i7 = 0;
                        while (true) {
                            if (i7 >= size) {
                                obj2 = this.f6950a.get(0);
                                break;
                            } else if (this.f6950a.contains(list.get(i7))) {
                                obj2 = list.get(i7);
                                break;
                            } else {
                                i7++;
                            }
                        }
                        String str = (String) obj2;
                        this.f6952c = str;
                        return str;
                    }
                }
                if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                    this.f6952c = (String) objArr[0];
                    return null;
                }
                return method.invoke(this, objArr);
            }
        }
    }

    static {
        f fVar;
        Class<?> cls;
        f bVar;
        e eVar;
        e eVar2;
        try {
            try {
                try {
                    cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
                } catch (ClassNotFoundException unused) {
                    cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
                }
                Class<?> cls2 = cls;
                e eVar3 = null;
                e eVar4 = new e(null, "setUseSessionTickets", Boolean.TYPE);
                e eVar5 = new e(null, "setHostname", String.class);
                try {
                    Class<?> cls3 = Class.forName("android.net.TrafficStats");
                    cls3.getMethod("tagSocket", Socket.class);
                    cls3.getMethod("untagSocket", Socket.class);
                    Class.forName("android.net.Network");
                    e eVar6 = new e(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                    try {
                        eVar3 = new e(null, "setAlpnProtocols", byte[].class);
                    } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                    }
                    eVar = eVar6;
                    eVar2 = eVar3;
                } catch (ClassNotFoundException | NoSuchMethodException unused3) {
                    eVar = null;
                    eVar2 = null;
                }
                fVar = new a(cls2, eVar4, eVar5, eVar, eVar2);
            } catch (ClassNotFoundException unused4) {
                Class<?> cls4 = Class.forName("sun.security.ssl.SSLContextImpl");
                try {
                    Class<?> cls5 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                    bVar = new c(cls4, cls5.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider")), cls5.getMethod("get", SSLSocket.class), cls5.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
                } catch (ClassNotFoundException | NoSuchMethodException unused5) {
                    bVar = new b(cls4);
                    fVar = bVar;
                    f6940a = fVar;
                }
                fVar = bVar;
            }
        } catch (ClassNotFoundException unused6) {
            fVar = new f();
        }
        f6940a = fVar;
    }

    public static <T> T e(Object obj, Class<T> cls, String str) {
        Object e;
        for (Class<?> cls2 = obj.getClass(); cls2 != Object.class; cls2 = cls2.getSuperclass()) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (obj2 != null && cls.isInstance(obj2)) {
                    return cls.cast(obj2);
                }
                return null;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (NoSuchFieldException unused2) {
            }
        }
        if (str.equals("delegate") || (e = e(obj, Object.class, "delegate")) == null) {
            return null;
        }
        return (T) e(e, cls, str);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void b(SSLSocket sSLSocket, String str, List<q> list) {
    }

    public void c(Socket socket, InetSocketAddress inetSocketAddress, int i7) {
        socket.connect(inetSocketAddress, i7);
    }

    public String d(SSLSocket sSLSocket) {
        return null;
    }

    public X509TrustManager f(SSLSocketFactory sSLSocketFactory) {
        return null;
    }

    public d5.c g(X509TrustManager x509TrustManager) {
        return new t(x509TrustManager.getAcceptedIssuers());
    }
}
