package li.lin.decoration;

/**
 * 描述：装饰者模式
 * 基础：抽象，封装，继承，多态
 * 原则：1.封装变化 2.针对接口编程，不针对实现编程 3.多用组合，少用继承 4.对扩展开放，对修改封闭
 * 模式：动态的将责任追加到对象上。扩展功能，提供有别于继承的另一种选择。
 * @author lilin
 * @since 2020/12/16 15:06
 */
public class TestMain {
	public static void main(String[] args) {
		Beverage beverage = new Milk();
		System.out.println(beverage.description()+beverage.cost());
		beverage = new Pearl(beverage);
		System.out.println(beverage.description()+beverage.cost());
		beverage = new Pudding(beverage);
		System.out.println(beverage.description()+beverage.cost());
	}
}
