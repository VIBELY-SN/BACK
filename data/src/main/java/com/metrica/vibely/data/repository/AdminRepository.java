package com.metrica.vibely.data.repository;

import com.metrica.vibely.data.entity.Admin;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, java.util.UUID> {


    /**
     * Find a user by its username.  
     *
     * @param username the unique username
     * @return the user if exist
     */
	@Query("SELECT a FROM Admin a WHERE a.username = :username")
	Optional<Admin> findByAdminUsername(@Param("username") String username);

    /** 
     * Find a user by its username.
     *
     * @param username the unique username
     * @return the user if exist
     */ 
	@Query("SELECT a FROM Admin a WHERE a.email = :email")
    Optional<Admin> findByEmail(@Param("email")String email);

	@Query("SELECT a FROM Admin a WHERE a.userId = :userId")
    Optional<Admin> findById(@Param("userId")String userId);     
	
    /**
     * @param username
     * @throws NoSuchElementException
     */
	@Query("SELECT a FROM Admin a WHERE a.username = :username")
	void deleteAdminByUsername(@Param("username")String username);
	
	
    @Query("SELECT a.apikey FROM Admin a WHERE a.userId=:id")
    Optional<String> findApikeyByUserId(UUID id);
}

