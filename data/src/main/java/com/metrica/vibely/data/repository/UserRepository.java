package com.metrica.vibely.data.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.metrica.vibely.data.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, java.util.UUID> {

	/**
	 * @param username
	 * @return
	 * @throws NoSuchElementException
	 */
	Optional<User> findByUsername(String username);

	/**
	 * @param email
	 * @return
	 * @throws NoSuchElementException
	 */
	Optional<User> findByEmail(String email);

	/**
	 *
	 * @param id
	 * @return
	 */
	@Query("SELECT u.apikey FROM User u WHERE u.userId=:id")
	Optional<String> findApikeyByUserId(UUID id);

	/**
	 * @param username
	 * @throws NoSuchElementException
	 */
	void deleteByUsername(String username);
}



