/*
 * Tasty.
 */
package io.codeffeine.starterkit.domain.notification.contract;

import io.codeffeine.starterkit.domain.notification.entity.Notification;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface NewNotificationInterface {

    public Notification add(String title, String content);
}
