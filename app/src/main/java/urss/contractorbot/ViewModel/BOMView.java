package urss.contractorbot.ViewModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import urss.contractorbot.R;
import urss.contractorbot.Model.BOMItem;

public class BOMView extends LinearLayout {

    private TextView tvName;
    private TextView tvType;
    private TextView tvSupplier;
    private TextView tvUnitPrice;
    private TextView tvQuantity;
    private TextView tvTotalPrice;
    private BOMItem bomItem;

    public BOMView(Context context, BOMItem bomItem){
        super(context);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.bom_row_layout, this, true);

        requestLayout();
        tvName = (TextView)findViewById(R.id.BOMMaterialName);
        tvType = (TextView)findViewById(R.id.BOMMaterialType);
        tvSupplier = (TextView)findViewById(R.id.BOMMaterialSupplier);
        tvUnitPrice = (TextView)findViewById(R.id.BOMUnitPrice);
        tvQuantity = (TextView)findViewById(R.id.BOMQuantity);
        tvTotalPrice = (TextView)findViewById(R.id.BOMTotalPrice);
        setBOMItem(bomItem);
    }

    public void setBOMItem(BOMItem bomItem){
        this.bomItem = bomItem;
        tvName.setText(bomItem.getMaterial().getName());
        tvType.setText(bomItem.getMaterial().getType().getName());
        tvSupplier.setText(bomItem.getMaterial().getSupplier().getName());
        tvUnitPrice.setText(bomItem.getMaterial().getPrice() + "$");
        tvQuantity.setText(bomItem.getQuantity() + "");
        float totalPrice = (float)bomItem.getQuantity() * (float)bomItem.getMaterial().getPrice();
        tvTotalPrice.setText(totalPrice + "$");
    }

    public BOMItem getBomItem(){ return bomItem; }
}
