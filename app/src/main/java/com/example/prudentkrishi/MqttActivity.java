package com.example.prudentkrishi;

//public class MqttActivity extends AppCompatActivity {

   // @Override
  //  protected void onCreate(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_mqtt);
   // }
//}


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.UnsupportedEncodingException;

public class MqttActivity extends AppCompatActivity {

    EditText brokerAddress, textToSend, topicToSend, subscriptionTopic;
    Button connectButton, sendButton, subscribeButton;
    TextView receivedMessage, connectionStatus;

    MqttAndroidClient client;

    String serverURL = "tcp://broker.hivemq.com:1883";
    String topic = "mqtt/topic";
    String sTopic = "mqtt/sensorData";

    boolean connectionFlag = false;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /////////////////////////////////////////////////////////////////
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                serverURL = "tcp://" + brokerAddress.getText().toString() + ":1883";
                connectToBroker();
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topic = topicToSend.getText().toString();
                sendMessage(topic);
            }
        });
        /////////////////////////////////////////////////////////////////
        subscribeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sTopic = subscriptionTopic.getText().toString();
                subscribeToTopic(sTopic);
            }
        });
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
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

    ////////////////////////////////////////////////////////////////////////////////////////////////
    void sendMessage(String topic) {
        String payload = textToSend.getText().toString();
        byte[] encodedPayload;
        try {
            encodedPayload = payload.getBytes("UTF-8");
            MqttMessage message = new MqttMessage(encodedPayload);
            client.publish(topic, message);
            Toast.makeText(getApplicationContext(), "Sent", Toast.LENGTH_SHORT).show();
        } catch (UnsupportedEncodingException | MqttException e) {
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void subscribeToTopic(String topic) {
        try {
            if (client.isConnected()) {
                client.subscribe(topic, 0);
                Toast.makeText(getApplicationContext(), "Subscribed", Toast.LENGTH_SHORT).show();
                client.setCallback(new MqttCallback() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void connectionLost(Throwable cause) {
                        connectionStatus.setText("Connection Failed");
                        connectionFlag = false;
                    }

                    @Override
                    public void messageArrived(String topic, MqttMessage message) throws Exception {
                        receivedMessage.setText(message.toString());
                    }

                    @Override
                    public void deliveryComplete(IMqttDeliveryToken token) {
                    }
                });
            }
        } catch (Exception ignored) {
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (connectionFlag) {
            try {
                IMqttToken disconnectToken = client.disconnect();
                disconnectToken.setActionCallback(new IMqttActionListener() {
                    @Override
                    public void onSuccess(IMqttToken asyncActionToken) {
                        Toast.makeText(getApplicationContext(), "Disconnected", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                        finish();
                    }
                });
            } catch (MqttException e) {
                e.printStackTrace();
            }
            connectionFlag = false;
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
}
