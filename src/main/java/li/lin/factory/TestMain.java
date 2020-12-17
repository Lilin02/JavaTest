package li.lin.factory;

/**
 * 描述：工厂方法模式
 * 模式：使用了多态，工厂方法克服了简单工厂违背的开放封闭原则的缺点，又保持了封装对象创建过程的优点。
 * 缺点：当需要增加一个新汽车benchiCar,只需要新建对应的benchiCarFactory来实现生产功能即可,对原有的代码没有任何影响，
 *       非常符合开放封闭原则，但是由于每增加一个产品，都需要新增对应的生产工厂，导致增加额外的开发工作量。
 * 疑惑：为何要多此一举建个对应的工厂？直接new一个需要的对象不是更方便？
 * 解答：1.解耦，把对象的创建和使用的过程分开。就是 ClassA 想调用 ClassB 的方法，B的实例化以及业务逻辑都交给工厂类，ClassA调用工厂类即可。
 *       2.可以降低代码重复，许多地方都要用到，那么就会有很多的重复代码。我们可以这些创建对象B的代码放到工厂里统一管理。既减少了重复代码，
 *       也方便以后对B的实例化以及业务逻辑的修改维护。
 *       参考：https://blog.csdn.net/qq_36186690/article/details/82945749
 * @author lilin
 * @since 2020/12/17 11:21
 */
public class TestMain {
	public static void main(String[] args) {
		CarFactory aodiCarFactory = new AodiCarFactory();
		aodiCarFactory.getCar().display();
	}
}
