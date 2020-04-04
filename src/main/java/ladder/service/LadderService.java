package ladder.service;

import ladder.domain.LadderGame;
import ladder.domain.LadderPrize;
import ladder.domain.Node;
import ladder.domain.Players;
import ladder.utils.StringUtils;

import java.util.List;

public class LadderService {

    private static final String COMMA = ",";

    public LadderGame createLadder(final String inputName,
                                   final String inputHeight,
                                   final String inputResult) {
        List<String> names = StringUtils.splitStringToList(inputName, COMMA);
        List<String> gameResults = StringUtils.splitStringToList(inputResult, COMMA);
        int height = StringUtils.stringToInt(inputHeight);

        Players players = Players.of(names);
        LadderPrize ladderPrize = new LadderPrize(gameResults);
        LadderGame game = LadderGame.createLadder(players, height, ladderPrize);

        return game;
    }

    public Node startGameOfPlayer(final String inputName, LadderGame ladderGame) {
        return ladderGame.getPlayerResult(inputName);
    }
}
