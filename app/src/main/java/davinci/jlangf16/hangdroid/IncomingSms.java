package davinci.jlangf16.hangdroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class IncomingSms extends BroadcastReceiver {

    final SmsManager sms = SmsManager.getDefault();

    public IncomingSms() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        final Bundle bundle = intent.getExtras();

        try{
            if(bundle != null){
                Log.d("MYLOG", "Bundle: " + bundle);

                //get pdu from bundle
                final Object[] pdus = (Object[]) bundle.get("pdus");
                //get format of bundle
                String format = bundle.getString("format");

                for(int i = 0; i < pdus.length; i++){
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();
                    String message = currentMessage.getDisplayMessageBody();

                    Log.d("MYLOG", "phone: " + phoneNumber + "; message: " + message);

                    //Show alert
                    Toast.makeText(context,"Text Received from " + phoneNumber, Toast.LENGTH_LONG).show();
                    //Set up to store preferences and add context because getSharedPreferences() needs it
                    SharedPreferences preferences = context.getSharedPreferences("TEXT_MSGS", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    Log.d("MYLOG", "TextedWord: " + message);
                    editor.putString("TextedWord", message);
                    editor.commit();
                }
            }
        }catch(Exception e){
            Log.e("SmsReceivier", "Exception smsReceiver" + e);
        }
    }
}
