package com.movelo.moveloapp;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movelo.moveloapp.models.Biciusuario;

import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
class BiciusuarioControllerTest {

	private String biciusuarioUrl;
	private String updatePersonUrl;
	private RestTemplate restTemplate;
	private HttpHeaders headers;
	private JSONObject ciclistaJsonObject;
	private final ObjectMapper objectMapper = new ObjectMapper();

	public BiciusuarioControllerTest() {
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
	}

	@Test
	public void cuandoLosDatosSiPermitenCrear() throws IOException {

		HttpEntity<String> request = new HttpEntity<String>(ciclistaJsonObject.toJSONString(), headers);
		Boolean reponse = restTemplate.postForObject(biciusuarioUrl, request, Boolean.class);
		System.out.println(reponse);
	}

}
