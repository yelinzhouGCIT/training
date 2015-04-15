import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class CollectionDemo {

	private int numOfName;
	private int merit;



	public static void main(String[] args){
		String fileName="assign3.txt";
		File file=new File(fileName);
		HashMap<String, ArrayList<Float>> hm = new HashMap<String,ArrayList<Float>>();
		ArrayList<Float> score = new ArrayList<Float>();

		try{
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()){
				String data = inputStream.next();//get a whole line				
				String[] values = data.split(",");
				Float f = Float.parseFloat(values[1]);
				score.add(f);
				hm.put(values[0], score);
				//fileData.add(data);
				//hm.put(values[0], f);
				//System.out.println(values[0]+"***");
			}
			//System.out.println(fileData);
			System.out.println(hm.keySet());
			System.out.println(hm.values()	);

		}catch(FileNotFoundException e){
			e.getMessage();
		}
		
		
	}
}
