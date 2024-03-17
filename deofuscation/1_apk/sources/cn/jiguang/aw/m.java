package cn.jiguang.aw;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class m extends i {
    private int e;
    private int f;
    private int g;
    private g h;

    @Override // cn.jiguang.aw.i
    public void a(b bVar) {
        this.e = bVar.g();
        this.f = bVar.g();
        this.g = bVar.g();
        this.h = new g(bVar);
    }

    @Override // cn.jiguang.aw.i
    public void a(c cVar, a aVar, boolean z) {
        cVar.c(this.e);
        cVar.c(this.f);
        cVar.c(this.g);
        this.h.a(cVar, (a) null, z);
    }

    @Override // cn.jiguang.aw.i
    public String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.e + " ");
        stringBuffer.append(this.f + " ");
        stringBuffer.append(this.g + " ");
        stringBuffer.append(this.h);
        return stringBuffer.toString();
    }

    public int j() {
        return this.g;
    }

    public g k() {
        return this.h;
    }
}
