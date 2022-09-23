package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.Main;
import sample.Model.Product;
import sample.MyListener;

import java.awt.event.ActionEvent;

public class itemController {
    @FXML
    private ImageView image;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;
    @FXML
    private void click(MouseEvent mouseEvent){
        myListener.onClickListener(newProduct);
    }
    private Product newProduct;
    private MyListener myListener;
    public void setData(Product newProduct, MyListener myListener) {
        this.newProduct = newProduct;
        this.myListener = myListener;
        nameLabel.setText(newProduct.getName());
        priceLabel.setText(String.valueOf(newProduct.getPrice()));
        Image newImage = new Image(getClass().getResourceAsStream(newProduct.getImgSrc()));
        image.setImage(newImage);

    }


}
