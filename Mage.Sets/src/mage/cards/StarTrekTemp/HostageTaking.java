
package mage.cards.h;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.TapTargetCost;
import mage.abilities.effects.common.TapTargetEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Zone;
import mage.filter.FilterPermanent;
import mage.filter.common.FilterControlledCreaturePermanent;
import mage.filter.predicate.Predicates;
import mage.filter.predicate.permanent.TappedPredicate;
import mage.target.TargetPermanent;
import mage.target.common.TargetControlledCreaturePermanent;

/**
 *
 * @author amcomeau
 */
public final class HostageTaking extends CardImpl {

    private static final FilterControlledCreaturePermanent filterCost = new FilterControlledCreaturePermanent("untapped creature you control");
    private static final FilterPermanent filterTarget = new FilterPermanent("artifact or creature");

    static {
        filterCost.add(Predicates.not(TappedPredicate.instance));
        filterTarget.add(Predicates.or(
                CardType.ARTIFACT.getPredicate(),
                CardType.CREATURE.getPredicate()));
    }

    public HostageTaking(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.ENCHANTMENT},"{2}{B}{B}");


        // Tap an untapped creature you control: Tap target artifact or creature.
        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new TapTargetEffect(), new TapTargetCost(new TargetControlledCreaturePermanent(1, 1, filterCost, true)));
        ability.addTarget(new TargetPermanent(filterTarget));
        this.addAbility(ability);
    }

    private HostageTaking(final HostageTaking card) {
        super(card);
    }

    @Override
    public HostageTaking copy() {
        return new HostageTaking(this);
    }
}
