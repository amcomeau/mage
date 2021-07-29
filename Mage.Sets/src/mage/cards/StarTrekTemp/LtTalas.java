
package mage.cards.l;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.BecomesExertSourceTriggeredAbility;
import mage.abilities.common.DiesSourceTriggeredAbility;
import mage.abilities.effects.common.counter.AddCountersTargetEffect;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.continuous.BoostSourceEffect;
import mage.abilities.effects.common.continuous.GainAbilitySourceEffect;
import mage.abilities.keyword.DoubleStrikeAbility;
import mage.abilities.keyword.ExertAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.counters.Counter;
import mage.counters.CounterType;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.SubType;
import mage.filter.FilterPermanent;
import mage.filter.common.FilterControlledPermanent;
import mage.target.TargetPermanent;

/**
 *
 * @author amcomeau
 */
public final class LtTalas extends CardImpl {

    private static final FilterPermanent filter = new FilterControlledPermanent(SubType.ANDORIAN);

    public LtTalas(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{3}{R}");

        this.subtype.add(SubType.ANDORIAN);
        this.subtype.add(SubType.SOLDIER);
        this.power = new MageInt(4);
        this.toughness = new MageInt(4);

        // You may exert Lt. Talas as it attacks. When you do, it gets double strike until end of turn.
        BecomesExertSourceTriggeredAbility ability = new BecomesExertSourceTriggeredAbility(effect);
        effect = new GainAbilitySourceEffect(DoubleStrikeAbility.getInstance(), Duration.EndOfTurn);
        effect.setText("gains double strike until end of turn");
        ability.addEffect(effect);
        this.addAbility(new ExertAbility(ability));

        // When Lt. Talas dies, put a menace counter on target Andorian you control.
        Ability ability = new DiesSourceTriggeredAbility(new AddCountersTargetEffect(CounterType.MENACE.createInstance()));
        ability.addTarget(new TargetPermanent(filter));
        this.addAbility(ability);

    }

    private LtTalas(final LtTalas card) {
        super(card);
    }

    @Override
    public LtTalas copy() {
        return new LtTalas(this);
    }
}
