package com.movelo.moveloapp.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class PushNotificationsProvider {
    private static String createNotificationUrl;
    private static RestTemplate restTemplate;
    private static HttpHeaders headers;
    private static JSONObject notificationObj;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private String appId = "c57efef2-42a3-4b89-a156-522ef565c7bf";
    private String apiKey = "NjZmZWNjN2EtZGNmZS00ZGZmLThkZmYtZmE1ZTdiMDI1NmQy";

    public PushNotificationsProvider() {
        createNotificationUrl = "https://onesignal.com/api/v1/notifications";
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth(apiKey);
        notificationObj = new JSONObject();
        List<String> includedSegments = new ArrayList<String>();
        includedSegments.add("Subscribed Users");
        notificationObj.put("included_segments", includedSegments);
        notificationObj.put("app_id", appId);
        notificationObj.put("headings", new NotificationContent("A new Tree", "Un nuevo arbol!!"));
        notificationObj.put("contents", new NotificationContent("Hello testing", "Hola Porbando!!"));

    }

    public void postData() throws IOException {
        HttpEntity<String> request = new HttpEntity<String>(notificationObj.toString(), headers);
        String personResultAsJsonStr = restTemplate.postForObject(createNotificationUrl, request, String.class);
        JsonNode root = objectMapper.readTree(personResultAsJsonStr);
        System.out.println(root.path("id").asText());
    }

}
