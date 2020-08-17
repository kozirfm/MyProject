package ru.geekbrains.kozirfm.myproject.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.geekbrains.kozirfm.myproject.R;
import ru.geekbrains.kozirfm.myproject.model.data.Hit;
import ru.geekbrains.kozirfm.myproject.presenter.MainPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView, OnClickItemHolder {

    @InjectPresenter
    MainPresenter mainPresenter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }

    @Override
    public void initRecyclerView(List<Hit> hits) {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(new MyAdapter(hits, this));
    }

    @Override
    public void startDetailActivity(int position) {
        mainPresenter.setAdapterPosition(position);
        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        startActivity(intent);
    }
}
