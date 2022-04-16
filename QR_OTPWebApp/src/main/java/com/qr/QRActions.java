package com.qr;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRActions {

	private static final String UPLOAD_DIR = "qrcodes";
	
	public static String generateQRCode(String details , String fname, String applicationPath) throws Exception {
		
		String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
		 File fileSaveDir = new File(uploadFilePath);
	        if (!fileSaveDir.exists()) {
	            fileSaveDir.mkdirs();
	        }
	        
	    System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
        String filePath =uploadFilePath + File.separator+fname+".png";
        
        String qrCodeData = details;
        //"C:\\Users\\Dell\\Desktop\\QRCodes\\" 
        String charset = "UTF-8"; // or "ISO-8859-1"
        Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        BitMatrix matrix = new MultiFormatWriter().encode(
            new String(qrCodeData.getBytes(charset), charset),
            BarcodeFormat.QR_CODE, 200, 200, hintMap);
        MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
            .lastIndexOf('.') + 1), new File(filePath));
        System.out.println("QR Code image created successfully!");
		
        return filePath;
        //		ByteArrayOutputStream out= net.glxn.qrgen.QRCode.from(details).to(ImageType.JPG).withSize(300, 300).stream();
        //		File f = new File("C:\\Users\\Dell\\Desktop\\QRCodes\\"+fname+".jpg");
        //		FileOutputStream fos= new FileOutputStream(f);
        //		
        //		fos.write(out.toByteArray());
        //		fos.flush();
		}
	
	public static String readQRCode(String path, Map hintMap) throws FileNotFoundException, IOException, NotFoundException {
		
         FileInputStream stream= new FileInputStream(path);
         BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
	            new BufferedImageLuminanceSource(
	                ImageIO.read(stream))));
	        Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap, hintMap);
	        
	        String details = qrCodeResult.getText();
	        stream.close();
	        
	        return details;
		}
	
}
