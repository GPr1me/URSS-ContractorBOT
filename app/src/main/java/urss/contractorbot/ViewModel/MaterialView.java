package urss.contractorbot.ViewModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import urss.contractorbot.R;
import urss.contractorbot.Model.Material;

public class MaterialView extends LinearLayout {

    private TextView tvName;
    private TextView tvType;
    private TextView tvSupplier;
    private TextView tvPrice;
    private Material material;

    public MaterialView(Context context, Material material)
    {
        super(context);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.material_row_layout, this, true);

        requestLayout();
        tvName = (TextView)findViewById(R.id.MaterialName);
        tvType = (TextView)findViewById(R.id.MaterialType);
        tvSupplier = (TextView)findViewById(R.id.MaterialSupplier);
        tvPrice = (TextView)findViewById(R.id.MaterialPrice);
        setMaterial(material);
    }

    public void setMaterial(Material material)
    {
        this.material = material;
        tvName.setText(material.getName());
        tvType.setText(material.getType().getName());
        tvSupplier.setText(material.getSupplier().getName());
        tvPrice.setText(material.getPrice() + "$");
    }

    public Material getMaterial() { return material; }
}

