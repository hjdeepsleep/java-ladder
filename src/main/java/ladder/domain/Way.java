package ladder.domain;

import ladder.exception.LadderException;

public class Way {

    private static final String TWO_WAY_MOVE_POSSIBLE = "양방향 이동은 불가";

    private final boolean left;
    private final boolean right;

    private Way(final boolean left, final boolean right) {
        validate(left, right);
        this.left = left;
        this.right = right;
    }

    public static Way from(final LadderMoveStrategy strategy) {
        return new Way(false, strategy.move());
    }

    private void validate(final boolean left, final boolean right) {
        if (left && right) {
            throw new LadderException(TWO_WAY_MOVE_POSSIBLE);
        }
    }

    public Way next(final LadderMoveStrategy strategy) {
        if (right) {
            return new Way(true, false);
        }
        return new Way(false, strategy.move());
    }

    public Way last() {
        if (right) {
            return new Way(true, false);
        }
        return new Way(false, false);
    }

    public boolean isMovableLeft() {
        return left;
    }

    public boolean isMovableRight() {
        return right;
    }
}
