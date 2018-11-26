package urss.contractorbot.Model;

import java.io.Serializable;
import java.util.Objects;

// Only to pre select thos bastard in listview
public class MaterialListPosition implements Serializable {
    private Material material;
    private int position;

    public MaterialListPosition(Material material, int position){
        this.material = material;
        this.position = position;
    }

    public Material getMaterial(){ return material; }

    public int getPosition(){ return position; }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof MaterialListPosition)) {
            return false;
        }
        MaterialListPosition material = (MaterialListPosition) o;
        return Objects.equals(this.material, material.getMaterial());
    }
}
