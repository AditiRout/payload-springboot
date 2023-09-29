package com.liveasy.Payload.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Payload {

//            "loadingPoint": "delhi",
//            "unloadingPoint": "jaipur",
//            "productType": "chemicals",
//            "truckType": "canter",
//            "noOfTrucks": "1",
//            "weight": "100",
//             "comment": "",
//            “shipperId” : “shipper:c29ce2ec-1630-4d1d-bb0b-6a82128521f3”,
//            “Date” : “dd-mm-yyyy”

//    {
//        "id": 352,
//            "unloadingPoint": "jaipur",
//            "productType": "chemicals",
//            "truckType": "canter",
//            "noOfTrucks": 1,
//            "weight": 100,
//            "comment": "",
//            "shipperId": "shipper:c29ce2ec-1630-4d1d-bb0b-6a82128521f3",
//            "Date": "02-01-2023",
//            "date": "02-01-2023"
//    }

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private Integer id;
    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private Integer noOfTrucks;
    private Integer weight;
    private String comment;
    private String shipperId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String Date;
}
