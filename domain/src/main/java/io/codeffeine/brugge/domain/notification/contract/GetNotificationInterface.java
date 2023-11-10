/*
 * Tasty.
 */
package io.codeffeine.brugge.domain.notification.contract;

import io.codeffeine.brugge.domain.notification.entity.Notification;
import io.codeffeine.brugge.domain.pagination.Page;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface GetNotificationInterface {

    public Notification getById(long id);

    public Page getByParams(String text, int page, String param, String order);
}
