package com.instacart.pp.android.starter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.instacart.pp.android.starter.network.NetworkService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;
import timber.log.Timber.DebugTree;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.pp_text_1) TextView textView1;

  CompositeDisposable cd = new CompositeDisposable();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Timber.plant(new DebugTree());

    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    loadData();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    cd.clear();
  }

  private void loadData() {
    textView1.setText("Hello World (local)");

    Disposable disposable = new NetworkService().getApi().hello()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(response -> {
          Timber.d("result %s", response);
        }, throwable -> {
          Timber.e(throwable, "ruh roh, something went wrong!");
        });

    cd.add(disposable);
  }
}
