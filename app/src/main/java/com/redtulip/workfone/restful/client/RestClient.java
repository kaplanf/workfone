package com.redtulip.workfone.restful.client;


import com.redtulip.workfone.restful.model.LoginModel;
import com.redtulip.workfone.util.NetworkConstants;

import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.RestClientErrorHandling;
import org.androidannotations.api.rest.RestClientHeaders;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

@Rest(rootUrl = NetworkConstants.BASE_URL, converters = {GsonHttpMessageConverter.class, StringHttpMessageConverter.class}
        )
public interface RestClient extends RestClientHeaders, RestClientErrorHandling {

    @Post(NetworkConstants.OFFICER_LOGIN)
    LoginModel loginOfficer(LoginModel.LoginRequest request);


//    LoginModel loginOfficer(LinkedTreeMap request);


}


