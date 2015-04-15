import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class ReadFile {

	public static void main(String[] args){
		String fileName="assign3.txt";
		File file=new File(fileName);
		ArrayList<PairData> pdls = new ArrayList<PairData>();
		HashMap<String,Float> hm = new HashMap<String,Float>();
		try{
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()){
				String data = inputStream.next();//get a whole line				
				String[] values = data.split(",");
				Float f = Float.parseFloat(values[1]);
				PairData pd = new PairData(values[0],f);
				pdls.add(pd);
			}
			Iterator<PairData> it = pdls.iterator();
			Set<String> nameSet = new HashSet<String>();
			while(it.hasNext()){
				String name = it.next().getName();
				nameSet.add(name);
			}
			
			for(int i =0;i<pdls.size();i++)
			{
				for(int j=0;j<pdls.size();j++){
					if(pdls.get(i).getName().equals(pdls.get(j).getName())){
						hm.put(pdls.get(i).getName(),pdls.get(i).getData());
					}
				}
			}
			System.out.println(hm.values());
			//System.out.println(nameSet);
		}catch(FileNotFoundException e){
			e.getMessage();
		}
	}
}
