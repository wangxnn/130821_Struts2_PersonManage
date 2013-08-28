package cn.wxn.web.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import cn.wxn.domain.Person;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class Permission implements Interceptor {

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invocation)
			throws Exception {
		Map<String, Object> session = ServletActionContext.getContext().getSession();
		Person p = (Person)session.get("person");
		if(p== null){
			ServletActionContext.getRequest().setAttribute("message", "请重新登陆！");
			return "error";
		}else{
			String result = invocation.invoke();
			return result;
		}
	}

}
