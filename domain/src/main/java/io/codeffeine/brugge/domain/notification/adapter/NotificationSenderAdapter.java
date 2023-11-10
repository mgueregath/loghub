/*
 * Tasty.
 */
package io.codeffeine.brugge.domain.notification.adapter;

import io.codeffeine.brugge.domain.notification.entity.Notification;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface NotificationSenderAdapter {

    public void notify(Notification notification);
}
