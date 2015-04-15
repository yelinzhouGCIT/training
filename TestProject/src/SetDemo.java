import java.util.HashSet;
import java.util.Set;


public class SetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set mySet = new HashSet();
		String fruit1 = "pear",fruit2="banana",fruit3="tangerine",fruit4="strawberry",fruit5="blackberry";
		mySet.add(fruit1);
		mySet.add(fruit2);
		mySet.add(fruit3);
		mySet.add(fruit4);
		mySet.add(fruit5);
		System.out.println("mySet now contains:");
		System.out.println(mySet);
		System.out.println(mySet.size());
		mySet.remove(fruit4);
		mySet.remove(fruit5);
		System.out.println(mySet);
		mySet.removeAll(mySet);
		System.out.println(mySet.isEmpty());
	}

}
