package deadCow5.deadCow5.alarm.service;

import deadCow5.deadCow5.alarm.dto.AlarmRequestDto;
import deadCow5.deadCow5.alarm.dto.AlarmResponseDto;
import deadCow5.deadCow5.alarm.entity.Alarm;
import deadCow5.deadCow5.alarm.repository.AlarmRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class MessageService {

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;
    private final AlarmRepository alarmRepository;

    /**
     * Queue로 메시지를 발행
     *
     * @param messageDto 발행할 메시지의 DTO 객체
     */
    public void sendMessage(AlarmRequestDto messageDto) {
        log.info("message sent: {}", messageDto.toString());

        rabbitTemplate.convertAndSend(exchangeName, routingKey, messageDto);
    }

    /**
     * Queue에서 메시지를 구독
     *
     * @param messageDto 구독한 메시지를 담고 있는 MessageDto 객체
     */
    @Async
    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void receiveMessage(AlarmRequestDto messageDto) {
        alarmRepository.save(Alarm.builder()
                .title("Message Title")
                .content(UUID.randomUUID().toString())
                .url("Message URL")
                .memberId(messageDto.getMemberId())
                .build());
        log.info("Received message: {}", messageDto.toString());

    }

    public AlarmResponseDto getAlarm(long alarmId) {
        Alarm alarm = alarmRepository.findById(alarmId).orElseThrow();
        return AlarmResponseDto.from(alarm);
    }

}
