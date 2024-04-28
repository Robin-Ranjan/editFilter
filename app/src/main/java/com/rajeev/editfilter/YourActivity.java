package com.rajeev.editfilter;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class YourActivity extends Activity {

    private Toast currentToast;

    // Function to show a Toast
    public void showToast(Context context, String message) {
        if (currentToast != null) {
            currentToast.cancel(); // Cancel previous toast if any
        }
        currentToast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        currentToast.show();
    }

    // Function to dismiss the currently displayed Toast
    public void dismissToast() {
        if (currentToast != null) {
            currentToast.cancel();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        dismissToast(); // Dismiss the toast when activity is stopped
    }

    @Override
    protected void onPause() {
        super.onPause();
        dismissToast(); // Dismiss the toast when activity is paused
    }

    // Your other activity lifecycle methods and functions
}