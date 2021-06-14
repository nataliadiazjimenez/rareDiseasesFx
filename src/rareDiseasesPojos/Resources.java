package rareDiseasesPojos;

public class Resources {
	private int idResources;
	private String name;
	private String finality;
	private String price;
	private String access;
	
	
	public Resources(int idResources, String name, String finality, String price, String access) {
		super();
		this.idResources = idResources;
		this.name = name;
		this.finality = finality;
		this.price = price;
		this.access = access;
	}
	
	public int getIdResources() {
		return idResources;
	}
	public void setIdResources(int idResources) {
		this.idResources = idResources;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFinality() {
		return finality;
	}
	public void setFinality(String finality) {
		this.finality = finality;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}

	@Override
	public String toString() {
		return "Resources [idResources=" + idResources + ", name=" + name + ", finality=" + finality + ", price="
				+ price + ", access=" + access + "]";
	}
	
	
}
