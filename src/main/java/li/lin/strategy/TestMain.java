package li.lin.strategy;

/**
 * 描述：策略模式
 * 基础：抽象，封装，多态，继承
 * 原则：1.封装变化 2.多用组合，少用继承 3.针对接口编程，不针对实现编程
 * 模式：定义算法族，分别封装起来，让他们之间可以互相替换，此模式让算法的变化独立于使用算法的客户。（把叫和飞的行为分别封装起来）
 * @author lilin
 * @since 2020/12/16 15:54
 */
public class TestMain {
	public static void main(String[] args) {
		Mallard mallard = new Mallard();
		mallard.description();
		mallard.setCallBehavior(new ZhiCall());
		mallard.description();
		PlasticDuck plasticDuck = new PlasticDuck();
		plasticDuck.description();
		plasticDuck.setCallBehavior(new GaCall());
		plasticDuck.description();
	}
}
