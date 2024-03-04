package linc.com.amplituda;

import java.util.LinkedHashSet;
import linc.com.amplituda.exceptions.AmplitudaException;
import linc.com.amplituda.exceptions.allocation.CodecContextAllocationException;
import linc.com.amplituda.exceptions.allocation.FrameAllocationException;
import linc.com.amplituda.exceptions.allocation.PacketAllocationException;
import linc.com.amplituda.exceptions.io.FileOpenException;
import linc.com.amplituda.exceptions.processing.CodecNotFoundException;
import linc.com.amplituda.exceptions.processing.CodecOpenException;
import linc.com.amplituda.exceptions.processing.CodecParametersException;
import linc.com.amplituda.exceptions.processing.DecodingException;
import linc.com.amplituda.exceptions.processing.PacketSubmittingException;
import linc.com.amplituda.exceptions.processing.SampleOutOfBoundsException;
import linc.com.amplituda.exceptions.processing.StreamInformationNotFoundException;
import linc.com.amplituda.exceptions.processing.StreamNotFoundException;
import linc.com.amplituda.exceptions.processing.UnsupportedSampleFormatException;

/* loaded from: classes.dex */
public final class AmplitudaResultJNI {
    private String amplitudes;
    private double duration;
    private String errors;

    private AmplitudaException getExceptionFromCode(int i7) {
        if (i7 != 20) {
            if (i7 != 40) {
                switch (i7) {
                    case ErrorCode.FRAME_ALLOC_CODE /* 10 */:
                        return new FrameAllocationException();
                    case ErrorCode.PACKET_ALLOC_CODE /* 11 */:
                        return new PacketAllocationException();
                    case ErrorCode.CODEC_CONTEXT_ALLOC_CODE /* 12 */:
                        return new CodecContextAllocationException();
                    default:
                        switch (i7) {
                            case ErrorCode.CODEC_NOT_FOUND_PROC_CODE /* 30 */:
                                return new CodecNotFoundException();
                            case ErrorCode.STREAM_NOT_FOUND_PROC_CODE /* 31 */:
                                return new StreamNotFoundException();
                            case ErrorCode.STREAM_INFO_NOT_FOUND_PROC_CODE /* 32 */:
                                return new StreamInformationNotFoundException();
                            case ErrorCode.CODEC_PARAMETERS_COPY_PROC_CODE /* 33 */:
                                return new CodecParametersException();
                            case ErrorCode.PACKET_SUBMITTING_PROC_CODE /* 34 */:
                                return new PacketSubmittingException();
                            case ErrorCode.CODEC_OPEN_PROC_CODE /* 35 */:
                                return new CodecOpenException();
                            case ErrorCode.UNSUPPORTED_SAMPLE_FMT_PROC_CODE /* 36 */:
                                return new UnsupportedSampleFormatException();
                            case ErrorCode.DECODING_PROC_CODE /* 37 */:
                                return new DecodingException();
                            default:
                                return new AmplitudaException();
                        }
                }
            }
            return new SampleOutOfBoundsException();
        }
        return new FileOpenException();
    }

    public String getAmplitudes() {
        return this.amplitudes;
    }

    public long getDurationMillis() {
        return (long) (this.duration * 1000.0d);
    }

    public LinkedHashSet<AmplitudaException> getErrors() {
        String[] split;
        String str = this.errors;
        if (str == null || str.isEmpty()) {
            return new LinkedHashSet<>();
        }
        LinkedHashSet<AmplitudaException> linkedHashSet = new LinkedHashSet<>();
        for (String str2 : this.errors.split(" ")) {
            if (!str2.isEmpty()) {
                linkedHashSet.add(getExceptionFromCode(Integer.parseInt(str2)));
            }
        }
        return linkedHashSet;
    }

    public void setAmplitudes(String str) {
        this.amplitudes = str;
    }

    public void setDuration(double d7) {
        this.duration = d7;
    }
}
