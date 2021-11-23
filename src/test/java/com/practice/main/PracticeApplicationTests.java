package com.practice.main;

import com.practice.dao.Member;
import com.practice.service.MemberService;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class PracticeApplicationTests {

    @Autowired
    private MemberService memberService;

    @Test
    void contextLoads() {
        log.info("findAll result : " +memberService.findAll());
        log.info("findMemberInfo result : " +memberService.findMemberInfo("1"));
        //log.info("findMemberInfo result : " +memberService.findMemberInfo("hello"));
        log.info("getMemberInfo result : " +memberService.getMemberInfo("ok4242"));

        Member member = new Member();
        member.setUserId("ok4243");
        member.setUserStatus("H");
        log.info("join result : " +memberService.join(member));
    }

}
