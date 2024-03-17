package com.hunantv.imgo.yaml.reader;

import com.hunantv.imgo.yaml.error.YAMLException;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ReaderException extends YAMLException {
    private static final long serialVersionUID = 8710781187529689083L;
    private final char character;
    private final String name;
    private final int position;

    public ReaderException(String str, int i, char c, String str2) {
        super(str2);
        this.name = str;
        this.character = c;
        this.position = i;
    }

    public char getCharacter() {
        return this.character;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "unacceptable character '" + this.character + "' (0x" + Integer.toHexString(this.character).toUpperCase() + ") " + getMessage() + "\nin \"" + this.name + "\", position " + this.position;
    }
}
