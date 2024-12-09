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

create table hltv_team(
    team_name varchar(255),
    "year" Integer,
    map_count Integer,
    kd_diff Integer,
    team_kd Float,
    average_rating Float,
    team_id Integer NOT NULL PRIMARY KEY
);