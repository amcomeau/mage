
package mage.cards.r;

import mage.abilities.Ability;
import mage.abilities.common.DealsCombatDamageToAPlayerTriggeredAbility;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.DrawCardSourceControllerEffect;
import mage.abilities.effects.common.combat.CantBeBlockedTargetEffect;
import mage.abilities.effects.common.continuous.GainAbilityTargetEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.game.Game;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.Predicates;
import mage.target.TargetCreaturePermanent;
import mage.target.common.TargetCreaturePermanent;
import mage.target.targetadjustment.TargetAdjuster;

import java.util.UUID;

/**
 * @author amcomeau
 */
public final class RevealThePath extends CardImpl {

    private static final FilterCreaturePermanent filter = new FilterCreaturePermanent("non-Starship creature");

    static {
        filter.add(Predicates.not(CardType.STARSHIP.getPredicate()));
    }

    public RevealThePath(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.SORCERY}, "{X}{S}{U}");
        this.supertype.add(SuperType.SNOW);

        // X target non-Starship creatures can't be blocked this turn. Until end of turn, those creatures gain "Whenever this creature deals combat damage to a player, draw a card."
        Effect effect = new CantBeBlockedTargetEffect(Duration.EndOfTurn);
        effect.setText("X target creatures can't be blocked this turn");
        this.getSpellAbility().addEffect(effect);
        Ability abilityToGain = new DealsCombatDamageToAPlayerTriggeredAbility(new DrawCardSourceControllerEffect(1), false);
        this.getSpellAbility().addEffect(new GainAbilityTargetEffect(abilityToGain, Duration.EndOfTurn,
                "Until end of turn, those creatures gain \"Whenever this creature deals combat damage to a player, draw a card.\""));
        this.getSpellAbility().setTargetAdjuster(RevealThePathAdjuster.instance);
    }

    private RevealThePath(final RevealThePath card) {
        super(card);
    }

    @Override
    public RevealThePath copy() {
        return new RevealThePath(this);
    }
}

enum RevealThePathAdjuster implements TargetAdjuster {
    instance;

    @Override
    public void adjustTargets(Ability ability, Game game) {
        ability.getTargets().clear();
        ability.addTarget(new TargetCreaturePermanent(ability.getManaCostsToPay().getX()));
    }
}