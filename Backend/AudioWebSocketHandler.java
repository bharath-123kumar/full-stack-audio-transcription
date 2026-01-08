public class AudioWebSocketHandler extends BinaryWebSocketHandler {

  @Override
  protected void handleBinaryMessage(
      WebSocketSession session, BinaryMessage message) throws Exception {

    // Forward audio chunk to transcription service (Gemini)
    String partialTranscript = "Live transcription...";
    session.sendMessage(new TextMessage(partialTranscript));
  }
}
