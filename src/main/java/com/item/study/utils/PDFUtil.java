package com.item.study.utils;

//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Paragraph;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;

/**
 * Author: Meng
 * Date: 2024-12-21
 * Desc:
 *      @GetMapping("/export")
 *     public ResponseEntity<byte[]> generatePdf(@RequestParam String content) {
 *         byte[] pdfBytes = pdfService.generatePdf(content);
 *
 *         return ResponseEntity.ok()
 *                 .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=generated.pdf")
 *                 .contentType(MediaType.APPLICATION_PDF)
 *                 .body(pdfBytes);
 *     }
 */
public class PDFUtil {

    public static byte[] create(String content) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        PdfWriter writer = new PdfWriter(byteArrayOutputStream);
//        PdfDocument pdfDoc = new PdfDocument(writer);
//        Document document = new Document(pdfDoc);
//
//        document.add(new Paragraph(content));
//        document.close();

        return byteArrayOutputStream.toByteArray();
    }

    public static ResponseEntity<byte[]> pdfBody(String content) {
        byte[] pdfBytes = create(content);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=generated.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }

}
