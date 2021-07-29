

package mage.cards.p;

import java.util.UUID;
import mage.abilities.effects.common.discard.DiscardCardYouChooseTargetEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.filter.FilterCard;
import mage.filter.predicate.Predicates;
import mage.target.common.TargetOpponent;

/**
 *
 * @author amcomeau
 */

public final class PrecisionCutting extends CardImpl {

    private static final FilterCard filter = new FilterCard("a noncreature, nonland card");
    static {
        filter.add(Predicates.not(CardType.CREATURE.getPredicate()));
        filter.add(Predicates.not(CardType.LAND.getPredicate()));
    }

    public PrecisionCutting(UUID ownerId, CardSetInfo setInfo){
        super(ownerId,setInfo,new CardType[]{CardType.SORCERY},"{B}");


        // Target opponent reveals their hand. You choose a noncreature, nonland card from it. That player discards that card.
        this.getSpellAbility().addTarget(new TargetOpponent());
        this.getSpellAbility().addEffect(new DiscardCardYouChooseTargetEffect(filter));
    }

    private PrecisionCutting(final PrecisionCutting card) {
        super(card);
    }

    @Override
    public PrecisionCutting copy() {
        return new PrecisionCutting(this);
    }
}
