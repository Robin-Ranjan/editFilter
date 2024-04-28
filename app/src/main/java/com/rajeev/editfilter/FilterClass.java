package com.rajeev.editfilter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatEditText;

public class FilterClass extends AppCompatEditText {

    private Drawable mCustomDrawable; // Drawable for custom decoration

    public FilterClass(Context context) {
        super(context);
        init(context, null);
    }

    public FilterClass(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public FilterClass(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        // Initialize your custom attributes or other setup here
//        mCustomDrawable = getResources().getDrawable(R.drawable.custom_drawable); // Your custom drawable
        filterEmoji();
    }

//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        // Draw the custom drawable if available
//        if (mCustomDrawable != null) {
//            // Adjust drawable bounds to fit within the EditText
//            mCustomDrawable.setBounds(0, 0, mCustomDrawable.getIntrinsicWidth(), mCustomDrawable.getIntrinsicHeight());
//            // Draw the drawable at the bottom right corner of the EditText
//            mCustomDrawable.draw(canvas);
//        }
//    }


    public void filterEmoji() {
        this.setFilters(new InputFilter[]{
                new InputFilter() {
                    @Override
                    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                        StringBuilder filteredStringBuilder = new StringBuilder();
                        for (int i = start; i < end; i++) {
                            char currentChar = source.charAt(i);
                            if (Character.getType(currentChar) != Character.SURROGATE && Character.getType(currentChar) != Character.OTHER_SYMBOL) {
                                filteredStringBuilder.append(currentChar);
                            }else{
                                Toast.makeText(getContext(),"Emojis Insertion does not Allowed here", Toast.LENGTH_SHORT).show();
                            }
                        }
                        return filteredStringBuilder.toString();
                    }
                }
        });
    }
}