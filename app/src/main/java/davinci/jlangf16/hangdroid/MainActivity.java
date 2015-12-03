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

    public void activityGame(View view){
        Toast.makeText(getBaseContext(), "You clicked on Single Player", Toast.LENGTH_LONG) .show();
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //create fragment manager allows you to interact with a fragment in an activity
        FragmentManager fragmentManager = getFragmentManager();
        //create fragment transaction allows us to call method to manage the fragments
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //set to change fragments on orientation - first get configuration information
        Configuration configuration = getResources().getConfiguration();

        if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            FragmentLandscape fragmentLandscape = new FragmentLandscape();
            fragmentTransaction.replace(android.R.id.content, fragmentLandscape);
        }else{
            FragmentPortrait fragmentPortrait = new FragmentPortrait();
            fragmentTransaction.replace(android.R.id.content, fragmentPortrait);
        }

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

    public void openScores(View view) {
        //update scores xml
        Intent intent = new Intent(this, ScoreActivity.class);
        startActivity(intent);
    }
        @Override
        public void onBackPressed(){
            Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
