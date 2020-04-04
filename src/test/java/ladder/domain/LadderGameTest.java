package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @DisplayName("로또 게임 생성자 테스트")
    @Test
    public void constructor_success() throws Exception {
        //given
        Players players =
                new Players(Arrays.asList(new Player("a"), new Player("b")));
        Lines lines = new Lines(Arrays.asList(new Line(), new Line(), new Line()));

        //when
        LadderGame game = new LadderGame(players, lines);
    }

    @DisplayName("사다리 게임 생성")
    @Test
    public void createLadder_success() throws Exception {
        //given
        Players players =
                new Players(Arrays.asList(new Player("a"), new Player("b")));

        //when
        LadderGame game = LadderGame.createLadder(players, 3);

        //then
        assertThat(game.getLines().size()).isEqualTo(3);
        assertThat(game.getLines().getLine(0).size()).isEqualTo(2);
    }

    @DisplayName("참가자의 이름을 전달 받고 사다리 진행 결과 Node 반환")
    @Test
    public void getPlayerResult_success() throws Exception {
        //given
        final String playerName = "a";
        final Players players = Players.of(Arrays.asList("a", "b"));
        final Lines lines = new Lines(
                Arrays.asList(
                        new Line(Arrays.asList(
                                new Node(0, new Way(false, true)),
                                new Node(1, new Way(true, false)))
                        ),
                        new Line(Arrays.asList(
                                new Node(0, new Way(false, true)),
                                new Node(1, new Way(true, false)))
                        )));
        LadderGame game = new LadderGame(players, lines);

        //when
        Node result = game.getPlayerResult(playerName);

        //then
        assertThat(result.getIndex()).isEqualTo(0);
    }
}
