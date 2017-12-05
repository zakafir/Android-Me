package com.st00.afir.android_me.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.st00.afir.android_me.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "position clicked: "+position,
                Toast.LENGTH_LONG).show();
    }
}
