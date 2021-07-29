
package mage.cards.u;

import java.util.UUID;
import mage.abilities.effects.common.search.SearchLibraryPutInHandEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.filter.FilterCard;
import mage.target.common.TargetCardInLibrary;

/**
 *
 * @author jonubuu
 */
public final class UshaanPreparations extends CardImpl {

    private static final FilterCard filter = new FilterCard("Equipment card");

    static {
        filter.add(CardType.ARTIFACT.getPredicate());
        filter.add(SubType.EQUIPMENT.getPredicate());
    }

    public UshaanPreparations(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.SORCERY},"{W}");


        // Search your library for an Equipment card, reveal that card, and put it into your hand. Then shuffle your library.
        this.getSpellAbility().addEffect(new SearchLibraryPutInHandEffect(new TargetCardInLibrary(filter), true));
    }

    private UshaanPreparations(final UshaanPreparations card) {
        super(card);
    }

    @Override
    public UshaanPreparations copy() {
        return new UshaanPreparations(this);
    }
}
