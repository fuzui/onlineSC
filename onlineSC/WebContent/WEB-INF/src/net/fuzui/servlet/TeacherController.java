package net.fuzui.servlet;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import net.fuzui.beans.Course;
import net.fuzui.beans.CoursePlan;
import net.fuzui.beans.StuExitSelect;
import net.fuzui.beans.StuSelectResult;
import net.fuzui.beans.Student;
import net.fuzui.beans.Teacher;
import net.fuzui.dao.CourseDAO;
import net.fuzui.dao.CoursePlanDAO;
import net.fuzui.dao.SCDAO;
import net.fuzui.dao.TeacherDAO;



@Controller
@RequestMapping("/TeacherController")
@SessionAttributes("teacherList")
public class TeacherController {

	
	/*
	 * 教师登录
	 */
	@RequestMapping("/login")
	public ModelAndView loginStudent(@RequestParam("tid") String tid,@RequestParam("tpassword") String tpassword,Model model,HttpSession httpSession) {
		TeacherDAO teacherDAO = new TeacherDAO();
		
		if (teacherDAO.queryByNamePwd(tid, tpassword)) {
			
			Teacher teacher = new Teacher();
			teacher = teacherDAO.getByTeaTid(tid);
           // model.addAttribute("tid", tid);
            httpSession.setAttribute("tid", tid);
            httpSession.setAttribute("tname", teacher.getTname());
           // httpSession.setAttribute("teachername", teacher.getTname());
            return new ModelAndView(new RedirectView("../teacher/teacherFace.jsp"));
            
        } else {
        	return new ModelAndView(new RedirectView("../fail.jsp"));
        }
		
		
		
	}
	/*
	 * 添加教师
	 */
	@RequestMapping("/addTeacher")
	public ModelAndView addTeacher(Teacher teacher,Model model,HttpSession httpSession) {
		TeacherDAO teacherDAO = new TeacherDAO();
		
		if (teacherDAO.addTeacher(teacher)) {
            model.addAttribute("teacher", teacher);
            
            return new ModelAndView(new RedirectView("../admin/addTeacher.jsp"));
           // return "techer/teacherFace";
        } else {
        	return new ModelAndView(new RedirectView("fail"));
        }
		
		
		
	}
	
	 /*
	  *教师条件查询
	 */
	
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String redirect(@RequestParam("serc") String serc,@RequestParam("condition") String condition,Model model) {

		
		TeacherDAO teacherDAO = new TeacherDAO();
		ArrayList<Teacher>teacherList = new ArrayList<Teacher>();
		
		if(serc.equals("all")) {
			
			
			teacherList = teacherDAO.getAllTeacher();
			model.addAttribute("teacherList",teacherList);
			System.out.println(teacherList);
			return "redirect:finalPage";
			
		}else if(serc.equals("sid")) {
			
			
			teacherList = teacherDAO.getTeacherTid(condition);
			model.addAttribute("teacherList",teacherList);
			System.out.println("tid");
			
			return "redirect:finalPage";
			
		}else {
			
			teacherList = teacherDAO.getAllTeacher();
			model.addAttribute("teacherList",teacherList);
			System.out.println(teacherList);
			return "redirect:finalPage";
	
		}
	
	    
	}
	
	@RequestMapping(value="/delete/{tid}",method=RequestMethod.GET)
	public String deleteStudent(@PathVariable(value="tid") String tid,Model model) {

		
		TeacherDAO teacherDAO = new TeacherDAO();
		
		if (teacherDAO.deleteTeacher(tid)) {
           System.out.println("success");
           
           return "success";
       } else {
       	System.out.println("fail");
       	return "redirect:finalPage";
       }
		
	}
	
	
	@RequestMapping(value = "/finalPage", method = RequestMethod.GET)
   public String finalPage() {

	    return "admin/queryTeacher";
	}

	@RequestMapping(value="/moditystu/{tid}",method=RequestMethod.GET)
   public String editPre(@PathVariable("tid") String tid,Model model){
		
		TeacherDAO teacherDAO = new TeacherDAO();
		ArrayList<Teacher>teacherList = new ArrayList<Teacher>();
		teacherList = teacherDAO.getTeacherTid(tid);
		model.addAttribute("teacherList",teacherList);
       
       return "admin/modiTeacher";
   }

   // 修改
   @RequestMapping(value="/moditystud/{tid}",method=RequestMethod.GET)
   public String update(@PathVariable("tid") String tid,Teacher teacher,Model model){

       TeacherDAO teacherDAO = new TeacherDAO();
       if(teacherDAO.modify(teacher)) {
       	return "success";
       }else {
       	return "fail";
       }
   }
	
   
   /*
    *教师界面左侧功能超链接提交请求
    */
   @RequestMapping("/addcou")
	public String addCou() {
           return "teacher/addCou";	
	}
   @RequestMapping("/sercsc")
  	public String sercSC() {
              return "teacher/serchSC";	
  	}
   
   
   
   
   
