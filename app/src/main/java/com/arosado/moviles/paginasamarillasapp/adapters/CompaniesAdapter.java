package com.arosado.moviles.paginasamarillasapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.arosado.moviles.paginasamarillasapp.R;
import com.arosado.moviles.paginasamarillasapp.activities.DetailActivity;
import com.arosado.moviles.paginasamarillasapp.models.Company;

import java.util.ArrayList;
import java.util.List;

public class CompaniesAdapter extends RecyclerView.Adapter<CompaniesAdapter.ViewHolder>{

    private AppCompatActivity activity;
    private List<Company> companies;

    public CompaniesAdapter(AppCompatActivity activity) {
        this.activity = activity;
        companies = new ArrayList<>();
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @NonNull
    @Override
    public CompaniesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_publication, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompaniesAdapter.ViewHolder viewHolder, int i) {
        final Company company = this.companies.get(i);

        Context context =viewHolder.itemView.getContext();
        int resource_id = context.getResources().getIdentifier(company.getLogo(), "drawable", context.getPackageName());

        viewHolder.name.setText(company.getName());
        viewHolder.address.setText(company.getAddress());
        viewHolder.phone.setText(company.getPhone());
        viewHolder.logo.setImageResource(resource_id);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("id", company.getId());

                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return companies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView address;
        TextView phone;
        ImageView logo;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            address = itemView.findViewById(R.id.item_address);
            phone = itemView.findViewById(R.id.item_phone);
            logo = itemView.findViewById(R.id.item_logo);
        }
    }
}
