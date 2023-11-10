/*
 * Tasty.
 */
package io.codeffeine.brugge.domain.notification.contract;

import io.codeffeine.brugge.domain.notification.entity.Notification;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface NewNotificationInterface {

    public Notification add(String title, String content);
}
