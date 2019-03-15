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
import net.fuzui.beans.StuExitSelect;
import net.fuzui.beans.StuSelectResult;
import net.fuzui.beans.Student;
import net.fuzui.beans.Teacher;
import net.fuzui.dao.CourseDAO;
import net.fuzui.dao.SCDAO;
import net.fuzui.dao.StudentDAO;



@Controller
@RequestMapping("/StudentController")
@SessionAttributes("studentList")
public class StudentController {
	
	
	/*
	 * 学生登录
	 */
	@RequestMapping("/login")
	public ModelAndView loginStudent(@RequestParam("sid") String sid,@RequestParam("spassword") String spassword,Model model,HttpSession httpSession) {
		StudentDAO studentDAO = new StudentDAO();
		Student student = new Student();
		student = studentDAO.getByStuSid(sid);
		if (studentDAO.queryByNamePwd(sid, spassword)) {
            httpSession.setAttribute("sid", sid);
            httpSession.setAttribute("sname", student.getSname());
            return new ModelAndView(new RedirectView("../student/studentFace.jsp"));
        } else {
        	return new ModelAndView(new RedirectView("../fail.jsp"));
        }
		
	}
	
	/*
	 * 添加学生
	 */
	@RequestMapping("/addStudent")
	public String addStudent(Student student,Model model) {
		StudentDAO studentDAO = new StudentDAO();
		if (studentDAO.addStudent(student)) {
            model.addAttribute("student", student);
            
            return "admin/addStudent";
        } else {
            return "fail";
        }
		
	}
	
	
	/*
	 * 学生查询
	 */
	
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String redirect(@RequestParam("serc") String serc,@RequestParam("condition") String condition,Model model) {

		
		StudentDAO studentDAO = new StudentDAO();
		ArrayList<Student>studentList = new ArrayList<Student>();
		
		if(serc.equals("all")) {
			
			
			studentList = studentDAO.getAllStudent();
			model.addAttribute("studentList",studentList);
			System.out.println(studentList);
			return "redirect:finalPage";
			
		}else if(serc.equals("sid")) {
			
			
			studentList = studentDAO.getByStudentId(condition);
			model.addAttribute("studentList",studentList);
			System.out.println("sid");
			
			return "redirect:finalPage";
			
		}else if(serc.equals("col")) {
			studentList = studentDAO.getByStudentCol(condition);
			model.addAttribute("studentList",studentList);
			System.out.println(studentList);
			System.out.println("col");
			return "redirect:finalPage";
			
		}else if(serc.equals("pro")) {
			studentList = studentDAO.getByStudentPro(condition);
			model.addAttribute("studentList",studentList);
			System.out.println(studentList);
			System.out.println("pro");
			return "redirect:finalPage";
			
		}else if(serc.equals("cla")) {
			studentList = studentDAO.getByStudentCla(condition);
			model.addAttribute("studentList",studentList);
			System.out.println(studentList);
			System.out.println("cla");
			return "redirect:finalPage";
			
		}else {
			
			studentList = studentDAO.getAllStudent();
			model.addAttribute("studentList",studentList);
			System.out.println(studentList);
			return "redirect:finalPage";
	
		}
	
	    
	}
	
	@RequestMapping(value="/delete/{sid}",method=RequestMethod.GET)
	public String deleteStudent(@PathVariable(value="sid") String sid,Model model) {

		
		StudentDAO studentDAO = new StudentDAO();
		
		if (studentDAO.deleteStudent(sid)) {
            System.out.println("success");
            
            return "success";
        } else {
        	System.out.println("fail");
        	return "redirect:finalPage";
        }
		
	}
	
	
	@RequestMapping(value = "/finalPage", method = RequestMethod.GET)
    public String finalPage() {

	    return "admin/queryStudent";
	}

	@RequestMapping(value="/moditystu/{sid}",method=RequestMethod.GET)
    public String editPre(@PathVariable("sid") String sid,Model model){
		
		StudentDAO studentDAO = new StudentDAO();
		ArrayList<Student>studentList = new ArrayList<Student>();
		studentList = studentDAO.getByStudentId(sid);
		model.addAttribute("studentList",studentList);
        
        return "admin/modiStudent";
    }

