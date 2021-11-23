package com.practice.service;

import com.practice.dao.Member;
import com.practice.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : thewayhj
 * @description: Member Service
 */
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Optional<Member> findMemberInfo(int userId) {
        return memberRepository.findById(userId);
    }

    public Member join(Member member) {
        return memberRepository.save(member);
    }
}
