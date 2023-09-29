package com.liveasy.Payload.dao;

import com.liveasy.Payload.model.Payload;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayloadDao extends JpaRepository<Payload,Integer> {
    List<Payload> findByshipperId(String shipperId);

}
