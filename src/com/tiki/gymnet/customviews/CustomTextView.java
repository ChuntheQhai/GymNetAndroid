package com.tiki.gymnet.customviews;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Html;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.tiki.gymnet.utils.TypeFaceUtils;

public class CustomTextView extends TextView {

    String  customFont;
    boolean underline;

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomTextView(Context context) {
        super(context);
    }

    private void init(AttributeSet attrs) {
        customFont = attrs.getAttributeValue(null, "customFont");
        underline = attrs.getAttributeBooleanValue(null, "underline", false);

        if (!isInEditMode() && underline) {
            setText(Html.fromHtml("<u>" + getText() + "</u>"));
        }

        if (!isInEditMode() && customFont != null) {
            // Log.e("CustomTextView", "customFont = " + customFont);
            Typeface tf = null;
            try {
                tf = TypeFaceUtils.getTypeFace(getContext(), customFont);
            } catch (Exception e) {
                Log.e("DroidSync", "CustomTextView - Load Font Error");
                e.printStackTrace();
            }

            if (tf != null) {
                setTypeface(tf);
                setPaintFlags(this.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
            } else {
                Log.e("CustomTextView", customFont + " font assignment had an error!");
            }
        } else {
//            Log.e("CustomTextView", "customFont is null");
        }
    }
}
