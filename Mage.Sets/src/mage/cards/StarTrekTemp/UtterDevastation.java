

package mage.cards.u;

import java.util.UUID;
import mage.abilities.common.LegendarySpellAbility;
import mage.abilities.effects.common.DestroyAllEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SuperType;
import mage.filter.FilterPermanent;
import mage.filter.predicate.Predicates;

/**
 *
 * @author amcomeau
 */

public final class UtterDevastation extends CardImpl {

    private static final FilterCard filter = new FilterCard("creatures and Starships");
    static {
        filter.add(Predicates.or(CardType.CREATURE.getPredicate()));
        filter.add(Predicates.or(SubType.STARSHIP.getPredicate()));
    }

    public UtterDevastation(UUID ownerId, CardSetInfo setInfo){
        super(ownerId,setInfo,new CardType[]{CardType.SORCERY},"{2}{B}{B}{G}{G}");
        this.addSuperType(SuperType.LEGENDARY);

        // (You may cast a legendary sorcery only if you control a legendary creature or planeswalker.)
        this.addAbility(new LegendarySpellAbility());

        // Destroy all creatures and Starships. They can't be regenerated.
        this.getSpellAbility().addEffect(new DestroyAllEffect(filter, true));
    }

    private UtterDevastation(final UtterDevastation card) {
        super(card);
    }

    @Override
    public UtterDevastation copy() {
        return new UtterDevastation(this);
    }
}
