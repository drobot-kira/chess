CREATE DATABASE IF NOT EXISTS ChessDatabase;
USE ChessDatabase;
CREATE TABLE IF NOT EXISTS Game(
	gameId INT AUTO_INCREMENT PRIMARY KEY,
    whiteName VARCHAR(100) NOT NULL,
    blackName VARCHAR(100) NOT NULL,
    type VARCHAR(5) NOT NULL,
    moves TEXT,
    result TINYINT,
    spectatorName VARCHAR(100),
    FOREIGN KEY (whiteName) REFERENCES User(name),
    FOREIGN KEY (blackName) REFERENCES User(name),
    FOREIGN KEY (spectatorName) REFERENCES User(name)
);