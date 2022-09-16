CREATE DATABASE  IF NOT EXISTS `db_goat` /* !40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /* !80016 DEFAULT ENCRYPTION='N' */;
USE `db_goat`;

DROP TABLE IF EXISTS `game`;
CREATE TABLE `game` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `assists` int NOT NULL,
  `commited_blocks` int NOT NULL,
  `commited_fouls` int NOT NULL,
  `defensive_rebounds` int NOT NULL,
  `free_throws_attempted` int NOT NULL,
  `free_throws_made` int NOT NULL,
  `free_throws_percentage` int NOT NULL,
  `minutes` int NOT NULL,
  `offensive_rebounds` int NOT NULL,
  `points` int NOT NULL,
  `recieved_blocks` int NOT NULL,
  `recieved_fouls` int NOT NULL,
  `steals` int NOT NULL,
  `three_points_attempted` int NOT NULL,
  `three_points_made` int NOT NULL,
  `three_points_percentage` int NOT NULL,
  `total_rebounds` int NOT NULL,
  `turnovers` int NOT NULL,
  `two_points_attempted` int NOT NULL,
  `two_points_made` int NOT NULL,
  `two_points_percentage` int NOT NULL,
  `away_id` bigint DEFAULT NULL,
  `home_id` bigint DEFAULT NULL,
  `tournament_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
  /*KEY `FKm2p938fpfltgm2mvwy3l1o8t8` (`away_id`),
  KEY `FKnlys7wwo8em324tk8wlbm88nx` (`home_id`),
  KEY `FK2xfdbv4n193efuyajlqh0vs6j` (`tournament_id`),
  CONSTRAINT `FK2xfdbv4n193efuyajlqh0vs6j` FOREIGN KEY (`tournament_id`) REFERENCES `tournament` (`id`),
  CONSTRAINT `FKm2p938fpfltgm2mvwy3l1o8t8` FOREIGN KEY (`away_id`) REFERENCES `team` (`id`),
  CONSTRAINT `FKnlys7wwo8em324tk8wlbm88nx` FOREIGN KEY (`home_id`) REFERENCES `team` (`id`)*/
); -- ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `game` WRITE;
UNLOCK TABLES;

/*
DROP TABLE IF EXISTS `game_players`;
CREATE TABLE `game_players` (
  `game_id` bigint NOT NULL,
  `players_game_id` bigint NOT NULL,
  `players_player_dni` int NOT NULL,
  UNIQUE KEY `UK_pg5csd0gwuxi0asdl4r20sifp` (`players_game_id`,`players_player_dni`),
  KEY `FKfjnwm25clh3tf6qwuohsmdtkj` (`game_id`),
  CONSTRAINT `FKagy5ym0ily8b448eoucynpqlu` FOREIGN KEY (`players_game_id`, `players_player_dni`) REFERENCES `player_games` (`game_id`, `player_dni`),
  CONSTRAINT `FKfjnwm25clh3tf6qwuohsmdtkj` FOREIGN KEY (`game_id`) REFERENCES `game` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/* !40101 SET character_set_client = @saved_cs_client ;

--
-- Dumping data for table `game_players`
--

LOCK TABLES `game_players` WRITE;
/*!40000 ALTER TABLE `game_players` DISABLE KEYS ;
/*!40000 ALTER TABLE `game_players` ENABLE KEYS ;
UNLOCK TABLES;
*/
--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
CREATE TABLE `player` (
  `dni` int NOT NULL,
  `assists` int NOT NULL,
  `commited_blocks` int NOT NULL,
  `commited_fouls` int NOT NULL,
  `defensive_rebounds` int NOT NULL,
  `free_throws_attempted` int NOT NULL,
  `free_throws_made` int NOT NULL,
  `free_throws_percentage` int NOT NULL,
  `minutes` int NOT NULL,
  `offensive_rebounds` int NOT NULL,
  `points` int NOT NULL,
  `recieved_blocks` int NOT NULL,
  `recieved_fouls` int NOT NULL,
  `steals` int NOT NULL,
  `three_points_attempted` int NOT NULL,
  `three_points_made` int NOT NULL,
  `three_points_percentage` int NOT NULL,
  `total_rebounds` int NOT NULL,
  `turnovers` int NOT NULL,
  `two_points_attempted` int NOT NULL,
  `two_points_made` int NOT NULL,
  `two_points_percentage` int NOT NULL,
  `birth` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dni`)
); -- ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/* !40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `assists` int NOT NULL,
                        `commited_blocks` int NOT NULL,
                        `commited_fouls` int NOT NULL,
                        `defensive_rebounds` int NOT NULL,
                        `free_throws_attempted` int NOT NULL,
                        `free_throws_made` int NOT NULL,
                        `free_throws_percentage` int NOT NULL,
                        `minutes` int NOT NULL,
                        `offensive_rebounds` int NOT NULL,
                        `points` int NOT NULL,
                        `recieved_blocks` int NOT NULL,
                        `recieved_fouls` int NOT NULL,
                        `steals` int NOT NULL,
                        `three_points_attempted` int NOT NULL,
                        `three_points_made` int NOT NULL,
                        `three_points_percentage` int NOT NULL,
                        `total_rebounds` int NOT NULL,
                        `turnovers` int NOT NULL,
                        `two_points_attempted` int NOT NULL,
                        `two_points_made` int NOT NULL,
                        `two_points_percentage` int NOT NULL,
                        `category` int NOT NULL,
                        `name` varchar(255) DEFAULT NULL,
                        `season` int NOT NULL,
                        PRIMARY KEY (`id`)
); -- ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/* !40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `tournament`
--

DROP TABLE IF EXISTS `tournament`;
CREATE TABLE `tournament` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `category` int NOT NULL,
                              `name` varchar(255) DEFAULT NULL,
                              `season` int NOT NULL,
                              PRIMARY KEY (`id`)
); -- ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*  SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tournament`
--

LOCK TABLES `tournament` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `player_games`
--

DROP TABLE IF EXISTS `player_games`;
CREATE TABLE `player_games` (
  `assists` int NOT NULL,
  `commited_blocks` int NOT NULL,
  `commited_fouls` int NOT NULL,
  `defensive_rebounds` int NOT NULL,
  `free_throws_attempted` int NOT NULL,
  `free_throws_made` int NOT NULL,
  `free_throws_percentage` int NOT NULL,
  `minutes` int NOT NULL,
  `offensive_rebounds` int NOT NULL,
  `points` int NOT NULL,
  `recieved_blocks` int NOT NULL,
  `recieved_fouls` int NOT NULL,
  `steals` int NOT NULL,
  `three_points_attempted` int NOT NULL,
  `three_points_made` int NOT NULL,
  `three_points_percentage` int NOT NULL,
  `total_rebounds` int NOT NULL,
  `turnovers` int NOT NULL,
  `two_points_attempted` int NOT NULL,
  `two_points_made` int NOT NULL,
  `two_points_percentage` int NOT NULL,

  `player_dni` int NOT NULL,
  `game_id` bigint NOT NULL,
  KEY `fk_player_games` (`player_dni`),
  KEY `fk_game` (`game_id`),
  CONSTRAINT `fk_game` FOREIGN KEY (`game_id`) REFERENCES `game` (`id`),
  CONSTRAINT `fk_player_games` FOREIGN KEY (`player_dni`) REFERENCES `player` (`dni`)
/*
  UNIQUE KEY `UK_o3dvw1lwnay32invjbp8ng61i` (`games_game_id`,`games_player_dni`),
  KEY `FKe6j8tbsks6jpi19abjujfp3da` (`player_dni`),
  CONSTRAINT `FK13ybaox59nv36hktxker8vhjy` FOREIGN KEY (`game_id`) REFERENCES `game` (`id`),
  CONSTRAINT `FK8fu8qevybc2n13h09sphidckl` FOREIGN KEY (`games_game_id`, `games_player_dni`) REFERENCES `player_games` (`game_id`, `player_dni`),
  CONSTRAINT `FKe6j8tbsks6jpi19abjujfp3da` FOREIGN KEY (`player_dni`) REFERENCES `player` (`dni`)*/
); -- ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/* !40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_games`
--

LOCK TABLES `player_games` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `player_teams`
--

DROP TABLE IF EXISTS `player_teams`;
CREATE TABLE `player_teams` (
  `assists` int NOT NULL,
  `commited_blocks` int NOT NULL,
  `commited_fouls` int NOT NULL,
  `defensive_rebounds` int NOT NULL,
  `free_throws_attempted` int NOT NULL,
  `free_throws_made` int NOT NULL,
  `free_throws_percentage` int NOT NULL,
  `minutes` int NOT NULL,
  `offensive_rebounds` int NOT NULL,
  `points` int NOT NULL,
  `recieved_blocks` int NOT NULL,
  `recieved_fouls` int NOT NULL,
  `steals` int NOT NULL,
  `three_points_attempted` int NOT NULL,
  `three_points_made` int NOT NULL,
  `three_points_percentage` int NOT NULL,
  `total_rebounds` int NOT NULL,
  `turnovers` int NOT NULL,
  `two_points_attempted` int NOT NULL,
  `two_points_made` int NOT NULL,
  `two_points_percentage` int NOT NULL,

  `player_dni` int NOT NULL,
  `team_id` bigint NOT NULL,
  KEY `fk_player_teams` (`player_dni`),
  KEY `fk_team` (`team_id`),
  CONSTRAINT `fk_team` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`),
  CONSTRAINT `fk_player_teams` FOREIGN KEY (`player_dni`) REFERENCES `player` (`dni`)
); -- **ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/* !40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_teams`
--

LOCK TABLES `player_teams` WRITE;
UNLOCK TABLES;

/*
--
-- Table structure for table `team_games`
--

DROP TABLE IF EXISTS `team_games`;
/*!40101 SET @saved_cs_client     = @@character_set_client ;
/*!50503 SET character_set_client = utf8mb4 ;
CREATE TABLE `team_games` (
  `team_id` bigint NOT NULL,
  `games_id` bigint NOT NULL,
  UNIQUE KEY `UK_1yibtd6ege54pgyw33brnuqui` (`games_id`),
  KEY `FKcj6g0ox27wqpddag02qoq2sqi` (`team_id`),
  CONSTRAINT `FKcj6g0ox27wqpddag02qoq2sqi` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`),
  CONSTRAINT `FKje5293ccwio9pw6oauiembn1c` FOREIGN KEY (`games_id`) REFERENCES `game` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client ;

--
-- Dumping data for table `team_games`
--

LOCK TABLES `team_games` WRITE;
/*!40000 ALTER TABLE `team_games` DISABLE KEYS ;
/*!40000 ALTER TABLE `team_games` ENABLE KEYS ;
UNLOCK TABLES;

--
-- Table structure for table `team_players`
--

DROP TABLE IF EXISTS `team_players`;
/*!40101 SET @saved_cs_client     = @@character_set_client ;
/*!50503 SET character_set_client = utf8mb4 ;
CREATE TABLE `team_players` (
  `team_id` bigint NOT NULL,
  `players_player_dni` int NOT NULL,
  `players_team_id` bigint NOT NULL,
  UNIQUE KEY `UK_6lunhe5u38ptu30rvlxmqagcr` (`players_player_dni`,`players_team_id`),
  KEY `FKc9igy2kys82rwa80px3q0usqa` (`team_id`),
  CONSTRAINT `FK341mjd7toynlqilp3s6gm01ic` FOREIGN KEY (`players_player_dni`, `players_team_id`) REFERENCES `player_teams` (`player_dni`, `team_id`),
  CONSTRAINT `FKc9igy2kys82rwa80px3q0usqa` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/* !40101 SET character_set_client = @saved_cs_client ;

--
-- Dumping data for table `team_players`
--

LOCK TABLES `team_players` WRITE;
/*!40000 ALTER TABLE `team_players` DISABLE KEYS ;
/*!40000 ALTER TABLE `team_players` ENABLE KEYS ;
UNLOCK TABLES;
*/
--
-- Table structure for table `team_tournaments`
--

