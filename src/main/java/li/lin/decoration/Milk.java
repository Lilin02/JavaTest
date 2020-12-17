package li.lin.decoration;

/**
 * 描述：牛奶，最基本的。
 *
 * @author lilin
 * @since 2020/12/16 14:55
 */
public class Milk extends Beverage{

	@Override
	public String description() {
		return "牛奶";
	}

	@Override
	public double cost() {
		return 7;
	}
}
