package ladder.domain;

public class LadderGame {

    private final Players players;
    private final Lines lines;
    private final LadderGameResult ladderGameResult;

    public LadderGame(Players players, Lines lines, LadderGameResult result) {
        this.players = players;
        this.lines = lines;
        this.ladderGameResult = result;
    }

    public static LadderGame createLadder(final Players players,
                                          final int height,
                                          final LadderGameResult result) {
        LadderGenerator ladderGenerator =
                new LadderGenerator(players.getPlayersCount(), height);
        Lines lines = ladderGenerator.generateLines();

        return new LadderGame(players, lines, result);
    }

    public Node getPlayerResult(String playerName) {
        int playerIndex = players.findPlayer(playerName);
        return lines.move(playerIndex);
    }

    public Lines getLines() {
        return lines;
    }

    public Players getPlayers() {
        return players;
    }
}
