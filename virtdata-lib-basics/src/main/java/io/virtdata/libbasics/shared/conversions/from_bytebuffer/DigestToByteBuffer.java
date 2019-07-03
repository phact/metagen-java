package io.virtdata.libbasics.shared.conversions.from_bytebuffer;

import io.virtdata.annotations.Categories;
import io.virtdata.annotations.Category;
import io.virtdata.annotations.ThreadSafeMapper;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Computes the digest of the ByteBuffer on input and stores it in the output
 * ByteBuffer. The digestTypes available are:
 * <UL>
 *     <LI>MD2</LI>
 *     <LI>MD5</LI>
 *     <LI>SHA-1</LI>
 *     <LI>SHA-224</LI>
 *     <LI>SHA-256</LI>
 *     <LI>SHA-384</LI>
 *     <LI>SHA-512</LI>
 *     <LI>SHA3-224</LI>
 *     <LI>SHA3-256</LI>
 *     <LI>SHA3-384</LI>
 *     <LI>SHA3-512</LI>
 * </UL>
 */
@Categories(Category.conversion)
@ThreadSafeMapper
public class DigestToByteBuffer implements Function<ByteBuffer,ByteBuffer> {

    private static ThreadLocal<TL_State> tl_state;

    public DigestToByteBuffer(String digestType) {

        for (String digestName : MessageDigestAlgorithms.values()) {
            if (digestName.equals(digestType)) {
                Supplier<MessageDigest> mds = () -> getDigest(digestName);
                tl_state = ThreadLocal.withInitial(() -> new TL_State(mds));
                break;
            }
        }
        if (tl_state==null) {
            tl_state = ThreadLocal.withInitial(() -> new TL_State(() -> getDigest(digestType)));
        }
    }

    private static MessageDigest getDigest(String type) {
        try {
            return MessageDigest.getInstance(type);
        } catch (Exception e) {
            throw new RuntimeException("A digest of type " + type + " was not found. Select a digest type from: " +
                    Arrays.stream(MessageDigestAlgorithms.values()).collect(Collectors.joining(",", "[", "]")));
        }
    }

    @Override
    public ByteBuffer apply(ByteBuffer byteBuffer) {
        TL_State state = tl_state.get();
        byte[] digest = state.digest.digest(byteBuffer.array());
        return ByteBuffer.wrap(digest);
    }

    private final static class TL_State {
        private final MessageDigest digest;
        private final ByteBuffer buf = ByteBuffer.allocate(Long.BYTES);

        public TL_State(Supplier<MessageDigest> mds) {
            digest = mds.get();
        }
    }
}
