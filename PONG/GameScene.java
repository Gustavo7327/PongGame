package PONG;


public class GameScene {
    
    private int ballYSpeed = 1;
    private int ballXSpeed = 1;
    private double playerOneYPos = GameStart.GAME_HEIGHT / 2;
    private double playerTwoYPos = GameStart.GAME_HEIGHT / 2;
    private double ballXPos = GameStart.GAME_WIDTH / 2;
    private double ballYPos = GameStart.GAME_WIDTH / 2;
    private int scoreP1 = 0;
    private int scoreP2 = 0;
    private double playerOneXPos = 0;
    private double playerTwoXPos = GameStart.GAME_WIDTH - PLAYER_WIDTH;
    private static final int PLAYER_WIDTH = 15;
    private static final int PLAYER_HEIGHT = 100;
    private static final double BALL_R = 15;

    
}