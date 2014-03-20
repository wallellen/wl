package action;

import java.util.List;

import service.ArchiveManager;
import util.PageBean;
import util.SessionContants;
import DAO.ArchiveDAO;
import bean.Archive;
import bean.User;


public class ArchiveAction extends BaseAction {
	private ArchiveDAO archiveDAO;

	private String archiveNumber;
	private String archiveTitle;
	
	private String newArchiveNumber;
	private String newArchiveTitle;
	public String getNewArchiveNumber() {
		return newArchiveNumber;
	}
	
	

	public void setNewArchiveNumber(String newArchiveNumber) {
		this.newArchiveNumber = newArchiveNumber;
	}

	public String getNewArchiveTitle() {
		return newArchiveTitle;
	}

	public void setNewArchiveTitle(String newArchiveTitle) {
		this.newArchiveTitle = newArchiveTitle;
	}

	private PageBean pageBean;
	private List<Archive> archives;
	private ArchiveManager archiveManager;
	
	private int page;
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public static final int pageSize=10;
	public String getArchiveNumber() {
		return archiveNumber;
	}

	public void setArchiveNumber(String archiveNumber) {
		this.archiveNumber = archiveNumber;
	}

	public String getArchiveTitle() {
		return archiveTitle;
	}

	public void setArchiveTitle(String archiveTitle) {
		this.archiveTitle = archiveTitle;
	}

	public ArchiveDAO getArchiveDAO() {
		return archiveDAO;
	}

	public void setArchiveDAO(ArchiveDAO archiveDAO) {
		this.archiveDAO = archiveDAO;
	}
	
	
	public String initModify(){
		return "initModify";
	}
	
	public String addArchive() throws Exception{
		Archive archive = new Archive();
		archive.setArchiveNumber(archiveNumber);
		if(archiveDAO.findByExample(archive).size() == 0){
			archive.setArchiveTitle(archiveTitle);
			archiveDAO.merge(archive);
			
			return "sucess";
		}
		
		return "exist";
		
		
	}
	
	public String searchArchive(){
		Archive archive = new Archive();
		archive.setArchiveNumber(archiveNumber);
		pageBean = archiveManager.findArchiveWithPageBean(archive, pageSize, page);
		archives = pageBean.getList();
		
		return "sucess";
	}
	
	public String searchArchiveByNumber(){
		Archive archive  = archiveManager.findArchiveByNumber(archiveNumber);
		if(archive != null){
			archiveNumber = archive.getArchiveNumber();
			archiveTitle = archive.getArchiveTitle();
			User user = (User)getSession(SessionContants.USER);
			if(user.getPermition().equals(User.QUERY_PERMITION)){
				return "detailforsearch";
			}else
			    return "detail";
		}
		else{
			return "notfind";
		}
		
	}

	public String modifyArchive(){
		Archive archive = archiveManager.findArchiveByNumber(archiveNumber);
		if(archive != null){
			archive.setArchiveNumber(newArchiveNumber);
			archive.setArchiveTitle(newArchiveTitle);
			archiveDAO.merge(archive);
			return "modifysucess";
		}
		return "modifyfail";
	}
	
	public String deleteArchive(){
		Archive archive = archiveManager.findArchiveByNumber(archiveNumber);
		if(archive != null){
			archiveDAO.delete(archive);
			return "deletesucess";
		}
		return "deletefail";
	}
	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public ArchiveManager getArchiveManager() {
		return archiveManager;
	}

	public void setArchiveManager(ArchiveManager archiveManager) {
		this.archiveManager = archiveManager;
	}

	public List<Archive> getArchives() {
		return archives;
	}

	public void setArchives(List<Archive> archives) {
		this.archives = archives;
	}
}
