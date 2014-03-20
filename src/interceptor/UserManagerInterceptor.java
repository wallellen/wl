package interceptor;

import util.SessionContants;
import bean.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserManagerInterceptor extends AbstractInterceptor {

	@Override
	public synchronized String intercept(ActionInvocation invocation) throws Exception {
        ActionContext ctx=invocation.getInvocationContext();       
        User user=new User();
        
		user=(User)ctx.getSession().get(SessionContants.USER);
		if(user==null){
			return Action.ERROR;
		}
		if(!user.getPermition().equals(User.SUPER_PERMITION)){
			return Action.ERROR;
		}		
		return invocation.invoke(); 
	}

}
