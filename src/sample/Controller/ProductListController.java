package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import sample.Model.Product;
import sample.MyListener;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class ProductListController implements Initializable {
    @FXML
    private Label ProductName;

    @FXML
    private Label ProductPrice;

    @FXML
    private VBox chosenProductCard;

    @FXML
    private ImageView image;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    private List<Product> Products = new ArrayList<>();
    private MyListener myListener;
    private List<Product> getData(){
        List<Product> products = new ArrayList<>();
        Product product;
           product = new Product();
           product.setName("Z Fold 4");
           product.setPrice(800.99);
           product.setImgSrc("..\\asset\\img\\samsung-galaxy-z-flip.jpg");
           product.setColor("6A7324");
           products.add(product);
        product = new Product();
            product.setName("Samsung 1");
            product.setPrice(300.99);
            product.setImgSrc("..\\asset\\img\\samsung1.jpg");
            product.setColor("3498db");
            products.add(product);
        product = new Product();
            product.setName("Samsung 2");
            product.setPrice(200.99);
            product.setImgSrc("..\\asset\\img\\samsung2.jpg");
            product.setColor("f1c40f");
            products.add(product);
        product = new Product();
            product.setName("Samsung 3");
            product.setPrice(400.99);
            product.setImgSrc("..\\asset\\img\\samsung3.jpg");
            product.setColor("d35400");
            products.add(product);
        product = new Product();
            product.setName("Samsung 4");
            product.setPrice(500.99);
            product.setImgSrc("..\\asset\\img\\sangsung4.png");
            product.setColor("bdc3c7");
            products.add(product);


        return products;
    }
    private void setChosenProductCard(Product product){
        ProductName.setText(product.getName());
        ProductPrice.setText(String.valueOf(product.getPrice()));
        Image newImage = new Image(getClass().getResourceAsStream(product.getImgSrc()));
        image.setImage(newImage);
        chosenProductCard.setStyle("-fx-background-color:#"+product.getColor()+";\n"+
                "fx-background-radius:30;");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Products.addAll(getData());
        if(Products.size()>0){
            setChosenProductCard(Products.get(0));
            myListener= new MyListener() {
                @Override
                public void onClickListener(Product product) {
                    setChosenProductCard(product);
                }
            };
        }
        int column=0;
        int row = 2;
        try {
        for(int i=0; i<Products.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/sample/Views/item.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            itemController itemController = fxmlLoader.getController();
            itemController.setData(Products.get(i),myListener);
            if (column==3){
                column=0;
                row++;
            }
            grid.add(anchorPane, column++, row);
            grid.setMinWidth(Region.USE_COMPUTED_SIZE);
            grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
            grid.setMaxWidth(Region.USE_PREF_SIZE);


            grid.setMinHeight(Region.USE_COMPUTED_SIZE);
            grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
            grid.setMaxHeight(Region.USE_PREF_SIZE);
            GridPane.setMargin(anchorPane,new Insets(10));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
