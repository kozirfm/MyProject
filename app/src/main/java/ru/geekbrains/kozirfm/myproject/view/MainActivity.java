package ru.geekbrains.kozirfm.myproject.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.geekbrains.kozirfm.myproject.R;
import ru.geekbrains.kozirfm.myproject.presenter.MainPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.imageView)
    ImageView imageView;

    @InjectPresenter
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.button)
    public void onClickButton() {
        mainPresenter.getUrlString();
    }

    @Override
    public void setText(String s) {
        textView.setText(s);
    }

    @Override
    public void setImage(String s) {
        Glide.with(this)
                .load(s)
                .into(imageView);
    }

}
