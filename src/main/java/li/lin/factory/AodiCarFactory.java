package li.lin.factory;

/**
 * 描述：奥迪汽车工厂
 *
 * @author lilin
 * @since 2020/12/17 14:24
 */
public class AodiCarFactory implements CarFactory{
	@Override
	public Car getCar() {
		return new AodiCar();
	}
}
