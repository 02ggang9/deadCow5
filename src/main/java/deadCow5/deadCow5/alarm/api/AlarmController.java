package deadCow5.deadCow5.alarm.api;

import deadCow5.deadCow5.alarm.dto.AlarmRequestDto;
import deadCow5.deadCow5.alarm.dto.AlarmResponseDto;
import deadCow5.deadCow5.alarm.repository.AlarmRepository;
import deadCow5.deadCow5.alarm.service.MessageService;
import deadCow5.deadCow5.member.repository.MemberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AlarmController {

    private final MessageService messageService;

    @PostMapping("/requestAlarm")
    public ResponseEntity<String> createAlarm(
            @RequestBody @Valid AlarmRequestDto requestDto
            ) {
        messageService.sendMessage(requestDto);
        return ResponseEntity.ok("Message sent to RabbitMQ");
    }

    @GetMapping("/search/{alarmId}")
    public ResponseEntity<AlarmResponseDto> searchAlarm(@PathVariable Long alarmId) {
        AlarmResponseDto alarm = messageService.getAlarm(alarmId);

        return ResponseEntity.ok(alarm);

    }

}
