package mage.cards.s;

import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.SacrificeSourceCost;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.costs.mana.GenericManaCost;
import mage.abilities.effects.common.DamageTargetEffect;
import mage.abilities.keyword.FlashAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.target.common.TargetAnyTarget;

import java.util.UUID;

/**
 * @author amcomeau
 */
public final class StolenPrototype extends CardImpl {

    public StolenPrototype(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.ARTIFACT}, "{1}");

        // Flash
        this.addAbility(FlashAbility.getInstance());

        // {4}, {T}, Sacrifice Stolen Prototype: It deals 3 damage to any target.
        Ability ability = new SimpleActivatedAbility(
                new DamageTargetEffect(3, "it"), new GenericManaCost(4)
        );
        ability.addCost(new TapSourceCost());
        ability.addCost(new SacrificeSourceCost());
        ability.addTarget(new TargetAnyTarget());
        this.addAbility(ability);
    }

    private StolenPrototype(final StolenPrototype card) {
        super(card);
    }

    @Override
    public StolenPrototype copy() {
        return new StolenPrototype(this);
    }
}
