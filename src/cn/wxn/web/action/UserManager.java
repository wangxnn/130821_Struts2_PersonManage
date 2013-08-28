package cn.wxn.web.action;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import cn.wxn.domain.Person;
import cn.wxn.domain.PersonAdd;
import cn.wxn.domain.QueryInfo;
import cn.wxn.domain.QueryPage;
import cn.wxn.service.impl.ServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

@SuppressWarnings("serial")
public class UserManager extends ActionSupport implements ModelDriven<PersonAdd> {
	private PersonAdd personAdd= new PersonAdd();
	
	public String all(){
		ServiceImpl service = new ServiceImpl();
		HttpServletRequest request = ServletActionContext.getRequest();

		try{
			QueryInfo info = new QueryInfo();

			String currentPage = request.getParameter("currentPage");
			if(currentPage!=null&& !currentPage.trim().equals("")){
				int cPage = Integer.parseInt(currentPage);
				info.setCurrentPage(cPage);
				info.setBegin(  (cPage-1) * info.getPageSize());
			}
			
			QueryPage qpage= service.query(info);
			
			request.setAttribute("page", qpage);
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("message", "查询服务器错误，请稍后重试");
			return "error";
		}		
		return "all";
	}
	
	public String del(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ServiceImpl service = new ServiceImpl();

		try{
			String userID = request.getParameter("userID");
			if(userID != null && !userID.trim().equals("")){
				int id = Integer.parseInt(userID);
				service.deletePerson(id);
				request.setAttribute("message", "删除操作成功！");
				return "success";
			}else{
				request.setAttribute("message", "参数传递错误！");
				return "error";
			}
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("message", "删除操作出现错误！");
			return "error";
		}
	}
	
	public String add(){

	   HttpServletRequest request= ServletActionContext.getRequest();
		ServiceImpl service = new ServiceImpl();
		
		//设置是否接受的education字段为空，是就设置为空
		if(this.personAdd.getEducation().trim().equals("请选择")){
			this.personAdd.setEducation("");
		}
		//查看上传的全部字段		
		System.out.println(this.personAdd);
		
		Person person = new Person();
		person.setUserName(this.personAdd.getUserName());
		person.setLoginName(this.personAdd.getLoginName());
		person.setLoginPwd(this.personAdd.getLoginPwd());
		person.setSex(this.personAdd.getSex());
		person.setBirthday(this.personAdd.getBirthday());
		person.setEducation(this.personAdd.getEducation());
		person.setTelephone(this.personAdd.getTelephone());
		person.setInterest(this.personAdd.getInterest());
		person.setRemark(this.personAdd.getRemark());
		
		//判断是否上传了文件，是就保存，并且封装数据到数据库中
		if(this.personAdd.getUploadfile()!=null){
			String realPath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/saveUpload");
			File saveFile = new File(new File(realPath), this.personAdd.getUploadfileFileName());
			if(!saveFile.getParentFile().exists()){
				saveFile.getParentFile().mkdirs();
			}
			try {
				FileUtils.copyFile(this.personAdd.getUploadfile(), saveFile);
				request.setAttribute("message", "保存文件成功");

				person.setPath(realPath);
				person.setFilename(this.personAdd.getUploadfileFileName());
			
			} catch (IOException e) {
				e.printStackTrace();
				request.setAttribute("message", "上传文件失败！请稍后重试！");
			}
		}
		
		try{
			service.addPerson(person);
			request.setAttribute("message", "添加用户成功！");
		}catch(Exception ex){
			request.setAttribute("message", "添加用户失败");
		}	
		
		return "success";
	}

	@Override
	public PersonAdd getModel() {
		return personAdd;
	}
	
	public String checkUI(){
		HttpServletRequest request = ServletActionContext.getRequest();
		ServiceImpl service = new ServiceImpl();

		try{
			String userID = request.getParameter("userID");
			if(userID != null && !userID.trim().equals("")){
				int id = Integer.parseInt(userID);
				Person  person= service.find(id);
				if(person != null){
					request.setAttribute("person", person);
					return "checkUI";				
				}
				}else{
					request.setAttribute("message", "参数传递错误！");
					return "error";
				}

			}catch(Exception ex){
				ex.printStackTrace();
			}
			request.setAttribute("message", "删除操作出现错误！");
			return "error";
	}
	
	public String editUI(){
		HttpServletRequest request = ServletActionContext.getRequest();
		ServiceImpl service = new ServiceImpl();

		/*
		Person person = new Person();
		person.setUserName(this.personAdd.getUserName());
		person.setLoginName(this.personAdd.getLoginName());
		person.setLoginPwd(this.personAdd.getLoginPwd());
		person.setSex(this.personAdd.getSex());
		person.setBirthday(this.personAdd.getBirthday());
		person.setEducation(this.personAdd.getEducation());
		person.setTelephone(this.personAdd.getTelephone());
		person.setInterest(this.personAdd.getInterest());
		person.setRemark(this.personAdd.getRemark());
		 */
		
		try{
			String userID = request.getParameter("userID");
			if(userID != null && !userID.trim().equals("")){
				int id = Integer.parseInt(userID);
				Person  person= service.find(id);
				if(person != null){
					/*
					Person person = new Person();
					person.setUserName(this.personAdd.getUserName());
					person.setLoginName(this.personAdd.getLoginName());
					person.setLoginPwd(this.personAdd.getLoginPwd());
					person.setSex(this.personAdd.getSex());
					person.setBirthday(this.personAdd.getBirthday());
					person.setEducation(this.personAdd.getEducation());
					person.setTelephone(this.personAdd.getTelephone());
					person.setInterest(this.personAdd.getInterest());
					person.setRemark(this.personAdd.getRemark());
					 */
					PersonAdd pa = new PersonAdd();
					pa.setUserID(person.getUserID());
					pa.setUserName(person.getUserName());
					pa.setLoginName(person.getLoginName());
					pa.setLoginPwd(person.getLoginPwd());
					pa.setSex(person.getSex());
					pa.setBirthday(person.getBirthday());
					pa.setEducation(person.getEducation());
					pa.setTelephone(person.getTelephone());
					pa.setInterest(person.getInterest());
					pa.setRemark(person.getRemark());
					
					//request.setAttribute("person", pa);
					ValueStack vs = ServletActionContext.getContext().getValueStack();
					vs.pop();
					vs.push(pa);
					
					return "editUI";				
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		request.setAttribute("message", "参数传递错误！");
		return "error";
	}
	
	
	public String update(){
		return null;
	}
}
