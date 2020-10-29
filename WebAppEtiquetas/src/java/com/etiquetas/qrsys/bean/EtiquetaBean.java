package com.etiquetas.qrsys.bean;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

public class EtiquetaBean {

    private final String pathLabel = "/home/danteac/Documents/ExcelFile/";

    public EtiquetaBean() {
    }

    public void generarQR(String fileName, String fact, String art, String descr, String serie, String proveedor, String pedimento, String aduana, String fecha) {
//        try {
//            Document document = new Document(new Rectangle(190, 190));
//            document.setMargins(15, 3, 15, 3);
//
//            try {
//                @SuppressWarnings("unused")
//                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pathLabel + fileName + ".pdf"));
//            } catch (DocumentException | FileNotFoundException e) {
//
//            }
//
//            document.open();
//            PdfPTable table = new PdfPTable(2);
//            table.getDefaultCell().setBorder(0);
//            table.setWidthPercentage(102);
//
//            BaseFont basefont = null;
//            try {
//                basefont = BaseFont.createFont("/com/etiquetas/qrsys/font/Verdana.ttf", BaseFont.WINANSI,
//                        BaseFont.NOT_EMBEDDED);
//            } catch (IOException ex) {
//
//            }
//            Font font = new Font(basefont);
//            font.setStyle(Font.NORMAL);
//            font.setSize(5);
//
//            Font fontBold = new Font(basefont);
//            fontBold.setStyle(Font.BOLD);
//            fontBold.setSize((float) 6.5);
//
//            document.add(new Paragraph("No. Factura: ".concat(fact), font));
//            document.add(new Paragraph("Clave Artículo: ".concat(art), font));
//            document.add(new Paragraph("Descripción: ".concat(descr), font));
//            document.add(new Paragraph("No. Serie: ".concat(serie), fontBold));
//            document.add(new Paragraph("Proveedor: ".concat(proveedor), font));
//            document.add(new Paragraph("Pedimento: ".concat(pedimento), font));
//            document.add(new Paragraph("Aduana: ".concat(aduana), font));
//            document.add(new Paragraph("Fecha de Pedimento: ".concat(fecha).concat("\n\n"), font));
//            table.addCell(new Paragraph("\n\n\n\n\n\nMarubeni México, S.A. de C.V.\n", font));
//            BarcodeQRCode my_code = new BarcodeQRCode(art.concat("|").concat(descr).concat("|").concat(serie).concat("|").concat(fact).concat("|").concat(proveedor).concat("|").concat(aduana).concat("|").concat(fecha),
//                    100, 100, null);
////            BarcodeQRCode my_code = new BarcodeQRCode(
////                    "ORR02525|18.00R25 1* VSMS  L5S|F1M482612|7GA00553|MARUBENI CORPORATION (B401)|3397-1003028|MANZANILLO|2011-11-19 00:00:00.000",
////                    100, 100, null);
//            Image qr_image = my_code.getImage();
//            qr_image.setAbsolutePosition(120, 0);
//
//            table.addCell(qr_image);
//            document.add(table);
//            document.close();
//        } catch (DocumentException ex) {
//
//        }

    }

    public void imprimirQR() {

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("https://www.uam.es/personal_pdi/economicas/eva/pdf/intro2.pdf");
        } catch (FileNotFoundException e) {
        }
        if (inputStream == null) {
            return;
        }
        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc document = new SimpleDoc(inputStream, docFormat, null);

        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();

        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

        if (defaultPrintService != null) {
            DocPrintJob printJob = defaultPrintService.createPrintJob();
            try {
                printJob.print(document, attributeSet);

            } catch (PrintException e) {
            }
        } else {
            System.err.println("No existen impresoras instaladas");
        }

        try {
            inputStream.close();
        } catch (IOException e) {
        }
    }

}
