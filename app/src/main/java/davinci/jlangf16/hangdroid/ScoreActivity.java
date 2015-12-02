package davinci.jlangf16.hangdroid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class ScoreActivity extends ActionBarActivity {

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
