package de.tk.mastermind.service;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MongoUserDetailsService implements UserDetailsService {

    private final PlayerService playerService;

    @Override
    public UserDetails loadUserByUsername(String playername) throws UsernameNotFoundException {
        return playerService.findByPlayerName(playername)
                .map(player -> new User(player.getPlayername(), player.getPassword(), List.of()))
                .orElseThrow(() -> new UsernameNotFoundException(playername + " not found"));
    }
}