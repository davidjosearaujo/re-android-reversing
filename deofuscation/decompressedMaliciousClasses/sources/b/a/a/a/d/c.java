package b.a.a.a.d;

import android.os.IBinder;
import b.a.a.a.d.a;
import java.lang.reflect.Field;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class c<T> extends a.AbstractBinderC0004a {
    private static short[] $ = {2059, 2087, 2109, 2084, 2092, 2152, 2086, 2087, 2108, 2152, 2089, 2091, 2091, 2093, 2107, 2107, 2152, 2108, 2080, 2093, 2152, 2094, 2081, 2093, 2084, 2092, 2152, 2081, 2086, 2152, 2106, 2093, 2085, 2087, 2108, 2093, 2058, 2081, 2086, 2092, 2093, 2106, 2150, 8683, 8640, 8647, 8653, 8652, 8667, 8585, 8646, 8651, 8643, 8652, 8650, 8669, 8585, 8640, 8666, 8585, 8647, 8668, 8645, 8645, 8583, 6685, 6683, 6710, 6718, 6705, 6711, 6688, 6659, 6694, 6709, 6692, 6692, 6705, 6694, 6772, 6704, 6705, 6711, 6712, 6709, 6694, 6705, 6704, 6772, 6706, 6717, 6705, 6712, 6704, 6772, 6714, 6715, 6688, 6772, 6692, 6694, 6717, 6690, 6709, 6688, 6705, 6773, 1629, 1638, 1645, 1648, 1656, 1645, 1643, 1660, 1645, 1644, 1576, 1638, 1661, 1637, 1642, 1645, 1658, 1576, 1639, 1646, 1576, 1601, 1607, 1642, 1634, 1645, 1643, 1660, 1631, 1658, 1641, 1656, 1656, 1645, 1658, 1576, 1644, 1645, 1643, 1636, 1641, 1658, 1645, 1644, 1576, 1646, 1633, 1645, 1636, 1644, 1659, 1586, 1576};

    /* renamed from: a  reason: collision with root package name */
    private final T f133a;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    private c(T t) {
        this.f133a = t;
    }

    public static <T> T y(a aVar) {
        if (aVar instanceof c) {
            return ((c) aVar).f133a;
        }
        IBinder asBinder = aVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
            int length = declaredFields.length;
            StringBuilder sb = new StringBuilder(64);
            sb.append($(107, 160, 1544));
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        } else if (!field.isAccessible()) {
            field.setAccessible(true);
            try {
                return (T) field.get(asBinder);
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException($(0, 43, 2120), e);
            } catch (NullPointerException e2) {
                throw new IllegalArgumentException($(43, 65, 8617), e2);
            }
        } else {
            throw new IllegalArgumentException($(65, 107, 6740));
        }
    }

    public static <T> a z(T t) {
        return new c(t);
    }
}
