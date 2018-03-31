package com.DelhiLabourWebAppAdmin.repository;

import com.DelhiLabourWebAppAdmin.model.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author abhishekjain on 31/3/18.
 */

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs,Integer> {
}
