/*
 * Tasty.
 */
package io.codeffeine.starterkit.usecase.notification;

import com.google.inject.Inject;
import io.codeffeine.starterkit.domain.notification.contract.GetNotificationInterface;
import io.codeffeine.starterkit.domain.notification.entity.Notification;
import io.codeffeine.starterkit.domain.notification.repository.NotificationRepositoryInterface;
import io.codeffeine.starterkit.domain.pagination.Page;
import io.codeffeine.starterkit.usecase.exception.data.DataNotFoundException;
import io.codeffeine.starterkit.usecase.exception.validation.ParameterValidationException;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class GetNotification implements GetNotificationInterface {

    private final NotificationRepositoryInterface repository;

    @Inject
    public GetNotification(NotificationRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public Notification getById(long id) {
        Notification notification = repository.findById(id);
        if (notification == null) {
            throw new DataNotFoundException();
        }
        return notification;
    }

    @Override
    public Page getByParams(String text, int page, String param, String order) {
        if (text.equals("")) {
            text = null;
        }
        if (param.equals("")) {
            param = null;
        }
        if (order == null || order.equals("")) {
            order = null;
        } else if (order.equalsIgnoreCase("asc")) {
            order = "ASC";
        } else if (order.equalsIgnoreCase("desc")) {
            order = "DESC";
        } else {
            throw new ParameterValidationException();
        }
        if (order != null && (param == null || param.equals(""))) {
            param = "id";
        }
        List<Notification> campaigns = repository.findByParams(text, page, param, order);
        if (campaigns.isEmpty()) {
            throw new DataNotFoundException();
        }
        Long quantity = repository.countByParams(text, page, param, order);
        return new Page(campaigns, page, (int) (quantity / 20), quantity);
    }

}
