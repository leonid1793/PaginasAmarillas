package com.arosado.moviles.paginasamarillasapp.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.arosado.moviles.paginasamarillasapp.R;
import com.arosado.moviles.paginasamarillasapp.models.Company;
import com.arosado.moviles.paginasamarillasapp.repositories.CompanyRepository;

public class DetailActivity extends AppCompatActivity {

    private Integer id;
    private TextView nameText;
    private TextView addressText;
    private TextView phoneText;
    private TextView categoryText;
    private TextView infoText;
    private ImageView logoImage;
    private Company company;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nameText = findViewById(R.id.item_name_detail);
        addressText = findViewById(R.id.item_address_detail);
        phoneText = findViewById(R.id.item_phone_detail);
        categoryText = findViewById(R.id.item_category_detail);
        infoText = findViewById(R.id.info_detail);
        logoImage = findViewById(R.id.item_logo_detail);

        this.id = getIntent().getExtras().getInt("id");

        company = CompanyRepository.getCompanyById(id);

        if(company != null) {
            int resource_id = getResources().getIdentifier(company.getLogo(), "drawable", getPackageName());

            nameText.setText(company.getName());
            addressText.setText(company.getAddress());
            phoneText.setText(company.getPhone());
            categoryText.setText(company.getCategory());
            infoText.setText(company.getInfo());
            logoImage.setImageResource(resource_id);
        }
    }

    public void visitWebsite(View view) {
        Uri web_page = Uri.parse(company.getUrl());
        intent = new Intent(Intent.ACTION_VIEW, web_page);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    public void sendEmail(View view) {
        intent = new Intent(Intent.ACTION_SENDTO);
        Uri uri = Uri.parse("mailto:" + company.getEmail());
        intent.setData(uri);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    public void sendSMS(View view) {
        intent = new Intent(Intent.ACTION_VIEW);
        intent.setType("vnd.android-dir/mms-sms");
        intent.putExtra("address", company.getPhone());

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    public void shareContent(View view) {
        intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Nombre:" + company.getName() + "\nDirección: " + company.getAddress() + "\nTeléfono: " + company.getPhone());

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    public void callTo(View view) {
        intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + company.getPhone()));

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
}
