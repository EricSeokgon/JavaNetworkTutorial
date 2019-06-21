package chapter4;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class javaURI4 {
    public static String getURLContent(String urlStr)
            throws Exception {
        URL url = new URL(urlStr);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        connection.connect();
        OutputStream ous = connection.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(ous));
        bw.write("index.htm");
        bw.flush();
        bw.close();

        printRequestHeaders(connection);
        InputStream ins = connection.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(ins));
        StringBuffer sb = new StringBuffer();
        String msg = null;
        while ((msg = br.readLine()) != null) {
            sb.append(msg);
            sb.append("\n"); // Append a new line
        }
        br.close();
        return sb.toString();
    }
    public static void printRequestHeaders(URLConnection connection) {
        Map headers = connection.getHeaderFields();
        System.out.println(headers);
    }
    public static void main(String[] args) throws Exception {
        String urlStr = "http://www.java2s.com";
        String content = getURLContent(urlStr);
        System.out.println(content);
    }
}
