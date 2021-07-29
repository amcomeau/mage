
package mage.cards.t;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.keyword.DevoidAbility;
import mage.abilities.keyword.MenaceAbility;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.continuous.BoostSourceEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Zone;

/**
 *
 * @author amcomeau
 */

public final class TacticalDrone extends CardImpl {

    public TacticalDrone(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{4}{B}");
        this.subtype.add(SubType.BORG);
        this.subtype.add(SubType.DRONE);
        this.power = new MageInt(4);
        this.toughness = new MageInt(4);

        // Devoid
        this.addAbility(new DevoidAbility(this.color));

        // Menace
        this.addAbility(new MenaceAbility());

        // {B}: Tactical Drone gets +1/+1 until end of turn.
        this.addAbility(new SimpleActivatedAbility(Zone.BATTLEFIELD,
                new BoostSourceEffect(1, 1, Duration.EndOfTurn), new ManaCostsImpl("{B}")));
    }

    private TacticalDrone(final TacticalDrone card) {
        super(card);
    }

    @Override
    public TacticalDrone copy() {
        return new TacticalDrone(this);
    }
}
