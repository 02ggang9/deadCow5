package deadCow5.deadCow5.alarm.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class ResponseAlarmDto {

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private String url;

}
