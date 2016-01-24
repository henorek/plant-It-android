package net.henorek.plantit.ui.views;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import net.henorek.plantit.R;
import net.henorek.plantit.data.models.TacticsEntity;
import net.henorek.plantit.data.services.TacticsService;
import net.henorek.plantit.data.utils.ServiceFactory;
import net.henorek.plantit.ui.base.BaseActivity;
import net.henorek.plantit.ui.base.BaseMvpActivity;
import net.henorek.plantit.ui.presenters.MainScreenPresenter;
import net.henorek.plantit.ui.utils.ActivityConfig;
import net.henorek.plantit.ui.utils.ActivityConfigBuilder;
import net.henorek.plantit.ui.widgets.adapters.MainScreenAdapter;

import butterknife.Bind;
import me.relex.circleindicator.CircleIndicator;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class MainScreenActivity extends BaseMvpActivity {

    @Bind(R.id.ams_main_pager)
    ViewPager viewPager;

    @Bind(R.id.ams_main_pager_indicator)
    CircleIndicator mainScreenViewIndicator;

    @Override
    protected ActivityConfig getConfig() {
        return new ActivityConfigBuilder(R.layout.activity_main_screen).build();
    }

    @Override
    public MainScreenPresenter createPresenter() {
        return new MainScreenPresenter();
    }

    @Override
    protected void prepareView(Bundle savedInstanceState) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new MainScreenAdapter(fragmentManager));
        mainScreenViewIndicator.setViewPager(viewPager);
    }

    @Override
    protected void addFragments() {

    }



}