    // 修改
    @RequestMapping(value="/moditystud/{sid}",method=RequestMethod.GET)
    public String update(@PathVariable("sid") String sid,Student student,Model model){

        StudentDAO studentDAO = new StudentDAO();
        if(studentDAO.modify(student)) {
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
    
    @RequestMapping("/addstu")
	public String adStudent() {
            return "admin/addStudent";	
	}
    @RequestMapping("/addtea")
   	public String adTeacher() {
               return "admin/addTeacher";	
   	}
    @RequestMapping("/addcou")
   	public String adCourse() {
               return "admin/addCourse";	
   	}
	
    
    
    
    
    /*
      * 学生退出登录
     */
    @RequestMapping("/studentlogout")
  	public ModelAndView teacherLogout(HttpSession httpSession) {
 	   
 	   httpSession.removeAttribute("sid");
 	   httpSession.removeAttribute("sname");
 	   httpSession.removeAttribute("courseList");
 	   httpSession.removeAttribute("ssrList");
 	  httpSession.removeAttribute("sesList");
 	   return new ModelAndView(new RedirectView("/onlineSC/login.jsp"));
  	}
    
    
    @RequestMapping("/queryvitastu/{sid}")
	public String queryVita(@PathVariable(value="sid") String sid,Model model) {
       StudentDAO studentDAO = new StudentDAO();
	   Student student = new Student();
	   student = studentDAO.getByStuSid(sid);
	   model.addAttribute("sid",student.getSid());
	   model.addAttribute("sname",student.getSname());
	   model.addAttribute("sidcard",student.getSidcard());
	   model.addAttribute("ssex",student.getSsex());
	   model.addAttribute("spassword",student.getSpassword());
	   model.addAttribute("sage",student.getSage());
	   model.addAttribute("classr",student.getClassr());
	   model.addAttribute("profession",student.getProfession());
	   model.addAttribute("college",student.getCollege());
	   
	   System.out.println(student);
	   System.out.println(student.getSpassword());
	   
	   return "student/queryVitaStu";
	}
	
    
    
    /*
     * 学生修改自己的密码
     */
    @RequestMapping("/moditypwstu/{sid}")
 	public ModelAndView teacherModi(@PathVariable(value="sid") String sid,Model model) {
 	   
 	   
 	   return new ModelAndView(new RedirectView("../../student/modityPwStu.jsp"));
 	}
    @RequestMapping("/moditypasswordstu/{sid}")
 	public ModelAndView teacherModiPw(@PathVariable(value="sid") String tid,@RequestParam("spassword") String spassword,Model model) {
       StudentDAO studentDAO = new StudentDAO();
 	   if(studentDAO.modifyPw(spassword, tid)){
 		   return new ModelAndView(new RedirectView("../queryvitastu/{sid}"));
 	   }else {
 		   return new ModelAndView(new RedirectView("../fail.jsp"));
 	   }

 	}
    
    
    
    /*
     * 查询选课
     */
    
    @RequestMapping("/selqueryy")
   	public String selQueryy() {
              return "student/selCourse";	
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
			return new ModelAndView(new RedirectView("/onlineSC/student/selCourse.jsp"));
			
		}else if(serc.equals("sid")) {
			
			
			courseList = courseDAO.getCourseCid(condition);
			httpSession.setAttribute("courseList",courseList);
			System.out.println("sid");
			
			return new ModelAndView(new RedirectView("/onlineSC/student/selCourse.jsp"));
			
		}else if(serc.equals("nam")) {
			courseList = courseDAO.getCourseName(condition);
			httpSession.setAttribute("courseList",courseList);
			System.out.println(courseList);
			System.out.println("cla");
			return new ModelAndView(new RedirectView("/onlineSC/student/selCourse.jsp"));
			
		}else if(serc.equals("col")) {
			courseList = courseDAO.getCourseCol(condition);
			httpSession.setAttribute("courseList",courseList);
			System.out.println(courseList);
			System.out.println("col");
			return new ModelAndView(new RedirectView("/onlineSC/student/selCourse.jsp"));
			
		}else if(serc.equals("type")) {
			courseList = courseDAO.getCourseType(condition);
			httpSession.setAttribute("courseList",courseList);
			System.out.println(courseList);
			System.out.println("pro");
			return new ModelAndView(new RedirectView("/onlineSC/student/selCourse.jsp"));
			
		}else {
			
			courseList = courseDAO.getAllCourse();
			httpSession.setAttribute("courseList",courseList);
			System.out.println(courseList);
			return new ModelAndView(new RedirectView("/onlineSC/student/selCourse.jsp"));
	
		}
	
	    
	}
	
	@RequestMapping(value="/selcou/{cid}",method=RequestMethod.GET)
	public String selCou(@PathVariable(value="cid") String cid,Model model) {

		CourseDAO courseDAO = new CourseDAO();
		Teacher teacher =new Teacher();
		Course course = new Course();
		
		
		if(courseDAO.selectedCourse(cid)) {
			
			teacher = courseDAO.selTeaByCid(cid);
			courseDAO.getCourseCid(cid);
			model.addAttribute("tname", teacher.getTname());
			model.addAttribute("inroduction", teacher.getIntroduction());
			course = courseDAO.getCouCid(cid);
			model.addAttribute("cname", course.getCname());
			model.addAttribute("cid", cid);
			return "student/seling";
					
		}else {
			
			
			
			course = courseDAO.getCouCid(cid);
			model.addAttribute("cname", course.getCname());
			model.addAttribute("cid", cid);
			return "student/noseling";
		}
		
			
       
		
	}
  
    /*
     * 确定选课
     */
	@RequestMapping("/seling")
	public ModelAndView confirmSelect(@RequestParam("cid") String cid,@RequestParam("sid") String sid,Model model) {
		CourseDAO courseDAO = new CourseDAO();
		
		if (courseDAO.selectCourse(cid, sid)) {
            System.out.println(cid);
            System.out.println(sid);
            return new ModelAndView(new RedirectView("../success.jsp"));
        } else {
        	return new ModelAndView(new RedirectView("../fail.jsp"));
        }
		
	}
	
	/*
	 * 取消选课
	 */
	@RequestMapping("/backseling/{cid}")
	public ModelAndView backConfirmSelect(@PathVariable(value="cid") String cid) {
		
            return new ModelAndView(new RedirectView("/onlineSC/StudentController/selqueryy"));
       
		
	}
	
	
	
	
	@RequestMapping(value="/selcouresult/{sid}",method=RequestMethod.GET)
    public String selcouresult(@PathVariable("sid") String sid,StuSelectResult ssr,Model model,HttpSession httpSession){

        SCDAO scDAO = new SCDAO();
        ArrayList<StuSelectResult> ssrList = new ArrayList<StuSelectResult>();
        ssrList = scDAO.getBysidSC(sid);
        httpSession.setAttribute("ssrList", ssrList);
        
        	return "student/selectedCourse";
        
        	
        
    }
    
	
	@RequestMapping(value="/exitchoose/{sid}",method=RequestMethod.GET)
    public String exitChoose(@PathVariable("sid") String sid,StuSelectResult ssr,Model model,HttpSession httpSession){

        SCDAO scDAO = new SCDAO();
        ArrayList<StuExitSelect> sesList = new ArrayList<StuExitSelect>();
        sesList = scDAO.getExitBysid(sid);
        httpSession.setAttribute("sesList", sesList);
        
        	return "student/exitSel";  	
        
    }
	
	@RequestMapping(value="/exitsel/{cid}/{sid}",method=RequestMethod.GET)
    public ModelAndView exitSel(@PathVariable("cid") String cid,@PathVariable("sid") String sid){

        SCDAO scDAO = new SCDAO();
        if(scDAO.deleteSC(cid)) {
        	return new ModelAndView(new RedirectView("/onlineSC/StudentController/exitchoose/{sid}"));
        }else {
        	return new ModelAndView(new RedirectView("../fail.jsp"));
        }        	
        
    }
	
	
	
}
