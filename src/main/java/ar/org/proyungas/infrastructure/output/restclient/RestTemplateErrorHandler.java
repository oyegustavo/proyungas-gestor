package ar.org.proyungas.infrastructure.output.restclient;



import java.io.IOException;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;




public class RestTemplateErrorHandler implements ResponseErrorHandler {
    private final Map<HttpStatus, RuntimeException> exceptionsMap;

    public RestTemplateErrorHandler(Map<HttpStatus, RuntimeException> exceptionsMap) {
        this.exceptionsMap = exceptionsMap;
    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().isError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        HttpStatus statusCode = (HttpStatus) response.getStatusCode();
        if (statusCode == HttpStatus.CONFLICT) {
//            throw new JurisdictionSlugNotFoundException(ErrorCode.NOT_FOUND_ERROR);
        }
//        throw exceptionsMap.getOrDefault(statusCode,
//                new RestClientGenericException(ErrorCode.REST_CLIENT_ERROR));
    }
}