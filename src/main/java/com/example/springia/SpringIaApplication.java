package com.example.springia;

// Utilidades para trabajar con Inteligencia Artificial en Spring 
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.StreamingChatClient;

// Utilidades necesarias 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@SpringBootApplication
@RestController
public class SpringIaApplication {

	// Usamos la interface chatClient para conversar con la Inteligencia Artificial
	private final ChatClient chatClient;

	// Clase principal de Spring
	public static void main(String[] args) {
		SpringApplication.run(SpringIaApplication.class, args);
	}

	// Ruta principal (Opcional)
	@GetMapping("/")
	public String hello(@RequestParam(value = "name", defaultValue = "de la Programación") String name) {
		return String.format("Hola Crack %s !", name);
	}

	// Usamos la interface chatClient y StreamingChatClient para conversar con la
	// Inteligencia Artificial
	@Autowired
	public SpringIaApplication(ChatClient chatClient, StreamingChatClient streamingChatClient) {
		this.chatClient = chatClient;
	}

	// Ruta para obtener las respuestas de la Inteligencia Artificial
	@GetMapping("/ia")
	public Map generate(

			// Le hacemos una pregunta a la Inteligencia Artificial
			@RequestParam(value = "message", defaultValue = "¿Donde queda Mali?") String message) {

		// Obtenemos la respuesta de la Inteligencia Artificial
		return Map.of("generation", chatClient.call(message));
	}

}