package com.example.prudentkrishi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.prudentkrishi.data.Detail;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MainActivity extends AppCompatActivity implements MyFragment.callbacks{
    MqttAndroidClient client;

    String serverURL = "tcp://broker.hivemq.com:1883";
    String topic = "mqtt/topic";
    String sTopic = "mqtt/sensorData";

    boolean connectionFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  FragmentManager fm= getSupportFragmentManager();
      //  Fragment fragment=fm.findFragmentById(R.id.mycontainer);
      //  if(fragment==null) fragment= new MyFragment();
       // fm.beginTransaction().add(R.id.mycontainer,fragment).commit();

        serverURL = "tcp://";
        connectToBroker();



    }

    @Override
    public void onItem(Detail detail,int position) {
Intent intent= new Intent(MainActivity.this,AllDetails.class);
        intent.putExtra("detail_id",position);
startActivity(intent);


    }
    void connectToBroker() {
        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(this.getApplicationContext(), serverURL, clientId);

        try {
            IMqttToken token = client.connect();
            token.setActionCallback(new IMqttActionListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    connectionStatus.setText("Connected To " + serverURL);
                    connectionFlag = true;
                    sendButton.setEnabled(true);
                    subscribeButton.setEnabled(true);
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}