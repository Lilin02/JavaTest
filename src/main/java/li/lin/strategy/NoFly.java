package li.lin.strategy;

/**
 * 描述：不能飞
 *
 * @author lilin
 * @since 2020/12/16 15:47
 */
public class NoFly implements FlyBehavior{
	@Override
	public String fly() {
		return "不能飞";
	}
}
