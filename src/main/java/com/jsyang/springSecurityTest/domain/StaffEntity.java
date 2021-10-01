package com.jsyang.springSecurityTest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="tb_staff")
public class StaffEntity {

    @Id @GeneratedValue
    @Column(name="STAFF_ID")
    private Integer staffId;

    @Column(name="LOGIN_ID")
    private String loginId;

    @Column(name="LOGIN_PWD")
    private String loginPWD;

    @Column(name = "APP_SERVICE")
    private String appService;

    @Column(name = "PUSH_TOKEN")
    private String pushToken;


    @Column(name="STAFF_POSITION")
    private String staffPosition;

    @Column(name="STAFF_NAME")
    private String staffName;

    @Column(name="STAFF_STATUS")
    private String staffStatus;
}
