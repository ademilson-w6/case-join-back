package com.join.tecnologia.case_join.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@Slf4j
public class JpaAuditingConfiguration {

    @Autowired
    private SpringSecurityAuditorAware springSecurityAuditorAware;

    @Bean
    public AuditorAware<String> auditorProvider() {
        return springSecurityAuditorAware;
    }

}