package com.test.springactuatortest.user;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public User findById(@NonNull UUID id) {
        return getById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    private Optional<User> getById(UUID id) {
        return userRepository.findById(id);
    }

    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(@NonNull UserRequest userRequest) {
        final var user = User.builder()
                .email(userRequest.email())
                .phoneNumber(userRequest.phoneNumber())
                .build();

        ResponseEntity<String> forEntity = restTemplate.getForEntity("https://mock-test.free.beeceptor.com", String.class);
        log.info(forEntity.getBody());

        return userRepository.save(user);
    }

    public void deleteById(@NonNull UUID id) {
        findById(id);
        userRepository.deleteById(id);
    }
}
