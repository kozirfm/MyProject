package ru.geekbrains.kozirfm.myproject.app;


import javax.inject.Singleton;

import dagger.Component;
import ru.geekbrains.kozirfm.myproject.presenter.MainPresenter;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(MainPresenter mainPresenter);

}
