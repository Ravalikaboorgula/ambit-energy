package accountDetailsDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ambit.pojos.AccountDetails;
@Repository
public interface AmbitJpaRep extends JpaRepository<AccountDetails, Integer> {

}
