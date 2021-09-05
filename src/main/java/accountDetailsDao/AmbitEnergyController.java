package accountDetailsDao;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ambit.pojos.AccountDetails;
import com.ambit.pojos.AccountNotFoundException;


@RequestMapping("/ambitEnergy")
@RestController
public class AmbitEnergyController 
{
	@Autowired
	private AccountDetailsDaoService service;
	
	
	@GetMapping(path="/allaccounts")
	public List<AccountDetails> getAllAccountDetails()
	{
		System.out.println("inside ");
		return service.findAll();
	}
	
	@GetMapping(path="/health")
	public String checkHealth()
	{
		return "health is ok";
	}
	
	@GetMapping(path="/singleaccount/{meterNumber}")
	public AccountDetails getOneAccountDetails(@PathVariable int meterNumber)
	{
		
		AccountDetails acc=service.findOne(meterNumber);
		
		if(acc==null)
		throw new AccountNotFoundException("meterNumber-"+ meterNumber)	;

	    return acc;
	}
	
	@PostMapping(path="/saveAccountdetails")
	public ResponseEntity<Object> saveAccountdetails(@RequestBody AccountDetails accountdetails)
	{
		AccountDetails acc=service.save(accountdetails);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{meterNumber}").buildAndExpand(acc.getMeterNumber()).toUri();
		
		
		return ResponseEntity.created(location).build();
		
		
	}
	
	
	@DeleteMapping(path="/deleteaccount/{customerId}")
	public void removeAccount(@PathVariable  int customerId)
	{

		AccountDetails account=service.deleteById(customerId);
		
		if(account==null)
			throw new AccountNotFoundException("customerId"+ customerId);
	}
	
	
	@PutMapping(path="/updateaccount")	
	public void update(@RequestBody AccountDetails accountDetails)
	{
		int customerId=accountDetails.getCustomer().getCustomerId();
		AccountDetails oldAccountdetails=service.findOne(customerId);
	
		if(oldAccountdetails==null)
		{
			throw new AccountNotFoundException("customerId" +customerId);
		}
		else{
			service.deleteById(oldAccountdetails.getCustomer().getCustomerId());
			service.save(accountDetails);
		}
	} 
	
	
	

}
