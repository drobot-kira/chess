CREATE DATABASE IF NOT EXISTS chessdatabase;

USE ChessDatabase;

CREATE TABLE IF NOT EXISTS User(
    name VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(50) NOT NULL
);

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

CREATE TABLE IF NOT EXISTS PositionTable(
	gameId INT,
	position VARCHAR(255),
    repeatCounter TINYINT,
    PRIMARY KEY (gameId, position),
    FOREIGN KEY (gameId) REFERENCES Game(gameId)
);

CREATE TABLE IF NOT EXISTS Spectator(
gameId INT,
spectatorName VARCHAR(100),
 FOREIGN KEY (gameId) REFERENCES Game(gameId),
 FOREIGN KEY (spectatorName) REFERENCES User(name),
 PRIMARY KEY(gameId, spectatorName)
);