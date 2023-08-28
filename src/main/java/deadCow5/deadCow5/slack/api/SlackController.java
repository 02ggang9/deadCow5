package deadCow5.deadCow5.slack.api;

import deadCow5.deadCow5.slack.service.SlackService;
import jdk.jshell.Snippet.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/slack")
public class SlackController {

  private final SlackService slackService;

  @PostMapping("/v1/flag")
  public ResponseEntity<Void> checkFlag() {
    slackService.sendKeeperFBMessage();
    return ResponseEntity.ok().build();
  }

}
