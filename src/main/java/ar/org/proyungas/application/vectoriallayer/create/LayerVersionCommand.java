package ar.org.proyungas.application.vectoriallayer.create;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LayerVersionCommand {
	UUID id;
	LayerTemplateCommand layerTemplate;
	Integer versionNumber;
	String formatt;
	String originalNumber;
	String minioPath;
	String minioBucket;
	Long bytesSize;
	String hashSha256;
	String coordsSystem;
	UUID uploadedById;
	LocalDateTime createdAt;
}
