package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PropertyPreFilters {
    private List<MySimplePropertyPreFilter> filters = new ArrayList();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class MySimplePropertyPreFilter extends SimplePropertyPreFilter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MySimplePropertyPreFilter() {
            super(new String[0]);
            PropertyPreFilters.this = r1;
        }

        public MySimplePropertyPreFilter addExcludes(String... strArr) {
            for (String str : strArr) {
                getExcludes().add(str);
            }
            return this;
        }

        public MySimplePropertyPreFilter addIncludes(String... strArr) {
            for (String str : strArr) {
                getIncludes().add(str);
            }
            return this;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MySimplePropertyPreFilter(String... strArr) {
            super(strArr);
            PropertyPreFilters.this = r1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MySimplePropertyPreFilter(Class<?> cls, String... strArr) {
            super(cls, strArr);
            PropertyPreFilters.this = r1;
        }
    }

    public MySimplePropertyPreFilter addFilter() {
        MySimplePropertyPreFilter mySimplePropertyPreFilter = new MySimplePropertyPreFilter();
        this.filters.add(mySimplePropertyPreFilter);
        return mySimplePropertyPreFilter;
    }

    public List<MySimplePropertyPreFilter> getFilters() {
        return this.filters;
    }

    public void setFilters(List<MySimplePropertyPreFilter> list) {
        this.filters = list;
    }

    public MySimplePropertyPreFilter[] toFilters() {
        return (MySimplePropertyPreFilter[]) this.filters.toArray(new MySimplePropertyPreFilter[0]);
    }

    public MySimplePropertyPreFilter addFilter(String... strArr) {
        MySimplePropertyPreFilter mySimplePropertyPreFilter = new MySimplePropertyPreFilter(strArr);
        this.filters.add(mySimplePropertyPreFilter);
        return mySimplePropertyPreFilter;
    }

    public MySimplePropertyPreFilter addFilter(Class<?> cls, String... strArr) {
        MySimplePropertyPreFilter mySimplePropertyPreFilter = new MySimplePropertyPreFilter(cls, strArr);
        this.filters.add(mySimplePropertyPreFilter);
        return mySimplePropertyPreFilter;
    }
}
