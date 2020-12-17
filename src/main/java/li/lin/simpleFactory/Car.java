package li.lin.simpleFactory;

import lombok.Setter;

/**
 * 描述：汽车
 *
 * @author lilin
 * @since 2020/12/17 11:16
 */
@Setter
public class Car {

	protected String str;

	public void display(){
		System.out.println(this.str);
	}
}
