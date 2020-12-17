package li.lin.decoration;

/**
 * 描述：珍珠
 *
 * @author lilin
 * @since 2020/12/16 15:01
 */
public class Pearl extends Beverage{

	Beverage beverage;

	public Pearl(Beverage beverage){
		this.beverage = beverage;
	}

	@Override
	public String description() {
		return beverage.description()+",珍珠";
	}

	@Override
	public double cost() {
		return beverage.cost()+3;
	}

}
