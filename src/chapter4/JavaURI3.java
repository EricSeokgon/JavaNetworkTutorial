package chapter4;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class JavaURI3 {
    public static String getURLContent(String urlStr) throws Exception {
        BufferedReader br = null;
        URL url = new URL(urlStr);
        InputStream ins = url.openStream();
        br = new BufferedReader(new InputStreamReader(ins));

        StringBuilder sb = new StringBuilder();
        String msg = null;
        while ((msg = br.readLine()) != null) {
            sb.append(msg);
            sb.append("\n"); // Append a new line
        }
        br.close();
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        String urlStr = "http://java2s.com";
        String content = getURLContent(urlStr);
        System.out.println(content);

    }
}
