package User;

import net.serenitybdd.rest.SerenityRest;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import net.thucydides.core.annotations.Step;

public class Get {

    protected static String url = "https://reqres.in/api/";

    @Step("I set GET api endpoints")
    public String setApiEndpoints () { return url + "users/2"; }


    @Step("I send GET HTTP request")
    public void sendGetHttpRequest() { SerenityRest.given().get(setApiEndpoints()); }

    @Step("I receive valid HTTP response code 200")
    public void validateHttpResponseCode() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid data for detail user")
    public void validateDataForDetailUser() {
        restAssuredThat(response -> response.body("'data'.'id'", equalTo("2")));
        restAssuredThat(response -> response.body("'data'.'first_name'", equalTo("Janet")));



    }

}

