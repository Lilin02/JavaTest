package li.lin.strategy;

/**
 * 描述：慢飞
 *
 * @author lilin
 * @since 2020/12/16 15:42
 */
public class SlowFly implements FlyBehavior{
	@Override
	public String fly() {
		return "慢飞";
	}
}
