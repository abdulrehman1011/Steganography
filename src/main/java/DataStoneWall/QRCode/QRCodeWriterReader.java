/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStoneWall.QRCode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumMap;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author AbdulRehman
 */
public class QRCodeWriterReader {

    public static BufferedImage createQRCode(String qrCodeData, int qrCodeheight, int qrCodewidth)
            throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(qrCodeData.getBytes()),
                BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight);
        return MatrixToImageWriter.toBufferedImage(matrix);
    }

    public static BufferedImage createQRCodeInFile(String qrCodeData, int qrCodeheight, int qrCodewidth)
            throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(qrCodeData.getBytes()),
                BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight);
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(matrix, "PNG", pngOutputStream);
            byte[] pngData = pngOutputStream.toByteArray();
           SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
            Date date = new Date();
             Path path = FileSystems.getDefault().getPath(sdf.format(new Timestamp(date.getTime()))+".png");
             MatrixToImageWriter.writeToPath(matrix, "PNG", path);
            InputStream in = new ByteArrayInputStream(pngData);
            BufferedImage bImageFromConvert = ImageIO.read(in);
        return bImageFromConvert;
    }

    public static String readQRCode(BufferedImage image)
            throws FileNotFoundException, IOException, NotFoundException {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(image)));
        Result qrCodeResult;
        qrCodeResult = new MultiFormatReader().decode(binaryBitmap);
        return qrCodeResult.getText().trim();
    }
}
