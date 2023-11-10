/*
 * Tasty.
 */
package io.codeffeine.brugge.domain.notification.repository;

import io.codeffeine.brugge.domain.notification.entity.Notification;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface NotificationRepositoryInterface {

    public Notification findById(long id);

    public List<Notification> findByParams(String text, int page, String param, String order);

    public Long countByParams(String text, int page, String param, String order);

    public Notification persist(Notification notification);

}
