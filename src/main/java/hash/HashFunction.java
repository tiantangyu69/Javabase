package hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashFunction {

    public long hash(String key) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            if (null == md5) {
                throw new NullPointerException();
            }
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("no md5 algorythm found");
        }
        md5.reset();
        md5.update(key.getBytes());
        byte[] bKey = md5.digest();
        long res = ((long) (bKey[3] & 0xFF) << 24)
                | ((long) (bKey[2] & 0xFF) << 16)
                | ((long) (bKey[1] & 0xFF) << 8) | (long) (bKey[0] & 0xFF);
        return res & 0xffffffffL;
    }
}