/*
 * Tasty.
 */
package io.codeffeine.brugge.facade.module.notification;

import com.google.inject.AbstractModule;
import io.codeffeine.brugge.domain.notification.adapter.NotificationSenderAdapter;
import io.codeffeine.brugge.domain.notification.contract.GetNotificationInterface;
import io.codeffeine.brugge.domain.notification.contract.NewNotificationInterface;
import io.codeffeine.brugge.domain.notification.repository.NotificationRepositoryInterface;
import io.codeffeine.brugge.external.notification.fcm.FCMPushNotification;
import io.codeffeine.brugge.persistence.postgresql.repository.NotificationRepository;
import io.codeffeine.brugge.usecase.notification.GetNotification;
import io.codeffeine.brugge.usecase.notification.NewNotification;

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
