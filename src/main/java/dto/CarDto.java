package dto;

import lombok.*;

@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

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
