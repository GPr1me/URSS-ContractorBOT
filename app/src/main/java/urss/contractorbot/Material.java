package urss.contractorbot;

public class Material {
    private int _id;
    private String name;
    private MaterialType type;
    private MaterialSupplier supplier;
    private double price;

    public Material(int _id,
                    String name,
                    MaterialType type,
                    MaterialSupplier supplier,
                    double price)
    {
        super();
        this._id = _id;
        this.name = name;
        this.type = type;
        this.supplier = supplier;
        this.price = price;
    }

    public Material(String name,
                    MaterialType type,
                    MaterialSupplier supplier,
                    double price)
    {
        super();
        this.name = name;
        this.type = type;
        this.supplier = supplier;
        this.price = price;
    }

    public int get_id() { return _id; }

    public String getName() { return name; }

    public MaterialType getType() { return type; }

    public MaterialSupplier getSupplier() { return supplier; }

    public double getPrice() { return price; }
}