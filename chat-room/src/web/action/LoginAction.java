/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package web.action;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import domain.Users;
import web.form.UserForm;
import web.service.UsersService;

/** 
 * MyEclipse Struts
 * Creation date: 12-24-2016
 * 
 * XDoclet definition:
 * @struts.action path="/login" name="userForm" parameter="flag" scope="request"
 */
public class LoginAction extends DispatchAction {
	/*
	 * Generated Methods
	 */
	
	private UsersService usersService;
	public void setUsersService(UsersService usersService) {
		System.out.println(usersService);
		this.usersService = usersService;
	}
	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UserForm userForm = (UserForm) form;// TODO Auto-generated method stub
		Users users = new Users();
		users.setName(userForm.getName());
		users.setPassword(userForm.getPassword());
		users = usersService.checkUsers(users);
		
		if(users!=null){
			List<Users> friendList= usersService.findAllUsers();
			request.getSession().setAttribute("userInfo", users);
			request.setAttribute("friendList", friendList);
		
			return mapping.findForward("goFriendListUI");
		}else{
			return mapping.findForward("loginerr");		
		}
	}
	/**
	 * 登录成功后跳转至朋友列表
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward goFriendListUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UserForm userForm = (UserForm) form;// TODO Auto-generated method stub
		List<Users> friendList= usersService.findAllUsers();
		request.setAttribute("friendList", friendList);
		return mapping.findForward("goFriendListUI");
	}
}