package chapter4;

public class JavaURI2 {
    public static void main(String[] args) {
        String baseURLStr = "http://www.ietf.org/rfc/rfc3986.txt";
        String relativeURLStr = "rfc2732.txt";
        URL baseURL = new URL(baseURLStr);
        URL resolvedRelativeURL = new URL(baseURL, relativeURLStr);
        System.out.println("Base URL:" + baseURL);
        System.out.println("Relative URL  String:" + relativeURLStr);
        System.out.println("Resolved Relative URL:" + resolvedRelativeURL);
    }
}
