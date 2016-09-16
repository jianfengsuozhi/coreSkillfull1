package com.proxy;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
/**
 * 模拟aop实现原理
 * 代理：代理.java(实现接口方法时(调用invoke))-->代理.class-->生成代理对象 ===接口,InvocationHanlder
 * InvocationHandler：接口方法 =====真实对象
 * @author Edward
 *
 */
public class SelfProxy {
    /** 
     *  
     * @param infce 被代理类的接口 
     * @param h 代理类 
     * @return 
     * @throws Exception 
     */  
    public static Object newProxyInstance(Class infce, SelfInvocationHandler h) throws Exception {   
        String methodStr = "";  
        String rt = "\r\n";  

        //利用反射得到infce的所有方法，并重新组装  
        Method[] methods = infce.getMethods();    
        for(Method m : methods) {  
            methodStr += "    @Override" + rt +   
                         "    public  "+m.getReturnType()+" " + m.getName() + "() {" + rt +  
                         "        try {" + rt +  
                         "        Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt +  
                         "        h.invoke(this, md);" + rt +  
                         "        }catch(Exception e) {e.printStackTrace();}" + rt +                          
                         "    }" + rt ;  
        }  

        //生成Java源文件  
        String srcCode =   
            "package com.proxy;" +  rt +  
            "import java.lang.reflect.Method;" + rt +  
            "public class $SelfProxy1 implements " + infce.getName() + "{" + rt +  
            "    public $SelfProxy1(SelfInvocationHandler h) {" + rt +  
            "        this.h = h;" + rt +  
            "    }" + rt +            
            "    com.proxy.SelfInvocationHandler h;" + rt +                           
            methodStr + rt +  
            "}";  
        String fileName =   
            "F:/gitWorkspace/coreSkillful/skillful/edward-skillful-provider/src/test/java/com/proxy/$SelfProxy1.java";  
        File f = new File(fileName);  
        FileWriter fw = new FileWriter(f);  
        fw.write(srcCode);  
        fw.flush();  
        fw.close();  

        //将Java文件编译成class文件  
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();  
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);  
        Iterable units = fileMgr.getJavaFileObjects(fileName);  
        CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);  
        t.call();  
        fileMgr.close();  

        //加载到内存，并实例化  
        URL[] urls = new URL[] {new URL("file:/" + "F:/gitWorkspace/coreSkillful/skillful/edward-skillful-provider/src/test/java/")};  
        URLClassLoader ul = new URLClassLoader(urls);  
        Class c = ul.loadClass("com.proxy.$SelfProxy1");  

        Constructor ctr = c.getConstructor(SelfInvocationHandler.class);  
        Object m = ctr.newInstance(h);  

        return m;  
    } 
    
    public static void main(String[] args) throws Exception {
    	Subject subject = new RealSubject();
    	//添加事务代理功能
		SelfTransactionHandler selfTransactionHandler = new SelfTransactionHandler(subject);
		Subject subjectProxy = (Subject)SelfProxy.newProxyInstance(Subject.class, selfTransactionHandler);
		subjectProxy.targetMethod();
	}
}
