package com.project.library_mangement_system.model;

import com.project.library_mangement_system.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private IssueService issueService;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository=memberRepository;
    }

    public Long getTotalCount() {
        return memberRepository.count();
    }

    public Long getInstructorsCount() {
        return memberRepository.countByType(Constants.MEMBER_INSTRUCTOR);
    }

    public Long getStudentsCount() {
        return memberRepository.countByType(Constants.MEMBER_STUDENT);
    }

    public List<Member> getAll() {
        return memberRepository.findAllByOrderByFirstNameAscMiddleNameAscLastNameAsc();
    }

    public Member get(Long id) {
        return memberRepository.findById(id).get();
    }

    public Member addNew(Member member) {
        member.setJoiningDate( new Date() );
        return memberRepository.save( member );
    }

    public Member save(Member member) {
        return memberRepository.save( member );
    }

    public void delete(Member member) {
        memberRepository.delete(member);
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }
    public boolean hasUsage(Member member) {
        return issueService.getCountByMember(member) > 0;
    }
}
