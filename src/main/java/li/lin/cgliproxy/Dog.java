package li.lin.cgliproxy;

/**
 * @author ：lin
 * @date ：Created in 2021/08/17 16:01
 * @description：
 * @modified By：
 * @version:
 */
public class Dog {
    /**
     * final无法被代理
     * @param name
     */
    final public void run(String name) {
        System.out.println("狗"+name+"----run");
    }

    public void eat() {
        System.out.println("狗----eat");
    }
}
