package util;

import java.util.HashMap;

import bean.PersonalBirthInsuranceDocument;
import bean.PersonalInjuryInsuranceDocument;
import bean.PersonalMedicalInsuranceDocument;
import bean.PersonalPensionInsuranceDocument;
import bean.PersonalSocialInsuranceAuditDocument;
import bean.PersonalSocialInsuranceCollectionDocument;
import bean.PersonalSocialInsuranceDocument;
import bean.PersonalSocialInsuranceStatisticsDocument;
import bean.PersonalUnemployeeInsuranceDocument;
import bean.UnitSocialInsuranceAuditDocument;
import bean.UnitSocialInsuranceCollectionDocument;
import bean.UnitSocialInsuranceManagerDocument;
import bean.UnitSocialInsuranceStatisticsDocument;
import bean.UnitUnemployeeInsuranceDocument;

public class TableAndObjectMap {
	private static HashMap<String,String>UnideDocumentmodels=new HashMap<String,String>();
	private static HashMap<String,String>PersonalDocumentmodels=new HashMap<String,String>();
	static{
		UnideDocumentmodels.put("生育保险待遇类","UnitBirthInsuranceDocument");
		
		UnideDocumentmodels.put("工伤保险待遇类","UnitInjeryInsuranceDocument");
		
		UnideDocumentmodels.put("医疗保险待遇类","UnitMedicalInsuranceDocument");
		
		UnideDocumentmodels.put("养老保险待遇类","UnitPensionInsuranceDocument");
		
		UnideDocumentmodels.put("社会保险稽核类","UnitSocialInsuranceAuditDocument");
		
		UnideDocumentmodels.put("社会保险管理类","UnitSocialInsuranceManagerDocument");
		
		UnideDocumentmodels.put("社会保险征缴类","UnitSocialInsuranceCollectionDocument");
		
		UnideDocumentmodels.put("社会保险业务统计报表类","UnitSocialInsuranceStatisticsDocument");
		
		UnideDocumentmodels.put("失业保险待遇类","UnitUnemployeeInsuranceDocument");
	}
	public static String getUnitDocumentModel(String type){
		return UnideDocumentmodels.get(type);
		
	}
	public static final String U_B_I_D="生育保险待遇类";
	public static final String U_I_I_D="工伤保险待遇类";
	public static final String U_M_I_D="医疗保险待遇类";
	public static final String U_P_I_D="养老保险待遇类";
	public static final String U_S_I_A_D="社会保险稽核类";
	public static final String U_S_I_M_D="社会保险管理类";
	public static final String U_S_I_C_D="社会保险征缴类";
	public static final String U_S_I_S_D="社会保险业务统计报表类";
	public static final String U_U_I_D="失业保险待遇类";
	
	public static final String P_B_I_D="生育保险待遇类";
	public static final String P_I_I_D="工伤保险待遇类";
	public static final String P_M_I_D="医疗保险待遇类";
	public static final String P_P_I_D="养老保险待遇类";
	public static final String P_S_I_A_D="社会保险稽核类";
	public static final String P_S_I_M_D="社会保险管理类";
	public static final String P_S_I_S_D="社会保险业务统计报表类";
	public static final String P_U_I_D="失业保险待遇类";
	public static final String P_S_I_C_D="社会保险征缴类";
	static{
		PersonalDocumentmodels.put("生育保险待遇类", "PersonalBirthInsuranceDocument");
		
		PersonalDocumentmodels.put("工伤保险待遇类", "PersonalInjuryInsuranceDocument");
		
		PersonalDocumentmodels.put("医疗保险待遇类", "PersonalMedicalInsuranceDocument");
		
		PersonalDocumentmodels.put("养老保险待遇类", "PersonalPensionInsuranceDocument");
		
		PersonalDocumentmodels.put("社会保险稽核类", "PersonalSocialInsuranceAuditDocument");
		
		PersonalDocumentmodels.put("社会保险管理类", "PersonalSocialInsuranceDocument");
		
		PersonalDocumentmodels.put("社会保险业务统计报表类", "PersonalSocialInsuranceStatisticsDocument");
		
		PersonalDocumentmodels.put("失业保险待遇类", "PersonalUnemployeeInsuranceDocument");
		
		PersonalDocumentmodels.put("社会保险征缴类", "PersonalSocialInsuranceCollectionDocument");
	}
	public static String getPersonalDocumentModel(String type){
		return PersonalDocumentmodels.get(type);
	}
}
