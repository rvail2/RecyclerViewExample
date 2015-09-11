package remmievail.com.recyclerviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import remmievail.com.recyclerviewexample.adapters.ContactAdapter;
import remmievail.com.recyclerviewexample.model.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        final ContactAdapter adapter = new ContactAdapter(getContacts());
        recyclerView.setAdapter(adapter);
    }

    private List<Contact> getContacts(){
        final List<Contact> contacts = new ArrayList<>();
        contacts.add(createContact("Bob", "White", "bwhite@yahoo.com"));
        contacts.add(createContact("Sue", "Green", "sgreen@gmail.com"));
        contacts.add(createContact("Mark", "Smith", "msmith@hotmail.com"));

        return contacts;
    }

    private Contact createContact(final String fname, final String lname, final String email){
        final Contact contact = new Contact();
        contact.setEmail(email);
        contact.setFirstName(fname);
        contact.setLastName(lname);
        return contact;
    }
}
