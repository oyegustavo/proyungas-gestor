package ar.org.proyungas.application.action.get.byactionnumber;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class LayerVersionResult {
	UUID id;
	Integer versionNumber;
	String formatt;
	String originalNumber;
	String minioPath;
	String minioBucket;
	Long bytesSize;
	String hashSha256;
	String coordsSystem;
	UserResult uploadedById;
}
