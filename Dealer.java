import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Dealer here.
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
        getWorld().showText(scoreText, 310,584);
    }
    
    private void checkIfEndGame()
    {
        
    }
    
    private void checkIfTriple(ArrayList<Card> cardsOnBoard,Card[]cardsSelected,
                               ArrayList<Integer>selectedCardsIndex)
    {
        
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
    }
    
    //Begin card animation off scene view
    Animations.slideAndTurn(cardsSelected);
    
    //Remove and replace triple cards
    for(int card = 0; card < 3; card++)
    {
        getWorld().removeObject(cardsSelected[card]);
        if(deck.getNumCardsInDeck() > 0)
        {
            cardsOnBoard.set(selectedCardsIndex.get(card).deck.getToopCard());
            getWorld().addObject(cardsOnBoard.get(selectedCardsIndec.get(card)),
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
