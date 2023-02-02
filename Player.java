import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Player here.
 * 
 * @Becky
 * @01/31/2023
 */
public class Player extends Actor
{
    private Dealer dealer;
    private ArrayList cardsSelected;
    private ArrayList cardsOnBoard;
    private ArrayList selectedCardsIndex;
    private ArrayList checkIfTriple;
    public void act()
    {
        selectCards();
        Dealer.checkIfTriple (cardsOnBoard,cardsSelected,selectedCardsIndex);
        resetCardsSelected();
    }
    public World addedToWorld()
    {
        cardsOnBoard = (ArrayList) getWorld().getObjects(Card.class);
    }
    private void selectCards()
    {
           for(int i = 0; i < cardsOnBoard.size(); i++)
           {
                  if(Greenfoot.mouseClicked(cardsOnBoard.get(i)))
                 {
                         if(cardsOnBoard.get(i).getIsSelected())
                         {
                              cardsOnBoard.get(i).setIsSelected(false);
                              cardsOnBoard.get(i).setImage(cardsOnBoard.get(i).getCardImage());
                              selectedCardsIndex.remove(new Integer(i));
                         }
                         else
                         {
                               cardsOnBoard.get(i).setIsSelected(true);
                               cardsOnBoard.get(i).setImage(cardsOnBoard.get(i).getSelectedCardImage());
                               selectedCardsIndex.add(new Integer(i));
                         }
                  }
            }
    } 

    private void resetCardsSelected();
    private boolean threeCardsSelected;
    {
        //return = false;
    }
}
