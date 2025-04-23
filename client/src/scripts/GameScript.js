let socket = new WebSocket("ws://localhost:8080/chess");

socket.onmessage = function (event)
{
    let field = JSON.parse(event.data);
    for (i = 0; i < 8; i++)
    {
        for (j = 0; j < 8; j++)
        {
            let piece = field[i][j];
            let move, pieceColor, type, squareColor;
            if (piece > 0)
            {
                if (piece > 100)
                {
                    move = "_selected"
                    piece -= 100;
                }
                else
                {
                    move = "";
                }
            }
            else
            {
                move = "_move";
                piece *= -1;
            }

            if (Math.floor(piece / 10) === 1)
            {
                pieceColor = "whiteOn";
            }
            else if (Math.floor(piece / 10) === 2)
            {
                pieceColor = "blackOn";
            }
            else
            {
                pieceColor = "";
            }
            piece %= 10;

            if (piece === 1)
            {
                type = "pawn";
            }
            else if (piece === 2)
            {
                type = "knight";
            }
            else if (piece === 3)
            {
                type = "bishop";
            }
            else if (piece === 4)
            {
                type = "rook";
            }
            else if (piece === 5)
            {
                type = "queen";
            }
            else if (piece === 6)
            {
                type = "king";
            }
            else {
                type = "square";
            }

            if ((i + j) % 2 == 0)
            {
                squareColor = "black";
            }
            else
            {
                squareColor = "white";
            }

            let image = "url('../../images/pieces/" + type + "_" + pieceColor + squareColor + move + ".png')";
            document.getElementById(i*10+j).style.backgroundImage = image;
            document.getElementById(i*10+j).style.backgroundSize = "cover";
        }
    }
}

function SquareClicked(SqId)
{
    let squareId = parseInt(SqId);
    let gameId = 1;
    let userId = 1;

    let message = JSON.stringify({Type: "SquareClicked", SquareId: squareId, GameId: gameId, UserId: userId});
    socket.send(message);
}