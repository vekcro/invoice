package ag04.errand.invoice.main;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ag04.errand.invoice.main.entitetes.Invoice;
import ag04.errand.invoice.main.entitetes.InvoiceDao;
import ag04.errand.invoice.main.entitetes.User;
import ag04.errand.invoice.main.service.IInvoiceService;

@org.springframework.stereotype.Controller
@ComponentScan
class Controller {

	@Autowired
	IInvoiceService invoiceService;
	
	String userDescription;
	
	@RequestMapping (value="/invoice",method=RequestMethod.GET)
	public String getInvoiceData(Principal principal, Model model)
	{
	// getting user description
		 userDescription = invoiceService.getUser(principal.getName()).toString();
		model.addAttribute("user", userDescription);
		
		
		Iterable<Invoice> listOfAllInvoice=  invoiceService.getListOffInvoice();
		
		model.addAttribute("invoices", listOfAllInvoice);
		
		return "home";
		
	}
	@RequestMapping( value="/invoice/new",method=RequestMethod.GET )
	public String getNewInvoicePage(Model model)
	{
		Invoice invoice = new Invoice();
		long autoIncr =(invoiceService.getCurrentAuto_INCR());
		model.addAttribute(invoice);
		model.addAttribute("user", userDescription);
		model.addAttribute("autoINCR", autoIncr);
		
		return "new";
	}
	@RequestMapping( value="/invoice/claimNew", method=RequestMethod.POST )
	public String claimNew(@Valid Invoice invoice, BindingResult bind,Principal principal,Model model)
	{
		if(bind.hasErrors())
		{
			model.addAttribute("autoINCR", invoiceService.getCurrentAuto_INCR());
			return "new";
		}
		invoice.setUser_name(principal.getName());
		invoiceService.insertNewInvoice(invoice);
		
		return "redirect:/invoice";
	}
}
