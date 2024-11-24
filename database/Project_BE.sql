CREATE TABLE `Match` (
  `matchId` int PRIMARY KEY,
  `season` varchar(20),
  `status` varchar(20),
  `dateTime` datetime,
  `stadium` varchar(40),
  `matchGroup` varchar(40),
  `originCompetitionId` varchar(40),
  `originCompetitionName` varchar(40),
  `createdAt` timestamp,
  `homeTeam` int,
  `awayTeam` int,
  `resultId` int,
  `stageId` int
);

CREATE TABLE `Team` (
  `teamId` int PRIMARY KEY,
  `name` varchar(50),
  `officialName` varchar(50),
  `slug` varchar(50),
  `abbreviation` varchar(50),
  `teamCountryCode` varchar(50),
  `stagePosition` varchar(50)
);

CREATE TABLE `Result` (
  `resultId` int PRIMARY KEY,
  `homeGoals` int,
  `awayGoals` int,
  `winner` varchar(50),
  `message` text,
  `goalId` int,
  `cardId` int
);

CREATE TABLE `Stage` (
  `stageId` int PRIMARY KEY,
  `name` varchar(50),
  `ordering` int
);

CREATE TABLE `Player` (
  `playerId` int PRIMARY KEY,
  `name` varchar(50) NOT NULL,
  `birthday` int,
  `jerseyNumber` int,
  `teamID` int,
  `cardId` int,
  `goalId` int
);

CREATE TABLE `Goal` (
  `goalId` int PRIMARY KEY,
  `time` time,
  `resultId` int,
  `playerId` int
);

CREATE TABLE `Card` (
  `cardId` int PRIMARY KEY,
  `cardType` varchar(50),
  `reason` text,
  `time` time,
  `resultId` int,
  `playerId` int
);

ALTER TABLE `Match` ADD FOREIGN KEY (`homeTeam`) REFERENCES `Team` (`teamId`);

ALTER TABLE `Match` ADD FOREIGN KEY (`awayTeam`) REFERENCES `Team` (`teamId`);

ALTER TABLE `Stage` ADD FOREIGN KEY (`stageId`) REFERENCES `Match` (`stageId`);

ALTER TABLE `Result` ADD FOREIGN KEY (`resultId`) REFERENCES `Match` (`resultId`);

ALTER TABLE `Goal` ADD FOREIGN KEY (`goalId`) REFERENCES `Result` (`goalId`);

ALTER TABLE `Card` ADD FOREIGN KEY (`cardId`) REFERENCES `Result` (`cardId`);

ALTER TABLE `Player` ADD FOREIGN KEY (`teamID`) REFERENCES `Team` (`teamId`);

ALTER TABLE `Card` ADD FOREIGN KEY (`cardId`) REFERENCES `Player` (`cardId`);

ALTER TABLE `Goal` ADD FOREIGN KEY (`goalId`) REFERENCES `Player` (`goalId`);

ALTER TABLE `Player` ADD FOREIGN KEY (`playerId`) REFERENCES `Goal` (`playerId`);

ALTER TABLE `Result` ADD FOREIGN KEY (`resultId`) REFERENCES `Goal` (`resultId`);

ALTER TABLE `Card` ADD FOREIGN KEY (`resultId`) REFERENCES `Result` (`resultId`);

ALTER TABLE `Card` ADD FOREIGN KEY (`playerId`) REFERENCES `Player` (`playerId`);
