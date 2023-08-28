package deadCow5.deadCow5.member.api;


import deadCow5.deadCow5.member.dto.MemberDto;
import deadCow5.deadCow5.member.entity.Member;
import deadCow5.deadCow5.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/{memberId}")
    public ResponseEntity<MemberDto> getMember(@PathVariable Long memberId) {
        MemberDto member = memberService.getMember(memberId);
        return ResponseEntity.ok(member);

    }


    @PostMapping("/member")
    public ResponseEntity<Void> createMember(@RequestBody @Valid MemberDto requestDto) {
        memberService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
