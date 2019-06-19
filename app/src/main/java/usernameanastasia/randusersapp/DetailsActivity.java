package usernameanastasia.randusersapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import usernameanastasia.randusersapp.Model.Result;

public class DetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView imageView = findViewById(R.id.imageView);
        TextView textFirstName = findViewById(R.id.text_first_name);
        TextView textLastName = findViewById(R.id.text_last_name);
        TextView textCity = findViewById(R.id.text_city);
        TextView textNat = findViewById(R.id.text_nat);
        TextView textEmail = findViewById(R.id.text_email);
        TextView textGender = findViewById(R.id.text_gender);
        TextView textPhone = findViewById(R.id.text_phone);
        TextView textCell = findViewById(R.id.text_cell);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        Result result = getIntent().getParcelableExtra("user");
        String fName = getIntent().getStringExtra("fname");
        String lName = getIntent().getStringExtra("lname");
        String city = getIntent().getStringExtra("city");
        String picture = getIntent().getStringExtra("picture");

        Picasso.get().load(picture).fit().into(imageView);
        textFirstName.setText(fName);
        textLastName.setText(lName);
        textCity.setText(city);


        textEmail.setText(result.getEmail());
        textCell.setText(result.getCell());
        textPhone.setText(result.getPhone());
        textNat.setText(result.getNat());
        textGender.setText(result.getGender());

    }
}
