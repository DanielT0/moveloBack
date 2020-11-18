package com.movelo.moveloapp;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
class BiciusuarioControllerTest {

	private static String biciusuarioUrl;
	private static String updatePersonUrl;
	private static RestTemplate restTemplate;
	private static HttpHeaders headers;
	private static JSONObject ciclistaJsonObject;
	private final ObjectMapper objectMapper = new ObjectMapper();

	@BeforeClass
	public static void runBeforeAllTestMethods() {

	}

	@Test
	public void cuandoLosDatosSiPermitenCrear() throws IOException {
		ciclistaJsonObject = new JSONObject();
		ciclistaJsonObject.put("cc", "1220f123");
		ciclistaJsonObject.put("nombre", "Juan Dafvid Valencia");
		ciclistaJsonObject.put("correo", "juandva2f016@gmail.com");
		ciclistaJsonObject.put("direccion", "de la fcasa xd");
		ciclistaJsonObject.put("telefono", "3250f032123");
		ciclistaJsonObject.put("password", "xDs2sdaq12");

		biciusuarioUrl = "http://localhost:4000/api/bikeriders";
		restTemplate = new RestTemplate();
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(ciclistaJsonObject.toString(), headers);
		Boolean reponse = restTemplate.postForObject(biciusuarioUrl, request, Boolean.class);
		System.out.println(reponse);
	}
}
