package rest;

import api_rest.AuthenticationController;
import dto.RegistrationBodyDto;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTestsRest extends AuthenticationController {
    @Test
    public void registrationPositiveTest(){
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("mursik"+i+"@gmail.com")
                .password("Password123!")
                .firstName("Mursik")
                .lastName("Mur").build();
        Assert.assertEquals(registrationLogin(user, REGISTRATION_URL)
                .getStatusCode(), 200);
    }
    @Test
    public void registrationNegativeTest_protocolHTTP_NotSecure(){
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("mursik"+i+"@gmail.com")
                .password("Password123!")
                .firstName("Mursik")
                .lastName("Mur").build();
        Response response = registrationLoginHTTP(user, REGISTRATION_URL);
        System.out.println(response.print());
        Assert.assertEquals(registrationLoginHTTP(user,REGISTRATION_URL)
                .getStatusCode(), 200);
    }
}
