package com.joel.logistics.config;

import com.joel.logistics.repository.RoleRepository;
import com.joel.logistics.role.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner loadRoles(RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.count() == 0) {
                roleRepository.save(new Role(null, "CUSTOMER"));
                roleRepository.save(new Role(null, "DELIVERY_PARTNER"));
                roleRepository.save(new Role(null, "ADMIN"));
            }
        };
    }
}
