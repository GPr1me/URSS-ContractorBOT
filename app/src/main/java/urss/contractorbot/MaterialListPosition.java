package urss.contractorbot;

import java.io.Serializable;

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
}
