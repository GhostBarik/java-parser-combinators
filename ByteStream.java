package cz.wincor.eps.cardhost.importer.impl.phillips66.parser;

/**
 * Immutabilní třída, view nad bytovem polem, zjednodušuje logiku parseru {@link BinaryParser}
 * při načítaní ruzných segmentů dat a posouvání v poli. Immutabilita zajištuje bezpečné
 * sdílení streamu mezi vice parsery.
 */
public class ByteStream {

    /**
     * binarní data, které se "streamují"
     */
    private final byte[] data;

    /**
     * pozice ve streamů
     */
    private final int position;

    public ByteStream(byte[] data) {
        this.data = data;
        this.position = 0;
    }

    public ByteStream(byte[] data, int position) {
        this.data = data;
        this.position = position;
    }

    /**
     * posouvání ve streamu o určitý počet bajtů, vrací nový objekt streamu s obnovenou pozici
     *
     * @param shift o klik bajtu se má stream posunout
     * @return nový objekt streamu s obnovenou pozici
     */
    public ByteStream move(int shift) {
        return new ByteStream(data, position + shift);
    }

    public byte[] getData() {
        return data;
    }

    public int getPosition() {
        return position;
    }
}
