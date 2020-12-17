package li.lin.strategy;

/**
 * 描述：不能叫
 *
 * @author lilin
 * @since 2020/12/16 15:47
 */
public class NoCall implements CallBehavior{
	@Override
	public String call() {
		return "不能叫";
	}
}
