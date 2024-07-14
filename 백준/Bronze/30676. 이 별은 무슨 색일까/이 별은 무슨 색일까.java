import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int wavelength = Integer.parseInt(br.readLine());

        if (wavelength >= 380 && wavelength < 425) {
            System.out.println("Violet");
        } else if (wavelength >= 425 && wavelength < 450) {
            System.out.println("Indigo");
        } else if (wavelength >= 450 && wavelength < 495) {
            System.out.println("Blue");
        } else if (wavelength >= 495 && wavelength < 570) {
            System.out.println("Green");
        } else if (wavelength >= 570 && wavelength < 590) {
            System.out.println("Yellow");
        } else if (wavelength >= 590 && wavelength < 620) {
            System.out.println("Orange");
        } else if (wavelength >= 620 && wavelength <= 780) {
            System.out.println("Red");
        }

    }

}