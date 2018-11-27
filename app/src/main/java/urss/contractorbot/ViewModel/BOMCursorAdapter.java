package urss.contractorbot.ViewModel;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

import urss.contractorbot.Model.BOMItem;
import urss.contractorbot.Model.Material;
import urss.contractorbot.Model.MaterialSupplier;
import urss.contractorbot.Model.MaterialType;

public class BOMCursorAdapter extends CursorAdapter {

    public BOMCursorAdapter(Context context, Cursor BOMCursor, int flags){
        super(context, BOMCursor, flags);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        BOMView bomView = (BOMView) view;
        bomView.setBOMItem(getBomItem(cursor));
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return new BOMView(context, getBomItem(cursor));
    }

    private BOMItem getBomItem(Cursor cursor){
        int materialId = cursor.getInt(1);
        int bomQuantity = cursor.getInt(2);
        String materialName = cursor.getString(3);
        int materialTypeId = cursor.getInt(4);
        String materialTypeName = cursor.getString(5);
        int materialSupplierId = cursor.getInt(6);
        String materialSupplierName = cursor.getString(7);
        double materialPrice = cursor.getDouble(8);


        Material material = new Material(materialId,
                                         materialName,
                                         new MaterialType(materialTypeId,
                                                          materialTypeName),
                                         new MaterialSupplier(materialSupplierId,
                                                              materialSupplierName),
                                         materialPrice);
        return new BOMItem(material, bomQuantity);
    }
}
