package net.fuzui.servlet;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import net.fuzui.beans.Course;
import net.fuzui.beans.CoursePlan;
import net.fuzui.dao.CourseDAO;
import net.fuzui.dao.CoursePlanDAO;




@Controller
@RequestMapping("/CoursePlanController")
public class CoursePlanController {

	
	
	
	/*
	 * 添加教学课程
	 */
	@RequestMapping("/doaddcouplan")
	public String addCoursePlan(CoursePlan coursePlan,Model model) {
		CoursePlanDAO coursePlanDAO = new CoursePlanDAO();
		
		if (coursePlanDAO.addCoursePlan(coursePlan)) {
            model.addAttribute("coursePlan", coursePlan);
            System.out.println(coursePlan);
            return "success";
           
        } else {
        	return "fail";
        }
		
		
		
	}
	
	
	
	@RequestMapping(value="/querycouplan/{cid}",method=RequestMethod.GET)
	public String deleteStudent(@PathVariable(value="cid") String cid,Model model) {

		
		model.addAttribute("cid", cid);
			System.out.println(cid);
           return "teacher/doAddCou";
       
		
	}
	
	
	 /*
	  *课程查询
	 */
	
	@RequestMapping(value = "/queryy", method = RequestMethod.GET)
	public ModelAndView redirect(@RequestParam("serc") String serc,@RequestParam("condition") String condition,Model model,HttpSession httpSession) {

		
		CourseDAO courseDAO = new CourseDAO();
		ArrayList<Course>courseList = new ArrayList<Course>();
		
		if(serc.equals("all")) {
			
			
			courseList = courseDAO.getAllCourse();
			httpSession.setAttribute("courseList",courseList);
			System.out.println(courseList);
			return new ModelAndView(new RedirectView("/onlineSC/teacher/addCou.jsp"));
			
		}else if(serc.equals("sid")) {
			
			
			courseList = courseDAO.getCourseCid(condition);
			httpSession.setAttribute("courseList",courseList);
			System.out.println("sid");
			
			return new ModelAndView(new RedirectView("/onlineSC/teacher/addCou.jsp"));
			
		}else if(serc.equals("nam")) {
			courseList = courseDAO.getCourseName(condition);
			httpSession.setAttribute("courseList",courseList);
			System.out.println(courseList);
			System.out.println("cla");
			return new ModelAndView(new RedirectView("/onlineSC/teacher/addCou.jsp"));
			
		}else if(serc.equals("col")) {
			courseList = courseDAO.getCourseCol(condition);
			httpSession.setAttribute("courseList",courseList);
			System.out.println(courseList);
			System.out.println("col");
			return new ModelAndView(new RedirectView("/onlineSC/teacher/addCou.jsp"));
			
		}else if(serc.equals("type")) {
			courseList = courseDAO.getCourseType(condition);
			httpSession.setAttribute("courseList",courseList);
			System.out.println(courseList);
			System.out.println("pro");
			return new ModelAndView(new RedirectView("/onlineSC/teacher/addCou.jsp"));
			
		}else {
			
			courseList = courseDAO.getAllCourse();
			httpSession.setAttribute("courseList",courseList);
			System.out.println(courseList);
			return new ModelAndView(new RedirectView("/onlineSC/teacher/addCou.jsp"));
	
		}
	
	    
	}
   
   
   
	/*
	 * 添加修改课程安排回显表单
	 */
	@RequestMapping("/modicouplan/{courseclass}")
	public String modiCouPlan(@PathVariable(value="courseclass") String courseclass,Model model,HttpSession httpSession) {
		CoursePlanDAO coursePlanDAO = new CoursePlanDAO();
		ArrayList<CoursePlan>cPlanList = new ArrayList<CoursePlan>();
    	
    	
		
		cPlanList = coursePlanDAO.getByCouPlanName(courseclass);
		
		if (cPlanList!=null) {
            httpSession.setAttribute("cPlanList", cPlanList);
            System.out.println(cPlanList);
            return "teacher/modCouPlan";
           
        } else {
        	return "fail";
        }
		
	}
	/*
	 * 修改课程安排_提交
	 */
	@RequestMapping("/moditycouplan/{tid}")
	public ModelAndView modityCouPlan(@PathVariable(value="tid") String tid,CoursePlan coursePlan) {
		CoursePlanDAO coursePlanDAO = new CoursePlanDAO();
		
		if(coursePlanDAO.modify(coursePlan)) {
			return new ModelAndView(new RedirectView("/onlineSC/TeacherController/managecou/{tid}"));
		}else {
    	
			return new ModelAndView(new RedirectView("/onlineSC/fail.jsp"));
		}
	}
   
   
   /*
     * 删除
    */
	@RequestMapping("/delcouplan/{courseclass}/{tid}")
	public ModelAndView modityCouPlan(@PathVariable(value="courseclass") String courseclass,@PathVariable(value="tid") String tid,HttpSession httpSession) {
		CoursePlanDAO coursePlanDAO = new CoursePlanDAO();
		
		if(coursePlanDAO.delByCouPlanClass(courseclass)) {
			return new ModelAndView(new RedirectView("/onlineSC/TeacherController/managecou/{tid}"));
		}else {
    	
			return new ModelAndView(new RedirectView("/onlineSC/fail.jsp"));
		}
	}
  

	
}