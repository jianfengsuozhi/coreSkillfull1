package com.stack;

/**
 * 表达式的计算：
 *   中缀表达式：对于人简单，对于计算机杂 前缀和后缀表达式对于人复杂，对于计算机简单
 *   1 讲中缀表达式转化为后缀表达式
 *   2 计算后缀表达式
 * Created by Edward on 2016/10/15.
 */
public class StackApplicatio03 {
    private final String digitPattern = "^[A-Za-z0-9]+$";
    private final String Space = " ";

    /**
     * 计算中缀表达式
     * @param middleExpr
     * @return
     */
    public double calculateMiddleExpr(String middleExpr){
        return this.calculateLateExpr(this.middleExprToLaterExpr(middleExpr));
    }
    /**
     * 中缀表达式转化为后缀表达式
     *  1 碰到数字直接输出
     *  2 操作符: 形象;若为(和空,操作符直接入栈,优先级大于(重于)栈顶,才能入栈,,若不大于,则先出栈,在比较
     */
     public String middleExprToLaterExpr(String middleExpr){
         Stack01<String> stack01 = new Stack01<>();
         String[] strings = middleExpr.split(" ");
         String lateExprission = "";
         for (String str : strings) {
            if(str.matches(digitPattern)){//如果是数字
                lateExprission = lateExprission + Space + str;
            }else {//如果是操作符
                if(stack01.isEmpty() || "(".equals(str)){//栈为空或栈顶元素是左括号
                    stack01.push(str);
                }else if(")".equals(str)){
                    while(!stack01.isEmpty() && !"(".equals(stack01.peek())){
                        lateExprission = lateExprission + Space + stack01.pop();
                    }
                    stack01.pop();
                }else if(!"(".equals(stack01.peek())&& comparePriority(str,stack01.peek()) >= 0){
                    lateExprission = lateExprission + Space + stack01.pop();
                    while(!stack01.isEmpty() && comparePriority(str,stack01.peek())>=0){
                        lateExprission = lateExprission + Space + stack01.pop();
                    }
                    stack01.push(str);
                }else{
                    stack01.push(str);
                }
            }
         }
         while(!stack01.isEmpty()){
             lateExprission = lateExprission + Space + stack01.pop();
         }
         return lateExprission;
     }

     private int comparePriority(String operator1,String operator2){
         switch (operator1){
             case "+":case "-":
                 return ("*".equals(operator2) || "/".equals(operator2) ? 1 : 0);
             case "*":case "/":
                 return ("+".equals(operator2) || "-".equals(operator2) ? -1 : 0);
         }
         throw new RuntimeException("操作符错误");
     }

    /**
     * 根据后缀表达式计算后缀值
     *   1 碰见数字：压入栈
     *   2 碰见操作符：取出两个,第二次取出 - 第一次取出
     */
    public double calculateLateExpr(String lateExpression){
        String[] split = lateExpression.trim().split(" ");
        Stack01<String> stack01 = new Stack01<>();
        for (String str : split) {
            if(str.matches(digitPattern)){
                stack01.push(str.trim());
            }else {
                double double1 = Double.parseDouble(stack01.pop());
                double double2 = Double.parseDouble(stack01.pop());
                double v = this.cal(double2,double1,str);
                stack01.push(String.valueOf(v));
            }
        }
        return Double.parseDouble(stack01.pop());
    }

    private double cal(double double1,double double2,String operate){
        switch (operate){
            case "+":
                return double1 + double2;
            case "-":
                return double1 - double2;
            case "*":
                return double1 * double2;
            case "/":
                if(double2 == 0){
                    throw new RuntimeException("除数不能为0");
                }
                return double1 / double2;
        }
        throw new RuntimeException("计算错误");
    }

    public static void main(String[] args) {
        //匹配数字
/*        String pattern = "^[0-9]*$";
        System.out.println("99".matches(pattern));
        System.out.println("aa".matches(pattern));*/

        StackApplicatio03 stackApplicatio03 = new StackApplicatio03();
        System.out.println(stackApplicatio03.calculateMiddleExpr("9 + ( 3 - 1 ) * 3 + 10 / 2"));
//        String s2 = stackApplicatio03.middleExprToLaterExpr("3 + ( 6 - 4 / 2 ) * 5");
    }
}
