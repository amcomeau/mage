
package mage.cards.u;

import java.util.UUID;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.DamageTargetControllerEffect;
import mage.abilities.effects.common.counter.AddCountersTargetEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.counters.CounterType;
import mage.target.common.TargetCreaturePermanent;
import mage.filter.predicate.Predicates;
import mage.target.TargetCreaturePermanent;

/**
 *
 * @author amcomeau
 */
public final class Ushaan extends CardImpl {

    private static final TargetControlledPermanent filter = new TargetControlledPermanent("untapped non-Starship creature");
    private static final TargetCreaturePermanent filter2 = new TargetCreaturePermanent("non-Starship creature");

    static {
        filter.add(Predicates.not(TappedPredicate.instance));
        filter.add(Predicates.not(CardType.STARSHIP.getPredicate()));
        filter2.add(Predicates.not(CardType.STARSHIP.getPredicate()));
    }

    public Ushaan(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.INSTANT}, "{R}");
        
        // As an additional cost to cast this spell, tap an untapped non-Starship creature you control.
        this.getSpellAbility().addCost(new TapTargetCost(new TargetControlledPermanent(filter)));

        // Put a -1/-1 counter on target non-Starship creature. Ushaan deals 2 damage to that creature's controller.
        getSpellAbility().addEffect(new AddCountersTargetEffect(CounterType.M1M1.createInstance(1)));
        Effect effect = new DamageTargetControllerEffect(2);
        effect.setText("{this} deals 2 damage to that creature's controller");
        getSpellAbility().addEffect(effect);
        getSpellAbility().addTarget(new TargetCreaturePermanent(filter2));
        
    }

    private Ushaan(final Ushaan card) {
        super(card);
    }

    @Override
    public Ushaan copy() {
        return new Ushaan(this);
    }
}
