package com.DelhiLabourWebAppAdmin.repository;

import com.DelhiLabourWebAppAdmin.model.AnnualReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author abhishekjain on 31/3/18.
 */

@Repository
public interface AnnualReturnRepository extends JpaRepository<AnnualReturn,Integer>{

}
