package com.jsyang.springSecurityTest.repository;


import com.jsyang.springSecurityTest.domain.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffEntity,Integer> {
    StaffEntity findByLoginId(String loginId);
}
