package z1;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a */
    public final b f6917a;

    /* loaded from: classes.dex */
    public static class a extends b {

        /* renamed from: a */
        public final TextView f6918a;

        /* renamed from: b */
        public final d f6919b;

        /* renamed from: c */
        public boolean f6920c = true;

        public a(TextView textView) {
            this.f6918a = textView;
            this.f6919b = new d(textView);
        }

        @Override // z1.f.b
        public final InputFilter[] a(InputFilter[] inputFilterArr) {
            if (this.f6920c) {
                int length = inputFilterArr.length;
                for (InputFilter inputFilter : inputFilterArr) {
                    if (inputFilter == this.f6919b) {
                        return inputFilterArr;
                    }
                }
                InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
                inputFilterArr2[length] = this.f6919b;
                return inputFilterArr2;
            }
            SparseArray sparseArray = new SparseArray(1);
            for (int i7 = 0; i7 < inputFilterArr.length; i7++) {
                InputFilter inputFilter2 = inputFilterArr[i7];
                if (inputFilter2 instanceof d) {
                    sparseArray.put(i7, inputFilter2);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length2 = inputFilterArr.length;
            InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i8 = 0;
            for (int i9 = 0; i9 < length2; i9++) {
                if (sparseArray.indexOfKey(i9) < 0) {
                    inputFilterArr3[i8] = inputFilterArr[i9];
                    i8++;
                }
            }
            return inputFilterArr3;
        }

        @Override // z1.f.b
        public final void b(boolean z6) {
            if (z6) {
                d();
            }
        }

        @Override // z1.f.b
        public final void c(boolean z6) {
            this.f6920c = z6;
            d();
            this.f6918a.setFilters(a(this.f6918a.getFilters()));
        }

        public final void d() {
            TransformationMethod transformationMethod = this.f6918a.getTransformationMethod();
            if (this.f6920c) {
                if (!(transformationMethod instanceof h) && !(transformationMethod instanceof PasswordTransformationMethod)) {
                    transformationMethod = new h(transformationMethod);
                }
            } else if (transformationMethod instanceof h) {
                transformationMethod = ((h) transformationMethod).f6927f;
            }
            this.f6918a.setTransformationMethod(transformationMethod);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            throw null;
        }

        public void b(boolean z6) {
            throw null;
        }

        public void c(boolean z6) {
            throw null;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends b {

        /* renamed from: a */
        public final a f6921a;

        public c(TextView textView) {
            this.f6921a = new a(textView);
        }

        @Override // z1.f.b
        public final InputFilter[] a(InputFilter[] inputFilterArr) {
            return (androidx.emoji2.text.f.f1509j != null) ^ true ? inputFilterArr : this.f6921a.a(inputFilterArr);
        }

        @Override // z1.f.b
        public final void b(boolean z6) {
            if (!(androidx.emoji2.text.f.f1509j != null)) {
                return;
            }
            this.f6921a.b(z6);
        }

        @Override // z1.f.b
        public final void c(boolean z6) {
            boolean z7 = !(androidx.emoji2.text.f.f1509j != null);
            a aVar = this.f6921a;
            if (z7) {
                aVar.f6920c = z6;
            } else {
                aVar.c(z6);
            }
        }
    }

    public f(TextView textView) {
        if (textView == null) {
            throw new NullPointerException("textView cannot be null");
        }
        this.f6917a = new c(textView);
    }
}
