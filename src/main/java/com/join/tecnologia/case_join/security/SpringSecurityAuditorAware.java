package com.join.tecnologia.case_join.security;

import com.join.tecnologia.case_join.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        Object principal = authentication.getPrincipal();
        String username;

        if (principal instanceof Usuario) {
            Usuario usuario = (Usuario) principal;
            username = usuario.getName();
        } else {
            username = authentication.getName();
        }

        return Optional.ofNullable(username);
    }

}