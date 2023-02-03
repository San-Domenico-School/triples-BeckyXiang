import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Dealer class
 * 
 * @Becky
 * @02/01/2023
 */
public class Dealer extends Actor
{
    private ArrayList cardsOnBoard;
    private ArrayList cardsSelected;
    private ArrayList selectedCardsIndex;
    private int triplesRemaining;
    private Deck deck;
    private ArrayList checkIfTriple;
    public Dealer(int numCardsInDeck)
    {
        deck = new Deck(numCardsInDeck);
        triplesRemaining = numCardsInDeck / 3;
        Scorekeeper.setDeckSize(numCardsInDeck);
    }
    
    public void addedToWorld(World world)
    {
        dealBoard();
    }
    
    private void dealBoard()
    {
        for (int row = 0; row < 5; row++)
        {
            for(int col = 0; col <3; col++)
            {
                getWorld().addObject(deck.getTopCard(),col * 130+ 83, row * 83 + 60);
            }
        }
    }
    
    private void setUI()
    {
        String cardsRemainingText = new Integer(triplesRemaining * 3).toString();
        String scoreText = new Integer(Scorekeeper.getScore()).toString();
        getWorld().showText(cardsRemainingText, 310, 470);
        getWorld().showText(scoreText, 310,504);
    }
    
    private void checkIfEndGame()
    {
        
    }
    
    public void checkIfTriple(ArrayList<Card> cardsOnBoard,Card[]cardsSelected,
                               ArrayList<Integer>selectedCardsIndex)
    {
        int shapes = cardsSelected[0].getShape().ordinal() +
                     cardsSelected[1].getShape().ordinal() +
                     cardsSelected[2].getShape().ordinal();
        int shadings = cardsSelected[0].getShading() +
                       cardsSelected[1].getShading() +
                       cardsSelected[2].getShading();
        int colors = cardsSelected[0].getColor().ordinal() +
                     cardsSelected[1].getColor().ordinal() +
                     cardsSelected[2].getColor().ordinal();
        int numbersOfShapes = cardsSelected[0].getNumberOfShapes() +
                              cardsSelected[1].getNumberOfShapes() +
                              cardsSelected[2].getNumberOfShapes();
        if(shapes % 3 == 0 && shadings % 3 == 0 && colors % 3 == 0 && numbersOfShapes % 3 == 0)
        {
            removeAndRepleaceTriple(cardsOnBoard, cardsSelected, selectedCardsIndex);
        }
        else
        {
            Animations.wobble(cardsSelected);
        }
    }
    
    private void removeAndRepleaceTriple(ArrayList<Card> cardsOnBoard,Card[]cardsSelected,
                               ArrayList<Integer>selectedCardsIndex)
    {
        //Set position of triple cards by coordinate, 3 cards by 2 coordinates
        int[][]cardsXYCoordinate = new int[3][2];
        for(int card = 0; card < 3; card++)
        {
            cardsXYCoordinate[card][0] = cardsSelected[card].getX();
            cardsXYCoordinate[card][1] = cardsSelected[card].getY();
        }
    
        //Begin card animation off scene view
        Animations.slideAndTurn(cardsSelected);
        
        //Remove and replace triple cards
        for(int card = 0; card < 3; card++)
        {
            getWorld().removeObject(cardsSelected[card]);
            if(deck.getNumCardsInDeck() > 0)
            {
                cardsOnBoard.set(selectedCardsIndex.get(card),deck.getTopCard());
                getWorld().addObject(cardsOnBoard.get(selectedCardsIndex.get(card)),
                                                      cardsXYCoordinate[card][0],
                                                      cardsXYCoordinate[card][1]);
            }
        }
        
        // UI Housekeeping
        triplesRemaining--;
        Scorekeeper.updateScore();
        setUI();
        checkIfEndGame();
    }
}
