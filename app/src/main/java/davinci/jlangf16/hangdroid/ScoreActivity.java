package davinci.jlangf16.hangdroid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.TextView;

public class ScoreActivity extends ActionBarActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        //find preferences
        SharedPreferences preferences = getSharedPreferences("WORD_SCORES",MODE_PRIVATE);
        //read preferences
        String scores = preferences.getString("SCORES", "NO SCORES");//NO SCORES if preferences not found
        //get the textView for scores
        TextView textView = (TextView) findViewById(R.id.textViewScores);
        //get scores in textView
        textView.setText(scores);
    }

}
