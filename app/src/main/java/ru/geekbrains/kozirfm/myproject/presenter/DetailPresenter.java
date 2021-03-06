package ru.geekbrains.kozirfm.myproject.presenter;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.geekbrains.kozirfm.myproject.app.App;
import ru.geekbrains.kozirfm.myproject.model.Model;
import ru.geekbrains.kozirfm.myproject.model.db.PhotosDao;
import ru.geekbrains.kozirfm.myproject.view.DetailView;

@InjectViewState
public class DetailPresenter extends MvpPresenter<DetailView> {

    @Inject
    PhotosDao photosDao;

    @Inject
    Model model;

    public DetailPresenter() {
        App.getAppComponent().inject(this);
    }

    public void getUrlPhoto() {
        Disposable disposable = photosDao.getWebformatUrl(model.getNum() + 1).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> getViewState().setDetailPhoto(s));
    }

}
