/**
 * import the parts of the Java standard library that we need.
 */
import java.awt.font.TextHitInfo;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * this is the thirdLab.
 * @author Irdina
 *
 */
public class thirdLab {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     * This is the total word count subroutine.
     * @param url is the parameter
     * @return int which is the word count
     */
    public static int wordCount(final String url) {
        Scanner wordMarker = new Scanner(url);
        int count = 0;
        while (wordMarker.hasNext()) {
            wordMarker.next();
            count++;
        }
        return count;
    }

    /**
     * This is the total word count of specific words subroutine.
     * @param url is the parameter
     * @param target is the word you are looking for
     * @return int which is the word count of the specfic word
     */
    public static int wordTargetCount(final String url, final String target) {
        Scanner wordMarker = new Scanner(url);
        int count = 0;
        while (wordMarker.hasNext()) {
            if (target.equalsIgnoreCase(wordMarker.next())) {
                count++;
            }
        }
        return count;
    }

    /**
     * this is the main method.
     * @param args is the parameter
     */
    public static void main(final String[] args) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        //System.out.println(urlToString("https://www.bls.gov/tus/charts/chart9.txt"));
        //System.out.println
        //(urlToString("http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt"));
        System.out.println(wordCount(urlToString("http://erdani.com/tdpl/hamlet.txt")));
        System.out.println(wordTargetCount(
                urlToString("http://erdani.com/tdpl/hamlet.txt"), "prince"));
    }
}
