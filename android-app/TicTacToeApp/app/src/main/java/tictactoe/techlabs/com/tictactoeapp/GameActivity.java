package tictactoe.techlabs.com.tictactoeapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.techlabs.tic.tac.toe.game.Board;
import com.techlabs.tic.tac.toe.game.Game;
import com.techlabs.tic.tac.toe.game.Mark;
import com.techlabs.tic.tac.toe.game.Player;
import com.techlabs.tic.tac.toe.game.ResultAnalyzer;
import com.techlabs.tic.tac.toe.game.Status;

import org.json.JSONException;
import org.json.JSONObject;

public class GameActivity extends Activity {

    private Player player1, player2;
    private Board board;
    private ResultAnalyzer resultAnalyzer;
    private Game g;
    private TextView currentPlayer;
    private TextView currentMark;
    private TextView currentStatus;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Dialog winnerDialog;
    private Dialog drawDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_ui);

        btn1 = (Button) this.findViewById(R.id.btnId1);
        btn2 = (Button) this.findViewById(R.id.btnId2);
        btn3 = (Button) this.findViewById(R.id.btnId3);
        btn4 = (Button) this.findViewById(R.id.btnId4);
        btn5 = (Button) this.findViewById(R.id.btnId5);
        btn6 = (Button) this.findViewById(R.id.btnId6);
        btn7 = (Button) this.findViewById(R.id.btnId7);
        btn8 = (Button) this.findViewById(R.id.btnId8);
        btn9 = (Button) this.findViewById(R.id.btnId9);

        currentPlayer = (TextView) this.findViewById(R.id.currentPlayerText);
        currentMark = (TextView) this.findViewById(R.id.markText);
        currentStatus = (TextView) this.findViewById(R.id.statusText);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        try {
            JSONObject jsonObject = new JSONObject(extras.getString("playerInput"));
            //Log.d("msg",jsonObject.getString("mark"));

            String player1Name = jsonObject.getString("player1");
            String player2Name = jsonObject.getString("player2");
            String player1Mark = jsonObject.getString("mark");

            if (player1Mark.equals("O")) {
                player1 = new Player(player1Name, Mark.O);
                player2 = new Player(player2Name, Mark.X);
            } else {
                player1 = new Player(player1Name, Mark.X);
                player2 = new Player(player2Name, Mark.O);
            }

            board = new Board();
            resultAnalyzer = new ResultAnalyzer(board);
            g = new Game(player1, player2, board, resultAnalyzer);

            displayGameData(g);

            winnerDialog = new Dialog(this);
            drawDialog = new Dialog(this);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void selectPosition(View v) {

        if(g.getGameStatus() == Status.Progress || g.getGameStatus() == Status.Play) {

            boolean isPlayed = true;

            Button selectedBtn = (Button)this.findViewById(v.getId());

            if(selectedBtn.getText().equals("")){

                switch (v.getId()) {

                    case R.id.btnId1:
                        btn1.setText(g.getCurrentPlayer().getMarkChoice().toString());
                        isPlayed = g.play(1);
                        break;

                    case R.id.btnId2:
                        btn2.setText(g.getCurrentPlayer().getMarkChoice().toString());
                        isPlayed = g.play(2);
                        break;

                    case R.id.btnId3:
                        btn3.setText(g.getCurrentPlayer().getMarkChoice().toString());
                        isPlayed = g.play(3);
                        break;

                    case R.id.btnId4:
                        btn4.setText(g.getCurrentPlayer().getMarkChoice().toString());
                        isPlayed = g.play(4);
                        break;

                    case R.id.btnId5:
                        btn5.setText(g.getCurrentPlayer().getMarkChoice().toString());
                        isPlayed = g.play(5);
                        break;

                    case R.id.btnId6:
                        btn6.setText(g.getCurrentPlayer().getMarkChoice().toString());
                        isPlayed = g.play(6);
                        break;

                    case R.id.btnId7:
                        btn7.setText(g.getCurrentPlayer().getMarkChoice().toString());
                        isPlayed = g.play(7);
                        break;

                    case R.id.btnId8:
                        btn8.setText(g.getCurrentPlayer().getMarkChoice().toString());
                        isPlayed = g.play(8);
                        break;

                    case R.id.btnId9:
                        btn9.setText(g.getCurrentPlayer().getMarkChoice().toString());
                        isPlayed = g.play(9);
                        break;

                    default:
                        break;
                }

                displayGameData(g);

            } else {
                Toast.makeText(getApplicationContext(), "Already marked. Please mark another cell.", Toast.LENGTH_LONG).show();
            }

        }

        if(g.getGameStatus() == Status.Win){
            TextView winnerName;
            Button playAgain;
            Button tryAgain;

            winnerDialog.setContentView(R.layout.game_win_result);

            winnerName =(TextView) winnerDialog.findViewById(R.id.winnerName);
            playAgain = (Button) winnerDialog.findViewById(R.id.playAgain);
            tryAgain = (Button) winnerDialog.findViewById(R.id.tryBtn);

            winnerName.setText(g.getCurrentPlayer().getName());

            playAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }
            });

            tryAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    //System.exit(1);
                    //winnerDialog.dismiss();
                }
            });

            winnerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            winnerDialog.show();
        }

        if(g.getGameStatus() == Status.Draw){
            Button playAgain;
            Button tryAgain;

            drawDialog.setContentView(R.layout.game_draw_result);

            playAgain = (Button) drawDialog.findViewById(R.id.playAgainBtn);
            tryAgain = (Button) drawDialog.findViewById(R.id.tryBtn);

            playAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }
            });

            tryAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    //System.exit(1);
                    //drawDialog.dismiss();
                }
            });

            drawDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            drawDialog.show();

        }

    }

    private void displayGameData(Game g){
        currentPlayer.setText(g.getCurrentPlayer().getName());
        currentMark.setText(g.getCurrentPlayer().getMarkChoice().toString());
        currentStatus.setText(g.getGameStatus().toString());
    }

}
