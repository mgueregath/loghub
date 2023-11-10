/*
 * Tasty.
 */
package io.codeffeine.brugge.external.notification.fcm;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.ApnsConfig;
import com.google.firebase.messaging.Aps;
import com.google.firebase.messaging.ApsAlert;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.MulticastMessage;
import io.codeffeine.brugge.domain.notification.adapter.NotificationSenderAdapter;
import io.codeffeine.brugge.domain.notification.entity.Notification;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class FCMPushNotification implements NotificationSenderAdapter {

    static {
        if (FCMConfiguration.ENABLED) {
            try {
                ClassPathResource res = new ClassPathResource(FCMConfiguration.CREDENTIAL);
                InputStream credentialsJSON = res.getInputStream();

                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(credentialsJSON))
                        .setDatabaseUrl(FCMConfiguration.URL)
                        .build();

                FirebaseApp.initializeApp(options);

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                // No action
            } catch (IOException ex) {
                ex.printStackTrace();
                // No action
            }
        }

    }

    @Override
    public void notify(Notification notification) {
        if (!FCMConfiguration.ENABLED) {
            return;
        }
        sendNotification(notification);
    }

    private void sendNotification(Notification notification) {
        if (!FCMConfiguration.ENABLED) {
            return;
        }
        List<List<String>> groups = new ArrayList<>();
        List<String> registrationTokens = new ArrayList<>();

        /*
        for (Device device : notification.getDevices()) {
            if (registrationTokens.size() > 100) {
                groups.add(registrationTokens);
                registrationTokens.clear();
            }
            registrationTokens.add(device.getDeviceId());
        }
         */
        groups.forEach(group -> {
            MulticastMessage message = MulticastMessage.builder().setNotification(
                    new com.google.firebase.messaging.Notification(
                            notification.getTitle(),
                            notification.getContent()
                    )
            ).setAndroidConfig(
                    AndroidConfig.builder()
                            .setTtl(3600 * 1000) // 1 hour in milliseconds
                            .setPriority(AndroidConfig.Priority.NORMAL)
                            .setNotification(
                                    AndroidNotification.builder().setIcon("ic_launcher.png").build()
                            ).build()
            ).setApnsConfig(
                    ApnsConfig.builder()
                            .putHeader("apns-priority", "10")
                            .setAps(
                                    Aps.builder().setAlert(ApsAlert.builder().build()
                                    ).build()
                            ).build()
            ).addAllTokens(group).build();
            try {
                FirebaseMessaging.getInstance().sendMulticastAsync(message).get();
            } catch (InterruptedException ex) {
                // No action
            } catch (ExecutionException ex) {
                // No action
            }
        });

    }
}
