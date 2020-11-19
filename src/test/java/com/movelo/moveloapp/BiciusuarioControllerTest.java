package com.movelo.moveloapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movelo.moveloapp.models.Biciusuario;
import com.movelo.moveloapp.services.BiciusuarioServiImpl;
import com.movelo.moveloapp.services.BiciusuarioService;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
class BiciusuarioControllerTest {

	private String biciusuarioUrl;
	private String updatePersonUrl;
	private RestTemplate restTemplate;
	private HttpHeaders headers;
	private JSONObject ciclistaJsonObject;
	private final ObjectMapper objectMapper = new ObjectMapper();
	private UriComponentsBuilder builder;

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
		Boolean response = restTemplate.postForObject(biciusuarioUrl, request, Boolean.class);
		assertEquals(response, true);
	}

	@Test
	public void obtenerUsuario() {
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		builder = UriComponentsBuilder.fromHttpUrl(biciusuarioUrl).queryParam("email", "juandva2f016@gmail.com")
				.queryParam("pass", "xDs2sdaq12");

		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<Biciusuario> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				Biciusuario.class);
		Biciusuario obtenido = response.getBody();
		assertEquals(ciclistaJsonObject.get("cc"), obtenido.getCc());
	}

	@Test
	public void actualizarKmTest() {
		/*
		 * JSONObject wrapper = new JSONObject(); wrapper.put("email",
		 * "juandva2f016@gmail.com"); wrapper.put("distance", 100);
		 * Optional<Biciusuario> biciusuario =
		 * service.findByEmail("juandva2f016@gmail.com"); String url =
		 * "http://localhost:4000/api/bikeriders/kmCovered"; HttpEntity<String> request
		 * = new HttpEntity<String>(wrapper.toJSONString(), headers); Boolean response =
		 * restTemplate.postForObject(url, request, Boolean.class); Optional<Double>
		 * actualizado = Optional.of(service.actualizarKm("juandva2f016@gmail.com",
		 * 100.0)); if (!actualizado.isPresent()) {
		 * fail("La cantidad de kilometros no debe ser null"); }
		 * assertEquals(biciusuario.get().getkmRecorridos() + 100.0, actualizado.get());
		 * assertEquals(true, response);
		 */
	}

}
