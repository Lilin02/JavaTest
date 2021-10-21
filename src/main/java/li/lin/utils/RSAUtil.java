package li.lin.utils;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/*** rsa相关工具类
 *  使用说明：生成公私钥，私钥自己保留，公钥暴露出去
 *
 *  例如：
 *      mic方拥有：
 * 			支付的公钥
 * 			mic的私钥
 *      mic方对数据的操作：
 * 			（发送数据给支付）加签：mic的私钥
 * 			（从支付获得数据）验签：支付的公钥
 *
 * 		支付方拥有：
 * 			支付的私钥
 * 			mic的公钥
 *      支付方对数据的操作：
 * 			（发送数据给mic）加签：支付的私钥
 * 			（从mic获得数据）验签：mic的公钥
 *
 * @author lin
 * @since 2021/1/22 17:33
 */
public abstract class RSAUtil {
    public static final String ALGORITHM_RSA = "RSA";
    public static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final int RSA_KEY_SIZE = 2048;

    /**
     * 生成2048位的RSA密钥
     *
     * @return String[2] 0: 私钥 1: 公钥
     * @throws NoSuchAlgorithmException
     */
    public static String[] generateKeys() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM_RSA);
        keyPairGenerator.initialize(RSA_KEY_SIZE);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        String publicKey = Base64.encodeBase64String(keyPair.getPublic().getEncoded());
        String privateKey = Base64.encodeBase64String(keyPair.getPrivate().getEncoded());
        return new String[]{privateKey, publicKey};
    }

    /**
     * 对数据进行验签
     * @param data
     * @param sign
     * @param pubKey
     * @param algorithm
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws SignatureException
     * @throws InvalidKeySpecException
     */
    public static boolean verify(String data, String sign, String pubKey, String algorithm)
            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, InvalidKeySpecException {
        return verify(data.getBytes(UTF_8), sign, pubKey, algorithm);
    }

    /**
     * 对数据进行验签
     * @param data
     * @param sign
     * @param pubKey
     * @param algorithm
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws SignatureException
     * @throws InvalidKeySpecException
     */
    public static boolean verify(byte[] data, String sign, String pubKey, String algorithm)
            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, InvalidKeySpecException {
        byte[] keyBytes = Base64.decodeBase64(pubKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return verify(data, sign, publicKey, algorithm);
    }

    /**
     * 对数据进行验签
     * @param data
     * @param sign
     * @param publicKey
     * @param algorithm
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws SignatureException
     */
    public static boolean verify(byte[] data, String sign, PublicKey publicKey, String algorithm)
            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signature = Signature.getInstance(algorithm);
        signature.initVerify(publicKey);
        signature.update(data);
        return signature.verify(Base64.decodeBase64(sign));
    }

    /**
     * 对数据进行签名
     * @param data
     * @param priKey
     * @param algorithm
     * @return
     * @throws SignatureException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static String sign(String data, String priKey, String algorithm)
            throws SignatureException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException {
        return sign(data.getBytes(UTF_8), priKey, algorithm);
    }

    /**
     * 对数据进行签名
     * @param data
     * @param priKey
     * @param algorithm
     * @return
     * @throws SignatureException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static String sign(byte[] data, String priKey, String algorithm)
            throws SignatureException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] keyBytes = Base64.decodeBase64(priKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        return sign(data, privateKey, algorithm);
    }

    /**
     * 对数据进行签名
     * @param data
     * @param key
     * @param algorithm
     * @return
     * @throws InvalidKeyException
     * @throws SignatureException
     * @throws NoSuchAlgorithmException
     */
    public static String sign(byte[] data, PrivateKey key, String algorithm)
            throws InvalidKeyException, SignatureException, NoSuchAlgorithmException {
        Signature signature = Signature.getInstance(algorithm);
        signature.initSign(key);
        signature.update(data);
        byte[] result = signature.sign();
        return Base64.encodeBase64String(result);
    }
}
