package urss.contractorbot.ViewModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import urss.contractorbot.R;
import urss.contractorbot.Model.Material;

public class MaterialView extends LinearLayout {

    private TextView tvName;
    private TextView tvType;
    private TextView tvSupplier;
    private TextView tvPrice;
    private Material material;

    private DecimalFormat floatFormat;
    private DecimalFormatSymbols separator;
    private String unit = "$/pi\u00B2";

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
        separator = new DecimalFormatSymbols(DecimalFormatSymbols.getAvailableLocales()[0]);
        separator.setDecimalSeparator('.');
        floatFormat = new DecimalFormat("#.##", separator);
        floatFormat.setMinimumFractionDigits(2);

        this.material = material;
        tvName.setText(material.getName());
        tvType.setText(material.getType().getName());
        tvSupplier.setText(material.getSupplier().getName());
        tvPrice.setText(floatFormat.format(material.getPrice()) + unit);
    }

    public Material getMaterial() { return material; }
}

