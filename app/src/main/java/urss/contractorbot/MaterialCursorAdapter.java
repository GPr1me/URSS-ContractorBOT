package urss.contractorbot;

import android.content.Context;
import android.database.Cursor;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

public class MaterialCursorAdapter extends CursorAdapter
{
    public MaterialCursorAdapter(Context context, Cursor materialCursor, int flags)
    {
        super(context, materialCursor, flags);
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        int materialId = cursor.getInt(0);
        String materialName = cursor.getString(1);
        int materialTypeId = cursor.getInt(2);
        int materialSupplierId = cursor.getInt(3);
        double materialPrice = cursor.getDouble(4);

        //Material material = new Material(materialId, materialName, materialType, materialSupplier, materialPrice)
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        String livre_titre = cursor.getString(1);
        String livre_auteur = cursor.getString(2);
        String livre_categorie = cursor.getString(3);
        int livre_id = cursor.getInt(0);
        /*Livre livre = new Livre(livre_id, livre_titre, livre_auteur, livre_categorie);
        LivreView livre_view = new LivreView(context, livre);
        return livre_view;*/
        return new View(context);
    }
}
