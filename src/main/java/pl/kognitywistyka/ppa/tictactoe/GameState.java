package pl.kognitywistyka.ppa.tictactoe;

/**
 * Created by pwilkin on 09.12.2021.
 */
public class GameState {

    public enum TicOrTac {
        CIRCLE("O"),
        CROSS("X");

        private final String rep;

        TicOrTac(String rep) {
            this.rep = rep;
        }

        public String getRep() {
            return rep;
        }
    }

    public enum GameStage {
        START,
        PLAYING,
        CROSS_WINS,
        CIRCLE_WINS,
        TIE
    }

    private TicOrTac[][] matrix = new TicOrTac[3][3];
    private TicOrTac whoseTurn = TicOrTac.CROSS;
    private GameStage stage = GameStage.START;

    public TicOrTac getWinner() {
        switch (stage) {
            case CROSS_WINS:
                return TicOrTac.CROSS;
            case CIRCLE_WINS:
                return TicOrTac.CIRCLE;
            case START:
            case PLAYING:
            default:
                return null;
        }
    }

    private void determineIfSomeoneWins() {
        TicOrTac winner = determineWinnerOnRows();
        if (winner == null) {
            winner = determineWinnerOnColumns();
        }
        if (winner == null) {
            winner = determineWinnerOnDiagonals();
        }
        if (winner == TicOrTac.CROSS) {
            stage = GameStage.CROSS_WINS;
        } else if (winner == TicOrTac.CIRCLE) {
            stage = GameStage.CIRCLE_WINS;
        } else if (isFullMatrix()) {
            stage = GameStage.TIE;
        } else {
            stage = GameStage.PLAYING;
        }
    }

    private boolean isFullMatrix() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private TicOrTac determineWinnerOnRows() {
        for (int i = 0; i < 3; i++) {
            TicOrTac first = matrix[i][0];
            if (first != null) {
                boolean allEqual = true;
                for (int j = 1; j < 3; j++) {
                    if (matrix[i][j] != first) {
                        allEqual = false;
                        break;
                    }
                }
                if (allEqual) {
                    return first;
                }
            }
        }
        return null;
    }

    private TicOrTac determineWinnerOnColumns() {
        for (int i = 0; i < 3; i++) {
            TicOrTac first = matrix[0][i];
            if (first != null) {
                boolean allEqual = true;
                for (int j = 1; j < 3; j++) {
                    if (matrix[j][i] != first) {
                        allEqual = false;
                        break;
                    }
                }
                if (allEqual) {
                    return first;
                }
            }
        }
        return null;
    }

    private TicOrTac determineWinnerOnDiagonals() {
        // top left bottom right diagonal
        TicOrTac upwards = determineWinnerOnUpwardsDiagonal();
        if (upwards != null) {
            return upwards;
        } else {
            return determineWinnerOnDownwardsDiagonal();
        }
    }

    private TicOrTac determineWinnerOnDownwardsDiagonal() {
        TicOrTac first = matrix[2][0];
        if (first != null) {
            boolean allEqual = true;
            for (int i = 1; i < 3; i++) {
                if (matrix[2 - i][i] != first) {
                    allEqual = false;
                    break;
                }
            }
            if (allEqual) {
                return first;
            }
        }
        return null;
    }

    private TicOrTac determineWinnerOnUpwardsDiagonal() {
        TicOrTac first = matrix[0][0];
        if (first != null) {
            boolean allEqual = true;
            for (int i = 1; i < 3; i++) {
                if (matrix[i][i] != first) {
                    allEqual = false;
                    break;
                }
            }
            if (allEqual) {
                return first;
            }
        }
        return null;
    }

    public boolean isLegalMove(int x, int y) {
        return matrix[x][y] == null;
    }

    public void makeAMove(int x, int y) {
        if (isLegalMove(x, y)) {
            matrix[x][y] = whoseTurn;
            whoseTurn = (whoseTurn == TicOrTac.CIRCLE) ? TicOrTac.CIRCLE : TicOrTac.CROSS;
            determineIfSomeoneWins();
        } else {
            throw new IllegalArgumentException("Illegal move: x = " + x + ", y = " + y);
        }
    }

    public TicOrTac getWhoseTurn() {
        return whoseTurn;
    }

    public GameStage getStage() {
        return stage;
    }

    public TicOrTac getField(int x, int y) {
        return matrix[x][y];
    }

    public void reset() {
        matrix = new TicOrTac[3][3];
        stage = GameStage.START;
        whoseTurn = TicOrTac.CROSS;
    }

}
