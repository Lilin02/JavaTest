package li.lin;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void test1(){
        son s = new son();
        s.doSomething();
    }
}
    class parent{
        private static int a=1;
        private static int b;
        private int c=initc();
        static {
            b=1;
            System.out.println("1.父类静态代码块：赋值b成功");
            System.out.println("1.父类静态代码块：a的值"+a);
        }
        int initc(){
            System.out.println("3.父类成员变量赋值：---> c的值"+c);
            this.c=12;
            System.out.println("3.父类成员变量赋值：---> c的值"+c);
            return c;
        }
        public parent(){
            System.out.println("4.父类构造方式开始执行---> a:"+a+",b:"+b);
            System.out.println("4.父类构造方式开始执行---> c:"+c);
        }
        public void doSomething(){
            System.out.println("父类doSomething开始执行");
        }
    }

    class son extends parent{
        private static int sa=1;
        private static int sb;
        private int sc=initc2();
        static {
            sb=1;
            System.out.println("2.子类静态代码块：赋值sb成功");
            System.out.println("2.子类静态代码块：sa的值"+sa);
        }
        int initc2(){
            System.out.println("5.子类成员变量赋值--->：sc的值"+sc);
            this.sc=12;
            return sc;
        }
        public son(){
            System.out.println("6.子类构造方式开始执行---> sa:"+sa+",sb:"+sb);
            System.out.println("6.子类构造方式开始执行---> sc:"+sc);
        }
        public void doSomething(){
            super.doSomething();
            System.out.println("子类doSomething开始执行");
        }
    }

