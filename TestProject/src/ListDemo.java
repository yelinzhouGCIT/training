import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> ls = new ArrayList<String>();
		ls.add("pear");
		ls.add("banana");
		ls.add("tangerine");
		ls.add("strawberry");
		ls.add("blackberry");
		Iterator<String> it = ls.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		ListIterator<String> li = ls.listIterator(ls.size());
		// boolean b = li.hasPrevious();
		// System.out.println(b);
		while (li.hasPrevious()) {
			System.out.println(li.previous());
		}

		System.out.println("haha");
		for(int i=0;i<ls.size();i++){
			String s= ls.get(i);
			if(s.equals("tangerine")){
				ls.add(i+1,"banana2");
				break;
				}
		}

		System.out.println(ls);
	}

	// List<String> li = new ArrayList<String>();
	// ListIterator<String> litr = null;
	// li.add("pear");
	// li.add("banana");
	// li.add("tangerine");
	// li.add("strawberry");
	// li.add("blackberry");
	// litr=li.listIterator();
	// System.out.println("Elements in forward directiton");
	//
	// while(litr.hasNext()){
	// System.out.println(litr.next());
	// }
	//
	// System.out.println("Elements in backward directiton");
	// while(litr.hasPrevious()){
	// System.out.println(litr.previous());
	// }
	// }
}
