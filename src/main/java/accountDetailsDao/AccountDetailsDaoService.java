package accountDetailsDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ambit.pojos.AccountDetails;
import com.ambit.pojos.Address;
import com.ambit.pojos.CurrentMeterRead;
import com.ambit.pojos.Customer;
import com.ambit.pojos.PreviousMeterRead;

@Component
public class AccountDetailsDaoService {

	private static List<AccountDetails> account = new ArrayList<AccountDetails>();
	
	private static List<String> str = new ArrayList<String>();

	private static int meternumCount = 103;

	private static int customerCount = 3;

	// private static List<Customer> customersList = new ArrayList<Customer>();

	static {

		account.add(new AccountDetails(101, 70, "jhfh", new PreviousMeterRead(new Date(), 87860),
				new CurrentMeterRead(new Date(), 65945), 4046, 8787, 788,
				new Customer(1, new Address("7200 preston rd", 1812, "plano", "texas", 75024))));

		account.add(new AccountDetails(102, 78, "jhfh", new PreviousMeterRead(new Date(), 87890),
				new CurrentMeterRead(new Date(), 6545), 4546, 787, 788,
				new Customer(2, new Address("7200 preston rd", 1812, "plano", "texas", 75024))));

		account.add(new AccountDetails(103, 5609, "fjhgh", new PreviousMeterRead(new Date(), 9900),
				new CurrentMeterRead(new Date(), 78), 665, 898, 45,
				new Customer(3, new Address("9200 preston rd", 1912, "plano", "texas", 70024))));

	}

	public List<AccountDetails> findAll() {
		Collections.sort(account);
		return account;
	}

	public AccountDetails findOne(int id) {
		for (AccountDetails accountdetails : account) {
			if (accountdetails.getCustomer().getCustomerId() == id) {
				return accountdetails;
			}
		}

		return null;
	}

	public AccountDetails save(AccountDetails accountdetails) {
		if (accountdetails.getCustomer().getCustomerId() == 0) {

			accountdetails.getCustomer().setCustomerId(++customerCount);
			accountdetails.setMeterNumber(++meternumCount);

		}
		account.add(accountdetails);
		return accountdetails;

	}

	public AccountDetails deleteById(int customerId) {
		Iterator<AccountDetails> iterator = account.iterator();

		while (iterator.hasNext()) {

			AccountDetails account = iterator.next();

			if (account.getCustomer().getCustomerId() == customerId) {
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
			if (oldAccount.getCustomer().getCustomerId() == accountDetails.getCustomer().getCustomerId()) {
				account.remove(oldAccount);
				account.add(accountDetails);
			}

		}
		return accountDetails;

	}

}
