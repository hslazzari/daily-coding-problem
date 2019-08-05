package dayFiftyFiveURLShortener;

import java.util.HashMap;
import java.util.Random;

public class Solution {

    private static class URLShortener {
        private HashMap<String, String> urlToShort;
        private HashMap<String, String> shortToUrl;
        private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUV123456";
        private static int size = 6;

        public URLShortener() {
            urlToShort = new HashMap<String, String>();
            shortToUrl = new HashMap<String, String>();
        }

        public String shorten(String url) {
            if(this.urlToShort.containsKey(url)) {
                return this.urlToShort.get(url);
            }

            Random r = new Random();

            String shortUrl = "";
            for(int i = 0; i < size; i++) {
                shortUrl += alphabet.charAt(r.nextInt(alphabet.length()));
            }

            urlToShort.put(url, shortUrl);
            shortToUrl.put(shortUrl, url);
            return shortUrl;
        }
    }
    
    public static void main(String[] args) {
    	URLShortener u = new URLShortener();
    	System.out.println(u.shorten("testeSigma.txt"));
    }

}