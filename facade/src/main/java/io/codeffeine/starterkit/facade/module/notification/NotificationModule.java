/*
 * Tasty.
 */
package io.codeffeine.starterkit.facade.module.notification;

import com.google.inject.AbstractModule;
import io.codeffeine.starterkit.domain.notification.adapter.NotificationSenderAdapter;
import io.codeffeine.starterkit.domain.notification.contract.GetNotificationInterface;
import io.codeffeine.starterkit.domain.notification.contract.NewNotificationInterface;
import io.codeffeine.starterkit.domain.notification.repository.NotificationRepositoryInterface;
import io.codeffeine.starterkit.external.notification.fcm.FCMPushNotification;
import io.codeffeine.starterkit.persistence.postgresql.repository.NotificationRepository;
import io.codeffeine.starterkit.usecase.notification.GetNotification;
import io.codeffeine.starterkit.usecase.notification.NewNotification;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class NotificationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(NotificationRepositoryInterface.class).to(NotificationRepository.class);
        bind(NewNotificationInterface.class).to(NewNotification.class);
        bind(GetNotificationInterface.class).to(GetNotification.class);
        bind(NotificationSenderAdapter.class).to(FCMPushNotification.class);
    }

}
