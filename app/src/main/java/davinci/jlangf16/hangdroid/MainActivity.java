package davinci.jlangf16.hangdroid;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    int backButtonCount = 0;

    public void activityGame(View view){
        Toast.makeText(getBaseContext(), "You clicked on Single Player", Toast.LENGTH_LONG) .show();
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSinglePlayerGame(View view){
        //explicit intent sends a message to start an activity
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void startMultiPlayerGame(View view){
        //explicit intent sends a message to start an activity
        Intent intent = new Intent(this, MultiPlayerActivity.class);
        startActivity(intent);
    }

    public void startTextPlayerGame(View view){
        //explicit intent sends a message to start an activity
        Intent intent = new Intent(this, TextActivity.class);
        startActivity(intent);
    }

    public void startContacts(View view){
        //opens contacts
        //explicit intent sends a message to start an activity
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }


    public void openScores(View view) {
        //update scores xml
        Intent intent = new Intent(this, ScoreActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed()
    {
        if(backButtonCount >= 1)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Press the back button once again to close the application.", Toast.LENGTH_SHORT).show();
            backButtonCount++;
        }
    }


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
}
