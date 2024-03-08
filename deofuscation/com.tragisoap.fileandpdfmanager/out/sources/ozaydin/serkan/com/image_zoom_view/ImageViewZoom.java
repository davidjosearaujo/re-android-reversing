package ozaydin.serkan.com.image_zoom_view;

import a0.b;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import androidx.appcompat.widget.p;
import androidx.fragment.app.q;
import androidx.fragment.app.y;
import j6.a;
import j6.c;
import java.io.ByteArrayOutputStream;
import java.util.Objects;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class ImageViewZoom extends p implements View.OnClickListener {

    /* renamed from: i */
    public Boolean f5419i;

    public ImageViewZoom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5419i = Boolean.FALSE;
        setOnClickListener(this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, b.G, 0, 0);
        try {
            this.f5419i = Boolean.valueOf(obtainStyledAttributes.getBoolean(0, false));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private q getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof q) {
                return (q) context;
            }
        }
        return null;
    }

    public String getBase64() {
        Bitmap bitmap = ((BitmapDrawable) getDrawable()).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        byte[] decode = Base64.decode(encodeToString.getBytes(), 2);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
        if (decodeByteArray.getHeight() <= 400 && decodeByteArray.getWidth() <= 400) {
            return encodeToString;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, 400, 400, false);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        createScaledBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
        byte[] byteArray = byteArrayOutputStream2.toByteArray();
        System.gc();
        return Base64.encodeToString(byteArray, 2);
    }

    public Bitmap getBitmap() {
        return ((BitmapDrawable) getDrawable()).getBitmap();
    }

    public Boolean getCircle() {
        return this.f5419i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (getDrawable() != null) {
            a aVar = new a();
            q activity = getActivity();
            Objects.requireNonNull(activity);
            y yVar = activity.f1739x.f1762a.f1767i;
            Bitmap bitmap = getBitmap();
            aVar.T(yVar);
            aVar.f4604q0 = bitmap;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.f5419i.booleanValue()) {
            Drawable drawable = getDrawable();
            if (drawable != null && getWidth() != 0 && getHeight() != 0) {
                Bitmap copy = ((BitmapDrawable) drawable).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
                int width = getWidth();
                getHeight();
                if (!(copy.getWidth() == width && copy.getHeight() == width)) {
                    float min = ((float) Math.min(copy.getWidth(), copy.getHeight())) / ((float) width);
                    copy = Bitmap.createScaledBitmap(copy, (int) (((float) copy.getWidth()) / min), (int) (((float) copy.getHeight()) / min), false);
                }
                Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                Paint paint = new Paint();
                Rect rect = new Rect(0, 0, width, width);
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                paint.setDither(true);
                canvas2.drawARGB(0, 0, 0, 0);
                float f7 = (float) (width / 2);
                float f8 = 0.7f + f7;
                canvas2.drawCircle(f8, f8, f7 + 0.1f, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas2.drawBitmap(copy, rect, rect, paint);
                canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
                return;
            }
            return;
        }
        super.onDraw(canvas);
    }

    public void setCircle(Boolean bool) {
        this.f5419i = bool;
    }

    public void setConfig(c cVar) {
    }
}
