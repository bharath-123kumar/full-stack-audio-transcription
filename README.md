# full-stack-audio-transcription

Real-Time Circular Audio Visualizer & Streaming Transcription

A full-stack application that captures live microphone audio, renders a circular audio equalizer UI, and streams audio chunks to a Spring Boot backend for real-time speech transcription using Gemini AI.

🚀 Features
Frontend

🎙️ Live microphone access (MediaStream API)

📊 Circular audio frequency visualizer

⚡ Smooth 60 FPS animation using Canvas

🔄 Real-time WebSocket audio streaming

🎨 Clean, responsive UI

Backend

☕ Spring Boot + WebSocket

🔁 Low-latency audio chunk streaming

🤖 Real-time transcription using Gemini API

⚙️ Non-blocking, scalable architecture

🏗️ Tech Stack
Frontend

HTML5

CSS3

JavaScript (ES6)

Web Audio API

Canvas API

WebSocket

Backend

Java 17

Spring Boot

Spring WebSocket

Spring WebFlux

Gemini AI API

📂 Project Structure
fullstack-audio-transcription/
│
├── frontend/
│   ├── index.html
│   ├── style.css
│   └── app.js
│
├── backend/
│   ├── pom.xml
│   └── src/main/java/com/example/transcription/
│       ├── TranscriptionApplication.java
│       ├── config/WebSocketConfig.java
│       └── handler/AudioWebSocketHandler.java
│
├── demo-video-script.txt
├── README.md
└── Fullstack_Development_Assignment_Submission.pdf

▶️ How to Run the Project (Local)
1️⃣ Run Backend (Spring Boot)
Prerequisites

Java 17+

Maven

Gemini API key

cd backend
mvn spring-boot:run


Backend will start at:

http://localhost:8080


WebSocket endpoint:

ws://localhost:8080/audio

2️⃣ Run Frontend
Recommended Browser

✅ Google Chrome

cd frontend
npx serve .


OR simply open:

index.html


Allow microphone permission when prompted.

🎥 Demo Video Instructions

Start Spring Boot backend

Open frontend in Chrome

Click Start Microphone

Speak into mic

Observe circular equalizer reacting

Show live transcription response

Explain real-time WebSocket streaming

⏱ Recommended demo length: 2–3 minutes

🌐 Deployment Guide
Frontend

Netlify or Vercel

HTTPS required for microphone access

Backend

Render or Railway

Set environment variable:

GEMINI_API_KEY=your_api_key_here


Update frontend WebSocket URL:

wss://your-backend-url/audio
