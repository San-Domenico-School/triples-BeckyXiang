import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Dealer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dealer extends Actor
{
    private ArrayList cardsOnBoard;
    private ArrayList cardsSelected;
    private ArrayList selectedCardsIndex;
    private int triplesRemaining;
    private Deck deck;
    
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
    }
}
