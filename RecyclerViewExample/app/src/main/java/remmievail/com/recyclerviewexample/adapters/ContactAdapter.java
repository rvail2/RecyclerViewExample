package remmievail.com.recyclerviewexample.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import remmievail.com.recyclerviewexample.R;
import remmievail.com.recyclerviewexample.model.Contact;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<Contact> mContactList;

    public ContactAdapter(final List<Contact> contactList) {
        mContactList = contactList;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.adapter_contact, parent, false);

        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.setData(mContactList.get(position));
    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }

    protected static class ContactViewHolder extends RecyclerView.ViewHolder {

        private TextView mFirstName;
        private TextView mLastName;
        private TextView mEmail;

        public ContactViewHolder(View itemView) {
            super(itemView);
            mFirstName = (TextView) itemView.findViewById(R.id.firstName);
            mLastName = (TextView) itemView.findViewById(R.id.lastName);
            mEmail = (TextView) itemView.findViewById(R.id.email);
        }

        public void setData(final Contact contact) {
            mFirstName.setText(contact.getFirstName());
            mLastName.setText(contact.getLastName());
            mEmail.setText(contact.getEmail());
        }
    }
}
