package li.lin.factory;

/**
 * 描述：宝马汽车工厂
 *
 * @author lilin
 * @since 2020/12/17 14:25
 */
public class BaomaCarFactory implements CarFactory{
	@Override
	public Car getCar() {
		return new BaomaCar();
	}
}
