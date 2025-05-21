package dto;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ErrorMessageDtoString {
    private String timestamp;//    timestamp	string($date-time)
    private int status;      //    status	integer($int32)
    private String error;    //    error	string
    private Object message;  //    message	string
    private String path;     //    path	string
}
