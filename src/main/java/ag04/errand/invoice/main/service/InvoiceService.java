package ag04.errand.invoice.main.service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import ag04.errand.invoice.main.entitetes.InvoiceDao;
import ag04.errand.invoice.main.entitetes.User;
import ag04.errand.invoice.main.entitetes.Invoice;
import ag04.errand.invoice.main.entitetes.UserDao;

@Service
@ComponentScan
public class InvoiceService implements IInvoiceService {
	
	

	
	long auto_incr=0;
	
	  @Autowired
	  private UserDao userDao;
 

	  @Autowired
	  private InvoiceDao invoiceDao;
	  
@Override
public User getUser(String username) {
	return  userDao.findByUserName(username);
}

@Override
public Iterable<Invoice> getListOffInvoice() {
	
	return invoiceDao.findAll();
}

@Override
public void insertNewInvoice(Invoice invoice) {
	
	invoiceDao.save(invoice);
	auto_incr = invoice.getId();
}

@Override
public long getCurrentAuto_INCR() {
	
	return auto_incr+1;
}


   
	
	
}
