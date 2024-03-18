package client;


public class Client {
	private String id;
	private String name;
	private String phoneNumber;
	private String emailAddress;
	
//Default constructor
public Client() {
	}

//Parameterized constructor
public Client(String id, String name, String phoneNumber, String emailAddress) {
    this.id = id;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
}

//Copy constructor
public Client(Client copy) {
	this.id = copy.id;
	this.name = copy.name;
	this.phoneNumber = copy.phoneNumber;
	this.emailAddress = copy.emailAddress;
}

//Accessors 
public String getId() {
	return this.id;
}
public String getName() {
	return this.name;
}
public String getPhonenumber() {
	return this.phoneNumber;
}
public String getEmailaddress() {
	return this.emailAddress;
}

//Mutators
public void setId(String id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
}

//toString method
@Override
public String toString() {
	return "Client ID: " + id + "\n Name: " + name + "\n Phone Number: " + phoneNumber + "\n Email: " + emailAddress;
}

//equals method
@Override
public boolean equals(Object obj) {
	if (obj == null || getClass() != obj.getClass())
        return false;
	else {
    Client client = (Client) obj;
    return this.name.equals(client.name) && this.phoneNumber.equals(client.phoneNumber) && this.emailAddress.equals(client.emailAddress);
}
}
}

