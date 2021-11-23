package com.practice.service;

import com.practice.dao.Member;
import java.util.List;
import java.util.Optional;

/**
 * @author : thewayhj
 * @description: Member Service
 */
public interface MemberService {

    public List<Member> findAll();

    public Optional<Member> findMemberInfo(String userNo);

    public Member getMemberInfo(String userId);

    public Member join(Member member);

    public Member modify(String userNo, Member member);

    public void delete(String userNo);
}
