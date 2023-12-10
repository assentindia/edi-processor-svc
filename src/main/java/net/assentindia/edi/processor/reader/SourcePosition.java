package net.assentindia.edi.processor.reader;

public interface SourcePosition {
    int getCharCount();

    int getSegmentCharCount();

    void setCharCounts(int charCount, int segmentCharCount);
}
