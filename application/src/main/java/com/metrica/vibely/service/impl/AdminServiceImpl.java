package com.metrica.vibely.service.impl;

import com.metrica.vibely.data.entity.Admin;
import com.metrica.vibely.data.model.dto.AdminDTO;
import com.metrica.vibely.data.model.enumerator.PrivacyType;
import com.metrica.vibely.data.model.enumerator.UserState;
import com.metrica.vibely.data.model.enumerator.UserStatus;
import com.metrica.vibely.data.model.mapper.AdminMapper;
import com.metrica.vibely.data.repository.AdminRepository;
import com.metrica.vibely.data.util.PasswordHasher;
import com.metrica.vibely.service.AdminService;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class AdminServiceImpl implements AdminService {
	
	 // ATRIBUTES
    private AdminRepository adminRepository;
    
    // CONSTRUCTOR
    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    
    // METHODS
    @Override
    public AdminDTO getById(UUID id) {
        Admin admin = this.adminRepository.findById(id).orElseThrow();
        
        if (admin.getState() != UserState.DISABLED)
            return AdminMapper.toDTO(admin);
        throw new NoSuchElementException();
    }

    @Override
    public AdminDTO getByUsername(String username) {
        Admin admin = this.adminRepository.findByUsername(username).orElseThrow();
        return AdminMapper.toDTO(admin);
    }

    @Override
    public AdminDTO getByEmail(String email) {
        Admin admin = this.adminRepository.findByEmail(email).orElseThrow();
        return AdminMapper.toDTO(admin);
    }
}
