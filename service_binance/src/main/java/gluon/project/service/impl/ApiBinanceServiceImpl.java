package gluon.project.service.impl;

import gluon.project.myexceptions.RequestSendException;
import gluon.project.service.ApiBinanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiBinanceServiceImpl implements ApiBinanceService {

    Logger logger = LoggerFactory.getLogger(ApiBinanceServiceImpl.class);

    HttpRequest httpRequest;
    HttpClient httpClient;
    HttpResponse<String> httpResponse;

    @Override
    public boolean isConnectionOk() {
        String testConnectivityUrl = "https://api.binance.com/api/v3/ping";

        this.httpRequest = HttpRequest
                .newBuilder()
                .uri(URI.create(testConnectivityUrl))
                .build();
        this.httpClient = HttpClient.newHttpClient();
        try {
            this.httpResponse = this.httpClient.send(this.httpRequest, HttpResponse.BodyHandlers.ofString());
            logger.atInfo().log(this.httpResponse.body());
            logger.atInfo().log(this.httpResponse.headers().toString());

        } catch (IOException e) {
            throw new RequestSendException(e);
        } catch (InterruptedException e) {
            logger.atWarn().log("Iterrupted!", e);
            Thread.currentThread().interrupt();
            throw new RequestSendException(e);
        }

        return this.httpResponse.body().equals("{}");
    }
}
