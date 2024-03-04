package linc.com.amplituda;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import linc.com.amplituda.InputAudio;

/* loaded from: classes.dex */
public final class AmplitudaResult<T> {
    private final String amplitudes;
    private final InputAudio<T> inputAudio;

    /* loaded from: classes.dex */
    public enum DurationUnit {
        SECONDS,
        MILLIS
    }

    /* loaded from: classes.dex */
    public enum SequenceFormat {
        SINGLE_LINE,
        NEW_LINE
    }

    public AmplitudaResult(String str, InputAudio<T> inputAudio) {
        this.amplitudes = str;
        this.inputAudio = inputAudio;
    }

    private String amplitudesToSingleLineSequence(String str, String str2) {
        return TextUtils.join(str2, str.split("\n"));
    }

    public String amplitudesAsJson() {
        String str = this.amplitudes;
        return (str == null || str.isEmpty()) ? "" : Arrays.toString(amplitudesAsList().toArray());
    }

    public List<Integer> amplitudesAsList() {
        String str = this.amplitudes;
        if (str == null || str.isEmpty()) {
            return Collections.emptyList();
        }
        String[] split = this.amplitudes.split("\n");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            if (str2.isEmpty()) {
                break;
            }
            arrayList.add(Integer.valueOf(str2));
        }
        return arrayList;
    }

    public String amplitudesAsSequence(SequenceFormat sequenceFormat) {
        String str = this.amplitudes;
        return (str == null || str.isEmpty()) ? "" : amplitudesAsSequence(sequenceFormat, " ");
    }

    public String amplitudesAsSequence(SequenceFormat sequenceFormat, String str) {
        String str2 = this.amplitudes;
        return (str2 == null || str2.isEmpty()) ? "" : sequenceFormat == SequenceFormat.SINGLE_LINE ? amplitudesToSingleLineSequence(this.amplitudes, str) : this.amplitudes;
    }

    public List<Integer> amplitudesForSecond(int i7) {
        List<Integer> amplitudesAsList = amplitudesAsList();
        int audioDuration = (int) getAudioDuration(DurationUnit.SECONDS);
        if (i7 > audioDuration || audioDuration == 0) {
            return Collections.emptyList();
        }
        int size = amplitudesAsList.size() / audioDuration;
        int size2 = (amplitudesAsList.size() * i7) / audioDuration;
        ArrayList arrayList = new ArrayList();
        for (int i8 = size2; i8 > size2 - size && i8 >= 0 && i8 < amplitudesAsList.size(); i8--) {
            arrayList.add(amplitudesAsList.get(i8));
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public long getAudioDuration(DurationUnit durationUnit) {
        DurationUnit durationUnit2 = DurationUnit.SECONDS;
        InputAudio<T> inputAudio = this.inputAudio;
        return durationUnit == durationUnit2 ? inputAudio.getDuration() / 1000 : inputAudio.getDuration();
    }

    public T getAudioSource() {
        return this.inputAudio.getSource();
    }

    public InputAudio.Type getInputAudioType() {
        return this.inputAudio.getType();
    }
}
