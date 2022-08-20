package com.example.prudentkrishi.data;

import android.util.Log;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

import java.io.IOException;
import java.io.InputStream;

public class Options {
    final String topic = "foo/bar";
{
           MqttAndroidClient client = null;
           IMqttToken unsubToken = null;
        try {
            unsubToken = client.unsubscribe(topic);
        } catch (MqttException ex) {
            ex.printStackTrace();
        }
        unsubToken.setActionCallback(new IMqttActionListener() {
            @Override
            public void onSuccess(IMqttToken asyncActionToken) {
                // The subscription could successfully be removed from the client
            }

            @Override
            public void onFailure(IMqttToken asyncActionToken,
                                  Throwable exception) {
                // some error occurred, this is very unlikely as even if the client
                // did not had a subscription to the topic the unsubscribe action
                // will be successfully
            }
        });
    }

    private MqttAsyncClient MqttClient;
    String clientId = MqttAsyncClient.generateClientId();
    final MqttAndroidClient client =
            new MqttAndroidClient(this.getApplicationContext(), "ssl://iot.eclipse.org:8883",
                    clientId);



        IMqttToken token = client.connect(options);
        token.setActionCallback(new IMqttActionListener() {
            @Override
            public void onSuccess(IMqttToken asyncActionToken) {
                // We are connected
                Log.d(TAG, "onSuccess");

            }

            @Override
            public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                // Something went wrong e.g. connection timeout or firewall problems
                Log.d(TAG, "onFailure");

            }
        });


    } catch (MqttException IOException_e) {
        e.printStackTrace();
    }
    }

