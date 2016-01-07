package com.shaubert.blankmaterial.ui.home;

import android.os.Bundle;
import com.shaubert.blankmaterial.R;
import com.shaubert.blankmaterial.uiroot.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_fragment);
    }

}
