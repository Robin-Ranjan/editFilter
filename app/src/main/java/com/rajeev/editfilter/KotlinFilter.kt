package com.rajeev.editfilter

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.InputFilter
import android.util.AttributeSet
import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText

class KotlinFilter @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatEditText(context, attrs, defStyleAttr) {

    private var mCustomDrawable: Drawable? = null // Drawable for custom decoration

    init {
        // Initialize your custom attributes or other setup here
//        mCustomDrawable = resources.getDrawable(R.drawable.custom_drawable, null) // Your custom drawable
    }

//    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
//        // Draw the custom drawable if available
//        mCustomDrawable?.let {
//            // Adjust drawable bounds to fit within the EditText
//            it.setBounds(0, 0, it.intrinsicWidth, it.intrinsicHeight)
//            // Draw the drawable at the bottom right corner of the EditText
//            it.draw(canvas)
  }

fun filterEmoji(editText: EditText) {
    editText.filters = arrayOf(
        InputFilter { source, start, end, dest, dstart, dend ->
            val filteredStringBuilder = StringBuilder()
            for (i in start until end) {
                val currentChar = source[i]
                if (Character.getType(currentChar) != Character.SURROGATE.toInt() && Character.getType(
                        currentChar
                    ) != Character.OTHER_SYMBOL.toInt()
                ) {
                    filteredStringBuilder.append(currentChar)
                }
            }
            filteredStringBuilder.toString()
        }
    )
}