package com.item.study.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Meng
 * Date: 2024-12-21
 * Desc:
 */
public class QrcodeUtil {

    /**
     * 生成二维码
     * @param text
     * @param width
     * @param height
     * @GetMapping(value = "/create")
     *  public ResponseEntity<Resource> barbecueEAN13Barcode(@PathVariable("text") String text)
     */
    public static ResponseEntity<Resource> create(String text, int width, int height) {
        System.out.println("生成二维码：" + text);
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, getHints());

            BufferedImage qrCodeImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(qrCodeImage, "PNG", byteArrayOutputStream);

            byte[] qrCodeBytes = byteArrayOutputStream.toByteArray();

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_PNG_VALUE);

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(qrCodeBytes.length)
                    .body(new ByteArrayResource(qrCodeBytes));
        } catch (IOException | WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成二维码
     * @param text
     * @GetMapping(value = "/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
     *  public ResponseEntity<BufferedImage> barbecueEAN13Barcode(@PathVariable("barcode") String barcode)
     */
    public static ResponseEntity<BufferedImage> create(String text) {
        System.out.println("生成二维码：" + text);
        try {
            QRCodeWriter barcodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = barcodeWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);

            BufferedImage qrCodeImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

            return ResponseEntity.ok(qrCodeImage);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void parse(String text) {
        System.out.println("解析二维码：" + text);
    }

    private static Map<EncodeHintType, Object> getHints() {
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);
        return hints;
    }
}
