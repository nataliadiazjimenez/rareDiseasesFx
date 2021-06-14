package rareDiseasesPojos;

public class ResourceType {
	private Integer idType;
	private String type;
	private String description;
	
	
	public ResourceType(Integer idType, String type, String description) {
		super();
		this.idType = idType;
		this.type = type;
		this.description = description;
	}
	
	public Integer getIdType() {
		return idType;
	}
	public void setIdType(Integer idType) {
		this.idType = idType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ResourceType [idType=" + idType + ", type=" + type + ", description=" + description + "]";
	}
	
	
	
	
}
