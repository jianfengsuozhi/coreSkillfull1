package com.stack;

/**
 * 栈的应用：括号匹配问题
 * Created by Edward on 2016/10/15.
 */
public class StackApplicatio02 {
    /**
     * 括号匹配：
     * 两种情况：次序和个数不匹配
     * @param expression
     */
    public void bracketMatch(String expression){
        String[] strings = this.strToStrArray(expression);
        Stack01<String> stack01 = new Stack01<>();
        for (String str : strings) {
            if("(".equals(str) || "[".equals(str) || "{".equals(str)){//左括号入栈 使用栈先进后出
                stack01.push(str);
                continue;
            }else if(")".equals(str) && !stack01.isEmpty() && stack01.peek().equals("(")){
                stack01.pop();
                continue;
            }else if("]".equals(str) && !stack01.isEmpty() && stack01.peek().equals("[")){
                stack01.pop();
                continue;
            }else if("}".equals(str) && !stack01.isEmpty() && stack01.peek().equals("{")){
                stack01.pop();
                continue;
            }else if(")".equals(str) &&!stack01.isEmpty() && !stack01.peek().equals("(")
                    || "]".equals(str) &&!stack01.isEmpty() && !stack01.peek().equals("[")
                    || "}".equals(str) &&!stack01.isEmpty() && !stack01.peek().equals("{")){
                System.out.println("括号次序不对");
                return;
            }else if((")".equals(str) || "]".equals(str) || "}".equals(str)) && stack01.isEmpty()){
                System.out.println("右括号多于左括号");
                return;
            }
        }
        if(!stack01.isEmpty()){
            System.out.println("左括号多于右括号");
        }else {
            System.out.println("匹配正确");
        }
    }

    /**
     * 将字符串转换为数组
     * @param expression
     * @return
     */
    public static String[] strToStrArray(String expression){
        expression = expression.trim();
        //创建数组
        String[] strings = new String[expression.length()];
        //赋值
        for(int i=0; i<expression.length(); i++){
            strings[i] = expression.substring(i, i + 1);
        }
        return strings;
    }

    public static void main(String[] args) {
        StackApplicatio02 stackApplicatio02 = new StackApplicatio02();
        stackApplicatio02.bracketMatch("{[(a+b)-(c*e)]+{a+b}");
    }
}
