SET @path = 'C:/ProgramData/MySQL/MySQL Server 8.0/Data/db_goat/BBDD - IMG/';

INSERT into tournament (name, season, category, profileImage) values ('Federal', 2022, 17, CONCAT(@path, 'Tournaments/1.jpg'));
SET @federal_id = LAST_INSERT_ID();
INSERT into team (name, season, category, profileImage) values ('Berazategui', 2022, 17, CONCAT(@path, 'Teams/1.jpg'));
SET @bera_id = LAST_INSERT_ID();

INSERT INTO team_tournaments (tournament_id, team_id) values (@federal_id, @bera_id);

INSERT into tournament (name, season, category, profileImage) values ('Metropolitano', 2022, 17, CONCAT(@path, 'Tournaments/2.jpg'));
SET @metro_id = LAST_INSERT_ID();
INSERT into team (name, season, category, profileImage) values ('Ezeiza', 2022, 17, CONCAT(@path, 'Teams/2.jpg'));
SET @ezeiza_id = LAST_INSERT_ID();

INSERT INTO team_tournaments (tournament_id, team_id) values (@metro_id, @ezeiza_id);

INSERT INTO team (name, season, category, profileImage) values ('Tristan Suarez', 2022, 17, CONCAT(@path, 'Teams/3.jpg'));
SET @suarez_id = LAST_INSERT_ID();

INSERT INTO team_tournaments (tournament_id, team_id) values (@federal_id, @suarez_id);
INSERT INTO team_tournaments (tournament_id, team_id) values (@metro_id, @suarez_id);

INSERT INTO player (dni, birth, name, surname, profileImage) values (45678946, DATE '2005-09-24', 'Huilen', 'Miceli', CONCAT(@path, 'Players/45678946.jpg'));
INSERT INTO player_teams (team_id, player_dni) values (@suarez_id, 45678946);
INSERT INTO player (dni, birth, name, surname, profileImage) values (4614744, DATE '2006-02-04', 'Mia', 'Barrutia', CONCAT(@path, 'Players/4614744.jpg'));
INSERT INTO player_teams (team_id, player_dni) values (@suarez_id, 4614744);

INSERT INTO player (dni, birth, name, surname, profileImage) values (45611946, DATE '2005-11-17', 'Barbara', 'Velazquez', CONCAT(@path, 'Players/45611946.jpg'));
INSERT INTO player_teams (team_id, player_dni) values (@bera_id, 45611946);
INSERT INTO player (dni, birth, name, surname, profileImage) values (44685513, DATE '2005-04-12', 'Morena', 'Vazquez', CONCAT(@path, 'Players/44685513.jpg'));
INSERT INTO player_teams (team_id, player_dni) values (@bera_id, 44685513);

INSERT INTO player_teams (team_id, player_dni) values (@ezeiza_id, 44685513);
INSERT INTO player (dni, birth, name, surname, profileImage) values (44687961, DATE '2006-07-21', 'Sol', 'Moyano', CONCAT(@path, 'Players/44687961.jpg'));
INSERT INTO player_teams (team_id, player_dni) values (@ezeiza_id, 44687961);


INSERT INTO game (tournament_id) values (@metro_id);
SET @game_1 = LAST_INSERT_ID();
INSERT INTO player_games (player_dni, game_id) VALUES (45678946, @game_1);
INSERT INTO player_games (player_dni, game_id) VALUES (4614744, @game_1);
INSERT INTO team_games(team_id, game_id) values (@suarez_id, @game_1);

INSERT INTO player_games (player_dni, game_id) VALUES (44687961, @game_1);
INSERT INTO player_games (player_dni, game_id) VALUES (44685513, @game_1);
INSERT INTO team_games(team_id, game_id) values (@ezeiza_id, @game_1);


INSERT INTO game (tournament_id) values (@federal_id);
SET @game_2 = LAST_INSERT_ID();
INSERT INTO player_games (player_dni, game_id) VALUES (45678946, @game_2);
INSERT INTO player_games (player_dni, game_id) VALUES (4614744, @game_2);
INSERT INTO team_games(team_id, game_id) values (@suarez_id, @game_2);

INSERT INTO player_games (player_dni, game_id) VALUES (45611946, @game_2);
INSERT INTO player_games (player_dni, game_id) VALUES (44685513, @game_2);
INSERT INTO team_games(team_id, game_id) values (@bera_id, @game_2);