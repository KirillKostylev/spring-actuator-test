package com.test.springactuatortest.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @Email
        String email,
        @NotBlank
        String phoneNumber) {
}
