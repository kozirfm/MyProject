package ru.geekbrains.kozirfm.myproject.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.geekbrains.kozirfm.myproject.R;
import ru.geekbrains.kozirfm.myproject.model.data.Photos;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;

    private Photos photos;

    public MyAdapter(Context context, Photos photos) {
        this.context = context;
        this.photos = photos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context)
                .load(photos.hits.get(position).webformatURL)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return photos.hits.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {

        @BindView(R.id.recyclerViewItem)
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            imageView.setOnClickListener((v -> {
                Intent intent = new Intent(context, SecondActivity.class);
                context.startActivity(intent);
            }));
        }

        private void startActivity() {

            Log.d("CLICK", "Click" + " " + getAdapterPosition());
        }

    }
}
