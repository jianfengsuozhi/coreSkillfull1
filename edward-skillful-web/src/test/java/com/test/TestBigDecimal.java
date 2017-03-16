package com.test;


/**
 * Created by weideliang on 2016/11/24.
 */
public class TestBigDecimal {
    public static void main(String[] args) {
//        BigDecimal bigDecimal1 = new BigDecimal(1);
//        BigDecimal bigDecimal2 = new BigDecimal(2);
//
//        System.out.println(bigDecimal1.subtract(bigDecimal2));//减
//        System.out.println(bigDecimal1.multiply(bigDecimal2));//乘
//
//        BigDecimal zeroBigDecimal = new BigDecimal(0);
//        BigDecimal add = zeroBigDecimal.add(new BigDecimal(1));
//        System.out.println(add);

//        System.out.println("3.0".indexOf("."));
//        System.out.println(Double.parseDouble("3.0"));
//        BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf("3.0".substring(0,"3.0".indexOf("."))));

//        System.out.println(new BigDecimal(3.00).equals(new BigDecimal(3.0)));

/*        List<Long> list = null;
        for (Long aLong : list) {
            System.out.println();
        }*/
//
//        IdAndName idAndName = new IdAndName(1, "2");
//        IdAndName idAndName1 = new IdAndName(1, "2");
//        System.out.println(idAndName.equals(idAndName1));

/*        ArrayList<Integer> integers =
                Lists.newArrayList(1);
        for (Integer integer : integers) {
            integers.remove(integer);
        }*/

/*        System.out.println(StringEscapeUtils.escapeHtml("<a>dddd</a>"));// &lt;a&gt;dddd&lt;/a&gt;
        System.out.println(StringEscapeUtils.escapeJavaScript("<script>alert('1111')</script>"));// <script>alert(\'1111\')<\/script>*/
//        String str = StringEscapeUtils.escapeHtml("[{\"cI\":0,\"cN\":\"1\",\"cW\":72.0,},{\"cI\":1,\"cN\":\"0\",\"cW\":90.0,},{\"cI\":2,\"cN\":\"2\",\"cW\":144.0,},{\"cI\":3,\"cN\":\"3\",\"cW\":90.0,},{\"cI\":4,\"cN\":\"4\",\"cW\":90.0,},{\"cI\":5,\"cN\":\"5\",\"cW\":180.0,},{\"cI\":6,\"cN\":\"6\",\"cW\":180.0,},{\"cI\":7,\"cN\":\"7\",\"cW\":180.0,},{\"cI\":8,\"cN\":\"8\",\"cW\":108.0,},{\"cI\":9,\"cN\":\"9\",\"cW\":144.0,},{\"cI\":10,\"cN\":\"10\",\"cW\":144.0,},{\"cI\":11,\"cN\":\"11\",\"cW\":108.0,},{\"cI\":12,\"cN\":\"12\",\"cW\":162.0,},{\"cI\":13,\"cN\":\"13\",\"cW\":108.0,}]");

//        System.out.println(StringEscapeUtils.unescapeHtml(str));

/*        String string = "<script>alert('aa');</script>";
        if (string.contains("<script>")){
            string = string.replaceAll("<script>", "&lt;script&gt;");
        }
        if(string.contains("</script>")){
            string = string.replaceAll("</script>", "&lt;/script&gt;");
        }
        System.out.println(string);*/

   /*     Date date = new Date();
        System.out.println(date.getTime());*/

        String str1 = null;
        String str2 = null;
        String l1 = "11";
        String l2 = "11";
//        System.out.println(str1+l1);
//        System.out.println(str1+str2);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1);
        System.out.println(stringBuilder);

    }
}
