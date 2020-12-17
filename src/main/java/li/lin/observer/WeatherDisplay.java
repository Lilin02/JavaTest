package li.lin.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 描述：监听最新数据并展示
 *
 * @author lilin
 * @since 2020/12/16 10:02
 */
public class WeatherDisplay implements Observer {
	private String name;
	private int age;
	private String job;

	public WeatherDisplay(Observable observable) {
		observable.addObserver(this);
	}

	public void removeObserver(Observable observable){
		observable.deleteObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof WeatherData){
			WeatherData weatherData = (WeatherData) o;
			this.name = weatherData.getName();
			this.age = weatherData.getAge();
			this.job = weatherData.getJob();
			display();
		}
	}

	public void display(){
		System.out.println("name:"+name+",age:"+age+",job:"+job);
	}
}
