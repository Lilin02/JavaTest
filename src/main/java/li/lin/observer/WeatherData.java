package li.lin.observer;

import lombok.Getter;

import java.util.Observable;

/**
 * 描述：天气通知类（主题）
 *
 * @author lilin
 * @since 2020/12/16 9:33
 */
@Getter
public class WeatherData extends Observable {
	private String name;
	private int age;
	private String job;

	public void setWeatherData(String name, int age, String job) {
		this.name = name;
		this.age = age;
		this.job = job;
		setChanged();
		notifyObservers();
	}
}
