
package mage.cards.g;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.effects.common.CrewsStarshipSourceTriggeredAbility;
import mage.abilities.effects.common.continuous.GainAbilityTargetEffect;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.common.combat.CantBeBlockedTargetEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SuperType;
import mage.constants.SubType;
import mage.constants.Duration;
import mage.constants.Zone;
import mage.filter.common.FilterPermanent;
import mage.target.common.TargetPermanent;

/**
 *
 * @author amcomeau
 */
public final class Gareb extends CardImpl {

    private static final FilterPermanent filter1 = new FilterPermanent("Starship");

    static {
        filter1.add(SubType.STARSHIP.getPredicate());
    }

    public Gareb(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{1}{S}{W}");
        this.supertype.add(SuperType.LEGENDARY);
        this.supertype.add(SuperType.SNOW);
        this.subtype.add(SubType.AENAR);
        this.subtype.add(SubType.PILOT);
        this.power = new MageInt(2);
        this.toughness = new MageInt(4);

        // Whenever Gareb crews a Starship, that Starship can't be blocked this turn.
        this.addAbility(new CrewsStarshipSourceTriggeredAbility(new SimpleActivatedAbility(Zone.BATTLEFIELD, new CantBeBlockedTargetEffect()));
        ability.addTarget(new TargetPermanent(filter1));
        this.addAbility(ability);
    }

    private Gareb(final Gareb card) {
        super(card);
    }

    @Override
    public Gareb copy() {
        return new Gareb(this);
    }
}
