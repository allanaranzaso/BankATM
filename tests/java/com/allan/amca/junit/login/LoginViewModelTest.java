package com.allan.amca.junit.login;

import com.allan.amca.login.LoginViewModel;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class LoginViewModelTest {

    @Test
    void loginTest() {
        LoginViewModel loginViewModel = LoginViewModel.getInstance();

        assertThat(loginViewModel.login(4500123410000000L, "1111"), equalTo(true));
        assertThat(loginViewModel.login(4500123410000001L, "1111"), equalTo(true));
        assertThat(loginViewModel.login(4500123410000002L, "9123"), equalTo(true));
        assertThat(loginViewModel.login(4500123410000003L, "9000"), equalTo(true));
        assertThat(loginViewModel.login(4500123410000004L, "4442"), equalTo(true));
    }

    @Test
    void badLogin() {
        LoginViewModel loginViewModel = LoginViewModel.getInstance();

        assertThat(loginViewModel.login(4500123410000001L, "4312"), equalTo(false));
        assertThat(loginViewModel.login(4500123410000002L, "1111"), equalTo(false));
        assertThat(loginViewModel.login(4500123410000003L, "9999"), equalTo(false));
        assertThat(loginViewModel.login(4500123410000004L, "12345"), equalTo(false));
        assertThat(loginViewModel.login(4500123410000005L, "101010"), equalTo(false));

    }
}