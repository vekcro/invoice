package ag04.errand.invoice.main.service;



import org.springframework.data.jpa.repository.Query;

import ag04.errand.invoice.main.entitetes.Invoice;
import ag04.errand.invoice.main.entitetes.User;
import antlr.collections.List;


public interface IInvoiceService  {

 public User getUser(String username);

 public Iterable<Invoice> getListOffInvoice();
 
 public void insertNewInvoice(Invoice invoice);

public long getCurrentAuto_INCR();

 
}
