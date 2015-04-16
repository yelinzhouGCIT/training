import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class ReadFile {

	public static void main(String[] args) {
		String fileName = "assign3.txt";
		File file = new File(fileName);
		ArrayList<PairData> pdls = new ArrayList<PairData>();
		HashMap<String, Float> hm = new HashMap<String, Float>();
		try {
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) {
				String data = inputStream.next();// get a whole line
				String[] values = data.split(",");
				Float f = Float.parseFloat(values[1]);
				PairData pd = new PairData(values[0], f);
				pdls.add(pd);
			}
			Collections.sort(pdls);
			// Iterator<PairData> it = pdls.iterator();
			// while(it.hasNext()){
			// PairData tmpPd = it.next();
			// System.out.println(tmpPd.getName()+tmpPd.getData());
			// }

			// Set<String> nameSet = new HashSet<String>();
			// while(it.hasNext()){
			// String name = it.next().getName();
			// nameSet.add(name);
			// }

			for (int i = 0; i < pdls.size(); i++) {
				for (int j = i + 1; j < pdls.size(); j++) {
					String iName = pdls.get(i).getName();
					String jName = pdls.get(j).getName();
					if (iName.equals(jName)) {
						// System.out.println(iName + "     J "+ jName);
						Float tmp = pdls.get(i).getData();
						tmp = tmp + pdls.get(j).getData();
						pdls.get(i).setData(tmp);
						// System.out.println(tmp);
						pdls.get(j).setData((float) 0);
					}
				}
			}

			for (int i = 0; i < pdls.size(); i++) {
				for (int j = 0; j < pdls.size(); j++) {
					String iName = pdls.get(i).getName();
					String jName = pdls.get(j).getName();
					if (iName.equals(jName) && (pdls.get(j).getData() == 0)) {
						pdls.remove(j);
					}
				}
			}
			Iterator<PairData> it = pdls.iterator();
			while (it.hasNext()) {
				PairData tmpPd = it.next();
				System.out.println(tmpPd.getName() + tmpPd.getData());
			}

		} catch (FileNotFoundException e) {
			e.getMessage();
		}
	}
}
