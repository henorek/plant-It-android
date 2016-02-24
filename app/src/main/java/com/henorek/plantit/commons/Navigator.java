package com.henorek.plantit.commons;

import android.content.Context;
import android.content.Intent;

import com.henorek.plantit.ui.views.activities.MainScreenActivity;
import com.henorek.plantit.ui.views.activities.MatchmakingActivity;

public class Navigator {

    public static void navigateToMainScreenActivity(Context context) {
        Intent intent = new Intent(context, MainScreenActivity.class);
        context.startActivity(intent);
    }

    public static void navigateToMatchmakingActivity(Context context) {
        Intent intent = new Intent(context, MatchmakingActivity.class);
        context.startActivity(intent);
    }

}