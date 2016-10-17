package com.stack;

/**
 * 字符串回文：如noon level 正着读和反着读都一样
 */
public class QueueApplication02 {
    private Queue02<String> queue02 = new Queue02<String>();
    private Stack01<String> stack01 = new Stack01<String>();

    /**
     * 判断是否是回文字符串
     * @param str
     * @return
     */
    public boolean isWhoops(String str){
        String[] strings = StackApplicatio02.strToStrArray(str);
        stack01.pushAll(strings);
        queue02.pushAll(strings);

        for (int i=0; i<strings.length; i++){
            String stackPop = stack01.pop();
            String queuePop = queue02.pop();

            if(!stackPop.equals(queuePop)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        QueueApplication02 queueApplication02 = new QueueApplication02();
        System.out.println(queueApplication02.isWhoops("noon"));
        System.out.println(queueApplication02.isWhoops("noon1"));
    }
}
