package li.lin.singleton;

/**
 * 描述：单例模式
 *
 * @author lilin
 * @since 2020/12/18 10:19
 */
public class Singleton {

	private static volatile Singleton singleton;

	private Singleton() {
	}

	public static Singleton getSingleton() {
		if (null == singleton) {
			synchronized (Singleton.class) {
				if (null == singleton) {
					try {
						//注释掉synchronized 将返回不同的对象
						Thread.sleep(1000);
					} catch (Exception e) {

					}
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}
