package CustomerMS.assignment;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import CustomerMS.assignment.controller.CustomerController;
import CustomerMS.assignment.entity.Customer;
import CustomerMS.assignment.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration


public class CustomerControllerTest {

	
	@InjectMocks
	CustomerController controller;
	
	@Mock
	CustomerService service;
	
	@Before
	public void setInit() {
		// req initialisation goes here
	}
	
	@Test
	public void testaddNewCustomer() throws Exception{
		ResponseEntity res = controller.addNewCustomer(new Customer());
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		
		//equals(res.getStatusCode().equals("200"));
	}
	
	//Remainin test mtd goes here
	
}
