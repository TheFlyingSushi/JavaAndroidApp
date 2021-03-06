package fall2018.csc2017.twentyfortyeight;

import android.content.Context;
import android.widget.Toast;

public class MovementController2048 {

    private BoardManager2048 boardManager = null;

    MovementController2048() {
    }

    // TODO: edit the class to get rid of unused lines or params
    public void setBoardManager(BoardManager2048 boardManager) {
        this.boardManager = boardManager;
    }

    //    public void processTapMovement(Context context, int instruction, boolean display) {
//        if (boardManager.isValidMove(instruction)) {
//            boardManager.touchMove(instruction);
//            if (boardManager.gameFinished()) {
//                Toast.makeText(context, "YOU WIN!", Toast.LENGTH_SHORT).show();
//            }
//        } else if (!this.boardManager.getBoardStatus()){
//            Toast.makeText(context, "Press back button to exit", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(context, "Invalid Tap", Toast.LENGTH_SHORT).show();
//        }
//    }
    void processSwipeMovement(Context context, int move, boolean display) {
        if (!boardManager.getBoardStatus()) {
            Toast.makeText(context, "The game is over, press back to return to the main menu", Toast.LENGTH_SHORT).show();
        } else if (boardManager.isValidTap(move)) {
            boardManager.touchMove(move);
            if (boardManager.gameFinished()) {
                Toast.makeText(context, "YOU WIN!", Toast.LENGTH_SHORT).show();
            } else if (boardManager.gameOver()) {
                Toast.makeText(context, "YOU LOSE!", Toast.LENGTH_SHORT).show();
            } else {
                int a = 0; // TODO: remove
            }
        } else {
            Toast.makeText(context, "Invalid Move", Toast.LENGTH_SHORT).show();
        }
    }
}
