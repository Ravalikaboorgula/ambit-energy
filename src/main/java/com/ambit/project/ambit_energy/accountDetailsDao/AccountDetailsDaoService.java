package com.ambit.project.ambit_energy.accountDetailsDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ambit.project.ambit_energy.pojos.AccountDetails;

@Component
public class AccountDetailsDaoService {

	private static List<AccountDetails> account = new ArrayList<AccountDetails>();

	private static List<String> str = new ArrayList<String>();

	private static int meternumCount = 103;

	// private static List<Customer> customersList = new ArrayList<Customer>();

	//static {

		//account.add(new AccountDetails(101, 70, "jhfh", 4046, 8787, 788, 56464, "hello"));

		//account.add(new AccountDetails(102, 78, "jhfh", 4546, 787, 788, 56765, "ewrwe"));

		//account.add(new AccountDetails(103, 5609, "fjhgh", 665, 898, 45, 6586778, "sdfsdf"));

	//}

	public List<AccountDetails> findAll() {
		Collections.sort(account);
		return account;
	}

	public AccountDetails findOne(int id) {
		for (AccountDetails accountdetails : account) {
			if (accountdetails.getMeterNumber() == id) {
				return accountdetails;
			}
		}

		return null;
	}

	public AccountDetails save(AccountDetails accountdetails) {
		if (accountdetails.getMeterNumber() == 0) {

			accountdetails.setMeterNumber(++meternumCount);

		}
		account.add(accountdetails);
		return accountdetails;

	}

	public AccountDetails deleteById(int customerId) {
		Iterator<AccountDetails> iterator = account.iterator();

		while (iterator.hasNext()) {

			AccountDetails account = iterator.next();

			if (account.getMeterNumber() == customerId) {
				iterator.remove();

				return account;
			}

		}
		return null;

	}

	// 1 john smith dallas tx Edit
	// 1 johnson smith plano tx Submit
	public AccountDetails updateAccount(AccountDetails accountDetails) {
		for (AccountDetails oldAccount : account) {
			if (oldAccount.getMeterNumber() == accountDetails.getMeterNumber()) {
				account.remove(oldAccount);
				account.add(accountDetails);
			}

		}
		return accountDetails;

	}

}
