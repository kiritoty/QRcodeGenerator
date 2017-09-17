import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.MultiFormatWriter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;


/**
 * Created by Administrator on 2017/9/15.
 */


public class createQRcode {

    public static int WHITE = Color.WHITE.getRGB();
    public static int BLACK = Color.black.getRGB();
    public static int size = 440;
    public static String QR_Format = "png";
    public static byte[] point = new byte[0];


    public static byte[] createQrCode(String content, int size, String extension ) {

        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();

        try{
            HashMap<EncodeHintType, Object> hashMap = new HashMap<>();
            hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

            BitMatrix matrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, size, size, hashMap);

            int width = matrix.getWidth();
            int height = matrix.getHeight();

            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            for(int i = 0; i < width; i++) {
                for(int j = 0; j < height; j++){
                    if(matrix.get(i,j)){
                        image.setRGB(i, j, BLACK);
                    } else {
                        image.setRGB(i, j, WHITE);
                    }
                }
            }
            ImageIO.write(image,extension, byteOut);
            return byteOut.toByteArray();

        }catch(Exception e){

        }

        return point;
    }

    public static byte[] createQrCode(String content){
        return createQrCode(content, size, QR_Format);
    }
}

