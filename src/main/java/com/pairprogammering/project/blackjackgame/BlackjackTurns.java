package com.pairprogammering.project.blackjackgame;

import com.pairprogammering.project.deckcards.Card;
import com.pairprogammering.project.deckcards.Deck;
import com.pairprogammering.project.game.Player;
import com.pairprogammering.project.game.UserInterface;

public class BlackjackTurns {
        private Deck deck;
        private Player dealer;
        private BlackjackCalculate scoring;
        private final UserInterface ui = new UserInterface();

        public BlackjackTurns(Deck deck, Player dealer, BlackjackCalculate scoring) {
            this.deck = deck;
            this.dealer = dealer;
            this.scoring = scoring;
        }

    public boolean playerTurn(Player player, String name) {
        while (true) {
            String choice = ui.askPlayerChoice();
            if (choice.equalsIgnoreCase("hit")) {
                player.addCard(deck.drawCard());
                int total = scoring.calculateScore(player.getHand(), 0);
                ui.showHand(name, player.getHand(), total);

                if (total > 21) {
                    ui.showMessage(name + " busts!");
                    return true;
                } else if (total == 21) {
                    ui.showMessage(name + " hits 21!");
                    return false;
                }
            } else if (choice.equalsIgnoreCase("stand")) {
                return false;
            } else {
                ui.showMessage("Invalid choice. Please enter 'hit' or 'stand'.");
            }
        }
    }

    public boolean dealerTurn() {
        while (scoring.calculateScore(dealer.getHand(), 0) < 17) {
            Card card = deck.drawCard();
            dealer.addCard(card);
            ui.showMessage("Dealer drew: " + card);
        }

        int total = scoring.calculateScore(dealer.getHand(),0);
        ui.showHand("Dealer", dealer.getHand(), total);

        if (total > 21) {
            ui.showMessage("Dealer busts! ♥♠♣♦ You win! ♣♦♥♠");
            return true;
        }
        return false;
    }
}
