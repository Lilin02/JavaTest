package li.lin.simpleFactory;

/**
 * 描述：简单工厂模式
 * 模式：利用静态方法根据输入参数生成对应的产品，隐藏了产品实例化的细节。
 * 缺点：当用户需要新增产品时，必须在工厂类的生产方法中增加对应的判断分支，所以简单工厂模式违背了开放封闭原则。
 * @author lilin
 * @since 2020/12/17 11:21
 */
public class TestMain {
	public static void main(String[] args) {
		Car car = new CarFactory().getCar("宝马汽车");
		car.display();
	}
}
