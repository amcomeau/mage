package mage.cards.s;

import mage.abilities.effects.common.CreateTokenEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.game.permanent.token.BorgDroneToken;

import java.util.UUID;

/**
 * @author amcomeau
 */
public final class StrengthInNumbers extends CardImpl {

    public StrengthInNumbers(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.INSTANT}, "{2}{B}{B}");

        // Create two 2/2 Borg Drone creature tokens with devoid.
        this.getSpellAbility().addEffect(new CreateTokenEffect(new BorgDroneToken(), 2));
    }

    private StrengthInNumbers(final StrengthInNumbers card) {
        super(card);
    }

    @Override
    public StrengthInNumbers copy() {
        return new StrengthInNumbers(this);
    }
}
