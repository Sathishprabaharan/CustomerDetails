package CustomerMS.assignment.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CustomerMS.assignment.commom.Constants;
import CustomerMS.assignment.dao.CustomerDao;
import CustomerMS.assignment.entity.Address;
import CustomerMS.assignment.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao custDao;
	
	@Override
	public String addNewCustomer(Customer cust) throws SQLException {
		custDao.save(cust);
		return Constants.CUSTOMER_ADDED;
	}

	@Override
	public List<Customer> getAllCustomers() throws SQLException {
		return (List<Customer>) custDao.findAll();
	}

	@Override
	public Optional<Customer> getCustomerByID(String id) throws SQLException {	
		Optional<Customer> cust = custDao.findById(Integer.parseInt(id));
		return cust;
	}

	@Override
	public List<Customer> searchCustomer(String firstName, String lastName) throws SQLException {
		List<Customer> customerList = custDao.findByFirstNameInOrLastNameIn(firstName,lastName);
		return customerList;
	}

	@Override
	public String updateAddress(Address address, String id) throws SQLException {
		Optional<Customer> cust = custDao.findById(Integer.parseInt(id));
		if(cust.isPresent()) {
			Customer c = cust.get();
			c.setAddress(address);
			custDao.save(c);
		}
		return Constants.CUSTOMER_UPDATED;
	}
	

}
