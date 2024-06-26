package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.infer.annotation.ThreadSafe;
import java.util.LinkedList;
import javax.annotation.Nullable;

@ThreadSafe
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class BucketMap<T> {
    @VisibleForTesting
    @Nullable
    public LinkedEntry<T> mHead;
    public final SparseArray<LinkedEntry<T>> mMap = new SparseArray<>();
    @VisibleForTesting
    @Nullable
    public LinkedEntry<T> mTail;

    @VisibleForTesting
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class LinkedEntry<I> {
        public int key;
        @Nullable
        public LinkedEntry<I> next;
        @Nullable
        public LinkedEntry<I> prev;
        public LinkedList<I> value;

        public String toString() {
            return "LinkedEntry(key: " + this.key + ")";
        }

        private LinkedEntry(@Nullable LinkedEntry<I> linkedEntry, int i, LinkedList<I> linkedList, @Nullable LinkedEntry<I> linkedEntry2) {
            this.prev = linkedEntry;
            this.key = i;
            this.value = linkedList;
            this.next = linkedEntry2;
        }
    }

    private void maybePrune(LinkedEntry<T> linkedEntry) {
        if (linkedEntry == null || !linkedEntry.value.isEmpty()) {
            return;
        }
        prune(linkedEntry);
        this.mMap.remove(linkedEntry.key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void moveToFront(LinkedEntry<T> linkedEntry) {
        if (this.mHead == linkedEntry) {
            return;
        }
        prune(linkedEntry);
        LinkedEntry linkedEntry2 = (LinkedEntry<T>) this.mHead;
        if (linkedEntry2 == null) {
            this.mHead = linkedEntry;
            this.mTail = linkedEntry;
            return;
        }
        linkedEntry.next = linkedEntry2;
        linkedEntry2.prev = linkedEntry;
        this.mHead = linkedEntry;
    }

    private synchronized void prune(LinkedEntry<T> linkedEntry) {
        LinkedEntry linkedEntry2 = (LinkedEntry<T>) linkedEntry.prev;
        LinkedEntry linkedEntry3 = (LinkedEntry<T>) linkedEntry.next;
        if (linkedEntry2 != null) {
            linkedEntry2.next = linkedEntry3;
        }
        if (linkedEntry3 != null) {
            linkedEntry3.prev = linkedEntry2;
        }
        linkedEntry.prev = null;
        linkedEntry.next = null;
        if (linkedEntry == this.mHead) {
            this.mHead = linkedEntry3;
        }
        if (linkedEntry == this.mTail) {
            this.mTail = linkedEntry2;
        }
    }

    @Nullable
    public synchronized T acquire(int i) {
        LinkedEntry<T> linkedEntry = this.mMap.get(i);
        if (linkedEntry == null) {
            return null;
        }
        T pollFirst = linkedEntry.value.pollFirst();
        moveToFront(linkedEntry);
        return pollFirst;
    }

    public synchronized void release(int i, T t) {
        LinkedEntry<T> linkedEntry = this.mMap.get(i);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry<>(null, i, new LinkedList(), null);
            this.mMap.put(i, linkedEntry);
        }
        linkedEntry.value.addLast(t);
        moveToFront(linkedEntry);
    }

    @Nullable
    public synchronized T removeFromEnd() {
        LinkedEntry<T> linkedEntry = this.mTail;
        if (linkedEntry == null) {
            return null;
        }
        T pollLast = linkedEntry.value.pollLast();
        maybePrune(linkedEntry);
        return pollLast;
    }

    @VisibleForTesting
    public synchronized int valueCount() {
        int i;
        i = 0;
        for (LinkedEntry linkedEntry = this.mHead; linkedEntry != null; linkedEntry = linkedEntry.next) {
            LinkedList<I> linkedList = linkedEntry.value;
            if (linkedList != 0) {
                i += linkedList.size();
            }
        }
        return i;
    }
}
