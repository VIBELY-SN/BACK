package com.metrica.vibely.data.repository;

import com.metrica.vibely.data.entity.Admin;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, java.util.UUID> {

}

