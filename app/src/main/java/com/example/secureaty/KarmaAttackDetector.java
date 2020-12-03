package com.example.secureaty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Date;

public class KarmaAttackDetector extends AppCompatActivity {

    private final ResponseReceiver receiver = new ResponseReceiver();
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private final CompoundButton.OnCheckedChangeListener autoStartSwitchWatcher = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            editor = sharedPreferences.edit();
            editor.putBoolean("autoStart", isChecked);
            editor.apply();
        }
    };
    private Intent wifiScannerIntent;
    private TextView textViewLog;
    private EditText scanFrequencyText;
    private int scanFrequency;
    private final TextWatcher frequencyScanTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void afterTextChanged(Editable s) {
            try {
                scanFrequency = Integer.parseInt(s.toString());
                if (scanFrequency < 5)
                    scanFrequency = 5;
            } catch (Exception e) {
                scanFrequency = 5;
            }

            editor = sharedPreferences.edit();
            editor.putInt("scanFrequency", scanFrequency);
            editor.apply();
        }
    };
    private Switch autoStartSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karma_attack_detector);
        textViewLog = (TextView) findViewById(R.id.textViewLog);
        wifiScannerIntent = new Intent(this, WiFiScannerService.class);
        textViewLog.setMovementMethod(new ScrollingMovementMethod());
        sharedPreferences = getSharedPreferences("karmaDetectorPrefs", Context.MODE_PRIVATE);
        scanFrequencyText = (EditText) findViewById(R.id.scanFrequency);
        scanFrequencyText.addTextChangedListener(frequencyScanTextWatcher);
        autoStartSwitch = (Switch) findViewById(R.id.switchAutoStart);
        autoStartSwitch.setOnCheckedChangeListener(autoStartSwitchWatcher);
        loadPrefs();
        addToLog("App started.");

    }


    @Override
    protected void onDestroy() {
        stopService(wifiScannerIntent);
        unregisterReceiver(receiver);
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadPrefs();
        registerReceiver(receiver, new IntentFilter(ResponseReceiver.ACTION_RESP));
    }

    public void startScanner(View v) {
        startService(wifiScannerIntent);
        addToLog("Requested scan service start.");
    }

    public void stopScanner(View v) {
        stopService(wifiScannerIntent);
        addToLog("Requested scan service stop.");
    }

    private void addToLog(String content) {
        final int LOG_MAX_BUFFER = 2000;
        // lame log rotation implementation
        if (textViewLog.length() > LOG_MAX_BUFFER)
            textViewLog.setText(textViewLog.getText().toString().substring(100, textViewLog.length()));
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        textViewLog.append(currentDateTimeString + ": " + content + "\n");
    }

    private void loadPrefs() {
        autoStartSwitch.setChecked(sharedPreferences.getBoolean("autoStart", false));
        scanFrequency = sharedPreferences.getInt("scanFrequency", 0);
        if (scanFrequency == 0) {
            editor = sharedPreferences.edit();
            int DEFAULT_SCAN_FREQ = 300;
            editor.putInt("scanFrequency", DEFAULT_SCAN_FREQ);
            editor.apply();
            scanFrequencyText.setText("" + DEFAULT_SCAN_FREQ);
        } else {
            scanFrequencyText.setText("" + scanFrequency);
        }
    }

    public class ResponseReceiver extends BroadcastReceiver {
        public static final String ACTION_RESP = "com.pmbento.karmadetector.wifiscannerservice.response";

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ACTION_RESP)) {
                addToLog(intent.getStringExtra("message"));
            }
        }
    }
}
