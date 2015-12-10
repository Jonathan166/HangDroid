package davinci.jlangf16.hangdroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GameWin extends ActionBarActivity {
    private int playerPoints = 0;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, ScoreActivity.class);
            startActivity(intent);
        }else if(id == R.id.action_settings2){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

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
        editor.putString("SCORES", name + " " + playerPoints + " Points\n" + previousScores);
        //saves buffer
        editor.commit();

        //name x points \n name2 y points

        Toast.makeText(this, "Score Saved", Toast.LENGTH_SHORT).show();
        editText.setText("");
        //finish
    }

}
