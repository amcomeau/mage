package mage.cards.u;

import mage.abilities.condition.CompoundCondition;
import mage.abilities.condition.Condition;
import mage.abilities.Ability;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.common.PreventAllDamageToAllEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Zone;
import mage.filter.common.FilterControlledCreaturePermanent;
import mage.filter.FilterPermanent;
import mage.filter.StaticFilters;

import java.util.UUID;

/**
 * @author amcomeau
 */
public final class UselessShot extends CardImpl {

    public UselessShot(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.INSTANT}, "{1}{G}");

        // Prevent all combat damage that would be dealt to creatures you control this turn.
        this.getSpellAbility().addEffect(new PreventAllDamageToAllEffect(Duration.EndOfTurn, StaticFilters.FILTER_PERMANENT_CREATURES_CONTROLLED));

    }

    private UselessShot(final UselessShot card) {
        super(card);
    }

    @Override
    public UselessShot copy() {
        return new UselessShot(this);
    }
}
