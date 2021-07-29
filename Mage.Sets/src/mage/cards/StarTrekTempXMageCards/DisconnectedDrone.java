
package mage.cards.d;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.keyword.DevoidAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;

/**
 *
 * @author amcomeau
 */

public final class DisconnectedDrone extends CardImpl {

    public DisconnectedDrone(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{1}{G}");
        this.subtype.add(SubType.BORG);
        this.subtype.add(SubType.DRONE);
        this.power = new MageInt(3);
        this.toughness = new MageInt(3);

        // Devoid
        this.addAbility(new DevoidAbility(this.color));
        
    }

    private DisconnectedDrone(final DisconnectedDrone card) {
        super(card);
    }

    @Override
    public DisconnectedDrone copy() {
        return new DisconnectedDrone(this);
    }
}
