package li.lin;

import com.sun.deploy.util.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * jdk8的lambda表达式简单使用练习
 *
 * @author lilin
 * @since 2020/4/16 15:38
 */
public class TestJdk8 {
	/**
	 * user类
	 */
	class User{
		private String name;
		private int age;

		public User(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "User{" +
					"name='" + name + '\'' +
					", age=" + age +
					'}';
		}
	}

	List<User> userList = new ArrayList<>();
	List<Map<String,Object>> mapList = new ArrayList<>();
	Map<String,Object> map = new HashMap<>();

	/**
	 * 初始化数据
	 */
	@Before
	public void setUp(){
		userList.add(new User("li",21));
		userList.add(new User("lin",22));
		userList.add(new User("liLin",23));
		userList.add(new User("liu",22));
		for(int i=0;i<5;i++){
			Map<String,Object> map = new HashMap<>();
			map.put("name","li_"+i);
			map.put("age",20+i);
			mapList.add(map);
		}
		map.put("A", 10);
		map.put("B", 20);
		map.put("C", 30);
		map.put("D", 40);
		map.put("E", 50);
		map.put("F", 60);
	}

	/**
	 * list转map
	 */
	@Test
	public void ListTest1(){
		Map<String,Integer> map = userList.stream().collect(Collectors.toMap(user->user.getName(),user->user.getAge()));
		//lin-22  liLin-23  liu-22  li-21
		map.forEach((k,v)->System.out.print(k+"-"+v+" "));
	}

	/**
	 * 提取需要的信息name成一个新list
	 */
	@Test
	public void ListTest2(){
		List<String> nameList = userList.stream().map(user->user.getName()).collect(Collectors.toList());
		//li lin liLin liu
		nameList.stream().forEach(name->System.out.print(name+" "));
	}

	/**
	 * 提取需要的信息age成一个新set
	 * set自动去重
	 */
	@Test
	public void ListTest3(){
		Set<Integer> ageList = userList.stream().map(user->user.getAge()).collect(Collectors.toSet());
		//21 22 23
		ageList.stream().forEach(age->System.out.print(age+" "));
	}

	/**
	 * 根据age进行排序
	 */
	@Test
	public void ListTest4(){
		//age降序
		List<User> aseUserList = userList.stream().sorted((user1, user2) -> Integer.compare(user2.getAge(), user1.getAge())).collect(Collectors.toList());
		//User{name='liLin', age=23} User{name='lin', age=22} User{name='liu', age=22} User{name='li', age=21}
		aseUserList.stream().forEach(user -> System.out.print(user.toString() + " "));
		System.out.println();
		//排序操作原list未改变
		//User{name='li', age=21} User{name='lin', age=22} User{name='liLin', age=23} User{name='liu', age=22}
		userList.stream().forEach(user -> System.out.print(user.toString() + " "));
		System.out.println();
		//age升序，代码可以更简洁
		List<User> descUserList = userList.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
		//User{name='li', age=21} User{name='lin', age=22} User{name='liu', age=22} User{name='liLin', age=23}
		descUserList.stream().forEach(user->System.out.print(user.toString()+" "));
	}

	/**
	 * 获取age最大的user
	 */
	@Test
	public void ListTest5(){
		//Optional<User> user = userList.stream().max((user1,user2)->Integer.compare(user1.getAge(),user2.getAge()));
		Optional<User> user = userList.stream().max(Comparator.comparing(User::getAge));
		//User{name='liLin', age=23}
		System.out.print(user.get());
	}

	/**
	 * 去掉list里的指定数据
	 */
	@Test
	public void ListTest6(){
		List<User> list = userList.stream().filter(user1 -> !"lin".equals(user1.getName())).collect(Collectors.toList());
		//User{name='li', age=21} User{name='liLin', age=23} User{name='liu', age=22}
		list.stream().forEach(user->System.out.print(user.toString()+" "));
		System.out.println();
		//forEach可以改变原list，且原list并未去除指定数据
		userList.stream().forEach(u->u.setAge(33));
		userList.stream().forEach(user->System.out.print(user.toString()+" "));
	}

	/**
	 * 统计list里的年龄22岁的数量
	 */
	@Test
	public void ListTest7(){
		Long num = userList.stream().filter(user1 -> user1.getAge()==22).count();
		//2
		System.out.print(num);
	}

	/**
	 * 获取list里的年龄的平均值
	 */
	@Test
	public void ListTest8(){
		OptionalDouble num = userList.stream().mapToInt(user->user.getAge()).average();
		//22.0
		System.out.print(num.getAsDouble());
	}

	/**
	 * 获取list里name不为li的年龄的总值
	 */
	@Test
	public void ListTest9(){
		int num = userList.stream().filter(user -> !"li".equals(user.getName())).mapToInt(user->user.getAge()).sum();
		//67
		System.out.print(num);
	}

	/**
	 * 获取mapList里的name作为一个新list
	 */
	@Test
	public void ListTest10(){
		List<String> nameList = mapList.stream().map(map->(String)map.get("name")).collect(Collectors.toList());
		//li_0 li_1 li_2 li_3 li_4
		nameList.forEach(name->System.out.print(name+" "));
	}

	/**
	 * 获取mapList里的age总数
	 */
	@Test
	public void ListTest11(){
		int age = mapList.stream().mapToInt(map->(Integer)map.get("age")).sum();
		//110
		System.out.print(age+" ");
	}

	/**
	 * 获取mapList里的age最大值
	 */
	@Test
	public void ListTest12(){
		Optional<Map<String,Object>> age = mapList.stream().max((map1,map2)->Integer.compare((Integer) map1.get("age"),(Integer) map2.get("age")));
		//24
		System.out.print(age.get().get("age")+" ");
	}

	/**
	 * 打印出值大于30的map
	 */
	@Test
	public void ListTest13(){
		Map<String,Object> map1 = map.entrySet().stream().filter(map2->(Integer)map2.getValue()>30).collect(Collectors.toMap(map3->map3.getKey(),map4->map4.getValue()));
		//D-40 E-50 F-60
		map1.forEach((k,v)->System.out.print(k+"-"+v+" "));
	}

	/**
	 * 将list集合的数据按年龄分类
	 */
	@Test
	public void ListTest14(){
		Map<Integer,List<User>> groupMap = userList.stream().collect(Collectors.groupingBy(user -> user.getAge()));
		//{21=[User{name='li', age=21}], 22=[User{name='lin', age=22}, User{name='liu', age=22}], 23=[User{name='liLin', age=23}]}
		System.out.print(groupMap);
	}

	/**
	 * 将list集合22岁的数据加1
	 */
	@Test
	public void ListTest15(){
		 userList.forEach(user -> { if(user.getAge()==22){
		 	user.setAge(user.getAge()+1);
		 }});
		 userList.forEach(user -> System.out.print(user.getName()+"-"+user.getAge()+" "));
		 System.out.print(2<<9);
	}

	private final AtomicReference<Thread> owner = new AtomicReference<Thread>();

	@Test
	public void ListTest16(){
		Map<String,Integer> map = new HashMap<>();
		map.put("li",111);
		map.put("aa",222);
		List<User> userList1 = userList.stream().map(user -> {
			user.setAge(null==map.get(user.getName())?map.get("aa"):map.get(user.getName()));
			return user;
		}).collect(Collectors.toList());
		userList1.forEach(user -> System.out.print(user.getName()+"-"+user.getAge()+" "));
	}

	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	public void ListTest18(){
		System.out.println("dev-1提交");
	}
}


