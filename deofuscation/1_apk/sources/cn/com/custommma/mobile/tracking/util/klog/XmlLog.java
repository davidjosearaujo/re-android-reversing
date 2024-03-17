package cn.com.custommma.mobile.tracking.util.klog;

import android.util.Log;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class XmlLog {
    private static String formatXML(String str) {
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            newTransformer.transform(streamSource, streamResult);
            return streamResult.getWriter().toString().replaceFirst(">", ">\n");
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static void printXml(String str, String str2, String str3) {
        String[] split;
        String str4 = str2 != null ? str3 + "\n" + formatXML(str2) : str3 + KLog.NULL_TIPS;
        KLogUtil.printLine(str, true);
        for (String str5 : str4.split(KLog.LINE_SEPARATOR)) {
            if (!KLogUtil.isEmpty(str5)) {
                Log.d(str, "║ " + str5);
            }
        }
        KLogUtil.printLine(str, false);
    }
}
