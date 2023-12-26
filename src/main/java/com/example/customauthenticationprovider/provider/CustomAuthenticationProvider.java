package com.example.customauthenticationprovider.provider;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName= authentication.getName();
        String password= String.valueOf(authentication.getCredentials());
        if ("john".equals(userName) && "12345".equals(password)){
            return new UsernamePasswordAuthenticationToken(
                    userName,
                    password,
                    Arrays.asList()
            );
        }
        else
            throw new AuthenticationCredentialsNotFoundException("Login Error");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken
                .class
                .isAssignableFrom(authentication);
    }
}
