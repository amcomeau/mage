
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

public final class BorgCube extends CardImpl {

    public BorgCube(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.ARTIFACT},"{5}");
        this.subtype.add(SubType.STARSHIP);
        this.power = new MageInt(7);
        this.toughness = new MageInt(7);

        // {5}: Regenerate Borg Cube.
        this.addAbility(new SimpleActivatedAbility(Zone.BATTLEFIELD, new RegenerateSourceEffect(), new ManaCostsImpl("{5}")));

        // Crew 4
        this.addAbility(new CrewAbility(4));
    }

    private BorgCube(final BorgCube card) {
        super(card);
    }

    @Override
    public BorgCube copy() {
        return new BorgCube(this);
    }
}
