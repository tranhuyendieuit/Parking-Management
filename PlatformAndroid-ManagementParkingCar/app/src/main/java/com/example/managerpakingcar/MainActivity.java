package com.example.managerpakingcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.managerpakingcar.fragment.HomeFragment;
import com.example.managerpakingcar.fragment.ProfileFragment;
import com.example.managerpakingcar.fragment.ScanrFragment;


public class  MainActivity extends AppCompatActivity {
//    private ZXingScannerView mScannerView;
    private MeowBottomNavigation bottomNavigation;
    private Fragment fragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mScannerView = findViewById(R.id.scannerView);
//        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
//        mScannerView.startCamera();

//           Convert page QRScanner into ScanrFragment

         initView();
    }

    private void initView() {
        initSetupBottomNav();
    }
    private void initSetupBottomNav(){
        bottomNavigation = findViewById(R.id.bottomNavigation);
        // init BottomNavigation

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_baseline_qr_code_scanner_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_baseline_settings_24));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {

            }
        });
        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                switch (item.getId()){
                    case 1:
                        fragment = new HomeFragment();
                        break;
                    case 2:
                        fragment = new ScanrFragment();
                        break;
                    case 3 :
                        fragment = new ProfileFragment();
                        break;
                }
                replaceFragment(fragment);
            }
        });

        // set home fragment initially selected;
        bottomNavigation.show(2,true);
    }


    private void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();
    }


//    @Override
//    public void onResume() {
//        super.onResume();
//        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
//        mScannerView.startCamera();          // Start camera on resume
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        mScannerView.stopCamera();           // Stop camera on pause
//    }
//
//    @Override
//    public void handleResult(Result result) {
//
//        Toast.makeText(MainActivity.this, result.getText(), Toast.LENGTH_SHORT).show();
//        // If you would like to resume scanning, call this method below:
//        mScannerView.resumeCameraPreview(this);
//    }

}
