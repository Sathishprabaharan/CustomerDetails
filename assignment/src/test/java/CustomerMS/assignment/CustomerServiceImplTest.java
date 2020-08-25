package CustomerMS.assignment;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import CustomerMS.assignment.dao.CustomerDao;
import CustomerMS.assignment.entity.Customer;
import CustomerMS.assignment.service.CustomerServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)


public class CustomerServiceImplTest {

	
	
	@InjectMocks
	CustomerServiceImpl cust;
	
	@Mock
	CustomerDao dao;
	
	@Before
	public void setInit() {
		// req initialisation goes here
	}
	
	@Test
	public void testaddNewCustomer() throws Exception{
		String str = cust.addNewCustomer(new Customer());
		assertEquals("Customer-Inserted", str);
	}
	
	//Remainin test mtd goes here
	
}
