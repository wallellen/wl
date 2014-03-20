package bean;

public class UnitDocument {
	protected Integer id;
	protected String unitIdentifyId;
	protected String unitName;
	protected String documentName;
	protected String retentionPeriod;
	protected String physicsAdress;
	protected String time;
	protected String zone;
	protected String sequenceNumber;
	protected String fileNumber;
	protected String author;
	protected String title;
	protected String pageNumber;
	protected String comments;
	protected Archive archive;
	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getFileNumber() {
		return fileNumber;
	}

	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public static String getDefaultTime() {
		return DEFAULT_TIME;
	}

	public static final String DEFAULT_TIME="д╛хо";
	// Property accessors

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getRetentionPeriod() {
		return this.retentionPeriod;
	}

	public void setRetentionPeriod(String retentionPeriod) {
		this.retentionPeriod = retentionPeriod;
	}

	public String getPhysicsAdress() {
		return this.physicsAdress;
	}

	public void setPhysicsAdress(String physicsAdress) {
		this.physicsAdress = physicsAdress;
	}

	public Archive getArchive() {
		return archive;
	}

	public void setArchive(Archive archive) {
		this.archive = archive;
	}

}
