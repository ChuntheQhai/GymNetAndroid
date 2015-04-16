package com.tiki.gymnet.utils;

import java.util.HashMap;

import android.content.Context;
import android.graphics.Typeface;

public class TypeFaceUtils {

    // An efficient typeface retriver. Dont keep loading from assets!
    private static HashMap<String, Typeface> typefaceCache = new HashMap<String, Typeface>();

    public static Typeface getTypeFace(Context c, String typefaceName) {
        if (typefaceCache == null) {
            HashMap<String, Typeface> typefaceCache = new HashMap<String, Typeface>();
        }

        if (typefaceCache.containsKey(typefaceName)) {
            // Log.e("SAUtils","getTypeFace: get "+typefaceName+" from cache!");
            return typefaceCache.get(typefaceName);
        } else {
            // Log.e("SAUtils","getTypeFace: get "+typefaceName+" from assets!");
            Typeface tf = Typeface.createFromAsset(c.getAssets(), "fonts/" + typefaceName);
            typefaceCache.put(typefaceName, tf);
            return tf;
        }
    }
}
