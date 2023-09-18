package com.example.coworking.specification;

import com.example.coworking.entity.Booking;
import com.example.coworking.entity.Room;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RoomSpecification {

    public Specification<Room> checkOccupancyForDates(Long roomId, LocalDateTime from, LocalDateTime until) {

        return (root, query, criteriaBuilder) -> {
            Join<Room, Booking> join = root.join("bookingList", JoinType.LEFT);
            Predicate pr1 = criteriaBuilder.greaterThan(join.get("endDate"), from);
            Predicate pr2 = criteriaBuilder.lessThan(join.get("startDate"), until);
            Predicate pr3 = criteriaBuilder.equal(root.get("id"), roomId);
            return criteriaBuilder.and(pr1, pr2, pr3);
        };
    }

    public Specification<Room> byCapacity(Integer capacity) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("capacity"), capacity));
    }
}
