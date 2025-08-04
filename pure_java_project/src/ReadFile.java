import java.io.File;
import java.io.FileInputStream;
public class fileReader {
    public static void main(String[] args) {
        File f = new File("/test.txt");
        try {
            FileInputStream fis = new FileInputStream(f);
            int c;
            while ((c = fis.read()) != -1 ) {
                System.out.println((char)c);

            }
        }cacth (Exception e) {
            e.printStackTrace();
        }
    }
}