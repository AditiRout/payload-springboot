package com.liveasy.Payload.controller;


import com.liveasy.Payload.model.Payload;
import com.liveasy.Payload.service.PayloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/load")
public class PayloadController {

    @Autowired
    PayloadService ps;

    @GetMapping
    public ResponseEntity<List<Payload>> getLoads(@RequestParam String shipperId){
        return ps.getLoads(shipperId);
    }

    @GetMapping("/{loadId}")
    public ResponseEntity<Payload> getLoads(@PathVariable Integer loadId){
        return ps.getLoad(loadId);
    }

    @PostMapping
    public ResponseEntity<String> addPayload(@RequestBody Payload payload){
        return ps.addPayload(payload);
        //return "success";
    }
    @PutMapping("/{loadId}")
    public ResponseEntity<String> updatePayload(@RequestBody Payload payload,@PathVariable Integer loadId){
        payload.setId(loadId);
        return ps.updatePayload(payload,loadId);
    }
    @DeleteMapping("/{loadId}")
    public ResponseEntity<String> deletePayload(@PathVariable Integer loadId){
        return ps.deletePayload(loadId);
    }

}
