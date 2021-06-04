
import java.time.LocalDate;
import java.util.Objects;

public class Ingredient{
    private final int id;
    private final String name;
    private final int amount;
    private final String unit;
    private final LocalDate expDate;

    public Ingredient(int id, String name, int amount, String unit, String expDate) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.expDate = setDate(expDate);
    }

    private LocalDate setDate(String string){
        String[] arrFromDate = string.split("\\.");
        return LocalDate.of(Integer.parseInt(arrFromDate[2]), Integer.parseInt(arrFromDate[1]), Integer.parseInt(arrFromDate[0]));
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + amount + ", " + unit + ", " + expDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return amount == that.amount && Objects.equals(name, that.name) && Objects.equals(unit, that.unit) && Objects.equals(expDate, that.expDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, unit, expDate);
    }
}