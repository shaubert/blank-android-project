package com.shaubert.blankmaterial;

import android.app.Application;
import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.utils.L;
import com.shaubert.blankmaterial.navigation.Jumper;
import com.shaubert.blankmaterial.navigation.StartNewActivityJumperFactory;
import com.shaubert.ui.jumper.JumperFactory;
import com.shaubert.ui.remoteimageview.RemoteImageView;

public class App extends Application {

    private static App INSTANCE;

    private DisplayImageOptions displayImageOptions;
    private ImageLoader imageLoader;
    private JumperFactory<Jumper> jumperFactory;

    public static App get() {
        return INSTANCE;
    }

    public App() {
        INSTANCE = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        jumperFactory = new StartNewActivityJumperFactory();

        setupImageLoader();
        setupRemoteImageView();
    }

    private void setupImageLoader() {
        displayImageOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .considerExifParams(true)
                .build();
        ImageLoaderConfiguration imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(this)
                .diskCacheSize(50 * 1024 * 1024)
                .memoryCacheSizePercentage(30)
                .defaultDisplayImageOptions(displayImageOptions)
                .build();
        if (!BuildConfig.DEBUG) {
            L.writeLogs(false);
        }
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(imageLoaderConfiguration);
    }

    private void setupRemoteImageView() {
        new RemoteImageView.Setup()
                .imageLoader(imageLoader)
                .displayImageOptions(displayImageOptions)
                .apply();
    }

    public JumperFactory<Jumper> getJumperFactory() {
        return jumperFactory;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        imageLoader.clearMemoryCache();
    }

}