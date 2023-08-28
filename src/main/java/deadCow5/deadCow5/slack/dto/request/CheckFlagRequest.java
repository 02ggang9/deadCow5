package deadCow5.deadCow5.slack.dto.request;

import deadCow5.deadCow5.member.entity.Member;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CheckFlagRequest {

  @NotNull(message = "CTF 문제의 ID 값을 입력해주세요.")
  private Integer flagId;

  @NotEmpty(message = "CTF 문제의 FLAG 값을 입력해주세요.")
  private String flag;
}
