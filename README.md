# CustomerDetails
CRUD Opeartion Assignment.


Post Url:
Inserting Customer::
http://localhost:8800/customer/new-customer
Payload:
{
"firstName":"Sam",
"lastName":"Sammy",
"age" :25,
"address" : {
    "addressLine1" : "Flat No 1 , ABC aprt , A cross",
    "addressLine2" : "Xyz Nagar, Bangalore",
    "zipcode"      : "560093"
}
}

============================================================
Get Urls:
Search All Customer- 
http://localhost:8800/customer/all-customers

Search Customer by ID- 
http://localhost:8800/customer/customer/{id}

Search Customer by FirstName or LastName:
http://localhost:8800/customer/customer-availability?firstname=Sathish&lastname=Sammy


===============================================================
Put url:
Update Customer Address:
http://localhost:8800/customer/{custID}/alter-address

Payload:
{
    "addressLine1" : "Flat No 3 , CBA aprt , C cross",
    "addressLine2" : "ZYX Nagar, Bangalore",
    "zipcode"      : "560093"
}

===================================================================
To Monitor in Prod (Basic Functionality): 
http://localhost:8800/actuator/health
