package cz.wincor.eps.cardhost.importer.impl.phillips66.parser;

/**
 * výsledek parsování - samotný vysledek + posunutá sekvence bajtů po přečtení
 */
public class ParsingResult<T> {

    private T result;
    private ByteStream restStream;

    public ParsingResult(T result, ByteStream restStream) {
        this.result = result;
        this.restStream = restStream;
    }

    public T getResult() {
        return result;
    }

    public ByteStream getRestStream() {
        return restStream;
    }
}
