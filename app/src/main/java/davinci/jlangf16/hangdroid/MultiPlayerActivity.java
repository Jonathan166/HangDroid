package davinci.jlangf16.hangdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MultiPlayerActivity extends ActionBarActivity {

    EditText editText; //declared class attribute for a listener

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
        setContentView(R.layout.activity_multi_player);

        //connect to XML
        editText = (EditText) findViewById(R.id.editTextWord);

        //add listener
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("MYLOG", "beforeTextChanged " + " Start: " + start + " Count: " + count + " After: " + after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("MYLOG", "onTextChanged " + " Start: " + start + " Before:" + before + " Count: " + count);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("MYLOG", "afterTextChanged " + s);
            }
        });
    }

    public void playMultiPlayerGame(View view) {
        //create new editText object from XML
        EditText editText = (EditText) findViewById(R.id.editTextWord);
        //get word and cast word to a String
        String wordToGuess = editText.getText().toString();
        //debug
        Log.d("MYLOG", "Multi-Player Word: " + wordToGuess);
        //create intent
        Intent intent = new Intent(this, GameMultiActivity.class);
        //send word with intent
        intent.putExtra("GUESS_WORD", wordToGuess);
        //start activity
        startActivity(intent);
    }

}//end of class
