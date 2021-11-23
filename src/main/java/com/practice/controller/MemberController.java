package com.practice.controller;

import com.practice.dao.Member;
import com.practice.service.MemberService;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping(value = "/list")
    public List<Member> userList() {
        return memberService.findAll();
    }

    @GetMapping(value = "/{userNo}")
    public Optional<Member> getUserNoInfo(@PathVariable("userNo") String userNo) {
        return memberService.findMemberInfo(userNo);
    }

    @GetMapping(value = "/{userId}")
    public Member getUserIdInfo(@PathVariable("userId") String userId) {
        return memberService.getMemberInfo(userId);
    }

    @PostMapping(value = "")
    public Member join(Member member) {
        return memberService.join(member);
    }

    @PutMapping(value = "/{userNo}")
    public Member modify(@PathVariable("userNo") String userNo, @RequestBody Member member) {
        return memberService.modify(userNo, member);
    }

    @DeleteMapping(value = "/{userNo}")
    public void delete(@PathVariable("userNo") String userNo) {
        memberService.delete(userNo);
    }
}
