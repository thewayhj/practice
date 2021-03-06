package com.practice.repository;

import com.practice.dao.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Query("SELECT M FROM Member AS M WHERE M.userId=:userId")
    Member getMemberInfo(@Param("userId") String userId);
}
