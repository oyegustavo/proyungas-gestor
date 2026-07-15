package ar.org.proyungas.shared.infrastructure.utils;




import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class JpaFilterBuilder {

	private final Map<String, String> translations =
		    Collections.unmodifiableMap(
		        Stream.of(
		            new AbstractMap.SimpleEntry<>("actionNumber", "actionNumber"),
		            new AbstractMap.SimpleEntry<>("propertyOwner", "propertyOwner")
		        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
		    );

    private final Map<String, JpaFormatter> formatters =
    	    Collections.unmodifiableMap(
    	        Stream.of(
    	            new AbstractMap.SimpleEntry<>("actionNumber", new JpaStringFormatter()),
    	            new AbstractMap.SimpleEntry<>("propertyOwner", new JpaStringFormatter())
    	        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
    	    );

    private final Map<Class<? extends Filter>, JpaFilter> jpaFilterFactory =
    	    Collections.unmodifiableMap(
    	        Stream.of(
    	            new AbstractMap.SimpleEntry<>(EqualsFilter.class, new JpaEqualsFilter()),
    	            new AbstractMap.SimpleEntry<>(ContainsFilter.class, new JpaContainsFilter())
    	        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
    	    );

    public JpaFilter build(Filter filter) {
        return jpaFilterFactory.get(filter.getClass())
                .fromDomain(filter)
                .formatValues(formatters)
                .translateField(translations);
    }
}