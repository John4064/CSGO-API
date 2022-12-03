class hltvMatch:
    matchid = 0
    url = ""
    teamA = ""
    teamB = ""
    scoreA = 0
    scoreB = 0
    competition = ""
    typeofmatch = ""

    def __init__(self, matchid, url, teamA, teamB, score_A, score_B, competiton, type):
        self.matchid = matchid
        self.url = url
        self.teamA = teamA
        self.teamB = teamB
        self.scoreA = score_A
        self.scoreB = score_B
        self.competition = competiton
        self.typeofmatch = type

    def setId(self, matchId):
        self.matchid = matchId

    def setUrl(self, url):
        self.url = url

    def setteamA(self, teamA):
        self.teamA = teamA

    def setteamB(self, teamB):
        self.teamB = teamB

    def setscoreA(self, score_A):
        self.scoreA = score_A

    def setscoreB(self, score_B):
        self.scoreB = score_B

    def setCompetition(self, comp):
        self.competition = comp

    def setmatchType(self, type):
        self.typeofmatch = type

    def printAttr(self):
        print(
            "The Attributes are: {}, {}, {}, {}, {}, {}, {}, {}".format(self.url, self.teamA, self.teamB, self.matchid,
                                                                        self.typeofmatch, self.competition, self.scoreA,
                                                                        self.scoreB))
