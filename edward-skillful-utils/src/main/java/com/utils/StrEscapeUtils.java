package com.utils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.translate.CharSequenceTranslator;
import org.apache.commons.lang3.text.translate.LookupTranslator;

/**
 * 参考 Apache Commons-Lang 3中的 StringEscapeUtils 提供将指定要用于SQL中LIKE操作的字符串中的特殊字符进行转义。
 *
 * 说明：PostGreSQL中的默认转义字符是反斜杠。
 *
 * @author zhangliangliang
 *
 */
public final class StrEscapeUtils {

    private StrEscapeUtils(){

    }

    public static final CharSequenceTranslator ESCAPE_SQL = new LookupTranslator(
            new String[][]{
                    {"\\", "\\\\"},
                    {"%", "\\%"},});

    public static final CharSequenceTranslator UNESCAPE_SQL =new LookupTranslator(
            new String[][]{
                    {"\\\\", "\\"},
                    {"\\%", "%"},
                    {"\\_", "_"},});

    public static final CharSequenceTranslator ESCAPE_HTML = new LookupTranslator(
            new String[][]{
				    {"<", "&lt;"},
				    {">", "&gt;"},
				    {"&", "&amp;"},
				    {"\"", "&quot;"}});

    public static final CharSequenceTranslator UNESCAPE_HTML =new LookupTranslator(
            new String[][]{
                    {"&lt;", "<"},
                    {"&gt;", ">"},
                    {"&amp;", "&"},
                    {"&quot;", "\""}});

    /**
     * 将输入值转义为LIKE可用的SQL语句。
     *
     * @param input
     *            输入值
     * @return 转义后的字符串。
     */
    public static String escapeSql(String input) {
        return ESCAPE_SQL.translate(input);
    }

    /**
     * 是 {@link #escapeSql(String) escapeSql(String)} 的反操作。
     *
     * @param input
     *            被转义的字符串
     * @return 转义前的字符串。
     */
    public static String unescapeSql(String input) {
        return UNESCAPE_SQL.translate(input);
    }

    /**
     * 使HTML的标签中的<>&"失去作用
     *
     * @param input 需要处理的字符串
     * @return 如果input为null，返回null；否则返回转以后的字符串
     */
    public static final String escapeHTMLTag(String input) {
        if (StringUtils.isBlank(input)) {
            return input;
        }
//        StringBuilder stringBuilder = new StringBuilder();
//        for (char charT : input.toCharArray()) {
//            switch (charT) {
//            case '<':
//                stringBuilder.append("&lt;");
//                break;
//            case '>':
//                stringBuilder.append("&gt;");
//                break;
//            case '&':
//                stringBuilder.append("&amp;");
//                break;
//            case '"':
//                stringBuilder.append("&quot;");
//                break;
//            default:
//                stringBuilder.append(charT);
//                break;
//            }
//        }
//        return stringBuilder.toString();

        return ESCAPE_HTML.translate(input);
    }

    /**
     * {@link #escapeHTMLTag(String)}的逆运算
     *
     * @param input 需要处理的字符串
     * @return 如果input为null，返回null；否则返回转换后字符串
     */
    public static final String unescapeHTMLTag(String input) {
        if (StringUtils.isBlank(input)) {
            return input;
        }
        return UNESCAPE_HTML.translate(input);
    }

    /**
     *
     * 剔除input中的作为操作系统文件名一般情况下不合法字符及空格并返回
     * <p>这些字符包括：<pre>+<>|/\:"*?$#~</pre>空格以及首字符半角句号
     *
     * @author jmy
     * @version v2.2.9
     * @date 2015年4月17日 下午6:37:41
     *
     * @param input 待处理的将作为文件名的字符串
     * @param defaultName 默认文件名
     * @return 如果input参数被处理后为null或空字符串，返回该defaultName。
     */
    public static final String escapeWinFileName(String input, String defaultName) {
    	if (input != null) {
    		input = input.replaceAll("^\\.+|[+<>\\|/\\\\:\"\\*?$#~]+|\\s+", "");
    	}
    	return input != null && input.length() > 0 ? input : defaultName;
    }

    public static void main(String[] args) {
    	//HTML Escapte TEST
    	System.out.println(escapeWinFileName("..fff<>,/,\\|+   ,d #  *\"\\ $ d:,s\\\\,?\"234.txt    d ", "defaultName"));
    	String html = "\"><script>alert(\"XSS!\");&amp;amp;&gt;&lt;&quot;</script>";
    	String ehtml = escapeHTMLTag(html);
    	String uehtml = unescapeHTMLTag(ehtml);
    	System.out.println(html);
    	System.out.println(ehtml);
    	System.out.println(uehtml);
    	System.out.println(uehtml.equals(html));
    }
}

