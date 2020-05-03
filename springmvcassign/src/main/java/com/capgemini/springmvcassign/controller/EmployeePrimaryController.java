package com.capgemini.springmvcassign.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.springmvcassign.bean.EmployeePrimary;
import com.capgemini.springmvcassign.service.EmployeePrimaryService;


@Controller
public class EmployeePrimaryController {
	@Autowired
	private EmployeePrimaryService service;
	

	@GetMapping("/loginForm")
	public String getloginForm() {
		return "login";
	}

	@PostMapping("/login")
	public String authenticate(int id, String password, HttpServletRequest request) {
		EmployeePrimary employeeInfoBean = service.authenticate(id, password);
		if(employeeInfoBean != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("loggedEmployeeInfo", employeeInfoBean);
			return "home";
		}else {
			request.setAttribute("errMsg", "Invalid Credentials");
			return "login";
		}
	}

	@GetMapping("/home")
	public String home(HttpSession session, ModelMap modelMap) {
		if(session.getAttribute("loggedEmployeeInfo") != null) {
			return "home";
		}else {

			modelMap.addAttribute("errMsg", "Please Login to Access this Page!!");
			return "login";
		}

	}

	@GetMapping("/getEmployeeForm")
	public String getEmployeeForm(HttpSession session, ModelMap modelMap) {
		if(session.getAttribute("loggedEmployeeInfo") != null) {
			return "search";
		}else {
			
			modelMap.addAttribute("errMsg", "Please First Login!!");
			return "login";
		}
	}
	@GetMapping("/getEmployee")
	public String getEmployee(int id,ModelMap map, HttpSession session) {
		if(session.getAttribute("loggedEmployeeInfo") != null) {
			EmployeePrimary employeeInfoBean = service.getEmployee(id);
			if(employeeInfoBean != null) {
				map.addAttribute("employeeInfo", employeeInfoBean);
			}else {
				map.addAttribute("errmsg","Employee Id Not Found");
			}
			return "search";
		}else {
			map.addAttribute("errMsg", "Please login First!!");
			return "login";
		}
	}

	@GetMapping("/addEmployeeForm")
	public String addEmployeeForm(HttpSession session, ModelMap modelMap) {
		if(session.getAttribute("loggedEmployeeInfo") != null) {
			return "addEmployeeForm";
		}else {
			
			modelMap.addAttribute("errMsg", "Please First Login!!");
			return "login";
		}
	}

	@PostMapping("/addEmployee")
	public String addEmployee(EmployeePrimary employeeInfoBean,ModelMap map, HttpSession session) {
		if(session.getAttribute("loggedEmployeeInfo") != null) {
			System.out.println(employeeInfoBean.getId());
			boolean isAdded = service.addEmployee(employeeInfoBean);
			if(isAdded) {
				map.addAttribute("done","SucessFully added to the table");
			}else {
				map.addAttribute("notDone", "Unscessfull add to the table");
			}
			return "status";
		}else {
			map.addAttribute("errMsg", "Please login First!!");
			return "login";
		}
	}

	@GetMapping("/deleteEmployeeForm")
	public String deleteEmployeeForm(HttpSession session, ModelMap modelMap) {

		if(session.getAttribute("loggedEmployeeInfo") != null) {
			return "delete";
		}else {
			
			modelMap.addAttribute("errMsg", "Please First Login!!");
			return "login";
		}
	}
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(int id,ModelMap map,HttpSession session) {
		if(session.getAttribute("loggedEmployeeInfo") != null) {
			boolean isDeleted = service.deleteEmployee(id);
			if(isDeleted) {
				map.addAttribute("done", "Successfully Deleted ");
			}else {
				map.addAttribute("Not Done", "Not Deleted");
			}
			return "status";
		}
		else {
			map.addAttribute("errMsg", "Please login First!!");
			return "login";
		}

	}

	@GetMapping("/updateEmployeeForm")
	public String updateEmployeeForm(HttpSession session,ModelMap modelMap) {
		if(session.getAttribute("loggedEmployeeInfo")!= null) {
			return "update";
		}
	
		modelMap.addAttribute("errMsg", "Please Login First!!");
		return "login";
	}

	@PostMapping("/updateEmployee")
	public String updateEmployee(EmployeePrimary employeeInfoBean,ModelMap map, HttpSession session) {
		if(session.getAttribute("loggedEmployeeInfo") != null) {
			boolean isUpdated = service.updateEmployee(employeeInfoBean);
			if(isUpdated) {
				map.addAttribute("done", "Successfully Updated");
			}else {
				map.addAttribute("Not Done", "Not Updated");
			}
			return "status";
		}else {
			map.addAttribute("errMsg", "Please Login First!!!");
			return "login";
		}
	}

	@GetMapping("/allEmployeeDetails")
	public String allProductDetails(ModelMap map,HttpSession session) {
		if(session.getAttribute("loggedEmployeeInfo") != null) {
		List<EmployeePrimary> beanList = service.getAllEmployees();
		if(beanList.size()!=0) {
			map.addAttribute("beanList", beanList);
		}else {
			map.addAttribute("zero", "No Employees are There");
		}
		return "allEmployeeDetails";
		}else {
			map.addAttribute("errMsg", "Please Login First!!");
			return "login";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap modelMap) {
		session.invalidate();
		modelMap.addAttribute("errMsg", "You are logged out Successfully");
		return "login";
	}
}

