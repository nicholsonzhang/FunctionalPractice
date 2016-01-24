package com.functionalpractice.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by nichol on 16/1/13.
 */
public class LedTextView extends TextView {

    private static final String FONT_DIGITAL_7 = "digital-7.ttf";
    public LedTextView(Context context) {
        super(context);
        init(context);
    }

    public LedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
       AssetManager assetManager = context.getAssets();

        Typeface typeface = Typeface.createFromAsset(assetManager,FONT_DIGITAL_7);
        setTypeface(typeface);
    }
}
