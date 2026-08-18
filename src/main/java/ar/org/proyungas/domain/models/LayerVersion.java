package ar.org.proyungas.domain.models;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class LayerVersion {
	UUID id;
	LayerTemplate layerTemplate;
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
