
package mage.cards.l;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.effects.OneShotEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.filter.common.FilterControlledCreaturePermanent;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.other.AnotherTargetPredicate;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.target.common.TargetControlledCreaturePermanent;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 *
 * As Fall of the Hammer tries to resolve, if only one of the targets is legal,
 * Fall of the Hammer will still resolve but will have no effect: If the first
 * target creature is illegal, it can't deal damage to anything. If the second
 * target creature is illegal, it can't be dealt damage.
 *
 * The amount of damage dealt is based on the first target creature's power as Fall of the Hammer resolves.


 * @author amcomeau
 */
public final class LovedOneAvenged extends CardImpl {

    public LovedOneAvenged(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.INSTANT},"{1}{R}");


        // Target creature you control deals damage equal to twice its power to another target creature.
        this.getSpellAbility().addEffect(new LovedOneAvengedDamageEffect());
        TargetControlledCreaturePermanent target = 
                new TargetControlledCreaturePermanent(new FilterControlledCreaturePermanent("Target creature: deals damage"));
        target.setTargetTag(1);
        this.getSpellAbility().addTarget(target);
        
        FilterCreaturePermanent filter = new FilterCreaturePermanent("Another creature: damage dealt to");
        filter.add(new AnotherTargetPredicate(2));
        TargetCreaturePermanent target2 = new TargetCreaturePermanent(filter);
        target2.setTargetTag(2);
        this.getSpellAbility().addTarget(target2);

        // Cast this spell only if a creature you control died this turn.
        ??????

    }

    private LovedOneAvenged(final LovedOneAvenged card) {
        super(card);
    }

    @Override
    public LovedOneAvenged copy() {
        return new LovedOneAvenged(this);
    }
}

class LovedOneAvengedDamageEffect extends OneShotEffect {

    public LovedOneAvengedDamageEffect() {
        super(Outcome.Damage);
        this.staticText = "Target creature you control deals damage equal to twice its power to another target creature";
    }

    public LovedOneAvengedDamageEffect(final LovedOneAvengedDamageEffect effect) {
        super(effect);
    }

    @Override
    public LovedOneAvengedDamageEffect copy() {
        return new LovedOneAvengedDamageEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Permanent ownCreature = game.getPermanent(source.getFirstTarget());
        if (ownCreature != null) {
            int damage = ownCreature.getPower().getValue();
            Permanent targetCreature = game.getPermanent(source.getTargets().get(1).getFirstTarget());
            if (targetCreature != null) {
                targetCreature.damage(damage, ownCreature.getId(), source, game, false, true);
                return true;
            }
        }
        return false;
    }
}
