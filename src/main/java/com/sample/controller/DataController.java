package com.sample.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.entity.CustomerData;
import com.sample.repo.DataRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class DataController {

	@Autowired(required = true)
	private DataRepository dataRepository;

	@GetMapping("/employees")
	public List<CustomerData> getAllEmployees(){
		return (List) dataRepository.findAll();
	}
	
	@RequestMapping(path = "/test",method = RequestMethod.GET)
	public String test(){
		return "Application Running....";
	}
	
	@PostMapping("/employees")
	public CustomerData createEmployee(@RequestBody CustomerData data) {
		return dataRepository.save(data);
	}
	
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<CustomerData> updateEmployee(@PathVariable Long id, @RequestBody CustomerData employeeDetails){
		Optional<CustomerData> employee1 = dataRepository.findById(id);
				//.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		CustomerData employee =employee1.get();
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());

		CustomerData updatedEmployee = dataRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);

	}
}
