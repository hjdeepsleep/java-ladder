package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private final List<Line> lines;

    public Lines() {
        this.lines = new ArrayList<Line>();
    }

    public Lines(final List<Line> lines) {
        this.lines = lines;
    }

    public Lines addLine(Line line) {
        List<Line> merge = new ArrayList<>();
        merge.addAll(this.lines);
        merge.add(line);
        return new Lines(merge);
    }

    public Node move(final int nodeNumber) {
        int move = nodeNumber;
        for (Line line : lines) {
            move = line.getNode(move).move();
        }
        return getLastLine().getNode(move);
    }

    private Line getLastLine() {
        return this.lines.get(size() - 1);
    }

    public int size() {
        return this.lines.size();
    }

    public List<Line> getLines() {
        return new ArrayList<>(this.lines);
    }

    public Line getLine(int index) {
        Line line = this.lines.get(index);
        return line.clone();
    }
}
