let socket = new WebSocket("ws://localhost:8080/chess");

const userName = localStorage.getItem('username');
socket.onopen = () => {
    socket.send(JSON.stringify({Type: "Identify", UserName: userName}));
};

function CreateGame() {
    if (userName == null) {
        window.location.replace('/chess/authorization/index.html');
    } else {
        let type = "CreateGame";
        let gameType = "10";
        let message = JSON.stringify({Type: type, UserName: userName, GameType: gameType});
        socket.send(message);
        window.location.replace('/chess/select-game-mode/game-lobby/index.html');
    }
}