package deadCow5.deadCow5.alarm.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AlarmRequestDto {

    @NotNull(message = "Member의 PK값을 넣어주세요")
    private Long memberId;

    @NotNull(message = "어떤 종류의 알람을 만들지 알려주세요")
    private AlarmType alarmType;

}