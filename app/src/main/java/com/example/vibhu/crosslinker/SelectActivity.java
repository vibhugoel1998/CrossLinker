package com.example.vibhu.crosslinker;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SelectActivity extends AppCompatActivity {
    private static final int REQUEST_CAMERA_PERMISSION = 201;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }

    public void GenerateQR(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void OpenScanner(View view){
        if (ActivityCompat.checkSelfPermission(SelectActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Intent intent=new Intent(this,ScanActivity.class);
            startActivity(intent);
        } else {
            ActivityCompat.requestPermissions(SelectActivity.this, new
                    String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Intent intent=new Intent(SelectActivity.this,ScanActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Please provide permission!", Toast.LENGTH_SHORT).show();
        }
    }
}
