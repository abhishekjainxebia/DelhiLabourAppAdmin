package com.DelhiLabourWebAppAdmin.repository;

import com.DelhiLabourWebAppAdmin.model.Centralized_Database;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author abhishekjain on 31/3/18.
 */
@Repository
public interface Centralized_DatabaseRepository extends JpaRepository<Centralized_Database,Integer> {
}
