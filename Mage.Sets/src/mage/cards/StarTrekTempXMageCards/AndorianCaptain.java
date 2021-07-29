
package mage.cards.a;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.common.BecomesExertSourceTriggeredAbility;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.continuous.AddCardTypeTargetEffect;
import mage.abilities.keyword.ExertAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.SubType;
import mage.target.common.TargetCreaturePermanent;
import mage.filter.common.FilterControlledArtifactPermanent;
import mage.filter.predicate.mageobject.AnotherPredicate;
import mage.target.common.TargetControlledPermanent;

/**
 *
 * @author amcomeau
 */

public final class AndorianCaptain extends CardImpl {

    private static final FilterControlledArtifactPermanent filter = new FilterControlledArtifactPermanent("another target Starship");

    static {
        filter.add(AnotherPredicate.instance);
        filter.add(SubType.STARSHIP.getPredicate());
    }

    public AndorianCaptain(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{2}{R}");

        this.subtype.add(SubType.ANDORIAN);
        this.subtype.add(SubType.CAPTAIN);
        this.power = new MageInt(3);
        this.toughness = new MageInt(2);

        // You may exert Andorian Captain as it attacks. When you do, target Starship you control becomes a creature in addition to its other types until end of turn.
        BecomesExertSourceTriggeredAbility ability = new BecomesExertSourceTriggeredAbility(new SimpleActivatedAbility(Zone.BATTLEFIELD, effect));
        this.addAbility(new ExertAbility(ability));
        Effect effect = new AddCardTypeTargetEffect(Duration.EndOfTurn, CardType.CREATURE);
        ability.addTarget(new FilterControlledArtifactPermanent(filter));
        this.addAbility(ability);
    }

    private AndorianCaptain(final AndorianCaptain card) {
        super(card);
    }

    @Override
    public AndorianCaptain copy() {
        return new AndorianCaptain(this);
    }
}
