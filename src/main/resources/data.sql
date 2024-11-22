-- Insert data into team
INSERT INTO team (team_id, name, official_name, slug, abbreviation, team_country_code, stage_position) VALUES (1, 'Al Shabab', 'Al Shabab FC', 'al-shabab-fc', 'SHA', 'KSA', NULL);
INSERT INTO team (team_id, name, official_name, slug, abbreviation, team_country_code, stage_position) VALUES (2, 'Nasaf', 'FC Nasaf', 'fc-nasaf-qarshi', 'NAS', 'UZB', NULL);
INSERT INTO team (team_id, name, official_name, slug, abbreviation, team_country_code, stage_position) VALUES (3, 'Al Hilal', 'Al Hilal Saudi FC', 'al-hilal-saudi-fc', 'HIL', 'KSA', NULL);
INSERT INTO team (team_id, name, official_name, slug, abbreviation, team_country_code, stage_position) VALUES (4, 'Shabab Al Ahli', 'SHABAB AL AHLI DUBAI', 'shabab-al-ahli-club', 'SAH', 'UAE', NULL);
INSERT INTO team (team_id, name, official_name, slug, abbreviation, team_country_code, stage_position) VALUES (5, 'Al Duhail', 'AL DUHAIL SC', 'al-duhail-sc', 'DUH', 'QAT', NULL);
INSERT INTO team (team_id, name, official_name, slug, abbreviation, team_country_code, stage_position) VALUES (6, 'Al Rayyan', 'AL RAYYAN SC', 'al-rayyan-sc', 'RYN', 'QAT', NULL);
INSERT INTO team (team_id, name, official_name, slug, abbreviation, team_country_code, stage_position) VALUES (7, 'Al Faisaly', 'Al Faisaly FC', 'al-faisaly-fc', 'FAI', 'KSA', NULL);
INSERT INTO team (team_id, name, official_name, slug, abbreviation, team_country_code, stage_position) VALUES (8, 'Foolad', 'FOOLAD KHOUZESTAN FC', 'foolad-khuzestan-fc', 'FLD', 'IRN', NULL);
INSERT INTO team (team_id, name, official_name, slug, abbreviation, team_country_code, stage_position) VALUES (9, 'Urawa Reds', 'Urawa Red Diamonds', 'urawa-red-diamonds', 'RED', 'JPN', NULL);
ALTER TABLE team ALTER COLUMN team_id RESTART WITH 10;

-- Insert data into player
INSERT INTO player (player_id, name, birthday, jersey_number, team_id) VALUES (1, 'Salem Al Dawsari', 1991, 11, 3);
INSERT INTO player (player_id, name, birthday, jersey_number, team_id) VALUES (2, 'Odil Akhmedov', 1987, 7, 2);
INSERT INTO player (player_id, name, birthday, jersey_number, team_id) VALUES (3, 'Andre Carrillo', 1991, 9, 3);
INSERT INTO player (player_id, name, birthday, jersey_number, team_id) VALUES (4, 'Fabio Lima', 1987, 10, 4);
INSERT INTO player (player_id, name, birthday, jersey_number, team_id) VALUES (5, 'Youssef Msakni', 1990, 11, 5);
INSERT INTO player (player_id, name, birthday, jersey_number, team_id) VALUES (6, 'Mohammed Al-Breik', 1993, 13, 3);
INSERT INTO player (player_id, name, birthday, jersey_number, team_id) VALUES (7, 'Abdullah Al-Muwallad', 1994, 15, 7);
INSERT INTO player (player_id, name, birthday, jersey_number, team_id) VALUES (8, 'Vahid Amiri', 1990, 8, 8);
INSERT INTO player (player_id, name, birthday, jersey_number, team_id) VALUES (9, 'Tatsuya Ito', 1996, 22, 9);
ALTER TABLE player ALTER COLUMN player_id RESTART WITH 10;


-- Insert data into stage
INSERT INTO stage (stage_id, name, ordering) VALUES (1, 'GROUP STAGE', 1);
INSERT INTO stage (stage_id, name, ordering) VALUES (2, 'SEMIFINAL', 6);
INSERT INTO stage (stage_id, name, ordering) VALUES (3, 'ROUND OF 16', 4);
INSERT INTO stage (stage_id, name, ordering) VALUES (4, 'FINAL', 7);
INSERT INTO stage (stage_id, name, ordering) VALUES (5, 'SEMIFINAL', 3);
ALTER TABLE stage ALTER COLUMN stage_id RESTART WITH 6;


