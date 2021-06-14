package rareDiseasesPojos;

public class Url {
	private Integer id;
	private String language;
	private String address;
	private String location;
	
	
	public Url(Integer id, String language, String address, String location) {
		super();
		this.id = id;
		this.language = language;
		this.address = address;
		this.location = location;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public String toString() {
		return "Url [id=" + id + ", language=" + language + ", address=" + address + ", location=" + location + "]";
	}
	
	
	

}
