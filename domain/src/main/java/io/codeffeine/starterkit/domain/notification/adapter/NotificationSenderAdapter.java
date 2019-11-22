/*
 * Tasty.
 */
package io.codeffeine.starterkit.domain.notification.adapter;

import io.codeffeine.starterkit.domain.notification.entity.Notification;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface NotificationSenderAdapter {

    public void notify(Notification notification);
}
