package com.sweng455.meetingschedulingsystem.data.repository;

import com.sweng455.meetingschedulingsystem.data.entity.Meetings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Meetings, Integer> {
}
