package li.lin.observer;

/**
 * 描述：观察者模式
 * 基础：抽象，继承
 * 原则：为交互对象之间的松耦合设计而努力
 * 模式：在对象之间定义一对多的依赖，这样一来，当一个对象改变状态，依赖它的对象都会收到通知并自动更新。
 * @author lilin
 * @since 2020/12/16 10:51
 */
public class TestMain {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		WeatherDisplay weatherDisplay = new WeatherDisplay(weatherData);
		weatherData.setWeatherData("li",21,"大一学生");
		weatherData.setWeatherData("li",22,"大二学生");
		weatherData.setWeatherData("li",23,"大三学生");
		weatherData.setWeatherData("li",24,"java实习生");
		weatherDisplay.removeObserver(weatherData);
		weatherData.setWeatherData("li",25,"java开发");
	}
}
