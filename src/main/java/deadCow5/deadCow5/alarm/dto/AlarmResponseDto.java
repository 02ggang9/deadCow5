package deadCow5.deadCow5.alarm.dto;

import deadCow5.deadCow5.alarm.entity.Alarm;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@Getter
@Builder
public class AlarmResponseDto {

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private String url;

    @NotNull
    private LocalDateTime localDateTime;


    public static AlarmResponseDto from(Alarm alarm) {
        return AlarmResponseDto.builder()
                .title(alarm.getTitle())
                .content(alarm.getTitle())
                .url(alarm.getUrl())
                .build();

    }
}
