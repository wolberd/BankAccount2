import java.util.List;

/**
 * Measurable has an abstract method that implementers provide to specify
 * their measure (some value). It also provides a static method average that
 * averages measurable objects using getMeasure. Note variable type T can be any
 * subclass/implementer of Measurable (or Measurable).
 */
public interface Measurable {
    float getMeasure();

    public static <T extends Measurable> float average(List<T> items) {
        if (items.size()==0) return 0.0f;

        float total=0.0f;
        for (T m:items) {
            total=total+m.getMeasure();
        }
        return total/items.size();
    }
}
