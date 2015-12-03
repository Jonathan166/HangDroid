package davinci.jlangf16.hangdroid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TextActivity extends ActionBarActivity {

    private EditText editText;
    private SharedPreferences preferences;
    private TextView textView;
    private String textWord;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        //get text message from shared preferences
        preferences = getSharedPreferences("TEXT_MSGS", MODE_PRIVATE);
        //read preferences
        getTextFromPref();
    }

    public void getTextFromPref(){
        //get text message from shared preferences
        //preferences = getSharedPreferences("TEXT_MSGS", MODE_PRIVATE);
        //read preferences
        textWord = preferences.getString("TextedWord", "NO WORD"); //NO WORD if preferences not found
        //get the textview for texted word
        if(textWord == "NO WORD"){
            textWord = "";
            Toast.makeText(this, "No Text Received", Toast.LENGTH_LONG).show();
        }
        Log.d("MYLOG", "Texted Word: " + textWord);

        //put texted word in textview
        textView = (TextView) findViewById(R.id.editTextWord);
        textView.setText(textWord);
    }
}
