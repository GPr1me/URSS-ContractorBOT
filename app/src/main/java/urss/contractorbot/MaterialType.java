package urss.contractorbot;

public class MaterialType {
    private int _id;
    private String name;

    public MaterialType(int _id, String name)
    {
        super();
        this._id = _id;
        this.name = name;
    }

    public MaterialType(String name)
    {
        super();
        this.name = name;
    }

    public int get_id() { return _id; }

    public String getName() { return name; }
}

