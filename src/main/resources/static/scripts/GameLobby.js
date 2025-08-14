let socket = new WebSocket("ws://localhost:8080/chess");

const userName = localStorage.getItem('username');
socket.onopen = () => {
    socket.send(JSON.stringify({Type: "Identify", UserName: userName}));

    let message = JSON.stringify({Type: "GetUnstartedGames"});
    socket.send(message);
}

function renderGameList(games) {
    gameList.innerHTML = '';
    games.forEach(addGameToList);
}

function addGameToList(gameArray) {
    const [id, username, timeControl] = gameArray;

    const li = document.createElement('li');
    li.className = 'game-container__item';
    li.dataset.gameId = id;

    const opponentDiv = document.createElement('div');
    opponentDiv.className = 'opponent';
    opponentDiv.textContent = username;

    const containerDiv = document.createElement('div');
    containerDiv.className = 'container-for-time-and-button';

    const timeDiv = document.createElement('div');
    timeDiv.className = 'container-for-time-and-button__time';
    timeDiv.textContent = timeControl;

    const button = document.createElement('button');
    button.className = 'container-for-time-and-button__join-game-button';
    button.textContent = 'Грати';
    button.id = id;
    button.onclick = () => joinGame(id);

    containerDiv.appendChild(timeDiv);
    containerDiv.appendChild(button);

    li.appendChild(opponentDiv);
    li.appendChild(containerDiv);

    gameList.appendChild(li);
}

function joinGame(gameId) {
    let message = JSON.stringify({Type: "StartGame", GameId: gameId, UserName: userName});
    socket.send(message);
}

socket.onmessage = (event) => {
    const data = JSON.parse(event.data);

    if (data.type === 'AvailableGames') {
        renderGameList(data.games);
    } else if (data.type === 'StartGame') {
        localStorage.setItem('color', data.color);
        localStorage.setItem('gameid', data.gameid);
        localStorage.setItem('opponent', data.opponent);
        window.location.replace('/chess/game/index.html');
    }
};
