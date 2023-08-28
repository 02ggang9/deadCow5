package deadCow5.deadCow5.member.service;

import deadCow5.deadCow5.member.dto.MemberDto;
import deadCow5.deadCow5.member.entity.Member;
import deadCow5.deadCow5.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void save(MemberDto request) {
        memberRepository.save(Member.builder()
                        .name(request.getName())
                        .build());
    }

    public MemberDto getMember(long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        return MemberDto.from(member);

    }
}
