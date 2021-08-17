package li.lin.jdkproxy;

/**
 * @author ：lin
 * @date ：Created in 2021/08/17 14:33
 * @description：
 * @modified By：
 * @version:
 */
public class Dog implements Animal{
    @Override
    public void say(String name) {
        System.out.println("dog say "+name);
    }

    @Override
    public Animal play(String name) {
        System.out.println("dog play "+name);
        return this;
    }
}
