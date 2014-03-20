package action;

import org.apache.struts2.ServletActionContext;

import util.Constants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	// 取得当前登录的用户名
	protected String getLoginUsername() {
		return (String) ActionContext.getContext().getSession().get(
				Constants.USERNAME_KEY);
	}
	
	// 判断当前用户是否超时
	protected boolean isTimeout() {
		if (ActionContext.getContext().getSession().get(Constants.USERNAME_KEY) == null) {
			return true;
		} else {
			return false;
		}
	}

	// 检查Session对象是否存在
	protected boolean isExistSession(String key) {
		if (ActionContext.getContext().getSession()!=null&&ActionContext.getContext().getSession().get(key) != null) {
			return true;
		} else {
			return false;
		}
	}

	// 保存Session对象
	protected void setSession(String key, Object obj) {
		if(ActionContext.getContext().getSession()!=null)
		ActionContext.getContext().getSession().put(key, obj);
	}

	// 取得Session对象
	protected Object getSession(String key) {
		return ActionContext.getContext().getSession().get(key);
	}
	
	// 保存一条错误
	protected void saveActionError(String key) {
		super.addActionError(super.getText(key));
	}
	
	// 保存一个消息
	protected void saveActionMessage(String key) {
		super.addActionMessage(super.getText(key));
	}
	
	// 取得查询的URL
	protected String getRequestPath() {
		return (String)ServletActionContext.getRequest().getServletPath();
	}
	protected void removeSession(String key){
		ActionContext.getContext().getSession().remove(key);
	}
}
