package li.lin.decoration;

/**
 * 描述：红豆
 *
 * @author lilin
 * @since 2020/12/16 15:05
 */
public class RedBeans extends Beverage{

	Beverage beverage;

	public RedBeans(Beverage beverage){
		this.beverage = beverage;
	}

	@Override
	public String description() {
		return beverage.description()+",红豆";
	}

	@Override
	public double cost() {
		return beverage.cost()+3.5;
	}
}
