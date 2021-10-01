package com.jsyang.springSecurityTest.service;

import com.jsyang.springSecurityTest.domain.StaffEntity;
import com.jsyang.springSecurityTest.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class StaffService implements UserDetailsService {

    private final StaffRepository staffRepository;
    private static final Logger logger = LoggerFactory.getLogger(StaffService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        StaffEntity staff = staffRepository.findByLoginId(username);
        return  new User(staff.getLoginId(), staff.getLoginPWD(), new ArrayList<>());
    }
}
