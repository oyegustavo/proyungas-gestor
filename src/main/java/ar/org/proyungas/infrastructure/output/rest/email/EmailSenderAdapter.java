package ar.org.proyungas.infrastructure.output.rest.email;

import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ar.org.proyungas.infrastructure.output.restclient.RestTemplateErrorHandler;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.ExternalServiceException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmailSenderAdapter implements EmailSenderOutputPort {

	private final RestTemplate restTemplate;

	private final EmailSenderAdapterConfigurationProperties emailSenderAdapterConfigurationProperties;

	
	
	public EmailSenderAdapter(RestTemplate restTemplate,
			EmailSenderAdapterConfigurationProperties emailSenderAdapterConfigurationProperties) {
		

        var errorHandler = new RestTemplateErrorHandler(
                        Map.of(
                                        HttpStatus.INTERNAL_SERVER_ERROR,
                                        new ExternalServiceException(ErrorCode.EXTERNAL_SERVICE_ERROR),
                                        HttpStatus.SERVICE_UNAVAILABLE,
                                        new ExternalServiceException(ErrorCode.EXTERNAL_SERVICE_ERROR)));

		
		this.restTemplate = restTemplate;
		this.restTemplate.setErrorHandler(errorHandler);
		this.emailSenderAdapterConfigurationProperties = emailSenderAdapterConfigurationProperties;
	}



	@Override
	public void perform(EmailMessage emailMessage) {
	    String requestUri = emailSenderAdapterConfigurationProperties.getBaseUri()
	            .concat(emailSenderAdapterConfigurationProperties.getEmailUri());

	    log.info("Calling external service POST {}", requestUri);

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    HttpEntity<EmailMessage> requestEntity = new HttpEntity<>(emailMessage, headers);

	    restTemplate.exchange(
	            requestUri,
	            HttpMethod.POST,
	            requestEntity,
	            new ParameterizedTypeReference<Void>() {}
	    );
	}


}
