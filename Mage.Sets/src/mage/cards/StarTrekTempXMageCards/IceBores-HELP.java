package mage.cards.i;

import mage.MageInt;
import mage.abilities.TriggeredAbilityImpl;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.DamageTargetEffect;
import mage.abilities.costs.common.SacrificeSourceCost;
import mage.abilities.mana.SimpleManaAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.SuperType;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.target.targetpointer.FixedTarget;

import java.util.UUID;

/**
 * @author amcomeau
 */
public final class IceBores extends CardImpl {

    public IceBores(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{S}{R}");

        this.supertype.add(SuperType.SNOW);
        this.subtype.add(SubType.WORM);
        this.power = new MageInt(1);
        this.toughness = new MageInt(1);

        // Whenever Ice-Bores attacks, it deals 1 damage to the player or permanent it's attacking.
        this.addAbility(new IceBoresTriggeredAbility());

        // Sacrifice Ice-Bores: Add {R}.
        this.addAbility(new SimpleManaAbility(Zone.BATTLEFIELD, Mana.RedMana(1), new SacrificeSourceCost()));
    }

    private IceBores(final IceBores card) {
        super(card);
    }

    @Override
    public IceBores copy() {
        return new IceBores(this);
    }
}

class IceBoresTriggeredAbility extends TriggeredAbilityImpl {

    IceBoresTriggeredAbility() {
        super(Zone.BATTLEFIELD, null);
    }

    private IceBoresTriggeredAbility(final IceBoresTriggeredAbility ability) {
        super(ability);
    }

    @Override
    public IceBoresTriggeredAbility copy() {
        return new IceBoresTriggeredAbility(this);
    }

    @Override
    public boolean checkEventType(GameEvent event, Game game) {
        return event.getType() == GameEvent.EventType.ATTACKER_DECLARED;
    }

    @Override
    public boolean checkTrigger(GameEvent event, Game game) {
        if (this.getSourceId().equals(event.getSourceId())) {
            this.getEffects().clear();
            Effect effect = new DamageTargetEffect(1);
            effect.setTargetPointer(new FixedTarget(game.getCombat().getDefenderId(event.getSourceId()), game));
            this.addEffect(effect);
            return true;
        }
        return false;
    }

    @Override
    public String getRule() {
        return "Whenever {this} attacks, it deals 1 damage to the player or permanent it's attacking.";
    }
}
