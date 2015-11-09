package com.functionalpractice;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by nichol on 15/11/9.
 */
public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        initImageLoader(getApplicationContext());
    }

    private void initImageLoader(Context context){

        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(context);
        builder.threadPriority(Thread.NORM_PRIORITY - 2);
        builder.denyCacheImageMultipleSizesInMemory();
        builder.diskCacheFileNameGenerator(new HashCodeFileNameGenerator());
        builder.diskCacheFileCount(30);
        builder.tasksProcessingOrder(QueueProcessingType.LIFO);

        ImageLoader.getInstance().init(builder.build());


    }
}
