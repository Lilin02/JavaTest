package li.lin.strategy;

/**
 * 描述：绿头鸭,嘎嘎叫,快飞
 *
 * @author lilin
 * @since 2020/12/16 15:50
 */
public class Mallard extends Duck{

	public Mallard() {
		this.callBehavior = new GaCall();
		this.flyBehavior = new FastFly();;
	}

	@Override
	public String display() {
		return "绿头鸭";
	}
}
