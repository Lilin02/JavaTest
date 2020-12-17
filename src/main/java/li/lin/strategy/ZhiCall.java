package li.lin.strategy;

/**
 * 描述：吱吱叫
 *
 * @author lilin
 * @since 2020/12/16 15:44
 */
public class ZhiCall implements CallBehavior{
	@Override
	public String call() {
		return "吱吱叫";
	}
}
