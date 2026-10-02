package ar.org.proyungas.infrastructure.input.plantype.create;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class LayerVersionResponse {
	UUID id;
	Integer versionNumber;
	String formatt;
	String originalNumber;
	String minioPath;
	String minioBucket;
	Long bytesSize;
	String hashSha256;
	String coordsSystem;
	String uploadedById;
}
