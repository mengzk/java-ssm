package com.item.study.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Base64;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public class EncodeUtils {

    public void testDES() throws Exception {
        String value = "rawchen";
        System.out.println("待加密值：" + value);
        // 加密算法
        String algorithm = "DES";
        // 转换模式
        String transformation = "DES";
        // --- 生成秘钥 ---
        // 实例化秘钥生成器
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        // 初始化秘钥长度
        keyGenerator.init(56);
        // 生成秘钥
        SecretKey secretKey = keyGenerator.generateKey();
        // 实例化DES秘钥材料
        DESKeySpec desKeySpec = new DESKeySpec(secretKey.getEncoded());
        // 实例化秘钥工厂
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(algorithm);
        // 生成DES秘钥
        SecretKey desSecretKey = secretKeyFactory.generateSecret(desKeySpec);
        System.out.println("DES秘钥：" + Base64.getEncoder().encodeToString(desSecretKey.getEncoded()));

        // 实例化密码对象
        Cipher cipher = Cipher.getInstance(transformation);
        // 设置模式（ENCRYPT_MODE：加密模式；DECRYPT_MODE：解密模式）和指定秘钥
        cipher.init(Cipher.ENCRYPT_MODE, desSecretKey);
        // 加密
        byte[] encrypt = cipher.doFinal(value.getBytes());
        System.out.println("DES加密结果：" + Base64.getEncoder().encodeToString(encrypt));
        // 解密
        // 设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, desSecretKey);
        byte[] decrypt = cipher.doFinal(encrypt);
        System.out.println("DES解密结果：" + new String(decrypt));
    }

    public void DESedeTest() throws Exception {
        String value = "哈哈哈哈哈洒水的";
        System.out.println("待加密值：" + value);
        // 加密算法
        String algorithm = "DESede";
        // 转换模式
        String transformation = "DESede";
        // --- 生成秘钥 ---
        // 实例化秘钥生成器
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        // 初始化秘钥长度
        keyGenerator.init(112);
        // 生成秘钥
        SecretKey secretKey = keyGenerator.generateKey();
        // 实例化DESede秘钥材料
        DESedeKeySpec desKeySpec = new DESedeKeySpec(secretKey.getEncoded());
        // 实例化秘钥工厂
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(algorithm);
        // 生成DES秘钥
        SecretKey desSecretKey = secretKeyFactory.generateSecret(desKeySpec);
        System.out.println("DESede秘钥：" + Base64.getEncoder().encodeToString(desSecretKey.getEncoded()));

        // 实例化密码对象
        Cipher cipher = Cipher.getInstance(transformation);
        // 设置模式（ENCRYPT_MODE：加密模式；DECRYPT_MODE：解密模式）和指定秘钥
        cipher.init(Cipher.ENCRYPT_MODE, desSecretKey);
        // 加密
        byte[] encrypt = cipher.doFinal(value.getBytes());
        System.out.println("DESede加密结果：" + Base64.getEncoder().encodeToString(encrypt));
        // 解密
        // 设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, desSecretKey);
        byte[] decrypt = cipher.doFinal(encrypt);
        System.out.println("DESede解密结果：" + new String(decrypt));
    }


    public static void AES() throws Exception {
        String value = "ajjasdakkasda";
        System.out.println("待加密值：" + value);
        // 加密算法
        String algorithm = "AES";
        // 转换模式
        String transformation = "AES";
        // --- 生成秘钥 ---
        // 实例化秘钥生成器
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        // 初始化秘钥长度
        keyGenerator.init(256);
        // 生成秘钥
        SecretKey secretKey = keyGenerator.generateKey();
        // 生成秘钥材料
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), algorithm);
        System.out.println("AES秘钥：" + Base64.getEncoder().encodeToString(secretKey.getEncoded()));

        // 实例化密码对象
        Cipher cipher = Cipher.getInstance(transformation);
        // 设置模式（ENCRYPT_MODE：加密模式；DECRYPT_MODE：解密模式）和指定秘钥
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        // 加密
        byte[] encrypt = cipher.doFinal(value.getBytes());
        System.out.println("AES加密结果：" + Base64.getEncoder().encodeToString(encrypt));
        // 解密
        // 设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decrypt = cipher.doFinal(encrypt);
        System.out.println("AES解密结果：" + new String(decrypt));

    }

    public static void RC4() throws Exception {
        String value = "asdadsasda";
        System.out.println("待加密值：" + value);
        // 加密算法
        String algorithm = "RC2";
        // 转换模式
        String transformation = "RC2";
        // --- 生成秘钥 ---
        // 实例化秘钥生成器
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        // 初始化秘钥长度
        keyGenerator.init(50);
        // 生成秘钥
        SecretKey secretKey = keyGenerator.generateKey();
        // 生成秘钥材料
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), algorithm);
        System.out.println("RC2秘钥：" + Base64.getEncoder().encodeToString(secretKey.getEncoded()));

        // 实例化密码对象
        Cipher cipher = Cipher.getInstance(transformation);
        // 设置模式（ENCRYPT_MODE：加密模式；DECRYPT_MODE：解密模式）和指定秘钥
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        // 加密
        byte[] encrypt = cipher.doFinal(value.getBytes());
        System.out.println("RC2加密结果：" + Base64.getEncoder().encodeToString(encrypt));
        // 解密
        // 设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decrypt = cipher.doFinal(encrypt);
        System.out.println("RC2解密结果：" + new String(decrypt));

    }

    public static void testRSA() throws Exception {
        String value = "askjakasdadsa";
        // 加密算法
        String algorithm = "RSA";
        // 转换模式
        String transform = "RSA/ECB/PKCS1Padding";
        // 实例化秘钥对生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        // 初始化，秘钥长度512~16384位，64倍数
        keyPairGenerator.initialize(512);
        // 生成秘钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 公钥
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("RSA公钥: " + Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        // 私钥
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("RSA私钥: " + Base64.getEncoder().encodeToString(privateKey.getEncoded()));

        // ------ 测试公钥加密，私钥解密 ------
        Cipher cipher = Cipher.getInstance(transform);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] pubEncryptBytes = cipher.doFinal(value.getBytes());
        System.out.println("RSA公钥加密后数据: " + Base64.getEncoder().encodeToString(pubEncryptBytes));

        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] priDecryptBytes = cipher.doFinal(pubEncryptBytes);
        System.out.println("RSA私钥解密后数据: " + new String(priDecryptBytes));

        // ------ 测试私钥加密，公钥解密 ------
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] priEncryptBytes = cipher.doFinal(value.getBytes());
        System.out.println("RSA私钥加密后数据: " + Base64.getEncoder().encodeToString(priEncryptBytes));

        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] pubDecryptBytes = cipher.doFinal(priEncryptBytes);
        System.out.println("RSA公钥解密后数据: " + new String(pubDecryptBytes));
    }

}
