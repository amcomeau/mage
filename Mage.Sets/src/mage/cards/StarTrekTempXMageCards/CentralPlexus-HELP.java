package mage.cards.c;

import mage.abilities.common.BeginningOfUpkeepTriggeredAbility;
import mage.abilities.condition.Condition;
import mage.abilities.condition.common.PermanentsOnTheBattlefieldCondition;
import mage.abilities.condition.common.FerociousCondition;
import mage.abilities.decorator.ConditionalInterveningIfTriggeredAbility;
import mage.abilities.effects.common.DrawCardSourceControllerEffect;
import mage.abilities.hint.common.FerociousHint;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.ComparisonType;
import mage.constants.SubType;
import mage.constants.Zone;
import mage.constants.TargetController;
import mage.filter.StaticFilters;
import mage.filter.common.FilterControlledCreaturePermanent;

import java.util.UUID;

/**
 * @author amcomeau
 */

public final class CentralPlexus extends CardImpl {

    private static final Condition condition = new PermanentsOnTheBattlefieldCondition(
            StaticFilters.FILTER_CONTROLLED_CREATURE, ComparisonType.MORE_THAN, 3

    public CentralPlexus(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.ENCHANTMENT}, "{2}{G}");

        // At the beginning of your upkeep, if you control 4 or more creatures or a creature with power 4 or greater, draw a card.
        this.addAbility(new ConditionalInterveningIfTriggeredAbility(
                new BeginningOfUpkeepTriggeredAbility(
				new DrawCardSourceControllerEffect(1),TargetController.YOU, false
			),
                FerociousCondition.instance,
                "At the beginning of your upkeep, "
                        + "if you control a creature with power 4 or greater, "
                        + "draw a card."
        ).addHint(FerociousHint.instance));
    }

    private CentralPlexus(final CentralPlexus card) {
        super(card);
    }

    @Override
    public CentralPlexus copy() {
        return new CentralPlexus(this);
    }
}
