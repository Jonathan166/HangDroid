package davinci.jlangf16.hangdroid;

        import android.app.ListActivity;
        import android.content.Intent;
        import android.database.Cursor;
        import android.os.Bundle;
        import android.provider.ContactsContract;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ListView;
        import android.widget.SimpleCursorAdapter;
        import android.widget.TextView;

//-1- change extends to ListActivity
public class ContactsActivity extends ListActivity {

    //-2-declare ListView and Cursor attributes
    ListView listView;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);


        //-4- construct cursor...
        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        startManagingCursor(cursor); //replace by CursorLoader for async loading

        final String[] Texter = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER};

        //item is the combined layouts of text1 and text2
        int[] item = {android.R.id.text1, android.R.id.text2};


        SimpleCursorAdapter listadapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, Texter, item, 0); //new constructor set last para to 0

        setListAdapter(listadapter);

        listView = getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        //add listener to listview and respond to click by calling the TextActivity and send it the selected phone number
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //since the View is not the TextView itself, but the List Item's View.
                String selectPhone = ((TextView) (view.findViewById(android.R.id.text2))).getText().toString();

                Log.d("MYLOG", "onClick: " + position + "/" + id + "/" + selectPhone);

                //create intent
                Intent intent = new Intent(ContactsActivity.this, TextActivity.class);
                //send phone with intent
                intent.putExtra("Phone", selectPhone);
                //start activity
                startActivity(intent);
            }
        });

    }
}
