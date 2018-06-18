package com.yet.spring.core.loggers;

import com.yet.spring.core.events.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileEventLogger implements EventLogger {
    protected String fileName;
    protected File file;

    public void init() throws IOException {
        this.file = new File(fileName);
        if (!file.canWrite()) {
            throw new IOException();
        }
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(new File(fileName), event.toString(), Charset.defaultCharset(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
