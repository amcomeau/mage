
package mage.cards.m;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.keyword.DevoidAbility;
import mage.abilities.keyword.MenaceAbility;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.SacrificeTargetCost;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.effects.common.GainLifeEffect;
import mage.abilities.effects.common.continuous.GainAbilityControlledEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Zone;
import mage.filter.common.FilterControlledCreaturePermanent;
import mage.target.common.TargetControlledCreaturePermanent;

/**
 *
 * @author amcomeau
 */

public final class MaintenanceDrone extends CardImpl {

    private static final FilterControlledCreaturePermanent filter = new FilterControlledCreaturePermanent("Borg");

    static {
        filter.add(SubType.BORG.getPredicate());
    }

    public MaintenanceDrone(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{2}{B}{G}");
        this.subtype.add(SubType.BORG);
        this.subtype.add(SubType.DRONE);
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);

        // Devoid
        this.addAbility(new DevoidAbility(this.color));
        
        // {T}: You gain 1 life.
        this.addAbility(new SimpleActivatedAbility(Zone.BATTLEFIELD, new GainLifeEffect(1), new TapSourceCost()));

        // Sacrifice a Borg: Borg creatures you control gain menace until end of turn.
        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new GainAbilityControlledEffect(MenaceAbility.getInstance(), Duration.EndOfTurn, filter, false);
        ability.addCost(new SacrificeTargetCost(new TargetControlledCreaturePermanent(1, 1, filter, true)));
        this.addAbility(ability);

    }

    private MaintenanceDrone(final MaintenanceDrone card) {
        super(card);
    }

    @Override
    public MaintenanceDrone copy() {
        return new MaintenanceDrone(this);
    }
}
