package CustomerMS.assignment.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import CustomerMS.assignment.commom.Constants;
import CustomerMS.assignment.entity.Address;
import CustomerMS.assignment.entity.Customer;

import CustomerMS.assignment.service.CustomerService;

@RestController
public class CustomerController {
	private static org.slf4j.Logger log = LoggerFactory.getLogger(CustomerController.class) ;

	
	@Autowired
	CustomerService custService;
	
	@PostMapping("/customer/new-customer")
	public ResponseEntity addNewCustomer(@RequestBody Customer cust) throws Exception{
		log.info("Method::addNewCustomer");
		String returnString ="";
		HttpStatus httpStatus = null;
		String insertResult = custService.addNewCustomer(cust);
		if(Constants.CUSTOMER_ADDED.equalsIgnoreCase(insertResult)) {
			returnString ="Customer Added Succesfully";
			httpStatus = HttpStatus.CREATED;
		}
		return new ResponseEntity(returnString, httpStatus);
	}
	
	@GetMapping("/customer/all-customers")
	public ResponseEntity getAllCustomers() throws SQLException {
		log.info("Method::getAllCustomers");
		List customerList = custService.getAllCustomers();
		return new ResponseEntity( customerList, HttpStatus.OK);
	}
	
	@GetMapping("/customer/customer/{id}")
	public ResponseEntity getCustomer(@PathVariable ("id") String id) throws SQLException {
		log.info("Method::getCustomer");
		Optional<Customer> cust = custService.getCustomerByID(id);
		return new ResponseEntity( cust, HttpStatus.OK);
	}
	
	@GetMapping("/customer/customer-availability")
	public ResponseEntity searchCustomer(@RequestParam (name="firstname",required=false) String firstName  ,
			@RequestParam(name="lastname",required = false) String lastName) throws SQLException{
		log.info("Method::searchCustomer");		
		List<Customer> customerList= null;
		HttpStatus httpStatus=null;
		if(StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)) {
			httpStatus = HttpStatus.BAD_REQUEST;
		}else {
			customerList = custService.searchCustomer(firstName,lastName);
			httpStatus = HttpStatus.OK;
		}
		return new ResponseEntity( customerList, httpStatus);
	}
	
	@PutMapping("/customer/{custId}/alter-address")
	public ResponseEntity updateAddress(@PathVariable ("custId")String custId ,@RequestBody Address addr) throws SQLException {
		log.info("Method::updateAddress"+custId);
		String returnString ="";
		HttpStatus httpStatus = null;
		String insertResult = custService.updateAddress(addr, custId);
		if(Constants.CUSTOMER_UPDATED.equalsIgnoreCase(insertResult)) {
			returnString ="Customer Updated Succesfully";
			httpStatus = HttpStatus.CREATED;
		}
		return new ResponseEntity(returnString, httpStatus);
	}
	
	
	
	
}
