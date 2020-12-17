//package li.lin;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * 测试sql
// *
// * @author lilin
// * @since 2020/4/16 15:38
// */
//public class TestJdk8 {
//
//	public static void main(String args[]){
//
//		List<String> names1 = new ArrayList<String>();
//		names1.add("Google ");
//		names1.add("Runoob ");
//		names1.add("Taobao ");
//		names1.add("Baidu ");
//		names1.add("Sina ");
//
//		List<String> names2 = new ArrayList<String>();
//		names2.add("Google ");
//		names2.add("Runoob ");
//		names2.add("Taobao ");
//		names2.add("Baidu ");
//		names2.add("Sina ");
//
//		//names1.stream().forEach(s->System.out.println(s));
//
//		//names1.stream().filter(s->!s.equals("Google ")).forEach(s -> System.out.println(s));
//
////		List<String> names3 = names1.stream().filter(s->!s.equals("Google ")).collect(Collectors.toList());
////		names3.stream().forEach(s->System.out.println(s));
//
//		TestJdk8 tester = new TestJdk8();
//		System.out.println("使用 Java 7 语法: ");
//
//		tester.sortUsingJava7(names1);
//		System.out.println(names1);
//		System.out.println("使用 Java 8 语法: ");
//
//		tester.sortUsingJava8(names2);
//		System.out.println(names2);
//	}
//
//	/**
//	 * 使用 java 7 排序
// 	 */
//	private void sortUsingJava7(List<String> names){
//		Collections.sort(names, new Comparator<String>() {
//			@Override
//			public int compare(String s1, String s2) {
//				return s1.compareTo(s2);
//			}
//		});
//	}
//
//	/**
//	 * 使用 java 8 排序
//	 */
//	private void sortUsingJava8(List<String> names){
//		//names.stream().sorted((s1, s2) -> s2.compareTo(s1));
//	}
//
//}
//
//
