package i1;

import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f extends g {
    public static Font a(FontFamily fontFamily, int i7) {
        FontStyle fontStyle = new FontStyle((i7 & 1) != 0 ? 700 : 400, (i7 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int b2 = b(fontStyle, font.getStyle());
        for (int i8 = 1; i8 < fontFamily.getSize(); i8++) {
            Font font2 = fontFamily.getFont(i8);
            int b7 = b(fontStyle, font2.getStyle());
            if (b7 < b2) {
                font = font2;
                b2 = b7;
            }
        }
        return font;
    }

    public static int b(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }
}
