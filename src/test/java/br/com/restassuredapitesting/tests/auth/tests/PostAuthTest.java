package br.com.restassuredapitesting.tests.auth.tests;

import base.BaseTest;
import br.com.restassuredapitesting.suites.AllTest;
import br.com.restassuredapitesting.tests.auth.request.PostAuthRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.CoreMatchers.notNullValue;

@Category(AllTest.class)
public class PostAuthTest extends BaseTest {

  PostAuthRequest postAuthRequest = new PostAuthRequest();
    @Test
    public  void validaRetornoDeTokenParaUsuario(){
        postAuthRequest.tokenReturn()
                .then()
                .statusCode(200)
                .body("token",notNullValue());
    }
}
