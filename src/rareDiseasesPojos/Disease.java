package rareDiseasesPojos;

//import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleStringProperty;

public class Disease {
	/*
	 * private SimpleIntegerProperty idDisease; private SimpleStringProperty
	 * diseaseName; private SimpleStringProperty prevalence; private
	 * SimpleStringProperty affectedSystem; private SimpleStringProperty treatment;
	 * private SimpleStringProperty diagnosis; private SimpleStringProperty
	 * description;
	 * 
	 * 
	 * public Disease(Integer idDisease, String diseaseName, String prevalence,
	 * String affectedSystem, String treatment, String diagnosis, String
	 * description){ this.idDisease = new SimpleIntegerProperty(idDisease);
	 * this.diseaseName = new SimpleStringProperty(diseaseName); this.prevalence =
	 * new SimpleStringProperty(prevalence); this.affectedSystem = new
	 * SimpleStringProperty(affectedSystem); this.treatment = new
	 * SimpleStringProperty(treatment); this.diagnosis = new
	 * SimpleStringProperty(diagnosis); this.description = new
	 * SimpleStringProperty(description);
	 * 
	 * }
	 */
	private Integer idDisease;
	private String diseaseName;
	private String prevalence;
	private String affectedSystem;
	private String treatment;
	private String diagnosis;
	private String description;

	public Disease(Integer idDisease, String diseaseName, String prevalence, String affectedSystem, String treatment,
			String diagnosis, String description) {
		super();
		this.idDisease = idDisease;
		this.diseaseName = diseaseName;
		this.prevalence = prevalence;
		this.affectedSystem = affectedSystem;
		this.treatment = treatment;
		this.diagnosis = diagnosis;
		this.description = description;
	}
	
	public Disease(String diseaseName, String prevalence, String affectedSystem, String treatment,
			String diagnosis, String description) {
		super();
		this.diseaseName = diseaseName;
		this.prevalence = prevalence;
		this.affectedSystem = affectedSystem;
		this.treatment = treatment;
		this.diagnosis = diagnosis;
		this.description = description;
	}
	/*
	 * private String description; public void setIdDisease(SimpleIntegerProperty
	 * idDisease) { this.idDisease = idDisease; } public void
	 * setDiseaseName(SimpleStringProperty diseaseName) { this.diseaseName =
	 * diseaseName; } public void setPrevalence(SimpleStringProperty prevalence) {
	 * this.prevalence = prevalence; } public void
	 * setAffectedSystem(SimpleStringProperty affectedSystem) { this.affectedSystem
	 * = affectedSystem; } public void setTreatment(SimpleStringProperty treatment)
	 * { this.treatment = treatment; } public void setDiagnosis(SimpleStringProperty
	 * diagnosis) { this.diagnosis = diagnosis; } public void
	 * setDescription(SimpleStringProperty description) { this.description =
	 * description; }
	 */
	public Integer getIdDisease() {
		return idDisease;
	}

	public void setIdDisease(Integer idDisease) {
		this.idDisease = idDisease;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getPrevalence() {
		return prevalence;
	}

	public void setPrevalence(String prevalence) {
		this.prevalence = prevalence;
	}

	public String getAffectedSystem() {
		return affectedSystem;
	}

	public void setAffectedSystem(String affectedSystem) {
		this.affectedSystem = affectedSystem;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Disease [idDisease=" + idDisease + ", diseaseName=" + diseaseName + ", prevalence=" + prevalence
				+ ", affectedSystem=" + affectedSystem + ", treatment=" + treatment + ", diagnosis=" + diagnosis
				+ ", description=" + description + "]";
	}

}
