package li.lin.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ：lin
 * @date ：Created in 2021/08/17 14:37
 * @description：
 * @modified By：
 * @version:
 */
public class DogInvocationHandler implements InvocationHandler {

    /**
     *被代理的对象
     */
    private Dog dog;

    DogInvocationHandler(Dog dog){
        this.dog=dog;
    }

    /**
     *
     * @param proxy
     * 参数proxy的作用：
     * 1. 可以使用反射获取代理对象的信息（也就是proxy.getClass().getName()）。
     * 2. 可以将代理对象返回以进行连续调用，这就是proxy存在的目的。因为this并不是代理对象.
     * 绝大多数情况没什么卵用...
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始代理......");
        if("play".equals(method.getName())) {
            //调用真实对象的逻辑
            method.invoke(dog, args);
            System.out.println("play结束代理......");
            return proxy;
        }else{
            method.invoke(dog, args);
            System.out.println("say结束代理......");
            return this;
        }
    }
}
