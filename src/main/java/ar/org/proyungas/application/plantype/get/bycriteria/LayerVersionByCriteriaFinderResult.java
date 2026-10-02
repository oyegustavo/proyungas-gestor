package ar.org.proyungas.application.plantype.get.bycriteria;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LayerVersionByCriteriaFinderResult {
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
