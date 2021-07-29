
package mage.cards.c;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.BecomesExertSourceTriggeredAbility;
import mage.abilities.effects.common.AdditionalCombatPhaseEffect;
import mage.abilities.effects.common.UntapAllControllerEffect;
import mage.abilities.keyword.ExertAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.SuperType;
import mage.filter.common.FilterControlledCreaturePermanent;

/**
 *
 * @author amcomeau
 */
public final class CommanderShran extends CardImpl {

    public CommanderShran(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{4}{R}");

        this.supertype.add(SuperType.LEGENDARY);
        this.subtype.add(SubType.ANDORIAN);
        this.subtype.add(SubType.COMMANDER);
        this.power = new MageInt(6);
        this.toughness = new MageInt(4);

        // If Commander Shran hasn't been exerted this turn, you may exert it as it attacks. When you do, untap all other creatures you control and after this phase, there is an additional combat phase.
        BecomesExertSourceTriggeredAbility ability = new BecomesExertSourceTriggeredAbility(new UntapAllControllerEffect(new FilterControlledCreaturePermanent(), null, false));
        ability.addEffect(new AdditionalCombatPhaseEffect("and after this phase, there is an additional combat phase"));
        this.addAbility(new ExertAbility(ability, true));
    }

    private CommanderShran(final CommanderShran card) {
        super(card);
    }

    @Override
    public CommanderShran copy() {
        return new CommanderShran(this);
    }
}
