package edu.ualr.intentsassignment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;

import edu.ualr.intentsassignment.model.Contact;

public class ContactInfoActivity extends AppCompatActivity {
    TextView name, phone, emailAddress, address, website;
    Chip call, text, email, map, web;
    // TODO 03. Create a new layout file to define the GUI elements of the ContactInfoActivity.
    // TODO 04. Define the basic skeleton of the ContactInfoActivity. Inflate the layout defined in the first step to display the GUI elements on screen.
    // TODO 07. Create a new method that reads the contact info coming from ContactFormActivity and use it to populate the several TextView elements in the layout.
    // TODO 08. Create a new method that invokes a Phone Dialer app, using as parameter the phone number included in the contact info received from ContactFormActivity in the previous step
    // TODO 09. Create a new method that invokes a Messages app, using as parameter the phone number included in the contact info received from ContactFormActivity in the 7th step
    // TODO 10. Create a new method that invokes a Maps app, using as parameter the address included in the contact info received from ContactFormActivity in the 7th step
    // TODO 11. Create a new method that invokes an Email app, using as parameter the email address included in the contact info received from ContactFormActivity in the 7th step
    // TODO 12. Create a new method that invokes an Web Browser app, using as parameter the web url included in the contact info received from ContactFormActivity in the 7th step


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactinfo);

        LayoutInflater inflater = getLayoutInflater();
        View myLayout = inflater.inflate(R.layout.contactinfo, null, false);

        setViews();

        call = findViewById(R.id.callchip);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneCall();
            }
        });

        text = findViewById(R.id.textchip);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendText();
            }
        });

        email = findViewById(R.id.emailchip);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });

        map = findViewById(R.id.mapchip);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                useMap();
            }
        });

        web = findViewById(R.id.webchip);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchWebAddress();
            }
        });
    }

    public void setViews() {
        Contact c = getIntent().getParcelableExtra(ContactFormActivity.EXTRA_CONTACT);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.textView3);
        emailAddress = findViewById(R.id.textView4);
        address = findViewById(R.id.textView5);
        website = findViewById(R.id.textView6);

        name.setText(c.getFullName());
        phone.setText(c.getPhoneNumber());
        emailAddress.setText(c.getEmailAddress());
        address.setText(c.getAddress());
        website.setText(c.getWebsite());
    }

    public void phoneCall() {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone.getText().toString()));
        startActivity(intent);
    }

    public void sendText() {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phone.getText().toString()));
        startActivity(intent);
    }

    public void useMap() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + map.getText().toString()));
        startActivity(intent);
    }

    public void sendEmail() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + email.getText().toString()));
        startActivity(intent);
    }

    public void searchWebAddress() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website.getText().toString()));
        startActivity(intent);
    }
}
