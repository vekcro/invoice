package ag04.errand.invoice.main.entitetes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	@Id
	@Column(name="user_name")
	String userName;
	String password;
	String name;
	
	
	@Override
	public String toString() {
		return name;
	}
	
	
	
}
