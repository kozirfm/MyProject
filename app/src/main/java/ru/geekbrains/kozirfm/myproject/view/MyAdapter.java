package ru.geekbrains.kozirfm.myproject.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.geekbrains.kozirfm.myproject.R;
import ru.geekbrains.kozirfm.myproject.app.App;
import ru.geekbrains.kozirfm.myproject.model.Constants;
import ru.geekbrains.kozirfm.myproject.model.GlideLoader;
import ru.geekbrains.kozirfm.myproject.model.data.Hit;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Constants {


    @Inject
    GlideLoader glideLoader;

    List<Hit> hits;

    public MyAdapter(List<Hit> hits) {
        App.getAppComponent().inject(this);
        this.hits = hits;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        glideLoader.loadPhoto(holder.imageView.getContext(),
                hits.get(position).previewURL,
                holder.imageView);
    }

    @Override
    public int getItemCount() {
        return hits.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recyclerViewItem)
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            imageView.setOnClickListener((this::startActivity));
        }

        private void startActivity(View v) {
            Context context = v.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(ADAPTER_POSITION, getAdapterPosition());
            context.startActivity(intent);
        }

    }
}
