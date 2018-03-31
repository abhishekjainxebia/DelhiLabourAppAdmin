package com.DelhiLabourWebAppAdmin.repository;
import com.DelhiLabourWebAppAdmin.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author abhishekjain on 30/3/18.
 */

@Repository
public interface UserRepository extends JpaRepository<Admin,Integer> {

    //@Query("from register where unm=:username AND number=:number")
    Admin findByUsernameAndPassword(
            @Param("username") String username,
            @Param("password") String password);

}
