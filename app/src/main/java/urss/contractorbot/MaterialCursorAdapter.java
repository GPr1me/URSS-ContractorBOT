package urss.contractorbot;

import android.content.Context;
import android.database.Cursor;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

/**
 * Handle a cursor pointing to the Material table and generate the corresponding view
 */
public class MaterialCursorAdapter extends CursorAdapter
{
    public MaterialCursorAdapter(Context context, Cursor materialCursor, int flags)
    {
        super(context, materialCursor, flags);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor)
    {
        MaterialView materialView = (MaterialView) view;
        materialView.setMaterial(getMaterial(cursor));
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return new MaterialView(context, getMaterial(cursor));
    }

    private Material getMaterial(Cursor cursor)
    {
        int materialId = cursor.getInt(0);
        String materialName = cursor.getString(1);
        int materialTypeId = cursor.getInt(2);
        String materialTypeName = cursor.getString(3);
        int materialSupplierId = cursor.getInt(4);
        String materialSupplierName = cursor.getString(5);
        double materialPrice = cursor.getDouble(6);

        return new Material(materialId,
                            materialName,
                            new MaterialType(materialTypeId,
                                             materialTypeName),
                            new MaterialSupplier(materialSupplierId,
                                                 materialSupplierName),
                            materialPrice);
    }
}
