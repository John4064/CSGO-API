class hltvMatch:
    matchId = 0
    url = ""
    teamA = ""
    teamB = ""
    scoreA = 0
    scoreB = 0
    competition = ""
    matchtype = ""

    def __init__(self, matchId, url, teamA, teamB, score_A, score_B, competiton, type):
        self.matchId = matchId
        self.url = url
        self.teamA = teamA
        self.teamB = teamB
        self.scoreA = score_A
        self.scoreB = score_B
        self.competition = competiton
        self.matchtype = type

    def setId(self, matchId):
        self.matchId = matchId

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
        self.matchtype = type

    def printAttr(self):
        print(
            "The Attributes are: {}, {}, {}, {}, {}, {}, {}, {}".format(self.url, self.teamA, self.teamB, self.matchId,
                                                                        self.matchtype, self.competition, self.scoreA,
                                                                        self.scoreB))
