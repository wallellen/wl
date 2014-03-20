package bean;

/**
 * ElectrictDocumentAdress entity. @author MyEclipse Persistence Tools
 */

public class ElectrictDocumentAdress implements java.io.Serializable {

	// Fields

	private Integer id;
	private String addressUrl;
	private String documentType;
	private Integer documentId;
	private String time;
	private String electricDocumentName;

	// Constructors

	/** default constructor */
	public ElectrictDocumentAdress() {
	}

	/** full constructor */
	public ElectrictDocumentAdress(String addressUrl, String documentType,
			Integer documentId, String time, String electricDocumentName) {
		this.addressUrl = addressUrl;
		this.documentType = documentType;
		this.documentId = documentId;
		this.time = time;
		this.electricDocumentName = electricDocumentName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddressUrl() {
		return this.addressUrl;
	}

	public void setAddressUrl(String addressUrl) {
		this.addressUrl = addressUrl;
	}

	public String getDocumentType() {
		return this.documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public Integer getDocumentId() {
		return this.documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getElectricDocumentName() {
		return this.electricDocumentName;
	}

	public void setElectricDocumentName(String electricDocumentName) {
		this.electricDocumentName = electricDocumentName;
	}

}