
package mage.cards.a;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.BlocksOrBecomesBlockedSourceTriggeredAbility;
import mage.abilities.common.delayed.AtTheEndOfCombatDelayedTriggeredAbility;
import mage.abilities.effects.common.continuous.BecomesCreatureTypeTargetEffect;
import mage.abilities.effects.common.continuous.GainAbilityTargetEffect;
import mage.abilities.effects.common.continuous.GainControlTargetEffect;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.CreateDelayedTriggeredAbilityEffect;
import mage.abilities.keyword.DevoidAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.Predicates;
import mage.target.TargetPermanent;

/**
 *
 * @author amcomeau
 */

public final class AssimilationDrone extends CardImpl {

    private static final FilterPermanent filter = new FilterCreaturePermanent("nonartifact creature");

    static {
        filter.add(Predicates.not(CardType.ARTIFACT.getPredicate()));
    }
    public AssimilationDrone(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{4}{B}{B}");
        this.subtype.add(SubType.BORG);
        this.subtype.add(SubType.DRONE);
        this.power = new MageInt(3);
        this.toughness = new MageInt(3);

        // Devoid
        this.addAbility(new DevoidAbility(this.color));
        
        // Whenever Assimilation Drone blocks or becomes blocked by a nonartifact creature, assimilate that creature at the end of combat.
        Effect effect = new CreateDelayedTriggeredAbilityEffect(new AtTheEndOfCombatDelayedTriggeredAbility(new GainControlTargetEffect(Duration.Custom, true)), true);
        this.addAbility(new BlocksOrBecomesBlockedSourceTriggeredAbility(effect, filter, false));
        this.addEffect(new GainAbilityTargetEffect(DevoidAbility.getInstance()));
        this.addEffect(new BecomesCreatureTypeTargetEffect(Duration.WhileOnBattlefield, SubType.BORG, SubType.DRONE, false);

    }

    private AssimilationDrone(final AssimilationDrone card) {
        super(card);
    }

    @Override
    public AssimilationDrone copy() {
        return new AssimilationDrone(this);
    }
}
