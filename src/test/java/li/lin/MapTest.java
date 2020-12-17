package li.lin;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 测试sql
 *
 * @author lilin
 * @since 2020/4/21 16:48
 */
public class MapTest {

	@Test
	public void testMap(){
		ConcurrentHashMap map = new ConcurrentHashMap<>();
		AtomicReference<Thread> owner = new AtomicReference<Thread>();
		map.put("name","lilin");
		map.put("age","23");
		HashMap<String,String> hashMap = new HashMap<>(4);
		for(int i = 0;i<10;i++){
			hashMap.put("name_"+i,"lilin_"+i);
		}
		Collections.synchronizedMap(hashMap);
		Hashtable hashtable = new Hashtable();
		hashtable.put("aa","aa");
	}

	@Test
	public void test1(){

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable(){
				@Override
				public void run() {
					int i = 0;

				}
			});
		}
	}
}
