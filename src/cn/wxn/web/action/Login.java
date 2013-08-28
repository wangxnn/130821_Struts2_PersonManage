package cn.wxn.web.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import cn.wxn.domain.Person;
import cn.wxn.domain.PersonLogin;
import cn.wxn.service.impl.ServiceImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class Login extends ActionSupport implements ModelDriven<PersonLogin>{
	private PersonLogin pl = new PersonLogin();
	
	public String find(){
		try{
			ServiceImpl service = new ServiceImpl();
			Person p = service.findPerson(pl.getName(), pl.getPassword());
			
			if(p == null){
				this.addFieldError("name", "用户名或者密码错误");
				return "input";
			}
			Map<String, Object> sessionMap = ServletActionContext.getContext().getSession();
			sessionMap.put("person", p);
			return "success";

		}catch(Exception ex){
			ex.printStackTrace();
			return "input";
		}
		
	}

	@Override
	public PersonLogin getModel() {
		return pl;
	}
}