   /*
    * 教师退出登录
    */
   @RequestMapping("/teacherlogout")
 	public ModelAndView teacherLogout(HttpSession httpSession) {
	   
	   httpSession.removeAttribute("tid");
	   httpSession.removeAttribute("tname");
	   httpSession.removeAttribute("couList");
	   httpSession.removeAttribute("sesList");
	   httpSession.removeAttribute("lookList");
	   
	   return new ModelAndView(new RedirectView("/onlineSC/login.jsp"));
 	}
   
   
   /*
    * 
    */
   @RequestMapping("/queryvita/{tid}")
	public String queryVita(@PathVariable(value="tid") String tid,Model model) {
	   TeacherDAO teacherDAO = new TeacherDAO();
	   Teacher teacher = new Teacher();
	   teacher = teacherDAO.getByTeaTid(tid);
	   model.addAttribute("tid",teacher.getTid());
	   model.addAttribute("tname",teacher.getTname());
	   model.addAttribute("tpassword",teacher.getTpassword());
	   model.addAttribute("tsex",teacher.getTsex());
	   model.addAttribute("introduction",teacher.getIntroduction());
	   System.out.println(teacher);
	   System.out.println(teacher.getTpassword());
	   
	   return "teacher/queryVita";
	}
    @RequestMapping("/managecou/{tid}")
 	public String manageCou(@PathVariable(value="tid") String tid,Model model,HttpSession httpSession) {
    	//Course course = new Course();
    	CourseDAO courseDAO = new CourseDAO();
    	//CoursePlan coursePlan = new CoursePlan();
    	CoursePlanDAO coursePlanDAO = new CoursePlanDAO();
    	ArrayList<CoursePlan>coursePlanList = new ArrayList<CoursePlan>();
    	ArrayList<Course>couList = new ArrayList<Course>();
    	
    	coursePlanList = coursePlanDAO.getByCouPlanTid(tid);
    	couList = courseDAO.getCoursetid(tid);
    	System.out.println("教师编号"+tid);
    	httpSession.setAttribute("coursePlanList", coursePlanList);
    	httpSession.setAttribute("couList", couList);
    	
    	
    	System.out.println(coursePlanList);
    	
    	System.out.println(couList);
    	return "teacher/manageCourse";	
 	}
   
   
   /*
    * 教师修改自己的密码
    */
   @RequestMapping("/moditypw/{tid}")
	public ModelAndView teacherModi(@PathVariable(value="tid") String tid,Model model) {
	   
	   
	   return new ModelAndView(new RedirectView("../../teacher/modityPw.jsp"));
	}
   @RequestMapping("/moditypassword/{tid}")
	public ModelAndView teacherModiPw(@PathVariable(value="tid") String tid,@RequestParam("tpassword") String tpassword,Model model) {
	   TeacherDAO teacherDAO = new TeacherDAO();
	   if(teacherDAO.modifyPw(tpassword, tid)){
		   return new ModelAndView(new RedirectView("../queryvita/{tid}"));
	   }else {
		   return new ModelAndView(new RedirectView("../fail.jsp"));
	   }
	   
	   
	}
   
   @RequestMapping("/addquery")
	public String adStudent() {
           return "teacher/addCou";	
	}
   
   
   
   
   /*
    * 查看名单
    */
   @RequestMapping(value="/sercsc/{tid}",method=RequestMethod.GET)
   public String sercChoose(@PathVariable("tid") String tid,StuSelectResult ssr,Model model,HttpSession httpSession){

       SCDAO scDAO = new SCDAO();
       ArrayList<StuExitSelect> sesList = new ArrayList<StuExitSelect>();
       sesList = scDAO.getLookByTid(tid);
       httpSession.setAttribute("sesList", sesList);
       
       	return "teacher/serchSC";  	
       
   }
   
   
   /*
    * 为了方便，这里的sid实际为教师编号
    */
   @RequestMapping(value="/looksel/{cid}/{cname}",method=RequestMethod.GET)
   public String lookChoose(@PathVariable("cid") String cid,@PathVariable("cname") String cname,Model model,HttpSession httpSession){

       SCDAO scDAO = new SCDAO();
       ArrayList<Student> lookList = new ArrayList<Student>();
       lookList = scDAO.getByStuSid(cid);
       httpSession.setAttribute("lookList", lookList);
       model.addAttribute("cname", cname);
       
       	return "teacher/printStudent";  	
       
   }
  

	
}