
package mage.cards.b;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.keyword.CrewAbility;
import mage.abilities.effects.common.RegenerateSourceEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Zone;

/**
 *
 * @author amcomeau
 */

public final class BorgTacticalCube extends CardImpl {

    public BorgTacticalCube(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.ARTIFACT},"{7}");
        this.subtype.add(SubType.STARSHIP);
        this.power = new MageInt(10);
        this.toughness = new MageInt(10);

        // {5}: Regenerate Borg Tactical Cube.
        this.addAbility(new SimpleActivatedAbility(Zone.BATTLEFIELD, new RegenerateSourceEffect(), new ManaCostsImpl("{7}")));

        // Crew 5
        this.addAbility(new CrewAbility(5));
    }

    private BorgTacticalCube(final BorgTacticalCube card) {
        super(card);
    }

    @Override
    public BorgTacticalCube copy() {
        return new BorgTacticalCube(this);
    }
}
