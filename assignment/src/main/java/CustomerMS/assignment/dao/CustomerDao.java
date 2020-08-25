package CustomerMS.assignment.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import CustomerMS.assignment.entity.Customer;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer> {

	List<Customer> findByFirstNameInOrLastNameIn(String firstName, String lastName);

}
