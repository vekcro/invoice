package ag04.errand.invoice.main.entitetes;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface UserDao extends CrudRepository<User, Long>{
  public User findByUserName(String userName);
  
}
	