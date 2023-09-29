package com.liveasy.Payload.service;

import com.liveasy.Payload.dao.PayloadDao;
import com.liveasy.Payload.model.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PayloadService {
    @Autowired
    PayloadDao payloadDao;
    public ResponseEntity<List<Payload>> getLoads(String shipperId) {
        try{
            //response entity required to send status codes
            return new ResponseEntity<>(payloadDao.findByshipperId(shipperId), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addPayload(Payload payload) {
        try{
            payloadDao.save(payload);
            return new ResponseEntity<>("load details added successfully"
                    ,HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("could not be added",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updatePayload(Payload payload, Integer id) {
        try {
            Optional<Payload> p = payloadDao.findById(id);
            if (p.isPresent()) {
                // Update the properties of the existing payload with the new payload data and shipperid always remains constant
                Payload existingPayload = p.get();
                existingPayload.setNoOfTrucks(payload.getNoOfTrucks());
                existingPayload.setProductType(payload.getProductType());
                existingPayload.setUnloadingPoint(payload.getUnloadingPoint());
                existingPayload.setWeight(payload.getWeight());
                existingPayload.setLoadingPoint(payload.getLoadingPoint());
                existingPayload.setComment(payload.getComment());
                existingPayload.setDate(payload.getDate());
                payloadDao.save(existingPayload);
                return new ResponseEntity<>("load details updated successfully"
                        , HttpStatus.CREATED);
            }}catch(Exception e){
                e.printStackTrace();
            }
            return new ResponseEntity<>("could not be added", HttpStatus.BAD_REQUEST);
        }


    public ResponseEntity<Payload> getLoad(Integer id) {
        try{
            //response entity required to send status codes
            Optional<Payload>p=payloadDao.findById(id);
            return new ResponseEntity<>(p.get(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> deletePayload(Integer loadId) {
        try{
            //response entity required to send status codes
            Optional<Payload>p=payloadDao.findById(loadId);
            payloadDao.delete(p.get());
            return new ResponseEntity<>("load deleted", HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("load couldnt be deleted",HttpStatus.BAD_REQUEST);

    }
}

