package cn.com.custommma.mobile.tracking.viewability.origin.support;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AtlantisUtil {
    private int cnt;
    private int len;
    private SegTree st = new SegTree(310);
    private edge[] ed = new edge[310];
    private zone[] zn = new zone[310];
    private double[] hash = new double[310];

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class SegTree {
        public node[] tree;

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public class node {
            public int key;
            public int left;
            public int right;
            public double sum;

            public node() {
            }

            public void init(int i, int i2) {
                this.left = i;
                this.right = i2;
                this.sum = 0.0d;
                this.key = 0;
            }

            public double length() {
                return AtlantisUtil.this.hash[this.right + 1] - AtlantisUtil.this.hash[this.left];
            }

            public int mid() {
                return (this.left + this.right) >> 1;
            }
        }

        public SegTree(int i) {
            int i2 = i * 3;
            this.tree = new node[i2];
            for (int i3 = 1; i3 < i2; i3++) {
                this.tree[i3] = new node();
            }
        }

        public void init(int i, int i2, int i3) {
            this.tree[i3].init(i, i2);
            if (i == i2) {
                return;
            }
            int mid = this.tree[i3].mid();
            int i4 = i3 << 1;
            init(i, mid, i4);
            init(mid + 1, i2, i4 | 1);
        }

        public void pushup(int i) {
            node[] nodeVarArr = this.tree;
            if (nodeVarArr[i].key > 0) {
                nodeVarArr[i].sum = nodeVarArr[i].length();
            } else if (nodeVarArr[i].left == nodeVarArr[i].right) {
                nodeVarArr[i].sum = 0.0d;
            } else {
                node nodeVar = nodeVarArr[i];
                int i2 = i << 1;
                nodeVar.sum = nodeVarArr[i2].sum + nodeVarArr[i2 | 1].sum;
            }
        }

        public void update(int i, int i2, int i3, int i4) {
            node[] nodeVarArr = this.tree;
            if (nodeVarArr[i3].left >= i && nodeVarArr[i3].right <= i2) {
                nodeVarArr[i3].key += i4;
                pushup(i3);
                return;
            }
            int mid = nodeVarArr[i3].mid();
            if (i <= mid) {
                update(i, i2, i3 << 1, i4);
            }
            if (i2 > mid) {
                update(i, i2, (i3 << 1) | 1, i4);
            }
            pushup(i3);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class edge implements Comparable<edge> {
        public int s;
        public int t;
        public int v;
        public double x;

        private edge() {
        }

        @Override // java.lang.Comparable
        public int compareTo(edge edgeVar) {
            double d = this.x;
            double d2 = edgeVar.x;
            if (d < d2) {
                return -1;
            }
            return (d != d2 || this.v <= edgeVar.v) ? 1 : -1;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class zone implements Comparable<zone> {
        public double h;
        public int id;

        private zone() {
        }

        @Override // java.lang.Comparable
        public int compareTo(zone zoneVar) {
            return this.h < zoneVar.h ? -1 : 1;
        }
    }

    public AtlantisUtil() {
        for (int i = 0; i <= 300; i += 2) {
            this.ed[i] = new edge();
            int i2 = i + 1;
            this.ed[i2] = new edge();
            this.zn[i] = new zone();
            this.zn[i2] = new zone();
        }
    }

    private void build() {
        Arrays.sort(this.zn, 1, (this.len * 2) + 1);
        this.cnt = 1;
        for (int i = 1; i <= this.len * 2; i++) {
            if (i > 1) {
                zone[] zoneVarArr = this.zn;
                if (zoneVarArr[i].h != zoneVarArr[i - 1].h) {
                    this.cnt++;
                }
            }
            double[] dArr = this.hash;
            int i2 = this.cnt;
            zone[] zoneVarArr2 = this.zn;
            dArr[i2] = zoneVarArr2[i].h;
            int i3 = zoneVarArr2[i].id;
            if (i3 > 0) {
                edge[] edgeVarArr = this.ed;
                edge edgeVar = edgeVarArr[i3];
                edgeVarArr[i3 + 1].s = i2;
                edgeVar.s = i2;
            } else {
                edge[] edgeVarArr2 = this.ed;
                int i4 = -i3;
                edge edgeVar2 = edgeVarArr2[i4];
                edgeVarArr2[i4 + 1].t = i2;
                edgeVar2.t = i2;
            }
        }
    }

    private void fill(List<Rectangle> list) {
        int i = 1;
        for (Rectangle rectangle : list) {
            edge[] edgeVarArr = this.ed;
            edgeVarArr[i].x = rectangle.x1;
            edgeVarArr[i].v = 1;
            zone[] zoneVarArr = this.zn;
            zoneVarArr[i].id = i;
            zoneVarArr[i].h = rectangle.y1;
            int i2 = i + 1;
            edgeVarArr[i2].x = rectangle.x2;
            edgeVarArr[i2].v = -1;
            zoneVarArr[i2].id = -i;
            zoneVarArr[i2].h = rectangle.y2;
            i += 2;
        }
    }

    public double calOverlapArea(List<Rectangle> list) {
        double d = 0.0d;
        try {
            System.currentTimeMillis();
            this.len = list.size();
            fill(list);
            build();
            Arrays.sort(this.ed, 1, (this.len * 2) + 1);
            this.st.init(1, this.cnt - 1, 1);
            SegTree segTree = this.st;
            edge[] edgeVarArr = this.ed;
            segTree.update(edgeVarArr[1].s, edgeVarArr[1].t - 1, 1, 1);
            for (int i = 2; i <= this.len * 2; i++) {
                SegTree segTree2 = this.st;
                double d2 = segTree2.tree[1].sum;
                edge[] edgeVarArr2 = this.ed;
                d += d2 * (edgeVarArr2[i].x - edgeVarArr2[i - 1].x);
                segTree2.update(edgeVarArr2[i].s, edgeVarArr2[i].t - 1, 1, edgeVarArr2[i].v);
            }
            System.currentTimeMillis();
            new DecimalFormat("0.00");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return d;
    }
}
