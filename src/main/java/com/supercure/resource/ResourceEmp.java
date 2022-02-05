
package com.supercure.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supercure.dto.DtoEmp;
import com.supercure.dto.LoginDto;
import com.supercure.dto.ResponseDto;
import com.supercure.entity.Employee;
import com.supercure.service.ServiceEmp;
import com.supercure.utility.UserNotFoundException;
// 1. register employee
// 2. get all Employee
// 3. soft delete Employee
// 4. get deleted employee
// 5. login api 
@RestController
@RequestMapping("/employee")
public class ResourceEmp {
	ResponseDto response = new ResponseDto();
	@Autowired
	ServiceEmp service;
	@PostMapping("register")
	public ResponseDto registerEmployee(@RequestBody DtoEmp emp) {
//		if(!emp.getPassw().equalsIgnoreCase(emp.getConfirmPassw())) {
//			throw new RuntimeException("pass does not match");
//		}
	
		service.createEmp(emp);
		response.setMsg("Successfully registerd");
		return response;
	}
	

	@PostMapping("login")
	public ResponseDto loginEmployee(@RequestBody LoginDto login) {
		String empBy = service.getEmpByMobileNoAndPassw(login.getMobileNo(), login.getPassw());
		response.setMsg(empBy);
		return response;
	
	}
	
	@GetMapping("allemployee")
	public List<Employee> getAllemployee(){
		return service.getAllEmp();
	}
	
	@GetMapping("deleted/employee")
	public List<Employee> deletedemployee(){
		return service.getDeletedEmployee();
	}
	
	// soft delete employee
	@DeleteMapping("delete")
	public void deleteEmployee(@RequestBody Employee e){
		service.softDeleteEmp(e);
	}
	
	@PutMapping("update/employee")
	public String updateEmployee(@RequestBody DtoEmp emp) {
//		if(!emp.getPassw().equalsIgnoreCase(emp.getConfirmPassw())) {
//			throw new RuntimeException("pass does not match");
//		}
		service.createEmp(emp);
		return "Successfully registerd";
	}
	
	@GetMapping("getby/{id}")
	public Employee getById(@PathVariable("id") Long id) {
		return service.getEmpById(id); // does not give exception why
	}

	@GetMapping("getname/{name}")
	public Employee getById(@PathVariable("name") String name) {
		Employee byName = service.getByName(name);
		if (byName==null) {
			throw new UserNotFoundException("user with name " +name +" is not available ");
		}
		return service.getByName(name);
	}
	
	
}
