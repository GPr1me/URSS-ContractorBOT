package urss.contractorbot.ViewModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

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

    private DecimalFormat floatFormat;
    private DecimalFormatSymbols separator;
    private String areaUnit = "pi\u00B2";

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
        separator = new DecimalFormatSymbols(DecimalFormatSymbols.getAvailableLocales()[0]);
        separator.setDecimalSeparator('.');
        floatFormat = new DecimalFormat("#.##", separator);
        floatFormat.setMinimumFractionDigits(2);

        this.bomItem = bomItem;
        tvName.setText(bomItem.getMaterial().getName());
        tvType.setText(bomItem.getMaterial().getType().getName());
        tvSupplier.setText(bomItem.getMaterial().getSupplier().getName());
        tvUnitPrice.setText(floatFormat.format(bomItem.getMaterial().getPrice()) + "$/" + areaUnit);
        tvQuantity.setText("Quantité: " + bomItem.getQuantity() + areaUnit);
        float totalPrice = (float)bomItem.getQuantity() * (float)bomItem.getMaterial().getPrice();
        tvTotalPrice.setText("Prix total: " + floatFormat.format(totalPrice) + "$");
    }

    public BOMItem getBomItem(){ return bomItem; }
}
