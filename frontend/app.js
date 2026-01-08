const canvas = document.getElementById("visualizer");
const ctx = canvas.getContext("2d");
canvas.width = 300;
canvas.height = 300;

let analyser, dataArray;

document.getElementById("startBtn").onclick = async () => {
  const stream = await navigator.mediaDevices.getUserMedia({ audio: true });
  const audioCtx = new AudioContext();
  analyser = audioCtx.createAnalyser();
  const source = audioCtx.createMediaStreamSource(stream);
  source.connect(analyser);

  analyser.fftSize = 128;
  dataArray = new Uint8Array(analyser.frequencyBinCount);
  draw();
};

function draw() {
  requestAnimationFrame(draw);
  analyser.getByteFrequencyData(dataArray);
  ctx.clearRect(0, 0, canvas.width, canvas.height);

  const centerX = canvas.width / 2;
  const centerY = canvas.height / 2;
  const radius = 70;

  dataArray.forEach((val, i) => {
    const angle = (i / dataArray.length) * Math.PI * 2;
    const barHeight = val / 2;
    ctx.strokeStyle = `hsl(${i * 4}, 100%, 50%)`;
    ctx.beginPath();
    ctx.moveTo(
      centerX + Math.cos(angle) * radius,
      centerY + Math.sin(angle) * radius
    );
    ctx.lineTo(
      centerX + Math.cos(angle) * (radius + barHeight),
      centerY + Math.sin(angle) * (radius + barHeight)
    );
    ctx.stroke();
  });
}
