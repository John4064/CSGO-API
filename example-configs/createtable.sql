create table hltv_match(
    team_a varchar(255),
    team_b varchar(255),
    match_url varchar(255),
    competition varchar(255),
    type_of_match varchar(255),
    score_ta Integer,
    score_tb Integer,
    match_id varchar(100) NOT NULL PRIMARY KEY
);
