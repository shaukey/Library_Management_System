package com.project.library_mangement_system.repository;

import com.project.library_mangement_system.model.Issue;
import com.project.library_mangement_system.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
    public List<Issue> findByReturned(Integer returned);
    public Long countByMemberAndReturned(Member member, Integer returned);
}
