import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Notebook implements Comparable<Notebook>{
    private final BigDecimal price;
    private final int memory;
    private final Vendor vendor;
    private final UUID serialID = UUID.randomUUID();

    public BigDecimal getPrice() {
        return price;
    }
    public int getMemory() {
        return memory;
    }
    public Vendor getVendor() {
        return vendor;
    }
    public UUID getSerialID() {
        return serialID;
    }

    public enum Vendor {
        Lenuvo1, Asos2, MacNote3, Eser4, Xamiou5
    }

    public Notebook(BigDecimal price, int memory, Vendor vendor) {
        this.price = price;
        this.memory = memory;
        this.vendor = vendor;
    }

    @Override
    public int compareTo(Notebook nb) {
        int result = price.compareTo(nb.getPrice());
        if (result == 0) {
            result = Integer.compare(memory, nb.getMemory());
            if (result == 0) {
                return vendor.compareTo(nb.getVendor());
            }
            return result;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "price=" + price +
                ", memory=" + memory +
                ", vendor=" + vendor +
                ", serialID=" + serialID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notebook)) return false;
        Notebook notebook = (Notebook) o;
        return memory == notebook.memory && price.equals(notebook.price) && vendor == notebook.vendor && serialID.equals(notebook.serialID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, memory, vendor, serialID);
    }
}
