package net.fuzui.servlet;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import net.fuzui.dao.AdminDAO;


@Controller
@RequestMapping("/AdminController")
public class AdminController {

	
	/*
	 * 管理员登录
	 */
	@RequestMapping("/login")
	public String loginStudent(@RequestParam("aname") String aname,@RequestParam("apassword") String apassword,Model model,HttpSession httpSession) {
		AdminDAO adminDAO = new AdminDAO();
		
		
		
		if (adminDAO.queryByNamePwd(aname, apassword)) {
			httpSession.setAttribute("aname", aname);
            return "admin/adminFace";
        } else {
            return "fail";
        }
		
		
		
	}
	
	
	
	/*
	    * 管理员退出登录
	    */
	   @RequestMapping("/adminlogout")
	 	public ModelAndView teacherLogout(HttpSession httpSession) {
		   
		   httpSession.removeAttribute("aname");
		   httpSession.removeAttribute("couList");
		   
		   
		   
		   return new ModelAndView(new RedirectView("/onlineSC/login.jsp"));
	 	}

	
}