package urss.contractorbot.Model;

import java.io.Serializable;
import java.util.Objects;

public class BOMItem {

    private Material material;
    private int quantity;

    public BOMItem(Material material, int quantity){
        this.material = material;
        this.quantity = quantity;
    }

    public BOMItem(MaterialListPosition materialListPosition, int quantity){
        this.material = materialListPosition.getMaterial();
        this.quantity = quantity;
    }

    public Material getMaterial(){ return material; }

    public int getQuantity(){ return quantity; }

    public void setQuantity(int quantity){
        if(quantity <= 0){
            this.quantity = quantity;
        }
    }

    public void add(int quantity){
        if(quantity > 0){
            this.quantity += quantity;
        }
    }

    public void add(BOMItem item){
        if(item.quantity > 0
                && item.getMaterial().equals(this.material)){
            this.quantity = item.getQuantity();
        }
    }

//    @Override
//    public boolean equals(Object o) {
//
//        if (o == this) return true;
//        if (!(o instanceof BOMItem)) {
//            return false;
//        }
//        BOMItem material = (BOMItem) o;
//        return this._id == material.get_id()
//                && this.name.equals(material.getName())
//                && this.price == material.getPrice()
//                && Objects.equals(this.type, material.getType())
//                && Objects.equals(this.supplier, material.getSupplier());
//    }
}
