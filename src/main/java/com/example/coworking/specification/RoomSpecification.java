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

    public Specification<Room> checkOccupancyForDates(LocalDateTime from, LocalDateTime until) {

        return (root, query, criteriaBuilder) -> {
            Join<Room, Booking> join = root.join("room", JoinType.LEFT);
            Predicate pr1 = criteriaBuilder.and(criteriaBuilder.lessThan(join.get("from"), from),
                    criteriaBuilder.lessThanOrEqualTo(join.get("from"), until));
            Predicate pr2 = criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(join.get("until"), from),
                    criteriaBuilder.greaterThan(join.get("until"), until));
            return criteriaBuilder.or(pr1, pr2);
        };
    }

    public Specification<Room> byCapacity(Integer capacity) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("capacity"), capacity));
    }

    public Specification<Room> byId(Long id) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("id"), id));
    }
}
