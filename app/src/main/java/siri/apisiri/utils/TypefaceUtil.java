package siri.apisiri.utils;

import android.content.Context;
import android.graphics.Typeface;

public class TypefaceUtil {
    public static Typeface typeface    = null;
    public static Typeface typeface_m  = null;
    public static Typeface typeface_b  = null;

    public static void loadTypeface(Context mContext) {
        if(typeface == null) {
            typeface = Typeface.createFromAsset(mContext.getAssets(), "Fonts/NanumSquareRegular.ttf");
        }

        if(typeface_m == null) {
            typeface_m = Typeface.createFromAsset(mContext.getAssets(), "Fonts/NanumSquareBold.ttf");
        }

        if(typeface_b == null) {
            typeface_b = Typeface.createFromAsset(mContext.getAssets(), "Fonts/NanumSquareExtraBold.ttf");
        }
    }
}
