package CustomerMS.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	private String addressLine1;
	@Column
	private String addressLine2;
	@Column
	private String zipcode;
	
	@OneToOne(mappedBy = "address")
	private Customer cust;


public String getAddressLine1() {
	return addressLine1;
}
public void setAddressLine1(String addressLine1) {
	this.addressLine1 = addressLine1;
}
public String getAddressLine2() {
	return addressLine2;
}
public void setAddressLine2(String addressLine2) {
	this.addressLine2 = addressLine2;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getZipcode() {
	return zipcode;
}
public void setZipcode(String zipcode) {
	zipcode = zipcode;
}

}
