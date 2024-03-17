package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.Objects;
import n.b0;
import n.l2.v.f0;
import n.l2.v.s0;
import org.json.JSONArray;
import org.json.JSONObject;
import r.e.a.d;
import r.e.a.e;

/* compiled from: GraphRequest.kt */
@b0(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ+\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00150\u0014\"\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dJ$\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u00122\b\u0010 \u001a\u0004\u0018\u00010\u00122\b\u0010!\u001a\u0004\u0018\u00010\u0012J \u0010\"\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0012J \u0010&\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010\u0012J+\u0010)\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00150\u0014\"\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\"\u0010*\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010+\u001a\u0004\u0018\u00010\u00152\b\u0010,\u001a\u0004\u0018\u00010-J\u0006\u0010.\u001a\u00020\u0010J$\u0010/\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u00100\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00020-03J\u0018\u00104\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0012H\u0016R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\u00060\u000bj\u0002`\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/facebook/GraphRequest$Serializer;", "Lcom/facebook/GraphRequest$KeyValueSerializer;", "outputStream", "Ljava/io/OutputStream;", "logger", "Lcom/facebook/internal/Logger;", "useUrlEncode", "", "(Ljava/io/OutputStream;Lcom/facebook/internal/Logger;Z)V", "firstWrite", "invalidTypeError", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "getInvalidTypeError", "()Ljava/lang/RuntimeException;", "write", "", "format", "", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "writeBitmap", SDKConstants.PARAM_KEY, "bitmap", "Landroid/graphics/Bitmap;", "writeBytes", "bytes", "", "writeContentDisposition", "name", "filename", "contentType", "writeContentUri", "contentUri", "Landroid/net/Uri;", "mimeType", "writeFile", "descriptor", "Landroid/os/ParcelFileDescriptor;", "writeLine", "writeObject", SDKConstants.PARAM_VALUE, "request", "Lcom/facebook/GraphRequest;", "writeRecordBoundary", "writeRequestsAsJson", "requestJsonArray", "Lorg/json/JSONArray;", "requests", "", "writeString", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class GraphRequest$Serializer implements GraphRequest$KeyValueSerializer {
    private boolean firstWrite;
    private final Logger logger;
    private final OutputStream outputStream;
    private final boolean useUrlEncode;

    public GraphRequest$Serializer(@d OutputStream outputStream, @e Logger logger, boolean z) {
        f0.p(outputStream, "outputStream");
        this.outputStream = outputStream;
        this.logger = logger;
        this.firstWrite = true;
        this.useUrlEncode = z;
    }

    private final RuntimeException getInvalidTypeError() {
        return new IllegalArgumentException("value is not a supported type.");
    }

    public final void write(@d String str, @d Object... objArr) {
        f0.p(str, "format");
        f0.p(objArr, "args");
        if (!this.useUrlEncode) {
            if (this.firstWrite) {
                OutputStream outputStream = this.outputStream;
                Charset charset = n.u2.d.a;
                byte[] bytes = "--".getBytes(charset);
                f0.o(bytes, "(this as java.lang.String).getBytes(charset)");
                outputStream.write(bytes);
                OutputStream outputStream2 = this.outputStream;
                String access$getMIME_BOUNDARY$cp = GraphRequest.access$getMIME_BOUNDARY$cp();
                Objects.requireNonNull(access$getMIME_BOUNDARY$cp, "null cannot be cast to non-null type java.lang.String");
                byte[] bytes2 = access$getMIME_BOUNDARY$cp.getBytes(charset);
                f0.o(bytes2, "(this as java.lang.String).getBytes(charset)");
                outputStream2.write(bytes2);
                OutputStream outputStream3 = this.outputStream;
                byte[] bytes3 = "\r\n".getBytes(charset);
                f0.o(bytes3, "(this as java.lang.String).getBytes(charset)");
                outputStream3.write(bytes3);
                this.firstWrite = false;
            }
            OutputStream outputStream4 = this.outputStream;
            s0 s0Var = s0.a;
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            String format = String.format(str, Arrays.copyOf(copyOf, copyOf.length));
            f0.o(format, "java.lang.String.format(format, *args)");
            Charset charset2 = n.u2.d.a;
            Objects.requireNonNull(format, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes4 = format.getBytes(charset2);
            f0.o(bytes4, "(this as java.lang.String).getBytes(charset)");
            outputStream4.write(bytes4);
            return;
        }
        OutputStream outputStream5 = this.outputStream;
        s0 s0Var2 = s0.a;
        Locale locale = Locale.US;
        Object[] copyOf2 = Arrays.copyOf(objArr, objArr.length);
        String format2 = String.format(locale, str, Arrays.copyOf(copyOf2, copyOf2.length));
        f0.o(format2, "java.lang.String.format(locale, format, *args)");
        String encode = URLEncoder.encode(format2, "UTF-8");
        f0.o(encode, "URLEncoder.encode(String… format, *args), \"UTF-8\")");
        Charset charset3 = n.u2.d.a;
        Objects.requireNonNull(encode, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes5 = encode.getBytes(charset3);
        f0.o(bytes5, "(this as java.lang.String).getBytes(charset)");
        outputStream5.write(bytes5);
    }

    public final void writeBitmap(@d String str, @d Bitmap bitmap) {
        f0.p(str, SDKConstants.PARAM_KEY);
        f0.p(bitmap, "bitmap");
        writeContentDisposition(str, str, "image/png");
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, this.outputStream);
        writeLine("", new Object[0]);
        writeRecordBoundary();
        Logger logger = this.logger;
        if (logger != null) {
            logger.appendKeyValue("    " + str, "<Image>");
        }
    }

    public final void writeBytes(@d String str, @d byte[] bArr) {
        f0.p(str, SDKConstants.PARAM_KEY);
        f0.p(bArr, "bytes");
        writeContentDisposition(str, str, "content/unknown");
        this.outputStream.write(bArr);
        writeLine("", new Object[0]);
        writeRecordBoundary();
        Logger logger = this.logger;
        if (logger != null) {
            s0 s0Var = s0.a;
            String format = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(bArr.length)}, 1));
            f0.o(format, "java.lang.String.format(locale, format, *args)");
            logger.appendKeyValue("    " + str, format);
        }
    }

    public final void writeContentDisposition(@e String str, @e String str2, @e String str3) {
        if (!this.useUrlEncode) {
            write("Content-Disposition: form-data; name=\"%s\"", str);
            if (str2 != null) {
                write("; filename=\"%s\"", str2);
            }
            writeLine("", new Object[0]);
            if (str3 != null) {
                writeLine("%s: %s", "Content-Type", str3);
            }
            writeLine("", new Object[0]);
            return;
        }
        OutputStream outputStream = this.outputStream;
        s0 s0Var = s0.a;
        String format = String.format("%s=", Arrays.copyOf(new Object[]{str}, 1));
        f0.o(format, "java.lang.String.format(format, *args)");
        Charset charset = n.u2.d.a;
        Objects.requireNonNull(format, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = format.getBytes(charset);
        f0.o(bytes, "(this as java.lang.String).getBytes(charset)");
        outputStream.write(bytes);
    }

    public final void writeContentUri(@d String str, @d Uri uri, @e String str2) {
        int copyAndCloseInputStream;
        f0.p(str, SDKConstants.PARAM_KEY);
        f0.p(uri, "contentUri");
        if (str2 == null) {
            str2 = "content/unknown";
        }
        writeContentDisposition(str, str, str2);
        if (this.outputStream instanceof ProgressNoopOutputStream) {
            ((ProgressNoopOutputStream) this.outputStream).addProgress(Utility.getContentSize(uri));
            copyAndCloseInputStream = 0;
        } else {
            Context applicationContext = FacebookSdk.getApplicationContext();
            f0.o(applicationContext, "FacebookSdk.getApplicationContext()");
            copyAndCloseInputStream = Utility.copyAndCloseInputStream(applicationContext.getContentResolver().openInputStream(uri), this.outputStream) + 0;
        }
        writeLine("", new Object[0]);
        writeRecordBoundary();
        Logger logger = this.logger;
        if (logger != null) {
            s0 s0Var = s0.a;
            String format = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(copyAndCloseInputStream)}, 1));
            f0.o(format, "java.lang.String.format(locale, format, *args)");
            logger.appendKeyValue("    " + str, format);
        }
    }

    public final void writeFile(@d String str, @d ParcelFileDescriptor parcelFileDescriptor, @e String str2) {
        int copyAndCloseInputStream;
        f0.p(str, SDKConstants.PARAM_KEY);
        f0.p(parcelFileDescriptor, "descriptor");
        if (str2 == null) {
            str2 = "content/unknown";
        }
        writeContentDisposition(str, str, str2);
        OutputStream outputStream = this.outputStream;
        if (outputStream instanceof ProgressNoopOutputStream) {
            ((ProgressNoopOutputStream) outputStream).addProgress(parcelFileDescriptor.getStatSize());
            copyAndCloseInputStream = 0;
        } else {
            copyAndCloseInputStream = Utility.copyAndCloseInputStream(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), this.outputStream) + 0;
        }
        writeLine("", new Object[0]);
        writeRecordBoundary();
        Logger logger = this.logger;
        if (logger != null) {
            s0 s0Var = s0.a;
            String format = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(copyAndCloseInputStream)}, 1));
            f0.o(format, "java.lang.String.format(locale, format, *args)");
            logger.appendKeyValue("    " + str, format);
        }
    }

    public final void writeLine(@d String str, @d Object... objArr) {
        f0.p(str, "format");
        f0.p(objArr, "args");
        write(str, Arrays.copyOf(objArr, objArr.length));
        if (this.useUrlEncode) {
            return;
        }
        write("\r\n", new Object[0]);
    }

    public final void writeObject(@d String str, @e Object obj, @e GraphRequest graphRequest) {
        boolean isSupportedParameterType;
        String parameterToString;
        f0.p(str, SDKConstants.PARAM_KEY);
        OutputStream outputStream = this.outputStream;
        if (outputStream instanceof RequestOutputStream) {
            Objects.requireNonNull(outputStream, "null cannot be cast to non-null type com.facebook.RequestOutputStream");
            ((RequestOutputStream) outputStream).setCurrentRequest(graphRequest);
        }
        GraphRequest$Companion graphRequest$Companion = GraphRequest.Companion;
        isSupportedParameterType = graphRequest$Companion.isSupportedParameterType(obj);
        if (isSupportedParameterType) {
            parameterToString = graphRequest$Companion.parameterToString(obj);
            writeString(str, parameterToString);
        } else if (obj instanceof Bitmap) {
            writeBitmap(str, (Bitmap) obj);
        } else if (obj instanceof byte[]) {
            writeBytes(str, (byte[]) obj);
        } else if (obj instanceof Uri) {
            writeContentUri(str, (Uri) obj, null);
        } else if (obj instanceof ParcelFileDescriptor) {
            writeFile(str, (ParcelFileDescriptor) obj, null);
        } else if (obj instanceof GraphRequest$ParcelableResourceWithMimeType) {
            GraphRequest$ParcelableResourceWithMimeType graphRequest$ParcelableResourceWithMimeType = (GraphRequest$ParcelableResourceWithMimeType) obj;
            Parcelable resource = graphRequest$ParcelableResourceWithMimeType.getResource();
            String mimeType = graphRequest$ParcelableResourceWithMimeType.getMimeType();
            if (resource instanceof ParcelFileDescriptor) {
                writeFile(str, (ParcelFileDescriptor) resource, mimeType);
            } else if (resource instanceof Uri) {
                writeContentUri(str, (Uri) resource, mimeType);
            } else {
                throw getInvalidTypeError();
            }
        } else {
            throw getInvalidTypeError();
        }
    }

    public final void writeRecordBoundary() {
        if (!this.useUrlEncode) {
            writeLine("--%s", GraphRequest.access$getMIME_BOUNDARY$cp());
            return;
        }
        OutputStream outputStream = this.outputStream;
        byte[] bytes = "&".getBytes(n.u2.d.a);
        f0.o(bytes, "(this as java.lang.String).getBytes(charset)");
        outputStream.write(bytes);
    }

    public final void writeRequestsAsJson(@d String str, @d JSONArray jSONArray, @d Collection<GraphRequest> collection) {
        f0.p(str, SDKConstants.PARAM_KEY);
        f0.p(jSONArray, "requestJsonArray");
        f0.p(collection, "requests");
        OutputStream outputStream = this.outputStream;
        if (!(outputStream instanceof RequestOutputStream)) {
            String jSONArray2 = jSONArray.toString();
            f0.o(jSONArray2, "requestJsonArray.toString()");
            writeString(str, jSONArray2);
            return;
        }
        Objects.requireNonNull(outputStream, "null cannot be cast to non-null type com.facebook.RequestOutputStream");
        RequestOutputStream requestOutputStream = (RequestOutputStream) outputStream;
        writeContentDisposition(str, null, null);
        write("[", new Object[0]);
        int i = 0;
        for (GraphRequest graphRequest : collection) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            requestOutputStream.setCurrentRequest(graphRequest);
            if (i > 0) {
                write(",%s", jSONObject.toString());
            } else {
                write("%s", jSONObject.toString());
            }
            i++;
        }
        write("]", new Object[0]);
        Logger logger = this.logger;
        if (logger != null) {
            String jSONArray3 = jSONArray.toString();
            f0.o(jSONArray3, "requestJsonArray.toString()");
            logger.appendKeyValue("    " + str, jSONArray3);
        }
    }

    @Override // com.facebook.GraphRequest$KeyValueSerializer
    public void writeString(@d String str, @d String str2) {
        f0.p(str, SDKConstants.PARAM_KEY);
        f0.p(str2, SDKConstants.PARAM_VALUE);
        writeContentDisposition(str, null, null);
        writeLine("%s", str2);
        writeRecordBoundary();
        Logger logger = this.logger;
        if (logger != null) {
            logger.appendKeyValue("    " + str, str2);
        }
    }
}
