let socket = new WebSocket("ws://localhost:8080/chess");

let startField = [
    [24, 22, 23, 25, 26, 23, 22, 24],
    [21, 21, 21, 21, 21, 21, 21, 21],
    [30, 30, 30, 30, 30, 30, 30, 30],
    [30, 30, 30, 30, 30, 30, 30, 30],
    [30, 30, 30, 30, 30, 30, 30, 30],
    [30, 30, 30, 30, 30, 30, 30, 30],
    [11, 11, 11, 11, 11, 11, 11, 11],
    [14, 12, 13, 15, 16, 13, 12, 14],
    [ 1, 11, 11,  0,  0,  0,  0,  0]];
if (localStorage.getItem('color') === 'black')
{
    startField = ChangeColor(startField);
}
showField(startField);
document.getElementById("whiteName").innerText = localStorage.getItem('username');
document.getElementById("blackName").innerText = localStorage.getItem('opponent')

socket.onopen = () => {
    const userName = localStorage.getItem('username');
    socket.send(JSON.stringify({Type: "Identify", UserName: userName}));
};

socket.onmessage = function (event) {
    let field = JSON.parse(event.data);
    if (localStorage.getItem('color') === 'black')
    {
        showField(ChangeColor(field));
    }
    else {
        showField(field);
    }
}

    function showField(field){
    for (i = 0; i < 8; i++) {
        for (j = 0; j < 8; j++) {
            let piece = field[i][j];
            let move, pieceColor, type, squareColor;
            if (piece > 0) {
                if (piece > 100) {
                    move = "_selected"
                    piece -= 100;
                } else {
                    move = "";
                }
            } else {
                move = "_move";
                piece *= -1;
            }

            if (Math.floor(piece / 10) === 1) {
                pieceColor = "whiteOn";
            } else if (Math.floor(piece / 10) === 2) {
                pieceColor = "blackOn";
            } else {
                pieceColor = "";
            }
            piece %= 10;

            if (piece === 1) {
                type = "pawn";
            } else if (piece === 2) {
                type = "knight";
            } else if (piece === 3) {
                type = "bishop";
            } else if (piece === 4) {
                type = "rook";
            } else if (piece === 5) {
                type = "queen";
            } else if (piece === 6) {
                type = "king";
            } else {
                type = "square";
            }

            if ((i + j) % 2 == 0) {
                squareColor = "black";
            } else {
                squareColor = "white";
            }

            let image = "url('/images/pieces/" + type + "_" + pieceColor + squareColor + move + ".png')";
            document.getElementById(i * 10 + j).style.backgroundImage = image;
            document.getElementById(i * 10 + j).style.backgroundSize = "cover";
        }
    }
}

function SquareClicked(SqId) {
    let squareId = parseInt(SqId);
    let gameId = localStorage.getItem('gameid');
    let userId = localStorage.getItem('username');

    let message = JSON.stringify({Type: "SquareClicked", SquareId: squareId, GameId: gameId, UserId: userId});
    socket.send(message);
}

function ChangeColor(field){
    let newField = [];
    for (let i = 0; i < 8; i++)
    {
        newField[i] = []
        for (let j = 0; j < 8; j++)
        {
            newField[i][j] = 0;
        }
    }
    newField[8] = [];
    for (let i = 0; i < 8; i++)
    {
        newField[8][i] = field[8][i];
    }

    for (let i = 0; i < 8; i++)
    {
        for (let j = 0; j < 8; j++)
        {
            newField[i][j] = field[7-i][7-j];
        }
    }

    let elements = document.querySelectorAll(".a");
    elements.forEach(el => {
        el.textContent = 'h';
    });
    elements = document.querySelectorAll(".b");
    elements.forEach(el => {
        el.textContent = 'g';
    });
    elements = document.querySelectorAll(".c");
    elements.forEach(el => {
        el.textContent = 'f';
    });
    elements = document.querySelectorAll(".d");
    elements.forEach(el => {
        el.textContent = 'e';
    });
    elements = document.querySelectorAll(".e");
    elements.forEach(el => {
        el.textContent = 'd';
    });
    elements = document.querySelectorAll(".f");
    elements.forEach(el => {
        el.textContent = 'c';
    });
    elements = document.querySelectorAll(".g");
    elements.forEach(el => {
        el.textContent = 'b';
    });
    elements = document.querySelectorAll(".h");
    elements.forEach(el => {
        el.textContent = 'a';
    });
    elements = document.querySelectorAll(".one");
    elements.forEach(el => {
        el.textContent = '8';
    });
    elements = document.querySelectorAll(".two");
    elements.forEach(el => {
        el.textContent = '7';
    });
    elements = document.querySelectorAll(".three");
    elements.forEach(el => {
        el.textContent = '6';
    });
    elements = document.querySelectorAll(".four");
    elements.forEach(el => {
        el.textContent = '5';
    });
    elements = document.querySelectorAll(".five");
    elements.forEach(el => {
        el.textContent = '4';
    });
    elements = document.querySelectorAll(".six");
    elements.forEach(el => {
        el.textContent = '3';
    });
    elements = document.querySelectorAll(".seven");
    elements.forEach(el => {
        el.textContent = '2';
    });
    elements = document.querySelectorAll(".eight");
    elements.forEach(el => {
        el.textContent = '1';
    });

    return newField;

}