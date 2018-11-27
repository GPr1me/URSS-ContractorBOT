package urss.contractorbot.Model;

import android.text.TextUtils;

import java.io.Serializable;

public class MaterialSupplier implements Serializable {
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

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof MaterialSupplier)) {
            return false;
        }
        MaterialSupplier supplier = (MaterialSupplier) o;
        return this._id == supplier.get_id()
                && this.name.equals(supplier.getName());
    }
}
