package ru.geekbrains.kozirfm.myproject.presenter;

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
import ru.geekbrains.kozirfm.myproject.model.db.PhotosDao;
import ru.geekbrains.kozirfm.myproject.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Inject
    Model model;

    @Inject
    RetrofitApi api;

    @Inject
    PhotosDao photosDao;

    public MainPresenter() {
        App.getAppComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getDataFromRoom();
    }

    public void getListUrl() {
        Disposable disposable = api.requestServer().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(photos -> {
                    getViewState().initRecyclerView(photos.hits);
                    putDataToRoom(photos.hits);
                }, Throwable::printStackTrace);

    }

    private void putDataToRoom(List<Hit> hits) {
        Disposable disposable = photosDao.insert(hits).subscribeOn(Schedulers.io())
                .subscribe();
    }

    private void getDataFromRoom() {
        Disposable disposable = photosDao.getAll().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(hits -> {
                    if (hits.isEmpty()) {
                        getListUrl();
                    } else {
                        getViewState().initRecyclerView(hits);
                    }
                }, Throwable::printStackTrace);
    }

    public void setAdapterPosition(int position) {
        model.setNum(position);
    }

}
