package com.maemtal.lesson_school;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
      ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
    }
}
