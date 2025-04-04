# Online Chess

## Overview
**Online Chess** is a web-based chess game that allows players to challenge each other in real time. The system is built with a Java-based server using Spring Boot and a client-side interface developed with HTML, CSS, and JavaScript. Communication between the client and server is handled via WebSockets, ensuring dynamic and responsive gameplay.

## Features
- **Real-time Gameplay:** Moves are transmitted instantly using WebSockets.
- **Move Validation:** The server validates each move (including check, mate, and stalemate conditions).
- **Game State Management:** The game state is maintained and updated continuously on the server.
- **User Interaction:** The web client provides an interactive chessboard with clickable squares.
- **Modular Architecture:** Clearly divided components for game logic, UI, and data storage.
