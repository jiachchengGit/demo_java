
package com.jcc.demo.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>Title: GreetDynamicProxy.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:2014年3月4日 下午5:00:45</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public class GreetDynamicProxy implements InvocationHandler {
    
    //be proxyed object
    private Object obj;
    
    private GreetDynamicProxy(Object o){
        this.obj = o;
    }
    /**
     * 获取动态代理对象
     * @author chenjiacheng
     * @creaetime 2014年3月4日 下午5:08:20
     * @param o
     * @return
     */
    public static Object newInstance(Object o){
        return Proxy.newProxyInstance(o.getClass().getClassLoader(),
            o.getClass().getInterfaces(),new GreetDynamicProxy(o));
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("Dynamic proxy before.....");
        try{
            //note the "obj" , not proxy
        result = method.invoke(obj, args);
        }catch(Exception e){
            System.out.println("Dynamic proxy invoke exception.....");
            e.printStackTrace();
        }
        System.out.println("Dynamic proxy after.....");
        return result;
    }

}
