package com.practice.controller;

import com.practice.dao.Member;
import com.practice.repository.MemberRepository;
import com.practice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author : thewayhj
 * @description: Member Controller
 */
@RestController
@RequestMapping(value = "/api/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Member> userList() {
        return memberService.findAll();
    }

    @RequestMapping(value = "/info/{userId}", method = RequestMethod.GET)
    public Optional<Member> userInfo(@PathVariable("userId") int userId) {
        return memberService.findMemberInfo(userId);
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public Member join(Member member) {
        return memberService.join(member);
    }
}
