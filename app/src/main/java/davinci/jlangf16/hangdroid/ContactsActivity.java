package davinci.jlangf16.hangdroid;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ContactsActivity extends ListActivity {

    ListView listView;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        startManagingCursor(cursor);
        final String[] Texter = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER};
        int[] item = {android.R.id.text1, android.R.id.text2};
        SimpleCursorAdapter listadapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, Texter, item, 0);
        setListAdapter(listadapter);

        listView = getListView();

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

//        listView.setOnItemClickListener((parent, view, position, id) {
//            String selectPhone = ((TextView)(listView.findViewById(android.R.id.text2))).getText().toString();
//
//            Log.d("MYLOG", "onClick: " + position + "/" + id + selectPhone);
//            Intent intent = new Intent(ContactsActivity.this, TextActivity.class);
//            intent.putExtra("Phone", selectPhone);
//            startActivity(intent);
//        });

    }
}
