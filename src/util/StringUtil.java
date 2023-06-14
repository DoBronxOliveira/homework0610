package util;

import lombok.ToString;

import java.util.Random;

/**
 * @author Tan
 * @date 2023/6/13 10:28
 */
public class StringUtil {
    public static String getRandomStr(int n) {

        StringBuilder strPool = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 128; i++) {
            if (Character.isLetterOrDigit((char) i)) {
                strPool.append((char) i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(strPool.charAt(r.nextInt(strPool.length())));
        }
        return sb.toString();
    }
}