-- Insert data into result
INSERT INTO result (result_id, home_goals, away_goals, winner, message) VALUES (1, 1, 2, 'Nasaf', NULL);
INSERT INTO result (result_id, home_goals, away_goals, winner, message) VALUES (2, 0, 0, NULL, NULL);
INSERT INTO result (result_id, home_goals, away_goals, winner, message) VALUES (3, 0, 0, NULL, NULL);
INSERT INTO result (result_id, home_goals, away_goals, winner, message) VALUES (4, 0, 0, NULL, NULL);
ALTER TABLE result ALTER COLUMN result_id RESTART WITH 5;


-- Insert data into card
INSERT INTO card (card_id, card_type, reason, time, result_id, player_id) VALUES (1, 'yellow', 'Foul', 20, 1, 2);
INSERT INTO card (card_id, card_type, reason, time, result_id, player_id) VALUES (2, 'yellow', 'Foul', 45, 1, 2);
INSERT INTO card (card_id, card_type, reason, time, result_id, player_id) VALUES (3, 'red', 'Second Yellow', 45, 1, 2);
INSERT INTO card (card_id, card_type, reason, time, result_id, player_id) VALUES (4, 'yellow', 'Dissent', 30, 2, 1);
INSERT INTO card (card_id, card_type, reason, time, result_id, player_id) VALUES (5, 'yellow', 'Handball', 60, 2, 3);
INSERT INTO card (card_id, card_type, reason, time, result_id, player_id) VALUES (6, 'red', 'Violent Conduct', 75, 2, 4);
INSERT INTO card (card_id, card_type, reason, time, result_id, player_id) VALUES (7, 'yellow', 'Foul', 15, 3, 5);
INSERT INTO card (card_id, card_type, reason, time, result_id, player_id) VALUES (8, 'yellow', 'Time Wasting', 80, 3, 5);
INSERT INTO card (card_id, card_type, reason, time, result_id, player_id) VALUES (9, 'red', 'Second Yellow', 80, 3, 5);
INSERT INTO card (card_id, card_type, reason, time, result_id, player_id) VALUES (10, 'yellow', 'Dissent', 25, 4, 7);
INSERT INTO card (card_id, card_type, reason, time, result_id, player_id) VALUES (11, 'yellow', 'Foul', 55, 4, 8);
ALTER TABLE card ALTER COLUMN card_id RESTART WITH 12;


-- Insert data into goal
INSERT INTO goal (goal_id, time, result_id, player_id) VALUES (1, 15, 1, 2);
INSERT INTO goal (goal_id, time, result_id, player_id) VALUES (2, 35, 1, 2);
INSERT INTO goal (goal_id, time, result_id, player_id) VALUES (3, 50, 1, 1);
ALTER TABLE goal ALTER COLUMN goal_id RESTART WITH 4;


-- Insert data into match
INSERT INTO match (match_id, season, status, date_time, stadium, match_group, origin_competition_id, origin_competition_name, home_team_id, away_team_id, result_id, stage_id) VALUES (1, 2024, 'played', '2024-01-03 00:00:00', NULL, NULL, 'afc-champions-league', 'AFC Champions League', 1, 2, 1, 1);
INSERT INTO match (match_id, season, status, date_time, stadium, match_group, origin_competition_id, origin_competition_name, home_team_id, away_team_id, result_id, stage_id) VALUES (2, 2024, 'scheduled', '2024-01-03 16:00:00', NULL, NULL, 'afc-champions-league', 'AFC Champions League', 3, 4, 2, 2);
INSERT INTO match (match_id, season, status, date_time, stadium, match_group, origin_competition_id, origin_competition_name, home_team_id, away_team_id, result_id, stage_id) VALUES (3, 2024, 'scheduled', '2024-01-04 15:25:00', NULL, NULL, 'afc-champions-league', 'AFC Champions League', 5, 6, 3, 3);
INSERT INTO match (match_id, season, status, date_time, stadium, match_group, origin_competition_id, origin_competition_name, home_team_id, away_team_id, result_id, stage_id) VALUES (4, 2024, 'scheduled', '2024-01-04 08:00:00', NULL, NULL, 'afc-champions-league', 'AFC Champions League', 7, 8, 4, 4);
INSERT INTO match (match_id, season, status, date_time, stadium, match_group, origin_competition_id, origin_competition_name, home_team_id, away_team_id, result_id, stage_id) VALUES (5, 2024, 'scheduled', '2024-01-19 00:00:00', NULL, NULL, 'afc-champions-league', 'AFC Champions League', NULL, 9, NULL, 5);
ALTER TABLE match ALTER COLUMN match_id RESTART WITH 6;
