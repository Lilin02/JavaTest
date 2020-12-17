package li.lin.strategy;

/**
 * 描述：塑料鸭，不会叫，不能飞
 *
 * @author lilin
 * @since 2020/12/16 16:13
 */
public class PlasticDuck extends Duck{

	public PlasticDuck() {
		this.callBehavior = new NoCall();
		this.flyBehavior = new NoFly();
	}

	@Override
	public String display() {
		return "塑料鸭";
	}
}
