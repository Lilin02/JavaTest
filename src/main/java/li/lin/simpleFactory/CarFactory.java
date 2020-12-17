package li.lin.simpleFactory;

/**
 * 描述：汽车工厂
 *
 * @author lilin
 * @since 2020/12/17 11:13
 */
public class CarFactory {
	public Car getCar(String type){
		if("奥迪汽车".equals(type)){
			return new AodiCar();
		}else if("宝马汽车".equals(type)){
			return new BaomaCar();
		}else{
			return new DazhongCar();
		}
	}
}
