
public class PairData implements Comparable<PairData>{
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getData() {
		return data;
	}

	public void setData(Float data) {
		this.data = data;
	}

	private Float data;

	public PairData(String n, Float d){
		name = n;
		data=d;
	}

	@Override
	public int compareTo(PairData o) {
		int compare = this.getName().compareTo(o.getName());
		if(compare < 0)
		{
			return -1;
		}
		else 
		{
			if(compare>0){
				return 1;
			}
			else{
				return 0;
			}
		}
	}
	

}
