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
                    {"%", "\\%"},
                    {"_", "\\_"},});

    public static final CharSequenceTranslator UNESCAPE_SQL =new LookupTranslator(
            new String[][]{
                    {"\\\\", "\\"},
                    {"\\%", "%"},
                    {"\\_", "_"},});

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
     * @return 如果input为null，返回null；否则返回
     */
    public static final String escapeHTMLTag(String input) {
        if (StringUtils.isBlank(input)) {
            return input;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char charT : input.toCharArray()) {
            switch (charT) {
            case '<':
                stringBuilder.append("&lt;");
                break;
            case '>':
                stringBuilder.append("&gt;");
                break;
            case '&':
                stringBuilder.append("&amp;");
                break;
            case '"':
                stringBuilder.append("&quot;");
                break;
            default:
                stringBuilder.append(charT);
                break;
            }
        }
        return stringBuilder.toString();
    }
    /**
     * 使HTML的标签中的<>&"失去作用
     *
     * @param input 需要处理的字符串
     * @return 如果input为null，返回null；否则返回
     */
    public static final String turnHTMLTag(String input) {
        if (StringUtils.isBlank(input)) {
            return input;
        }

        return input.replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&").replace("&quot;", "\"");

    }
}
