package li.lin;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 测试Optional
 *
 * @author lilin
 * @since 2020/8/12 15:27
 */
public class OptionalTest {
	public class User{
		private String name;
		private int age;

		public User getSon() {
			return son;
		}

		public void setSon(User son) {
			this.son = son;
		}

		private User son;

		public User(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public User(String name, int age,User son) {
			this.name = name;
			this.age = age;
			this.son = son;
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
	}
	List<User> userList = new ArrayList<>();

	/**
	 * 初始化数据
	 */
	@Before
	public void setUp() {
		userList.add(new User("li", 21,new User("son", 21)));
		userList.add(new User("lin", 22));
		userList.add(new User("liLin", 23));
		userList.add(new User("liu", 22));
	}

	@Test
	public void aaa(){
		String name = Optional.ofNullable(userList).map(users -> users.stream().max(Comparator.comparing(User::getAge))).map(user -> user.get().getName()).orElse(null);
		System.out.println(name);
		String name2 = Optional.ofNullable(userList).map(users -> users.stream().filter(user -> "liu".equals(user.getName())).collect(Collectors.toList())).map(liu->liu.get(0).getName()).orElse(null);
		System.out.println(name2);
	}
}
