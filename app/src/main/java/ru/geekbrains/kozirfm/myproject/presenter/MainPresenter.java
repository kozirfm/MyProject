package ru.geekbrains.kozirfm.myproject.presenter;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.geekbrains.kozirfm.myproject.app.App;
import ru.geekbrains.kozirfm.myproject.model.Model;
import ru.geekbrains.kozirfm.myproject.model.RetrofitApi;
import ru.geekbrains.kozirfm.myproject.model.data.Hit;
import ru.geekbrains.kozirfm.myproject.model.data.Photos;
import ru.geekbrains.kozirfm.myproject.model.db.PhotosDao;
import ru.geekbrains.kozirfm.myproject.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Inject
    Model model;

    @Inject
    RetrofitApi api;

    @Inject
    Photos photos;

    @Inject
    PhotosDao photosDao;

    public MainPresenter() {
        App.getAppComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getUrlString();
    }

    private void incrementNum() {
        if (model.getNum() == 19) {
            model.setNum(0);
            return;
        }
        model.setNum(model.getNum() + 1);
    }


    public void getUrlString() {
        if (photos.hits == null) {
            Disposable disposable = api.requestServer().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(photos -> {
                        this.photos = photos;
                        Log.d("HITS", photos.hits.toString());
                        putData(photos.hits);
                        setView();
                    }, throwable -> {
                        getViewState().setText("Error");
                    });
            return;
        }

        setView();

    }

    private void setView(){
        getViewState().setImage(photos.hits.get(model.getNum()).webformatURL);
        getViewState().setText(photos.hits.get(model.getNum()).downloads);
        incrementNum();
    }

    private void putData(List<Hit> photos){
        Disposable disposable = photosDao.insert(photos).subscribeOn(Schedulers.io())
                .subscribe();
    }

}
