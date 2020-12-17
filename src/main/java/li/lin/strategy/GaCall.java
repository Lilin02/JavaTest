package li.lin.strategy;

/**
 * 描述：嘎嘎叫
 *
 * @author lilin
 * @since 2020/12/16 15:45
 */
public class GaCall implements CallBehavior{
	@Override
	public String call() {
		return "嘎嘎叫";
	}
}
