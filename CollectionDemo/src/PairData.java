
public class PairData {
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

}
