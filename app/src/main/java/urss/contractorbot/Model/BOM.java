package urss.contractorbot.Model;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BOM {

    private List<BOMItem> list;

    public BOM(){
        list = new ArrayList<>();
    }

    public List<BOMItem> getList(){ return list; }

    public void addItem(BOMItem item){
        if(list.contains(item)){
            list.get(list.indexOf(item)).add(item.getQuantity());
        } else {
            list.add(item);
        }
    }

    public void addItem(Material material, int quantity){
        addItem(new BOMItem(material, quantity));
    }

    public void addItem(MaterialListPosition materialListPosition, int quantity){
        addItem(new BOMItem(materialListPosition, quantity));
    }

    public void addList(ArrayList materials, int quantity){
        for(Object material: materials){
            if(material instanceof Material){
                addItem(new BOMItem((Material)material, quantity));
            } else if(material instanceof MaterialListPosition){
                addItem(new BOMItem((MaterialListPosition)material, quantity));
            } else {
                break;
            }
        }
    }

    public float calculateGrandTotal(){
        float result = 0;

        for(BOMItem item: list){
            result += (item.getQuantity() * item.getMaterial().getPrice());
        }

        return result;
    }
}
