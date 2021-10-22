package li.lin.utils;

import java.nio.charset.StandardCharsets;

/**
 * @author ：lin
 * @date ：Created in 2021/10/21 20:04
 * @description：中文转义
 * @modified By：
 * @version:
 */
public class EscapeHtmlUtil {

    /**
     * 中文转义特殊字符
     * @param str
     * @return
     */
    public static String escape(String str){
        return new String(str.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
    }

    /**
     * 特殊字符转义中文
     * @param str
     * @return
     */
    public static String unescape(String str){
        return new String(str.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }

    public static void main(String[] args){
        String str = "zhaopian照片";
        System.out.println(escape(str));

        System.out.println(unescape(escape(str)));
    }
}
