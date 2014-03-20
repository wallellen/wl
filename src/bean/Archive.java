package bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Archive entity. @author MyEclipse Persistence Tools
 */

public class Archive implements java.io.Serializable {

	// Fields

	private Integer id;
	private String archiveNumber;
	private String archiveTitle;
	private Set personalBirthInsuranceDocuments = new HashSet(0);
	private Set personalSocialInsuranceAuditDocuments = new HashSet(0);
	private Set personalSocialInsuranceAuditDocuments_1 = new HashSet(0);
	private Set personalInjuryInsuranceDocuments = new HashSet(0);
	private Set personalInjuryInsuranceDocuments_1 = new HashSet(0);
	private Set personalSocialInsuranceStatisticsDocuments = new HashSet(0);
	private Set personalUnemployeeInsuranceDocuments = new HashSet(0);
	private Set unitMedicalInsuranceDocuments = new HashSet(0);
	private Set unitUnemployeeInsuranceDocuments = new HashSet(0);
	private Set unitInjeryInsuranceDocuments = new HashSet(0);
	private Set personalSocialInsuranceCollectionDocuments = new HashSet(0);
	private Set unitSocialInsuranceStatisticsDocuments = new HashSet(0);
	private Set personalMedicalInsuranceDocuments = new HashSet(0);
	private Set unitSocialInsuranceManagerDocuments = new HashSet(0);
	private Set unitSocialInsuranceAuditDocuments = new HashSet(0);
	private Set personalSocialInsuranceStatisticsDocuments_1 = new HashSet(0);
	private Set unitPensionInsuranceDocuments = new HashSet(0);
	private Set personalSocialInsuranceDocuments = new HashSet(0);
	private Set unitBirthInsuranceDocuments = new HashSet(0);
	private Set personalBirthInsuranceDocuments_1 = new HashSet(0);
	private Set personalSocialInsuranceDocuments_1 = new HashSet(0);
	private Set unitSocialInsuranceCollectionDocuments = new HashSet(0);
	private Set unitSocialInsuranceCollectionDocuments_1 = new HashSet(0);
	private Set unitUnemployeeInsuranceDocuments_1 = new HashSet(0);
	private Set unitSocialInsuranceAuditDocuments_1 = new HashSet(0);
	private Set unitBirthInsuranceDocuments_1 = new HashSet(0);
	private Set personalPensionInsuranceDocuments = new HashSet(0);
	private Set documents = new HashSet(0);
	private Set personalUnemployeeInsuranceDocuments_1 = new HashSet(0);
	private Set unitSocialInsuranceStatisticsDocuments_1 = new HashSet(0);
	private Set unitSocialInsuranceManagerDocuments_1 = new HashSet(0);
	private Set personalMedicalInsuranceDocuments_1 = new HashSet(0);
	private Set personalPensionInsuranceDocuments_1 = new HashSet(0);
	private Set unitPensionInsuranceDocuments_1 = new HashSet(0);
	private Set personalSocialInsuranceCollectionDocuments_1 = new HashSet(0);
	private Set unitMedicalInsuranceDocuments_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Archive() {
	}

