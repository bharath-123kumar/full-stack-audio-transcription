@Service
public class GeminiStreamingService {

  private static final String GEMINI_URL =
      "https://generativelanguage.googleapis.com/v1/models/gemini-1.5-pro:streamGenerateContent";

  private final WebClient webClient;

  public GeminiStreamingService(WebClient.Builder builder) {
    this.webClient = builder.baseUrl(GEMINI_URL).build();
  }

  public Flux<String> streamTranscription(byte[] audioChunk) {
    return webClient.post()
      .uri(uriBuilder -> uriBuilder
        .queryParam("key", "YOUR_GEMINI_API_KEY")
        .build())
      .contentType(MediaType.APPLICATION_JSON)
      .bodyValue(buildPayload(audioChunk))
      .retrieve()
      .bodyToFlux(String.class);
  }

  private Map<String, Object> buildPayload(byte[] audioChunk) {
    return Map.of(
      "contents", List.of(
        Map.of(
          "parts", List.of(
            Map.of(
              "inline_data", Map.of(
                "mime_type", "audio/wav",
                "data", Base64.getEncoder().encodeToString(audioChunk)
              )
            )
          )
        )
      )
    );
  }
}
