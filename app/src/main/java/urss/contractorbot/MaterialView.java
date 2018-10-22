package urss.contractorbot;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MaterialView extends LinearLayout {

    private TextView titleView;
    private Material material;

    public MaterialView(Context context, Material material)
    {
        super(context);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.material_row_layout, this, true);

        titleView = (TextView)findViewById(R.id.message);
        setMaterial(material);
        requestLayout();
    }

    public void setMaterial(Material material)
    {
        this.material = material;
        titleView.setText(material.getName());
    }

    public Material getMaterial() { return material; }
}

