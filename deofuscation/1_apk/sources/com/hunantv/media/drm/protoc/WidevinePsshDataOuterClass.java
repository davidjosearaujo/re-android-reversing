package com.hunantv.media.drm.protoc;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class WidevinePsshDataOuterClass {

    /* renamed from: com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass$1  reason: invalid class name */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class WidevineHeader extends GeneratedMessageLite<WidevineHeader, Builder> implements WidevineHeaderOrBuilder {
        public static final int CONTENT_ID_FIELD_NUMBER = 4;
        private static final WidevineHeader DEFAULT_INSTANCE;
        public static final int KEY_IDS_FIELD_NUMBER = 2;
        private static volatile Parser<WidevineHeader> PARSER = null;
        public static final int PROVIDER_FIELD_NUMBER = 3;
        private int bitField0_;
        private Internal.ProtobufList<String> keyIds_ = GeneratedMessageLite.emptyProtobufList();
        private String provider_ = "";
        private ByteString contentId_ = ByteString.EMPTY;

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<WidevineHeader, Builder> implements WidevineHeaderOrBuilder {
            private Builder() {
                super(WidevineHeader.DEFAULT_INSTANCE);
            }

            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllKeyIds(Iterable<String> iterable) {
                copyOnWrite();
                ((WidevineHeader) ((GeneratedMessageLite.Builder) this).instance).addAllKeyIds(iterable);
                return this;
            }

            public Builder addKeyIds(String str) {
                copyOnWrite();
                ((WidevineHeader) ((GeneratedMessageLite.Builder) this).instance).addKeyIds(str);
                return this;
            }

            public Builder addKeyIdsBytes(ByteString byteString) {
                copyOnWrite();
                ((WidevineHeader) ((GeneratedMessageLite.Builder) this).instance).addKeyIdsBytes(byteString);
                return this;
            }

            public Builder clearContentId() {
                copyOnWrite();
                ((WidevineHeader) ((GeneratedMessageLite.Builder) this).instance).clearContentId();
                return this;
            }

            public Builder clearKeyIds() {
                copyOnWrite();
                ((WidevineHeader) ((GeneratedMessageLite.Builder) this).instance).clearKeyIds();
                return this;
            }

            public Builder clearProvider() {
                copyOnWrite();
                ((WidevineHeader) ((GeneratedMessageLite.Builder) this).instance).clearProvider();
                return this;
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevineHeaderOrBuilder
            public ByteString getContentId() {
                return ((WidevineHeader) ((GeneratedMessageLite.Builder) this).instance).getContentId();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevineHeaderOrBuilder
            public String getKeyIds(int i) {
                return ((WidevineHeader) ((GeneratedMessageLite.Builder) this).instance).getKeyIds(i);
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevineHeaderOrBuilder
            public ByteString getKeyIdsBytes(int i) {
                return ((WidevineHeader) ((GeneratedMessageLite.Builder) this).instance).getKeyIdsBytes(i);
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevineHeaderOrBuilder
            public int getKeyIdsCount() {
                return ((WidevineHeader) ((GeneratedMessageLite.Builder) this).instance).getKeyIdsCount();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevineHeaderOrBuilder
            public List<String> getKeyIdsList() {
                return Collections.unmodifiableList(((WidevineHeader) ((GeneratedMessageLite.Builder) this).instance).getKeyIdsList());
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevineHeaderOrBuilder
            public String getProvider() {
                return ((WidevineHeader) ((GeneratedMessageLite.Builder) this).instance).getProvider();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevineHeaderOrBuilder
            public ByteString getProviderBytes() {
                return ((WidevineHeader) ((GeneratedMessageLite.Builder) this).instance).getProviderBytes();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevineHeaderOrBuilder
            public boolean hasContentId() {
                return ((WidevineHeader) ((GeneratedMessageLite.Builder) this).instance).hasContentId();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevineHeaderOrBuilder
            public boolean hasProvider() {
                return ((WidevineHeader) ((GeneratedMessageLite.Builder) this).instance).hasProvider();
            }

            public Builder setContentId(ByteString byteString) {
                copyOnWrite();
                ((WidevineHeader) ((GeneratedMessageLite.Builder) this).instance).setContentId(byteString);
                return this;
            }

            public Builder setKeyIds(int i, String str) {
                copyOnWrite();
                ((WidevineHeader) ((GeneratedMessageLite.Builder) this).instance).setKeyIds(i, str);
                return this;
            }

            public Builder setProvider(String str) {
                copyOnWrite();
                ((WidevineHeader) ((GeneratedMessageLite.Builder) this).instance).setProvider(str);
                return this;
            }

            public Builder setProviderBytes(ByteString byteString) {
                copyOnWrite();
                ((WidevineHeader) ((GeneratedMessageLite.Builder) this).instance).setProviderBytes(byteString);
                return this;
            }
        }

        static {
            WidevineHeader widevineHeader = new WidevineHeader();
            DEFAULT_INSTANCE = widevineHeader;
            GeneratedMessageLite.registerDefaultInstance(WidevineHeader.class, widevineHeader);
        }

        private WidevineHeader() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllKeyIds(Iterable<String> iterable) {
            ensureKeyIdsIsMutable();
            AbstractMessageLite.addAll(iterable, this.keyIds_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addKeyIds(String str) {
            str.getClass();
            ensureKeyIdsIsMutable();
            this.keyIds_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addKeyIdsBytes(ByteString byteString) {
            ensureKeyIdsIsMutable();
            this.keyIds_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearContentId() {
            this.bitField0_ &= -3;
            this.contentId_ = getDefaultInstance().getContentId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKeyIds() {
            this.keyIds_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProvider() {
            this.bitField0_ &= -2;
            this.provider_ = getDefaultInstance().getProvider();
        }

        private void ensureKeyIdsIsMutable() {
            Internal.ProtobufList<String> protobufList = this.keyIds_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.keyIds_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static WidevineHeader getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(WidevineHeader widevineHeader) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(widevineHeader);
        }

        public static WidevineHeader parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WidevineHeader) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WidevineHeader parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WidevineHeader) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WidevineHeader parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (WidevineHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static WidevineHeader parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WidevineHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WidevineHeader parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (WidevineHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WidevineHeader parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WidevineHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static WidevineHeader parseFrom(InputStream inputStream) throws IOException {
            return (WidevineHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WidevineHeader parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WidevineHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WidevineHeader parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (WidevineHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static WidevineHeader parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WidevineHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static WidevineHeader parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (WidevineHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WidevineHeader parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WidevineHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<WidevineHeader> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContentId(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.contentId_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeyIds(int i, String str) {
            str.getClass();
            ensureKeyIdsIsMutable();
            this.keyIds_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProvider(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.provider_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProviderBytes(ByteString byteString) {
            this.provider_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new WidevineHeader();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0002\u0004\u0003\u0000\u0001\u0000\u0002\u001a\u0003ဈ\u0000\u0004ည\u0001", new Object[]{"bitField0_", "keyIds_", "provider_", "contentId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    GeneratedMessageLite.DefaultInstanceBasedParser defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (WidevineHeader.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        }
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevineHeaderOrBuilder
        public ByteString getContentId() {
            return this.contentId_;
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevineHeaderOrBuilder
        public String getKeyIds(int i) {
            return (String) this.keyIds_.get(i);
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevineHeaderOrBuilder
        public ByteString getKeyIdsBytes(int i) {
            return ByteString.copyFromUtf8((String) this.keyIds_.get(i));
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevineHeaderOrBuilder
        public int getKeyIdsCount() {
            return this.keyIds_.size();
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevineHeaderOrBuilder
        public List<String> getKeyIdsList() {
            return this.keyIds_;
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevineHeaderOrBuilder
        public String getProvider() {
            return this.provider_;
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevineHeaderOrBuilder
        public ByteString getProviderBytes() {
            return ByteString.copyFromUtf8(this.provider_);
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevineHeaderOrBuilder
        public boolean hasContentId() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevineHeaderOrBuilder
        public boolean hasProvider() {
            return (this.bitField0_ & 1) != 0;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface WidevineHeaderOrBuilder extends MessageLiteOrBuilder {
        ByteString getContentId();

        String getKeyIds(int i);

        ByteString getKeyIdsBytes(int i);

        int getKeyIdsCount();

        List<String> getKeyIdsList();

        String getProvider();

        ByteString getProviderBytes();

        boolean hasContentId();

        boolean hasProvider();
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class WidevinePsshData extends GeneratedMessageLite<WidevinePsshData, Builder> implements WidevinePsshDataOrBuilder {
        public static final int ALGORITHM_FIELD_NUMBER = 1;
        public static final int CONTENT_ID_FIELD_NUMBER = 4;
        public static final int CRYPTO_PERIOD_INDEX_FIELD_NUMBER = 7;
        private static final WidevinePsshData DEFAULT_INSTANCE;
        public static final int GROUPED_LICENSE_FIELD_NUMBER = 8;
        public static final int KEY_ID_FIELD_NUMBER = 2;
        private static volatile Parser<WidevinePsshData> PARSER = null;
        public static final int POLICY_FIELD_NUMBER = 6;
        public static final int PROTECTION_SCHEME_FIELD_NUMBER = 9;
        public static final int PROVIDER_FIELD_NUMBER = 3;
        private int algorithm_;
        private int bitField0_;
        private ByteString contentId_;
        private int cryptoPeriodIndex_;
        private ByteString groupedLicense_;
        private String policy_;
        private int protectionScheme_;
        private Internal.ProtobufList<ByteString> keyId_ = GeneratedMessageLite.emptyProtobufList();
        private String provider_ = "";

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public enum Algorithm implements Internal.EnumLite {
            UNENCRYPTED(0),
            AESCTR(1);
            
            public static final int AESCTR_VALUE = 1;
            public static final int UNENCRYPTED_VALUE = 0;
            private static final Internal.EnumLiteMap<Algorithm> internalValueMap = new Internal.EnumLiteMap<Algorithm>() { // from class: com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshData.Algorithm.1
                public Algorithm findValueByNumber(int i) {
                    return Algorithm.forNumber(i);
                }
            };
            private final int value;

            /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
            public static final class AlgorithmVerifier implements Internal.EnumVerifier {
                public static final Internal.EnumVerifier INSTANCE = new AlgorithmVerifier();

                private AlgorithmVerifier() {
                }

                public boolean isInRange(int i) {
                    return Algorithm.forNumber(i) != null;
                }
            }

            Algorithm(int i) {
                this.value = i;
            }

            public static Algorithm forNumber(int i) {
                if (i != 0) {
                    if (i != 1) {
                        return null;
                    }
                    return AESCTR;
                }
                return UNENCRYPTED;
            }

            public static Internal.EnumLiteMap<Algorithm> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return AlgorithmVerifier.INSTANCE;
            }

            @Deprecated
            public static Algorithm valueOf(int i) {
                return forNumber(i);
            }

            public final int getNumber() {
                return this.value;
            }
        }

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<WidevinePsshData, Builder> implements WidevinePsshDataOrBuilder {
            private Builder() {
                super(WidevinePsshData.DEFAULT_INSTANCE);
            }

            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllKeyId(Iterable<? extends ByteString> iterable) {
                copyOnWrite();
                ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).addAllKeyId(iterable);
                return this;
            }

            public Builder addKeyId(ByteString byteString) {
                copyOnWrite();
                ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).addKeyId(byteString);
                return this;
            }

            public Builder clearAlgorithm() {
                copyOnWrite();
                ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).clearAlgorithm();
                return this;
            }

            public Builder clearContentId() {
                copyOnWrite();
                ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).clearContentId();
                return this;
            }

            public Builder clearCryptoPeriodIndex() {
                copyOnWrite();
                ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).clearCryptoPeriodIndex();
                return this;
            }

            public Builder clearGroupedLicense() {
                copyOnWrite();
                ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).clearGroupedLicense();
                return this;
            }

            public Builder clearKeyId() {
                copyOnWrite();
                ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).clearKeyId();
                return this;
            }

            public Builder clearPolicy() {
                copyOnWrite();
                ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).clearPolicy();
                return this;
            }

            public Builder clearProtectionScheme() {
                copyOnWrite();
                ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).clearProtectionScheme();
                return this;
            }

            public Builder clearProvider() {
                copyOnWrite();
                ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).clearProvider();
                return this;
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
            public Algorithm getAlgorithm() {
                return ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).getAlgorithm();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
            public ByteString getContentId() {
                return ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).getContentId();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
            public int getCryptoPeriodIndex() {
                return ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).getCryptoPeriodIndex();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
            public ByteString getGroupedLicense() {
                return ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).getGroupedLicense();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
            public ByteString getKeyId(int i) {
                return ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).getKeyId(i);
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
            public int getKeyIdCount() {
                return ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).getKeyIdCount();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
            public List<ByteString> getKeyIdList() {
                return Collections.unmodifiableList(((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).getKeyIdList());
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
            public String getPolicy() {
                return ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).getPolicy();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
            public ByteString getPolicyBytes() {
                return ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).getPolicyBytes();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
            public int getProtectionScheme() {
                return ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).getProtectionScheme();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
            public String getProvider() {
                return ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).getProvider();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
            public ByteString getProviderBytes() {
                return ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).getProviderBytes();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
            public boolean hasAlgorithm() {
                return ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).hasAlgorithm();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
            public boolean hasContentId() {
                return ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).hasContentId();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
            public boolean hasCryptoPeriodIndex() {
                return ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).hasCryptoPeriodIndex();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
            public boolean hasGroupedLicense() {
                return ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).hasGroupedLicense();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
            public boolean hasPolicy() {
                return ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).hasPolicy();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
            public boolean hasProtectionScheme() {
                return ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).hasProtectionScheme();
            }

            @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
            public boolean hasProvider() {
                return ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).hasProvider();
            }

            public Builder setAlgorithm(Algorithm algorithm) {
                copyOnWrite();
                ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).setAlgorithm(algorithm);
                return this;
            }

            public Builder setContentId(ByteString byteString) {
                copyOnWrite();
                ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).setContentId(byteString);
                return this;
            }

            public Builder setCryptoPeriodIndex(int i) {
                copyOnWrite();
                ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).setCryptoPeriodIndex(i);
                return this;
            }

            public Builder setGroupedLicense(ByteString byteString) {
                copyOnWrite();
                ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).setGroupedLicense(byteString);
                return this;
            }

            public Builder setKeyId(int i, ByteString byteString) {
                copyOnWrite();
                ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).setKeyId(i, byteString);
                return this;
            }

            public Builder setPolicy(String str) {
                copyOnWrite();
                ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).setPolicy(str);
                return this;
            }

            public Builder setPolicyBytes(ByteString byteString) {
                copyOnWrite();
                ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).setPolicyBytes(byteString);
                return this;
            }

            public Builder setProtectionScheme(int i) {
                copyOnWrite();
                ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).setProtectionScheme(i);
                return this;
            }

            public Builder setProvider(String str) {
                copyOnWrite();
                ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).setProvider(str);
                return this;
            }

            public Builder setProviderBytes(ByteString byteString) {
                copyOnWrite();
                ((WidevinePsshData) ((GeneratedMessageLite.Builder) this).instance).setProviderBytes(byteString);
                return this;
            }
        }

        static {
            WidevinePsshData widevinePsshData = new WidevinePsshData();
            DEFAULT_INSTANCE = widevinePsshData;
            GeneratedMessageLite.registerDefaultInstance(WidevinePsshData.class, widevinePsshData);
        }

        private WidevinePsshData() {
            ByteString byteString = ByteString.EMPTY;
            this.contentId_ = byteString;
            this.policy_ = "";
            this.groupedLicense_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllKeyId(Iterable<? extends ByteString> iterable) {
            ensureKeyIdIsMutable();
            AbstractMessageLite.addAll(iterable, this.keyId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addKeyId(ByteString byteString) {
            byteString.getClass();
            ensureKeyIdIsMutable();
            this.keyId_.add(byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAlgorithm() {
            this.bitField0_ &= -2;
            this.algorithm_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearContentId() {
            this.bitField0_ &= -5;
            this.contentId_ = getDefaultInstance().getContentId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCryptoPeriodIndex() {
            this.bitField0_ &= -17;
            this.cryptoPeriodIndex_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGroupedLicense() {
            this.bitField0_ &= -33;
            this.groupedLicense_ = getDefaultInstance().getGroupedLicense();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKeyId() {
            this.keyId_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPolicy() {
            this.bitField0_ &= -9;
            this.policy_ = getDefaultInstance().getPolicy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProtectionScheme() {
            this.bitField0_ &= -65;
            this.protectionScheme_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProvider() {
            this.bitField0_ &= -3;
            this.provider_ = getDefaultInstance().getProvider();
        }

        private void ensureKeyIdIsMutable() {
            Internal.ProtobufList<ByteString> protobufList = this.keyId_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.keyId_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static WidevinePsshData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(WidevinePsshData widevinePsshData) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(widevinePsshData);
        }

        public static WidevinePsshData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WidevinePsshData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WidevinePsshData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WidevinePsshData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WidevinePsshData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (WidevinePsshData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static WidevinePsshData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WidevinePsshData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WidevinePsshData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (WidevinePsshData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WidevinePsshData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WidevinePsshData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static WidevinePsshData parseFrom(InputStream inputStream) throws IOException {
            return (WidevinePsshData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WidevinePsshData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WidevinePsshData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WidevinePsshData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (WidevinePsshData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static WidevinePsshData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WidevinePsshData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static WidevinePsshData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (WidevinePsshData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WidevinePsshData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WidevinePsshData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<WidevinePsshData> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAlgorithm(Algorithm algorithm) {
            this.algorithm_ = algorithm.getNumber();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContentId(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.contentId_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCryptoPeriodIndex(int i) {
            this.bitField0_ |= 16;
            this.cryptoPeriodIndex_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGroupedLicense(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 32;
            this.groupedLicense_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeyId(int i, ByteString byteString) {
            byteString.getClass();
            ensureKeyIdIsMutable();
            this.keyId_.set(i, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPolicy(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.policy_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPolicyBytes(ByteString byteString) {
            this.policy_ = byteString.toStringUtf8();
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProtectionScheme(int i) {
            this.bitField0_ |= 64;
            this.protectionScheme_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProvider(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.provider_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProviderBytes(ByteString byteString) {
            this.provider_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new WidevinePsshData();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\t\b\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001c\u0003ဈ\u0001\u0004ည\u0002\u0006ဈ\u0003\u0007ဋ\u0004\bည\u0005\tဋ\u0006", new Object[]{"bitField0_", "algorithm_", Algorithm.internalGetVerifier(), "keyId_", "provider_", "contentId_", "policy_", "cryptoPeriodIndex_", "groupedLicense_", "protectionScheme_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    GeneratedMessageLite.DefaultInstanceBasedParser defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (WidevinePsshData.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        }
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
        public Algorithm getAlgorithm() {
            Algorithm forNumber = Algorithm.forNumber(this.algorithm_);
            return forNumber == null ? Algorithm.UNENCRYPTED : forNumber;
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
        public ByteString getContentId() {
            return this.contentId_;
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
        public int getCryptoPeriodIndex() {
            return this.cryptoPeriodIndex_;
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
        public ByteString getGroupedLicense() {
            return this.groupedLicense_;
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
        public ByteString getKeyId(int i) {
            return (ByteString) this.keyId_.get(i);
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
        public int getKeyIdCount() {
            return this.keyId_.size();
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
        public List<ByteString> getKeyIdList() {
            return this.keyId_;
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
        public String getPolicy() {
            return this.policy_;
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
        public ByteString getPolicyBytes() {
            return ByteString.copyFromUtf8(this.policy_);
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
        public int getProtectionScheme() {
            return this.protectionScheme_;
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
        public String getProvider() {
            return this.provider_;
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
        public ByteString getProviderBytes() {
            return ByteString.copyFromUtf8(this.provider_);
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
        public boolean hasAlgorithm() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
        public boolean hasContentId() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
        public boolean hasCryptoPeriodIndex() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
        public boolean hasGroupedLicense() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
        public boolean hasPolicy() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
        public boolean hasProtectionScheme() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // com.hunantv.media.drm.protoc.WidevinePsshDataOuterClass.WidevinePsshDataOrBuilder
        public boolean hasProvider() {
            return (this.bitField0_ & 2) != 0;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface WidevinePsshDataOrBuilder extends MessageLiteOrBuilder {
        WidevinePsshData.Algorithm getAlgorithm();

        ByteString getContentId();

        int getCryptoPeriodIndex();

        ByteString getGroupedLicense();

        ByteString getKeyId(int i);

        int getKeyIdCount();

        List<ByteString> getKeyIdList();

        String getPolicy();

        ByteString getPolicyBytes();

        int getProtectionScheme();

        String getProvider();

        ByteString getProviderBytes();

        boolean hasAlgorithm();

        boolean hasContentId();

        boolean hasCryptoPeriodIndex();

        boolean hasGroupedLicense();

        boolean hasPolicy();

        boolean hasProtectionScheme();

        boolean hasProvider();
    }

    private WidevinePsshDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
