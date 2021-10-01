package com.ambit.project.ambit_energy.accountDetailsDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ambit.project.ambit_energy.accountDetailsDao.model.AccountDetails;
@Repository
public interface AmbitJpaRep extends JpaRepository<AccountDetails, Integer> {

}
