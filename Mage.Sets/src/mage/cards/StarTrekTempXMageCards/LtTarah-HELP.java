
package mage.cards.l;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.AttacksEachCombatStaticAbility;
import mage.abilities.common.BecomesExertSourceTriggeredAbility;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.DamageTargetEffect;
import mage.abilities.keyword.ExertAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.SubType;
import mage.filter.FilterPermanent;
import mage.filter.common.FilterControlledPermanent;
import mage.target.common.TargetAnyTarget;

/**
 *
 * @author amcomeau
 */
public final class LtTarah extends CardImpl {

    private static final FilterPermanent filter = new FilterControlledPermanent(SubType.ANDORIAN);

    public LtTarah(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{2}{R}{R}");

        this.subtype.add(SubType.ANDORIAN);
        this.subtype.add(SubType.SOLDIER);
        this.power = new MageInt(4);
        this.toughness = new MageInt(4);

        // Lt. Tarah attacks each combat if able.
        this.addAbility(new AttacksEachCombatStaticAbility());

        // You may exert Lt. Tarah as it attacks. When you do, it deals 2 damage to target player or permanent.
        BecomesExertSourceTriggeredAbility ability = new BecomesExertSourceTriggeredAbility(effect);
        effect = new DamageTargetEffect(2, "it");
        ability.addTarget(new TargetAnyTarget());
        this.addAbility(ability);
    }

    private LtTarah(final LtTarah card) {
        super(card);
    }

    @Override
    public LtTarah copy() {
        return new LtTarah(this);
    }
}
