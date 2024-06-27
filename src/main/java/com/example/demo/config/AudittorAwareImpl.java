package com.example.demo.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AudittorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.empty();
    }
}