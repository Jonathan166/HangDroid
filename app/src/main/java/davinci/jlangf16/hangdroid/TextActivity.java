package davinci.jlangf16.hangdroid;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TextActivity extends ActionBarActivity {

    private EditText editText;
    private SharedPreferences preferences;
    private TextView textView;
    private String textWord;
    private String friendPhone;
    private String texterPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        //get text message from shared preferences
        preferences = getSharedPreferences("TEXT_MSGS", MODE_PRIVATE);
        friendPhone = getIntent().getStringExtra("Phone");

        Log.d("MYLOG", "Friend: " + friendPhone);
        //read preferences
        getTextFromPref();
    }

    public void setTextMessage(View view){
        getTextFromPref();
    }

    public void getTextFromPref(){
        //get text message from shared preferences
        //preferences = getSharedPreferences("TEXT_MSGS", MODE_PRIVATE);
        //read preferences
        textWord = preferences.getString("TextedWord", "NO WORD"); //NO WORD if preferences not found
        texterPhone = preferences.getString("TexterPhone", "NO PHONE");
        textView = (TextView) findViewById(R.id.editTextWord);

        boolean phone = true;
        boolean word = true;
        boolean friend = true;

        if(textWord == "NO WORD"){
            word = false;
        }
        if(texterPhone == "NO PHONE"){
            phone = false;
        }
        if(friendPhone == null){
            friend = false;
        }

        //word but no friend selected
        if(!friend && word){
            textView.setText(textWord);
            textWord = "";
            texterPhone = "";
            return;
        }
        if(phone && word){
            if(friendPhone.equals(texterPhone)){
                textView.setText(textWord);
                textWord = "";
                texterPhone = "";
            }else{
                Toast.makeText(this, "No Text from Selected Friend", Toast.LENGTH_LONG).show();
            }
            return;
        }
        if(!word){
            Toast.makeText(this, "No Text Received", Toast.LENGTH_LONG).show();
        }
    }

    //play button
    public void playMultiPlayerGame(View view){
        //connect to XML
        //get word and cast word to a String
        String textWord = textView.getText().toString();
        if(textWord.length() > 0){
            //clear field for the next word
            textView.setText("");
            //clear word from sharedPreferences
            preferences.edit().remove("TextedWord").apply();
            Log.d("MYLOG", "Removed Texted Word: " + textView);
            //create intent
            Intent intent = new Intent(this, GameMultiActivity.class);
            //send word with intent
            intent.putExtra("GUESS_WORD", textWord);
            //intent.putExtra("GUESS_WORD", wordToGuess);
            //start activity
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "No Word Found - Try GET NEW TEXT", Toast.LENGTH_LONG).show();
        }
    }

}
