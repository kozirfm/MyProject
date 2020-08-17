package ru.geekbrains.kozirfm.myproject.view;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.geekbrains.kozirfm.myproject.R;
import ru.geekbrains.kozirfm.myproject.app.App;
import ru.geekbrains.kozirfm.myproject.model.Constants;
import ru.geekbrains.kozirfm.myproject.model.GlideLoader;
import ru.geekbrains.kozirfm.myproject.presenter.DetailPresenter;

public class DetailActivity extends MvpAppCompatActivity implements DetailView, Constants {

    @InjectPresenter
    DetailPresenter detailPresenter;

    @Inject
    GlideLoader glideLoader;

    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        App.getAppComponent().inject(this);

        ButterKnife.bind(this);

        detailPresenter.getUrlPhoto();

    }

    @Override
    public void setDetailPhoto(String url) {
        glideLoader.loadPhoto(this, url, imageView);

    }
}
