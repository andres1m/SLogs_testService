package ru.andres1m.SLogs_testService.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.andres1m.SLogs_testService.service.LogsMessageService;
import ru.andres1m.SLogs_testService.service.TestService;

import java.util.Map;

@RestController
@RequestMapping("/SLogs/test/")
@AllArgsConstructor
public class TestController {
    private final TestService testService;
    private final LogsMessageService logsMessageService;

    @GetMapping("/getSomeTestData")
    public String getSomeTestData(@RequestParam("dataId") String id) {
        try {
            testService.doTestGet();
            logsMessageService.sendLogsMessage("Success to get data with id " + id);
            return "Success get: " + "id";
        } catch (Exception e) {
            logsMessageService.sendLogsMessage("Fail to get data with id " + id);
            return "Failed get";
        }
    }

    @PostMapping("/postSomeTestData")
    public String postSomeTestData(@RequestBody Map<String, String> jsonParams){
        try {
            testService.doTestGet();
            logsMessageService.sendLogsMessage("Success to get data with id " + jsonParams.get("id"));
            return "Success post: " + "id";
        } catch (Exception e) {
            logsMessageService.sendLogsMessage("Fail to get data with id " + jsonParams.get("id"));
            return "Failed post";
        }
    }
}