package com.rajeev.editfilter;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     EditText edit;
     private static final YourActivity YourAct = new YourActivity();
     @SuppressLint("StaticFieldLeak")
     static Context Context;
     @SuppressLint("StaticFieldLeak")
     private static final MainActivity act = new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = findViewById(R.id.edit);
        Context = getApplicationContext();

        filterEmoji(edit);

    }

    public static void filterEmoji(EditText editText) {
        editText.setFilters(new InputFilter[] {
                new InputFilter() {
                    @Override
                    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                        StringBuilder filteredStringBuilder = new StringBuilder();
                        for (int i = start; i < end; i++) {
                            char currentChar = source.charAt(i);
                            if (Character.getType(currentChar) != Character.SURROGATE && Character.getType(currentChar) != Character.OTHER_SYMBOL) {
                                filteredStringBuilder.append(currentChar);
                            }else{
//                                Toast.makeText(Context.getApplicationContext(), "Emojis Insertion does not Allowed here", Toast.LENGTH_SHORT).show();
                                YourAct.showToast(Context.getApplicationContext(),"Hello");
                                return "";
                            }
                        }
                        return filteredStringBuilder.toString();
                    }
                }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        YourAct.dismissToast();
    }
}