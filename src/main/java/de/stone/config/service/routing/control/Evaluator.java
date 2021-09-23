package de.stone.config.service.routing.control;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import de.stone.config.service.routing.entity.DocumentRouting;

public interface Evaluator {
	
	Optional<String> matches(final InputStream is, List<DocumentRouting> routings);
}
