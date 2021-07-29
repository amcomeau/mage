
package mage.cards.a;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.BecomesExertSourceTriggeredAbility;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.continuous.BoostSourceEffect;
import mage.abilities.effects.common.continuous.GainAbilitySourceEffect;
import mage.abilities.keyword.ExertAbility;
import mage.abilities.keyword.MenaceAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Duration;

/**
 *
 * @author amcomeau
 */
public final class AndorianCommando extends CardImpl {

    public AndorianCommando(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{3}{R}");

        this.subtype.add(SubType.ANDORIAN);
        this.subtype.add(SubType.SOLDIER);
        this.power = new MageInt(4);
        this.toughness = new MageInt(3);

        // You may exert Andorian Commandos as it attacks. When you do, it gets +1/+1 and gains menace until end of turn.
        Effect effect = new BoostSourceEffect(1, 1, Duration.EndOfTurn);
        effect.setText("it gets +1/+1");
        BecomesExertSourceTriggeredAbility ability = new BecomesExertSourceTriggeredAbility(effect);
        effect = new GainAbilitySourceEffect(new MenaceAbility(), Duration.EndOfTurn);
        effect.setText("and gains menace until end of turn");
        ability.addEffect(effect);
        this.addAbility(new ExertAbility(ability));
    }

    private AndorianCommando(final AndorianCommando card) {
        super(card);
    }

    @Override
    public AndorianCommando copy() {
        return new AndorianCommando(this);
    }
}
