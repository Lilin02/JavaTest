package li.lin.decoration;

/**
 * 描述：布丁
 *
 * @author lilin
 * @since 2020/12/16 15:04
 */
public class Pudding extends Beverage{

	Beverage beverage;

	public Pudding(Beverage beverage){
		this.beverage = beverage;
	}

	@Override
	public String description() {
		return beverage.description()+",布丁";
	}

	@Override
	public double cost() {
		return beverage.cost()+3.5;
	}
}
