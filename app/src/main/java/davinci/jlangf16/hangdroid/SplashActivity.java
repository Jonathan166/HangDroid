package davinci.jlangf16.hangdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Handler;

import org.apache.http.protocol.RequestUserAgent;

import java.util.logging.LogRecord;

public class SplashActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //expand the splash xml to a view
        setContentView(R.layout.activity_splash);

        //new thread
        Runnable wait3seconds = new Runnable() {
            @Override
            public void run() {
                nextActivity();
            }
        };

        Handler handler = new Handler();
        handler.postDelayed(wait3seconds, 3000);
    }

    public void nextActivity(){
        //start next Activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
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
