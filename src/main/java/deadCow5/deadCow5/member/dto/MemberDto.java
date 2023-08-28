package deadCow5.deadCow5.member.dto;

import deadCow5.deadCow5.member.entity.Member;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {

    @NotNull
    private String name;

    public static MemberDto from(Member member) {
        return MemberDto.builder()
                .name(member.getName())
                .build();
    }

}
