package com.redtulip.workfone.restful.client;

import org.androidannotations.annotations.EBean;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;

import java.io.IOException;

/**
 * Created by kaplanfatt on 28/12/15.
 */
@EBean(scope = EBean.Scope.Singleton)
public class RestAuthInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public org.springframework.http.client.ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        return execution.execute(request, body);

    }
}