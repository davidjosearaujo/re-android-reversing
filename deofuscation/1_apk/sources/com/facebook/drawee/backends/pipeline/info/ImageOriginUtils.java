package com.facebook.drawee.backends.pipeline.info;

import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.LocalAssetFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer;
import com.facebook.imagepipeline.producers.LocalFileFetchProducer;
import com.facebook.imagepipeline.producers.LocalResourceFetchProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.hunantv.imgo.vod.ImgoErrorStatisticsData;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ImageOriginUtils {
    private ImageOriginUtils() {
    }

    public static int mapProducerNameToImageOrigin(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1914072202:
                if (str.equals(BitmapMemoryCacheGetProducer.PRODUCER_NAME)) {
                    c = 0;
                    break;
                }
                break;
            case -1683996557:
                if (str.equals(LocalResourceFetchProducer.PRODUCER_NAME)) {
                    c = 1;
                    break;
                }
                break;
            case -1579985851:
                if (str.equals(LocalFileFetchProducer.PRODUCER_NAME)) {
                    c = 2;
                    break;
                }
                break;
            case -1307634203:
                if (str.equals(EncodedMemoryCacheProducer.PRODUCER_NAME)) {
                    c = 3;
                    break;
                }
                break;
            case -1224383234:
                if (str.equals(NetworkFetchProducer.PRODUCER_NAME)) {
                    c = 4;
                    break;
                }
                break;
            case 656304759:
                if (str.equals("DiskCacheProducer")) {
                    c = 5;
                    break;
                }
                break;
            case 957714404:
                if (str.equals(BitmapMemoryCacheProducer.PRODUCER_NAME)) {
                    c = 6;
                    break;
                }
                break;
            case 1019542023:
                if (str.equals(LocalAssetFetchProducer.PRODUCER_NAME)) {
                    c = 7;
                    break;
                }
                break;
            case 1721672898:
                if (str.equals(DataFetchProducer.PRODUCER_NAME)) {
                    c = '\b';
                    break;
                }
                break;
            case 1793127518:
                if (str.equals(LocalContentUriThumbnailFetchProducer.PRODUCER_NAME)) {
                    c = '\t';
                    break;
                }
                break;
            case 2113652014:
                if (str.equals(LocalContentUriFetchProducer.PRODUCER_NAME)) {
                    c = '\n';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 6:
                return 5;
            case 1:
            case 2:
            case 7:
            case '\b':
            case '\t':
            case '\n':
                return 6;
            case 3:
                return 4;
            case 4:
                return 2;
            case 5:
                return 3;
            default:
                return 1;
        }
    }

    public static String toString(int i) {
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? "unknown" : ImgoErrorStatisticsData.STRING_LOCAL : "memory_bitmap" : "memory_encoded" : "disk" : "network";
    }
}
