package li.lin.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 描述：单例模式
 * 原则：1.私有的构造方法 2.静态的获取实例对象方法（由于第一点无法new对象，所以必须static，通过类名.方法调用，即私有对象变量也必须是static）
 *       3.多线程安全，锁代码块而非整个获取实例对象方法，volatile修饰私有对象变量
 * 模式：确保一个类只有一个实例，并提供全局访问点。
 * @author lilin
 * @since 2020/12/18 10:24
 */
public class TestMain{
	private static final int NUM = 10;

	private static CountDownLatch cld = new CountDownLatch(NUM);

	public static void main(String[] args) {
		for (int i = 0; i <NUM; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						cld.await();//将线程阻塞在此，等待所有线程都调用完start()方法，一起执行
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis()+ "，" + Singleton.getSingleton());
				}
			}).start();
			cld.countDown();
		}
		System.out.println("finish");
	}

}
