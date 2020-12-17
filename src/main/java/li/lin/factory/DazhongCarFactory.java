package li.lin.factory;

/**
 * 描述：大众汽车工厂
 *
 * @author lilin
 * @since 2020/12/17 14:25
 */
public class DazhongCarFactory implements CarFactory{
	@Override
	public Car getCar() {
		return new DazhongCar();
	}
}
