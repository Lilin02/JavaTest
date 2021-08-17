package li.lin.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @author ：lin
 * @date ：Created in 2021/08/17 14:31
 * @description：JDK动态代理
 * @modified By：
 * @version:
 */
public class ProxyTest {
    public static void main(String[] args) {
        //真实对象，即被代理的对象
        Dog dog = new Dog();
        DogInvocationHandler dogInvocationHandler = new DogInvocationHandler(dog);
        //获取代理对象
        Animal dogProxy = (Animal) Proxy.newProxyInstance(dog.getClass().getClassLoader(),dog.getClass().getInterfaces(),dogInvocationHandler);
        dogProxy.say("xiaoGu");
        Object object = dogProxy.play("game").play("work");
        System.out.println(object.getClass());
    }
}
