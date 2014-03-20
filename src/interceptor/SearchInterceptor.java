package interceptor;

import util.SessionContants;
import bean.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SearchInterceptor extends AbstractInterceptor {

	@Override
	public synchronized String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
        ActionContext ctx=invocation.getInvocationContext();       
        User user=new User();
		user=(User)ctx.getSession().get(SessionContants.USER);
		if(user==null){
			return Action.ERROR;
		}	
		return invocation.invoke(); 
	}


}
