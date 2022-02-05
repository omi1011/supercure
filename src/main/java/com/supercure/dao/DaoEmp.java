package com.supercure.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supercure.entity.Employee;

public interface DaoEmp extends JpaRepository<Employee, Long> {

	Employee getEmployeeByName(String name);
	
	Employee findEmployeeByMobileNoAndPassw(String mobileNo, String passw);
	

}
