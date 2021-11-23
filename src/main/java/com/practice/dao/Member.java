package com.practice.dao;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "회원 번호")
    private int userNo;

    @Column(columnDefinition = "회원 아이디")
    private String userId;

    @Column(columnDefinition = "회원 상태")
    private String userStatus;
}
