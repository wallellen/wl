package bean;

/**
 * Document entity. @author MyEclipse Persistence Tools
 */

public class Document implements java.io.Serializable {

	// Fields

	private Integer id;
	private Archive archive;
	private int sequenceNumber;
	private int packageNumber;
	private String fileNumber;
	private String author;
	private String title;
	private String pageNumber;
	private String retentionPeriod;
	private String time;
	private String sqcurityLevel;
	private String comments;

	private String frameNumber;
	public String getFrameNumber() {
		return frameNumber;
	}

	public void setFrameNumber(String frameNumber) {
		this.frameNumber = frameNumber;
	}

	private String type;
	private String kind;
	// Constructors

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	/** default constructor */
	public Document() {
	}

	/** full constructor */
	public Document(Archive archive, int sequenceNumber, String fileNumber,
			String author, String title, String pageNumber,
			String retentionPeriod, String time, String sqcurityLevel,
			String comments,String type,String kind) {
		this.archive = archive;
		this.sequenceNumber = sequenceNumber;
		this.fileNumber = fileNumber;
		this.author = author;
		this.title = title;
		this.pageNumber = pageNumber;
		this.retentionPeriod = retentionPeriod;
		this.time = time;
		this.sqcurityLevel = sqcurityLevel;
		this.comments = comments;
		this.type = type;
		this.kind = kind;
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

	public int getSequenceNumber() {
		return this.sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
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
		return pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
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

	public String getSqcurityLevel() {
		return this.sqcurityLevel;
	}

	public void setSqcurityLevel(String sqcurityLevel) {
		this.sqcurityLevel = sqcurityLevel;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getPackageNumber() {
		return packageNumber;
	}

	public void setPackageNumber(int packageNumber) {
		this.packageNumber = packageNumber;
	}

}