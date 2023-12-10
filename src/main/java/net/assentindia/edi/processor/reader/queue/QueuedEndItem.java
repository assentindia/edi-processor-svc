package net.assentindia.edi.processor.reader.queue;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import net.assentindia.edi.processor.reader.EDIAttributes;
import net.assentindia.edi.processor.reader.SourcePosition;

public class QueuedEndItem extends QueuedItem {

    public QueuedEndItem(String uri, String localName, String qName, int charCount, int segmentCharCount) {
        super(uri, localName, qName, charCount, segmentCharCount);
    }

    @Override
    public void process(ContentHandler handler) throws SAXException {
        if (handler instanceof SourcePosition) {
            ((SourcePosition) handler).setCharCounts(getCharCount(), getSegmentCharCount());
        }
        handler.endElement(getUri(), getLocalName(), getQName());
    }

    @Override
    public void addData(String data) {
        throw new RuntimeException("addData() should not be called on an end item");
    }

    @Override
    public EDIAttributes getAttributes() {
        throw new RuntimeException("getAttributes() should not be called on an end item");
    }
}
