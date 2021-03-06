package br.com.restassuredapitesting.tests.auth.tests;

import base.BaseTest;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.SmokeTests;
import br.com.restassuredapitesting.tests.auth.request.PostAuthRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.CoreMatchers.notNullValue;

@Feature("Feature de Autenticação")
public class PostAuthTest extends BaseTest {
    PostAuthRequest postAuthRequest= new PostAuthRequest ();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, SmokeTests.class})
    @DisplayName("Retorna token para o usuario")

    public void validaRetornoTokenUsuario(){
        postAuthRequest.tokenReturn()
                .then()
                .statusCode(200)
                .body("token",notNullValue());

    }
}

