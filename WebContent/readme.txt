struts2练习：

	创建数据库：

		set names utf8;
		#创建数据库
		create database day130821 character set utf8 collate utf8_general_ci;
		#用户表
		CREATE TABLE S_User(
			userID INT  NOT NULL AUTO_INCREMENT, #主键ID
			userName VARCHAR(50)   NULL,  #用户姓名
			loginName VARCHAR(50)   NULL, #登录名
			loginPwd VARCHAR(50)  NULL,   #密码#
			sex VARCHAR(10)  NULL,        #性别（例如：男，女）
			birthday VARCHAR(50) NULL,       #出生日期
			education VARCHAR(20)  NULL,    #学历（例如：研究生、本科、专科、高中）
			telephone VARCHAR(50)  NULL,  #电话 
			interest VARCHAR(20)  NULL,      #兴趣爱好（例如：体育、旅游、逛街）
			path VARCHAR(500)  NULL,     #上传路径（path路径）
			filename VARCHAR(100)  NULL,     #上传文件名称（文件名）
			remark VARCHAR(500)  NULL,   #备注
			PRIMARY KEY (userID)
		)charset utf8; 
		#初始化数据：默认用户名和密码是admin
		INSERT INTO S_User (userID,userName,logonName,logonPwd) VALUES (1,'超级管理员','admin','admin');

	* 分析案例的功能：
		* 登录页面：
			* 验证：1、手工验证；2、xml验证
			* 数据库验证
		
		* 查询页面：
			* 条件查询
			* 默认模糊查询
		
		* 添加页面：
			* 模型驱动，从页面中获取所有属性信息
			* 文件上传：
				* 真实文件要上传到指定的目录中，在数据库只保存路径和文件名
			* 令牌拦截器，处理表单重复提交
		
		* 编辑页面：
			* 页面回显技术
			* 文件上传：
				* 真实文件要上传到指定的目录中，在数据库只保存路径和文件名
			* 令牌拦截器，处理表单重复提交
		
		* 查看页面：
			* 页面显示相关信息
			* 文件下载
		
		* 删除
	
	* 工程目录说明：
		* css：样式目录
		* images：工程所用的图片
		* jquery：jquery相关内容，利用了jquery的时间插件
		* js：页面中所用到的内容
		* login目录：
			* login.jsp是登录页面
			* home.jsp是主页面
			* top.jsp是标题页面
			* left.jsp是菜单页面
			* welcome.jsp是欢迎页面
			* buttom.jsp是底部信息页面
		* user目录：
			* list.jsp是默认列表页面
			* add.jsp是添加页面
			* edit.jsp是编辑页面
			* view.jsp是查看页面
			* error.jsp是错误提示页面
		* index.jsp直接转向login.jsp
	
	* 开发环境搭建：
		* 导入所需的所有jar包：
			* struts2所有jar包
			* mysql的驱动包
			* jdbcUtils包
			* junit包
		
		* 配置web.xml文件，配置struts2框架的核心过滤器
			  <filter>
			  	<filter-name>StrutsPrepareAndExecuteFilter</filter-name>
			  	<filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
			  </filter>
			  <filter-mapping>
			  	<filter-name>StrutsPrepareAndExecuteFilter</filter-name>
			  	<url-pattern>*.action</url-pattern>
			  	<url-pattern>*.jsp</url-pattern>
			  </filter-mapping>
		
		* 配置struts.xml文件
		
		* 完成登录功能：
			* 修改页面中使用的UI标签，改成struts2的UI标签
				* 要引入struts2标签库
					<%@ taglib uri="/struts-tags" prefix="s" %>
				
				* 验证：
					* 从页面中获取表单元素信息
						* 创建一个javabean，声明页面中所有同名的属性
						* 在动作类中，使用"模型驱动"来获取页面元素内容
						* 使用xml方式验证
							<validators>
								<field name="loginName">
									<field-validator type="requiredstring">
										<param name="trim">true</param>
										<message><![CDATA[用户名不能为空]]></message>
									</field-validator>
								</field>
								<field name="loginPsw">
									<field-validator type="requiredstring">
										<param name="trim">true</param>
										<message><![CDATA[密码不能为空]]></message>
									</field-validator>
									<field-validator type="regex">
										<param name="trim">true</param>
										<param name="expression"><![CDATA[^[0-9a-zA-Z]{5,12}$]]></param>
										<message><![CDATA[密码的长度必须在5至12位之间]]></message>
									</field-validator>
								</field>
							</validators>
						* 在struts.xml文件中，配置一个名为"input"的result结果类型
							<result name="input">/login/login.jsp</result>
						* 在login.jsp页面，增加一个<s:fielderror />标签，作用是提示错误信息
					
					* 数据库验证：
						* 创建数据库：
							#用户表
							CREATE TABLE S_User(
								userID INT  NOT NULL AUTO_INCREMENT, #主键ID
								userName VARCHAR(50)   NULL,  #用户姓名
								logonName VARCHAR(50)   NULL, #登录名
								logonPwd VARCHAR(50)  NULL,   #密码#
								sex VARCHAR(10)  NULL,        #性别（例如：男，女）
								birthday VARCHAR(50) NULL,       #出生日期
								education VARCHAR(20)  NULL,    #学历（例如：研究生、本科、专科、高中）
								telephone VARCHAR(50)  NULL,  #电话 
								interest VARCHAR(20)  NULL,      #兴趣爱好（例如：体育、旅游、逛街）
								path VARCHAR(500)  NULL,     #上传路径（path路径）
								filename VARCHAR(100)  NULL,     #上传文件名称（文件名）
								remark VARCHAR(500)  NULL,   #备注
								PRIMARY KEY (userID)
							) 
							
							#初始化数据：默认用户名和密码是admin
							INSERT INTO s_user (userID,userName,logonName,logonPwd) VALUES (1,'超级管理员','admin','admin')
						
						* 在动作类action中，home()方法里，代码如下：
							public String home(){
								System.out.println("LoginAction home()");
								
								Dao userDao = new DaoImpl();
								
								User newUser = userDao.login(user);
								
								if(newUser==null||newUser.equals("")){
									this.addFieldError("error", "用户名不存在或密码错误！");
									return "input";
								}
								
								return "home";
							}
		
		
		