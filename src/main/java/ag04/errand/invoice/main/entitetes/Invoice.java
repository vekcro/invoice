package ag04.errand.invoice.main.entitetes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.validation.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
@Entity
public
class Invoice {

	

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
long id;
public void setId(long l) {
	this.id = l;
}


@Column(name="date_time")
String date_time;
@Size(min=32,max=255, message="* Minimum size is 32 characters, maximum 255")
String svrha_unosa;
public void setSvrha_unosa(String svrha_unosa) {
	this.svrha_unosa = svrha_unosa;
}


public void setUser_name(String user_name) {
	this.user_name = user_name;
}


String user_name;


public Invoice(){}


public Invoice(String svrha_unosa, String user_name)
{
	this.svrha_unosa=svrha_unosa;
	this.user_name= user_name;
}


public long getId() {
	return id;
}


public String getDate_time() {
	return date_time;
}


public String getSvrha_unosa() {
	return svrha_unosa;
}


public String getUser_name() {
	return user_name;
}



}
