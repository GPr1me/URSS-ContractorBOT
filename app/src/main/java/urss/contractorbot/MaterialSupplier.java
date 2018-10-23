package urss.contractorbot;

import android.text.TextUtils;

public class MaterialSupplier {
    private int _id;
    private  String name;

    public MaterialSupplier(int _id, String name)
    {
        super();
        this._id = _id;
        this.name = TextUtils.isEmpty(name) ? "error" : name;
    }

    public MaterialSupplier(String name)
    {
        super();
        this.name = TextUtils.isEmpty(name) ? "error" : name;
    }

    public int get_id() { return _id; }

    public String getName() { return name; }
}
