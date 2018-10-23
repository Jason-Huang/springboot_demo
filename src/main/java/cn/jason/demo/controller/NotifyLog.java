package cn.jason.demo.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

@Controller
@EnableScheduling
public class NotifyLog {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private BlockingQueue<String> notifyQueue = new LinkedBlockingDeque<>(1000);

    @GetMapping("/notifyLog")
    public String notifyLog() {
        return "notifyLog";
    }

    @Scheduled(fixedRate = 1000)
    @SendTo("/topic/callbackNotifyLog")
    public Object callback() throws Exception {
        // 发现消息
        messagingTemplate.convertAndSend("/topic/callbackNotifyLog", notifyQueue.take());
        return "callbackNotifyLog";
    }

    @RequestMapping(value = "/receiptNotify")
    public void receiptNotify(HttpServletRequest request) {
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(parameterMap);
            System.out.println("收到通知：" + json);
            notifyQueue.offer(json);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
