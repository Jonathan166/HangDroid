package davinci.jlangf16.hangdroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GameWin extends ActionBarActivity {
    private int playerPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_win);

        int points = getIntent().getIntExtra("PointsID", 0);
        TextView textView = (TextView) findViewById(R.id.textViewPoints);
        textView.setText(String.valueOf(points));

        playerPoints = points;
    }

    public void saveScore(View view){
        //Set up to store preferences
        SharedPreferences preferences = getSharedPreferences("WORD_SCORES", Context.MODE_PRIVATE);
        //get name from game over XML
        EditText editText = (EditText) findViewById(R.id.editTextName);
        //set it to a String
        String name = editText.getText().toString();

        //start the preferences editor
        SharedPreferences.Editor editor = preferences.edit();
        //get previous scores using the key
        String previousScores = preferences.getString("SCORES", "");

        //key = scores, value = concatinated string
        editor.putString("SCORES", name + " " + playerPoints + " POINTS\n" + previousScores);
        //saves buffer
        editor.commit();

        //name x points \n name2 y points

        Toast.makeText(this, "Score Saved", Toast.LENGTH_SHORT).show();
        editText.setText("");
        //finish
    }

}
