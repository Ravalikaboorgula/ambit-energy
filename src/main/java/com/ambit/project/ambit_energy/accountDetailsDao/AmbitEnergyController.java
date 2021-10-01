package com.ambit.project.ambit_energy.accountDetailsDao;

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

import com.ambit.project.ambit_energy.accountDetailsDao.model.AccountDetails;
import com.ambit.project.ambit_energy.accountDetailsDao.model.AccountNotFoundException;

@RequestMapping("/ambitEnergy")
@RestController
public class AmbitEnergyController {
	@Autowired
	private AccountDetailsDaoService service;

	@Autowired
	private AmbitJpaRep ambitJpaRep;

	@GetMapping(path = "/allaccounts")
	public List<AccountDetails> getAllAccountDetails() {
		System.out.println("inside ");
		return service.findAll();
	}

	@GetMapping(path = "/health")
	public String checkHealth() {
		return "health is ok";
	}

	@GetMapping(path = "/singleaccount/{meter_Number}")
	public AccountDetails getOneAccountDetails(@PathVariable int meter_Number) {

		AccountDetails acc = service.findOne(meter_Number);

		if (acc == null)
			throw new AccountNotFoundException("meterNumber-" + meter_Number);

		return acc;
	}

	@PostMapping(path = "/saveAccountdetails")
	public ResponseEntity<Object> saveAccountdetails(@RequestBody AccountDetails accountdetails) {

		AccountDetails acc = service.save(accountdetails);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{meter_Number}")
				.buildAndExpand(acc.getMeterNumber()).toUri();

		return ResponseEntity.created(location).build();

	}

	@DeleteMapping(path = "/deleteaccount/{meter_Number}")
	public void removeAccount(@PathVariable int meter_Number) {

		AccountDetails account = service.deleteById(meter_Number);

		if (account == null)
			throw new AccountNotFoundException("meter_Number" + meter_Number);
	}

	@PutMapping(path = "/updateaccount")
	public void update(@RequestBody AccountDetails accountDetails) {
		int meter_Number = accountDetails.getMeterNumber();
		AccountDetails oldAccountdetails = service.findOne(meter_Number);

		if (oldAccountdetails == null) {
			throw new AccountNotFoundException("meter_Number" + meter_Number);
		} else {
			service.deleteById(oldAccountdetails.getMeterNumber());
			service.save(accountDetails);
		}
	}

	@PostMapping(path = "/oracle-insert")
	public void oracleInsert(@RequestBody AccountDetails accountDetails) {
		ambitJpaRep.save(accountDetails);
	}

	@DeleteMapping(path = "/oracle-delete/{meter_Number}")
	public void oracleDelete(@PathVariable int meter_Number) {
		ambitJpaRep.deleteById(meter_Number);
	}

	@GetMapping(path = "/oracle-getAllAccounts")
	public List<AccountDetails> getAllAccounts() {

		return ambitJpaRep.findAll();

	}

//	@GetMapping(path = "/oracle-getoneAccount/{meter_Number")
//	public List<AccountDetails> getAllAccounts() {
//
//		return ambitJpaRep.findAll();
//
//	}
	

}
