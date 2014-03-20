package bean;

/**
 * UnitPensionInsuranceDocument entity. @author MyEclipse Persistence Tools
 */

public class UnitPensionInsuranceDocument extends UnitDocument implements java.io.Serializable {

	// Fields

	private Integer id;
	private Archive archive;
	private String unitIdentifyId;
	private String unitName;
	private String documentName;
	private String physicsAdress;
	private String retentionPeriod;
	private String time;
	private String zone;
	private String sequenceNumber;
	private String fileNumber;
	private String author;
	private String title;
	private String pageNumber;
	private String comments;

	// Constructors

	/** default constructor */
	public UnitPensionInsuranceDocument() {
	}

	/** full constructor */
	public UnitPensionInsuranceDocument(Archive archive, String unitIdentifyId,
			String unitName, String documentName, String physicsAdress,
			String retentionPeriod, String time, String zone,
			String sequenceNumber, String fileNumber, String author,
			String title, String pageNumber, String comments) {
		this.archive = archive;
		this.unitIdentifyId = unitIdentifyId;
		this.unitName = unitName;
		this.documentName = documentName;
		this.physicsAdress = physicsAdress;
		this.retentionPeriod = retentionPeriod;
		this.time = time;
		this.zone = zone;
		this.sequenceNumber = sequenceNumber;
		this.fileNumber = fileNumber;
		this.author = author;
		this.title = title;
		this.pageNumber = pageNumber;
		this.comments = comments;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Archive getArchive() {
		return this.archive;
	}

	public void setArchive(Archive archive) {
		this.archive = archive;
	}

	public String getUnitIdentifyId() {
		return this.unitIdentifyId;
	}

	public void setUnitIdentifyId(String unitIdentifyId) {
		this.unitIdentifyId = unitIdentifyId;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getDocumentName() {
		return this.documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getPhysicsAdress() {
		return this.physicsAdress;
	}

	public void setPhysicsAdress(String physicsAdress) {
		this.physicsAdress = physicsAdress;
	}

	public String getRetentionPeriod() {
		return this.retentionPeriod;
	}

	public void setRetentionPeriod(String retentionPeriod) {
		this.retentionPeriod = retentionPeriod;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getZone() {
		return this.zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getSequenceNumber() {
		return this.sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getFileNumber() {
		return this.fileNumber;
	}

	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPageNumber() {
		return this.pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}