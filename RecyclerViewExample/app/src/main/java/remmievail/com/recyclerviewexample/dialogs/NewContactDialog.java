package remmievail.com.recyclerviewexample.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import remmievail.com.recyclerviewexample.R;
import remmievail.com.recyclerviewexample.model.Contact;

public class NewContactDialog extends DialogFragment {

    private TextView firstName;
    private TextView lastName;
    private TextView email;
    private ContactSaveListener mContactSaveListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final LayoutInflater inflater = LayoutInflater.from(getActivity());
        final View view = inflater.inflate(R.layout.dialog_new_contact, null);
        firstName = (TextView) view.findViewById(R.id.firstName);
        lastName = (TextView) view.findViewById(R.id.lastName);
        email = (TextView) view.findViewById(R.id.email);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("New Contact")
            .setView(view)
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final Contact contact = new Contact();
                        contact.setFirstName(firstName.getText().toString());
                        contact.setLastName(lastName.getText().toString());
                        contact.setEmail(email.getText().toString());

                        mContactSaveListener.saveContact(contact);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });

        return builder.create();
    }

    public void setOnSaveListener(final ContactSaveListener listener){
        mContactSaveListener = listener;
    }

    public interface ContactSaveListener{
        void saveContact(Contact contact);
    }
}
