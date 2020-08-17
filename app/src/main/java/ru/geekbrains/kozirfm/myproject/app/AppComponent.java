package ru.geekbrains.kozirfm.myproject.app;


import javax.inject.Singleton;

import dagger.Component;
import ru.geekbrains.kozirfm.myproject.presenter.MainPresenter;
import ru.geekbrains.kozirfm.myproject.presenter.DetailPresenter;
import ru.geekbrains.kozirfm.myproject.view.MyAdapter;
import ru.geekbrains.kozirfm.myproject.view.DetailActivity;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(MainPresenter mainPresenter);

    void inject(MyAdapter myAdapter);

    void inject(DetailPresenter detailPresenter);

    void inject(DetailActivity detailActivity);
}
