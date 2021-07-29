package mage.cards.m;

import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.SacrificeSourceCost;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.turn.ControlTargetPlayerNextTurnEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SuperType;
import mage.constants.Zone;
import mage.target.TargetPlayer;

import java.util.UUID;

/**
 * @author nantuko
 */
public final class Mindslaver extends CardImpl {

    public Mindslaver(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.ARTIFACT}, "{4}{B}{B}");
        addSuperType(SuperType.LEGENDARY);

        // {2}{S}{S}, {T}, Sacrifice Mindslaver: You control target player during that player's next turn.
        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new ControlTargetPlayerNextTurnEffect(), new ManaCostsImpl("{2}{S}{S}"));
        ability.addCost(new TapSourceCost());
        ability.addCost(new SacrificeSourceCost());
        ability.addTarget(new TargetPlayer());
        this.addAbility(ability);
    }

    private Mindslaver(final Mindslaver card) {
        super(card);
    }

    @Override
    public Mindslaver copy() {
        return new Mindslaver(this);
    }
}
