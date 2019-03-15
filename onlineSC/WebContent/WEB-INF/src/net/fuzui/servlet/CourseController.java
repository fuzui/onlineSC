package net.fuzui.servlet;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.fuzui.beans.Course;
import net.fuzui.dao.CourseDAO;


@Controller
@RequestMapping("/CourseController")
@SessionAttributes("courseList")
public class CourseController {
	
	
	/*
	 * 添加课程
	 */
	
	@RequestMapping("/addCourse")
	public String addCourse(Course course,Model model ) {
		CourseDAO courseDAO = new CourseDAO();
		
		if(courseDAO.addCourse(course)) {
			model.addAttribute("course",course);
			return "success";
		}else{
			return "fail";
		}
	}
	 /*
	  *课程查询
	 */
	
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String redirect(@RequestParam("serc") String serc,@RequestParam("condition") String condition,Model model) {

		
		CourseDAO courseDAO = new CourseDAO();
		ArrayList<Course>courseList = new ArrayList<Course>();
		
		if(serc.equals("all")) {
			
			
			courseList = courseDAO.getAllCourse();
			model.addAttribute("courseList",courseList);
			System.out.println(courseList);
			return "redirect:finalPage";
			
		}else if(serc.equals("sid")) {
			
			
			courseList = courseDAO.getCourseCid(condition);
			model.addAttribute("courseList",courseList);
			System.out.println("sid");
			
			return "redirect:finalPage";
			
		}else if(serc.equals("nam")) {
			courseList = courseDAO.getCourseName(condition);
			model.addAttribute("courseList",courseList);
			System.out.println(courseList);
			System.out.println("cla");
			return "redirect:finalPage";
			
		}else if(serc.equals("col")) {
			courseList = courseDAO.getCourseCol(condition);
			model.addAttribute("courseList",courseList);
			System.out.println(courseList);
			System.out.println("col");
			return "redirect:finalPage";
			
		}else if(serc.equals("type")) {
			courseList = courseDAO.getCourseType(condition);
			model.addAttribute("courseList",courseList);
			System.out.println(courseList);
			System.out.println("pro");
			return "redirect:finalPage";
			
		}else {
			
			courseList = courseDAO.getAllCourse();
			model.addAttribute("courseList",courseList);
			System.out.println(courseList);
			return "redirect:finalPage";
	
		}
	
	    
	}
	
	@RequestMapping(value="/delete/{cid}",method=RequestMethod.GET)
	public String deleteStudent(@PathVariable(value="cid") String cid,Model model) {

		
		CourseDAO courseDAO = new CourseDAO();
		
		if (courseDAO.deleteCourse(cid)) {
            System.out.println("success");
            
            return "success";
        } else {
        	System.out.println("fail");
        	return "redirect:finalPage";
        }
		
	}
	
	
	@RequestMapping(value = "/finalPage", method = RequestMethod.GET)
    public String finalPage() {

	    return "admin/queryCourse";
	}

	@RequestMapping(value="/moditystu/{cid}",method=RequestMethod.GET)
    public String editPre(@PathVariable("cid") String cid,Model model){
		
		CourseDAO courseDAO = new CourseDAO();
		ArrayList<Course>courseList = new ArrayList<Course>();
		courseList = courseDAO.getCourseCid(cid);
		model.addAttribute("courseList",courseList);
        
        return "admin/modiCourse";
    }

    // 修改
    @RequestMapping(value="/moditystud/{cid}",method=RequestMethod.GET)
    public String update(@PathVariable("cid") String cid,Course course,Model model){

        CourseDAO courseDAO = new CourseDAO();
        if(courseDAO.modify(course)) {
        	return "success";
        }else {
        	return "fail";
        }
    }
	
    
    
    @RequestMapping("/managestu")
	public String manageStudent() {
            return "admin/queryStudent";	
	}
    @RequestMapping("/managetea")
   	public String manageTeacher() {
               return "admin/queryTeacher";	
   	}
    @RequestMapping("/managecou")
   	public String manageCourse() {
               return "admin/queryCourse";	
   	}
}
