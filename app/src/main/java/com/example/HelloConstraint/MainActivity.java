package com.example.HelloConstraint;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnToast = findViewById(R.id.button_toast);
        Button btnCount = findViewById(R.id.button_count);
        Button btnZero = findViewById(R.id.button_zero);
        TextView mShowCount = findViewById(R.id.show_count);

        btnToast.setOnClickListener(v -> showToast());
        btnCount.setOnClickListener(v -> countUp(mShowCount, btnZero, btnCount));
        btnZero.setOnClickListener(v -> resetCount(mShowCount, btnZero, btnCount));
    }

    private void showToast() {
        Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT).show();
    }

    private void countUp(TextView mShowCount, Button btnZero, Button btnCount) {
        if (btnCount != null) {
            Drawable drawable = btnCount.getBackground();
            Drawable drawableBtnCount = DrawableCompat.wrap(drawable);
            if (mCount % 2 == 0) {
                DrawableCompat.setTint(drawableBtnCount, Color.GREEN);
            } else {
                DrawableCompat.setTint(drawableBtnCount, Color.BLUE);
            }
        }

        if (mCount == 0 && btnZero != null) {
            Drawable drawable = btnZero.getBackground();
            DrawableCompat.setTint(DrawableCompat.wrap(drawable), Color.MAGENTA);
        }

        mCount++;

        if (mShowCount != null) {
            mShowCount.setText(String.valueOf(mCount));
        }
    }

    private void resetCount(TextView mShowCount, Button btnZero, Button btnCount) {
        if (btnZero != null) {
            Drawable drawable = btnZero.getBackground();
            DrawableCompat.setTint(DrawableCompat.wrap(drawable), Color.GRAY);
        }

        if (btnCount != null) {
            Drawable drawable = btnCount.getBackground();
            DrawableCompat.setTint(DrawableCompat.wrap(drawable), Color.BLUE);
        }

        mCount = 0;

        if (mShowCount != null) {
            mShowCount.setText(String.valueOf(mCount));
        }
    }
}