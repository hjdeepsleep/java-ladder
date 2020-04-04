package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LineTest {

    @DisplayName("생성자 테스트")
    @Test
    public void constructor_success() throws Exception {
        //given
        ArrayList<Node> nodes = new ArrayList<>(
                Arrays.asList(
                        new Node(0, new Way(false, false)),
                        new Node(1, new Way(false, false))));
        Line line = new Line(nodes);
    }

    @DisplayName("다음 노드를 생성후 더해준다: 노드가 하나도 없을 때")
    @Test
    public void addRandomNextNode_success_nodeEmpty() throws Exception {
        //given
        Line line = new Line();

        //when
        line = line.addRandomNextNode(true);

        //then
        assertThat(line.size()).isEqualTo(1);
        assertFalse(line.getNode(0).isMovableLeft());
        assertTrue(line.getNode(0).isMovableRight());
    }

    @DisplayName("마지막 노드를 추가해 준다")
    @Test
    public void addLastNode_success() throws Exception {
        //given
        Line line = new Line(Arrays.asList(new Node(0, new Way(false, false))));

        //when
        line = line.addLastNode();
        final int nodesSize = line.getNodes().size();

        //then
        assertFalse(line.getNodes().get(nodesSize - 1).isMovableRight());
    }

    @DisplayName("객체 복사")
    @Test
    public void clone_success() throws Exception {
        //given
        Line line = new Line(Arrays.asList(new Node(0, new Way(false, false))));

        //when
        Line clone = line.clone();

        //then
        assertThat(clone.size()).isEqualTo(line.size());
    }
}
