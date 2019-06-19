package usernameanastasia.randusersapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import usernameanastasia.randusersapp.DetailsActivity;
import usernameanastasia.randusersapp.Model.Result;
import usernameanastasia.randusersapp.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<Result> results = new ArrayList<>();

    public MyAdapter(Context context){
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.BindInfo(results.get(position));

        Result result = results.get(position);

        // Use when you want to start different activity or perform a different activity on each item click
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                Intent intent = new Intent(context, DetailsActivity.class);

                intent.putExtra("user", result);
                intent.putExtra("fname", result.getName().getFirst().toUpperCase());
                intent.putExtra("lname", result.getName().getLast().toUpperCase());
                intent.putExtra("city", result.getLocation().getCity().toUpperCase());
                intent.putExtra("picture", result.getPicture().getMedium());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setResults(List<Result> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView textName, textCity;
        private ImageView imageView;

        ItemClickListener itemClickListener;

        MyViewHolder(View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.text_name);
            textCity = itemView.findViewById(R.id.text_city);
            imageView = itemView.findViewById(R.id.image);
            itemView.setOnClickListener(this);
        }

        void BindInfo(Result result) {
            textName.setText(result.getName().getFirst());
            textCity.setText(result.getLocation().getCity());
            Picasso.get().load(result.getPicture().getMedium()).fit().into(imageView);
        }

        @Override
        public void onClick(View v){
            this.itemClickListener.onItemClick(v, getLayoutPosition());
        }
        void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;
        }
    }
}