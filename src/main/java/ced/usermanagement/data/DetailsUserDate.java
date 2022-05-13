package ced.usermanagement.data;

import ced.usermanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DetailsUserDate implements UserDetails {

    private final Optional<User> optionalUser;

    @Autowired
    public DetailsUserDate(Optional<User> optionalUser) {
        this.optionalUser = optionalUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return optionalUser.orElse(new User()).getPassword();
    }

    @Override
    public String getUsername() {
        return optionalUser.orElse(new User()).getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
