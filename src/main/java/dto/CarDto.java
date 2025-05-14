package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Builder

public class CarDto {
    String serialNumber;//    serialNumber*	string
    String manufacture; //    manufacture*	string
    String model;       //    model*	string
    String year;        //    year*	string
    String fuel;        //    fuel*	string
    int seats;          //    seats*	integer($int32)
    String carClass;    //    carClass*	string
    double pricePerDay; //    pricePerDay*	number($double)
    String about;       //    about	string
    String city;        //    city*	string

}
