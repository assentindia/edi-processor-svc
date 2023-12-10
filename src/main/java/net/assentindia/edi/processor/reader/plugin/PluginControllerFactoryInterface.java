package net.assentindia.edi.processor.reader.plugin;

import net.assentindia.edi.processor.reader.Tokenizer;

public interface PluginControllerFactoryInterface {
    PluginController create(String standard, String docType, Tokenizer tokenizer);

    PluginController create(String standard, String docType, String docVersion, String docRelease, Tokenizer tokenizer);

    PluginController getLastControllerCreated();
}
