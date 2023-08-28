package deadCow5.deadCow5.slack.service;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class slackService {

  private static final String KEEPER_CTF_BOT = "#키퍼-퍼블봇-테스트";

  @Value(value = "${slack.token}")
  String slackToken;

  public void sendKeeperFBMessage() {

    try {
      MethodsClient methods = Slack.getInstance().methods(slackToken);

      ChatPostMessageRequest request = ChatPostMessageRequest.builder()
          .channel(KEEPER_CTF_BOT)
          .text("TEST FB BOT")
          .build();

      methods.chatPostMessage(request);
    } catch (SlackApiException | IOException e) {
      System.out.println("e = " + e);
    }


  }




}
