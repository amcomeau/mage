
package mage.cards.n;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.keyword.DevoidAbility;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.SacrificeTargetCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.DrawCardSourceControllerEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Zone;
import static mage.filter.StaticFilters.FILTER_CONTROLLED_CREATURE_SHORT_TEXT;
import mage.target.common.TargetControlledCreaturePermanent;

/**
 *
 * @author amcomeau
 */

public final class NeedleFingersAndBill extends CardImpl {

    public NeedleFingersAndBill(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{2}{B}");
        this.addSuperType(SuperType.LEGENDARY);
        this.subtype.add(SubType.BORG);
        this.subtype.add(SubType.DRONE);
        this.power = new MageInt(2);
        this.toughness = new MageInt(3);

        // Devoid
        this.addAbility(new DevoidAbility(this.color));

	   // {2}{B}, Sacrifice a creature: Draw a card.
        SimpleActivatedAbility ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new DrawCardSourceControllerEffect(1), new ManaCostsImpl("{2}{B}")));
        ability.addCost(new SacrificeTargetCost(new TargetControlledCreaturePermanent(FILTER_CONTROLLED_CREATURE_SHORT_TEXT)));
        this.addAbility(ability);
    }

    private NeedleFingersAndBill(final NeedleFingersAndBill card) {
        super(card);
    }

    @Override
    public NeedleFingersAndBill copy() {
        return new NeedleFingersAndBill(this);
    }
}
