package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @DisplayName("Lines에 Line을 새로 추가하고 반환한다")
    @Test
    public void addLine_success() throws Exception {
        //given
        Lines lines = new Lines();
        Line line = new Line(Arrays.asList(new Node(2, new Way(false, false))));

        //when
        lines = lines.addLine(line);

        //then
        assertThat(lines.size()).isEqualTo(1);
        assertThat(lines.getLine(0).getNode(0).getIndex()).isEqualTo(2);
    }

    @DisplayName("사다리 이동 결과 확인")
    @Test
    public void move() throws Exception {
        //given
        Lines lines = new Lines(
                Arrays.asList(
                        new Line(Arrays.asList(
                                new Node(0, new Way(false, true)),
                                new Node(1, new Way(true, false)))
                        ),
                        new Line(Arrays.asList(
                                new Node(0, new Way(false, true)),
                                new Node(1, new Way(true, false)))
                        )));

        //when
        Node move1 = lines.move(0);
        Node move2 = lines.move(1);

        //then
        assertThat(move1.getIndex()).isEqualTo(0);
        assertThat(move2.getIndex()).isEqualTo(1);
    }
}
