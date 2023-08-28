package deadCow5.deadCow5.slack.api;

import deadCow5.deadCow5.member.entity.Member;
import deadCow5.deadCow5.slack.dto.request.CheckFlagRequest;
import deadCow5.deadCow5.slack.service.SlackService;
import jakarta.validation.Valid;
import jdk.jshell.Snippet.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/slack")
public class SlackController {

  private final SlackService slackService;

  Member member = Member.builder()
      .name("ggang9")
      .build();

  @PostMapping("/v1/flag")
  public ResponseEntity<Void> checkFlag(@RequestBody @Valid CheckFlagRequest request) {
    slackService.sendKeeperFBMessage(member, request.getFlagId(), request.getFlag());
    return ResponseEntity.ok().build();
  }

}
