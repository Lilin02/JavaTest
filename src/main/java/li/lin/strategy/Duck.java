package li.lin.strategy;

import lombok.Setter;

/**
 * 描述：鸭子抽象类
 *
 * @author lilin
 * @since 2020/12/16 15:48
 */
@Setter
public abstract class Duck {

	protected CallBehavior callBehavior;

	protected FlyBehavior flyBehavior;

	public abstract String display();

	public void description(){
		System.out.println(display()+","+callBehavior.call()+","+flyBehavior.fly());
	}
}
