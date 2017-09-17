import java.io.FileOutputStream;

/**
 * Created by Administrator on 2017/9/15.
 */
public class test {
    public static void main(String[] args){

        try{
            FileOutputStream out = new FileOutputStream("test.png");
            out.write(createQRcode.createQrCode("123"));
            out.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
