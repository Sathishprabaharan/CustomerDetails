package CustomerMS.assignment.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import CustomerMS.assignment.entity.Address;
import CustomerMS.assignment.entity.Customer;

@Service
public interface CustomerService {

	public String addNewCustomer(Customer cust) throws SQLException;
	public List<Customer> getAllCustomers() throws SQLException;
	public Optional<Customer> getCustomerByID(String id)throws SQLException;
	public List<Customer> searchCustomer(String firstName, String lastName) throws SQLException;
	public String updateAddress(Address address,String id) throws SQLException;

}
