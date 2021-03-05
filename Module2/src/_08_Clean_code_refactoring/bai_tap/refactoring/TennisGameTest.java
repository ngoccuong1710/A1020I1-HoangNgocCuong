package _08_Clean_code_refactoring.bai_tap.refactoring;

public class TennisGameTest {
    private int player1Score;
    private int player2Score;
    private String expectedScore;

    public TennisGameTest(int player1Score, int player2Score, String expectedScore) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.expectedScore = expectedScore;
    }
    public void checkAllScores() {
        int highestScore = Math.max(this.player1Score, this.player2Score);
        int m_score1 = 0;
        int m_score2 = 0;
        for (int i = 0; i < highestScore; i++) {
            if (i < this.player1Score)
                m_score1 += 1;
            if (i < this.player2Score)
                m_score2 += 1;
        }
        assertEquals(this.expectedScore, TennisGame.getScore("John", "Bill", m_score1, m_score2));
    }

    private void assertEquals(String expectedScore, String score) {
    }
}
