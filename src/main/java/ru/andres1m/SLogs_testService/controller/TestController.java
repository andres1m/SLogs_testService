package ru.andres1m.SLogs_testService.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.andres1m.SLogs_testService.service.LogsMessageService;
import ru.andres1m.SLogs_testService.service.TestService;

import java.util.Map;

@RestController
@RequestMapping("/SLogs/test/")
@Tag(name = "тестовый API", description = "API для тестирования SLogs")
@AllArgsConstructor
public class TestController {
    private final TestService testService;
    private final LogsMessageService logsMessageService;

    @Operation(summary = "Имитировать запрос для получния данных", responses = {
            @ApiResponse(responseCode = "200", description = "Получение данных")
    })
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

    @Operation(summary = "Имитировать запрос для отправки данных", responses = {
            @ApiResponse(responseCode = "200", description = "Отправка данных")
    })
    @PostMapping("/postSomeTestData")
    public String postSomeTestData(@RequestBody Map<String, String> jsonParams){
        try {
            testService.doTestGet();
            logsMessageService.sendLogsMessage("Success to post data with id " + jsonParams.get("id"));
            return "Success post: " + "id";
        } catch (Exception e) {
            logsMessageService.sendLogsMessage("Fail to get post with id " + jsonParams.get("id"));
            return "Failed post";
        }
    }
}