	/** full constructor */
	public Archive(String archiveNumber, String archiveTitle,
			Set personalBirthInsuranceDocuments,
			Set personalSocialInsuranceAuditDocuments,
			Set personalSocialInsuranceAuditDocuments_1,
			Set personalInjuryInsuranceDocuments,
			Set personalInjuryInsuranceDocuments_1,
			Set personalSocialInsuranceStatisticsDocuments,
			Set personalUnemployeeInsuranceDocuments,
			Set unitMedicalInsuranceDocuments,
			Set unitUnemployeeInsuranceDocuments,
			Set unitInjeryInsuranceDocuments,
			Set personalSocialInsuranceCollectionDocuments,
			Set unitSocialInsuranceStatisticsDocuments,
			Set personalMedicalInsuranceDocuments,
			Set unitSocialInsuranceManagerDocuments,
			Set unitSocialInsuranceAuditDocuments,
			Set personalSocialInsuranceStatisticsDocuments_1,
			Set unitPensionInsuranceDocuments,
			Set personalSocialInsuranceDocuments,
			Set unitBirthInsuranceDocuments,
			Set personalBirthInsuranceDocuments_1,
			Set personalSocialInsuranceDocuments_1,
			Set unitSocialInsuranceCollectionDocuments,
			Set unitSocialInsuranceCollectionDocuments_1,
			Set unitUnemployeeInsuranceDocuments_1,
			Set unitSocialInsuranceAuditDocuments_1,
			Set unitBirthInsuranceDocuments_1,
			Set personalPensionInsuranceDocuments, Set documents,
			Set personalUnemployeeInsuranceDocuments_1,
			Set unitSocialInsuranceStatisticsDocuments_1,
			Set unitSocialInsuranceManagerDocuments_1,
			Set personalMedicalInsuranceDocuments_1,
			Set personalPensionInsuranceDocuments_1,
			Set unitPensionInsuranceDocuments_1,
			Set personalSocialInsuranceCollectionDocuments_1,
			Set unitMedicalInsuranceDocuments_1) {
		this.archiveNumber = archiveNumber;
		this.archiveTitle = archiveTitle;
		this.personalBirthInsuranceDocuments = personalBirthInsuranceDocuments;
		this.personalSocialInsuranceAuditDocuments = personalSocialInsuranceAuditDocuments;
		this.personalSocialInsuranceAuditDocuments_1 = personalSocialInsuranceAuditDocuments_1;
		this.personalInjuryInsuranceDocuments = personalInjuryInsuranceDocuments;
		this.personalInjuryInsuranceDocuments_1 = personalInjuryInsuranceDocuments_1;
		this.personalSocialInsuranceStatisticsDocuments = personalSocialInsuranceStatisticsDocuments;
		this.personalUnemployeeInsuranceDocuments = personalUnemployeeInsuranceDocuments;
		this.unitMedicalInsuranceDocuments = unitMedicalInsuranceDocuments;
		this.unitUnemployeeInsuranceDocuments = unitUnemployeeInsuranceDocuments;
		this.unitInjeryInsuranceDocuments = unitInjeryInsuranceDocuments;
		this.personalSocialInsuranceCollectionDocuments = personalSocialInsuranceCollectionDocuments;
		this.unitSocialInsuranceStatisticsDocuments = unitSocialInsuranceStatisticsDocuments;
		this.personalMedicalInsuranceDocuments = personalMedicalInsuranceDocuments;
		this.unitSocialInsuranceManagerDocuments = unitSocialInsuranceManagerDocuments;
		this.unitSocialInsuranceAuditDocuments = unitSocialInsuranceAuditDocuments;
		this.personalSocialInsuranceStatisticsDocuments_1 = personalSocialInsuranceStatisticsDocuments_1;
		this.unitPensionInsuranceDocuments = unitPensionInsuranceDocuments;
		this.personalSocialInsuranceDocuments = personalSocialInsuranceDocuments;
		this.unitBirthInsuranceDocuments = unitBirthInsuranceDocuments;
		this.personalBirthInsuranceDocuments_1 = personalBirthInsuranceDocuments_1;
		this.personalSocialInsuranceDocuments_1 = personalSocialInsuranceDocuments_1;
		this.unitSocialInsuranceCollectionDocuments = unitSocialInsuranceCollectionDocuments;
		this.unitSocialInsuranceCollectionDocuments_1 = unitSocialInsuranceCollectionDocuments_1;
		this.unitUnemployeeInsuranceDocuments_1 = unitUnemployeeInsuranceDocuments_1;
		this.unitSocialInsuranceAuditDocuments_1 = unitSocialInsuranceAuditDocuments_1;
		this.unitBirthInsuranceDocuments_1 = unitBirthInsuranceDocuments_1;
		this.personalPensionInsuranceDocuments = personalPensionInsuranceDocuments;
		this.documents = documents;
		this.personalUnemployeeInsuranceDocuments_1 = personalUnemployeeInsuranceDocuments_1;
		this.unitSocialInsuranceStatisticsDocuments_1 = unitSocialInsuranceStatisticsDocuments_1;
		this.unitSocialInsuranceManagerDocuments_1 = unitSocialInsuranceManagerDocuments_1;
		this.personalMedicalInsuranceDocuments_1 = personalMedicalInsuranceDocuments_1;
		this.personalPensionInsuranceDocuments_1 = personalPensionInsuranceDocuments_1;
		this.unitPensionInsuranceDocuments_1 = unitPensionInsuranceDocuments_1;
		this.personalSocialInsuranceCollectionDocuments_1 = personalSocialInsuranceCollectionDocuments_1;
		this.unitMedicalInsuranceDocuments_1 = unitMedicalInsuranceDocuments_1;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArchiveNumber() {
		return this.archiveNumber;
	}

	public void setArchiveNumber(String archiveNumber) {
		this.archiveNumber = archiveNumber;
	}

	public String getArchiveTitle() {
		return this.archiveTitle;
	}

	public void setArchiveTitle(String archiveTitle) {
		this.archiveTitle = archiveTitle;
	}

	public Set getPersonalBirthInsuranceDocuments() {
		return this.personalBirthInsuranceDocuments;
	}

	public void setPersonalBirthInsuranceDocuments(
			Set personalBirthInsuranceDocuments) {
		this.personalBirthInsuranceDocuments = personalBirthInsuranceDocuments;
	}

	public Set getPersonalSocialInsuranceAuditDocuments() {
		return this.personalSocialInsuranceAuditDocuments;
	}

	public void setPersonalSocialInsuranceAuditDocuments(
			Set personalSocialInsuranceAuditDocuments) {
		this.personalSocialInsuranceAuditDocuments = personalSocialInsuranceAuditDocuments;
	}

	public Set getPersonalSocialInsuranceAuditDocuments_1() {
		return this.personalSocialInsuranceAuditDocuments_1;
	}

	public void setPersonalSocialInsuranceAuditDocuments_1(
			Set personalSocialInsuranceAuditDocuments_1) {
		this.personalSocialInsuranceAuditDocuments_1 = personalSocialInsuranceAuditDocuments_1;
	}

	public Set getPersonalInjuryInsuranceDocuments() {
		return this.personalInjuryInsuranceDocuments;
	}

	public void setPersonalInjuryInsuranceDocuments(
			Set personalInjuryInsuranceDocuments) {
		this.personalInjuryInsuranceDocuments = personalInjuryInsuranceDocuments;
	}

	public Set getPersonalInjuryInsuranceDocuments_1() {
		return this.personalInjuryInsuranceDocuments_1;
	}

	public void setPersonalInjuryInsuranceDocuments_1(
			Set personalInjuryInsuranceDocuments_1) {
		this.personalInjuryInsuranceDocuments_1 = personalInjuryInsuranceDocuments_1;
	}

	public Set getPersonalSocialInsuranceStatisticsDocuments() {
		return this.personalSocialInsuranceStatisticsDocuments;
	}

	public void setPersonalSocialInsuranceStatisticsDocuments(
			Set personalSocialInsuranceStatisticsDocuments) {
		this.personalSocialInsuranceStatisticsDocuments = personalSocialInsuranceStatisticsDocuments;
	}

	public Set getPersonalUnemployeeInsuranceDocuments() {
		return this.personalUnemployeeInsuranceDocuments;
	}

	public void setPersonalUnemployeeInsuranceDocuments(
			Set personalUnemployeeInsuranceDocuments) {
		this.personalUnemployeeInsuranceDocuments = personalUnemployeeInsuranceDocuments;
	}

	public Set getUnitMedicalInsuranceDocuments() {
		return this.unitMedicalInsuranceDocuments;
	}

	public void setUnitMedicalInsuranceDocuments(
			Set unitMedicalInsuranceDocuments) {
		this.unitMedicalInsuranceDocuments = unitMedicalInsuranceDocuments;
	}

	public Set getUnitUnemployeeInsuranceDocuments() {
		return this.unitUnemployeeInsuranceDocuments;
	}

	public void setUnitUnemployeeInsuranceDocuments(
			Set unitUnemployeeInsuranceDocuments) {
		this.unitUnemployeeInsuranceDocuments = unitUnemployeeInsuranceDocuments;
	}

	public Set getUnitInjeryInsuranceDocuments() {
		return this.unitInjeryInsuranceDocuments;
	}

	public void setUnitInjeryInsuranceDocuments(Set unitInjeryInsuranceDocuments) {
		this.unitInjeryInsuranceDocuments = unitInjeryInsuranceDocuments;
	}

	public Set getPersonalSocialInsuranceCollectionDocuments() {
		return this.personalSocialInsuranceCollectionDocuments;
	}

	public void setPersonalSocialInsuranceCollectionDocuments(
			Set personalSocialInsuranceCollectionDocuments) {
		this.personalSocialInsuranceCollectionDocuments = personalSocialInsuranceCollectionDocuments;
	}

	public Set getUnitSocialInsuranceStatisticsDocuments() {
		return this.unitSocialInsuranceStatisticsDocuments;
	}

	public void setUnitSocialInsuranceStatisticsDocuments(
			Set unitSocialInsuranceStatisticsDocuments) {
		this.unitSocialInsuranceStatisticsDocuments = unitSocialInsuranceStatisticsDocuments;
	}

	public Set getPersonalMedicalInsuranceDocuments() {
		return this.personalMedicalInsuranceDocuments;
	}

	public void setPersonalMedicalInsuranceDocuments(
			Set personalMedicalInsuranceDocuments) {
		this.personalMedicalInsuranceDocuments = personalMedicalInsuranceDocuments;
	}

	public Set getUnitSocialInsuranceManagerDocuments() {
		return this.unitSocialInsuranceManagerDocuments;
	}

	public void setUnitSocialInsuranceManagerDocuments(
			Set unitSocialInsuranceManagerDocuments) {
		this.unitSocialInsuranceManagerDocuments = unitSocialInsuranceManagerDocuments;
	}

	public Set getUnitSocialInsuranceAuditDocuments() {
		return this.unitSocialInsuranceAuditDocuments;
	}

	public void setUnitSocialInsuranceAuditDocuments(
			Set unitSocialInsuranceAuditDocuments) {
		this.unitSocialInsuranceAuditDocuments = unitSocialInsuranceAuditDocuments;
	}

	public Set getPersonalSocialInsuranceStatisticsDocuments_1() {
		return this.personalSocialInsuranceStatisticsDocuments_1;
	}

	public void setPersonalSocialInsuranceStatisticsDocuments_1(
			Set personalSocialInsuranceStatisticsDocuments_1) {
		this.personalSocialInsuranceStatisticsDocuments_1 = personalSocialInsuranceStatisticsDocuments_1;
	}

	public Set getUnitPensionInsuranceDocuments() {
		return this.unitPensionInsuranceDocuments;
	}

	public void setUnitPensionInsuranceDocuments(
			Set unitPensionInsuranceDocuments) {
		this.unitPensionInsuranceDocuments = unitPensionInsuranceDocuments;
	}

	public Set getPersonalSocialInsuranceDocuments() {
		return this.personalSocialInsuranceDocuments;
	}

	public void setPersonalSocialInsuranceDocuments(
			Set personalSocialInsuranceDocuments) {
		this.personalSocialInsuranceDocuments = personalSocialInsuranceDocuments;
	}

	public Set getUnitBirthInsuranceDocuments() {
		return this.unitBirthInsuranceDocuments;
	}

	public void setUnitBirthInsuranceDocuments(Set unitBirthInsuranceDocuments) {
		this.unitBirthInsuranceDocuments = unitBirthInsuranceDocuments;
	}

	public Set getPersonalBirthInsuranceDocuments_1() {
		return this.personalBirthInsuranceDocuments_1;
	}

	public void setPersonalBirthInsuranceDocuments_1(
			Set personalBirthInsuranceDocuments_1) {
		this.personalBirthInsuranceDocuments_1 = personalBirthInsuranceDocuments_1;
	}

	public Set getPersonalSocialInsuranceDocuments_1() {
		return this.personalSocialInsuranceDocuments_1;
	}

	public void setPersonalSocialInsuranceDocuments_1(
			Set personalSocialInsuranceDocuments_1) {
		this.personalSocialInsuranceDocuments_1 = personalSocialInsuranceDocuments_1;
	}

	public Set getUnitSocialInsuranceCollectionDocuments() {
		return this.unitSocialInsuranceCollectionDocuments;
	}

	public void setUnitSocialInsuranceCollectionDocuments(
			Set unitSocialInsuranceCollectionDocuments) {
		this.unitSocialInsuranceCollectionDocuments = unitSocialInsuranceCollectionDocuments;
	}

	public Set getUnitSocialInsuranceCollectionDocuments_1() {
		return this.unitSocialInsuranceCollectionDocuments_1;
	}

	public void setUnitSocialInsuranceCollectionDocuments_1(
			Set unitSocialInsuranceCollectionDocuments_1) {
		this.unitSocialInsuranceCollectionDocuments_1 = unitSocialInsuranceCollectionDocuments_1;
	}

	public Set getUnitUnemployeeInsuranceDocuments_1() {
		return this.unitUnemployeeInsuranceDocuments_1;
	}

	public void setUnitUnemployeeInsuranceDocuments_1(
			Set unitUnemployeeInsuranceDocuments_1) {
		this.unitUnemployeeInsuranceDocuments_1 = unitUnemployeeInsuranceDocuments_1;
	}

	public Set getUnitSocialInsuranceAuditDocuments_1() {
		return this.unitSocialInsuranceAuditDocuments_1;
	}

	public void setUnitSocialInsuranceAuditDocuments_1(
			Set unitSocialInsuranceAuditDocuments_1) {
		this.unitSocialInsuranceAuditDocuments_1 = unitSocialInsuranceAuditDocuments_1;
	}

	public Set getUnitBirthInsuranceDocuments_1() {
		return this.unitBirthInsuranceDocuments_1;
	}

	public void setUnitBirthInsuranceDocuments_1(
			Set unitBirthInsuranceDocuments_1) {
		this.unitBirthInsuranceDocuments_1 = unitBirthInsuranceDocuments_1;
	}

	public Set getPersonalPensionInsuranceDocuments() {
		return this.personalPensionInsuranceDocuments;
	}

	public void setPersonalPensionInsuranceDocuments(
			Set personalPensionInsuranceDocuments) {
		this.personalPensionInsuranceDocuments = personalPensionInsuranceDocuments;
	}

	public Set getDocuments() {
		return this.documents;
	}

	public void setDocuments(Set documents) {
		this.documents = documents;
	}

	public Set getPersonalUnemployeeInsuranceDocuments_1() {
		return this.personalUnemployeeInsuranceDocuments_1;
	}

	public void setPersonalUnemployeeInsuranceDocuments_1(
			Set personalUnemployeeInsuranceDocuments_1) {
		this.personalUnemployeeInsuranceDocuments_1 = personalUnemployeeInsuranceDocuments_1;
	}

	public Set getUnitSocialInsuranceStatisticsDocuments_1() {
		return this.unitSocialInsuranceStatisticsDocuments_1;
	}

	public void setUnitSocialInsuranceStatisticsDocuments_1(
			Set unitSocialInsuranceStatisticsDocuments_1) {
		this.unitSocialInsuranceStatisticsDocuments_1 = unitSocialInsuranceStatisticsDocuments_1;
	}

	public Set getUnitSocialInsuranceManagerDocuments_1() {
		return this.unitSocialInsuranceManagerDocuments_1;
	}

	public void setUnitSocialInsuranceManagerDocuments_1(
			Set unitSocialInsuranceManagerDocuments_1) {
		this.unitSocialInsuranceManagerDocuments_1 = unitSocialInsuranceManagerDocuments_1;
	}

	public Set getPersonalMedicalInsuranceDocuments_1() {
		return this.personalMedicalInsuranceDocuments_1;
	}

	public void setPersonalMedicalInsuranceDocuments_1(
			Set personalMedicalInsuranceDocuments_1) {
		this.personalMedicalInsuranceDocuments_1 = personalMedicalInsuranceDocuments_1;
	}

	public Set getPersonalPensionInsuranceDocuments_1() {
		return this.personalPensionInsuranceDocuments_1;
	}

	public void setPersonalPensionInsuranceDocuments_1(
			Set personalPensionInsuranceDocuments_1) {
		this.personalPensionInsuranceDocuments_1 = personalPensionInsuranceDocuments_1;
	}

	public Set getUnitPensionInsuranceDocuments_1() {
		return this.unitPensionInsuranceDocuments_1;
	}

	public void setUnitPensionInsuranceDocuments_1(
			Set unitPensionInsuranceDocuments_1) {
		this.unitPensionInsuranceDocuments_1 = unitPensionInsuranceDocuments_1;
	}

	public Set getPersonalSocialInsuranceCollectionDocuments_1() {
		return this.personalSocialInsuranceCollectionDocuments_1;
	}

	public void setPersonalSocialInsuranceCollectionDocuments_1(
			Set personalSocialInsuranceCollectionDocuments_1) {
		this.personalSocialInsuranceCollectionDocuments_1 = personalSocialInsuranceCollectionDocuments_1;
	}

	public Set getUnitMedicalInsuranceDocuments_1() {
		return this.unitMedicalInsuranceDocuments_1;
	}

	public void setUnitMedicalInsuranceDocuments_1(
			Set unitMedicalInsuranceDocuments_1) {
		this.unitMedicalInsuranceDocuments_1 = unitMedicalInsuranceDocuments_1;
	}

}