DROP TABLE IF EXISTS `team_tournaments`;
CREATE TABLE `team_tournaments` (
  `assists` int NOT NULL,
  `commited_blocks` int NOT NULL,
  `commited_fouls` int NOT NULL,
  `defensive_rebounds` int NOT NULL,
  `free_throws_attempted` int NOT NULL,
  `free_throws_made` int NOT NULL,
  `free_throws_percentage` int NOT NULL,
  `minutes` int NOT NULL,
  `offensive_rebounds` int NOT NULL,
  `points` int NOT NULL,
  `recieved_blocks` int NOT NULL,
  `recieved_fouls` int NOT NULL,
  `steals` int NOT NULL,
  `three_points_attempted` int NOT NULL,
  `three_points_made` int NOT NULL,
  `three_points_percentage` int NOT NULL,
  `total_rebounds` int NOT NULL,
  `turnovers` int NOT NULL,
  `two_points_attempted` int NOT NULL,
  `two_points_made` int NOT NULL,
  `two_points_percentage` int NOT NULL,

  `tournament_id` bigint NOT NULL,
  `team_id` bigint NOT NULL,
  KEY `fk_tournament` (`tournament_id`),
  KEY `fk_team_tournaments` (`team_id`),
  CONSTRAINT `fk_team_tournaments` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`),
  CONSTRAINT `fk_tournament` FOREIGN KEY (`tournament_id`) REFERENCES `tournament` (`id`)
); -- ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/* !40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_tournaments`
--

LOCK TABLES `team_tournaments` WRITE;
UNLOCK TABLES;

/*
--
-- Table structure for table `tournament_games`
--

DROP TABLE IF EXISTS `tournament_games`;
CREATE TABLE `tournament_games` (
  `tournament_id` bigint NOT NULL,
  `games_id` bigint NOT NULL,
  UNIQUE KEY `UK_cmj7ch4c9r7m64vwbavgeewen` (`games_id`),
  KEY `FKlr9rld6ddhjf4i9kkt46semhy` (`tournament_id`),
  CONSTRAINT `FKi63alm8l9mrwr6jxw6aicx2fq` FOREIGN KEY (`games_id`) REFERENCES `game` (`id`),
  CONSTRAINT `FKlr9rld6ddhjf4i9kkt46semhy` FOREIGN KEY (`tournament_id`) REFERENCES `tournament` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client ;

--
-- Dumping data for table `tournament_games`
--

LOCK TABLES `tournament_games` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `tournament_teams`
--

DROP TABLE IF EXISTS `tournament_teams`;
CREATE TABLE `tournament_teams` (
  `tournament_id` bigint NOT NULL,
  `teams_team_id` bigint NOT NULL,
  `teams_tournament_id` bigint NOT NULL,
  UNIQUE KEY `UK_ifvjtyteuvq4mypvd6vgcu7fo` (`teams_team_id`,`teams_tournament_id`),
  KEY `FKi2xkpjk2bkpniv5lp7pq3ushl` (`tournament_id`),
  CONSTRAINT `FKi2xkpjk2bkpniv5lp7pq3ushl` FOREIGN KEY (`tournament_id`) REFERENCES `tournament` (`id`),
  CONSTRAINT `FKms19pjldi5bpy1oar7okos81s` FOREIGN KEY (`teams_team_id`, `teams_tournament_id`) REFERENCES `team_tournaments` (`team_id`, `tournament_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client ;

--
-- Dumping data for table `tournament_teams`
--

LOCK TABLES `tournament_teams` WRITE;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE ;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS ;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS ;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT ;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS ;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION ;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-14 11:08:07
