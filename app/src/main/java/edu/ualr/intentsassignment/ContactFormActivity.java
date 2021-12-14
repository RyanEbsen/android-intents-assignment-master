package edu.ualr.intentsassignment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import edu.ualr.intentsassignment.model.Contact;

public class ContactFormActivity extends AppCompatActivity {
    Button save;
    public static final String EXTRA_CONTACT = "ContactData";
    // TODO 01. Create a new layout file to define the GUI elements of the ContactFormActivity.
    // TODO 02. Define the basic skeleton of the ContactFormActivity. Inflate the layout defined in the first step to display the GUI elements on screen.
    // TODO 06. Create a new method that reads the values in the several EditText elements of the layout and then uses the Contact class to send those data to ContactInfoActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactform);

        LayoutInflater inflater = getLayoutInflater();
        View myLayout = inflater.inflate(R.layout.contactform, null, false);

        save = findViewById((R.id.submit));
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity();
            }
        });

    }

    public void switchActivity() {
        EditText firstName, lastName, phone, email, address, website;

        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        website = findViewById(R.id.website);

        Contact c = new Contact(firstName.getText().toString(), lastName.getText().toString(),
                phone.getText().toString(), email.getText().toString(), address.getText().toString(), website.getText().toString());


        Intent intent = new Intent(ContactFormActivity.this, ContactInfoActivity.class);
        intent.putExtra(EXTRA_CONTACT, c);
        startActivity(intent);
    }
}
