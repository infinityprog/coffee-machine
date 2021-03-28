package be.umons.coffeemachine.config;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

public abstract class TestConfig {

    public TestConfig() {
        Configurator.setRootLevel(Level.DEBUG);
    }
}
