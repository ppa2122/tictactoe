package pl.kognitywistyka.ppa.tictactoe;

/**
 * Created by pwilkin on 13.01.2022.
 */
public class Statistics {

    protected int circleWins = 0;
    protected int crossWins = 0;
    protected int draws = 0;

    public int getCircleWins() {
        return circleWins;
    }

    public void setCircleWins(int circleWins) {
        this.circleWins = circleWins;
    }

    public int getCrossWins() {
        return crossWins;
    }

    public void setCrossWins(int crossWins) {
        this.crossWins = crossWins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void reset() {
        circleWins = 0;
        crossWins = 0;
        draws = 0;
    }

}
