/*
 * Tasty.
 */
package io.codeffeine.starterkit.usecase.notification;

import com.google.inject.Inject;
import io.codeffeine.starterkit.domain.notification.contract.NewNotificationInterface;
import io.codeffeine.starterkit.domain.notification.repository.NotificationRepositoryInterface;
import io.codeffeine.starterkit.usecase.adapter.validation.field.FieldValidatorAdapter;
import io.codeffeine.starterkit.domain.notification.adapter.NotificationSenderAdapter;
import io.codeffeine.starterkit.domain.notification.entity.Notification;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class NewNotification implements NewNotificationInterface {

    private final NotificationRepositoryInterface repository;
    private final FieldValidatorAdapter fieldValidator;
    private final NotificationSenderAdapter notificationSender;

    @Inject
    public NewNotification(
            NotificationRepositoryInterface repository,
            FieldValidatorAdapter fieldValidator,
            NotificationSenderAdapter notificationSender
    ) {
        this.repository = repository;
        this.fieldValidator = fieldValidator;
        this.notificationSender = notificationSender;
    }

    @Override
    public Notification add(String title, String content) {
        fieldValidator.validate(title, content);
        Notification notification = new Notification(title, content);
        notification = repository.persist(notification);
        notificationSender.notify(notification);
        return notification;
    }
}
