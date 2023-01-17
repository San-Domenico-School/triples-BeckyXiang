import greenfoot.*; 

/**
 * Game Board for Triples
 * 
 * @Becky 
 * @01/12/2023
 */
public class Card extends Actor
{
   private Shape shape;
   private Color color;
   private boolean isSelected;
   private GreenfootImage cardImage,selectedCardImage;
   private int numberOfShapes,shading;
   public Card(Shape shape, Color color, int numberOfShapes, int shading, 
   GreenfootImage cardImage, GreenfootImage selectedCardImage)
   {
       this.shape = shape;
       this.color = color;
       this.numberOfShapes = numberOfShapes;
       this.shading = shading;
       this.cardImage = cardImage;
       this.selectedCardImage = selectedCardImage;
       setImage(cardImage);
   }
   
   public enum Shape
   {
       TRIANGLE,SQUARE,CIRCLE,NO_SHAPE
   }
   
   public enum Color
   {
       RED, GREEN, BLUE, NO_COLOR
   }
   
   public Shape getShape()
   {
       return shape;
   }
   
   public Color getColor()
   {
       return color;
   }
   
   public int getNumberOfShapes()
   {
       return numberOfShapes;
   }
   
   public int getShading()
   {
       return shading;
   }
   
   public GreenfootImage getCardImage()
   {
       return cardImage;
   }
   
   public GreenfootImage getSelectedCardImage()
   {
       return selectedCardImage;
   }
   public boolean getIsSelected()
   {
       return isSelected;
   }
   
   public void setIsSelected(boolean isSelected)
   {
       this.isSelected = isSelected;
   }
}

