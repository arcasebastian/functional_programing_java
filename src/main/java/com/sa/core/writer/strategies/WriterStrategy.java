package com.sa.core.writer.strategies;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public interface WriterStrategy {

    Stream<String> getOutput(List<Map<String, String>> logs);
}
