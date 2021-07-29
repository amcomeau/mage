
package mage.cards.c;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.BeginningOfCombatTriggeredAbility;
import mage.abilities.effects.common.continuous.GainAbilityTargetEffect;
import mage.abilities.keyword.DevoidAbility;
import mage.abilities.keyword.TrampleAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.Duration;
import mage.constants.TargetController;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.filter.common.FilterControlledCreaturePermanent;
import mage.filter.predicate.mageobject.AnotherPredicate;
import mage.target.common.TargetControlledCreaturePermanent;

/**
 *
 * @author amcomeau
 */

public final class Crosis extends CardImpl {

    private static final FilterControlledCreaturePermanent filter = new FilterControlledCreaturePermanent("another target creature you control");

    static {
        filter.add(AnotherPredicate.instance);
    }

    public Crosis(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{2}{G}");
        this.addSuperType(SuperType.LEGENDARY);
        this.subtype.add(SubType.BORG);
        this.subtype.add(SubType.DRONE);
        this.power = new MageInt(2);
        this.toughness = new MageInt(3);

        // Devoid
        this.addAbility(new DevoidAbility(this.color));
        
        // At the beginning of combat on your turn, another target creature you control gets +1/+1 and gains trample until end of turn.
        Ability ability = new BeginningOfCombatTriggeredAbility(
			new GainAbilityTargetEffect(new TrampleAbility(), Duration.EndOfTurn), TargetController.YOU, false;
			effect = new BoostTargetEffect(1, 1, Duration.EndOfTurn)
	   );
        ability.addTarget(new TargetControlledCreaturePermanent(filter));
        this.addAbility(ability);

    }

    private Crosis(final Crosis card) {
        super(card);
    }

    @Override
    public Crosis copy() {
        return new Crosis(this);
    }
}
