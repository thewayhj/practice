package com.practice.service.Impl;

import com.practice.dao.Member;
import com.practice.repository.MemberRepository;
import com.practice.service.MemberService;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> findAll() { return memberRepository.findAll(); }

    public Optional<Member> findMemberInfo(String userNo) {
        if(BooleanUtils.isFalse(StringUtils.isNumeric(userNo)))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return memberRepository.findById(Integer.parseInt(userNo));
    }

    public Member getMemberInfo(String userId) { return memberRepository.getMemberInfo(userId);}

    public Member join(Member member) {
        return memberRepository.save(member);
    }

    public Member modify(String userNo, Member member) {
        member.setUserNo(Integer.parseInt(userNo));
        return memberRepository.save(member);
    }

    public void delete(String userNo) {
        if(StringUtils.isEmpty(userNo))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        memberRepository.deleteById(Integer.parseInt(userNo));
    }
}