package urss.contractorbot;

import android.text.TextUtils;

import java.io.Serializable;

public class MaterialType implements Serializable {
    private int _id;
    private String name;

    public MaterialType(int _id, String name)
    {
        super();
        this._id = _id;
        this.name = TextUtils.isEmpty(name) ? "error" : name;
    }

    public MaterialType(String name)
    {
        super();
        this.name = TextUtils.isEmpty(name) ? "error" : name;
    }

    public int get_id() { return _id; }

    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof MaterialType)) {
            return false;
        }
        MaterialType type = (MaterialType) o;
        return this._id == type.get_id()
                && this.name.equals(type.getName());
    }
}

