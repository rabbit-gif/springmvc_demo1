package com.experiment.requestparams.controller;

import com.experiment.requestparams.model.UserInfo;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class UserController {

    /**
     * GET /users — 使用 @RequestParam 接收查询参数
     * id: 默认值 1, 非必填
     * email: 非必填
     */
    @GetMapping("/users")
    public ResponseEntity<UserInfo> getUser(
            @RequestParam(value = "id", defaultValue = "1", required = false) Long id,
            @RequestParam(value = "email", required = false) String email) {

        String name;
        if (email != null && !email.isEmpty()) {
            name = "User-" + id;
        } else {
            name = "DefaultUser-" + id;
        }

        UserInfo userInfo = new UserInfo(id, name, email);
        return ResponseEntity.ok(userInfo);
    }

    /**
     * POST /users/update — 使用 @RequestBody 接收 JSON 请求体
     */
    @PostMapping("/users/update")
    public ResponseEntity<String> updateUser(@RequestBody UserInfo userInfo) {
        String message = "用户信息更新成功: " + userInfo.toString();
        return ResponseEntity.ok(message);
    }

    /**
     * GET /greeting/{name} — 综合演示 @PathVariable, @RequestHeader, @CookieValue
     */
    @GetMapping("/greeting/{name}")
    public ResponseEntity<String> greeting(
            @PathVariable("name") String name,
            @RequestHeader("User-Agent") String userAgent,
            @CookieValue(value = "session-id", defaultValue = "") String sessionId) {

        StringBuilder sb = new StringBuilder();
        sb.append("Hello, ").append(name).append("! ");
        sb.append("Your User-Agent is: ").append(userAgent).append(" ");
        sb.append("Session ID: ").append(sessionId.isEmpty() ? "N/A (no session-id cookie)" : sessionId);

        return ResponseEntity.ok(sb.toString());
    }

    /**
     * GET /demo/all/{category} — 综合演示所有参数绑定注解
     * @PathVariable 绑定路径变量 category
     * @RequestParam  绑定查询参数 keyword
     * @ModelAttribute 将查询参数自动绑定到 UserInfo 对象
     * @RequestBody    绑定请求体 (GET 请求携带 body 属于非标准用法, 此处仅为演示)
     * @RequestHeader  绑定请求头 X-Custom-Header
     * @CookieValue    绑定 Cookie session-id
     */
    @GetMapping("/demo/all/{category}")
    public ResponseEntity<Map<String, Object>> demoAll(
            @PathVariable("category") String category,
            @RequestParam(value = "keyword", defaultValue = "default-keyword", required = false) String keyword,
            @ModelAttribute UserInfo userInfo,
            @RequestBody(required = false) UserInfo bodyUserInfo,
            @RequestHeader(value = "X-Custom-Header", defaultValue = "no-custom-header") String customHeader,
            @CookieValue(value = "session-id", defaultValue = "") String sessionId,
            HttpServletRequest request) {

        Map<String, Object> result = new LinkedHashMap<>();

        // @PathVariable
        Map<String, Object> pathVar = new LinkedHashMap<>();
        pathVar.put("annotation", "@PathVariable");
        pathVar.put("value", category);
        result.put("pathVariable", pathVar);

        // @RequestParam
        Map<String, Object> reqParam = new LinkedHashMap<>();
        reqParam.put("annotation", "@RequestParam");
        reqParam.put("value", keyword);
        result.put("requestParam", reqParam);

        // @ModelAttribute (绑定查询参数到对象)
        Map<String, Object> modelAttr = new LinkedHashMap<>();
        modelAttr.put("annotation", "@ModelAttribute");
        modelAttr.put("value", userInfo);
        result.put("modelAttribute", modelAttr);

        // @RequestBody
        Map<String, Object> reqBody = new LinkedHashMap<>();
        reqBody.put("annotation", "@RequestBody");
        reqBody.put("value", bodyUserInfo != null ? bodyUserInfo : "null (未提供请求体)");
        result.put("requestBody", reqBody);

        // @RequestHeader
        Map<String, Object> reqHeader = new LinkedHashMap<>();
        reqHeader.put("annotation", "@RequestHeader");
        reqHeader.put("value", customHeader);
        result.put("requestHeader", reqHeader);

        // @CookieValue
        Map<String, Object> cookieVal = new LinkedHashMap<>();
        cookieVal.put("annotation", "@CookieValue");
        cookieVal.put("value", sessionId.isEmpty() ? "N/A (no session-id cookie)" : sessionId);
        result.put("cookieValue", cookieVal);

        // 额外: 列出所有 Cookie
        Cookie[] cookies = request.getCookies();
        Map<String, String> allCookies = new LinkedHashMap<>();
        if (cookies != null) {
            for (Cookie c : cookies) {
                allCookies.put(c.getName(), c.getValue());
            }
        }
        result.put("allCookies", allCookies);

        return ResponseEntity.ok(result);
    }
}
