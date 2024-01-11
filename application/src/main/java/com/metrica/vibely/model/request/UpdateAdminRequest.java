package com.metrica.vibely.model.request;

import com.metrica.vibely.data.model.dto.AdminDTO;

import jakarta.validation.constraints.Pattern;

public class UpdateAdminRequest {

    // <<-FIELDS->>
    private String username;
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]{12,}$")
    private String password;
    private String nickname;
    private String email;

    // <<-CONSTRUCTOR->>
    public UpdateAdminRequest() {
    }

    // <<-METHODS->>
    public AdminDTO toDTO() {
        AdminDTO adminDTO = new AdminDTO();

        adminDTO.setUsername(this.username);
        adminDTO.setPassword(this.password);
        adminDTO.setNickname(this.nickname);
        adminDTO.setEmail   (this.email);

        return adminDTO;
    }

    // <<-GETTERS & SETTERS->>
    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

}