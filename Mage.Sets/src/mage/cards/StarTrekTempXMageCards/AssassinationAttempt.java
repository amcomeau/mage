package mage.cards.a;

import java.util.UUID;
import mage.abilities.costs.common.SacrificeTargetCost;
import mage.abilities.dynamicvalue.common.SacrificeCostCreaturesPower;
import mage.abilities.effects.common.DamageTargetEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import static mage.filter.StaticFilters.FILTER_CONTROLLED_CREATURE_SHORT_TEXT;
import mage.target.common.TargetAnyTarget;
import mage.target.common.TargetControlledCreaturePermanent;

/**
 *
 * @author amcomeau
 */
public final class AssassinationAttempt extends CardImpl {

    public AssassinationAttempt(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.SORCERY}, "{R}");

        // As an additional cost to cast this spell, sacrifice a creature.
        this.getSpellAbility().addCost(new SacrificeTargetCost(
                new TargetControlledCreaturePermanent(FILTER_CONTROLLED_CREATURE_SHORT_TEXT)
        ));

        // Assassination Attempt deals damage equal to the sacrificed creature's power to any target.
        this.getSpellAbility().addEffect(new DamageTargetEffect(SacrificeCostCreaturesPower.instance));
        this.getSpellAbility().addTarget(new TargetAnyTarget());
    }

    private AssassinationAttempt(final AssassinationAttempt card) {
        super(card);
    }

    @Override
    public AssassinationAttempt copy() {
        return new AssassinationAttempt(this);
    }
}
