package chapter4;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncoderTest {
    public static void main(String[] args) throws Exception{
        String source = "index&^%*a test for 2.5% and  &";
        String encoded = URLEncoder.encode(source, "utf-8");
        String decoded = URLDecoder.decode(encoded, "utf-8");
        System.out.println("Source: " + source);
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + decoded);
    }
}
