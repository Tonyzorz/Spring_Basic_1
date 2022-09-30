package hello.core_20220927;

import hello.core_20220927.member.Grade;
import hello.core_20220927.member.Member;
import hello.core_20220927.member.MemberService;
import hello.core_20220927.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member member1 = memberService.findMember(1L);
        System.out.println(member.getName());
        System.out.println(member1.getName());
    }

}
