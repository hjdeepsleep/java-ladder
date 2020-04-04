package ladder.domain;

public class LadderGame {

    private final Players players;
    private final Lines lines;

    public LadderGame(Players players, Lines lines) {
        this.players = players;
        this.lines = lines;
    }

    public static LadderGame createLadder(Players players, int height) {
        LadderGenerator ladderGenerator =
                new LadderGenerator(players.getPlayersCount(), height);
        Lines lines = ladderGenerator.generateLines();

        return new LadderGame(players, lines);
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
