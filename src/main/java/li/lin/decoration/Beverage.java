package li.lin.decoration;

/**
 * 描述：饮料基类,装饰者模式
 *
 * @author lilin
 * @since 2020/12/16 14:50
 */
public abstract class Beverage {
	private String description = "null";
	public String description(){
		return description;
	}
	public abstract double cost();
}
